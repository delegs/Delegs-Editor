package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.general.widget.CheckBoxFiringMouseEvents;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ButtonBar;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;

public class DocumentEditorButtonBar extends ButtonBar {

	private final DocumentEditorButtonBarListener listener;
	private ToolBarButton newButton;
	private ToolBarButton saveButton;
	private ToolBarButton saveAsButton;
	private ToolBarButton pdfButton;
	private ToolBarButton prevDocButton;
	private ToolBarButton nextDocButton;
	private CheckBoxFiringMouseEvents searchWordLineVisibilityCheckbox;
	private CheckBoxFiringMouseEvents freetextLineVisibilityCheckbox;
	private CheckBoxFiringMouseEvents signVisibilityCheckbox;
	private CheckBoxFiringMouseEvents glossWritingCheckBox;
	private CheckBoxFiringMouseEvents automaticFreeTextLineCheckBox;
	private TokenCountPanel tokenCountPanel;

	public DocumentEditorButtonBar(TokenCountPanel tokenCountPanel, DocumentEditorButtonBarListener listener) {
		super();
		assert listener != null : "Precondition failed: listener != null";

		this.tokenCountPanel = tokenCountPanel;
		this.listener = listener;

		init();
	}

	public void setSaveButtonEnabled(boolean enabled) {
		saveButton.setEnabled(enabled);
	}

	public void setFreetextLineVisibilityCheckboxValue(boolean checked) {
		freetextLineVisibilityCheckbox.setValue(checked);
	}

	public void setSearchWordLineVisibilityCheckboxValue(boolean checked) {
		searchWordLineVisibilityCheckbox.setValue(checked);
	}

	public void setSignVisibilityCheckboxValue(boolean checked) {
		signVisibilityCheckbox.setValue(checked);
	}

	public void setGlossWritingCheckBoxValue(boolean checked) {
		glossWritingCheckBox.setValue(checked);
	}

	public void setAutomaticFreeTextLineCheckBoxValue(boolean automaticFreeTextLineCheckBox) {
		this.automaticFreeTextLineCheckBox.setValue(automaticFreeTextLineCheckBox);
	}

	private void init() {
		newButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconNewDocument()), I18N.getNewFile(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onOpenNewDocument();
					}
				});
		newButton.ensureDebugId("documentEditorButtonBar-newButton");
		addWidget(newButton);

		saveButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconSave()),
				new Image(RESOURCE.getToolBarIconSaveDis()), I18N.getSave(), new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onSaveDocument();
					}
				});
		saveButton.ensureDebugId("documentEditorButtonBar-saveButton");
		addWidget(saveButton);

		saveAsButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconSaveAs()), I18N.getSaveAs(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onSaveAsDocument();
					}
				});
		saveAsButton.ensureDebugId("documentEditorButtonBar-saveAsButton");

		addWidget(saveAsButton);

		pdfButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconPDF()), I18N.getDoCreatePdf(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onCreatePdf();
					}
				});
		pdfButton.ensureDebugId("documentEditorButtonBar-pdfButton");
		addWidget(pdfButton);

		prevDocButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconPreviousDocumentActive()),
				new Image(RESOURCE.getToolBarIconDocumentEditor()), I18N.getPrevDocument(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onPreviousDocument();

					}
				});
		prevDocButton.ensureDebugId("documentEditorButtonBar-prevDocButton");
		addWidget(prevDocButton);

		nextDocButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconNextDocumentActive()),
				new Image(RESOURCE.getToolBarIconNextDocument()), I18N.getNextDocument(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onNextDocument();
					}
				});
		nextDocButton.ensureDebugId("documentEditorButtonBar-nextDocButton");
		addWidget(nextDocButton);

		signVisibilityCheckbox = new CheckBoxFiringMouseEvents(I18N.getSignWritingLine());
		signVisibilityCheckbox.ensureDebugId("signVisibilityCheckbox");
		signVisibilityCheckbox.addStyleName("toolBarCheckbox");
		signVisibilityCheckbox.setValue(true);
		signVisibilityCheckbox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onToggleSignVisibility(signVisibilityCheckbox.getValue());
			}
		});
		addWidget(signVisibilityCheckbox);

		signVisibilityCheckbox = new CheckBoxFiringMouseEvents(I18N.getSignWritingLine());
		signVisibilityCheckbox.ensureDebugId("signVisibilityCheckbox");
		signVisibilityCheckbox.addStyleName("toolBarCheckbox");
		signVisibilityCheckbox.setValue(true);
		signVisibilityCheckbox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onToggleSignVisibility(signVisibilityCheckbox.getValue());
			}
		});
		addWidget(signVisibilityCheckbox);

		searchWordLineVisibilityCheckbox = new CheckBoxFiringMouseEvents(I18N.getSearchWordLine());
		searchWordLineVisibilityCheckbox.ensureDebugId("searchWordLineVisibilityCheckbox");
		searchWordLineVisibilityCheckbox.addStyleName("toolBarCheckbox");
		searchWordLineVisibilityCheckbox.setValue(true);
		searchWordLineVisibilityCheckbox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onToggleSearchWordVisibility(searchWordLineVisibilityCheckbox.getValue());
			}
		});
		addWidget(searchWordLineVisibilityCheckbox);

		freetextLineVisibilityCheckbox = new CheckBoxFiringMouseEvents(I18N.getFreetextVisibility());
		freetextLineVisibilityCheckbox.ensureDebugId("freetextLineVisibilityCheckbox");
		freetextLineVisibilityCheckbox.addStyleName("toolBarCheckbox");
		freetextLineVisibilityCheckbox.setValue(true);
		freetextLineVisibilityCheckbox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onToggleFreetextLineVisibility(freetextLineVisibilityCheckbox.getValue());
			}
		});
		addWidget(freetextLineVisibilityCheckbox);

		glossWritingCheckBox = new CheckBoxFiringMouseEvents(I18N.getGlossWriting());
		glossWritingCheckBox.addStyleName("toolBarCheckbox");
		glossWritingCheckBox.setValue(true);
		glossWritingCheckBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onToggleGlossWriting(glossWritingCheckBox.getValue());
			}
		});
		addWidget(glossWritingCheckBox);

		automaticFreeTextLineCheckBox = new CheckBoxFiringMouseEvents(I18N.getAutomaticFreeTextLine());
		automaticFreeTextLineCheckBox.addStyleName("toolBarCheckbox");
		automaticFreeTextLineCheckBox.setValue(true);

		automaticFreeTextLineCheckBox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				listener.onToggleAutomaticFreeTextLine(automaticFreeTextLineCheckBox.getValue());

			}
		});
		addWidget(automaticFreeTextLineCheckBox);

		addWidget(tokenCountPanel);
	}

	public void setPreviousButtonEnabled(boolean isPreviousEnabled) {
		prevDocButton.setEnabled(isPreviousEnabled);
	}

	public void setNextButtonEnabled(boolean isNextEnabled) {
		nextDocButton.setEnabled(isNextEnabled);
	}

	public interface DocumentEditorButtonBarListener {
		public void onOpenNewDocument();

		public void onToggleAutomaticFreeTextLine(boolean value);

		public void onSaveDocument();

		public void onSaveAsDocument();

		public void onCreatePdf();

		public void onPreviousDocument();

		public void onNextDocument();

		public void onToggleSearchWordVisibility(boolean visible);

		public void onToggleSignVisibility(boolean visible);

		public void onToggleFreetextLineVisibility(boolean visible);

		public void onToggleGlossWriting(boolean usingGlossenWriting);
	}
}
