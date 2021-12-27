package de.delegs.memo.client;

import java.io.Serializable;

public class ColorValue implements Serializable {

	public static final ColorValue BLACK = new ColorValue(0, 0, 0);
	public static final ColorValue DARKGRAY = new ColorValue(64, 64, 64);
	public static final ColorValue GRAY = new ColorValue(128, 128, 128);
	public static final ColorValue LIGHTGRAY = new ColorValue(192, 192, 192);
	public static final ColorValue WHITE = new ColorValue(255, 255, 255);
	public static final ColorValue RED = new ColorValue(255, 0, 0);
	public static final ColorValue ORANGE = new ColorValue(255, 128, 0);
	public static final ColorValue YELLOW = new ColorValue(255, 255, 0);
	public static final ColorValue FRESHGREEN = new ColorValue(128, 255, 0);
	public static final ColorValue GREEN = new ColorValue(0, 255, 0);
	public static final ColorValue BOTTLEGREEN = new ColorValue(0, 255, 128);
	public static final ColorValue PELTFROG = new ColorValue(0, 255, 255);
	public static final ColorValue TURQUOISE = new ColorValue(0, 128, 255);
	public static final ColorValue BLUE = new ColorValue(0, 0, 255);
	public static final ColorValue LILAC = new ColorValue(128, 0, 255);
	public static final ColorValue VIOLET = new ColorValue(255, 0, 255);
	public static final ColorValue PINK = new ColorValue(255, 0, 128);
	public static final ColorValue BROWN = new ColorValue(112, 80, 32);
	public static final ColorValue PIGLET = new ColorValue(255, 192, 128);
	public static final ColorValue GOLD = new ColorValue(192, 192, 64);

	public static final ColorValue[] DEFAULTS = { BLACK, DARKGRAY, GRAY, LIGHTGRAY, WHITE, RED, ORANGE, YELLOW,
			FRESHGREEN, GREEN, BOTTLEGREEN, PELTFROG, TURQUOISE, BLUE, LILAC, VIOLET, PINK, BROWN, PIGLET, GOLD };

	private static final long serialVersionUID = -1569760738686573935L;

	private int r;
	private int g;
	private int b;

	@Deprecated
	protected ColorValue() {
		super();
	}

	public ColorValue(int rgbValue) {
		assert rgbValue >= 0x0 : "Precondition failed: rgbValue >= 0x0";
		assert rgbValue <= 0xFFFFFF : "Precondition failed: rgbValue <= 0xFFFFFF";

		this.r = (rgbValue / 0x10000) & 0xFF;
		this.g = (rgbValue / 0x100) & 0xFF;
		this.b = rgbValue & 0xFF;

		assert getRgbValue() == rgbValue : "Postcondition failed: getRgbValue() [" + getRgbValue() + "] == rgbValue ["
				+ rgbValue + "]";
	}

	public ColorValue(int r, int g, int b) {
		assert r >= 0 : "Precondition failed: r >= 0";
		assert r < 0x100 : "Precondition failed: r < 0x100";
		assert g >= 0 : "Precondition failed: g >= 0";
		assert g < 0x100 : "Precondition failed: g < 0x100";
		assert b >= 0 : "Precondition failed: b >= 0";
		assert b < 0x100 : "Precondition failed: b < 0x100";

		this.r = r;
		this.g = g;
		this.b = b;

		assert getR() == r : "Postcondition failed: getR() == r";
		assert getG() == g : "Postcondition failed: getG() == g";
		assert getB() == b : "Postcondition failed: getB() == b";
	}

