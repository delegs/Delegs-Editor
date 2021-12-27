package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.workbench.LoginPanel;

public class LoginDialogBox extends ModalDialogBox {
	private LoginPanel loginPanel;

	public interface LoginDialogBoxListener {
		void onLogin(String username, String password);

		void onPasswordForgotten();

		void onClose();
	}

	@Deprecated
	private class CloseButton extends PushButton {

		public CloseButton() {
			this(new Image(Resources.RESOURCE.getCloseButtonIcon()));
		}

		private CloseButton(Image closeIcon) {
			super(closeIcon);

			setStyleName("closeButton");
			setPixelSize(closeIcon.getWidth(), closeIcon.getHeight());
			Style style = getElement().getStyle();
			style.setTop(0, Unit.PX);
			style.setRight(0, Unit.PX);
			style.setPosition(Position.ABSOLUTE);
			style.setPaddingTop(5, Unit.PX);
			style.setPaddingRight(5, Unit.PX);
		}
	}

	public LoginDialogBox(String title, final LoginDialogBoxListener loginDialogListener) {
		this(title, loginDialogListener, "");
	}

	public LoginDialogBox(String title, final LoginDialogBoxListener loginDialogListener, String errorMessage) {
		CloseButton closeButtonTop = new CloseButton();
		getCellElement(0, 0).appendChild(closeButtonTop.getElement());

		setText(title);
		setWidth("210px");

		VerticalPanel dialogPanel = new VerticalPanel();
		CloseButton closeButtonTopClickable = new CloseButton();
		dialogPanel.add(closeButtonTopClickable);
		dialogPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		dialogPanel.addHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					event.stopPropagation();
				}
			}
		}, KeyDownEvent.getType());

		dialogPanel.sinkEvents(Event.ONKEYDOWN);

		closeButtonTopClickable.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				loginDialogListener.onClose();
				hide();
			}
		});

		loginPanel = new LoginPanel(false, errorMessage) {

			@Override
			protected void onRegisterUser() {
			}

			@Override
			protected void onPasswordForgotten() {
				loginDialogListener.onPasswordForgotten();
				LoginDialogBox.this.hide();
			}

			@Override
			protected void onLogin() {
				loginDialogListener.onLogin(this.getUsername(), this.getPassword());
				LoginDialogBox.this.hide();
			}
		};
		dialogPanel.add(loginPanel);
		setWidget(dialogPanel);
	}

	@Override
	public void center() {
		super.center();
		setPopupPosition(getPopupLeft() + 50, getPopupTop());
	}

	public void setFocusUsernameTextBox() {
		loginPanel.focusUsernameTextBox();
	}
}
