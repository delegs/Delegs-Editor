package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public interface Token extends Serializable, Template {

	Id getId();

	long contentHashCode();

	Color getBackgroundColor();

	void setBackgroundColor(Color backgroundColor);

	boolean isEmpty();
}
