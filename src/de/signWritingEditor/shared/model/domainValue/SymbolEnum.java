package de.signWritingEditor.shared.model.domainValue;

import java.util.List;

public interface SymbolEnum {
	Symbol getIswaSymbol();

	List<Integer> getValidFills();

	List<Integer> getValidRotationValues();

	List<SymbolRotation> getValidRotations();

	boolean canBeMirrored();
}
