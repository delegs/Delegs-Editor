package de.signWritingEditor.client.service;

import java.util.Collection;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
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
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class SymbolGroupAnalyzer {

	public static boolean containsOnlyHeadSymbolsAndLegacyHeadSymbols(Collection<PositionedSymbol> selectedSymbols) {
		assert selectedSymbols != null : "Precondition failed: selectedSymbols != null";

		boolean result = !selectedSymbols.isEmpty();

		for (PositionedSymbol selectedSymbol : selectedSymbols) {
			if (!isHeadSymbol(selectedSymbol)) {
				result = false;
				break;
			}
		}

		return result;
	}

	public static boolean containsOnlyHeadSymbols(Collection<PositionedSymbol> selectedSymbols) {
		assert selectedSymbols != null : "Precondition failed: selectedSymbols != null";

		boolean result = !selectedSymbols.isEmpty();

		for (PositionedSymbol selectedSymbol : selectedSymbols) {
			if (!(selectedSymbol instanceof HeadSymbol)) {
				result = false;
				break;
			}
		}

		return result;
	}

	public static boolean containsOnlyASingleHandOrMovementSymbol(Collection<PositionedSymbol> selectedSymbols) {
		assert selectedSymbols != null : "Precondition failed: selectedSymbols != null";

		boolean result = selectedSymbols.size() == 1;

		if (result) {
			for (PositionedSymbol postionable : selectedSymbols) {
				if (postionable instanceof PositionedSymbol) {
					Symbol symbol = ((PositionedSymbol) postionable).getSymbol();
					result = SymbolCategoryAnalyzer.isHandSymbol(symbol)
							|| SymbolCategoryAnalyzer.isMovementSymbol(symbol)
							|| SymbolCategoryAnalyzer.isDynamicsSymbol(symbol);
				} else {
					result = false;
				}
			}
		}

		return result;
	}

	private static boolean isHeadSymbol(PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = symbol instanceof HeadSymbol;

		if (!result) {
			if (symbol instanceof PositionedSymbol) {
				PositionedSymbol positionedSymbol = (PositionedSymbol) symbol;

				result = isHeadSymbol(positionedSymbol.getSymbol());
			}
		}

		return result;
	}

	public static boolean isHeadSymbol(Symbol symbol) {
		return SymbolCategoryAnalyzer.isHeadSymbol(symbol);
	}

	public static boolean isArrowSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		int group = symbol.getGroup();

		return symbol.getCategory() == SymbolCategory.MOVEMENT.getCategoryNumber()
				&& (group != MovementBaseSymbol.MovementsSymbolGroups.TOUCH.getGroup()
						&& group != MovementBaseSymbol.MovementsSymbolGroups.FINGER_MOVEMENTS.getGroup());
	}

	public static boolean isTouchSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		int group = symbol.getGroup();

		return symbol.getCategory() == SymbolCategory.MOVEMENT.getCategoryNumber()
				&& (group == MovementBaseSymbol.MovementsSymbolGroups.TOUCH.getGroup());
	}

	public static boolean isHeadPostureSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return HeadPostureBaseSymbol.isValidHeadPostureSymbol(symbol);
	}

	public static boolean isEyesSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return EyesBaseSymbol.isValidEyesSymbol(symbol);
	}

	public static boolean isNoseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return NoseBaseSymbol.isValidNoseSymbol(symbol);
	}

	public static boolean isCheeksSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return CheeksBaseSymbol.isValidCheeksSymbol(symbol);
	}

	public static boolean isMouthSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return MouthBaseSymbol.isValidMouthSymbol(symbol);
	}

	public static boolean isEarsSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return EarsBaseSymbol.isValidEarsSymbol(symbol);
	}

	public static boolean isBreathSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return BreathBaseSymbol.isValidBreathSymbol(symbol);
	}

	public static boolean isJawSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return JawBaseSymbol.isValidJawSymbol(symbol);
	}

	public static boolean isNeckSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return NeckBaseSymbol.isValidNeckSymbol(symbol);
	}

	public static boolean isExpressionSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return ExpressionBaseSymbol.isValidExpressionSymbol(symbol);
	}

	public static boolean isHairSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return HairBaseSymbol.isValidHairSymbol(symbol);
	}

	public static boolean isHandOrMovementOrDynamicOrBodySymbol(PositionedSymbol postionable) {
		boolean result;
		if (postionable instanceof PositionedSymbol) {
			Symbol symbol = ((PositionedSymbol) postionable).getSymbol();
			result = SymbolCategoryAnalyzer.isHandSymbol(symbol) || SymbolCategoryAnalyzer.isMovementSymbol(symbol)
					|| SymbolCategoryAnalyzer.isDynamicsSymbol(symbol) || SymbolCategoryAnalyzer.isBodySymbol(symbol);
		} else {
			result = false;
		}
		return result;
	}

	public static boolean isFingerMovementSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		int group = symbol.getGroup();

		return symbol.getCategory() == SymbolCategory.MOVEMENT.getCategoryNumber()
				&& (group == MovementBaseSymbol.MovementsSymbolGroups.FINGER_MOVEMENTS.getGroup());
	}
}
