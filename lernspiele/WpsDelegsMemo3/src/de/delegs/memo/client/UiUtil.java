package de.delegs.memo.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

public class UiUtil {

	private static Boolean isMobileDevice = null;

	public static boolean isMobileDevice() {
		if (isMobileDevice == null) {
			isMobileDevice = isMobileDevice(Navigator.getUserAgent());
		}
		assert isMobileDevice != null;
		return isMobileDevice;
	}

	public static void putBackOnTop(AbsolutePanel panel, Widget widget) {
		assert panel != null : "Precondition failed: panel != null";
		assert widget != null : "Precondition failed: widget != null";

		panel.add(widget); // put back on top

		// workaround for GWT bug (position attribute is emptied when widget is removed from AbsolutePanel):
		widget.getElement().getStyle().setProperty("position", "relative");
	}

	public static void setTextShadow(Widget widget, int offsX, int offsY, int size, String optionalColor) {
		assert widget != null : "Precondition failed: widget != null";
		assert size >= 0 : "Precondition failed: size >= 0";

		if (size == 0 || optionalColor == null) {
			UiUtil.setCss3StyleAttribute(widget, "textShadow", "none");
		} else {
			UiUtil.setCss3StyleAttribute(widget, "textShadow", offsX + " " + offsY + " " + size + "px " + optionalColor);
		}
	}

	public static void setBoxShadow(Widget widget, int offsX, int offsY, int size, String optionalColor) {
		assert widget != null : "Precondition failed: widget != null";
		assert size >= 0 : "Precondition failed: size >= 0";

		if (size == 0 || optionalColor == null) {
			UiUtil.setCss3StyleAttribute(widget, "boxShadow", "none");
		} else {
			UiUtil.setCss3StyleAttribute(widget, "boxShadow", offsX + "px " + offsY + "px " + size + "px "
					+ optionalColor);
		}
	}

	public static void setBorderBox(Widget widget) {
		assert widget != null : "Precondition failed: widget != null";
		setCss3StyleAttribute(widget, "boxSizing", "border-box");
	}

	public static void setBorderRadius(Widget widget, int radius) {
		assert widget != null : "Precondition failed: widget != null";
		assert radius >= 0 : "Precondition failed: radius >= 0";
		setCss3StyleAttribute(widget, "borderRadius", radius + "px");
	}

	public static void setBorderRadius(Widget widget, int topLeftRadius, int topRightRadius, int bottomRightRadius,
			int bottomLeftRadius) {
		assert widget != null : "Precondition failed: widget != null";
		assert topLeftRadius >= 0 : "Precondition failed: topLeftRadius >= 0";
		assert topRightRadius >= 0 : "Precondition failed: topRightRadius >= 0";
		assert bottomRightRadius >= 0 : "Precondition failed: bottomRightRadius >= 0";
		assert bottomLeftRadius >= 0 : "Precondition failed: bottomLeftRadius >= 0";
		setCss3StyleAttribute(widget, "borderRadius", topLeftRadius + "px " + topRightRadius + "px "
				+ bottomRightRadius + "px " + bottomLeftRadius + "px");
	}

	public static void setRetinaBackgroundImage(Widget widget, ImageResource image, String otherCssBackgroundSettings) {
		assert widget != null : "Precondition failed: widget != null";
		assert image != null : "Precondition failed: image != null";
		assert otherCssBackgroundSettings != null : "Precondition failed: otherCssBackgroundSettings != null";
		Style style = widget.getElement().getStyle();
		style.setProperty("background", "url(" + image.getSafeUri().asString() + ") " + otherCssBackgroundSettings);
		style.setProperty("backgroundSize", (image.getWidth() / 2) + "px " + (image.getHeight() / 2) + "px");
	}

	public static void setTextOverflowEllipsis(Widget widget) {
		assert widget != null : "Precondition failed: widget != null";
		UiUtil.setCss3StyleAttribute(widget, "textOverflow", "ellipsis");
		widget.getElement().getStyle().setProperty("overflow", "hidden");
	}

	public static void setCss3StyleAttribute(Widget widget, String attr, String value) {
		assert widget != null : "Precondition failed: widget != null";
		assert attr != null : "Precondition failed: attr != null";
		assert attr.matches("[a-zA-Z0-9]+") : "Precondition failed: attr.matches(\"[a-zA-Z0-9]+\")";
		assert value != null : "Precondition failed: value != null";

		setStyleAttribute(widget, attr, value);

		setStyleAttribute(widget, concamelenate("Webkit", attr), value);
		setStyleAttribute(widget, concamelenate("Moz", attr), value);
		setStyleAttribute(widget, concamelenate("Ms", attr), value);
		setStyleAttribute(widget, concamelenate("O", attr), value);
	}

	public static void setLinearGradient(Widget widget, boolean isHorizontal, String... colors) {
		assert widget != null : "Precondition failed: widget != null";
		assert colors != null : "Precondition failed: colors != null";
		assert colors.length >= 2 : "Precondition failed: colors.length >= 2";

		Element element = widget.getElement();

		String colorList = "";
		for (int i = 0; i < colors.length; i++) {
			colorList += ", " + colors[i];
		}

		String value = "linear-gradient(" + (isHorizontal ? "left" : "top") + colorList + ")";

		element.getStyle().setProperty("backgroundImage", "-webkit-" + value);
		element.getStyle().setProperty("backgroundImage", "-moz-" + value);
		element.getStyle().setProperty("backgroundImage", "-ms-" + value);
		element.getStyle().setProperty("backgroundImage", "-o-" + value);
		element.getStyle().setProperty("backgroundImage", value);
	}

