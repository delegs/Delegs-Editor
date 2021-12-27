package de.signWritingEditor.client.GWTClient.ui.tool.subtools.mobileComponents;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.Event;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ChangeAlternativeToolTip;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.SignSelectorPanel;
import de.signWritingEditor.shared.infrastructure.SignDataEncoder;
import de.signWritingEditor.shared.model.domainValue.Id;

public class SignSelectorPanelMobile extends SignSelectorPanel {
	private static final int TOOLTIP_SHOW_TIME_ON_TOUCH = 3000;

	@Override
	public void init(Id tokenId, SignDataEncoder signDataEncoder, ChangeAlternativeToolTip tooltip) {
		setToolTipPanelMobile(true);
		super.init(tokenId, signDataEncoder, tooltip);
		getToolTipPanel().getElement().getStyle().setPosition(Position.ABSOLUTE);
		// Adjust positioning for mobile devices since tooltippanel is bigger
		setToolTipLeft(-85);
		setToolTipTop(30);

		addHandler(new TouchStartHandler() {
			@Override
			public void onTouchStart(TouchStartEvent event) {
				if (!getSignItems().isEmpty()) {
					showToolTipPanel();
					getHideToolTipTimer().schedule(TOOLTIP_SHOW_TIME_ON_TOUCH);
				}
			}
		}, TouchStartEvent.getType());
		sinkEvents(Event.ONTOUCHSTART);
	}

	protected void initToolTipAltenativeButtonWidth() {
		getToolTipPanel().setWidth("70px");
	};

	@Override
	protected void showToolTipPanel() {
		getToolTipPanel().setVisible(true);
	}
}
