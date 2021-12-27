package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;

public class TokenFactoryTest {

	private TokenFactory tokenFactory;
	private IdFactory idFactory;
	private SignLocale signLocale;
	private TextbasedTokenStyleFactory tokenStyleFactory;
	private ReadOnlyTextbasedTokenStyle customStyle;

	@Before
	public void setUp() {
		idFactory = new IdFactory(10);
		tokenFactory = new TokenFactory(idFactory);
		signLocale = SignLocale.DGS;
		tokenStyleFactory = new TextbasedTokenStyleFactory();
		customStyle = tokenStyleFactory.createTextbasedTokenStyle(FontSize.SIZE_24, Color.BLUE, Color.CYAN,
				FontStyle.ITALIC, FontWeight.BOLD, Font.COURIER);
	}

	@Test
	public void testCreateEmptySignItemToken() throws Exception {
		// Prepare
		SignItemToken signItemToken;

		// Action
		signItemToken = tokenFactory.createEmptySignItemToken(customStyle, Color.WHITE, signLocale);

		// Check
		assertEquals(signLocale, signItemToken.getLocale());
		assertEquals(customStyle, signItemToken.getStyle());
		assertTrue(signItemToken.isEmpty());
		assertNotNull(signItemToken.getId());
	}

	@Test
	public void testCreateSignItemToken() throws Exception {
		// Prepare
		String word = "testWord";
		Id testId = idFactory.createId();
		SignItem dummySignItem = createDummySignItem();
		SignItemToken signItemToken;
		SignItemToken signItemToken2;
		SignItemToken signItemToken3;

		// Action
		signItemToken = tokenFactory.createSignItemToken(word, customStyle, Color.WHITE, signLocale);
		signItemToken2 = tokenFactory.createSignItemToken(word, createDummySignItem(), customStyle, Color.WHITE,
				signLocale);
		signItemToken3 = tokenFactory.createSignItemToken(word, createDummySignItem(), testId, customStyle, Color.WHITE,
				signLocale, false, false);

		// Check
		assertEquals(signLocale, signItemToken.getLocale());
		assertEquals(customStyle, signItemToken.getStyle());
		assertFalse(signItemToken.isEmpty());
		assertEquals(word, signItemToken.getText());
		assertNotNull(signItemToken.getId());

		assertEquals(signLocale, signItemToken2.getLocale());
		assertEquals(customStyle, signItemToken2.getStyle());
		assertFalse(signItemToken2.isEmpty());
		assertEquals(word, signItemToken2.getText());
		assertEquals(dummySignItem, signItemToken2.getSignItem());
		assertNotNull(signItemToken2.getId());

		assertEquals(signLocale, signItemToken3.getLocale());
		assertEquals(customStyle, signItemToken3.getStyle());
		assertFalse(signItemToken3.isEmpty());
		assertEquals(word, signItemToken3.getText());
		assertEquals(dummySignItem, signItemToken3.getSignItem());
		assertEquals(testId, signItemToken3.getId());
	}

	@Test
	public void testCreateFreeTextLineToken() throws Exception {
		// Prepare
		FreeTextToken freeTextLine;

		// Action
		freeTextLine = tokenFactory.createFreeTextLineToken(customStyle);

		// Check
		assertTrue(freeTextLine.isFreeTextLine());
		assertTrue(freeTextLine.isEmpty());
		assertEquals(customStyle, freeTextLine.getStyle());
	}

	@Test
	public void testCreateFreeTextToken() throws Exception {
		// Prepare
		String text = "testText";
		Id testId = idFactory.createId();
		FreeTextToken freeTextToken1;
		FreeTextToken freeTextToken2;
		FreeTextToken freeTextToken3;

		// Action
		freeTextToken1 = tokenFactory.createFreeTextToken(customStyle);
		freeTextToken2 = tokenFactory.createFreeTextToken(testId, customStyle);
		freeTextToken3 = tokenFactory.createFreeTextToken(testId, text, customStyle);

		// Check
		assertFalse(freeTextToken1.isFreeTextLine());
		assertTrue(freeTextToken1.isEmpty());
		assertEquals(customStyle, freeTextToken1.getStyle());

		assertFalse(freeTextToken2.isFreeTextLine());
		assertTrue(freeTextToken2.isEmpty());
		assertEquals(customStyle, freeTextToken2.getStyle());
		assertEquals(testId, freeTextToken2.getId());

		assertFalse(freeTextToken3.isFreeTextLine());
		assertFalse(freeTextToken3.isEmpty());
		assertEquals(customStyle, freeTextToken3.getStyle());
		assertEquals(testId, freeTextToken3.getId());
		assertEquals(text, freeTextToken3.getText());
	}

