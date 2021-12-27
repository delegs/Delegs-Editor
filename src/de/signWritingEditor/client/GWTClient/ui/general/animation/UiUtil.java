package de.signWritingEditor.client.GWTClient.ui.general.animation;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

public class UiUtil {

	public static void setPixelWidth(Widget widget, int width) {
		assert widget != null : "Precondition failed: widget != null";

		int w = width;
		if (w < 0) {
			w = 0;
		}

		widget.setWidth(w + "px");

		// subtract padding etc., if need be
		if (widget.isAttached() && widget.getOffsetWidth() > w) {
			w += w - widget.getOffsetWidth();
			if (w < 0) {
				w = 0;
			}
			widget.setWidth(w + "px");
		}
	}

	public static void setPixelHeight(Widget widget, int height) {
		assert widget != null : "Precondition failed: widget != null";

		int h = height;
		if (h < 0) {
			h = 0;
		}

		widget.setHeight(h + "px");

		// subtract padding etc., if need be
		if (widget.isAttached() && widget.getOffsetHeight() > h) {
			h += h - widget.getOffsetHeight();
			if (h < 0) {
				h = 0;
			}
			widget.setHeight(h + "px");
		}
	}

	public static void setPixelSize(Widget widget, int width, int height) {
		setPixelWidth(widget, width);
		setPixelHeight(widget, height);
	}

	public static void setPixelPos(Widget widget, int x, int y) {
		assert widget != null : "Precondition failed: widget != null";
		assert widget
				.getParent() instanceof AbsolutePanel : "Precondition failed: widget.getParent() instanceof AbsolutePanel";

		AbsolutePanel absoluteParent = (AbsolutePanel) widget.getParent();

		absoluteParent.setWidgetPosition(widget, x, y);

		if (widget.isAttached() && widget.isVisible()) {
			// invisibility results in pos 0/0
			int actX = widget.getAbsoluteLeft() - absoluteParent.getAbsoluteLeft();
			int actY = widget.getAbsoluteTop() - absoluteParent.getAbsoluteTop();
			if (actX != x || actY != y) {
				x += x - actX;
				y += y - actY;
				absoluteParent.setWidgetPosition(widget, x, y);
			}
		}
	}

	public static void setOpacity(Widget widget, double opacity, boolean isAlwaysVisble) {
		assert widget != null : "Precondition failed: widget != null";
		assert opacity >= 0d : "Precondition failed: opacity >= 0d";
		assert opacity <= 1d : "Precondition failed: opacity <= 1d";

		String opacityStr = "" + opacity;
		int i = opacityStr.indexOf('.');
		if (i < 0) {
			opacityStr = opacityStr + ".0";
		} else {
			opacityStr = (opacityStr + "0").substring(0, i + 2);
		}
		DOM.setStyleAttribute(widget.getElement(), "opacity", "" + opacityStr);
		DOM.setStyleAttribute(widget.getElement(), "filter", "alpha(opacity=" + (int) (opacity * 100) + ")");

		widget.setVisible(isAlwaysVisble || (opacity > 0));
	}

	public native static void disableTextSelectInternal(Element e)/*-{
																	e.onselectstart = function() {
																	return false;
																	};
																	e.style.MozUserSelect = "none"
																	e.style.khtmlUserSelect = "none"
																	}-*/;
}
