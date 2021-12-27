package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;

public class ArrowSymbol extends Symbol {
	private static final long serialVersionUID = 2038075211771026844L;

	public final static int MIN_ARROW_RIGHT_ROTATION = 1;
	public final static int MAX_ARROW_RIGHT_ROTATION = 8;
	public final static int MIN_ARROW_LEFT_ROTATION = MAX_ARROW_RIGHT_ROTATION + 1;
	public final static int MAX_ARROW_LEFT_ROTATION = 16;

	protected ArrowSymbol(int group, int symbol, int variation, int fill, int rotation, int width, int height) {
		super(SymbolCategory.MOVEMENT.getCategoryNumber(), group, symbol, variation, fill, rotation, width, height);
		assert isArrow(group) : "Precondition failed: group != 1 || group != 2";
	}

	private static boolean isArrow(int group) {
		return group != 1 && group != 2;
	}

	public static boolean isValid(BaseSymbol symbol) {
		return SymbolCategory.MOVEMENT.getCategoryNumber() == symbol.getCategory() && isArrow(symbol.getGroup());
	}

	public boolean isRightArrow() {
		return getRotation() <= MAX_ARROW_RIGHT_ROTATION;
	}

	public boolean isLeftArrow() {
		return !isRightArrow();
	}

	/**
	 * For serialization only!
	 */
	@Deprecated
	protected ArrowSymbol() {
	}
}
