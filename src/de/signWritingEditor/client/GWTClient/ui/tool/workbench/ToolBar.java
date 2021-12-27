package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.badge.client.gwtService.BadgeService;
import de.badge.client.gwtService.BadgeService.BadgesUpdatedListener;
import de.badge.shared.model.material.Badge;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel.ArrowAlignment;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPopupPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.InfoDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ButtonBar;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial.TutorialMainPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.RegisterUserDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.UserRegistrationValidator;
import de.signWritingEditor.client.badge.gwtClient.ui.widget.BadgeReceivedPopupPanel;
import de.signWritingEditor.client.service.CaptchaValidationServiceAsync;
import de.signWritingEditor.shared.i18n.I18NLocale;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.VersionNumber;
import de.signWritingEditor.shared.model.material.User;

public class ToolBar extends Composite {

	private static final String FLAG_BUTTON_STYLE = "flagButton";

	private static final int HELP_POPUP_BUTTON_MARGIN = 2;

	private static final String HELP_POPUP_WIDTH = "100px";

	private static final String INFO_WEBSITE = "http://www.wps.de/portfolio-items/delegs";

	private static final int UNDO_BUTTON_INDEX = 1;
	private static final int REDO_BUTTON_INDEX = 2;

	private static final int LANGUAGE_ICON_SIZE = 24;

	private SimplePanel buttonBarPanel;

	private LoginPanel loginPanel;
	private ToolBarButton changeToolButton;
	private ToolBarButton undoButton;
	private ToolBarButton redoButton;

	private FlowPanel mainPanel;

	private ArrowPopupPanel loginPopupPanel;
	private ToolBarButton userLoginAndProfileButton;
	private ProfilePanel profilePanel;

	private ArrowPopupPanel helpMenuPopupPanel;
	private Label welcomeLabel;
	private ToolBarButton helpMenuButton;
	private ToolBarButton messageMenuButton;

	private ArrowPopupPanel languageMenuePopupPanel;
	private ToolBarButton languageMenueButton;

	private Label notificationCountLabel;

