package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard;

import de.signWritingEditor.shared.model.material.Paragraph;

public class ParagraphFoundStoreInListHandler extends DocumentPartsToCopyHandler {

	@Override
	public void process(Object object, boolean hasNext) {
		if (object instanceof Paragraph) {
			Paragraph paragraph = (Paragraph) object;
			documentPartsToCopy.add(paragraph);
		}
	}
}