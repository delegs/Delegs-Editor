package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard;

import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;

public class ParagraphFoundHandler implements ObjectFoundStorage<Section> {

	private Section targetSection;

	public ParagraphFoundHandler() {
		super();
		this.targetSection = new Section();
	}

	@Override
	public void process(Object object, boolean hasNext) {
		if (object instanceof Paragraph) {
			Paragraph paragraph = (Paragraph) object;
			targetSection.addParagraph(paragraph);
		}
	}

	@Override
	public Section getResult() {
		return targetSection;
	}
}