package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ButtonArrowPopupPanel;

public class UnsavedChangesPopupPanel extends ButtonArrowPopupPanel {

	private Button saveButton;
	private Button stayButton;
	private Button discardButton;

	public UnsavedChangesPopupPanel(final UnsavedChangesPanelListener listener) {
		super();

		saveButton = addButton(I18N.getSave(), DEFAULT_BUTTON_WIDTH, new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onSaveUnsavedChanges();
				close();
			}
		});

		discardButton = addButton(I18N.getDiscard(), DEFAULT_BUTTON_WIDTH, new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onDiscardUnsavedChanges();
				close();
			}
		});

		discardButton.ensureDebugId("workbench-arrowPopupPanel-discardButton");

		stayButton = addButton(I18N.getStayInEditor(), DEFAULT_BUTTON_WIDTH, new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				close();
			}
		});

		buttonPanel.getElement().getStyle().setProperty("display", "inline-flex");
	}

	public void setToStayOrDiscardChangesMode() {
		assert saveButton != null : "Precondition failed: saveButton != null";
		setPopupPanelText(I18N.getDoYouWantToDiscardTheChanges());
		buttonPanel.remove(saveButton);
		discardButton
				.setHTML("<image src='images/icon-back.png' style='margin:0px 10px 0px 0px'/>" + I18N.getDiscard());
		discardButton.getElement().getStyle().setPaddingTop(1.0, Unit.PX);
		if (!stayButton.isAttached()) {
			buttonPanel.insert(stayButton, 1);
		}
	}

	public void setToSaveOrDiscardChangesMode() {
		assert saveButton != null : "Precondition failed: saveButton != null";
		setPopupPanelText(I18N.getDoYouWantToSaveTheChanges());
		buttonPanel.remove(stayButton);
		discardButton.setHTML(I18N.getDiscard());
		discardButton.getElement().getStyle().setPaddingTop(3.0, Unit.PX);
		if (!saveButton.isAttached()) {
			buttonPanel.insert(saveButton, 0);
		}
	}

	public interface UnsavedChangesPanelListener {
		void onSaveUnsavedChanges();

		void onDiscardUnsavedChanges();
	}
}
