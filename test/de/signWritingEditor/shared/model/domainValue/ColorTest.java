package de.signWritingEditor.shared.model.domainValue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorTest {

	private final double ALPHALIGHT = 0.1;
	private final double ALPHAMEDIUM = 0.5;
	private final double ALPHASTRONG = 0.9;

	@Test
	public void testMakeFromCssString() {
		// prepare
		Color toiletBlue = Color.makeFromRGB(204, 255, 255);
		Color lipRed = Color.makeFromRGB(255, 80, 80);

		// action
		Color toiletBlueFomCSS = Color.makeFromCssString("#ccffff");
		Color lipRedFromCSS = Color.makeFromCssString("#ff5050");

		// check
		assertEquals(toiletBlue, toiletBlueFomCSS);
		assertEquals(lipRed, lipRedFromCSS);
	}

	@Test
	public void testcreateColorFromHSV() {
		// prepare
		Color black = Color.makeFromHSV(0, 0, 0);
		Color royalBlue = Color.makeFromHSV(225, 80, 100);

		// action
		int rBlack = black.getRed();
		int gBlack = black.getGreen();
		int bBlack = black.getBlue();

		int rRoyalBlue = royalBlue.getRed();
		int gRoyalBlue = royalBlue.getGreen();
		int bRoyalBlue = royalBlue.getBlue();

		// check
		assertEquals(0, rBlack);
		assertEquals(0, gBlack);
		assertEquals(0, bBlack);

		assertEquals(50, rRoyalBlue);
		assertEquals(101, gRoyalBlue);
		assertEquals(255, bRoyalBlue);

	}

	@Test
	public void testGetCSSValue() {
		// prepare
		Color black = Color.makeFromRGB(0, 0, 0);
		Color white = Color.makeFromRGB(255, 255, 255);
		Color seaGreen = Color.makeFromRGB(0, 153, 51);
		Color royalBlue = Color.makeFromRGB(51, 102, 255);

		// action
		String cssValueBlack = black.getCssValue();
		String cssValueWhite = white.getCssValue();
		String cssValueSeaGreen = seaGreen.getCssValue();
		String cssValueRoyalBlue = royalBlue.getCssValue();

		// check
		assertEquals("#000000", cssValueBlack);
		assertEquals("#FFFFFF", cssValueWhite);
		assertEquals("#009933", cssValueSeaGreen);
		assertEquals("#3366FF", cssValueRoyalBlue);

	}

	@Test
	public void testMakeBlendColorBlackWhite() {
		// prepare
		Color black = Color.makeFromRGB(0, 0, 0);
		Color white = Color.makeFromRGB(255, 255, 255);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(black, white, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(black, white, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(black, white, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(25, 25, 25), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(127, 127, 127), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(229, 229, 229), makeBlendColorStrong);
	}

	@Test
	public void testMakeBlendColorRedGreen() {
		// prepare
		Color red = Color.makeFromRGB(255, 0, 0);
		Color green = Color.makeFromRGB(0, 255, 0);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(red, green, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(red, green, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(red, green, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(229, 25, 0), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(127, 127, 0), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(25, 229, 0), makeBlendColorStrong);
	}

	@Test
	public void testMakeBlendColorGreenBlue() {
		// prepare
		Color green = Color.makeFromRGB(0, 255, 0);
		Color blue = Color.makeFromRGB(0, 0, 255);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(green, blue, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(green, blue, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(green, blue, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(0, 229, 25), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(0, 127, 127), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(0, 25, 229), makeBlendColorStrong);
	}

	@Test
	public void testMakeBlendColorYellowBlue() {
		// prepare
		Color blue = Color.makeFromRGB(0, 0, 255);
		Color yellow = Color.makeFromRGB(255, 255, 0);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(yellow, blue, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(yellow, blue, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(yellow, blue, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(229, 229, 25), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(127, 127, 127), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(25, 25, 229), makeBlendColorStrong);
	}

	@Test
	public void testMakeBlendColorEqualsBlack() {
		// prepare
		Color base = Color.makeFromRGB(0, 0, 0);
		Color blend = Color.makeFromRGB(0, 0, 0);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(base, blend, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(base, blend, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(base, blend, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(0, 0, 0), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(0, 0, 0), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(0, 0, 0), makeBlendColorStrong);
	}

	@Test
	public void testMakeBlendColorEqualsWhite() {
		// prepare
		Color base = Color.makeFromRGB(255, 255, 255);
		Color blend = Color.makeFromRGB(255, 255, 255);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(base, blend, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(base, blend, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(base, blend, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(255, 255, 255), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(255, 255, 255), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(255, 255, 255), makeBlendColorStrong);
	}

	@Test
	public void testMakeBlendColorSeaGreenDarkOrange() {
		// prepare
		Color seaGreen = Color.makeFromRGB(0, 204, 102);
		Color darkOrange = Color.makeFromRGB(204, 82, 0);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(seaGreen, darkOrange, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(seaGreen, darkOrange, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(seaGreen, darkOrange, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(20, 191, 91), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(102, 143, 51), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(183, 94, 10), makeBlendColorStrong);
	}

	@Test
	public void testMakeBlendColorLavenderBrown() {
		// prepare
		Color lavender = Color.makeFromRGB(153, 102, 255);
		Color brown = Color.makeFromRGB(128, 64, 0);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(lavender, brown, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(lavender, brown, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(lavender, brown, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(150, 98, 229), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(140, 83, 127), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(130, 67, 25), makeBlendColorStrong);
	}

	@Test
	public void testMakeBlendColorBeigeGrey() {
		// prepare
		Color beige = Color.makeFromRGB(255, 204, 102);
		Color grey = Color.makeFromRGB(153, 153, 153);

		// action
		Color makeBlendColorLight = Color.makeBlendColor(beige, grey, ALPHALIGHT);
		Color makeBlendColorMedium = Color.makeBlendColor(beige, grey, ALPHAMEDIUM);
		Color makeBlendColorStrong = Color.makeBlendColor(beige, grey, ALPHASTRONG);

		// check
		assertEquals(Color.makeFromRGB(244, 198, 107), makeBlendColorLight);
		assertEquals(Color.makeFromRGB(204, 178, 127), makeBlendColorMedium);
		assertEquals(Color.makeFromRGB(163, 158, 147), makeBlendColorStrong);
	}
}
