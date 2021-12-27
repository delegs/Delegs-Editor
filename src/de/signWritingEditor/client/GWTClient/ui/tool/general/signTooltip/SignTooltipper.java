package de.signWritingEditor.client.GWTClient.ui.tool.general.signTooltip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.general.signTooltip.SignTooltip.ArrowDirection;
import de.signWritingEditor.shared.model.material.SignInfo;

public class SignTooltipper {

	private static final int BORDER_DIST = 2;
	private static final int AUTOSHOW_DELAY_INDEX = -3;

	private boolean isActive;

	private Map<String, SignInfo> signInfosById;
	private Map<String, Widget> widgetsById;
	private Map<String, ArrowDirection> arrowDirectionsById;

	private int autoshowIndex;
	private List<String> autoshowIds;

	private Widget tooltippedWidget;
	private SignTooltip signTooltip;

	public SignTooltipper(Map<String, SignInfo> signInfosById) {
		assert signInfosById != null : "Precondition failed: signInfosById != null";

		this.isActive = true;

		this.signInfosById = new HashMap<String, SignInfo>(signInfosById);
		this.widgetsById = new HashMap<String, Widget>();
		this.arrowDirectionsById = new HashMap<String, ArrowDirection>();

		this.autoshowIndex = AUTOSHOW_DELAY_INDEX;
		this.autoshowIds = new ArrayList<String>();

		this.tooltippedWidget = null;
		this.signTooltip = new SignTooltip();
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;

		if (!isActive) {
			signTooltip.hideImmediately();
		}

		autoshowIndex = AUTOSHOW_DELAY_INDEX;

		assert isActive() == isActive : "Postcondition failed: isActive() == isActive";
	}

	public SignTooltip getSignTooltip() {
		assert signTooltip != null : "Postcondition failed: result != null";
		return signTooltip;
	}

