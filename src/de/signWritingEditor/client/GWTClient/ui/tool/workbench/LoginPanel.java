package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ImageButton;
import de.signWritingEditor.shared.model.material.User;

public abstract class LoginPanel extends Composite {
	private VerticalPanel contentPanel;
	private Label errorLabel;

	private PasswordTextBoxWithWatermark passwordTextBox;
	private TextBoxWithWatermark usernameTextBox;

	private ImageButton loginButton;

	private FlexTable formPanel;

	private Hyperlink registerLink;
	private Hyperlink passwordForgottenLink;

	private boolean isInLoggedInMode;

	public LoginPanel() {
		this(true);
	}

	public LoginPanel(boolean userCanRegister) {
		this(userCanRegister, "");
	}

	public LoginPanel(boolean userCanRegister, String errorMessage) {

		contentPanel = new VerticalPanel();

		contentPanel.addHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					event.stopPropagation();
				}
			}
		}, KeyDownEvent.getType());

		contentPanel.sinkEvents(Event.ONKEYDOWN);

		initWidget(contentPanel);

		errorLabel = new Label(errorMessage);
		errorLabel.setStyleName("loginPanelErrorLabel");
		contentPanel.add(errorLabel);

		formPanel = new FlexTable();
		contentPanel.add(formPanel);

		contentPanel.setStyleName("formDialogBox");
		contentPanel.addStyleName("loginPanel");
		contentPanel.addHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					onLogin();
				}
			}
		}, KeyUpEvent.getType());
		contentPanel.sinkEvents(Event.ONKEYUP);

		usernameTextBox = new TextBoxWithWatermark(I18N.getUserName());
		usernameTextBox.ensureDebugId("loginPanel-usernameTextBox");

		addInputField(I18N.getUserName(), usernameTextBox);

		passwordTextBox = new PasswordTextBoxWithWatermark(I18N.getPassword());
		passwordTextBox.ensureDebugId("loginPanel-passwordTextBox");

		addInputField(I18N.getPassword(), passwordTextBox);

		loginButton = new ImageButton(new Image(RESOURCE.getToolBarIconLogin()), I18N.getDoLogin(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onLogin();
			}
		});
		loginButton.ensureDebugId("loginPanel-loginButton");
		loginButton.addStyleName("floatRight");

		contentPanel.add(loginButton);

		if (userCanRegister) {
			registerLink = new Hyperlink(I18N.getRegister(), "");
			registerLink.addStyleName("floatRight");
			registerLink.addHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					handleRegisterUserButtonClicked();
				}

			}, ClickEvent.getType());
			contentPanel.add(registerLink);
		}

		passwordForgottenLink = new Hyperlink(I18N.getPasswordForgotten() + "?", "");
		passwordForgottenLink.addStyleName("floatRight");
		passwordForgottenLink.addHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				handlePasswordForgottenButtonClicked();
			}

		}, ClickEvent.getType());
		contentPanel.add(passwordForgottenLink);

		this.addHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
			}
		}, ClickEvent.getType());
		this.sinkEvents(Event.ONCLICK);
	}

	public void switchToLoggedInMode(User user) {
		assert user != null : "Precondition failed: user != null";

		contentPanel.clear();

		resetTextBoxesToWatermarks();

		isInLoggedInMode = true;
	}

	public void switchToLoggedOutMode() {
		contentPanel.clear();

		resetTextBoxesToWatermarks();

		contentPanel.add(formPanel);
		contentPanel.add(loginButton);
		if (registerLink != null) {
			contentPanel.add(registerLink);
		}
		contentPanel.add(passwordForgottenLink);

		isInLoggedInMode = false;
	}

	public boolean isInLoggedInMode() {
		return isInLoggedInMode;
	}

	public String getUsername() {
		return usernameTextBox.getText();
	}

	public String getPassword() {
		return passwordTextBox.getText();
	}

	protected abstract void onLogin();

	protected abstract void onRegisterUser();

	protected abstract void onPasswordForgotten();

	private void resetTextBoxesToWatermarks() {
		usernameTextBox.displayWatermark();
		passwordTextBox.displayWatermark();
	}

	private void handleRegisterUserButtonClicked() {
		onRegisterUser();
	}

	private void handlePasswordForgottenButtonClicked() {
		onPasswordForgotten();
	}

	protected void addInputField(String labelText, Widget input) {
		assert labelText != null : "Precondition failed: labelText != null";
		assert input != null : "Precondition failed: input != null";

		int newRowIndex = formPanel.getRowCount();

		Label label = new Label(labelText);
		formPanel.setWidget(newRowIndex, 0, label);

		formPanel.setWidget(newRowIndex, 1, input);

		input.addHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					// handleSubmit();
				}
			}
		}, KeyDownEvent.getType());
		input.sinkEvents(Event.ONKEYDOWN);
	}

	public void focusUsernameTextBox() {
		usernameTextBox.setSelectionRange(0, usernameTextBox.getText().length());
		usernameTextBox.setFocus(true);
	}

}
