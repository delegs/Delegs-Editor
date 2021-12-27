package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;

public interface CopyPasteListener {

	void onCopy();

	boolean onCut();

	void onPaste(Id pageId, String pastedText, PasteTarget pasteTarget);
}