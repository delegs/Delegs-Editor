package de.signWritingEditor.server.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.service.SignPuddleXmlParser.SignPuddleEntry;

interface SignPuddleRepairStrategy {
	/**
	 * @return null for dismissed words
	 */
	String repairWord(String word, SignPuddleEntry signPuddleEntry);
}

enum KeepEveryWordUnchanged implements SignPuddleRepairStrategy {
	INSTANCE;

	@Override
	public String repairWord(String word, SignPuddleEntry signPuddleEntry) {
		return word;
	}
}

/**
 * NOTE: This class contains a heavily memory-optimized custom hash table. This
 * reduces the memory overhead by an order of magnitude and solves an annoying
 * OutOfMemoryError that plagued the memory-constrained production environment.
 */
public class RepairSwissWords implements SignPuddleRepairStrategy {
	private static final Logger LOGGER = Logger.getLogger(RepairSwissWords.class);

	private static final String ESF_WAR_PATH = "esf.war.path";
	private static final String GERMAN_DIC = "german.dic";

	// must be a power of 2, bigger than the number of words in german.dic
	private static final int CAPACITY = 1 << 19;
	private static final int AVAILABLE = -1;
	private static final int GOLDEN_RATIO = 0x9E3779B9;
	private static final int MASK = CAPACITY - 1;

	// the verbatim content of german.dic in memory
	private final byte[] bytes;
	// the hash table stores strings as offsets into the bytes array
	private final int[] offsets;

	public RepairSwissWords() throws IOException {
		this(new ConfigurationService().getProperty(ESF_WAR_PATH));
	}

	private RepairSwissWords(String warPath) throws IOException {
		LOGGER.info("warPath: " + warPath);

		bytes = Files.readAllBytes(Paths.get(warPath + GERMAN_DIC));
		offsets = new int[CAPACITY];
		Arrays.fill(offsets, AVAILABLE);

		// prepare first word
		int start = 0;
		int hash = 0;

		for (int i = 0; i < bytes.length; ++i) {
			byte b = bytes[i];
			if (b >= 32) {
				// only ASCII characters influence the hash code
				hash = hash * GOLDEN_RATIO + toLowerCase(b);
			} else if (bytes[i] == '\n') {
				// word complete, find next available slot (linear probing)
				while (offsets[hash &= MASK] != AVAILABLE) {
					++hash;
				}
				offsets[hash] = start;

				// prepare next word
				start = i + 1;
				hash = 0;
			}
		}
	}

	private static char toLowerCase(byte b) {
		// casting to char would sign-extend the byte,
		// but we want zero-extension, hence the bitwise-and
		return Character.toLowerCase((char) (b & 255));
	}

	private int asciiHash(String word) {
		int hash = 0;
		for (int i = 0; i < word.length(); ++i) {
			byte b = (byte) word.charAt(i);
			if (b >= 32) {
				// only ASCII characters influence the hash code
				hash = hash * GOLDEN_RATIO + toLowerCase(b);
			}
		}
		return hash;
	}

	private boolean asciiEquals(String word, int offset) {
		for (int i = 0; i < word.length(); ++i, ++offset) {
			// skip non-ASCII characters
			while (bytes[offset] < 0) {
				++offset;
			}
			// compare case-insensitive
			if (Character.toLowerCase(word.charAt(i)) != toLowerCase(bytes[offset])) {
				return false;
			}
		}
		// skip non-ASCII characters
		while (bytes[offset] < 0) {
			++offset;
		}
		byte b = bytes[offset];
		return b == '\r' || b == '\n';
	}

	private int length(int offset) {
		for (int i = offset; i < bytes.length; ++i) {
			byte b = bytes[i];
			if (b == '\r' || b == '\n') {
				return i - offset;
			}
		}
		return bytes.length - offset;
	}

	private List<String> findAlternativesFor(String word) {
		List<String> alternatives = new ArrayList<String>(1);
		int hash = asciiHash(word);
		int offset;
		while ((offset = offsets[hash &= MASK]) != AVAILABLE) {
			if (asciiEquals(word, offset)) {
				alternatives.add(new String(bytes, offset, length(offset), StandardCharsets.ISO_8859_1));
			}
			++hash;
		}
		return alternatives;
	}

