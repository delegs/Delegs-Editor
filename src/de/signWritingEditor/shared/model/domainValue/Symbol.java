package de.signWritingEditor.shared.model.domainValue;

import java.io.Serializable;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.material.HeadSymbol;

/**
 * A symbol id corresponding to International SignWriting Alphabet. See
 * {@linkplain http://www.signbank.org/iswa/}
 * <p>
 * The representation matches the pattern "CC-GG-SSS-VV-FF-RR", where each
 * letter stands for a digit being part of an index. The mapping is as follows:
 * <li>C = category</li>
 * <li>G = group</li>
 * <li>S = symbol</li>
 * <li>V = variation</li>
 * <li>F = fill</li>
 * <li>R = rotation</li><br>
 */
public class Symbol implements Serializable {
	public static final Symbol HEAD_POSTURE_PLACEHOLDER_SYMBOL = new Symbol(4, 99, 999, 99, 1, 1,
			HeadSymbol.HEAD_CIRCLE_WIDTH, HeadSymbol.HEAD_CIRCLE_HEIGHT);
	public static final Symbol HEAD_WHITESPACE_SYMBOL = new Symbol(4, 99, 999, 98, 1, 1,
			HeadSymbol.HEAD_CIRCLE_WIDTH / 2, HeadSymbol.HEAD_CIRCLE_HEIGHT);
	public static final Symbol HEAD_COMPONENT_PLACEHOLDER_SYMBOL = new Symbol(4, 99, 999, 97, 1, 1,
			HeadSymbol.HEAD_CIRCLE_WIDTH / 2, HeadSymbol.HEAD_CIRCLE_HEIGHT);
	public static final Symbol JAW_PART_HEAD_RIM = new Symbol(4, 99, 999, 96, 1, 1, 14, 4);

	private static final long serialVersionUID = 4073979821140855505L;

	private BaseSymbol baseSymbol;

	/**
	 * A symbol has certain fills. The overall possible values are 1, 2, 3, 4,
	 * 5, 6. For each symbol the valid values are defined individually. This is
	 * the index of a fill.
	 */
	private int fill;

	/**
	 * A symbol has a certain rotation. The overall possible values are 1, 2, 3,
	 * 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16. For each symbol the valid
	 * values are defined individually. This is the index of a rotation.
	 */
	private int rotation;

	private int width;

	private int height;

	/**
	 * Creates a symbol using the given values (corresponding to ISWA 2010).<br>
	 * NOTE: There is no verification whether the single values result in a
	 * valid ID according to ISWA 2010.
	 */
	public Symbol(int category, int group, int symbol, int variation, int fill, int rotation, int width, int height) {
		assert category >= 1 && category <= 99 : "category >= 0 && category <= 99";
		assert group >= 1 && group <= 99 : "group >= 0 && group <= 99";
		assert symbol >= 1 && symbol <= 999 : "symbol >= 0 && symbol <= 999";
		assert variation >= 1 && variation <= 99 : "variation >= 0 && variation <= 99";
		assert fill >= 1 && fill <= 6 : "fill >= 1 && fill <= 6";
		assert rotation >= 1 && rotation <= 16 : "rotation >= 1 && rotation <= 16";
		assert width >= 0 : "Precondition failed: width >= 0";
		assert height >= 0 : "Precondition failed: height >= 0";

		baseSymbol = new BaseSymbol(category, group, symbol, variation);

		this.fill = fill;
		this.rotation = rotation;
		this.width = width;
		this.height = height;
	}

	public BaseSymbol getBaseSymbol() {
		assert baseSymbol != null : "Postcondition failed: result != null";
		return baseSymbol;
	}

	public int getCategory() {
		return getBaseSymbol().getCategory();
	}

	public int getGroup() {
		return getBaseSymbol().getGroup();
	}

	public int getSymbol() {
		return getBaseSymbol().getSymbol();
	}

	public int getVariation() {
		return getBaseSymbol().getVariation();
	}

	public int getFill() {
		return fill;
	}

	public int getRotation() {
		return rotation;
	}

	public int getWidth() {
		return width == 0 ? 40 : width;
	}

	public int getHeight() {
		return height;
	}

	public String getIswaId() {
		return Symbol.getIswaCode(getCategory(), getGroup(), getSymbol(), getVariation(), fill, rotation);
	}

	@Override
	public String toString() {
		return getIswaId();
	}

	@Override
	public int hashCode() {
		int result = 1;

		final int prime = 31;

		result = prime * result + baseSymbol.hashCode();
		result = prime * result + fill;
		result = prime * result + rotation;

		return result;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other == this;

		if (!result && other != null && other instanceof Symbol) {
			Symbol otherSymbol = (Symbol) other;

			result = this.baseSymbol.equals(otherSymbol.baseSymbol) && this.fill == otherSymbol.fill
					&& this.rotation == otherSymbol.rotation;
		}

		return result;
	}

	public static String getIswaCode(int category, int group, int symbol, int variation, int fill, int rotation) {
		return getNumberWithLeadingZeros(category, 2) + "-" + getNumberWithLeadingZeros(group, 2) + "-"
				+ getNumberWithLeadingZeros(symbol, 3) + "-" + getNumberWithLeadingZeros(variation, 2) + "-"
				+ getNumberWithLeadingZeros(fill, 2) + "-" + getNumberWithLeadingZeros(rotation, 2);
	}

	public static double getSymbolHeadOffset(Symbol symbol) {
		assert symbol != null : "Precondition failed: positionedSymbol != null";
		assert symbol.getCategory() == SymbolCategory.HEAD
				.getCategoryNumber() : "Precondition failed: positionedSymbol.getSymbol().getCategory() == Symbol.SymbolCategory.HEAD.getCategoryNumber()";

		return symbol.getHeight() - HeadSymbol.HEAD_CIRCLE_HEIGHT;
	}

	// protected

	/**
	 * Default constructor.
	 * 
	 * 
	 * @deprecated For serialization only.
	 */
	@Deprecated
	protected Symbol() {
	}

	/**
	 * Converts a number to a string. Using the full number of digits.
	 */
	private static String getNumberWithLeadingZeros(int number, int digits) {
		assert number >= 0 : "Precondition failed: number >= 0";
		assert digits > 0 : "Precondition failed: digits > 0";

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(number);

		while (stringBuilder.length() < digits) {
			stringBuilder.insert(0, "0");
		}

		return stringBuilder.toString();
	}
}
