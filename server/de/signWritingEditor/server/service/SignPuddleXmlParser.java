package de.signWritingEditor.server.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import de.signWritingEditor.shared.infrastructure.IswaBswConverter;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;

public class SignPuddleXmlParser {

	private static final String SYMBOL_EXPRESSION = "S[0-9a-f]{5}";
	private static final String COORDINATE_EXPRESSION = "\\d{1,4}x\\d{1,4}";
	private static final Pattern COORDINATE_PATTERN = Pattern.compile(COORDINATE_EXPRESSION);
	private static final Pattern SYMBOL_PATTERN = Pattern.compile(SYMBOL_EXPRESSION);
	private static final Pattern SIGN_ENTRY_PATTERN = Pattern.compile("(A(" + SYMBOL_EXPRESSION + ")+)?(M"
			+ COORDINATE_EXPRESSION + ")?(" + SYMBOL_EXPRESSION + COORDINATE_EXPRESSION + ")+");

	private static final Logger LOGGER = Logger.getLogger(SignPuddleXmlParser.class);

	private final SymbolFactory symbolFactory;
	private final IswaBswConverter iswaBswConverter;

	public SignPuddleXmlParser(SymbolFactory symbolFactory) {
		this.symbolFactory = symbolFactory;
		this.iswaBswConverter = new IswaBswConverter();
	}

	public List<DictionaryEntry> parsePuddleXml(String puddleXml, SignLocale language,
			SignPuddleRepairStrategy repairStrategy) throws JDOMException, IOException {
		assert puddleXml != null : "Precondition failed: puddleXml != null";
		assert language != null : "Precondition failed: language != null";

		List<DictionaryEntry> result = new LinkedList<DictionaryEntry>();

		List<SignPuddleEntry> signPuddleEntries = parsePuddleEntries(puddleXml);

		for (SignPuddleEntry signPuddleEntry : signPuddleEntries) {
			List<PositionedSymbolEntry> symbolEntries = signPuddleEntry.getSign().getPositionedSymbolEntries();

			List<TextTermEntry> termStrings = signPuddleEntry.getTextTerms();
			for (TextTermEntry term : termStrings) {
				String word = term.getTextTermString();

				word = repairStrategy.repairWord(word, signPuddleEntry);
				if (word == null)
					continue;

				SimpleSign sign = new SimpleSign(
						new SignId(signPuddleEntry.getSignId(), word, language, SignSource.IMPORTED),
						User.getImportedUser(), language, signPuddleEntry.mdt, signPuddleEntry.getText());

				for (int i = 0; i < symbolEntries.size(); i++) {
					PositionedSymbolEntry positionedSymbolEntry = symbolEntries.get(i);

					SymbolEntry symbolEntry = positionedSymbolEntry.getSymbol();
					String iswa2010Code = iswaBswConverter.convertBswToIswa(symbolEntry.getBaseSymbol(),
							symbolEntry.getFill(), symbolEntry.getRotation());

					Symbol symbol = symbolFactory.createSymbol(iswa2010Code);

					int x = positionedSymbolEntry.getCoordinates().getX()
							+ signPuddleEntry.getSign().getOffset().getX();
					int y = positionedSymbolEntry.getCoordinates().getY()
							+ signPuddleEntry.getSign().getOffset().getY();

					sign.addSymbol(new PositionedSymbol(symbol, x, y, i));
				}
				sign.normalize();

				result.add(new DictionaryEntry(word, sign));
			}
		}

		return result;
	}