	@Test
	public void testCreateFrameToken() throws Exception {
		// Prepare
		Id testId = idFactory.createId();
		FrameToken frameToken1;
		FrameToken frameToken2;

		// Action
		frameToken1 = tokenFactory.createFrameToken();
		frameToken2 = tokenFactory.createFrameToken(testId);

		// Check
		assertTrue(frameToken1 instanceof FrameToken);
		assertTrue(frameToken2 instanceof FrameToken);
		assertEquals(testId, frameToken2.getId());
	}

	@Test
	public void testCreateVideoToken() throws Exception {
		// Prepare
		Id testId = idFactory.createId();
		VideoToken videoToken1;
		VideoToken videoToken2;

		// Action
		videoToken1 = tokenFactory.createVideoToken();
		videoToken2 = tokenFactory.createVideoToken(testId);

		// Check
		assertTrue(videoToken1 instanceof VideoToken);
		assertTrue(videoToken2 instanceof VideoToken);
		assertEquals(testId, videoToken2.getId());
	}

	@Test
	public void testCreateFormToken() throws Exception {
		// Prepare
		Id testId = idFactory.createId();
		ReadOnlyTextbasedTokenStyle tokenStyle = tokenStyleFactory.createDefaultTextbasedTokenStyle();
		FormToken formToken1;
		FormToken formToken2;

		// Action
		formToken1 = tokenFactory.createFormToken(testId, tokenStyle, "");
		formToken2 = tokenFactory.createFormToken(tokenStyle, "");

		// Check
		assertTrue(formToken1 instanceof FormToken);
		assertTrue(formToken2 instanceof FormToken);
		assertEquals(testId, formToken1.getId());
	}

	@Test
	public void testCreateImageToken() throws Exception {
		// Prepare
		Id testId = idFactory.createId();
		ImageToken imageToken1;
		ImageToken imageToken2;

		// Action
		imageToken1 = tokenFactory.createImageToken();
		imageToken2 = tokenFactory.createImageToken(testId);

		// Check
		assertTrue(imageToken1 instanceof ImageToken);
		assertTrue(imageToken2 instanceof ImageToken);
		assertEquals(testId, imageToken2.getId());
	}

	@Test
	public void testCreateTagToken() throws Exception {
		// Prepare
		Id testId = idFactory.createId();
		ReadOnlyTextbasedTokenStyle tokenstyle = tokenStyleFactory.createDefaultTextbasedTokenStyle();
		TagToken tagToken1;
		TagToken tagToken2;

		// Action
		tagToken1 = tokenFactory.createTagToken(tokenstyle);
		tagToken2 = tokenFactory.createTagToken(testId, tokenstyle);

		// Check
		assertTrue(tagToken1 instanceof TagToken);
		assertTrue(tagToken2 instanceof TagToken);
		assertEquals(testId, tagToken2.getId());
	}

	@Test
	public void testCreateNewTokenFromTokenForSignItemToken() throws Exception {
		// Prepare
		SignItemToken originalSignItemToken = tokenFactory.createSignItemToken("test", createDummySignItem(),
				customStyle, Color.WHITE, signLocale);
		originalSignItemToken.setBackgroundColor(Color.DARK_RED);
		Token token;
		SignItemToken newSignItemToken;

		// Action
		token = tokenFactory.createNewTokenFromToken(originalSignItemToken);

		// Check
		assertTrue(token instanceof SignItemToken);
		newSignItemToken = (SignItemToken) token;
		assertEquals(originalSignItemToken.getText(), newSignItemToken.getText());
		assertEquals(originalSignItemToken.getSignItem(), newSignItemToken.getSignItem());
		assertEquals(originalSignItemToken.getStyle(), newSignItemToken.getStyle());
		assertEquals(originalSignItemToken.getBackgroundColor(), newSignItemToken.getBackgroundColor());
		assertFalse(originalSignItemToken.getId().equals(newSignItemToken.getId()));
	}

