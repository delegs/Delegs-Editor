package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.layout.IdBox;
import de.signWritingEditor.shared.model.domainValue.Color;

public interface TokenBox extends IdBox {

	Color getBackgroundColor();

	boolean isLockedLayout();

	boolean isContentLocked();

}
