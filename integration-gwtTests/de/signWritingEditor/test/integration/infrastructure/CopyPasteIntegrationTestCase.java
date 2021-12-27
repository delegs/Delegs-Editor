package de.signWritingEditor.test.integration.infrastructure;

import com.google.gwt.user.client.EventListener;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ExtendedRichTextArea;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSearchWordBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.PasteEvent;
import de.signWritingEditor.shared.model.material.Clipboard;

public abstract class CopyPasteIntegrationTestCase extends IntegrationTestCase {

	protected <T extends ExtendedRichTextArea & EventListener> void createPasteEvent(final String pastedString,
			T pasteTarget) {
		int currentCursorPosition = pasteTarget.getCursorPosition();

		PasteEvent pasteEvent = new PasteEvent();
		pasteEvent.setPastedText(pastedString);
		pasteEvent.setPositionInToken(currentCursorPosition);

		String text = pasteTarget.getText();
		StringBuilder sb = new StringBuilder(text);
		sb.insert(currentCursorPosition, pastedString);
		pasteTarget.setText(sb.toString());

		pasteTarget.fireEvent(pasteEvent);
	}

	protected native LayoutedSearchWordBox getLayoutedSearchWordBox(Object o)/*-{
																				return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget::searchWordBox;
																				}-*/;

	protected native ExtendedRichTextArea getTextAreaFromFreeTextTokenBoxWidget(Object o)/*-{
																							return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidgetBase::textArea
																							}-*/;

	protected native ExtendedRichTextArea getUrlTextBoxFromVideoTokenBoxWidget(Object o)/*-{
																						return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget::urlTextBox
																						}-*/;

	protected native ExtendedRichTextArea getCollageInvisibleTextArea(Object o)/*-{
																							return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.CollagePanel::invisibleTextArea
																							}-*/;

	protected native ExtendedRichTextArea getSnippetInvisibleTextArea(Object o)/*-{
																								return o.@de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::invisbleKeyHandlingTextArea
																								}-*/;

	protected native Clipboard getClipBoard(Object o)/*-{
														return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditor::clipboard
														}-*/;
}