	public ToolBar(BadgeService badgeService, final ToolBarListener toolBarListener,
			final CaptchaValidationServiceAsync captchaService, VersionNumber versionNumber,
			final int privacyPolicyVersionNumber, I18NLocale selectedLocale) {
		assert badgeService != null : "Precondition failed:  badgeService != null";
		assert toolBarListener != null : "Precondition failed:  toolBarListener != null";
		assert versionNumber != null : "Precondition failed: versionNumber != null";
		assert privacyPolicyVersionNumber >= 0 : "Precondition failed: privacyPolicyVersionNumber >= 0";
		assert captchaService != null : "Precondition failed: captchaService != null";

		mainPanel = new OrientedFlowPanel(Orientation.HORIZONTAL);
		initWidget(mainPanel);

		setStylePrimaryName("toolBar");

		changeToolButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconEmpty()),
				new Image(RESOURCE.getToolBarIconEmpty()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						toolBarListener.onChangeTool();
						event.stopPropagation();
					}
				});
		changeToolButton.ensureDebugId("toolBar-changeToolButton");
		mainPanel.add(changeToolButton);

		undoButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRotateCounterClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwiseDis()), I18N.getUndo(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						toolBarListener.onUndo();
					}
				});
		mainPanel.add(undoButton);

		redoButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRotateClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateClockwiseDis()), I18N.getRedo(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						toolBarListener.onRedo();
					}
				});
		mainPanel.add(redoButton);

		buttonBarPanel = new SimplePanel();
		mainPanel.add(buttonBarPanel);

		createHelpMenu();
		createLanguageMenu(toolBarListener, selectedLocale);
		createMessageMenu(toolBarListener);

		Image logo = createLogoWithToolTip(versionNumber);
		mainPanel.add(logo);

		loginPopupPanel = new ArrowPopupPanel(ArrowAlignment.ALIGN_RIGHT);
		loginPopupPanel.ensureDebugId("loginPopupPanel");

		loginPanel = new LoginPanel() {
			private RegisterUserDialogBox registerUserDialogBox;

			@Override
			public void onLogin() {
				toolBarListener.onLogin(this.getUsername(), this.getPassword());
				loginPopupPanel.close();
			}

			@Override
			protected void onRegisterUser() {
				registerUserDialogBox = createRegisterUserDialogBox(toolBarListener, captchaService);
				registerUserDialogBox.center();
				registerUserDialogBox.focusUsernameTextBox();
				loginPopupPanel.close();
			}

			private RegisterUserDialogBox createRegisterUserDialogBox(final ToolBarListener toolBarListener,
					final CaptchaValidationServiceAsync captchaService) {
				return new RegisterUserDialogBox(new UserRegistrationValidator()) {
					@Override
					public void handleRegisterUser(final String username, final String firstName, final String lastName,
							final String password, final String emailAddress, String userCaptcha) {
						captchaService.validateCaptcha(userCaptcha,
								new SignWritingCallback<Boolean>("Fehler bei Captcha-Validierung") {
									@Override
									public void onSuccess(Boolean captchaValid) {
										if (captchaValid) {
											toolBarListener.onRegisterUser(username, firstName, lastName, password,
													emailAddress, privacyPolicyVersionNumber);
											hide();
										} else {
											registerUserDialogBox.setCaptchaErrorVisible(true);
										}
									}
								});
					}
				};
			}

			@Override
			protected void onPasswordForgotten() {
				toolBarListener.onPasswordForgotten();
				loginPopupPanel.close();
			}

		};

		profilePanel = new ProfilePanel(badgeService) {
			@Override
			protected void onLogout() {
				toolBarListener.onLogout();
				loginPanel.switchToLoggedOutMode();
				loginPopupPanel.close();
			}
		};

		userLoginAndProfileButton = new ToolBarButton(new Image(RESOURCE.getUserIconImage()), "", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handleUserLoginAndProfileButtonClicked(event);
			}
		});
		userLoginAndProfileButton.addStyleName("floatRight");
		userLoginAndProfileButton.ensureDebugId("userLoginButton");
		mainPanel.add(userLoginAndProfileButton);

		badgeService.addBadgesUpdatedListener(new BadgesUpdatedListener() {

			@Override
			public void badgesUpdated(List<Badge> badgesThatReachedANewLevel, List<Badge> badgesThatUpdated) {
				assert badgesThatUpdated != null : "Precondition failed: badgesThatUpdated != null";
				assert badgesThatReachedANewLevel != null : "Precondition failed: badgesThatUpdated != null";

				if (badgesThatReachedANewLevel.size() > 0) {
					BadgeReceivedPopupPanel newBadgeReceivedPopupPanel = new BadgeReceivedPopupPanel(
							badgesThatReachedANewLevel);
					newBadgeReceivedPopupPanel.displayBelow(userLoginAndProfileButton);
					newBadgeReceivedPopupPanel.animateAndDestroy();
				}
			}
		});

		welcomeLabel = new Label();
		welcomeLabel.setStyleName("welcomeLabel");
		welcomeLabel.ensureDebugId("welcomeLabel");
	}

	public void informAboutLoggedInUser(User user) {
		profilePanel.switchToLoggedInMode(user);
	}

	public void informAboutLoggedOutUser() {
		profilePanel.switchToLoggedOutMode();
	}

	private void createHelpMenu() {
		createInfoMenuPopupPanel();

		helpMenuButton = new ToolBarButton(new Image(Resources.RESOURCE.getToolbarHelpIcon()), "", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				helpMenuPopupPanel.removeFromParent();
				helpMenuPopupPanel.displayBelow(helpMenuButton);
				if (languageMenuePopupPanel != null) {
					languageMenuePopupPanel.removeFromParent();
				}
				event.stopPropagation();
			}
		});

		helpMenuButton.getElement().getStyle().setProperty("borderLeft", "1px solid #aaa");
		helpMenuButton.getElement().getStyle().setFloat(Float.RIGHT);

		helpMenuButton.addHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				helpMenuButton.addStyleDependentName("hover");
			}
		}, MouseOverEvent.getType());

		helpMenuButton.addHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				helpMenuButton.removeStyleDependentName("hover");
			}
		}, MouseOutEvent.getType());

		mainPanel.add(helpMenuButton);
	}

	private void createLanguageMenu(ToolBarListener toolBarListener, I18NLocale selectedLocale) {
		createLanguageMenuPopupPanel(toolBarListener);

		Image languageSelectionIcon = null;
		switch (selectedLocale) {
		case DE:
			languageSelectionIcon = new Image(Resources.RESOURCE.getGermanFlagIconRound());
			break;
		case EN:
			languageSelectionIcon = new Image(Resources.RESOURCE.getEnglandFlagIconRound());
			break;
		case BR:
			languageSelectionIcon = new Image(Resources.RESOURCE.getBrazilFlagIconRound());
			break;
		case FR:
			languageSelectionIcon = new Image(Resources.RESOURCE.getFranceFlagIconRound());
			break;
		case ES:
			languageSelectionIcon = new Image(Resources.RESOURCE.getSpainFlagIconRound());
			break;
		default:
			languageSelectionIcon = new Image(Resources.RESOURCE.getEnglandFlagIconRound());
			break;
		}

		languageSelectionIcon.setPixelSize(LANGUAGE_ICON_SIZE, LANGUAGE_ICON_SIZE);
		languageMenueButton = new ToolBarButton(languageSelectionIcon, "", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				languageMenuePopupPanel.removeFromParent();
				languageMenuePopupPanel.displayBelow(languageMenueButton);

				if (helpMenuPopupPanel != null) {
					helpMenuPopupPanel.removeFromParent();
				}
				event.stopPropagation();
			}
		});

		languageMenueButton.getElement().getStyle().setProperty("borderLeft", "1px solid #aaa");
		languageMenueButton.getElement().getStyle().setFloat(Float.RIGHT);

		languageMenueButton.addHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				languageMenueButton.addStyleDependentName("hover");
			}
		}, MouseOverEvent.getType());

		languageMenueButton.addHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				languageMenueButton.removeStyleDependentName("hover");
			}
		}, MouseOutEvent.getType());

		mainPanel.add(languageMenueButton);
	}

	private void createLanguageMenuPopupPanel(ToolBarListener toolBarListener) {
		languageMenuePopupPanel = new ArrowPopupPanel(ArrowAlignment.ALIGN_RIGHT);
		OrientedFlowPanel languagePanel = new OrientedFlowPanel(Orientation.VERTICAL);
		OrientedFlowPanel upperPanel = new OrientedFlowPanel(Orientation.HORIZONTAL);
		OrientedFlowPanel lowerPanel = new OrientedFlowPanel(Orientation.HORIZONTAL);

		upperPanel.add(createLanguageButton(I18NLocale.DE, Resources.RESOURCE.getGermanFlagIconRound(),
				Resources.RESOURCE.getGermanFlagIconRoundHover(), Resources.RESOURCE.getGermanFlagIconRoundActive(),
				toolBarListener));
		upperPanel.add(createLanguageButton(I18NLocale.EN, Resources.RESOURCE.getEnglandFlagIconRound(),
				Resources.RESOURCE.getEnglandFlagIconRoundHover(), Resources.RESOURCE.getEnglandFlagIconRoundActive(),
				toolBarListener));
		upperPanel.add(createLanguageButton(I18NLocale.BR, Resources.RESOURCE.getBrazilFlagIconRound(),
				Resources.RESOURCE.getBrazilFlagIconRoundHover(), Resources.RESOURCE.getBrazilFlagIconRoundActive(),
				toolBarListener));
		lowerPanel.add(createLanguageButton(I18NLocale.FR, Resources.RESOURCE.getFranceFlagIconRound(),
				Resources.RESOURCE.getFranceFlagIconRoundHover(), Resources.RESOURCE.getFranceFlagIconRoundActive(),
				toolBarListener));
		lowerPanel.add(createLanguageButton(I18NLocale.ES, Resources.RESOURCE.getSpainFlagIconRound(),
				Resources.RESOURCE.getSpainFlagIconRoundHover(), Resources.RESOURCE.getSpainFlagIconRoundActive(),
				toolBarListener));

		upperPanel.getElement().setAttribute("align", "center");
		upperPanel.getElement().getStyle().setProperty("display", "flex");
		upperPanel.getElement().getStyle().setProperty("justifyContent", "center");
		lowerPanel.getElement().setAttribute("align", "center");
		lowerPanel.getElement().getStyle().setProperty("display", "flex");
		lowerPanel.getElement().getStyle().setProperty("justifyContent", "center");

		languagePanel.add(upperPanel);
		languagePanel.add(lowerPanel);
		languagePanel.getElement().getStyle().setBackgroundColor("#FFF");
		languagePanel.getElement().getStyle().setProperty("paddingBottom", "15px");

		languageMenuePopupPanel.add(languagePanel);
	}

	private Image createLanguageButton(final I18NLocale locale, final ImageResource imageResource,
			final ImageResource imageResourceHover, final ImageResource imageResourceActive,
			final ToolBarListener toolBarListener) {
		final Image imageButton = new Image(imageResource);
		imageButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				toolBarListener.onLanguageChanged(locale);
			}
		});

		imageButton.setStylePrimaryName(FLAG_BUTTON_STYLE);

		imageButton.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				imageButton.setResource(imageResourceHover);
			}
		});

		imageButton.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				imageButton.setResource(imageResource);
			}
		});

		imageButton.addMouseDownHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				imageButton.setResource(imageResourceActive);
			}
		});

		return imageButton;
	}

	private void createMessageMenu(final ToolBarListener toolBarListener) {
		assert toolBarListener != null : "Precondition failed: toolBarListener != null";

		messageMenuButton = new ToolBarButton(new Image(Resources.RESOURCE.getNotificationIcon()), "",
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						toolBarListener.onShowMessage();
					}
				});

		messageMenuButton.getElement().getStyle().setProperty("borderLeft", "1px solid #aaa");
		messageMenuButton.getElement().getStyle().setFloat(Float.RIGHT);
		messageMenuButton.getElement().getStyle().setProperty("paddingLeft", "10px");
		messageMenuButton.getElement().getStyle().setProperty("paddingTop", "6px");
		messageMenuButton.addHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				messageMenuButton.addStyleDependentName("hover");
			}
		}, MouseOverEvent.getType());

		messageMenuButton.addHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				messageMenuButton.removeStyleDependentName("hover");
			}
		}, MouseOutEvent.getType());

		mainPanel.add(messageMenuButton);

		SimplePanel notificationCountPanel = new SimplePanel();
		notificationCountLabel = new Label("");
		notificationCountLabel.getElement().getStyle().setProperty("textAlign", "-webkit-center");
		notificationCountLabel.getElement().getStyle().setProperty("textAlign", "center");
		notificationCountLabel.getElement().getStyle().setProperty("color", "white");
		notificationCountLabel.getElement().getStyle().setProperty("fontSize", "11px");
		notificationCountLabel.getElement().getStyle().setProperty("fontWeight", "bold");
		notificationCountLabel.getElement().getStyle().setProperty("paddingLeft", "1px");
		notificationCountLabel.getElement().getStyle().setProperty("paddingRight", "1px");
		notificationCountLabel.getElement().getStyle().setProperty("pointerEvents", "none");
		notificationCountPanel.add(notificationCountLabel);

		notificationCountPanel.getElement().getStyle().setProperty("minWidth", "14px");
		notificationCountPanel.getElement().getStyle().setProperty("height", "16px");
		notificationCountPanel.getElement().getStyle().setProperty("backgroundColor", "red");
		notificationCountPanel.getElement().getStyle().setProperty("float", "right");
		notificationCountPanel.getElement().getStyle().setProperty("position", "relative");
		notificationCountPanel.getElement().getStyle().setProperty("left", "41px");
		notificationCountPanel.getElement().getStyle().setProperty("top", "1px");
		notificationCountPanel.getElement().getStyle().setProperty("borderRadius", "3px");
		notificationCountPanel.getElement().getStyle().setProperty("pointerEvents", "none");

		messageMenuButton.getElement().insertFirst(notificationCountPanel.getElement());

		mainPanel.add(notificationCountPanel);

	}

	private void createInfoMenuPopupPanel() {
		final Command helpCmd = new Command() {
			@Override
			public void execute() {
				TutorialMainPanel tutorialWidget = new TutorialMainPanel(Unit.PX);
				new InfoDialogBox(tutorialWidget).center();
			}
		};

		final Command imprintCmd = new Command() {
			@Override
			public void execute() {
				HTML imprint = new HTML(I18N.getImprintText());
				ScrollPanel imprintPanel = new ScrollPanel(imprint);
				new InfoDialogBox(imprintPanel).center();
			}
		};

		final Command privacyPolicyCmd = new Command() {
			@Override
			public void execute() {
				HTML impressum = new HTML(I18N.getPrivacyPolicyText());
				ScrollPanel impressumPanel = new ScrollPanel(impressum);
				new InfoDialogBox(impressumPanel).center();
			}
		};

		helpMenuPopupPanel = new ArrowPopupPanel(ArrowAlignment.ALIGN_RIGHT);
		Button helpButton = new Button(I18N.getHelp());
		helpButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				helpCmd.execute();
				helpMenuPopupPanel.removeFromParent();
			}
		});

		Button imprintButton = new Button(I18N.getImprint());
		imprintButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				imprintCmd.execute();
				helpMenuPopupPanel.removeFromParent();
			}
		});

		Button privacyPolicyButton = new Button(I18N.getPrivacyPolicy());
		privacyPolicyButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				privacyPolicyCmd.execute();
				helpMenuPopupPanel.removeFromParent();
			}
		});

		Panel helpImprintAndPrivacyChooserPanel = new FlowPanel();
		helpImprintAndPrivacyChooserPanel.setWidth(HELP_POPUP_WIDTH);

		helpImprintAndPrivacyChooserPanel.add(helpButton);
		helpImprintAndPrivacyChooserPanel.add(imprintButton);
		helpImprintAndPrivacyChooserPanel.add(privacyPolicyButton);

		helpButton.getElement().getStyle().setMargin(HELP_POPUP_BUTTON_MARGIN, Unit.PX);
		helpButton.setWidth("100%");
		imprintButton.getElement().getStyle().setMargin(HELP_POPUP_BUTTON_MARGIN, Unit.PX);
		imprintButton.setWidth("100%");
		privacyPolicyButton.getElement().getStyle().setMargin(HELP_POPUP_BUTTON_MARGIN, Unit.PX);
		privacyPolicyButton.setWidth("100%");

		helpImprintAndPrivacyChooserPanel.getElement().getStyle().setBackgroundColor("#FFF");

		helpMenuPopupPanel.add(helpImprintAndPrivacyChooserPanel);
	}

	public void setButtonBar(ButtonBar buttonBar, int position) {
		assert buttonBar != null : "Precondition failed: buttonBar != null";
		assert position < mainPanel.getWidgetCount() : "Precondition failed: position < mainPanel.getWidgetCount()";

		buttonBarPanel.clear();
		buttonBarPanel.add(buttonBar);
		mainPanel.remove(buttonBarPanel);
		mainPanel.insert(buttonBarPanel, position);

	}

	public void switchToLoggedInMode(User user) {
		assert user != null : "Precondition failed: user != null";
		assert !user.isUnknown() : "Precondition failed: !user.isUnknown()";

		showWelcomeLabel(user);
		loginPanel.switchToLoggedInMode(user);
	}

	public void switchToLoggedOutMode() {
		hideWelcomeLabel();
		loginPanel.switchToLoggedOutMode();
	}

	public void setChangeToolButtonEnabled(boolean enabled) {
		changeToolButton.setEnabled(enabled);
	}

	public void setChangeToolButtonIcon(Image newIcon) {
		assert newIcon != null : "Precondition failed: newIcon != null";

		changeToolButton.setEnabledImage(newIcon);
	}

	public ToolBarButton getChangeToolButton() {
		assert changeToolButton != null : "Postcondition failed: result != null";
		return changeToolButton;
	}

	public void setUndoButtonEnabled(boolean enabled) {
		undoButton.setEnabled(enabled);
	}

	public void setRedoButtonEnabled(boolean enabled) {
		redoButton.setEnabled(enabled);
	}

	public void setUndoRedoButtonsVisibility(boolean visible) {
		if (visible) {
			if (mainPanel.getWidgetIndex(undoButton) == -1) {
				mainPanel.insert(undoButton, UNDO_BUTTON_INDEX);
			}
			if (mainPanel.getWidgetIndex(redoButton) == -1) {
				mainPanel.insert(redoButton, REDO_BUTTON_INDEX);
			}
		} else {
			mainPanel.remove(undoButton);
			mainPanel.remove(redoButton);
		}
	}

	private void handleUserLoginAndProfileButtonClicked(ClickEvent event) {
		if (!loginPopupPanel.isAttached()) {
			loginPopupPanel.remove(loginPanel);
			loginPopupPanel.remove(profilePanel);
			if (!loginPanel.isInLoggedInMode()) {
				loginPopupPanel.add(loginPanel);
				loginPanel.focusUsernameTextBox();
			} else {
				loginPopupPanel.add(profilePanel);
			}
			loginPopupPanel.displayBelow(userLoginAndProfileButton);

			event.stopPropagation();
		}
	}

	private void handleMouseOverWpsLogo(final PopupPanel versionPopupPanel, MouseOverEvent event) {
		assert versionPopupPanel != null : "Precondition failed: versionPopupPanel != null";
		assert event != null : "Precondition failed: event != null";

		// Reposition the popup relative to the button
		Widget source = (Widget) event.getSource();
		int left = source.getAbsoluteLeft();
		int top = source.getAbsoluteTop() + 30;
		versionPopupPanel.setPopupPosition(left, top);
		// Show the popup
		versionPopupPanel.show();
	}

	private Image createLogoWithToolTip(VersionNumber versionNumber) {
		assert versionNumber != null : "Precondition failed: versionNumber != null";

		Label versionLabel = new Label(I18N.getVersion() + ": " + versionNumber.toString());

		Image logo = new Image(RESOURCE.getWpsLogo());
		logo.ensureDebugId("toolbar-wpsLogo");
		logo.setStyleName("logo");
		logo.setAltText(versionLabel.getText());

		final PopupPanel versionPopupPanel = new PopupPanel(true);
		versionPopupPanel.ensureDebugId("toolbar-versionPopupPanel");
		versionPopupPanel.add(versionLabel);
		versionPopupPanel.setStylePrimaryName("versionToolTip");
		versionPopupPanel.setAnimationEnabled(false);

		logo.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				handleMouseOverWpsLogo(versionPopupPanel, event);
			}
		});

		logo.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				versionPopupPanel.hide();
			}
		});

		logo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.open(INFO_WEBSITE, "_blank", "");
			}
		});

		return logo;
	}

	protected void showWelcomeLabel(User user) {
		welcomeLabel.setText(I18N.getHello() + ", " + user.getFirstName() + " " + user.getLastName());
		mainPanel.add(welcomeLabel);
	}

	protected void hideWelcomeLabel() {
		mainPanel.remove(welcomeLabel);
	}

	public enum Direction {
		LEFT, RIGHT;
	}

	public interface ToolBarListener {
		void onChangeTool();

		void onLanguageChanged(I18NLocale locale);

		void onPasswordForgotten();

		void onLogin(String username, String password);

		void onLogout();

		void onRegisterUser(String username, String firstName, String lastName, String password, String emailAddress,
				int privacyPolicyVersionNumber);

		void onUndo();

		void onRedo();

		void onShowMessage();
	}

	public void setNotificationCount(Integer result) {
		if (result > 0) {
			notificationCountLabel.setText(result + "");
			notificationCountLabel.getParent().setVisible(true);
		} else {
			notificationCountLabel.getParent().setVisible(false);
		}
	}
}