	protected List<SignPuddleEntry> parsePuddleEntries(String puddleXml) throws JDOMException, IOException {

		List<SignPuddleEntry> result = new ArrayList<SignPuddleEntry>();

		SAXBuilder saxBuilder = new SAXBuilder();
		Document doc = saxBuilder.build(new StringReader(puddleXml));

		Element root = doc.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> signElementList = root.getChildren("entry");

		int errorCount = 0; // up until 3 errors will be logged

		for (Element signElement : signElementList) {
			try {
				long signId = signElement.getAttribute("id").getLongValue();
				Attribute creationDateAttributte = signElement.getAttribute("cdt");
				Date creationDate;
				if (!creationDateAttributte.getValue().equals("")) {
					creationDate = new Date(creationDateAttributte.getLongValue() * 1000);
				} else {
					creationDate = new Date();
				}

				Attribute modificationDateAttribute = signElement.getAttribute("mdt");
				Date modificationDate;
				if (!modificationDateAttribute.getValue().equals("")) {
					modificationDate = new Date(modificationDateAttribute.getLongValue() * 1000);
				} else {
					modificationDate = creationDate;
				}

				String usr = signElement.getAttributeValue("usr");
				List<TextTermEntry> textTerms = new ArrayList<TextTermEntry>();

				SignEntry signEntry = null;

				@SuppressWarnings("unchecked")
				List<Element> terms = signElement.getChildren("term");
				for (Element term : terms) {
					String termString = term.getValue();
					termString = termString.trim();
					// signEntries are also valid textTermEntries, so signEntry
					// has
					// to be checked first
					if (SignEntry.isValid(termString)) {
						signEntry = new SignEntry(termString);
					} else if (TextTermEntry.isValid(termString)) {
						textTerms.add(new TextTermEntry(termString));
					}
				}

				Element textElement = signElement.getChild("text");
				String text = textElement != null ? textElement.getValue() : null;
				Element srcElement = signElement.getChild("src");
				String src = srcElement != null ? srcElement.getValue() : null;

				if (signEntry != null) {
					SignPuddleEntry signPuddleEntry = new SignPuddleEntry(signId, creationDate, modificationDate, usr,
							text, src, signEntry, textTerms);
					result.add(signPuddleEntry);
				} else {
					LOGGER.trace("Entry without valid sign data: '(id=" + signId + "')");
				}
			} catch (Exception e) {
				errorCount++;

				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < signElement.getAttributes().size(); i++) {
					Attribute attribute = (Attribute) signElement.getAttributes().get(i);
					builder.append("\t" + attribute.getName() + ":" + attribute.getValue() + "\n");
				}
				LOGGER.error("Entry " + signElement + " could not be parsed. Element:\n" + builder.toString(), e);

				if (errorCount >= 3) {
					LOGGER.error("3 errors occured during parsing, breaking operation: ");
					break;
				}
			}
		}

