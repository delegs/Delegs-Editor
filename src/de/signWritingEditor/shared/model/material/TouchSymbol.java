package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;

public class TouchSymbol extends Symbol {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7945543903412006048L;

	protected TouchSymbol(int group, int symbol, int variation, int fill, int rotation, int width, int height) {
		super(SymbolCategory.MOVEMENT.getCategoryNumber(), group, symbol, variation, fill, rotation, width, height);
		assert isTouch(group) : "Precondition failed: group == 1 || group == 2";
	}

	private static boolean isTouch(int group) {
		return group == 1 || group == 2;
	}

	public static boolean isValid(BaseSymbol symbol) {
		return SymbolCategory.MOVEMENT.getCategoryNumber() == symbol.getCategory() && isTouch(symbol.getGroup());
	}

	/**
	 * For serialization only!
	 */
	@Deprecated
	protected TouchSymbol() {
	}
}