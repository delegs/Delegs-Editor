package de.signWritingEditor.client.model.material;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.HandBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class AbstractPositionedMovementSymbolTest<T extends PositionedSymbol> {

	protected SymbolFactory symbolFactory;
	protected Map<String, T> symbolMap = new HashMap<String, T>();
	protected Class<T> clazz;

	public AbstractPositionedMovementSymbolTest(Class<T> clazz) {
		this.clazz = clazz;
	}

	protected void addSymbol(String name, HandBaseSymbol handBaseSymbol) {
		addSymbol(name, handBaseSymbol.getIswaSymbol());
	}

	protected void addSymbol(String name, String iswaId) {
		Symbol symbol = symbolFactory.createSymbol(iswaId);
		addSymbol(name, symbol);
	}

	protected void addSymbol(String name, Symbol iswaSymbol) {
		T positionedMovementSymbol;
		try {
			positionedMovementSymbol = clazz.getConstructor(Symbol.class, int.class, int.class, int.class, Set.class)
					.newInstance(iswaSymbol, 0, 0, 2,
							symbolFactory.getAllRotationsAndFillsFor(iswaSymbol.getBaseSymbol()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		symbolMap.put(name, positionedMovementSymbol);
	}
}