	public SignInfo getSignInfo(String contentId) {
		assert contentId != null : "Precondition failed: contentId != null";

		SignInfo result = signInfosById.get(contentId);
		if (result == null) {
			result = new SignInfo(contentId, "", 0, 0);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public boolean isRegistered(String contentId) {
		assert contentId != null : "Precondition failed: contentId != null";
		return widgetsById.containsKey(contentId);
	}

	public void addSignInfo(SignInfo signInfo) {
		assert signInfo != null : "Precondition failed: signInfo != null";

		this.signInfosById.put(signInfo.getContentId(), signInfo);
	}

	public void register(final String contentId, Widget tooltippedWidget, ArrowDirection tooltipArrowDirection) {
		assert contentId != null : "Precondition failed: contentId != null";
		assert tooltippedWidget != null : "Precondition failed: tooltippedWidget != null";
		assert tooltippedWidget instanceof HasMouseOverHandlers : "Precondition failed: tooltippedWidget instanceof HasMouseOverHandlers";
		assert tooltippedWidget instanceof HasMouseOutHandlers : "Precondition failed: tooltippedWidget instanceof HasMouseOutHandlers";
		assert tooltippedWidget instanceof HasMouseDownHandlers : "Precondition failed: tooltippedWidget instanceof HasMouseDownHandlers";
		assert tooltippedWidget instanceof HasBlurHandlers : "Precondition failed: tooltippedWidget instanceof HasBlurHandlers";

		assert tooltipArrowDirection != null : "Precondition failed: tooltipArrowDirection != null";
		assert !isRegistered(contentId) : "Precondition failed: !isRegistered(contentId)";

		MouseOverHandler mouseOverHandler = new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				onMouseOverWidget(contentId);
			}
		};
		((HasMouseOverHandlers) tooltippedWidget).addMouseOverHandler(mouseOverHandler);

		MouseOutHandler mouseOutHandler = new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				onMouseOutWidget(contentId);
			}
		};
		((HasMouseOutHandlers) tooltippedWidget).addMouseOutHandler(mouseOutHandler);

		MouseDownHandler mouseDownHandler = new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				onMouseDownWidget(contentId);

			}
		};
		((HasMouseDownHandlers) tooltippedWidget).addMouseDownHandler(mouseDownHandler);

		BlurHandler onBlurHandler = new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {
				onTooltipBlur(contentId);

			}

		};
		((HasBlurHandlers) tooltippedWidget).addBlurHandler(onBlurHandler);

		widgetsById.put(contentId, tooltippedWidget);
		arrowDirectionsById.put(contentId, tooltipArrowDirection);

		autoshowIds.add(contentId);

		assert isRegistered(contentId) : "Postcondition failed: isRegistered(contentId)";
	}

	protected void showSignTooltip(Widget widget, ArrowDirection arrowDirection, SignInfo signInfo) {
		assert widget != null : "Precondition failed: widget != null";
		assert signInfo != null : "Precondition failed: signInfo != null";

		if (!signInfo.isEmpty()) {
			int x = 0;
			int y = 0;
			if (ArrowDirection.UP.equals(arrowDirection)) {
				x = widget.getAbsoluteLeft();
				y = widget.getAbsoluteTop() + widget.getOffsetHeight() + BORDER_DIST;
			} else if (ArrowDirection.RIGHT.equals(arrowDirection)) {
				x = widget.getAbsoluteLeft() - BORDER_DIST;
				y = widget.getAbsoluteTop();
			} else if (ArrowDirection.DOWN.equals(arrowDirection)) {
				x = widget.getAbsoluteLeft();
				y = widget.getAbsoluteTop() - BORDER_DIST;
			} else {
				x = widget.getAbsoluteLeft() + widget.getOffsetWidth() + BORDER_DIST;
				y = widget.getAbsoluteTop();
			}
			signTooltip.show(x, y, arrowDirection, signInfo.getImageName(), signInfo.getWidth(), signInfo.getHeight());
		}
	}

	protected boolean isInside(Widget widget, int mouseX, int mouseY) {
		assert widget != null : "Precondition failed: widget != null";
		return mouseX >= widget.getAbsoluteLeft() && mouseY >= widget.getAbsoluteTop()
				&& mouseX < widget.getAbsoluteLeft() + widget.getOffsetWidth()
				&& mouseY < widget.getAbsoluteTop() + widget.getOffsetHeight();
	}

	protected void onMouseOverWidget(String contentId) {
		assert contentId != null : "Precondition failed: contentId != null";

		Widget widget = widgetsById.get(contentId);
		if (tooltippedWidget != widget) {
			tooltippedWidget = widget;
			SignInfo signInfo = signInfosById.get(contentId);
			showSignTooltip(widget, arrowDirectionsById.get(contentId), signInfo);
		}
	}

	protected void onMouseOutWidget(String contentId) {
		hideToolTip(contentId);
	}

	protected void onMouseDownWidget(String contentId) {
		hideToolTip(contentId);
	}

	protected void onTooltipBlur(String contentId) {
		hideToolTip(contentId);
	}

	protected void autoShowTooltips() {
		if (isActive) {
			if (autoshowIndex >= 0) {
				if (autoshowIndex > autoshowIds.size()) {
					autoshowIndex = 0;
				}

				String contentId = null;
				SignInfo signInfo = null;
				Widget widget = null;
				boolean canShow = false;
				while (!canShow && autoshowIndex < autoshowIds.size()) {
					contentId = autoshowIds.get(autoshowIndex);
					signInfo = signInfosById.get(contentId);
					if (signInfo != null && !signInfo.isEmpty()) {
						widget = widgetsById.get(contentId);
						canShow = tooltippedWidget != widget;
					}

					if (!canShow) {
						autoshowIndex++;
					}
				}

				if (canShow) {
					tooltippedWidget = widget;
					showSignTooltip(widget, arrowDirectionsById.get(contentId), signInfo);
				}
			}
			autoshowIndex++;
		}
	}

	private void hideToolTip(String contentId) {
		Widget widget = widgetsById.get(contentId);
		if (tooltippedWidget == widget) {
			tooltippedWidget = null;
			signTooltip.hide();
		}
	}
}
