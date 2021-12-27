package de.signWritingEditor.shared.layout;

import de.signWritingEditor.shared.model.domainValue.Id;

public abstract class AbstractIdBox implements IdBox {

	private Id id;

	public AbstractIdBox(Id id) {
		assert id != null : "Precondition failed: id != null";
		this.id = id;
	}

	@Override
	public Id getId() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (!(obj instanceof AbstractIdBox)) {
			return false;
		} else if (id == null && ((AbstractIdBox) obj).getId() == null) {
			return true;
		} else if (id == null && !(((AbstractIdBox) obj).getId() == null)) {
			return false;
		} else if (((AbstractIdBox) obj).getId().equals(id)) {
			return true;
		} else {
			return false;
		}
	}

}