	/**
	 * @param widget
	 * @return
	 * @require widget != null
	 * @ensure result >= 0d
	 * @ensure result <= 1d
	 */
	public static double getOpacity(Widget widget) {
		assert widget != null : "Precondition failed: widget != null";

		double result = 0d;

		String opacityStr = widget.getElement().getStyle().getOpacity();
		if (opacityStr != null && !opacityStr.trim().isEmpty()) {
			result = trimOpacity(Double.parseDouble(opacityStr));
		} else if (widget.isVisible()) {
			result = 1d;
		}

		assert result >= 0d : "Postcondition failed: result >= 0d";
		assert result <= 1d : "Postcondition failed: result <= 1d";
		return result;
	}

	/**
	 * @param opacity
	 * @return an opacity value trimmed to fit between 0d and 1d
	 * @ensure result >= 0d
	 * @ensure result <= 1d
	 */
	public static double trimOpacity(double opacity) {
		double result = opacity;
		if (result < 0.01d) {
			result = 0d;
		} else if (result > 0.99d) {
			result = 1d;
		}
		assert result >= 0d : "Postcondition failed: result >= 0d";
		assert result <= 1d : "Postcondition failed: result <= 1d";
		return result;

	}

	/**
	 * @param widget
	 * @param opacity
	 * @param keepVisibility
	 *            fully transparent but not invisible, if opacity is zero
	 * @require widget != null
	 * @require opacity >= 0d
	 * @require opacity <= 1d
	 */
	public static void setOpacity(Widget widget, double opacity, boolean keepVisibility) {
		assert widget != null : "Precondition failed: widget != null";
		assert opacity >= 0d : "Precondition failed: opacity >= 0d";
		assert opacity <= 1d : "Precondition failed: opacity <= 1d";

		widget.getElement().getStyle().setProperty("opacity", formatCssFloatingPoint(opacity));
		widget.getElement().getStyle().setProperty("filter", "alpha(opacity=" + (int) (opacity * 100d) + ")");

		if (!keepVisibility && widget.isVisible() != opacity > 0d) {
			widget.setVisible(opacity > 0d);
		}
	}

	/**
	 * @param value
	 * @return a string representation of the value in the format ####.##
	 */
	public static String formatCssFloatingPoint(double value) {
		String result = Integer.toString((int) (value * 100));
		int length = result.length();
		if (length == 1) {
			result = "0.0" + result;
		} else if (length == 2) {
			result = "0." + result;
		} else {
			result = result.substring(0, length - 2) + "." + result.substring(length - 2);
		}
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public static String formatCount(int count, String singular, String plural) {
		assert count >= 0 : "Precondition failed: count >= 0";
		assert singular != null : "Precondition failed: singular != null";
		assert plural != null : "Precondition failed: plural != null";

		StringBuilder result = new StringBuilder();
		if (count == 1) {
			result.append("1 ").append(singular);
		} else {
			result.append(count).append(" ").append(plural);
		}
		assert result != null : "Postcondition failed: result != null";
		return result.toString();
	}

	public static int min(int... intValues) {
		assert intValues != null : "Precondition failed: intValues != null";
		int result = Integer.MAX_VALUE;
		for (int intValue : intValues) {
			if (result > intValue) {
				result = intValue;
			}
		}
		return result;
	}

	public static int max(int... intValues) {
		assert intValues != null : "Precondition failed: intValues != null";
		int result = Integer.MIN_VALUE;
		for (int intValue : intValues) {
			if (result < intValue) {
				result = intValue;
			}
		}
		return result;
	}

	public static long min(long... longValues) {
		assert longValues != null : "Precondition failed: longValues != null";
		long result = Long.MAX_VALUE;
		for (long longValue : longValues) {
			if (result > longValue) {
				result = longValue;
			}
		}
		return result;
	}

	public static long max(long... longValues) {
		assert longValues != null : "Precondition failed: longValues != null";
		long result = Long.MIN_VALUE;
		for (long longValue : longValues) {
			if (result < longValue) {
				result = longValue;
			}
		}
		return result;
	}

	public static native void cutRubberBand() /*-{
		document.ontouchstart = function(e) {
			e.preventDefault();
		}
	}-*/;

	// protected interface

	/**
	 * Concatenate camel case strings using camel case.
	 */
	protected static String concamelenate(String... camelCaseStrings) {
		assert camelCaseStrings != null : "Precondition failed: camelCaseStrings != null";
		assert camelCaseStrings.length > 0 : "Precondition failed: camelCaseStrings.length > 0";

		StringBuilder result = new StringBuilder();
		for (String string : camelCaseStrings) {
			assert string != null : "Precondition failed: camelCaseStrings[...] != null";
			assert string.matches("[a-zA-Z0-9]+") : "Precondition failed: string.matches(\"[a-zA-Z0-9]+\")";

			int pos = result.length();
			result.append(string); // keep existing camel case!!!
			result.setCharAt(pos, Character.toUpperCase(string.charAt(0)));
		}
		assert result != null : "Postcondition failed: result != null";
		return result.toString();
	}

	protected static void setStyleAttribute(Widget widget, String attr, String value) {
		assert widget != null : "Precondition failed: widget != null";
		assert attr != null : "Precondition failed: attr != null";
		assert value != null : "Precondition failed: value != null";

		// make it safe - better unstyled than incomplete
		try {
			widget.getElement().getStyle().setProperty(attr, value);
		} catch (Throwable e) {
			// nothing we can do here
			e.printStackTrace(); // inform developer
		}
	}

	protected static boolean isMobileDevice(String userAgent) {
		assert userAgent != null : "Precondition failed: userAgent != null";
		return userAgent.toLowerCase().matches(
				".*\\b(iphone|ipad|ipod|android|blackberry|playbook|kindle|windows phone|windows ce|opera mobi)\\b.*");
	}

}