	@Test
	public void testCreateNewTokenFromTokenForFreeTextLine() throws Exception {
		// Prepare
		FreeTextToken originalFreeTextLine = tokenFactory.createFreeTextLineToken(customStyle);
		originalFreeTextLine.setText("TestText");
		Token token;
		FreeTextToken newFreeTextLine;

		// Action
		token = tokenFactory.createNewTokenFromToken(originalFreeTextLine);

		// Check
		assertTrue(token instanceof FreeTextToken);
		newFreeTextLine = (FreeTextToken) token;
		assertTrue(newFreeTextLine.isFreeTextLine());
		assertFalse(newFreeTextLine.isEmpty());
		assertEquals(originalFreeTextLine.getText(), newFreeTextLine.getText());
		assertEquals(originalFreeTextLine.getStyle(), newFreeTextLine.getStyle());
		assertFalse(originalFreeTextLine.getId().equals(newFreeTextLine.getId()));
	}

	@Test
	public void testCreateNewTokenFromTokenForFreeTextToken() throws Exception {
		// Prepare
		FreeTextToken originalFreeTextToken = tokenFactory.createFreeTextToken(customStyle);
		originalFreeTextToken.setText("TestText");
		Token token;
		FreeTextToken newFreeTextToken;

		// Action
		token = tokenFactory.createNewTokenFromToken(originalFreeTextToken);

		// Check
		assertTrue(token instanceof FreeTextToken);
		newFreeTextToken = (FreeTextToken) token;
		assertFalse(newFreeTextToken.isFreeTextLine());
		assertFalse(newFreeTextToken.isEmpty());
		assertEquals(originalFreeTextToken.getText(), newFreeTextToken.getText());
		assertEquals(originalFreeTextToken.getStyle(), newFreeTextToken.getStyle());
		assertFalse(originalFreeTextToken.getId().equals(newFreeTextToken.getId()));
	}

	@Test
	public void testCreateNewTokenFromTokenForFormToken() throws Exception {
		// Prepare
		ReadOnlyTextbasedTokenStyle tokenStyle = tokenStyleFactory.createDefaultTextbasedTokenStyle();
		FormToken originalFormToken = tokenFactory.createFormToken(tokenStyle, "Testformular");
		Token token;
		FormToken newFormToken;
		originalFormToken.setInputContent("Testeingabe");
		originalFormToken.setDescriptionWidth(42);
		originalFormToken.setBackgroundColor(Color.makeFromRGB(42, 13, 11));
		originalFormToken.setFontColor(Color.makeFromHSV(0.0, 100.0, 0.0));
		originalFormToken.setWidthPx(300);

		// Action
		token = tokenFactory.createNewTokenFromToken(originalFormToken);

		// Check
		assertTrue(token instanceof FormToken);
		newFormToken = (FormToken) token;
		assertEquals(originalFormToken.getDescription(), newFormToken.getDescription());
		assertEquals(originalFormToken.getInputContent(), newFormToken.getInputContent());
		assertEquals(originalFormToken.getDescriptionWidthPx(), newFormToken.getDescriptionWidthPx());
		assertEquals(originalFormToken.getFontColor(), newFormToken.getFontColor());
		assertEquals(originalFormToken.getInputWidthPx(), newFormToken.getInputWidthPx());
		assertEquals(originalFormToken.getStyle(), newFormToken.getStyle());
		assertEquals(originalFormToken.getWidthPx(), newFormToken.getWidthPx());
		assertFalse(originalFormToken.getId().equals(newFormToken.getId()));
		assertTrue(originalFormToken.getPattern().equals(newFormToken.getPattern()));
		assertTrue(newFormToken.getPattern().equals(newFormToken.getDefaultPattern()));
	}

	@Test
	public void testCreateNewTokenFromTokenForImageToken() throws Exception {
		// Prepare
		ImageToken originalImageToken = tokenFactory.createImageToken();
		originalImageToken.setUrl("www.xyz.de");
		originalImageToken.setBackgroundColor(Color.CYAN);
		originalImageToken.setHeight(100);
		originalImageToken.setWidth(55);
		Token token;
		ImageToken newImageToken;

		// Action
		token = tokenFactory.createNewTokenFromToken(originalImageToken);

		// Check
		assertTrue(token instanceof ImageToken);
		newImageToken = (ImageToken) token;
		assertEquals(originalImageToken.getUrl(), newImageToken.getUrl());
		assertEquals(originalImageToken.getBackgroundColor(), newImageToken.getBackgroundColor());
		assertEquals(originalImageToken.getHeight(), newImageToken.getHeight());
		assertEquals(originalImageToken.getWidth(), newImageToken.getWidth());
		assertFalse(originalImageToken.getId().equals(newImageToken.getId()));
	}

