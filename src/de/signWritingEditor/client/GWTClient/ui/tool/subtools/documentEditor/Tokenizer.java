package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tokenizer {

	private static final char[] SPECIAL_CHARACTERS_VISIBLES = { '.', ',', '!', '?', ';', ':', '"', '(', ')' };
	private static final char[] SPECIAL_CHARACTERS_INVISIBLES = { ' ', '\n', '\f' };
	private static final char[] SPECIAL_CHARACTERS = { '.', ',', '!', '?', ';', ':', '"', '(', ')', ' ', '\n', '\f' };

	public static final char LINE_BREAK = '\n';
	public static final char PAGE_BREAK = '\f';
	public static final char BOX_BREAK = ' ';
	public static boolean isSorted = false;

	public Tokenizer() {
		sort();
	}

	public static void sort() {
		Arrays.sort(SPECIAL_CHARACTERS);
		Arrays.sort(SPECIAL_CHARACTERS_VISIBLES);
		isSorted = true;
	}

	/**
	 * Splits the text into tokens. The splitting criteria are defined in
	 * DocumentEditorUtils.SPECIAL_CHARACTERS. The tokens are returned in a
	 * list.
	 * 
	 * @param textToTokenize
	 *            The text to be split
	 * @return The tokens the text was split into
	 * @require textToTokenize != null
	 */
	public List<String> tokenize(String textToTokenize) {
		assert textToTokenize != null : "Precondition failed: textToTokenize != null";
		List<String> result = new ArrayList<String>();

		List<String> pages = new ArrayList<String>();
		pages.addAll(Arrays.asList(textToTokenize.split(String.valueOf(PAGE_BREAK))));
		if (textToTokenize.equals(String.valueOf(PAGE_BREAK))) {
			pages.add("");
		}
		if (textToTokenize.endsWith(String.valueOf(PAGE_BREAK))) {
			pages.add("");
		}

		for (int i = 0; i < pages.size(); i++) {

			String page = pages.get(i);
			if (i < pages.size() - 1 && page.endsWith(String.valueOf(BOX_BREAK))) {
				page = page.substring(0, page.length() - 1);
			}
			tokenizeTextWithoutPageBreaks(result, page);

			if (i < pages.size() - 1) {
				result.add(String.valueOf(PAGE_BREAK));
			}
		}

		return result;
	}

	private void tokenizeTextWithoutPageBreaks(List<String> result, String text) {
		assert result != null : "Precondition failed: result, text != null";
		assert text != null : "Precondition failed: text != null";
		assert !text.contains("" + PAGE_BREAK) : "Precondition failed: !text.contains(PAGE_BREAK)";

		List<String> lines = new ArrayList<String>();
		lines.addAll(Arrays.asList(text.split("" + LINE_BREAK)));

		if (text.equals("" + LINE_BREAK)) {
			lines.add("");
		}
		if (text.endsWith("" + LINE_BREAK)) {
			lines.add("");
		}
		for (int j = 0; j < lines.size(); j++) {
			String line = lines.get(j);
			if (j < lines.size() - 1 && line.endsWith("" + BOX_BREAK)) {
				line = line.substring(0, line.length() - 1);
			}
			tokenizeStringWithoutLineOrPageBreaks(result, line);

			if (j < lines.size() - 1) {
				result.add("" + LINE_BREAK);
			}
		}

	}

	private void tokenizeStringWithoutLineOrPageBreaks(List<String> result, String text) {
		assert result != null : "Precondition failed: result, text != null";
		assert text != null : "Precondition failed: text != null";
		assert !text.contains("" + PAGE_BREAK) : "Precondition failed: !text.contains(PAGE_BREAK)";
		assert !text.contains("" + LINE_BREAK) : "Precondition failed: !text.contains(LINE_BREAK)";

		List<String> tokens = new ArrayList<String>();
		tokens.addAll(Arrays.asList(text.split("" + BOX_BREAK)));

		if (text.equals("" + BOX_BREAK)) {
			tokens.add("");
		}
		if (text.endsWith("" + BOX_BREAK)) {
			tokens.add("");
		}

		for (int i = 0; i < tokens.size(); i++) {
			tokenizeStringWithOnlyVisibleSpecialCharactersLeft(result, tokens.get(i));
		}
	}

	private void tokenizeStringWithOnlyVisibleSpecialCharactersLeft(List<String> result, String text) {
		assert result != null : "Precondition failed: result, text != null";
		assert text != null : "Precondition failed: text != null";
		assert !text.contains("" + PAGE_BREAK) : "Precondition failed: !text.contains(PAGE_BREAK)";
		assert !text.contains("" + LINE_BREAK) : "Precondition failed: !text.contains(LINE_BREAK)";
		assert !text.contains("" + BOX_BREAK) : "Precondition failed: !text.contains(LINE_BREAK)";

		int begin = 0;

		for (int i = 0; i < text.length(); i++) {
			char charAtPos = text.charAt(i);
			if (isVisibleSpecialCharacter(charAtPos)) {
				if (begin != i) {
					result.add(text.substring(begin, i));
				}
				result.add("" + charAtPos);
				begin = i + 1;
			}
		}
		if (begin < text.length()) {
			result.add(text.substring(begin));
		} else if (text.equals("")) {
			result.add("");
		}

	}

	private static int indexOfCharacter(String text, char[] characters) {
		if (!isSorted) {
			sort();
		}
		return indexOfCharacter(text, 0, characters);
	}

	private static int indexOfCharacter(String text, int beginIndex, char[] characters) {
		if (!isSorted) {
			sort();
		}
		int result = Integer.MAX_VALUE;
		for (char specialChararcter : characters) {
			int indexOfSpecialChar = text.indexOf(specialChararcter, beginIndex);
			if (indexOfSpecialChar != -1) {
				result = Math.min(result, indexOfSpecialChar);
			}
		}
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		return result;
	}

	public static boolean isVisibleSpecialCharacter(char character) {
		if (!isSorted) {
			sort();
		}
		return Arrays.binarySearch(SPECIAL_CHARACTERS_VISIBLES, character) > -1;
	}

	public static boolean isInvisibleSpecialCharacter(char character) {
		if (!isSorted) {
			sort();
		}
		return indexOfCharacter(String.valueOf(character), SPECIAL_CHARACTERS_INVISIBLES) > -1;
	}
}
