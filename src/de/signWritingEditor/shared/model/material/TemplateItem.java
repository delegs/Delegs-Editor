package de.signWritingEditor.shared.model.material;

import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;

public class TemplateItem extends DocumentItem {

	private static final long serialVersionUID = 9191107091473021491L;
	private boolean isValid;

	public TemplateItem(Id id, String owner, FileTitle fileTitle, Date creation, Date change,
			FileItemColorLabel colorLabel, boolean isValid) {
		super(id, owner, fileTitle, creation, change, colorLabel);
		this.isValid = isValid;
	}

	@Deprecated
	protected TemplateItem() {
	}

	public boolean isValid() {
		return isValid;
	}

}