	@Test
	public void testCreateNewTokenFromTokenForVideoToken() throws Exception {
		// Prepare
		VideoToken originalVideoToken = tokenFactory.createVideoToken();
		originalVideoToken.setUrl("www.xyz.de");
		originalVideoToken.setUrlVisible(false);
		originalVideoToken.setBackgroundColor(Color.CYAN);
		originalVideoToken.setHeight(100);
		originalVideoToken.setWidth(55);
		Token token;
		VideoToken newVideoToken;

		// Action
		token = tokenFactory.createNewTokenFromToken(originalVideoToken);

		// Check
		assertTrue(token instanceof VideoToken);
		newVideoToken = (VideoToken) token;
		assertEquals(originalVideoToken.getUrl(), newVideoToken.getUrl());
		assertEquals(originalVideoToken.isUrlVisible(), newVideoToken.isUrlVisible());
		assertEquals(originalVideoToken.getBackgroundColor(), newVideoToken.getBackgroundColor());
		assertEquals(originalVideoToken.getHeight(), newVideoToken.getHeight());
		assertEquals(originalVideoToken.getWidth(), newVideoToken.getWidth());
		assertFalse(originalVideoToken.getId().equals(newVideoToken.getId()));
	}

	@Test
	public void testCreateNewTokenFromTokenForFrameToken() throws Exception {
		// Prepare
		FrameToken originalframeToken = tokenFactory.createFrameToken();
		originalframeToken.setBackgroundColor(Color.GOLDENYELLOW);
		originalframeToken.setFrameColor(Color.GRASSGREEN);
		originalframeToken.setBorderWidth(33);
		originalframeToken.setHeight(45);
		originalframeToken.setWidth(42);
		Token token;
		FrameToken newFrameToken;

		// Action
		token = tokenFactory.createNewTokenFromToken(originalframeToken);

		// Check
		assertTrue(token instanceof FrameToken);
		newFrameToken = (FrameToken) token;
		assertEquals(originalframeToken.getBackgroundColor(), newFrameToken.getBackgroundColor());
		assertEquals(originalframeToken.getFrameColor(), newFrameToken.getFrameColor());
		assertEquals(originalframeToken.getBorderWidth_PX(), newFrameToken.getBorderWidth_PX());
		assertEquals(originalframeToken.getWidth(), newFrameToken.getWidth());
		assertEquals(originalframeToken.getHeight(), newFrameToken.getHeight());
		assertFalse(originalframeToken.getId().equals(newFrameToken.getId()));
	}

	@Test
	public void testCreateNewTokenFromTokenForTagToken() throws Exception {
		ReadOnlyTextbasedTokenStyle tokenStyle = tokenStyleFactory.createDefaultTextbasedTokenStyle();
		// Prepare
		TagToken originalTagToken = tokenFactory.createTagToken(tokenStyle);
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		originalTagToken.setBackgroundColor(Color.BLACK);
		originalTagToken.setWidth(42);
		originalTagToken.setItemList(list);
		originalTagToken.setSelectedItemList(list);
		originalTagToken.setText("");
		Token token;
		TagToken newTagToken;

		// Action
		token = tokenFactory.createNewTokenFromToken(originalTagToken);

		// Check
		assertTrue(token instanceof TagToken);
		newTagToken = (TagToken) token;
		assertEquals(originalTagToken.getBackgroundColor(), newTagToken.getBackgroundColor());
		assertEquals(originalTagToken.getWidth(), newTagToken.getWidth());
		assertFalse(originalTagToken.getId().equals(newTagToken.getId()));
		assertEquals(originalTagToken.getItemList(), newTagToken.getItemList());
		assertEquals(originalTagToken.getSelectedItemList(), newTagToken.getSelectedItemList());
		assertEquals(originalTagToken.getText(), newTagToken.getText());
	}

	private SignItem createDummySignItem() {
		SignId signId = new SignId(12345, "ein_Test_ohne_Sign", signLocale, SignSource.DELEGS);
		SignItem signItem = new SignItem(signId, 10);
		return signItem;
	}
}
