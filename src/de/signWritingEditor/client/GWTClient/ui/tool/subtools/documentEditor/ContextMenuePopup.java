package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

public class ContextMenuePopup extends PopupPanel {

	private ContextMenueListener listener;
	private Button reportButton;

	public ContextMenuePopup(ContextMenueListener listener) {
		super(true);
		this.listener = listener;

		setStyleName("contextMenuePopupStyle");

		reportButton = new Button(I18N.getReportButtonTitle());
		reportButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ContextMenuePopup.this.listener.onReport();
			}
		});
		reportButton.setStyleName("reportContentButton");
		add(reportButton);
	}

	public interface ContextMenueListener {
		public void onReport();
	}
}
