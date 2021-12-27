package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard;

import de.signWritingEditor.shared.model.material.Section;

public class SectionFoundHandler extends DocumentPartsToCopyHandler {

	@Override
	public void process(Object object, boolean hasNext) {
		if (object instanceof Section) {
			Section section = (Section) object;
			documentPartsToCopy.add(section);
		}
	}
}