package de.signWritingEditor.shared.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.VideoToken;

public class TokenBoxFactoryTest {

	private IdFactory idFactory;
	private TokenFactory tokenFactory;
	private TokenBoxFactory tokenBoxFactory;
	private TextbasedTokenStyleFactory tokenStyleFactory;
	private static int PAGE_HEIGHT = 500;
	private static int PAGE_WIDTH = 500;

	@Before
	public void setUp() {

		idFactory = new IdFactory(0);
		tokenFactory = new TokenFactory(idFactory);
		tokenBoxFactory = new TokenBoxFactory(new FontSizeServiceImpl());
		tokenBoxFactory.setPageHeight(PAGE_HEIGHT);
		tokenStyleFactory = new TextbasedTokenStyleFactory();
	}

	@Test
	public void testCreateSignItemTokenBox() {
		// Prepare
		SignItemToken token1 = tokenFactory.createEmptySignItemToken(
				tokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("Test",
				tokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		// Action
		TokenBox tokenBox1 = tokenBoxFactory.create(token1, true, true, PAGE_WIDTH);
		TokenBox tokenBox2 = tokenBoxFactory.create(token2, true, true, PAGE_WIDTH);
		// Check
		assertTrue(tokenBox1 instanceof SignItemTokenBox);
		SignItemTokenBox signItemTokenBox = (SignItemTokenBox) tokenBox1;
		assertEquals(token1.getText(), signItemTokenBox.getText());

		assertTrue(tokenBox2 instanceof SignItemTokenBox);
		SignItemTokenBox signItemTokenBox2 = (SignItemTokenBox) tokenBox2;
		assertEquals(token2.getText(), signItemTokenBox2.getText());
	}

	@Test
	public void testCreateFreeTextTokenBox() {
		// Prepare
		// Test standard FreeTextBox
		FreeTextToken freeTextToken1 = tokenFactory
				.createFreeTextToken(tokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Test FreeTextBox with fixed width
		FreeTextToken freeTextToken2 = tokenFactory
				.createFreeTextToken(tokenStyleFactory.createDefaultTextbasedTokenStyle());
		freeTextToken2.setFixedWidth(true, 400);

		// Test FreeTextLine
		FreeTextToken freeTextLine = tokenFactory
				.createFreeTextLineToken(tokenStyleFactory.createDefaultTextbasedTokenStyle());
		// Action
		TokenBox tokenBox1 = tokenBoxFactory.create(freeTextToken1, true, true, PAGE_WIDTH);
		TokenBox tokenBox2 = tokenBoxFactory.create(freeTextToken2, true, true, PAGE_WIDTH);
		TokenBox tokenBox3 = tokenBoxFactory.create(freeTextLine, true, true, PAGE_WIDTH);
		// Check
		assertTrue(tokenBox1 instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox1 = (FreeTextTokenBox) tokenBox1;
		// Empty non fixed width FreeTextToken have minWidth
		assertEquals(freeTextTokenBox1.getMinWidth() + freeTextTokenBox1.getMarginRight_PX()
				+ freeTextTokenBox1.getSliderWidth(), (int) freeTextTokenBox1.getWidth_PX());

		assertTrue(tokenBox2 instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox2 = (FreeTextTokenBox) tokenBox2;
		assertEquals(
				freeTextToken2.getWidth() + freeTextTokenBox2.getMarginRight_PX() + freeTextTokenBox2.getSliderWidth(),
				(int) freeTextTokenBox2.getWidth_PX());

		assertTrue(tokenBox3 instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox3 = (FreeTextTokenBox) tokenBox3;
		assertTrue(freeTextTokenBox3.isLine());
		assertEquals(PAGE_WIDTH, (int) freeTextTokenBox3.getWidth_PX());
	}

	@Test
	public void testCreateImageTokenBox() {
		// Prepare
		ImageToken imageToken1 = tokenFactory.createImageToken();
		ImageToken imageToken2 = tokenFactory.createImageToken();
		imageToken2.setWidth(PAGE_WIDTH + 50);
		imageToken2.setHeight(PAGE_HEIGHT + 50);
		// Action
		TokenBox tokenBox1 = tokenBoxFactory.create(imageToken1, true, true, PAGE_WIDTH);
		TokenBox tokenBox2 = tokenBoxFactory.create(imageToken2, true, true, PAGE_WIDTH);
		// Check
		assertTrue(tokenBox1 instanceof ImageTokenBox);
		assertEquals(imageToken1.getWidth() + ((ImageTokenBox) tokenBox1).getMarginRight(), (int) tokenBox1.getWidth_PX());
		assertEquals(imageToken1.getHeight(), tokenBox1.getHeight_PX());

		assertTrue(tokenBox2 instanceof ImageTokenBox);
		assertEquals(PAGE_WIDTH, (int) tokenBox2.getWidth_PX());
		assertEquals(PAGE_HEIGHT - ((ImageTokenBox) tokenBox2).getMarginRight(), tokenBox2.getHeight_PX());
	}

	@Test
	public void testCreateVideoTokenBox() {
		// Prepare
		VideoToken videoToken1 = tokenFactory.createVideoToken();
		VideoToken videoToken2 = tokenFactory.createVideoToken();
		videoToken2.setWidth(PAGE_WIDTH + 50);
		videoToken2.setHeight(PAGE_HEIGHT + 50);
		// Action
		TokenBox tokenBox1 = tokenBoxFactory.create(videoToken1, true, true, PAGE_WIDTH);
		TokenBox tokenBox2 = tokenBoxFactory.create(videoToken2, true, true, PAGE_WIDTH);
		// Check
		assertTrue(tokenBox1 instanceof VideoTokenBox);
		assertEquals(videoToken1.getWidth() + ((VideoTokenBox) tokenBox1).getMarginRight_PX(), (int) tokenBox1.getWidth_PX());
		assertEquals(videoToken1.getHeight(), tokenBox1.getHeight_PX());

		assertTrue(tokenBox2 instanceof VideoTokenBox);
		assertEquals(PAGE_WIDTH, (int) tokenBox2.getWidth_PX());
		assertEquals(PAGE_HEIGHT - ((VideoTokenBox) tokenBox2).getMarginRight_PX(), tokenBox2.getHeight_PX());
	}

	@Test
	public void testCreateFrameTokenBox() {

		// Prepare
		FrameToken frameToken1 = tokenFactory.createFrameToken();

		int frameToken1WidthWithBorder = frameToken1.getWidth() + 2 * frameToken1.getBorderWidth_PX();
		int frameToken1HeightWithBorder = frameToken1.getHeight() + 2 * frameToken1.getBorderWidth_PX();

		FrameToken frameToken2 = tokenFactory.createFrameToken();
		frameToken2.setHeight(PAGE_HEIGHT);
		frameToken2.setWidth(PAGE_WIDTH);

		// Action
		TokenBox tokenBox1 = tokenBoxFactory.create(frameToken1, true, true, PAGE_WIDTH);
		TokenBox tokenBox2 = tokenBoxFactory.create(frameToken2, true, true, PAGE_WIDTH);

		// Check
		assertTrue(tokenBox1 instanceof FrameTokenBox);
		int expectedWidth = frameToken1WidthWithBorder + ((FrameTokenBox) tokenBox1).getMarginRight()
				+ ((FrameTokenBox) tokenBox1).getDecorations();
		int expectedHeight = frameToken1HeightWithBorder + ((FrameTokenBox) tokenBox1).getDecorations();

		assertEquals(expectedWidth, (int) tokenBox1.getWidth_PX());
		assertEquals(expectedHeight, tokenBox1.getHeight_PX());

		assertTrue(tokenBox2 instanceof FrameTokenBox);
		assertEquals(PAGE_WIDTH, tokenBox2.getWidth_PX(), 0);
		assertEquals(PAGE_HEIGHT, tokenBox2.getHeight_PX());

	}

}
