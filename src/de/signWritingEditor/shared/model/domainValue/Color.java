package de.signWritingEditor.shared.model.domainValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Color implements Serializable {

	private static final long serialVersionUID = 3818078382950095281L;

	public static final Color BLACK = Color.makeFromRGB(0, 0, 0);
	public static final Color WHITE = Color.makeFromRGB(255, 255, 255);
	public static final Color GREY = Color.makeFromRGB(238, 238, 238);
	public static final Color LIGHT_GREY = Color.makeFromRGB(128, 128, 128);

	// StandardColors
	public static final Color RED = Color.makeFromHSV(0, 100, 100);
	public static final Color DARK_RED = Color.makeFromHSV(0, 100, 75);
	public static final Color ORANGE = Color.makeFromHSV(45, 100, 100);
	public static final Color YELLOW = Color.makeFromHSV(60, 100, 100);
	public static final Color LIGHT_GREEN = Color.makeFromHSV(89, 61, 81);
	public static final Color GREEN = Color.makeFromHSV(147, 100, 69);
	public static final Color LIGHT_BLUE = Color.makeFromHSV(196, 100, 94);
	public static final Color BLUE = Color.makeFromHSV(205, 100, 75);
	public static final Color DARK_BLUE = Color.makeFromHSV(220, 100, 37);
	public static final Color PURPLE = Color.makeFromHSV(274, 70, 62);

	// DesignColors
	public static final Color BEIGE = Color.makeFromHSV(50, 5, 95);
	public static final Color NAVIBLUE = Color.makeFromHSV(215, 75, 50);
	public static final Color SKYBLUE = Color.makeFromHSV(210, 60, 75);
	public static final Color OLDPINK = Color.makeFromHSV(0, 60, 75);
	public static final Color GRASSGREEN = Color.makeFromHSV(80, 55, 75);
	public static final Color LAVENDER = Color.makeFromHSV(265, 35, 65);
	public static final Color CYAN = Color.makeFromHSV(190, 65, 75);
	public static final Color GOLDENYELLOW = Color.makeFromHSV(25, 70, 95);

	private int argb;

	@Deprecated
	private Color() {
	}

	private Color(int argb) {
		this.argb = argb;
	}

	private Color(int r, int g, int b) {
		this(r, g, b, 255);
	}

	private Color(int r, int g, int b, int a) {
		assert r >= 0 && r <= 255 : r;
		assert g >= 0 && g <= 255 : g;
		assert b >= 0 && b <= 255 : b;
		assert a >= 0 && a <= 255 : a;

		argb = a << 24 | r << 16 | g << 8 | b;
	}

	public static Color makeFromRGB(int red, int green, int blue) {
		return new Color(red, green, blue, 255);
	}

	public static Color makeFromRGBA(int red, int green, int blue, int alpha) {
		return new Color(red, green, blue, alpha);
	}

	public static Color makeFromARGB(int argb) {
		return new Color(argb);
	}

	public static Color makeFromCssString(String css) {
		assert css != null : "Precondition failed: css != null";
		assert css.length() == 7 : "Precondition failed: css.length() == 7";
		assert css.charAt(0) == '#' : "Precondition failed: css.charAt(0) == '#'";

		int rgb = Integer.parseInt(css.substring(1), 16);
		return new Color(0xff000000 | rgb);
	}

	public static Color makeFromHSV(double hue, double saturation, double value) {
		return createColorFromHSV(hue, saturation, value);
	}

	public String getCssValue() {
		return "#" + hex(5) + hex(4) + hex(3) + hex(2) + hex(1) + hex(0);
	}

	public int getRed() {
		return (argb >>> 16) & 255;
	}

	public int getGreen() {
		return (argb >>> 8) & 255;
	}

	public int getBlue() {
		return argb & 255;
	}

	public int getAlpha() {
		return argb >>> 24;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Color && argb == ((Color) obj).argb;
	}

	@Override
	public int hashCode() {
		return argb;
	}

	@Override
	public String toString() {
		return "Color [argb=" + hex(7) + hex(6) + hex(5) + hex(4) + hex(3) + hex(2) + hex(1) + hex(0) + "]";
	}

	private String hex(int position) {
		return HEX_DIGITS[(argb >>> (4 * position)) & 15];
	}

	private static final String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
			"E", "F" };

	public static Color makeBlendColor(Color baseColor, Color blendColor, double alpha) {
		assert alpha > 0 && alpha <= 1 : "Precondition failed: alpha > 0 && alpha <= 1";
		assert baseColor != null : "Precondition failed: baseColor != null";
		assert blendColor != null : "Precondition failed: blendColor != null";

		int newR = (int) (alpha * blendColor.getRed() + (1 - alpha) * baseColor.getRed());
		int newG = (int) (alpha * blendColor.getGreen() + (1 - alpha) * baseColor.getGreen());
		int newB = (int) (alpha * blendColor.getBlue() + (1 - alpha) * baseColor.getBlue());

		return new Color(newR, newG, newB);
	}

	private static Color createColorFromHSV(double hue, double saturation, double value) {
		double red, green, blue;
		double h = hue;
		double s = saturation / 100.0;
		double v = value / 100.0;

		red = 0;
		green = 0;
		blue = 0;

		double c = v * s;
		double x = c * (1 - Math.abs((h / 60) % 2 - 1));
		double m = v - c;

		if (h >= 0 && h < 60) {
			red = c;
			green = x;
			blue = 0;
		} else if (h >= 60 && h < 120) {
			red = x;
			green = c;
			blue = 0;
		} else if (h >= 120 && h < 180) {
			red = 0;
			green = c;
			blue = x;
		} else if (h >= 180 && h < 240) {
			red = 0;
			green = x;
			blue = c;
		} else if (h >= 240 && h < 300) {
			red = x;
			green = 0;
			blue = c;
		} else if (h >= 300 && h < 360) {
			red = c;
			green = 0;
			blue = x;
		}

		red = (int) ((red + m) * 255);
		green = (int) ((green + m) * 255);
		blue = (int) ((blue + m) * 255);

		assert red <= 255 : "Postcondition failed: red <= 255";
		assert green <= 255 : "Postcondition failed: green <= 255";
		assert blue <= 255 : "Postcondition failed: blue <= 255";
		assert red >= 0 : "Postcondition failed: red >= 0 | " + h + " | " + s + " | " + v + " | " + red;
		assert green >= 0 : "Postcondition failed: green >= 0 | " + h + " | " + s + " | " + v + " | " + green;
		assert blue >= 0 : "Postcondition failed: blue >= 0 | " + h + " | " + s + " | " + v + " | " + blue;

		return new Color((int) red, (int) green, (int) blue);
	}

	public static List<Color> getMouthColors() {
		List<Color> list = new ArrayList<Color>();
		list.add(Color.makeFromRGB(0, 0, 0));
		list.add(Color.makeFromRGB(139, 0, 0));
		list.add(Color.makeFromRGB(201, 4, 51));
		list.add(Color.makeFromRGB(237, 33, 83));
		list.add(Color.makeFromRGB(238, 99, 99));
		list.add(Color.makeFromRGB(255, 193, 193));
		list.add(Color.makeFromRGB(243, 212, 207));
		return list;
	}

	public static List<Color> getEyeColors() {
		List<Color> list = new ArrayList<Color>();
		list.add(Color.makeFromRGB(0, 0, 0));
		list.add(Color.makeFromRGB(77, 54, 35));
		list.add(Color.makeFromRGB(123, 92, 51));
		list.add(Color.makeFromRGB(69, 139, 116));
		list.add(Color.makeFromRGB(102, 205, 170));
		list.add(Color.makeFromRGB(54, 100, 139));
		list.add(Color.makeFromRGB(79, 148, 205));
		return list;
	}

	// Kiefer, Nacken, Ohren, Kopf, Nacken
	public static List<Color> getSkinColor() {
		List<Color> list = new ArrayList<Color>();
		list.add(Color.makeFromRGB(0, 0, 0));
		list.add(Color.makeFromRGB(76, 45, 24));
		list.add(Color.makeFromRGB(118, 70, 48));
		list.add(Color.makeFromRGB(147, 97, 74));
		list.add(Color.makeFromRGB(218, 164, 136));
		list.add(Color.makeFromRGB(236, 196, 184));
		list.add(Color.makeFromRGB(243, 212, 207));
		return list;
	}

	public static List<Color> getCheekColors() {
		List<Color> list = new ArrayList<Color>();
		list.add(Color.makeFromRGB(0, 0, 0));
		list.add(Color.makeFromRGB(250, 128, 114));
		list.add(Color.makeFromRGB(237, 33, 83));
		list.add(Color.makeFromRGB(238, 99, 99));
		list.add(Color.makeFromRGB(255, 193, 193));
		list.add(Color.makeFromRGB(255, 211, 155));
		list.add(Color.makeFromRGB(255, 239, 213));
		return list;
	}

	public static List<Color> getBreathColors() {
		List<Color> list = new ArrayList<Color>();
		list.add(Color.makeFromRGB(0, 0, 0));
		list.add(Color.makeFromRGB(87, 87, 87));
		list.add(Color.makeFromRGB(148, 148, 148));
		list.add(Color.makeFromRGB(207, 207, 207));
		list.add(Color.makeFromRGB(185, 211, 233));
		list.add(Color.makeFromRGB(24, 116, 205));
		list.add(Color.makeFromRGB(255, 239, 213));
		return list;
	}

	public static List<Color> getHairColors() {
		List<Color> list = new ArrayList<Color>();
		list.add(Color.makeFromRGB(0, 0, 0));
		list.add(Color.makeFromRGB(80, 69, 67));
		list.add(Color.makeFromRGB(107, 78, 64));
		list.add(Color.makeFromRGB(183, 81, 59));
		list.add(Color.makeFromRGB(166, 132, 105));
		list.add(Color.makeFromRGB(221, 188, 155));
		list.add(Color.makeFromRGB(255, 246, 143));
		list.add(Color.makeFromRGB(211, 211, 211));
		list.add(Color.makeFromRGB(139, 137, 137));
		return list;
	}

	public static List<Color> getExpressionColors() {
		List<Color> list = new ArrayList<Color>();
		list.add(Color.makeFromRGB(0, 0, 0));
		list.add(Color.makeFromRGB(238, 59, 59));
		list.add(Color.makeFromRGB(255, 127, 36));
		list.add(Color.makeFromRGB(72, 61, 139));
		list.add(Color.makeFromRGB(0, 0, 139));
		list.add(Color.makeFromRGB(0, 206, 209));
		list.add(Color.makeFromRGB(152, 245, 255));
		return list;
	}
}