	/**
	 * @param h
	 *            hue 0-360°
	 * @param s
	 *            saturation 0-1
	 * @param v
	 *            value (darkness) 0-1
	 */
	public ColorValue(double h, double s, double v) {
		assert h >= 0d : "Precondition failed: h >= 0d";
		assert h < 420d : "Precondition failed: h < 420d";
		assert s >= 0d : "Precondition failed: s >= 0d";
		assert s <= 1d : "Precondition failed: s <= 1d";
		assert v >= 0d : "Precondition failed: v >= 0d";
		assert v <= 1d : "Precondition failed: v <= 1d";

		int hi = (int) (h / 60d);
		double f = h / 60 - hi;

		int o = (int) (v * 255d);
		int p = (int) (v * (1d - s) * 255d);
		int q = (int) (v * (1d - s * f) * 255d);
		int t = (int) (v * (1d - s * (1 - f)) * 255d);

		switch (hi) {
		case 1:
		case 7:
			r = q;
			g = o;
			b = p;
			break;
		case 2:
			r = p;
			g = o;
			b = t;
			break;
		case 3:
			r = p;
			g = q;
			b = o;
			break;
		case 4:
			r = t;
			g = p;
			b = o;
			break;
		case 5:
			r = o;
			g = p;
			b = q;
			break;
		default:
			r = o;
			g = t;
			b = p;
			break;
		}
	}

	public int getRgbValue() {
		int result = ((r * 0x100) + g) * 0x100 + b;
		assert result >= 0x0 : "Postcondition failed: result >= 0x0";
		assert result <= 0xFFFFFF : "Postcondition failed: result <= 0xFFFFFF";
		return result;
	}

	public int getR() {
		assert r >= 0 : "Postcondition failed: result >= 0";
		assert r < 0x100 : "Postcondition failed: result < 0x100";
		return r;
	}

	public int getG() {
		assert g >= 0 : "Postcondition failed: result >= 0";
		assert g < 0x100 : "Postcondition failed: result < 0x100";
		return g;
	}

	public int getB() {
		assert b >= 0 : "Postcondition failed: result >= 0";
		assert b < 0x100 : "Postcondition failed: result < 0x100";
		return b;
	}

	public double getH() {
		double result = 0d;

		if (r != g || g != b) {
			if (r >= g && r >= b) {
				int min = g < b ? g : b;
				result = 60d * (double) (g - b) / (double) (r - min);
			} else if (g >= r && g >= b) {
				int min = r < b ? r : b;
				result = 120d + 60d * (double) (b - r) / (double) (g - min);
			} else {
				int min = r < g ? r : g;
				result = 240d + 60d * (double) (r - g) / (double) (b - min);
			}

			if (result < 0d) {
				result += 360d;
			}
		}

		assert result >= 0d : "Postcondition failed: result >= 0d";
		assert result <= 360d : "Postcondition failed: result <= 360d";
		return result;
	}

	public double getS() {
		double result = 0d;

		if (r > 0 || g > 0 || b > 0) {
			int max = r;
			if (g >= r && g >= b) {
				max = g;
			} else if (b >= r && b >= g) {
				max = b;
			}

			int min = r;
			if (g <= r && g <= b) {
				min = g;
			} else if (b <= r && b <= g) {
				min = b;
			}

			result = (double) (max - min) / (double) max;
		}

		assert result >= 0d : "Postcondition failed: result >= 0d";
		assert result <= 1d : "Postcondition failed: result <= 1d";
		return result;
	}

	public double getV() {
		double result = (double) r;
		if (g >= r && g >= b) {
			result = (double) g;
		} else if (b >= r && b >= g) {
			result = (double) b;
		}
		result = result / 255d;

		assert result >= 0d : "Postcondition failed: result >= 0d";
		assert result <= 1d : "Postcondition failed: result <= 1d";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj.getClass().equals(getClass())) {
			ColorValue colorValue = (ColorValue) obj;
			result = r == colorValue.r && g == colorValue.g && b == colorValue.b;
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (r * 0x100 + g) * 0x100 + b;
	}

	@Override
	public String toString() {
		StringBuffer resultBuf = new StringBuffer();

		if (r < 0x10) {
			resultBuf.append("0");
		}
		resultBuf.append(Integer.toHexString(r));

		if (g < 0x10) {
			resultBuf.append("0");
		}
		resultBuf.append(Integer.toHexString(g));

		if (b < 0x10) {
			resultBuf.append("0");
		}
		resultBuf.append(Integer.toHexString(b));

		String result = resultBuf.toString().toUpperCase();
		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
