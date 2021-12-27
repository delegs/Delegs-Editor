package de.signWritingEditor.shared.model.domainValue;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.io.Serializable;

public class PageFormat implements Serializable, Comparable<PageFormat> {

	private static final long serialVersionUID = 8456401075283380569L;

	public static final double DEFAULT_DPI = 119.7983d;
	private static final String DIN_A4 = "DIN A4 ";

	public static final PageFormat A4_PORTRAIT = new PageFormat("A4 Hochformat", Orientation.VERTICAL, DEFAULT_DPI, 990,
			1401, 30, 30, 75, 100);
	public static final PageFormat A4_LANDSCAPE = new PageFormat("A4 Querformat", Orientation.VERTICAL, DEFAULT_DPI,
			1401, 990, 100, 30, 75, 30);

	public static final PageFormat[] DEFAULTS = { A4_PORTRAIT, A4_LANDSCAPE };

	public static final int SEARCH_WORD_BOX_PIXEL_HEIGHT = 18;
	public static final int FOOTER_PIXEL_PADDING = 16;

	public static final int COLLAGE_PADDING = 15;
	public static final int COLLAGE_GRID_TILE_EDGE_LENGTH = 40;
	public static final int COLLAGE_GRID_SNAP_DISTANCE_MARGIN = 20;

	public static final int SNIPPET_LINE_DISTANCE = 3;

	/**
	 * Find the default page dimension for the given name. Return null, if none
	 * was found.
	 * 
	 * @param name the name of a page dimension
	 * @return a matching default page dimension or null
	 * @pre name != null
	 */
	public static PageFormat getDefaultPageDimension(String name) {
		assert name != null : "Precondition failed: name != null";

		PageFormat result = null;
		for (int i = 0; result == null && i < DEFAULTS.length; i++) {
			if (DEFAULTS[i].getName().equals(name)) {
				result = DEFAULTS[i];
			}
		}

		return result;
	}

	private String name;

	private Orientation orientation;

	private double dpi;

	private int pixelWidth;
	private int pixelHeight;

	private int pixelPaddingTop;
	private int pixelPaddingRight;
	private int pixelPaddingBottom;
	private int pixelPaddingLeft_PX;

	@Deprecated
	protected PageFormat() {
		super();
	}

	public PageFormat(String name, Orientation orientation, double dpi, int pixelWidth, int pixelHeight,
			int pixelPaddingTop, int pixelPaddingRight, int pixelPaddingBottom, int pixelPaddingLeft) {
		assert name != null : "Precondition failed: name != null";
		assert orientation != null : "Precondition failed: orientation != null";
		assert dpi > 0d : "Precondition failed: dpi > 0d";
		assert pixelWidth >= 0 : "Precondition failed: pixelWidth >= 0";
		assert pixelHeight >= 0 : "Precondition failed: pixelHeight >= 0";
		assert pixelPaddingTop >= 0 : "Precondition failed: pixelPaddingTop >= 0";
		assert pixelPaddingRight >= 0 : "Precondition failed: pixelPaddingRight >= 0";
		assert pixelPaddingBottom >= 0 : "Precondition failed: pixelPaddingBottom >= 0";
		assert pixelPaddingLeft >= 0 : "Precondition failed: pixelPaddingLeft >= 0";

		this.name = name;

		this.orientation = orientation;

		this.dpi = dpi;

		this.pixelWidth = pixelWidth;
		this.pixelHeight = pixelHeight;

		this.pixelPaddingTop = pixelPaddingTop;
		this.pixelPaddingRight = pixelPaddingRight;
		this.pixelPaddingBottom = pixelPaddingBottom;
		this.pixelPaddingLeft_PX = pixelPaddingLeft;
	}

	@Override
	public int compareTo(PageFormat pageFormat) {
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		return getName().compareTo(pageFormat.getName());
	}

	@Override
	public String toString() {
		return getName();
	}

	public String getName() {
		assert name != null : "Postcondition failed: result != null";
		return name;
	}

	public String getDisplayName() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(DIN_A4);
		if (this.equals(A4_LANDSCAPE)) {
			stringBuilder.append(I18N.getPaperSizeLandscape());
		} else if (this.equals(A4_PORTRAIT)) {
			stringBuilder.append(I18N.getPaperSizePortrait());
		}
		return stringBuilder.toString();
	}

	public Orientation getOrientation() {
		assert orientation != null : "Postcondition failed: result != null";
		return orientation;
	}

	public double getDpi() {
		assert dpi > 0d : "Postcondition failed: result > 0d";
		return dpi;
	}

	public int getPixelWidth() {
		assert pixelWidth >= 0 : "Postcondition failed: result >= 0";
		return pixelWidth;
	}

	public int getPixelHeight() {
		assert pixelHeight >= 0 : "Postcondition failed: result >= 0";
		return pixelHeight;
	}

	public int getPixelInnerWidth() {
		int result = pixelWidth - pixelPaddingLeft_PX - pixelPaddingRight;

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public int getPixelInnerHeight() {
		int result = pixelHeight - pixelPaddingTop - pixelPaddingBottom;

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public int getPixelPaddingTop() {
		assert pixelPaddingTop >= 0 : "Postcondition failed: result >= 0";
		return pixelPaddingTop;
	}

	public int getPixelPaddingRight() {
		assert pixelPaddingRight >= 0 : "Postcondition failed: result >= 0";
		return pixelPaddingRight;
	}

	public int getPixelPaddingBottom() {
		assert pixelPaddingBottom >= 0 : "Postcondition failed: result >= 0";
		return pixelPaddingBottom;
	}

	public int getPixelPaddingLeft_PX() {
		assert pixelPaddingLeft_PX >= 0 : "Postcondition failed: result >= 0";
		return pixelPaddingLeft_PX;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other == this;
		if (!result && other != null && other.getClass().equals(getClass())) {
			PageFormat otherPageFormat = (PageFormat) other;
			result = otherPageFormat.name.equals(this.name);
		}
		return result;
	}

}
