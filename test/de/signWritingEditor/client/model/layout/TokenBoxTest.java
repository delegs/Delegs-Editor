package de.signWritingEditor.client.model.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.infrastructure.FontMetricMock;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.FontMetricGenerationServiceImpl;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class TokenBoxTest {

	private IdFactory idFactory;
	private FontSizeService fontSizeService;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;
	private TokenFactory tokenFactory;

	@Before
	public void setUp() throws Exception {
		idFactory = new IdFactory(0);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		tokenFactory = new TokenFactory(idFactory);
		fontSizeService = new FontSizeServiceImpl();
		fontSizeService.setMetric(new FontMetricMock());
		FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
				new ConfigurationService("/ESFConfig_Junit.properties"));
		fontSizeService.setFontMetrics(fontMetricGenerationService.getFontMetrics());
	}

	@Test
	public void testTokenBox() {
		Id tokenId1 = idFactory.createId();
		String word = "test";

		SignItemTokenBox tokenBox = new SignItemTokenBox(tokenFactory.createSignItemToken(word, null, tokenId1,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false), true, true, fontSizeService);

		assertEquals("test", tokenBox.getText());
		assertEquals(tokenId1, tokenBox.getId());
		assertEquals(new ArrayList<SignItem>(), tokenBox.getSignItems());
		assertEquals(null, tokenBox.getSelectedSign());
		assertEquals(-1, tokenBox.getSelectedSignIndex());
		assertEquals(100, tokenBox.getWidth_PX(), 0);
		assertEquals(207, tokenBox.getHeight_PX());

		ArrayList<SignItem> signItems = new ArrayList<SignItem>();
		SignItem signItem = new SignItem(new SignId(1234, "bla", SignLocale.DGS, SignSource.DELEGS), 100);
		signItems.add(signItem);

		Id tokenId2 = idFactory.createId();

		SignItemToken token2 = tokenFactory.createSignItemToken("test2", null, tokenId2,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);

		try {
			tokenBox = new SignItemTokenBox(token2, signItems, 1, true, true, fontSizeService);
			fail("selectedSignIndex out of bounds");
		} catch (AssertionError ae) {
		}

		tokenBox = new SignItemTokenBox(token2, signItems, 0, true, true, fontSizeService);
		int expectedWidth = signItem.getSignWidth() + tokenBox.getMarginRight_PX() + tokenBox.getPaddingLeft_PX()
				+ tokenBox.getPaddingRight_PX();

		assertEquals("test2", tokenBox.getText());
		assertEquals(tokenId2, tokenBox.getId());
		assertEquals(signItems, tokenBox.getSignItems());
		assertEquals(signItem, tokenBox.getSelectedSign());
		assertEquals(0, tokenBox.getSelectedSignIndex());
		assertEquals(expectedWidth, tokenBox.getWidth_PX(), 0);
		assertEquals(207, tokenBox.getHeight_PX());

		ArrayList<SignItem> signs2 = new ArrayList<SignItem>();
		SignItem sign2 = new SignItem(new SignId(1235, "bla", SignLocale.DGS, SignSource.DELEGS), 110);
		SignItem sign3 = new SignItem(new SignId(1236, "blub", SignLocale.DGS, SignSource.DELEGS), 60);
		signs2.add(sign2);
		signs2.add(sign3);

		tokenBox.setSigns(signs2);

		assertEquals("test2", tokenBox.getText());
		assertEquals(tokenId2, tokenBox.getId());
		assertEquals(signs2, tokenBox.getSignItems());
		assertEquals(sign2, tokenBox.getSelectedSign());
		assertEquals(0, tokenBox.getSelectedSignIndex());
		assertEquals(sign2.getSignWidth() + +tokenBox.getMarginRight_PX() + tokenBox.getPaddingLeft_PX()
				+ tokenBox.getPaddingRight_PX(), tokenBox.getWidth_PX(), 0);
		assertEquals(207, tokenBox.getHeight_PX());

		tokenBox.selectSign(1);

		assertEquals("test2", tokenBox.getText());
		assertEquals(tokenId2, tokenBox.getId());
		assertEquals(signs2, tokenBox.getSignItems());
		assertEquals(sign3, tokenBox.getSelectedSign());
		assertEquals(1, tokenBox.getSelectedSignIndex());
		assertEquals(sign3.getSignWidth() + +tokenBox.getMarginRight_PX() + tokenBox.getPaddingLeft_PX()
				+ tokenBox.getPaddingRight_PX(), tokenBox.getWidth_PX(), 0);
		assertEquals(207, tokenBox.getHeight_PX());
	}
}
