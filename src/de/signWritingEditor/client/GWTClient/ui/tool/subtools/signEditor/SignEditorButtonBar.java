package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ButtonBar;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;

public class SignEditorButtonBar extends ButtonBar {

	private ToolBarButton deleteSignButton;
	private ToolBarButton saveButton;
	private ToolBarButton saveAsButton;
	private ToolBarButton discardChangesButton;

	public SignEditorButtonBar(final SignSavePopupPanel signSavePopupPanel,
			final SignEditorButtonBarListener signEditorButtonBarListener) {
		super();

		deleteSignButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconDeleteSymbol()),
				new Image(RESOURCE.getToolBarIconDeleteSymbolDis()), I18N.getDelete(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						signEditorButtonBarListener.onDelete();
					}
				});
		deleteSignButton.ensureDebugId("signEditor-deleteSignButton");
		this.addWidget(deleteSignButton);

		saveButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconSave()),
				new Image(RESOURCE.getToolBarIconSaveDis()), I18N.getSave(), new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						boolean isAttached = signSavePopupPanel.isAttached();
						boolean isAlreadyAttachedToButton = isAttached
								&& signSavePopupPanel.getWidgetAbove().equals(saveButton);
						if (isAttached) {
							signSavePopupPanel.close();
						}
						if (!isAlreadyAttachedToButton) {
							signEditorButtonBarListener.onShowSaveDialogue();
							signSavePopupPanel.displayBelow(saveButton);
							event.stopPropagation();
						}
					}
				});

		this.addWidget(saveButton);

		saveAsButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconSaveAs()),
				new Image(RESOURCE.getToolBarIconSaveAsDis()), I18N.getSaveAs(), new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						boolean isAttached = signSavePopupPanel.isAttached();
						boolean isAlreadyAttachedToButton = isAttached
								&& signSavePopupPanel.getWidgetAbove().equals(saveAsButton);
						if (isAttached) {
							signSavePopupPanel.close();
						}
						if (!isAlreadyAttachedToButton) {
							signEditorButtonBarListener.onShowSaveAsDialogue();
							signSavePopupPanel.displayBelow(saveAsButton);
							event.stopPropagation();
						}
					}
				});
		this.addWidget(saveAsButton);
	}

	public void setDeleteSignButtonEnabled(boolean enabled) {
		deleteSignButton.setEnabled(enabled);
	}

	public void setSaveSignButtonEnabled(boolean enabled) {
		saveButton.setEnabled(enabled);
	}

	public interface SignEditorButtonBarListener {
		void onDelete();

		void onShowSaveDialogue();

		void onShowSaveAsDialogue();
	}
}
