package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ButtonArrowPopupPanel;
import de.signWritingEditor.shared.model.material.SignInfo;

public class SignSavePopupPanel extends ButtonArrowPopupPanel {
	private AbsolutePanel onlyDocumentPanel;
	private CheckBox onlyDocumentCheckbox;
	private AbsolutePanel commentPanel;
	private TextArea commentTextArea;
	private FlowPanel searchWordPanel;

	private Button saveButton;
	private Button saveAsButton;
	private TextBox searchWordTextBox;

	public SignSavePopupPanel(final SignSavePopupListener signSavePopupListener) {
		super();

		initSearchWordPanel();

		initOnlySaveInDocumentPanel();

		initCommentPanel();

		saveButton = addButton(I18N.getSave(), DEFAULT_BUTTON_WIDTH,
				new SignInfo("SaveSign", "images/save.png", 80, 46), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						signSavePopupListener.onSave();
						close();
					}
				});

		saveAsButton = addButton(I18N.getSaveAs(), DEFAULT_BUTTON_WIDTH,
				new SignInfo("SaveAsButtonTooltipForAuthors", "images/saveNew.png", 160, 80), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						signSavePopupListener.onSaveAs();
						close();
					}
				});

		addButton(I18N.getCancel(), DEFAULT_BUTTON_WIDTH,
				new SignInfo("AbortButtonTooltipForAuthorsInSaveAs", "images/discard.png", 50, 80), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						close();
					}
				});
	}

	public void setToSaveAsDialogue(boolean isAuthor, String defaultWord) {
		setPopupPanelText(I18N.getDoYouWantToSaveTheSignWithANewName());
		searchWordPanel.setVisible(true);
		searchWordTextBox.setText(defaultWord);
		saveButton.setVisible(false);
		saveAsButton.setVisible(true);
		onlyDocumentPanel.setVisible(isAuthor);
		onlyDocumentCheckbox.setValue(true);
		commentTextArea.setText("");
		commentPanel.setVisible(false);
	}

	public void setToSaveDialogue(boolean isAuthor, boolean isLocalSign) {
		setPopupPanelText(I18N.getDoYouWantToSaveTheChanges());
		searchWordPanel.setVisible(false);
		saveButton.setVisible(true);
		saveAsButton.setVisible(false);
		onlyDocumentPanel.setVisible(false);
		onlyDocumentCheckbox.setValue(false);
		commentTextArea.setText("");
		boolean showCommentPanel = isAuthor && !isLocalSign;
		commentPanel.setVisible(showCommentPanel);
	}

	private void initCommentPanel() {
		commentPanel = new AbsolutePanel();
		commentPanel.addStyleName("commentContainer");

		Label commentTextBoxLabel = new Label(I18N.getChangeComment() + ":");
		commentTextBoxLabel.addStyleName("commentTextBoxLabel");
		commentTextArea = new TextArea();

		commentTextArea.addStyleName("commentTextArea");
		commentTextArea.setCharacterWidth(30);
		commentTextArea.setVisibleLines(5);
		commentPanel.add(commentTextBoxLabel);
		commentPanel.add(commentTextArea);
		commentPanel.setVisible(false);

		commentTextArea.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
			}
		});
		mainPanel.insert(commentPanel, 3);
	}

	private void initOnlySaveInDocumentPanel() {
		onlyDocumentPanel = new AbsolutePanel();
		onlyDocumentPanel.addStyleName("onlyDocumentContainer");
		InlineLabel onlyDocumentLabel = new InlineLabel(I18N.getSaveInDocumentOnly());
		onlyDocumentLabel.addStyleName("onlyDocumentLabel");
		onlyDocumentCheckbox = new CheckBox();
		onlyDocumentPanel.add(onlyDocumentCheckbox);
		onlyDocumentPanel.add(onlyDocumentLabel);
		onlyDocumentCheckbox.setValue(true);
		onlyDocumentCheckbox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				commentPanel.setVisible(!onlyDocumentCheckbox.getValue());
				event.stopPropagation();
			}
		});

		onlyDocumentPanel.setVisible(false);
		mainPanel.insert(onlyDocumentPanel, 2);
	}

	private final void initSearchWordPanel() {
		searchWordPanel = new FlowPanel();
		searchWordTextBox = new TextBox();

		searchWordTextBox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
			}
		});

		searchWordTextBox.addKeyPressHandler(new KeyPressHandler() {

			public void onKeyPress(KeyPressEvent event) {
				if (event.getNativeEvent().getKeyCode() != KeyCodes.KEY_BACKSPACE
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_DELETE
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_LEFT
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_RIGHT
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_DOWN
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_UP
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_SHIFT
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_ENTER) {
					event.stopPropagation();

				}
			}

		});
		searchWordPanel.add(searchWordTextBox);
		searchWordPanel.setVisible(false);
		mainPanel.insert(searchWordPanel, 1);
	}

	public String getCommentText() {
		return commentTextArea.getText();
	}

	public String getSearchWordBoxText() {
		return searchWordTextBox.getText();
	}

	public boolean isLocalSaveModeEnabled() {
		return onlyDocumentCheckbox.getValue();
	}

	public boolean isCommentPanelVisible() {
		return commentPanel.isVisible();
	}

	public interface SignSavePopupListener {
		void onSave();

		void onSaveAs();
	}
}
