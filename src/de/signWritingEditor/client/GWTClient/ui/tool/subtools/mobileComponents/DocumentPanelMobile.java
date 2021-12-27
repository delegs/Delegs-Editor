package de.signWritingEditor.client.GWTClient.ui.tool.subtools.mobileComponents;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.TokenBoxWidgetFactory;

public class DocumentPanelMobile extends DocumentPanelImpl {
	@Override
	protected TokenBoxWidgetFactory getTokenBoxWidgetFactory() {
		if (tokenBoxWidgetFactory == null) {
			tokenBoxWidgetFactory = new TokenBoxWidgetFactory(true, urlConverter, eventTranslator, fontSizeService,
					visibilityToolTip, documentUiListener, documentPanelListener);
		}
		assert tokenBoxWidgetFactory != null : "Precondition failed: tokenBoxWidgetFactory != null";

		return super.getTokenBoxWidgetFactory();
	}
}
