package de.signWritingEditor.shared.model.domainValue;

import java.io.Serializable;

public class BaseSymbol implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaseSymbol(int category, int group, int symbol, int variation) {
		assert category >= 1 && category <= 99 : "Precondition failed: category >= 0 && category <= 99";
		assert group >= 1 && group <= 99 : "Precondition failed: group >= 0 && group <= 99";
		assert symbol >= 1 && symbol <= 999 : "Precondition failed: symbol >= 0 && symbol <= 999";
		assert variation >= 1 && variation <= 99 : "Precondition failed: variation >= 0 && variation <= 99";

		this.category = category;
		this.group = group;
		this.symbol = symbol;
		this.variation = variation;
	}

	/**
	 * The SignWriting alphabet is divided at its first level into categories.
	 * This is the index of a category within the alphabet.<br>
	 * Possible values are:
	 * <li>1. Hands</li>
	 * <li>2. Movement</li>
	 * <li>3. Dynamics & Timing</li>
	 * <li>4. Head & Face</li>
	 * <li>5. Body</li>
	 */
	private int category;
	private SymbolCategory symbolCategory;

	/**
	 * Each category has its groups. This is the index of a group within a
	 * category. This index is unique among the alphabet. Thus this is also the
	 * index of a group within the alphabet.
	 * 
	 * Possible values for nonIswaSymbols are:
	 * <li>1.</li>
	 */
	private int group;

	/**
	 * Each group has its symbols. This is the index of a symbol within a group.
	 * This index is only unique within its category.
	 */
	private int symbol;

	/**
	 * A symbol may have some variations, at least one. This is the index of a
	 * variation of a symbol. This index is only unique regarding the
	 * corresponding symbol.
	 * 
	 * A nonIswaSymbol may also have subcategories represented as variations.
	 */
	private int variation;

	public SymbolCategory getSymbolCategory() {
		symbolCategory = SymbolCategory.getCategoryForNumber(category);
		return symbolCategory;
	}

	public int getCategory() {
		return category;
	}

	public int getGroup() {
		return group;
	}

	public int getSymbol() {
		return symbol;
	}

	public int getVariation() {
		return variation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;

		int result = 1;

		result = prime * result + category;
		result = prime * result + group;
		result = prime * result + symbol;
		result = prime * result + variation;

		return result;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other == this;

		if (!result && other != null && other instanceof BaseSymbol) {
			BaseSymbol otherBaseSymbol = (BaseSymbol) other;

			result = this.category == otherBaseSymbol.category && this.group == otherBaseSymbol.group
					&& this.symbol == otherBaseSymbol.symbol && this.variation == otherBaseSymbol.variation;
		}

		return result;
	}

	/**
	 * Default constructor.
	 * 
	 * 
	 * @deprecated For serialization only.
	 */
	@Deprecated
	protected BaseSymbol() {
	}

	/**
	 * IswaSymbols have categories from one to seven. NonIswaSymbols start at a
	 * category of eight.
	 */
	public enum SymbolCategory {
		HAND(1), MOVEMENT(2), DYNAMICS(3), HEAD(4), BODY(5), LOCATION(6), PUNCTUATION(7);

		private int categoryNumber;

		private SymbolCategory(int categoryNumber) {
			this.categoryNumber = categoryNumber;
		}

		public int getCategoryNumber() {
			return categoryNumber;
		}

		public static SymbolCategory getCategoryForNumber(int categoryNumber) {
			SymbolCategory result = null;
			for (SymbolCategory category : SymbolCategory.values()) {
				if (category.getCategoryNumber() == categoryNumber) {
					result = category;
					break;
				}
			}

			return result;
		}
	}
}
