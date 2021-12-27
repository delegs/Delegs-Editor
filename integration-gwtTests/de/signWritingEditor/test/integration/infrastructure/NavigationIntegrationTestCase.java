package de.signWritingEditor.test.integration.infrastructure;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ExtendedRichTextArea;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSearchWordBox;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.Document;

public abstract class NavigationIntegrationTestCase extends IntegrationTestCase {

	protected static final int MAXIMAL_ACCEPTED_REACTION_TIME = 500;
	protected static final int PERIODIC_TEST_DELAY = 10;

	protected DocumentPanelImpl documentPanel;
	protected Document document;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		document = getGwtDocumentEditor().getDocument();
		documentPanel = (DocumentPanelImpl) getPanel(getGwtDocumentEditor());
		RootPanel.get().add(documentPanel);
	}

	@Override
	protected void gwtTearDown() throws Exception {
		RootPanel.get().remove(documentPanel);
		super.gwtTearDown();
	}

	protected native ExtendedRichTextArea getExtendedRichTextAreaFromVideo(Object o)/*-{
																					return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget::urlTextBox;
																					}-*/;

	protected native ExtendedRichTextArea getExtendedRichTextAreaFromImage(Object o)/*-{
																					return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ImageTokenBoxWidget::urlTextBox;
																					}-*/;

	protected native ExtendedRichTextArea getExtendedRichTextAreaFromFreeTextToken(Object o)/*-{
																							return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidgetBase::textArea;
																							}-*/;

	protected native TextArea getTextAreaFromFrameToken(Object o)/*-{
																	return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FrameTokenBoxWidgetBase::invisbleKeyHandlingTextArea;
																	}-*/;

	protected native LayoutedSearchWordBox getLayoutedSearchWordBox(Object o)/*-{
																				return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget::searchWordBox;
																				}-*/;

	protected void createKeyDownEvent(boolean ctrl, boolean alt, boolean shift, boolean meta, int keyCode,
			HasHandlers handlerSource) {
		NativeEvent event = com.google.gwt.dom.client.Document.get().createKeyDownEvent(ctrl, alt, shift, meta,
				keyCode);
		DomEvent.fireNativeEvent(event, handlerSource);
	}

	public class NavigationCompletionTimer extends Timer {

		private Object expectedId;

		public NavigationCompletionTimer(Id expected) {
			this.expectedId = expected;
		}

		@Override
		public void run() {
			if (getCurrentCursorTokenId(getGwtDocumentEditor()).equals(expectedId)) {
				finishTest();
				this.cancel();
			}
		}
	}

}