	@Override
	public String repairWord(String word, SignPuddleEntry signPuddleEntry) {
		// Bindestriche am Ende entfernen
		Matcher matcher = TRAILING_HYPHENS.matcher(word);
		if (matcher.matches()) {
			word = matcher.group(1);
		}
		// Wörter der Form S1-... ignorieren
		if (IGNORE.matcher(word).matches()) {
			return null;
		}
		// Sinnlose Suffixe hinter Wort entfernen
		matcher = KEEP_FRONT_BEFORE_DIGITS.matcher(word);
		if (matcher.matches()) {
			word = matcher.group(1);
		}
		matcher = KEEP_FRONT_BEFORE_LETTERS.matcher(word);
		if (matcher.matches()) {
			word = matcher.group(1);
		}
		// "-int" aus dem Wort entfernen
		matcher = INTERNATIONAL.matcher(word);
		if (matcher.matches()) {
			word = matcher.group(1);
		}
		// Unbekannte Wörter durch Hinzufügen von Umlauten fixen
		List<String> alternatives = findAlternativesFor(word);
		if (!alternatives.isEmpty()) {
			if (alternatives.size() == 1) {
				String repaired = alternatives.get(0);
				if (Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(repaired.charAt(0))) {
					repaired = Character.toLowerCase(repaired.charAt(0)) + repaired.substring(1);
				} else if (Character.isUpperCase(word.charAt(0)) && Character.isLowerCase(repaired.charAt(0))) {
					repaired = Character.toUpperCase(repaired.charAt(0)) + repaired.substring(1);
				}
				LOGGER.info(word + " wurde automatisch zu " + repaired + " repariert");
				word = repaired;
			} else {
				word = pickFittingWordFromTextTag(signPuddleEntry, word, alternatives);
			}
		} else {
			LOGGER.info(word + " wird unverändert übernommen");
		}
		return word;
	}

	private static final Pattern TRAILING_HYPHENS = Pattern.compile("([^-]+)-+");

	private static final Pattern IGNORE = Pattern.compile("S\\d-.+");

	private static final String ONE_OR_MORE_WORDS_SEPARATED_BY_HYPHENS = "([A-Za-z]+(?:-[A-Za-z]+)*)";

	private static final Pattern KEEP_FRONT_BEFORE_DIGITS = Pattern
			.compile(ONE_OR_MORE_WORDS_SEPARATED_BY_HYPHENS + "-\\d+.*");

	private static final Pattern KEEP_FRONT_BEFORE_LETTERS = Pattern
			.compile(ONE_OR_MORE_WORDS_SEPARATED_BY_HYPHENS + "-([A-Za-z]([^A-Za-z].*)?)");

	private static final Pattern INTERNATIONAL = Pattern.compile("(.+)-int");

	// der Inhalt aus dem Tag <Text> wird mit der Liste "mitUmlauten"
	// verglichen, um evtl. den richtigen Eintrag aus der Liste zu wählen
	private String pickFittingWordFromTextTag(SignPuddleEntry signPuddleEntry, String word, List<String> mitUmlauten) {
		String signPuddleText = signPuddleEntry.getText();

		if (signPuddleText != null) {
			String[] alternatives = signPuddleText.split("\\s*,\\s*");
			for (String alternative : alternatives) {
				for (String mitUmlaut : mitUmlauten) {
					if (alternative.equals(mitUmlaut)) {
						LOGGER.info(word + " wurde automatisch zu " + mitUmlaut + " repariert");
						return mitUmlaut;
					}
				}
			}
		}
		LOGGER.info(word + " hat mehrere Alternativen: " + mitUmlauten);
		return word;
	}

	// use jvisualvm to compare the memory overhead of different approaches
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Press ENTER to start... ");
		in.readLine();

		RepairSwissWords repair = new RepairSwissWords("war/");

		System.out.print("Press ENTER to stop... ");
		in.readLine();

		int memory = repair.bytes.length + repair.offsets.length * 4;
		System.out.println(memory / 1000 + " kb");
	}
}
