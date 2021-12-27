package de.signWritingEditor.shared.model.material;

import java.util.HashSet;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedHeadSymbol extends PositionedSymbol implements Cloneable {

	private static final long serialVersionUID = -3523045266096290481L;

	private Set<Symbol> validVariations;

	public PositionedHeadSymbol(int group, int symbol, int variation, int fill, int rotation, int width, int height,
			int x, int y, int z, Set<Symbol> validVariations) {
		super(new Symbol(SymbolCategory.HEAD.getCategoryNumber(), group, symbol, variation, fill, rotation, width,
				height), x, y, z);

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedHeadSymbol(Symbol symbol, int x, int y, int z, Set<Symbol> validVariations) {
		super(symbol, x, y, z);

		assert symbol != null : "Precondition failed: symbol != null";
		assert symbol.getCategory() == SymbolCategory.HEAD
				.getCategoryNumber() : "Precondition failed: symbol.getCategory() == SymbolCategory.HEAD.getCategoryNumber()";

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedHeadSymbol clone() {
		return new PositionedHeadSymbol(
				new Symbol(getSymbol().getCategory(), getSymbol().getGroup(), getSymbol().getSymbol(),
						getSymbol().getVariation(), getSymbol().getFill(), getSymbol().getRotation(),
						getSymbol().getWidth(), getSymbol().getHeight()),
				getX(), getY(), getZ(), new HashSet<Symbol>(validVariations));
	}

	@Override
	public BaseSymbol getBaseSymbol() {
		return getSymbol().getBaseSymbol();
	}

	@Override
	public boolean canManipulate() {
		return validVariations.size() > 1;
	}

	@Deprecated
	protected PositionedHeadSymbol() {

	}
}
