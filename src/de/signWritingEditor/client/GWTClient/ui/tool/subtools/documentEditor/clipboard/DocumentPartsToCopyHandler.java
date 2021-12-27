package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard;

import java.util.ArrayList;
import java.util.List;

public abstract class DocumentPartsToCopyHandler implements ObjectFoundStorage<List<Object>> {

	protected List<Object> documentPartsToCopy;

	public DocumentPartsToCopyHandler() {
		super();
		this.documentPartsToCopy = new ArrayList<Object>();
	}

	@Override
	public List<Object> getResult() {
		return documentPartsToCopy;
	}
}