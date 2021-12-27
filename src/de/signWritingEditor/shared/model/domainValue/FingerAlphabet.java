package de.signWritingEditor.shared.model.domainValue;

//TODO Zahlen
public enum FingerAlphabet {

	/**
	 * 01-99-999-* Defines the FingerAlphabet Symbols, all Symbols have the
	 * standard width and height of 30 but the actual width and height is
	 * calculated according to the symbol mappings. See:
	 * PositionedFingerAlphabetSymbols
	 */
	A(new Symbol(1, 99, 999, 1, 1, 1, 30, 30), new Symbol(1, 10, 3, 1, 3, 1, 20, 15)), //
	B(new Symbol(1, 99, 999, 2, 1, 1, 30, 30), new Symbol(1, 4, 4, 1, 3, 1, 14, 22)), //
	C(new Symbol(1, 99, 999, 3, 1, 1, 30, 30), new Symbol(1, 5, 34, 1, 2, 1, 17, 20)), //
	D(new Symbol(1, 99, 999, 4, 1, 1, 30, 30), new Symbol(1, 1, 2, 1, 2, 1, 16, 30)), //
	E(new Symbol(1, 99, 999, 5, 1, 1, 30, 30), new Symbol(1, 4, 7, 1, 3, 1, 15, 15)), //
	F(new Symbol(1, 99, 999, 6, 1, 1, 30, 30), new Symbol(1, 9, 2, 1, 3, 1, 22, 30)), //
	G(new Symbol(1, 99, 999, 7, 1, 1, 30, 30), new Symbol(1, 1, 1, 1, 1, 3, 30, 15)), //
	H(new Symbol(1, 99, 999, 8, 1, 1, 30, 30), new Symbol(1, 2, 8, 1, 1, 3, 30, 15)), //
	I(new Symbol(1, 99, 999, 9, 1, 1, 30, 30), new Symbol(1, 6, 13, 1, 3, 1, 21, 19)), //
	J(new Symbol(1, 99, 999, 10, 1, 1, 30, 30), new Symbol(1, 6, 13, 1, 3, 1, 21, 19),
			new Symbol(2, 6, 8, 1, 1, 13, 23, 28)), //
	K(new Symbol(1, 99, 999, 11, 1, 1, 30, 30), new Symbol(1, 3, 35, 1, 2, 1, 29, 30)), //
	L(new Symbol(1, 99, 999, 12, 1, 1, 30, 30), new Symbol(1, 9, 16, 1, 3, 1, 24, 30)), //
	M(new Symbol(1, 99, 999, 13, 1, 1, 30, 30), new Symbol(1, 6, 8, 1, 6, 1, 20, 25)), //
	N(new Symbol(1, 99, 999, 14, 1, 1, 30, 30), new Symbol(1, 2, 12, 1, 6, 1, 22, 26)), //
	O(new Symbol(1, 99, 999, 15, 1, 1, 30, 30), new Symbol(1, 5, 43, 1, 2, 1, 16, 16)), //
	P(new Symbol(1, 99, 999, 16, 1, 1, 30, 30), new Symbol(1, 3, 35, 1, 6, 8, 24, 31)), //
	Q(new Symbol(1, 99, 999, 17, 1, 1, 30, 30), new Symbol(1, 9, 36, 1, 6, 8, 23, 30)), //
	R(new Symbol(1, 99, 999, 18, 1, 1, 30, 30), new Symbol(1, 2, 13, 1, 3, 1, 15, 30)), //
	S(new Symbol(1, 99, 999, 19, 1, 1, 30, 30), new Symbol(1, 10, 15, 1, 3, 1, 15, 15)), //
	T(new Symbol(1, 99, 999, 20, 1, 1, 30, 30), new Symbol(1, 9, 38, 1, 2, 1, 30, 18)), //
	U(new Symbol(1, 99, 999, 21, 1, 1, 30, 30), new Symbol(1, 2, 8, 1, 3, 1, 15, 30)), //
	V(new Symbol(1, 99, 999, 22, 1, 1, 30, 30), new Symbol(1, 2, 1, 1, 3, 1, 15, 30)), //
	W(new Symbol(1, 99, 999, 23, 1, 1, 30, 30), new Symbol(1, 6, 2, 1, 3, 1, 18, 29)), //
	X(new Symbol(1, 99, 999, 24, 1, 1, 30, 30), new Symbol(1, 1, 7, 1, 2, 1, 15, 26)), //
	Y(new Symbol(1, 99, 999, 25, 1, 1, 30, 30), new Symbol(1, 6, 21, 1, 3, 1, 28, 20)), //
	Z(new Symbol(1, 99, 999, 26, 1, 1, 30, 30), new Symbol(1, 1, 1, 1, 3, 1, 15, 30),
			new Symbol(2, 3, 11, 1, 1, 11, 31, 18)), //
	Ä(new Symbol(1, 99, 999, 27, 1, 1, 30, 30), new Symbol(1, 10, 3, 1, 3, 1, 20, 15),
			new Symbol(2, 3, 3, 1, 1, 13, 26, 17)), //
	Ö(new Symbol(1, 99, 999, 28, 1, 1, 30, 30), new Symbol(1, 5, 43, 1, 2, 1, 16, 16),
			new Symbol(2, 3, 3, 1, 1, 13, 26, 17)), //
	Ü(new Symbol(1, 99, 999, 29, 1, 1, 30, 30), new Symbol(1, 2, 8, 1, 3, 1, 15, 30),
			new Symbol(2, 3, 3, 1, 1, 13, 26, 17)), //
	ß(new Symbol(1, 99, 999, 30, 1, 1, 30, 30), new Symbol(1, 10, 15, 1, 3, 1, 15, 15),
			new Symbol(2, 3, 3, 1, 1, 13, 26, 17)) //
	;

	private Symbol handSymbol;
	private Symbol movementSymbol;
	private Symbol iswaSymbol;

	private FingerAlphabet(Symbol baseSymbol, Symbol iswaSymbol, Symbol movementSymbol) {
		this.iswaSymbol = baseSymbol;
		this.handSymbol = iswaSymbol;
		this.movementSymbol = movementSymbol;
	}

	private FingerAlphabet(Symbol baseSymbol, Symbol iswaSymbol) {
		this.handSymbol = iswaSymbol;
		this.iswaSymbol = baseSymbol;
	}

	public Symbol getHandSymbol() {
		return handSymbol;
	}

	public Symbol getMovementSymbol() {
		return movementSymbol;
	}

	public Symbol getIswaSymbol() {
		return iswaSymbol;
	}

	public boolean hasMovement() {
		return getMovementSymbol() != null;
	}

	public static FingerAlphabet getFingerAlphabetSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		FingerAlphabet result = null;
		for (FingerAlphabet alphabetSymbol : FingerAlphabet.values()) {
			if (alphabetSymbol.getIswaSymbol().equals(symbol)) {
				result = alphabetSymbol;
				break;
			}
		}

		return result;
	}

}