		return result;
	}

	protected class SignPuddleEntry {
		private final long signId;
		private final Date cdt;
		private final Date mdt;
		private final String usr;
		private final String text;
		private final String src;
		private final SignEntry signEntry;
		private final List<TextTermEntry> textTerms;

		public SignPuddleEntry(long signId, Date cdt, Date mdt, String usr, String text, String src,
				SignEntry signEntry, List<TextTermEntry> textTerms) {
			assert cdt != null : "Precondition failed: cdt != null";
			assert mdt != null : "Precondition failed: mdt != null";
			assert usr != null : "Precondition failed: usr != null";
			assert textTerms != null : "Precondition failed: textTerms != null";

			this.signId = signId;
			this.cdt = cdt;
			this.mdt = mdt;
			this.usr = usr;
			this.text = text;
			this.src = src;
			this.signEntry = signEntry;
			this.textTerms = textTerms;
		}

		public long getSignId() {
			return signId;
		}

		public Date getCdt() {
			return cdt;
		}

		public Date getMdt() {
			return mdt;
		}

		public String getUsr() {
			return usr;
		}

		public String getText() {
			return text;
		}

		public String getSrc() {
			return src;
		}

		public List<TextTermEntry> getTextTerms() {
			return textTerms;
		}

		public SignEntry getSign() {
			return signEntry;
		}
	}

	protected static class CoordinateEntry {

		public static boolean isValid(String coordinateString) {
			return coordinateString != null && COORDINATE_PATTERN.matcher(coordinateString).matches();
		}

		private final int x;
		private final int y;

		public CoordinateEntry(String coordinateString) {
			assert isValid(coordinateString) : "Precondition failed: isValid(coordinateString)";

			String[] coordinateStrings = coordinateString.replace('n', '-').split("x");

			x = Integer.parseInt(coordinateStrings[0]);
			y = Integer.parseInt(coordinateStrings[1]);
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	protected static class TextTermEntry {

		private final String textTermString;

		public static boolean isValid(String textTermString) {
			return textTermString != null && !textTermString.isEmpty() && !textTermString.startsWith(" ")
					&& !textTermString.endsWith(" ");
		}

		public TextTermEntry(String textTermString) {
			assert isValid(textTermString) : "Precondition failed: isValid(textTermString)";

			this.textTermString = textTermString.replaceAll(" ", "_");
		}

		public String getTextTermString() {
			return textTermString;
		}

	}

	protected static class SymbolEntry {

		public static boolean isValid(String symbolString) {
			return symbolString != null && SYMBOL_PATTERN.matcher(symbolString).matches();
		}

		private final int baseSymbol;
		// Fill and rotation 0-based!
		private final int fill;
		private final int rotation;

		public SymbolEntry(String symbolString) {
			assert isValid(symbolString) : "Precondition failed: isValid(symbolString)";

			baseSymbol = Integer.parseInt(symbolString.substring(1, 4), 16);
			fill = Integer.parseInt(symbolString.substring(4, 5), 16);
			rotation = Integer.parseInt(symbolString.substring(5), 16);
		}

		public int getBaseSymbol() {
			return baseSymbol;
		}

		public int getFill() {
			return fill;
		}

		public int getRotation() {
			return rotation;
		}
	}

	protected static class PositionedSymbolEntry {

		private final SymbolEntry symbol;
		private final CoordinateEntry coordinates;

		public PositionedSymbolEntry(SymbolEntry symbol, CoordinateEntry coordinates) {
			assert symbol != null : "Precondition failed: symbol != null";
			assert coordinates != null : "Precondition failed: coordinates != null";

			this.symbol = symbol;
			this.coordinates = coordinates;
		}

		public SymbolEntry getSymbol() {
			return symbol;
		}

		public CoordinateEntry getCoordinates() {
			return coordinates;
		}
	}

	protected static class SignEntry {
		private final CoordinateEntry offset;
		private final List<PositionedSymbolEntry> positionedSymbolEntries;

		public static boolean isValid(String signString) {
			return signString != null && SIGN_ENTRY_PATTERN.matcher(signString).matches();
		}

		public SignEntry(String signString) {
			assert isValid(signString) : "Precondition failed: isValid(signString)";

			if (signString.startsWith("A")) {
				int indexOf = signString.indexOf("M");
				if (indexOf > -1) {
					signString = signString.substring(indexOf);
				}
			}

			Matcher coordinateMatcher = COORDINATE_PATTERN.matcher(signString);

			if (signString.startsWith("M")) {
				coordinateMatcher.find();
				offset = new CoordinateEntry(signString.substring(coordinateMatcher.start(), coordinateMatcher.end()));
			} else {
				offset = new CoordinateEntry("0x0");
			}

			Matcher symbolMatcher = SYMBOL_PATTERN.matcher(signString);

			positionedSymbolEntries = new ArrayList<SignPuddleXmlParser.PositionedSymbolEntry>();

			while (symbolMatcher.find()) {
				int symbolEndIndex = symbolMatcher.end();
				SymbolEntry symbolEntry = new SymbolEntry(signString.substring(symbolMatcher.start(), symbolEndIndex));
				coordinateMatcher.find(symbolEndIndex);
				CoordinateEntry coordinateEntry = new CoordinateEntry(
						signString.substring(coordinateMatcher.start(), coordinateMatcher.end()));
				positionedSymbolEntries.add(new PositionedSymbolEntry(symbolEntry, coordinateEntry));
			}
		}

		public CoordinateEntry getOffset() {
			return offset;
		}

		public List<PositionedSymbolEntry> getPositionedSymbolEntries() {
			return positionedSymbolEntries;
		}
	}
}
