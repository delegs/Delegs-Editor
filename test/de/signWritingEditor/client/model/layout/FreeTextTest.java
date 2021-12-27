package de.signWritingEditor.client.model.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.infrastructure.FontMetricMock;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.FontMetricGenerationServiceImpl;
import de.signWritingEditor.shared.layout.FontSizeServiceImplTest;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class FreeTextTest {

	private IdFactory idFactory;
	private TokenBoxFactory tokenBoxFactory;
	private TokenFactory tokenFactory;
	private FontSizeService fontSizeService;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp() throws Exception {
		fontSizeService = new FontSizeServiceImpl();
		fontSizeService.setMetric(new FontMetricMock());
		FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
				new ConfigurationService("/ESFConfig_Junit.properties"));
		fontSizeService.setFontMetrics(fontMetricGenerationService.getFontMetrics());

		idFactory = new IdFactory(0);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		tokenBoxFactory = new TokenBoxFactory(fontSizeService);
		tokenBoxFactory.setPageHeight(PageFormat.A4_PORTRAIT.getPixelInnerHeight());
		tokenFactory = new TokenFactory(idFactory);
	}

	/**
	 * See {@link FontSizeServiceImplTest} for further details.
	 */
	@Test
	public void testAll() {
		String freeText1 = "Nur eine Zeile";
		String freeText2 = "Mit einem Linebreak\nzweite Zeile";
		String freeText3 = "Eine sehr lange Zeile mit zwei automatischem Zeilenumbruch  123456789 123456789 123456789 123456789 123456789  123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789";
		String freeText4 = "Mit Linebreak\nund einer sehr langen Zeile mit automatischem Zeilenumbruch 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789";
		// Text with 2 more characters than allowed in one line:
		String freeText5 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String freeText6 = " aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		// Text with a word that ranges over the end of the line:
		String freeText7 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa wordAtLineEnd";

		FreeTextTokenBox freeTextBox = (FreeTextTokenBox) tokenBoxFactory.create(
				tokenFactory.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle()), true,
				true, true, 700);
		freeTextBox.splitFreeTextToLines();
		assertEquals(1, freeTextBox.getFreeTextLines().size());
		assertEquals("", freeTextBox.getText());

		freeTextBox.setText(freeText1);
		freeTextBox.splitFreeTextToLines();
		assertEquals(1, freeTextBox.getFreeTextLines().size());
		assertEquals("Nur eine Zeile", freeTextBox.getText());

		freeTextBox.setText(freeText2);
		freeTextBox.splitFreeTextToLines();
		assertEquals(2, freeTextBox.getFreeTextLines().size());
		assertEquals("Mit einem Linebreak\nzweite Zeile", freeTextBox.getText());

		freeTextBox.setText(freeText3);
		freeTextBox.splitFreeTextToLines();
		assertEquals(3, freeTextBox.getFreeTextLines().size());
		assertEquals(
				"Eine sehr lange Zeile mit zwei automatischem Zeilenumbruch  123456789 123456789 123456789 123456789 123456789  123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789",
				freeTextBox.getText());

		freeTextBox.setText(freeText4);
		freeTextBox.splitFreeTextToLines();
		assertEquals(4, freeTextBox.getFreeTextLines().size());
		assertEquals(
				"Mit Linebreak\nund einer sehr langen Zeile mit automatischem Zeilenumbruch 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789",
				freeTextBox.getText());

		freeTextBox.setText(freeText5);
		freeTextBox.splitFreeTextToLines();
		assertEquals(2, freeTextBox.getFreeTextLines().size());
		assertEquals(freeText5, freeTextBox.getText());

		freeTextBox.setText(freeText6);
		freeTextBox.splitFreeTextToLines();
		assertEquals(2, freeTextBox.getFreeTextLines().size());
		assertEquals(freeText6, freeTextBox.getText());

		freeTextBox.setText(freeText7);
		freeTextBox.splitFreeTextToLines();
		assertEquals(2, freeTextBox.getFreeTextLines().size());
		assertEquals(freeText7, freeTextBox.getText());
	}

	@Test
	public void testParagraphWidthForFreeTextBox() {
		// Prepare
		int paragraphWidth = 700;
		FreeTextToken freeTextToken = (FreeTextToken) tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		FreeTextTokenBox freeTextBox = (FreeTextTokenBox) tokenBoxFactory.create(freeTextToken, true, true, true,
				paragraphWidth);

		// Check
		assertEquals("", freeTextBox.getText());
		assertEquals(paragraphWidth, freeTextBox.getParagraphWidth());
	}

	@Test
	public void testParagraphWidthForFreeTextLine() {
		// Prepare
		int paragraphWidth = 700;
		FreeTextToken freeTextToken = (FreeTextToken) tokenFactory
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		FreeTextTokenBox freeTextBox = (FreeTextTokenBox) tokenBoxFactory.create(freeTextToken, true, true, true,
				paragraphWidth);

		// Check
		assertEquals("", freeTextBox.getText());
		assertEquals(paragraphWidth, freeTextBox.getParagraphWidth());
		assertEquals(paragraphWidth, freeTextBox.getWidth_PX(), 0);
	}

	@Test
	public void testSetFixedWidthWithoutMarginOnFreeTextLine() {
		// Prepare
		int paragraphWidth = 700;
		FreeTextToken freeTextToken = (FreeTextToken) tokenFactory
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextTokenBox freeTextBox = (FreeTextTokenBox) tokenBoxFactory.create(freeTextToken, true, true, true,
				paragraphWidth);
		int newWidthWithoutMargin = 330;

		// Action
		freeTextBox.setFixedWidthWithoutMargin(newWidthWithoutMargin);

		// Check
		assertEquals("", freeTextBox.getText());
		assertTrue("Margin for FreeTextBox not set.", freeTextBox.getMarginRight_PX() > 0);
		assertEquals(paragraphWidth, freeTextBox.getParagraphWidth());
		assertEquals(newWidthWithoutMargin + freeTextBox.getMarginRight_PX(), freeTextBox.getWidth_PX(), 0);
		assertEquals(freeTextBox.getTokenWidth(), freeTextBox.getMinWidth(), 0);
		assertEquals(freeTextBox.getTokenWidth(), freeTextBox.getMaxWidth(), 0);
	}

	private int calculateSliderWidth() {
		int paragraphWidth = 600;
		FreeTextToken freeTextToken = (FreeTextToken) tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextTokenBox freeTextBox = (FreeTextTokenBox) tokenBoxFactory.create(freeTextToken, true, true, true,
				paragraphWidth);
		return fontSizeService.getPixelSize(
				(freeTextBox.getWidth_PX() - freeTextBox.getTokenWidth() - freeTextBox.getMarginRight_PX()));
	}

	@Test
	public void testSetFixedWidthWithoutMarginOnFreeTextBox() {
		// Prepare
		int paragraphWidth = 700;
		FreeTextToken freeTextToken = (FreeTextToken) tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextTokenBox freeTextBox = (FreeTextTokenBox) tokenBoxFactory.create(freeTextToken, true, true, true,
				paragraphWidth);
		int newWidthWithoutMargin = paragraphWidth + 10;
		int sliderWidth = calculateSliderWidth();

		// Action
		freeTextBox.setFixedWidthWithoutMargin(newWidthWithoutMargin);

		// Check
		assertEquals("", freeTextBox.getText());
		assertEquals("No margin allowed for FreeTextLine.", 0, freeTextBox.getMarginRight_PX());
		assertEquals(paragraphWidth, freeTextBox.getParagraphWidth());
		assertEquals(paragraphWidth + freeTextBox.getMarginRight_PX(), freeTextBox.getWidth_PX(), 0);
		assertEquals(paragraphWidth - sliderWidth, freeTextBox.getMinWidth());
		assertEquals(paragraphWidth - sliderWidth, freeTextBox.getMaxWidth());
	}
}
