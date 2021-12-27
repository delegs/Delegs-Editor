package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.service.LocalSessionService;

public class TokenCountPanel extends FlowPanel {
	private LocalSessionService localSessionService;
	private HTML tokenCountLabel;
	private HTML maxTokenCountLabel;
	private HTML elementLabel;
	private SimplePanel infoToolTipPanel;
	private Image infoIcon;
	private InfoToolTip infoToolTip;

	private final int MAX_TOKEN_COUNT;

	public TokenCountPanel(int maxTokenCount, LocalSessionService localSessionService) {
		this.localSessionService = localSessionService;
		this.MAX_TOKEN_COUNT = maxTokenCount;
		tokenCountLabel = new HTML();
		elementLabel = new HTML(I18N.getElements());
		maxTokenCountLabel = new HTML("/ " + MAX_TOKEN_COUNT);

		infoToolTipPanel = new SimplePanel();
		infoIcon = new Image(Resources.RESOURCE.getInfoIcon());
		infoIcon.setPixelSize(15, 15);
		infoToolTipPanel.add(infoIcon);

		this.add(infoToolTipPanel);
		this.add(tokenCountLabel);
		this.add(maxTokenCountLabel);
		this.add(elementLabel);

		createToolTip();

		setStyleName("tokenCountPanel");
		addInfoIconListener();
	}

	private void createToolTip() {
		infoToolTip = new InfoToolTip();
		RootPanel.get().add(infoToolTip);
		infoToolTip.setText(I18N.getTokenCountInfoToolTipTextForUnknownUser());
		setToolTipPosition();
		infoToolTip.setVisible(false);
	}

	private void setToolTipPosition() {
		infoToolTip.setPosition(infoIcon.getAbsoluteLeft() - infoToolTip.getOffsetWidth(),
				infoIcon.getAbsoluteTop() + infoIcon.getOffsetHeight() / 2 - infoToolTip.getOffsetHeight() / 2);
	}

	private void addInfoIconListener() {
		infoIcon.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				infoIcon.setResource(Resources.RESOURCE.getInfoIconHover());
				infoToolTip.setVisible(true);
				setToolTipPosition();
			}
		});

		infoIcon.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				infoIcon.setResource(Resources.RESOURCE.getInfoIcon());
				infoToolTip.setVisible(false);
			}
		});
	}

	public void setTokenCount(int tokenCount) {
		tokenCountLabel.setHTML("" + tokenCount);

		tokenCountLabel.getElement().getStyle().setColor("black");
		tokenCountLabel.getElement().getStyle().setFontWeight(FontWeight.NORMAL);

		if (localSessionService.isCurrentUserUnknown()) {
			if (tokenCount >= MAX_TOKEN_COUNT) {
				tokenCountLabel.getElement().getStyle().setColor("#e90f0f");
				tokenCountLabel.getElement().getStyle().setFontWeight(FontWeight.BOLD);
			} else if (tokenCount >= MAX_TOKEN_COUNT * 0.99) {
				tokenCountLabel.getElement().getStyle().setColor("#ffae00");
				tokenCountLabel.getElement().getStyle().setFontWeight(FontWeight.BOLD);
			} else if (tokenCount >= MAX_TOKEN_COUNT * 0.9) {
				tokenCountLabel.getElement().getStyle().setColor("#c4a900");
				tokenCountLabel.getElement().getStyle().setFontWeight(FontWeight.BOLD);
			}
		}
	}

	public void switchToUnknownMode() {
		infoToolTip.setText(I18N.getTokenCountInfoToolTipTextForUnknownUser());
		maxTokenCountLabel.setVisible(true);
	}

	public void switchToLoggedInMode() {
		infoToolTip.setText(I18N.getTokenCountInfoToolTipTextForRegisteredUser());
		maxTokenCountLabel.setVisible(false);
	}
}
