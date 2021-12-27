package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.Tokenizer;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.TextbasedToken;
import de.signWritingEditor.shared.model.material.VideoToken;

public class ObjectToClipboardTextHandler implements ObjectFoundStorage<String> {

	private StringBuilder clipboardText;

	public ObjectToClipboardTextHandler() {
		this.clipboardText = new StringBuilder();
	}

	@Override
	public void process(Object object, boolean hasNext) {
		if (object instanceof TextbasedToken) {
			TextbasedToken textbasedToken = ((TextbasedToken) object);
			// Put space in between words
			clipboardText.append(textbasedToken.getText());
			if (hasNext) {
				clipboardText.append(" ");
			}
		} else if (object instanceof VideoToken) {
			VideoToken videoToken = ((VideoToken) object);
			// Put space in between words
			clipboardText.append(videoToken.getUrl());
			if (hasNext) {
				clipboardText.append(" ");
			}
		} else if (object instanceof ImageToken) {
			ImageToken imageToken = ((ImageToken) object);
			// Put space in between words
			clipboardText.append(imageToken.getUrl());
			if (hasNext) {
				clipboardText.append(" ");
			}
		} else if (object instanceof Paragraph) {
			if (hasNext) {
				clipboardText.append(Tokenizer.LINE_BREAK);
			}
		} else if (object instanceof Section) {
			if (hasNext) {
				clipboardText.append(Tokenizer.PAGE_BREAK);
			}
		}
	}

	@Override
	public String getResult() {
		return clipboardText.toString();
	}

}