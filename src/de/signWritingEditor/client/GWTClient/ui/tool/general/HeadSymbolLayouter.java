package de.signWritingEditor.client.GWTClient.ui.tool.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.SimpleSign;

public class HeadSymbolLayouter {

	private static final int EMPTY_HEAD_OVERLAP = HeadSymbol.HEAD_CIRCLE_OFFSET;

	public static List<Integer> getXPositionsForHeadSymbols(List<HeadSymbol> headSymbols, int center) {
		assert headSymbols != null : "Precondition failed: headSymbols != null";
		assert !headSymbols.isEmpty() : "Precondition failed: !headSymbols.isEmpty()";

		List<Integer> result = new ArrayList<Integer>(headSymbols.size());

		double headSymbolXPos = center;
		for (HeadSymbol headSymbol : headSymbols) {
			headSymbolXPos -= headSymbol.getWidth() / 2.0;
		}

		// Take overlap of symbols into account
		List<Integer> overlapsBetweenSymbols = HeadSymbolLayouter.getOverlapsBetweenSymbols(headSymbols);
		for (Integer overlap : overlapsBetweenSymbols) {
			headSymbolXPos += overlap / 2.0;
		}

		for (int i = 0; i < headSymbols.size(); i++) {
			HeadSymbol headSymbol = headSymbols.get(i);

			result.add((int) Math.round(headSymbolXPos));

			if (i < (headSymbols.size() - 1)) {
				headSymbolXPos = headSymbolXPos + headSymbol.getWidth() - overlapsBetweenSymbols.get(i);
			}
		}

		assert result != null : "Postcondition failed: result != null";
		assert result.size() == headSymbols.size() : "Postcondition failed: result.size() == headSymbols.size()";

		return result;
	}

	private static List<Integer> getOverlapsBetweenSymbols(List<HeadSymbol> headSymbols) {
		assert headSymbols != null : "Precondition failed: headSymbols != null";
		assert !headSymbols.isEmpty() : "Precondition failed: !headSymbols.isEmpty()";

		List<Integer> result = new ArrayList<Integer>(headSymbols.size() - 1);

		Map<HeadSymbol, Integer> individualXOverlaps = getIndividualXOverlaps(headSymbols);

		int lastSymbolOverlap = individualXOverlaps.get(headSymbols.get(0));

		for (int index = 1; index < headSymbols.size(); index++) {
			HeadSymbol headSymbol = headSymbols.get(index);
			int headSymbolOverlap = individualXOverlaps.get(headSymbol);

			result.add(Math.min(lastSymbolOverlap, headSymbolOverlap));

			lastSymbolOverlap = headSymbolOverlap;
		}

		return result;
	}

	private static Map<HeadSymbol, Integer> getIndividualXOverlaps(List<HeadSymbol> headSymbols) {
		assert headSymbols != null : "Precondition failed: headSymbols != null";

		Map<HeadSymbol, Integer> result = new HashMap<HeadSymbol, Integer>();

		for (HeadSymbol headSymbol : headSymbols) {
			int overlap;
			if (headSymbol.isWhitespace()) {
				overlap = EMPTY_HEAD_OVERLAP;
			} else {
				overlap = (headSymbol.getWidth() - HeadSymbol.HEAD_CIRCLE_WIDTH) / 2 + SimpleSign.HEAD_SYMBOL_OVERLAP;
			}
			result.put(headSymbol, overlap);
		}

		return result;

	}
}
