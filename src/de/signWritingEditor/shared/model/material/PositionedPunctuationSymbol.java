package de.signWritingEditor.shared.model.material;

import java.util.HashSet;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedPunctuationSymbol extends PositionedSymbol implements Cloneable {

	private static final long serialVersionUID = -3672406391831516927L;

	private Set<Symbol> validVariations;

	public PositionedPunctuationSymbol(int group, int symbol, int variation, int fill, int rotation, int width,
			int height, int x, int y, int z, Set<Symbol> validVariations) {
		super(new Symbol(SymbolCategory.PUNCTUATION.getCategoryNumber(), group, symbol, variation, fill, rotation,
				width, height), x, y, z);

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedPunctuationSymbol(Symbol symbol, int x, int y, int z, Set<Symbol> validVariations) {
		super(symbol, x, y, z);

		assert symbol != null : "Precondition failed: symbol != null";
		assert symbol.getCategory() == SymbolCategory.PUNCTUATION
				.getCategoryNumber() : "Precondition failed: symbol.getCategory() == SymbolCategory.PUNCTUATION.getCategoryNumber()";

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedPunctuationSymbol clone() {
		return new PositionedPunctuationSymbol(
				new Symbol(getSymbol().getCategory(), getSymbol().getGroup(), getSymbol().getSymbol(),
						getSymbol().getVariation(), getSymbol().getFill(), getSymbol().getRotation(),
						getSymbol().getWidth(), getSymbol().getHeight()),
				getX(), getY(), getZ(), new HashSet<Symbol>(validVariations));
	}

	@Deprecated
	protected PositionedPunctuationSymbol() {

	}

	@Override
	public BaseSymbol getBaseSymbol() {
		return getSymbol().getBaseSymbol();
	}

	@Override
	public boolean canManipulate() {
		return validVariations.size() > 1;
	}

	@Override
	public boolean canMirror() {
		return (canManipulate()
				&& PunctuationBaseSymbol.getPunctuationBaseSymbol(getSymbol().getBaseSymbol()).canBeMirrored());
	}

	@Override
	public boolean isValidFill(int fill) {
		return PunctuationBaseSymbol.getPunctuationBaseSymbol(getSymbol().getBaseSymbol()).getValidFills()
				.contains(fill);

	}

	@Override
	public boolean isValidRotation(int rotation) {
		return PunctuationBaseSymbol.getPunctuationBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues()
				.contains(rotation);
	}

	@Override
	public void setFillAndRotation(int fill, int rotation) {
		assert isValidRotation(rotation) : "Precondition failed: isValidRotation(rotation)";
		assert isValidFill(fill) : "Precondition failed: isValidFill(fill)";

		Symbol result = null;

		for (Symbol symbol : validVariations) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		setSymbol(result);
	}
}
