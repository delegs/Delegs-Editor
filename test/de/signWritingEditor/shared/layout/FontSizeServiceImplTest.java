package de.signWritingEditor.shared.layout;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.FontMetricGenerationServiceImpl;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class FontSizeServiceImplTest {

	private String head = "Dies wird ein ";
	private String tail = "kleiner Test";
	private String text = head + tail;
	FontSizeService fontSizeService;

	private FontMetricSpecifier DEFAULT_FONT_HELVETICA = new FontMetricSpecifier(Font.HELVETICA, FontStyle.NORMAL,
			FontSize.SIZE_13, FontWeight.NORMAL);
	private IdFactory idFactory;
	private TokenFactory tokenFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp() throws IOException {
		fontSizeService = new FontSizeServiceImpl();
		FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
				new ConfigurationService("/ESFConfig_Junit.properties"));
		fontSizeService.setFontMetrics(fontMetricGenerationService.getFontMetrics());
		idFactory = new IdFactory(System.currentTimeMillis());
		tokenFactory = new TokenFactory(idFactory);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
	}

	@After
	public void tearDown() {
		fontSizeService.setFontMetrics(null);
	}

	@Test
	public void testSplitFreeTextToLines() {
		float headWidth = fontSizeService.getStringWidth(head, DEFAULT_FONT_HELVETICA);
		float tailWidth = fontSizeService.getStringWidth(tail, DEFAULT_FONT_HELVETICA);
		int maxWidth = fontSizeService.getCeilPixelSize(headWidth);
		String debugMessage = String.format("[headWidth=%spx; tailWidth=%spx; maxWidth=%spx; completeWidth=%spx]",
				headWidth, tailWidth, maxWidth, headWidth + tailWidth);
		FreeTextToken freeTextToken = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		freeTextToken.setText(text);
		TokenBoxFactory tokenBoxFactory = new TokenBoxFactory(fontSizeService);
		tokenBoxFactory.setPageHeight(PageFormat.A4_PORTRAIT.getPixelInnerHeight());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) tokenBoxFactory.create(freeTextToken, false, false,
				false, 10);
		freeTextTokenBox
				.setMaxWidth(maxWidth + freeTextTokenBox.getPaddingLeft_PX() + freeTextTokenBox.getPaddingRight_PX());

		// Action
		freeTextTokenBox.splitFreeTextToLines();

		// Check
		List<String> lines = freeTextTokenBox.getFreeTextLines();
		assertEquals(debugMessage, 2, lines.size());
		assertEquals(debugMessage, head, lines.get(0));
		assertEquals(debugMessage, tail, lines.get(1));
		assertEquals(debugMessage, headWidth, freeTextTokenBox.getTokenWidth() - freeTextTokenBox.getPaddingLeft_PX()
				- freeTextTokenBox.getPaddingRight_PX(), 0);
	}

}
