package de.signWritingEditor.test.integration.misc.unit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;

import de.signWritingEditor.client.GWTClient.infrastructure.JsonConverter;
import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.HairBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.JawBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NeckBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NoseBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.VideoToken;

public class JsonConverterTest extends GWTTestCase {

	private IdFactory idFactory;
	private JsonConverter jsonSerializer;
	private JsonConverter jsonDeserializer;
	private PositionedSymbolFactory positionedSymbolFactory;
	private TokenFactory tokenFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Override
	protected void gwtSetUp() throws Exception {
		idFactory = new IdFactory(System.currentTimeMillis());
		tokenFactory = new TokenFactory(idFactory);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		positionedSymbolFactory = new PositionedSymbolFactory();
		jsonDeserializer = new JsonConverter(tokenFactory, textbasedTokenStyleFactory, positionedSymbolFactory);
		jsonSerializer = new JsonConverter(tokenFactory, textbasedTokenStyleFactory, positionedSymbolFactory);
	}

	protected IdFactory getIdFactory() {
		return idFactory;
	}

	@Override
	public String getModuleName() {
		return "de.signWritingEditor.SignWritingEditor";
	}

	@Test
	public void testConvertSignItemTokenWithIdFactory() {
		// Prepare
		Id signItemTokenId = getIdFactory().createId();
		SignItem signItem = new SignItem(new SimpleSign(new SignId(3245, "l", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(2), "Test comment"));
		SignItemToken signItemToken = tokenFactory.createSignItemToken("test", signItem, signItemTokenId,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		JsonConverter jsonDeserializerWithIdFactory = new JsonConverter(tokenFactory, textbasedTokenStyleFactory,
				positionedSymbolFactory);

		// Action
		String jsonString = jsonSerializer.convert(signItemToken);
		SignItemToken reconvertedSignItemToken = jsonDeserializerWithIdFactory.reconvert(jsonString);

		// Check
		assertEquals(signItemTokenId, reconvertedSignItemToken.getId());

		assertEquals(signItemToken.getSignItem(), reconvertedSignItemToken.getSignItem());
		assertEquals(signItemToken.getText(), reconvertedSignItemToken.getText());
	}

	@Test
	public void testConvertParagraphWithDifferentTokens() {
		// Prepare
		Id paragraphId = getIdFactory().createId();
		Id signItemTokenId = getIdFactory().createId();
		Id freeTextTokenId = getIdFactory().createId();
		Paragraph paragraph = new Paragraph(paragraphId, 130, 12, 12, 1);
		SignItem signItem = new SignItem(new SimpleSign(new SignId(3245, "l", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(2), "Test comment"));

		Font defaultFont = TextbasedTokenStyleFactory.DEFAULT_FONT;
		FontSize defaultFontSize = TextbasedTokenStyleFactory.DEFAULT_FONT_SIZE;
		Color defaultFontColor = Color.BLACK;
		FontStyle defaultFontStyle = TextbasedTokenStyleFactory.DEFAULT_FONT_STYLE;
		Color defaultTextBackgroundColor = Color.GREY;

		SignItemToken signItemToken = tokenFactory.createSignItemToken("test", signItem, signItemTokenId,
				textbasedTokenStyleFactory.createTextbasedTokenStyle(defaultFontSize, defaultFontColor,
						defaultTextBackgroundColor, defaultFontStyle, FontWeight.BOLD, defaultFont),
				Color.WHITE, SignLocale.DGS, false, false);

		FreeTextToken freeTextToken = tokenFactory.createFreeTextToken(freeTextTokenId,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		paragraph.addToken(signItemToken);
		paragraph.addToken(freeTextToken);

		// Action
		String jsonString = jsonSerializer.convert(paragraph);
		Paragraph newParagraph = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(paragraph, newParagraph);
	}

	@Test
	public void testConvertParagraphAndCheckOrderOfTokenList() {
		// Prepare
		Id paragraphId = getIdFactory().createId();
		Paragraph paragraph = new Paragraph(paragraphId, 130, 12, 12, 1);
		int tokenCount = 5;
		for (int i = 0; i < tokenCount; i++) {
			SignItemToken signItemToken = tokenFactory.createEmptySignItemToken(
					textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
			paragraph.addToken(signItemToken);
		}

		// Action
		String jsonString = jsonSerializer.convert(paragraph);
		Paragraph newParagraph = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(paragraph, newParagraph);
	}

	@Test
	public void testConvertSection() {
		// Prepare
		Section section = new Section();

		// Action
		String jsonString = jsonSerializer.convert(section);
		Section newSection = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(section, newSection);
	}

	@Test
	public void testConvertSectionWithParagraph() {
		// Prepare
		Section section = new Section();
		Id paragraphId = getIdFactory().createId();
		Paragraph paragraph = new Paragraph(paragraphId);
		SignItemToken signItemToken = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph.addToken(signItemToken);
		section.addParagraph(paragraph);

		// Action
		String jsonString = jsonSerializer.convert(section);
		Section newSection = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(section, newSection);
	}

	@Test
	public void testConvertFreeTextWithAttributes() {
		// Prepare
		FreeTextToken freeTextToken = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createTextbasedTokenStyle(FontSize.SIZE_10, Color.BLUE,
						Color.RED, FontStyle.ITALIC, FontWeight.BOLD, Font.COURIER));
		freeTextToken.setText("Testtext");
		freeTextToken.setFixedWidth(true, 123);
		freeTextToken.setIsFreeTextLine(true);

		// Action
		String jsonString = jsonSerializer.convert(freeTextToken);
		FreeTextToken newFreeTextToken = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(freeTextToken, newFreeTextToken);
	}

	@Test
	public void testConvertVideoToken() {
		// Prepare
		VideoToken videoToken = tokenFactory.createVideoToken();
		videoToken.setUrl("test.mp4");

		// Action
		String jsonString = jsonSerializer.convert(videoToken);
		VideoToken newVideoToken = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(videoToken, newVideoToken);
	}

	@Test
	public void testConvertFrameToken() {
		// Prepare
		Id frameTokenId = getIdFactory().createId();
		FrameToken frameToken = tokenFactory.createFrameToken(frameTokenId);

		// Action
		String jsonString = jsonSerializer.convert(frameToken);
		FrameToken newFrameToken = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(frameToken, newFrameToken);
	}

	@Test
	public void testConvertFrameTokenWithAttributes() {
		// Prepare
		FrameToken frameToken = tokenFactory.createFrameToken();
		frameToken.setHeight(160);
		frameToken.setWidth(99);
		frameToken.setFrameColor(Color.RED);
		frameToken.setBackgroundColor(Color.BLUE);
		frameToken.setBorderWidth(3);

		// Action
		String jsonString = jsonSerializer.convert(frameToken);
		FrameToken newFrameToken = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(frameToken, newFrameToken);
	}

	@Test
	public void testConvertEmptyFreeTextToken() {
		// Prepare
		FreeTextToken freeTextToken = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		String jsonString = jsonSerializer.convert(freeTextToken);
		FreeTextToken newFreeTextToken = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(freeTextToken, newFreeTextToken);
	}

	@Test
	public void testConvertSignItemTokenWithAttributes() {
		// Prepare
		Id signItemTokenId = getIdFactory().createId();
		SignItem signItem = new SignItem(new SimpleSign(new SignId(3245, "l", SignLocale.ASL, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(2), "Test comment"));

		FontStyle defaultFontStyle = TextbasedTokenStyleFactory.DEFAULT_FONT_STYLE;
		Font defaultFont = TextbasedTokenStyleFactory.DEFAULT_FONT;

		SignItemToken signItemToken = tokenFactory
				.createSignItemToken("Test", signItem, signItemTokenId,
						textbasedTokenStyleFactory.createTextbasedTokenStyle(FontSize.SIZE_18, Color.BLUE, Color.RED,
								defaultFontStyle, FontWeight.BOLD, defaultFont),
						Color.WHITE, SignLocale.DGS, false, false);

		signItemToken.setBackgroundColor(Color.GREEN);
		signItemToken.setSignLocale(SignLocale.BSL);

		// Action
		String jsonString = jsonSerializer.convert(signItemToken);
		SignItemToken newSignItemToken = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(signItemToken.getBackgroundColor(), newSignItemToken.getBackgroundColor());
		assertEquals(signItemToken.getFontColor(), newSignItemToken.getFontColor());
		assertEquals(signItemToken.getSignHeight_PX(), newSignItemToken.getSignHeight_PX());
		assertEquals(signItemToken.getText(), newSignItemToken.getText());
		assertEquals(signItemToken.getTextBackgroundColor(), newSignItemToken.getTextBackgroundColor());
		assertEquals(signItemToken.getStyle().getFontMetricSpecifier(),
				newSignItemToken.getStyle().getFontMetricSpecifier());
		assertEquals(signItemToken.getLocale(), newSignItemToken.getLocale());
		assertEquals(signItemToken.getSignItem(), newSignItemToken.getSignItem());
		assertEquals(signItemToken.getStyle(), newSignItemToken.getStyle());
		assertTrue(signItemToken.getStyle() != newSignItemToken.getStyle());
	}

	@Test
	public void testConvertEmptySignItemToken() {
		// Prepare
		SignItemToken signItemToken = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		// Action
		String jsonString = jsonSerializer.convert(signItemToken);
		SignItemToken newSignItemToken = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(signItemToken, newSignItemToken);
	}

	@Test
	public void testConvertList() {
		// Prepare
		SignItem signItem = new SignItem(new SimpleSign(new SignId(3245, "l", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(2), "Test comment"));
		List<SignItem> list = new ArrayList<SignItem>();
		list.add(signItem);

		// Action
		String jsonString = jsonSerializer.convert(list);
		List<SignItem> newList = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(list, newList);
	}

	@Test
	public void testConvertParagraph() {
		// Prepare
		Id paragraphId = getIdFactory().createId();
		Paragraph paragraph = new Paragraph(paragraphId, 100, 10, 10, 1);

		// Action
		String jsonString = jsonSerializer.convert(paragraph);
		Paragraph newParagraph = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(paragraph, newParagraph);
	}

	@Test
	public void testConvertSignItem() {
		// Prepare
		SimpleSign expectedLocalSign = new SimpleSign(new SignId(3245, "l", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(2), "Test comment");
		Symbol symbol = new Symbol(1, 2, 3, 4, 5, 6, 7, 8);
		PositionedSymbol positionedSymbol = new PositionedSymbol(symbol, 10, 10, 1);
		HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(
				positionedSymbolFactory.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_RIMS.getIswaSymbol()), //
				positionedSymbolFactory
						.createPositionedSymbol(EyesBaseSymbol.DREAMY_EYEBROWS_UP_NEUTRAL.getIswaSymbol()), //
				positionedSymbolFactory.createPositionedSymbol(NoseBaseSymbol.NOSE_WIGGLES.getIswaSymbol()), //
				positionedSymbolFactory.createPositionedSymbol(CheeksBaseSymbol.CHEEKS_NEUTRAL.getIswaSymbol()), //
				positionedSymbolFactory.createPositionedSymbol(MouthBaseSymbol.MOUTH_SMILE.getIswaSymbol()), //
				positionedSymbolFactory.createPositionedSymbol(EarsBaseSymbol.EARS.getIswaSymbol()), //
				positionedSymbolFactory.createPositionedSymbol(BreathBaseSymbol.AIR_BLOWING_OUT.getIswaSymbol()), //
				positionedSymbolFactory.createPositionedSymbol(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol()), //
				positionedSymbolFactory.createPositionedSymbol((NeckBaseSymbol.NECK.getIswaSymbol())), //
				positionedSymbolFactory.createPositionedSymbol((HairBaseSymbol.HAIR.getIswaSymbol())));//
		expectedLocalSign.addSymbol(positionedSymbol);
		expectedLocalSign.addHeadSymbol(headSymbol);
		SignItem expectedSignItem = new SignItem(expectedLocalSign);

		// Action
		String jsonString = jsonSerializer.convert(expectedSignItem);
		SignItem actualSignItem = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(expectedSignItem, actualSignItem);
	}

	@Test
	public void testConvertHeadSymbol() {
		// Prepare
		SimpleSign expectedLocalSign = new SimpleSign(new SignId(3245, "l", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(2), "Test comment");

		List<PositionedSymbol> allSymbols = new ArrayList<PositionedSymbol>();
		// Eyes
		int testValue = 36;
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 1, 1, 6, 1, testValue, testValue), Location.LEFT));
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 1, 1, 5, 1, testValue, testValue), Location.RIGHT));
		// Mouth
		allSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 4, 4, 2, 2, 1, testValue, testValue)));
		// Cheeks
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 1, 2, 4, 1, testValue, testValue), Location.LEFT));
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 1, 2, 5, 1, testValue, testValue), Location.RIGHT));
		// Ears
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 3, 1, 5, 1, testValue, testValue), Location.LEFT));
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 3, 1, 4, 1, testValue, testValue), Location.RIGHT));
		// Nose
		allSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 3, 4, 1, 2, 1, testValue, testValue)));
		// Breath
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 5, 1, 6, 1, testValue, testValue), Location.LEFT));
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 5, 1, 5, 1, testValue, testValue), Location.RIGHT));
		// Jaw
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 9, 1, 2, 1, testValue, testValue), Location.LEFT));
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(Symbol.JAW_PART_HEAD_RIM, Location.BOTH));
		allSymbols.add(positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 9, 1, 2, 1, testValue, testValue), Location.RIGHT));
		// Neck
		allSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 11, 1, 2, 1, testValue, testValue)));
		// Hair
		allSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 12, 1, 2, 1, testValue, testValue)));
		// Expression
		allSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 13, 1, 2, 1, testValue, testValue)));

		PositionedHeadPostureSymbol positionedHeadPosture = (PositionedHeadPostureSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 1, 1, 1, 1, testValue, testValue));

		HeadSymbol expectedHeadSymbol = positionedSymbolFactory.createHeadSymbol(positionedHeadPosture, 0, 30, 2,
				allSymbols.toArray(new PositionedSymbol[allSymbols.size()]));

		expectedLocalSign.addHeadSymbol(expectedHeadSymbol);
		SignItem expectedSignItem = new SignItem(expectedLocalSign);

		// Action
		String jsonString = jsonSerializer.convert(expectedSignItem);
		SignItem actualSignItem = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(expectedSignItem, actualSignItem);
		assertEquals(expectedLocalSign, actualSignItem.getLocalSign());
		assertEquals(1, actualSignItem.getLocalSign().getHeadSymbolCount());
		assertEquals(expectedHeadSymbol, actualSignItem.getLocalSign().getHeadSymbolAt(0));
	}

	@Test
	public void testConvertEmptyHeadSymbol() {
		// Prepare
		SimpleSign expectedLocalSign = new SimpleSign(new SignId(3245, "l", SignLocale.DGS, SignSource.IMPORTED),
				User.getSystemUser(), SignLocale.DGS, new Date(2), "Test comment");

		HeadSymbol expectedHeadSymbol = positionedSymbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 0, 30, 2);

		expectedLocalSign.addHeadSymbol(expectedHeadSymbol);
		SignItem expectedSignItem = new SignItem(expectedLocalSign);

		// Action
		String jsonString = jsonSerializer.convert(expectedSignItem);
		SignItem actualSignItem = jsonDeserializer.reconvert(jsonString);

		// Check
		assertEquals(expectedSignItem, actualSignItem);
		assertEquals(expectedLocalSign, actualSignItem.getLocalSign());
		assertEquals(1, actualSignItem.getLocalSign().getHeadSymbolCount());
		assertEquals(expectedHeadSymbol, actualSignItem.getLocalSign().getHeadSymbolAt(0));
	}
}
