package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.signWritingEditor.client.GWTClient.ui.tool.general.HeadSymbolLayouter;
import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.ExpressionBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HairBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.JawBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NeckBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NoseBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class SymbolToHeadSymbolConverter {
	private static final int JAW_SYMBOL_OFFSET_CENTER_TO_RIGHT = 19;
	private static final int JAW_SYMBOL_OFFSET_CENTER_TO_LEFT = 12;
	private static final int HORIZONTAL_CENTER_TOLERANCE = (HeadSymbol.HEAD_CIRCLE_WIDTH / 2)
			- SimpleSign.HEAD_SYMBOL_OVERLAP;
	private static final int VERTICAL_CENTER_TOLERANCE = HeadSymbol.HEAD_SYMBOL_HEIGHT;
	private PositionedSymbolFactory positionedSymbolFactory;

	public SymbolToHeadSymbolConverter(PositionedSymbolFactory positionedSymbolFactory) {
		assert positionedSymbolFactory != null : "Precondition failed: positioneSymbolFactory != null";
		this.positionedSymbolFactory = positionedSymbolFactory;

	}

	public List<PositionedSymbol> getConvertableSymbols(List<PositionedSymbol> positionedSymbols) {
		assert positionedSymbols != null : "Precondition failed: positionedSymbols != null";

		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();

		for (PositionedSymbol positionedSymbol : positionedSymbols) {
			Symbol symbol = positionedSymbol.getSymbol();

			if (HeadPostureBaseSymbol.isValidHeadPostureSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (EyesBaseSymbol.isAnyEyesSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (NoseBaseSymbol.isAnyNoseSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (CheeksBaseSymbol.isAnyCheeksSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (MouthBaseSymbol.isAnyMouthSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (EarsBaseSymbol.isAnyEarsSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (BreathBaseSymbol.isAnyBreathSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (JawBaseSymbol.isAnyJawSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (NeckBaseSymbol.isAnyNeckSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (ExpressionBaseSymbol.isAnyExpressionSymbol(symbol)) {
				result.add(positionedSymbol);

			} else if (HairBaseSymbol.isAnyHairSymbol(symbol)) {
				result.add(positionedSymbol);
			} else if (isJarSymbolAdditionSymbol(symbol)) {
				result.add(positionedSymbol);
			}
		}

		assert result != null : "Postcondition failed: result != null";
		assert result.size() <= positionedSymbols
				.size() : "Postcondition failed: result.size() <= positionedSymbols.size()";
		return result;
	}

	private boolean isJarSymbolAdditionSymbol(Symbol symbol) {
		return symbol.getCategory() == 4 && symbol.getGroup() == 99 && symbol.getSymbol() == 999
				&& symbol.getVariation() == 96;
	}

	public List<HeadSymbol> convertToHeadSymbols(List<PositionedSymbol> positionedSymbols) {
		assert positionedSymbols != null : "Precondition failed: positionedSymbols != null";

		List<HeadSymbol> result = new ArrayList<HeadSymbol>();

		List<PositionedSymbol> convertableSymbols = getConvertableSymbols(positionedSymbols);

		replacePositionedJawSymbolsByJawSymbolSets(convertableSymbols);

		Comparator<PositionedSymbol> symbolXComparator = new Comparator<PositionedSymbol>() {
			@Override
			public int compare(PositionedSymbol symbol1, PositionedSymbol symbol2) {
				return symbol1.getX() - symbol2.getX();
			}
		};

		Collections.sort(convertableSymbols, symbolXComparator);

		for (PositionedSymbol positionedSymbol : convertableSymbols) {
			Symbol symbol = positionedSymbol.getSymbol();
			assert SymbolCategoryAnalyzer
					.isHeadSymbol(symbol) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";

			HeadSymbol previousHeadSymbol = result.isEmpty() ? null : result.get(result.size() - 1);
			boolean belongsToPreviousHeadSymbol = previousHeadSymbol != null
					&& belongTogether(previousHeadSymbol, positionedSymbol);

			if (HeadPostureBaseSymbol.isValidHeadPostureSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleHeadPostureSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}
			} else if (EyesBaseSymbol.isAnyEyesSymbol(symbol)) {

				HeadSymbol potentialNewHeadSymbol = handleEyeSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}

			} else if (MouthBaseSymbol.isAnyMouthSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleMouthSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}

			} else if (CheeksBaseSymbol.isAnyCheeksSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleCheekSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}

			} else if (NoseBaseSymbol.isAnyNoseSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleNoseSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}

			} else if (EarsBaseSymbol.isAnyEarsSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleEarSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}
			} else if (BreathBaseSymbol.isAnyBreathSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleBreathSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}
			} else if (JawBaseSymbol.isAnyJawSymbol(symbol)) {

				HeadSymbol potentialNewHeadSymbol = handleJawSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}
			} else if (NeckBaseSymbol.isAnyNeckSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleNeckSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}
			} else if (ExpressionBaseSymbol.isAnyExpressionSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleExpressionSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}
			} else if (HairBaseSymbol.isAnyHairSymbol(symbol)) {
				HeadSymbol potentialNewHeadSymbol = handleHairSymbol(positionedSymbol, previousHeadSymbol,
						belongsToPreviousHeadSymbol);
				if (!result.contains(potentialNewHeadSymbol)) {
					result.add(potentialNewHeadSymbol);
				}
			}

			if (previousHeadSymbol != null && belongsToPreviousHeadSymbol
					&& positionedSymbol.getY() < previousHeadSymbol.getY()) {
				previousHeadSymbol.setY(positionedSymbol.getY());
			}

		}

		if (!result.isEmpty()) {
			boolean isArranged = true;
			int headSymbolsBottom = SimpleSign.HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT;
			for (HeadSymbol headSymbol : result) {
				if (headSymbol
						.getY() != (headSymbolsBottom - headSymbol.getHeight() + headSymbol.getLowerExtension())) {
					isArranged = false;
					break;
				}
			}
			if (isArranged) {
				List<Integer> xPositionsForHeadSymbols = HeadSymbolLayouter.getXPositionsForHeadSymbols(result, 0);
				for (int i = 0; i < xPositionsForHeadSymbols.size(); i++) {
					if (result.get(i).getX() != xPositionsForHeadSymbols.get(i)) {
						isArranged = false;
						break;
					}
				}
			}
			for (HeadSymbol headSymbol : result) {
				headSymbol.setFreePositionable(!isArranged);
			}
		}
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private void replacePositionedJawSymbolsByJawSymbolSets(List<PositionedSymbol> convertableSymbols) {
		List<PositionedSymbol> jawSymbols = new ArrayList<PositionedSymbol>();
		List<PositionedSymbol> invalidJaws = new ArrayList<PositionedSymbol>();

		for (PositionedSymbol positionedSymbol : convertableSymbols) {
			if (PositionedJawSymbol.isValidJawSymbol(positionedSymbol.getSymbol())) {
				jawSymbols.add(positionedSymbol);
			} else if (PositionedJawSymbol.isAnyJawSymbol(positionedSymbol.getSymbol())) {
				List<PositionedJawSymbol> validJawSymbols = PositionedJawSymbol
						.convertToValidJawSymbol(positionedSymbol.getSymbol());
				// Convert liefert PositionedJawSymbols zurück die alle Valid
				// sind
				for (int i = 0; i < validJawSymbols.size(); i++) {
					PositionedJawSymbol jawSymbol = validJawSymbols.get(i);
					if (jawSymbol.getLocation().equals(Location.LEFT)) {
						jawSymbol.setX(positionedSymbol.getX());
						jawSymbol.setY(HeadSymbol.JAW_SYMBOL_ARROW_Y_DISTANCE_FROM_HEAD_CENTER
								+ HeadSymbol.HEAD_CIRCLE_HEIGHT / 2);
					} else if (jawSymbol.getLocation().equals(Location.BOTH)) {
						jawSymbol.setX(positionedSymbol.getX() + JAW_SYMBOL_OFFSET_CENTER_TO_LEFT);
						jawSymbol.setY(HeadSymbol.JAW_HEAD_RIM_OFFSET_Y_FROM_CIRCLE_CENTER
								+ HeadSymbol.HEAD_CIRCLE_HEIGHT / 2);
					} else if (jawSymbol.getLocation().equals(Location.RIGHT)) {
						jawSymbol.setX(positionedSymbol.getX() + JAW_SYMBOL_OFFSET_CENTER_TO_LEFT
								+ JAW_SYMBOL_OFFSET_CENTER_TO_RIGHT);
						jawSymbol.setY(HeadSymbol.JAW_SYMBOL_ARROW_Y_DISTANCE_FROM_HEAD_CENTER
								+ HeadSymbol.HEAD_CIRCLE_HEIGHT / 2);
					}
				}

				invalidJaws.add(positionedSymbol);
				jawSymbols.addAll(validJawSymbols);
			}
		}

		convertableSymbols.removeAll(jawSymbols);
		convertableSymbols.removeAll(invalidJaws);

		List<PositionedJawSymbolSet> jawSymbolSets = new ArrayList<PositionedJawSymbolSet>();

		Collections.sort(jawSymbols, new Comparator<PositionedSymbol>() {

			@Override
			public int compare(PositionedSymbol symbol1, PositionedSymbol symbol2) {
				return symbol1.getX() - symbol2.getX();
			}

		});

		for (int i = 0; i < jawSymbols.size(); i++) {

			PositionedSymbol currentSymbol = jawSymbols.get(i);
			boolean addedToSet = false;
			for (int j = 0; j < jawSymbolSets.size(); j++) {
				if (!addedToSet && jawSymbolSets.get(j).belongsToSet(currentSymbol)) {
					jawSymbolSets.get(j).addSymbol(currentSymbol);
					addedToSet = true;
				}
			}

			if (!addedToSet && !currentSymbol.getBaseSymbol()
					.equals(JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol().getBaseSymbol())) {
				jawSymbolSets.add(new PositionedJawSymbolSet(currentSymbol));
			}

		}

		convertableSymbols.addAll(jawSymbolSets);
	}

	private HeadSymbol handleJawSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		PositionedJawSymbolSet symbolSet = (PositionedJawSymbolSet) positionedSymbol;
		assert positionedSymbol instanceof PositionedJawSymbolSet : "Precondition failed: positionedSymbol instanceof PositionedJawSymbolSet";

		List<PositionedJawSymbol> jawSymbols = symbolSet.getPositionedSymbols();

		HeadSymbol headSymbol = null;

		if (belongsToPreviousHeadSymbol) {

			headSymbol = previousHeadSymbol;

			for (PositionedJawSymbol positionedJawSymbol : jawSymbols) {
				updatePositionOfPositionedSymbol(positionedJawSymbol, positionedJawSymbol.getLocation(),
						positionedJawSymbol, headSymbol);
			}

			headSymbol.setJawSymbol(jawSymbols);
		} else {
			headSymbol = createHeadSymbolRelativeToASymbol(jawSymbols.get(0).getSymbol(), positionedSymbol.getX(),
					positionedSymbol.getY(), positionedSymbol.getZ() >= 1 ? positionedSymbol.getZ() : 1,
					jawSymbols.get(0).getLocation());
			// Set position to Standard when creating a new Head
			for (PositionedJawSymbol positionedJawSymbol : jawSymbols) {
				positionedJawSymbol.setX(0);
				positionedJawSymbol.setY(0);
				positionedJawSymbol.setZ(0);
			}

			headSymbol.setJawSymbol(jawSymbols);
			headSymbol.setX(positionedSymbol.getX());
		}

		return headSymbol;
	}

	private HeadSymbol handleHeadPostureSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";

		PositionedHeadPostureSymbol headPostureSymbol = getHeadPostureSymbolFor(positionedSymbol.getSymbol());

		HeadSymbol headSymbol = null;
		if (belongsToPreviousHeadSymbol) {
			headSymbol = previousHeadSymbol;
			updatePositionOfPositionedSymbol(headPostureSymbol, Location.UNKNOWN, positionedSymbol, previousHeadSymbol);
			previousHeadSymbol.setHeadPostureSymbol(headPostureSymbol);
		} else {
			headSymbol = createHeadSymbolRelativeToASymbol(headPostureSymbol.getSymbol(), positionedSymbol.getX(),
					positionedSymbol.getY(), positionedSymbol.getZ(), Location.UNKNOWN);
			headSymbol.setHeadPostureSymbol(headPostureSymbol);
			headSymbol.setX(positionedSymbol.getX());
			headSymbol.setY(positionedSymbol.getY());
		}

		return headSymbol;
	}

	private HeadSymbol handleNeckSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";
		PositionedNeckSymbol neckSymbol = getNeckSymbolFor(positionedSymbol.getSymbol());
		HeadSymbol headSymbol = null;

		if (belongsToPreviousHeadSymbol) {
			headSymbol = previousHeadSymbol;
			if (positionedSymbol.getSymbol().getFill() != 1) {
				updatePositionOfPositionedSymbol(neckSymbol, Location.UNKNOWN, positionedSymbol, previousHeadSymbol);
			}
			previousHeadSymbol.setNeckSymbol(neckSymbol);
		} else {
			if (positionedSymbol.getSymbol().getFill() != 1) {
				headSymbol = createHeadSymbolRelativeToASymbol(neckSymbol.getSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ(), Location.UNKNOWN);
			} else {
				headSymbol = positionedSymbolFactory.createHeadSymbol(
						PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ());
			}
			headSymbol.setNeckSymbol(neckSymbol);
		}
		return headSymbol;
	}

	private HeadSymbol handleHairSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";

		PositionedHairSymbol hairSymbol = getHairSymbolFor(positionedSymbol.getSymbol());
		HeadSymbol headSymbol = null;

		if (belongsToPreviousHeadSymbol) {
			headSymbol = previousHeadSymbol;
			updatePositionOfPositionedSymbol(hairSymbol, Location.UNKNOWN, positionedSymbol, previousHeadSymbol);
			previousHeadSymbol.setHairSymbol(hairSymbol);
		} else {
			headSymbol = createHeadSymbolRelativeToASymbol(hairSymbol.getSymbol(), positionedSymbol.getX(),
					positionedSymbol.getY(), positionedSymbol.getZ(), Location.UNKNOWN);
			headSymbol.setX(positionedSymbol.getX());
			headSymbol.setY(positionedSymbol.getY());
			headSymbol.setHairSymbol(hairSymbol);
		}
		return headSymbol;
	}

	private HeadSymbol handleExpressionSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";
		PositionedExpressionSymbol expressionSymbol = getExpressionSymbolFor(positionedSymbol.getSymbol());
		HeadSymbol headSymbol = null;

		if (belongsToPreviousHeadSymbol) {
			headSymbol = previousHeadSymbol;
			updatePositionOfPositionedSymbol(expressionSymbol, Location.UNKNOWN, positionedSymbol, previousHeadSymbol);
			previousHeadSymbol.setExpressionSymbol(expressionSymbol);
		} else {
			headSymbol = createHeadSymbolRelativeToASymbol(expressionSymbol.getSymbol(), positionedSymbol.getX(),
					positionedSymbol.getY(), positionedSymbol.getZ(), Location.UNKNOWN);
			headSymbol.setX(positionedSymbol.getX());
			headSymbol.setY(positionedSymbol.getY());
			headSymbol.setExpressionSymbol(expressionSymbol);
		}
		return headSymbol;
	}

	private HeadSymbol handleCheekSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";
		Location cheekPosition = isLeftRightOrBothSymbol(positionedSymbol, belongsToPreviousHeadSymbol,
				previousHeadSymbol);
		List<PositionedCheekSymbol> cheekSymbols = getCheekSymbolsFor(positionedSymbol.getSymbol(), cheekPosition);
		HeadSymbol headSymbol = null;
		if (belongsToPreviousHeadSymbol) {
			headSymbol = previousHeadSymbol;
			if (cheekSymbols.size() == 1 && positionedSymbol.getSymbol().getFill() > 3) {
				PositionedCheekSymbol positionedCheekSymbol = cheekSymbols.get(0);
				updatePositionOfPositionedSymbol(positionedCheekSymbol, positionedCheekSymbol.getLocation(),
						positionedSymbol, headSymbol);
			}
			cheekSymbols.addAll(previousHeadSymbol.getPositionedCheekSymbols());
			previousHeadSymbol.setCheekSymbols(cheekSymbols);
		} else {
			assert cheekSymbols.size() >= 1 : "Precondition failed: cheeksSymbol.size() >= 1";
			if (cheekSymbols.size() == 1 && positionedSymbol.getSymbol().getFill() > 3) {
				// The first cheek symbol always has to be a left cheek, if it
				// does not belong to a previous head symbol.
				headSymbol = createHeadSymbolRelativeToASymbol(
						CheeksBaseSymbol.getLeftCheekFor(positionedSymbol.getBaseSymbol()), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ(), Location.LEFT);
				if (!cheekSymbols.get(0).getLocation().equals(Location.LEFT)) {
					PositionedCheekSymbol positionedCheekSymbol = (PositionedCheekSymbol) positionedSymbolFactory
							.createPositionedSymbol(CheeksBaseSymbol.getLeftCheekFor(positionedSymbol.getBaseSymbol()),
									Location.LEFT);
					cheekSymbols.set(0, positionedCheekSymbol);
				}
			} else {
				headSymbol = positionedSymbolFactory.createHeadSymbol(
						PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ());
			}
			headSymbol.setCheekSymbols(cheekSymbols);
		}

		return headSymbol;
	}

	private HeadSymbol handleBreathSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";
		HeadSymbol headSymbol = null;
		if (belongsToPreviousHeadSymbol) {
			Location breathPosition = isLeftRightOrBothSymbol(positionedSymbol, belongsToPreviousHeadSymbol,
					previousHeadSymbol);
			List<PositionedBreathSymbol> breathSymbols = getBreathSymbolFor(positionedSymbol.getSymbol(),
					breathPosition);
			headSymbol = previousHeadSymbol;
			if (breathSymbols.size() == 1 && positionedSymbol.getSymbol().getFill() > 3) {
				PositionedBreathSymbol positionedBreathSymbol = breathSymbols.get(0);
				updatePositionOfPositionedSymbol(positionedBreathSymbol, positionedBreathSymbol.getLocation(),
						positionedSymbol, headSymbol);
			}
			breathSymbols.addAll(previousHeadSymbol.getPositionedBreathSymbols());
			previousHeadSymbol.setBreathSymbols(breathSymbols);
		} else {
			// Symbols are sorted from left to right
			Location breathPosition = Location.LEFT;
			List<PositionedBreathSymbol> breathSymbols = getBreathSymbolFor(positionedSymbol.getSymbol(),
					breathPosition);
			assert breathSymbols.size() >= 1 : "Precondition failed: cheeksSymbol.size() >= 1";
			if (positionedSymbol.getSymbol().getFill() > 3) {
				headSymbol = createHeadSymbolRelativeToASymbol(breathSymbols.get(0).getSymbol(),
						positionedSymbol.getX(), positionedSymbol.getY(), positionedSymbol.getZ(),
						breathSymbols.get(0).getLocation());
			} else {
				headSymbol = positionedSymbolFactory.createHeadSymbol(
						PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ());
			}

			headSymbol.setX(positionedSymbol.getX());
			headSymbol.setBreathSymbols(breathSymbols);
		}

		return headSymbol;
	}

	private HeadSymbol handleEarSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";
		HeadSymbol headSymbol = null;
		if (belongsToPreviousHeadSymbol) {
			Location earPosition = isLeftRightOrBothSymbol(positionedSymbol, belongsToPreviousHeadSymbol,
					previousHeadSymbol);
			List<PositionedEarsSymbol> earSymbols = getEarSymbolsFor(positionedSymbol.getSymbol(), earPosition);
			headSymbol = previousHeadSymbol;
			if (earSymbols.size() == 1 && positionedSymbol.getSymbol().getFill() > 3) {
				PositionedEarsSymbol positionedEarSymbol = earSymbols.get(0);
				updatePositionOfPositionedSymbol(positionedEarSymbol, positionedEarSymbol.getLocation(),
						positionedSymbol, headSymbol);
			}
			earSymbols.addAll(previousHeadSymbol.getPositionedEarSymbols());
			previousHeadSymbol.setEarSymbols(earSymbols);
		} else {
			// Symbols are sorted from left to right
			Location earPosition = Location.LEFT;
			List<PositionedEarsSymbol> earsSymbol = getEarSymbolsFor(positionedSymbol.getSymbol(), earPosition);
			assert earsSymbol.size() >= 1 : "Precondition failed: cheeksSymbol.size() >= 1";
			if (positionedSymbol.getSymbol().getFill() > 3) {
				headSymbol = createHeadSymbolRelativeToASymbol(earsSymbol.get(0).getSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ(), earsSymbol.get(0).getLocation());
			} else {
				headSymbol = positionedSymbolFactory.createHeadSymbol(
						PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ());
			}
			headSymbol.setEarSymbols(earsSymbol);
			headSymbol.setX(positionedSymbol.getX());
		}

		return headSymbol;
	}

	private HeadSymbol handleEyeSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";
		assert positionedSymbol != null : "Precondition failed: positionedSymbol != null";

		Location eyeLocation = Location.LEFT;
		if (positionedSymbol.getBaseSymbol().equals(EyesBaseSymbol.FOREHEAD_CONTACT.getIswaSymbol().getBaseSymbol()) || //
				positionedSymbol.getBaseSymbol().equals(EyesBaseSymbol.FOREHEAD_NEUTRAL.getIswaSymbol().getBaseSymbol())
				|| //
				positionedSymbol.getBaseSymbol()
						.equals(EyesBaseSymbol.FOREHEAD_WRINKLED.getIswaSymbol().getBaseSymbol())
				|| positionedSymbol.getSymbol().getFill() <= 4) {
			eyeLocation = Location.BOTH;
		}
		List<PositionedEyeSymbol> eyeSymbols = null;

		HeadSymbol headSymbol = null;
		if (belongsToPreviousHeadSymbol) {
			eyeLocation = isLeftRightOrBothSymbol(positionedSymbol, belongsToPreviousHeadSymbol, previousHeadSymbol);
			headSymbol = previousHeadSymbol;
			eyeSymbols = getEyesSymbolFor(positionedSymbol.getSymbol(), eyeLocation);
		} else {
			eyeSymbols = getEyesSymbolFor(positionedSymbol.getSymbol(), eyeLocation);
			assert eyeSymbols.size() >= 1 : "Precondition failed: eyeSymbols.size() >= 1";
			PositionedEyeSymbol positionedEyesSymbol = eyeSymbols.get(0);
			Location eyeSymbolLocation = positionedEyesSymbol.getLocation();
			if (positionedSymbol.getSymbol().getFill() >= 4) {
				headSymbol = createHeadSymbolRelativeToASymbol(positionedEyesSymbol.getSymbol(),
						positionedSymbol.getX(), positionedSymbol.getY(), positionedSymbol.getZ(), eyeSymbolLocation);
			} else {
				headSymbol = positionedSymbolFactory.createHeadSymbol(
						PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ());
			}
		}
		if (positionedSymbol.getSymbol().getFill() > 4) {
			PositionedEyeSymbol eyeSymbol = eyeSymbols.get(0);
			updatePositionOfPositionedSymbol(eyeSymbol, eyeSymbol.getLocation(), positionedSymbol, headSymbol);
		}
		eyeSymbols.addAll(headSymbol.getPositionedEyeSymbols());
		headSymbol.setEyeSymbols(eyeSymbols);

		return headSymbol;
	}

	private HeadSymbol handleMouthSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		assert SymbolCategoryAnalyzer.isHeadSymbol(positionedSymbol
				.getSymbol()) : "Precondition failed: SymbolCategoryAnalyzerpositionedSymbol.getSymbol()";
		PositionedMouthSymbol mouthSymbol = getMouthSymbolFor(positionedSymbol.getSymbol());
		HeadSymbol headSymbol = null;

		if (belongsToPreviousHeadSymbol) {
			headSymbol = previousHeadSymbol;
			if (positionedSymbol.getSymbol().getFill() != 1) {
				updatePositionOfPositionedSymbol(mouthSymbol, Location.UNKNOWN, positionedSymbol, previousHeadSymbol);
			}
			previousHeadSymbol.setMouthSymbol(mouthSymbol);
		} else {
			if (positionedSymbol.getSymbol().getFill() != 1) {
				headSymbol = createHeadSymbolRelativeToASymbol(mouthSymbol.getSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ(), Location.UNKNOWN);
			} else {
				headSymbol = positionedSymbolFactory.createHeadSymbol(
						PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ());
			}
			headSymbol.setMouthSymbol(mouthSymbol);
		}

		return headSymbol;
	}

	private HeadSymbol handleNoseSymbol(PositionedSymbol positionedSymbol, HeadSymbol previousHeadSymbol,
			boolean belongsToPreviousHeadSymbol) {
		PositionedNoseSymbol noseSymbol = getNoseSymbolFor(positionedSymbol.getSymbol());
		HeadSymbol headSymbol = null;

		if (belongsToPreviousHeadSymbol) {
			headSymbol = previousHeadSymbol;
			if (positionedSymbol.getSymbol().getFill() != 1) {
				updatePositionOfPositionedSymbol(noseSymbol, Location.UNKNOWN, positionedSymbol, previousHeadSymbol);
			}
			previousHeadSymbol.setNoseSymbol(noseSymbol);
		} else {
			if (positionedSymbol.getSymbol().getFill() != 1) {
				headSymbol = createHeadSymbolRelativeToASymbol(noseSymbol.getSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ(), Location.UNKNOWN);
			} else {
				headSymbol = positionedSymbolFactory.createHeadSymbol(
						PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), positionedSymbol.getX(),
						positionedSymbol.getY(), positionedSymbol.getZ());
			}
			headSymbol.setNoseSymbol(noseSymbol);
		}
		return headSymbol;
	}

	private PositionedHeadPostureSymbol getHeadPostureSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert HeadPostureBaseSymbol.isValidHeadPostureSymbol(
				symbol) : "Precondition failed: HeadPostureBaseSymbol.isHeadPostureBaseSymbol(symbol)";

		PositionedHeadPostureSymbol result = (PositionedHeadPostureSymbol) positionedSymbolFactory
				.createPositionedSymbol(symbol);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private List<PositionedEyeSymbol> getEyesSymbolFor(Symbol symbol, Location position) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert EyesBaseSymbol.isAnyEyesSymbol(symbol) : "Precondition failed: EyesBaseSymbol.isAnyEyesSymbol(symbol)";

		List<PositionedEyeSymbol> result = null;

		if (EyesBaseSymbol.isValidEyesSymbol(symbol) && ((symbol.getFill() != 4 && symbol.getSymbol() < 7)
				|| (symbol.getFill() > 2 && symbol.getSymbol() >= 7))) {
			result = new ArrayList<PositionedEyeSymbol>();
			result.add((PositionedEyeSymbol) positionedSymbolFactory.createPositionedSymbol(symbol, position));
		} else {
			result = PositionedEyeSymbol.convertToValidEyeSymbols(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private PositionedMouthSymbol getMouthSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert MouthBaseSymbol
				.isAnyMouthSymbol(symbol) : "Precondition failed: MouthBaseSymbol.isAnyMouthSymbol(symbol)";

		PositionedMouthSymbol result = null;

		if (PositionedMouthSymbol.isValidMouthSymbol(symbol)) {
			result = (PositionedMouthSymbol) positionedSymbolFactory.createPositionedSymbol(symbol);
		} else {
			result = PositionedMouthSymbol.convertToValidMouthSymbol(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private List<PositionedCheekSymbol> getCheekSymbolsFor(Symbol symbol, Location position) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert CheeksBaseSymbol
				.isAnyCheeksSymbol(symbol) : "Precondition failed: CheeksBaseSymbol.isCheeksBaseSymbol(symbol)";

		List<PositionedCheekSymbol> result = new ArrayList<PositionedCheekSymbol>();

		if (CheeksBaseSymbol.isValidCheeksSymbol(symbol)) {
			result.add((PositionedCheekSymbol) positionedSymbolFactory.createPositionedSymbol(symbol, position));
		} else {
			result = PositionedCheekSymbol.convertToValidCheeksSymbol(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private PositionedHairSymbol getHairSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert HairBaseSymbol.isAnyHairSymbol(symbol) : "Precondition failed: HairBaseSymbol.isAnyHairSymbol(symbol)";

		PositionedHairSymbol result = null;

		if (HairBaseSymbol.isValidHairSymbol(symbol)) {
			result = (PositionedHairSymbol) positionedSymbolFactory.createPositionedSymbol(symbol);
		} else {
			result = PositionedHairSymbol.convertToValidHairSymbol(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private PositionedExpressionSymbol getExpressionSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert ExpressionBaseSymbol.isAnyExpressionSymbol(
				symbol) : "Precondition failed:  ExpressionBaseSymbol.isAnyExpressionSymbol(symbol)";

		PositionedExpressionSymbol result = null;

		if (ExpressionBaseSymbol.isValidExpressionSymbol(symbol)) {
			result = (PositionedExpressionSymbol) positionedSymbolFactory.createPositionedSymbol(symbol);
		} else {
			result = PositionedExpressionSymbol.convertToValidExpressionSymbol(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private PositionedNeckSymbol getNeckSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert NeckBaseSymbol.isAnyNeckSymbol(symbol) : "Precondition failed: NeckBaseSymbol.isAnyNeckSymbol(symbol)";

		PositionedNeckSymbol result = null;

		if (NeckBaseSymbol.isValidNeckSymbol(symbol)) {
			result = (PositionedNeckSymbol) positionedSymbolFactory
					.createPositionedSymbol(NeckBaseSymbol.getNeckBaseSymbol(symbol).getIswaSymbol());
		} else {
			result = PositionedNeckSymbol.convertToValidNeckSymbol(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private List<PositionedBreathSymbol> getBreathSymbolFor(Symbol symbol, Location position) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert BreathBaseSymbol
				.isAnyBreathSymbol(symbol) : "Precondition failed: BreathBaseSymbol.isAnyBreathSymbol(symbol)";

		List<PositionedBreathSymbol> result = new ArrayList<PositionedBreathSymbol>();

		if (BreathBaseSymbol.isValidBreathSymbol(symbol) && symbol.getFill() != 4) {
			result.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(symbol, position));
		} else {
			result = PositionedBreathSymbol.convertToValidBreathSymbol(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private List<PositionedEarsSymbol> getEarSymbolsFor(Symbol symbol, Location position) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert EarsBaseSymbol.isAnyEarsSymbol(symbol) : "Precondition failed: EarsBaseSymbol.isAnyEarsSymbol(symbol)";

		List<PositionedEarsSymbol> result = new ArrayList<PositionedEarsSymbol>();

		if (EarsBaseSymbol.isValidEarsSymbol(symbol)) {
			result.add((PositionedEarsSymbol) positionedSymbolFactory.createPositionedSymbol(symbol, position));
		} else {
			result = PositionedEarsSymbol.convertToValidEarsSymbol(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private PositionedNoseSymbol getNoseSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert NoseBaseSymbol.isAnyNoseSymbol(symbol) : "Precondition failed: NoseBaseSymbol.isAnyNoseSymbol(symbol)";

		PositionedNoseSymbol result = null;

		if (NoseBaseSymbol.isValidNoseSymbol(symbol)) {
			result = (PositionedNoseSymbol) positionedSymbolFactory
					.createPositionedSymbol(NoseBaseSymbol.getNoseBaseSymbol(symbol.getBaseSymbol()).getIswaSymbol());
		} else {
			result = PositionedNoseSymbol.convertToValidNoseSymbol(symbol);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public static List<PositionedSymbol> getPositionedSymbolsForHeadSymbol(HeadSymbol headSymbol, int xOffset,
			int yOffset, int zOffset) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert zOffset >= 0 : "Precondition failed: zOffset>=0";

		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();

		PositionedHeadPostureSymbol headPosture = getHeadPostureAbsolutePosition(headSymbol);
		result.add(headPosture);

		if (headSymbol.hasEyes()) {
			collectPositionedEyesSymbol(result, headSymbol);
		}

		if (headSymbol.hasCheeks()) {
			collectPositionedCheeksSymbol(result, headSymbol);
		}

		if (headSymbol.hasMouth()) {
			collectPositionedMouthSymbol(result, headSymbol);
		}

		if (headSymbol.hasBreath()) {
			collectPositionedBreathSymbol(result, headSymbol);
		}

		if (headSymbol.hasExpression()) {
			collectPositionedExpressionSymbol(result, headSymbol);
		}

		if (headSymbol.hasHair()) {
			collectPositionedHairSymbol(result, headSymbol);
		}

		if (headSymbol.hasNeck()) {
			collectPositionedNeckSymbol(result, headSymbol);
		}

		if (headSymbol.hasNose()) {
			collectPositionedNoseSymbol(result, headSymbol);
		}

		if (headSymbol.hasEars()) {
			collectPositionedEarsSymbol(result, headSymbol);
		}

		if (headSymbol.hasJaw()) {
			collectPositionedJawSymbol(result, headSymbol);
		}

		normalizeToTheUpperLeftCorner(result);

		for (PositionedSymbol symbol : result) {
			// Adjust the head to the positioning according to the upper left
			// corner
			symbol.setX(symbol.getX() + xOffset);
			symbol.setY(symbol.getY() + yOffset);
			symbol.setZ(symbol.getZ() + zOffset);
		}

		assert result != null : "Postcondition failed: result != null";
		assert !result.isEmpty() : "Postcondition failed: !result.isEmpty()";
		return result;
	}

	private static void collectPositionedEyesSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert headSymbol.hasEyes() : "Precondition failed: headSymbol.hasEyes()";

		for (PositionedEyeSymbol symbol : headSymbol.getPositionedEyeSymbols()) {
			PositionedEyeSymbol positionedEyesSymbol = symbol.clone();

			int[] eyePosition = headSymbol.getRelativeEyeSymbolPosition(positionedEyesSymbol.getLocation(),
					positionedEyesSymbol.getWidth(), positionedEyesSymbol.getHeight());
			assert eyePosition != null : "Precondition failed: eyePosition != null";
			assert eyePosition.length == 3 : "Precondition failed: eyePosition.length == 3";

			positionedEyesSymbol.setX(eyePosition[0] + symbol.getX());
			positionedEyesSymbol.setY(eyePosition[1] + symbol.getY());
			positionedEyesSymbol.setZ(eyePosition[2] + symbol.getZ());

			assert !result
					.contains(positionedEyesSymbol) : "Postcondition failed: !result.contains(positionedEyesSymbol)";
			result.add(positionedEyesSymbol);
		}
	}

	private static void collectPositionedJawSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {

		List<PositionedJawSymbol> jawSymbols = headSymbol.getPositionedJawSymbols();

		for (PositionedJawSymbol currentSymbol : jawSymbols) {

			PositionedJawSymbol symbol = currentSymbol.clone();

			int[] jawPosition = headSymbol.getRelativeJawSymbolPosition(currentSymbol.getLocation(),
					currentSymbol.getWidth(), currentSymbol.getHeight());
			assert jawPosition != null : "Precondition failed: jawPosition != null";
			assert jawPosition.length == 3 : "Precondition failed: jawPosition.length == 3";

			symbol.setX(jawPosition[0] + currentSymbol.getX());
			symbol.setY(jawPosition[1] + currentSymbol.getY());
			symbol.setZ(jawPosition[2] + currentSymbol.getZ());
			result.add(symbol);
		}
	}

	private static void collectPositionedEarsSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {
		for (PositionedEarsSymbol ear : headSymbol.getPositionedEarSymbols()) {
			PositionedEarsSymbol positionedEarsSymbol = ear.clone();

			int[] earPosition = headSymbol.getRelativeEarSymbolPosition(ear.getLocation(), ear.getWidth(),
					ear.getHeight());
			assert earPosition != null : "Precondition failed: jawPosition != null";
			assert earPosition.length == 3 : "Precondition failed: jawPosition.length == 3";

			positionedEarsSymbol.setX(earPosition[0] + ear.getX());
			positionedEarsSymbol.setY(earPosition[1] + ear.getY());
			positionedEarsSymbol.setZ(earPosition[2] + ear.getZ());
			result.add(positionedEarsSymbol);
		}
	}

	private static void collectPositionedNoseSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {
		PositionedNoseSymbol positionedNoseSymbol = headSymbol.getPositionedNoseSymbol().clone();

		int[] nosePosition = headSymbol.getRelativeNoseSymbolPosition(positionedNoseSymbol.getWidth(),
				positionedNoseSymbol.getHeight());
		assert nosePosition != null : "Precondition failed: jawPosition != null";
		assert nosePosition.length == 3 : "Precondition failed: jawPosition.length == 3";

		positionedNoseSymbol.setX(nosePosition[0] + positionedNoseSymbol.getX());
		positionedNoseSymbol.setY(nosePosition[1] + positionedNoseSymbol.getY());
		positionedNoseSymbol.setZ(nosePosition[2] + positionedNoseSymbol.getZ());
		result.add(positionedNoseSymbol);
	}

	private static void collectPositionedNeckSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {
		PositionedNeckSymbol positionedNeckSymbol = headSymbol.getPositionedNeckSymbol().clone();

		int[] neckPosition = headSymbol.getRelativeNeckSymbolPosition(positionedNeckSymbol.getWidth(),
				positionedNeckSymbol.getHeight());
		assert neckPosition != null : "Precondition failed: jawPosition != null";
		assert neckPosition.length == 3 : "Precondition failed: jawPosition.length == 3";

		positionedNeckSymbol.setX(neckPosition[0] + positionedNeckSymbol.getX());
		positionedNeckSymbol.setY(neckPosition[1] + positionedNeckSymbol.getY());
		positionedNeckSymbol.setZ(neckPosition[2] + positionedNeckSymbol.getZ());
		result.add(positionedNeckSymbol);
	}

	private static void collectPositionedHairSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {

		PositionedHairSymbol positionedHairSymbol = headSymbol.getPositionedHairSymbol().clone();

		int[] hairPosition = headSymbol.getRelativeHairSymbolPosition(positionedHairSymbol.getWidth(),
				positionedHairSymbol.getHeight());
		assert hairPosition != null : "Precondition failed: jawPosition != null";
		assert hairPosition.length == 3 : "Precondition failed: jawPosition.length == 3";

		positionedHairSymbol.setX(hairPosition[0] + positionedHairSymbol.getX());
		positionedHairSymbol.setY(hairPosition[1] + positionedHairSymbol.getY());
		positionedHairSymbol.setZ(hairPosition[2] + positionedHairSymbol.getZ());
		result.add(positionedHairSymbol);
	}

	private static void collectPositionedExpressionSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {
		PositionedExpressionSymbol positionedExpressionSymbol = headSymbol.getPositionedExpressionSymbol().clone();

		int[] expressionPosition = headSymbol.getRelativeExpressionSymbolPosition(positionedExpressionSymbol.getWidth(),
				positionedExpressionSymbol.getHeight());

		positionedExpressionSymbol.setX(expressionPosition[0] + positionedExpressionSymbol.getX());
		positionedExpressionSymbol.setY(expressionPosition[1] + positionedExpressionSymbol.getY());
		positionedExpressionSymbol.setZ(expressionPosition[2] + positionedExpressionSymbol.getZ());
		result.add(positionedExpressionSymbol);
	}

	private static void collectPositionedBreathSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {
		for (PositionedBreathSymbol breath : headSymbol.getPositionedBreathSymbols()) {
			PositionedBreathSymbol positionedBreathSymbol = breath.clone();

			int[] breathPosition = headSymbol.getRelativeBreathSymbolPosition(breath.getLocation(), breath.getWidth(),
					breath.getHeight());

			positionedBreathSymbol.setX(breathPosition[0] + breath.getX());
			positionedBreathSymbol.setY(breathPosition[1] + breath.getY());
			positionedBreathSymbol.setZ(breathPosition[2] + breath.getZ());

			assert !result.contains(
					positionedBreathSymbol) : "Postcondition failed: !result.contains(positionedBreathSymbol)";

			result.add(positionedBreathSymbol);
		}
	}

	private static void collectPositionedMouthSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {
		PositionedMouthSymbol mouthSymbol = headSymbol.getPositionedMouthSymbol().clone();

		int[] mouthPosition = headSymbol.getRelativeMouthSymbolPosition(mouthSymbol.getWidth(),
				mouthSymbol.getHeight());

		mouthSymbol.setX(mouthPosition[0] + mouthSymbol.getX());
		mouthSymbol.setY(mouthPosition[1] + mouthSymbol.getY());
		mouthSymbol.setZ(mouthPosition[2] + mouthSymbol.getZ());
		result.add(mouthSymbol);
	}

	private static void collectPositionedCheeksSymbol(List<PositionedSymbol> result, HeadSymbol headSymbol) {
		for (PositionedCheekSymbol current : headSymbol.getPositionedCheekSymbols()) {
			PositionedCheekSymbol positionedCheeksSymbol = current.clone();

			int[] cheekPosition = headSymbol.getRelativeCheeksSymbolPosition(current.getLocation(), current.getWidth(),
					current.getHeight());

			positionedCheeksSymbol.setX(cheekPosition[0] + current.getX());
			positionedCheeksSymbol.setY(cheekPosition[1] + current.getY());
			positionedCheeksSymbol.setZ(cheekPosition[2] + current.getZ());
			result.add(positionedCheeksSymbol);
		}
	}

	private static PositionedHeadPostureSymbol getHeadPostureAbsolutePosition(HeadSymbol headSymbol) {
		PositionedHeadPostureSymbol headPostureSymbol = headSymbol.getPositionedHeadPostureSymbol().clone();
		int[] headPosturePosition = headSymbol.getRelativeHeadPosturePosition(headPostureSymbol.getWidth(),
				headPostureSymbol.getHeight());

		headPostureSymbol.setX(headPosturePosition[0] + headPostureSymbol.getX());
		headPostureSymbol.setY(headPosturePosition[1] + headPostureSymbol.getY());
		headPostureSymbol.setZ(headPosturePosition[2] + headPostureSymbol.getZ());

		return headPostureSymbol;
	}

	private static void normalizeToTheUpperLeftCorner(List<PositionedSymbol> result) {

		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;

		for (PositionedSymbol symbol : result) {
			minX = minX < symbol.getX() ? minX : symbol.getX();
			minY = minY < symbol.getY() ? minY : symbol.getY();
		}

		for (PositionedSymbol symbol : result) {
			symbol.setX(symbol.getX() - minX);
			symbol.setY(symbol.getY() - minY);
		}
	}

	private boolean belongTogether(PositionedSymbol positionable1, PositionedSymbol positionable2) {
		assert positionable1 != null : "Precondition failed: positionable1 != null";
		assert positionable2 != null : "Precondition failed: positionable2 != null";

		boolean result = false;

		int horizontalCenter1 = positionable1.getX() + positionable1.getWidth() / 2;
		int horizontalCenter2 = positionable2.getX() + positionable2.getWidth() / 2;

		int verticalCenter1 = positionable1.getY() + positionable1.getHeight() / 2;
		int verticalCenter2 = positionable2.getY() + positionable2.getHeight() / 2;

		Symbol symbol = ((PositionedSymbol) positionable2).getSymbol();

		if (CheeksBaseSymbol.isValidCheeksSymbol(symbol)) {
			result = (Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE
					&& positionable2.getX() >= positionable1.getX() && positionable2.getX() <= horizontalCenter1
					&& CheeksBaseSymbol.isLeftCheek(symbol))
					|| (Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE
							&& positionable2.getX() >= horizontalCenter1
							&& positionable2.getX() < (positionable1.getX() + positionable1.getWidth())
							&& CheeksBaseSymbol.isRightCheek(symbol));
		} else if (BreathBaseSymbol.isValidBreathSymbol(symbol)) {
			if (BreathBaseSymbol.isLeftBreathSymbol(symbol)) {
				int rightXOfPosSymbol2 = positionable2.getX() + positionable2.getWidth();

				result = rightXOfPosSymbol2 > positionable1.getX() && rightXOfPosSymbol2 < horizontalCenter1
						&& (Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE);

			} else if (BreathBaseSymbol.isRightBreathSymbol(symbol)) {
				result = positionable2.getX() < positionable1.getX() + positionable1.getWidth()
						&& (Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE);
			} else {
				int centerXOfPosSymbol1 = (positionable1.getX() + positionable1.getWidth()) / 2;
				int centerXOfPosSymbol2 = (positionable2.getX() + positionable2.getWidth()) / 2;

				result = Math.abs(centerXOfPosSymbol1 - centerXOfPosSymbol2) < HORIZONTAL_CENTER_TOLERANCE
						&& (Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE);
			}

		} else if (EarsBaseSymbol.isValidEarsSymbol(symbol)) {
			if (EarsBaseSymbol.isLeftEarSymbol(symbol)) {
				int rightXOfPosSymbol2 = positionable2.getX() + positionable2.getWidth();

				result = rightXOfPosSymbol2 > positionable1.getX() && rightXOfPosSymbol2 < horizontalCenter1
						&& (Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE);

			} else {
				// Must be a right Ear
				result = positionable2.getX() < positionable1.getX() + positionable1.getWidth()
						&& (Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE);
			}
		} else if (JawBaseSymbol.isValidJawSymbol(symbol)) {
			// check if it is the left jaw
			int rightXOfPosSymbol2 = positionable2.getX() + positionable2.getWidth();

			result = rightXOfPosSymbol2 > positionable1.getX() && rightXOfPosSymbol2 < horizontalCenter1
					&& (Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE);

		} else {
			result = Math.abs(horizontalCenter1 - horizontalCenter2) < HORIZONTAL_CENTER_TOLERANCE
					&& Math.abs(verticalCenter1 - verticalCenter2) < VERTICAL_CENTER_TOLERANCE;
		}

		return result;
	}

	private Location isLeftRightOrBothSymbol(PositionedSymbol positionedSymbol, boolean belongsToPreviousHeadSymbol,
			HeadSymbol previousHeadSymbol) {

		Location result = Location.BOTH;

		if (belongsToPreviousHeadSymbol) {
			int headCenterX = previousHeadSymbol.getX() + previousHeadSymbol.getRelativeHeadCenterPosition()[0];

			if (positionedSymbol.getX() + positionedSymbol.getWidth() < headCenterX) {
				result = Location.LEFT;
			} else if (positionedSymbol.getX() > headCenterX) {
				result = Location.RIGHT;
			}
		} else {
			if (previousHeadSymbol != null) {
				int nextHeadCenterX = previousHeadSymbol.getX() + previousHeadSymbol.getWidth()
						+ HeadSymbol.HEAD_CIRCLE_WIDTH / 2;
				if (positionedSymbol.getX() + positionedSymbol.getWidth() < nextHeadCenterX) {
					result = Location.LEFT;
				} else if (positionedSymbol.getX() > nextHeadCenterX) {
					result = Location.RIGHT;
				}
			}
		}

		return result;
	}

	private void updatePositionOfPositionedSymbol(PositionedSymbol positionedSymbolToUpdate, Location location,
			final PositionedSymbol referencePositionedSymbol, HeadSymbol headSymbol) {
		int[] relativeSymbolPosition = headSymbol.getRelativeSymbolPosition(positionedSymbolToUpdate.getSymbol(),
				location);
		int[] headCenter = headSymbol.getRelativeHeadCenterPosition();

		int absoluteHeadCenterPositionX = headSymbol.getX() + headCenter[0];
		int absoluteHeadCenterPositionY = headSymbol.getY() + headCenter[1];

		int xPosition = referencePositionedSymbol.getX() - (absoluteHeadCenterPositionX + relativeSymbolPosition[0]);
		int yPosition = referencePositionedSymbol.getY() - (absoluteHeadCenterPositionY + relativeSymbolPosition[1]);
		int zPosition = referencePositionedSymbol.getZ() - headSymbol.getZ() - relativeSymbolPosition[2];

		// Handle z Indexes which are coming from SignPuddle: They could be
		// lower than the standard values
		zPosition = Math.max(zPosition, 0);

		positionedSymbolToUpdate.setX(xPosition);
		positionedSymbolToUpdate.setY(yPosition);
		positionedSymbolToUpdate.setZ(zPosition);
	}

	private HeadSymbol createHeadSymbolRelativeToASymbol(Symbol symbol, int symbolX, int symbolY, int symbolZ,
			Location symbolLocation) {
		HeadSymbol newHeadSymbol = positionedSymbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 0, 0, 1);
		int[] newHeadCenter = newHeadSymbol.getRelativeHeadCenterPosition();
		int[] symbolHeadInternalPosition = newHeadSymbol.getRelativeSymbolPosition(symbol, symbolLocation);

		int xHeadPosition = symbolX - newHeadCenter[0] - symbolHeadInternalPosition[0];
		int yHeadPosition = symbolY - newHeadCenter[1] - symbolHeadInternalPosition[1];
		int zHeadPosition = symbolZ;

		newHeadSymbol.setX(xHeadPosition);
		newHeadSymbol.setY(yHeadPosition);
		newHeadSymbol.setZ(zHeadPosition);
		return newHeadSymbol;
	}
}
