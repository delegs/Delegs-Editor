package de.signWritingEditor.client.badge.gwtClient.ui.widget;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import de.badge.client.gwtClient.ui.widget.BadgePanel;
import de.badge.shared.model.material.Badge;
import de.signWritingEditor.client.GWTClient.ui.general.animation.Animation.Listener;
import de.signWritingEditor.client.GWTClient.ui.general.animation.Animator;
import de.signWritingEditor.client.GWTClient.ui.general.animation.FadeWidgetAnimation;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPopupPanel;

public class BadgeReceivedPopupPanel extends ArrowPopupPanel {

	public BadgeReceivedPopupPanel(List<Badge> badges) {
		super(ArrowAlignment.ALIGN_RIGHT);
		assert badges != null : "Precondition failed: badges != null";
		assert badges.size() > 0 : "Precondition failed: badges.size() > 0";

		super.addStyleName("newBadgeReceivedPopupPanel");

		FlowPanel contentPanel = new FlowPanel();
		contentPanel.getElement().getStyle().setBackgroundColor("#ffffff");

		BadgePanel badgePanel = new BadgePanel(badges);
		badgePanel.getElement().getStyle().setProperty("margin", "auto");
		badgePanel.getElement().getStyle().setBackgroundColor("#ffffff");

		Label congratulationsLabel = new Label(I18N.getCongratulationsForReceivingNewBadges());
		congratulationsLabel.getElement().getStyle().setPadding(10, Unit.PX);
		congratulationsLabel.getElement().getStyle().setWidth(badgePanel.getWidthInPx(), Unit.PX);
		congratulationsLabel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		contentPanel.add(congratulationsLabel);

		contentPanel.add(badgePanel);

		super.add(contentPanel);

	}

	public void animateAndDestroy() {
		Animator.getInstance().addAnimation(this, new FadeWidgetAnimation(this, 0d, false, 20, 100, new Listener() {
			@Override
			public void onDone() {
				super.onDone();
				close();
			}
		}));
	}

}
