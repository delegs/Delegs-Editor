package de.signWritingEditor.server.persistence.documentConverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentJSONConverter;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedBreathSymbol;
import de.signWritingEditor.shared.model.material.PositionedCheekSymbol;
import de.signWritingEditor.shared.model.material.PositionedEarsSymbol;
import de.signWritingEditor.shared.model.material.PositionedExpressionSymbol;
import de.signWritingEditor.shared.model.material.PositionedEyeSymbol;
import de.signWritingEditor.shared.model.material.PositionedHairSymbol;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedJawSymbol;
import de.signWritingEditor.shared.model.material.PositionedMouthSymbol;
import de.signWritingEditor.shared.model.material.PositionedNeckSymbol;
import de.signWritingEditor.shared.model.material.PositionedNoseSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.VideoToken;

public class DocumentJSONConverterTest {
	private DocumentJSONConverter jsonConverter;
	private TokenFactory tokenFactory;
	private IdFactory idFactory;
	private SymbolFactory symbolFactory;
	private UserDb userDb;
	private SignDB signDB;
	private String comment;
	private DbConnector connector;
	private PositionedSymbolFactory positionedSymbolFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp() throws IOException {
		ConfigurationService configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		connector = new DbConnector(configurationService);

		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		userDb = new UserDb(connector);
		signDB = new SignDB(connector, userDb, symbolFactory, configurationService);
		int uniqueNumber = 3;
		idFactory = new IdFactory(uniqueNumber);
		tokenFactory = new TokenFactory(idFactory);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		jsonConverter = new DocumentJSONConverter(userDb, signDB, tokenFactory);
		comment = "Das ist ein Kommentar";
		positionedSymbolFactory = new PositionedSymbolFactory();
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testDocumentWithEmptyCollage() {
		// Prepare
		User documentAuthor = new User("unknown", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(documentAuthor, SignLocale.DGS, new FileTitle("title"),
				PageFormat.A4_PORTRAIT);

		// first section, not free positioned:
		Section section1 = new Section();
		document.addSection(section1);

		// second section, free positioned
		Section emptyCollage = new Section();
		emptyCollage.setIsCollage(true, idFactory.createId());
		document.addSection(emptyCollage);

		// third section, not free positioned:
		Section section3 = new Section();
		document.addSection(section3);

		// Actions
		String jsonString = jsonConverter.toJson(document);

		// Check
		String expectedString = //
				"{\"templateVersion\":-1.0,\"fileTitle\":\"title\",\"sections\":[{\"paragraphs\":[],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphs\":[],\"isCollage\":true,\"collageId\":\"3:1\",\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphs\":[],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false}],\"localDictionary\":{\"dictionary\":{}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":true,\"automaticFreeTextLineEnabled\":true,\"showCollageGrid\":true,\"lockedLayout\":false,\"lockedContent\":false,\"templateName\":\"\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}";
		assertEquals(expectedString, jsonString);
	}

	@Test
	public void testDocumentWithCollageAndParagraph() {
		// Prepare
		User documentAuthor = new User("unknown", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(documentAuthor, SignLocale.DGS, new FileTitle("title"),
				PageFormat.A4_PORTRAIT);

		// first section, not free positioned:
		Section section1 = new Section();
		document.addSection(section1);

		// second section with paragraph, free positioned
		Section collage = new Section();
		collage.setIsCollage(true, idFactory.createId());
		Id snippetId = idFactory.createId();
		int width = 100;
		int xPos = 10;
		int yPos = 10;
		int zIndex = 0;
		Paragraph snippet = new Paragraph(snippetId, width, xPos, yPos, zIndex);
		collage.addParagraph(snippet);
		document.addSection(collage);

		// third section, not free positioned:
		Section section3 = new Section();
		document.addSection(section3);

		// Actions
		String jsonString = jsonConverter.toJson(document);

		// Check
		String expectedString = //
				"{\"templateVersion\":-1.0,\"fileTitle\":\"title\",\"sections\":[{\"paragraphs\":[],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphs\":[{\"paragraphId\":\"3:2\",\"tokens\":[],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":100,\"positionX\":10,\"positionY\":10,\"automaticResize\":true,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false}],\"isCollage\":true,\"collageId\":\"3:1\",\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphs\":[],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false}],\"localDictionary\":{\"dictionary\":{}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":true,\"automaticFreeTextLineEnabled\":true,\"showCollageGrid\":true,\"lockedLayout\":false,\"lockedContent\":false,\"templateName\":\"\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}";
		assertEquals(expectedString, jsonString);
	}

	@Test
	public void testAll() throws IOException {
		User documentAuthor = new User("unknown", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(documentAuthor, SignLocale.DGS, new FileTitle("title"),
				PageFormat.A4_PORTRAIT);

		// simple document

		String jsonString1 = jsonConverter.toJson(document);
		String expString1 = "{\"templateVersion\":-1.0,\"fileTitle\":\"title\",\"sections\":[],\"localDictionary\":{\"dictionary\":{}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":true,\"automaticFreeTextLineEnabled\":true,\"showCollageGrid\":true,\"lockedLayout\":false,\"lockedContent\":false,\"templateName\":\"\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}";
		assertEquals(expString1, jsonString1);

		Document convertedDocument1 = jsonConverter.fromJson(jsonString1, documentAuthor);
		assertEquals(document, convertedDocument1);

		// first section:

		Section section1 = new Section();
		document.addSection(section1);

		Id paragraphId1 = idFactory.createId();
		Paragraph paragraph1 = new Paragraph(paragraphId1);
		section1.addParagraph(paragraph1);
		SignItemToken token1 = tokenFactory.createSignItemToken("test1",
				new SignItem(new SignId(12345, "test1", SignLocale.DGS, SignSource.DELEGS), 50),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph1.addToken(token1);
		SignItemToken token2 = tokenFactory.createSignItemToken("test2",
				new SignItem(new SignId(12346, "test2", SignLocale.DGS, SignSource.DELEGS), 60),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph1.addToken(token2);

		Id paragraphId2 = idFactory.createId();
		Paragraph paragraph2 = new Paragraph(paragraphId2);
		section1.addParagraph(paragraph2);
		paragraph2.setSearchWordLineVisible(false);

		// second section:

		Section section2 = new Section();
		document.addSection(section2);

		Id paragraphId3 = idFactory.createId();
		Paragraph paragraph3 = new Paragraph(paragraphId3);
		section2.addParagraph(paragraph3);
		paragraph3.setFreeTextLineVisible(false);
		SignItemToken token3 = tokenFactory.createSignItemToken("test3",
				new SignItem(new SignId(12347, "test3", SignLocale.DGS, SignSource.DELEGS), 80),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph3.addToken(token3);

		Id paragraphId4 = idFactory.createId();
		Paragraph paragraph4 = new Paragraph(paragraphId4);
		section2.addParagraph(paragraph4);
		paragraph4.setSignLineVisible(false);
		SignItemToken token4 = tokenFactory.createSignItemToken("test4",
				new SignItem(new SignId(12347, "test4", SignLocale.DGS, SignSource.DELEGS), 80),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph4.addToken(token4);

		// third empty section:

		Section section3 = new Section();
		document.addSection(section3);

		String jsonString2 = jsonConverter.toJson(document);
		String expString2 = //
				"{\"templateVersion\":-1.0,\"fileTitle\":\"title\",\"sections\":[{\"paragraphs\":[{\"paragraphId\":\"3:1\",\"tokens\":[{\"Token\":\"SignItemToken\",\"id\":\"3:2\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":12345,\"lowerIdPart\":\"test1\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"signWidth\":50},\"signVisibility\":true,\"word\":\"test1\",\"searchWordVisibility\":true,\"isLayoutLocked\":false,\"isContentLocked\":false},{\"Token\":\"SignItemToken\",\"id\":\"3:3\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":12346,\"lowerIdPart\":\"test2\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"signWidth\":60},\"signVisibility\":true,\"word\":\"test2\",\"searchWordVisibility\":true,\"isLayoutLocked\":false,\"isContentLocked\":false}],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphId\":\"3:4\",\"tokens\":[],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":false,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false}],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphs\":[{\"paragraphId\":\"3:5\",\"tokens\":[{\"Token\":\"SignItemToken\",\"id\":\"3:6\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":12347,\"lowerIdPart\":\"test3\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"signWidth\":80},\"signVisibility\":true,\"word\":\"test3\",\"searchWordVisibility\":true,\"isLayoutLocked\":false,\"isContentLocked\":false}],\"isFreeTextLineVisible\":false,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphId\":\"3:7\",\"tokens\":[{\"Token\":\"SignItemToken\",\"id\":\"3:8\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":12347,\"lowerIdPart\":\"test4\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"signWidth\":80},\"signVisibility\":true,\"word\":\"test4\",\"searchWordVisibility\":true,\"isLayoutLocked\":false,\"isContentLocked\":false}],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":false,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false}],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphs\":[],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false}],\"localDictionary\":{\"dictionary\":{}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":true,\"automaticFreeTextLineEnabled\":true,\"showCollageGrid\":true,\"lockedLayout\":false,\"lockedContent\":false,\"templateName\":\"\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}";
		assertEquals(expString2, jsonString2);

		Document convertedDocument2 = jsonConverter.fromJson(jsonString2, documentAuthor);
		assertTrue(document.equals(convertedDocument2));

		SimpleSign localSign = new SimpleSign(new SignId(1234567, "TestLocal", SignLocale.DGS, SignSource.DELEGS),
				User.getUnknownUser(), SignLocale.DGS, new Date(0), comment);
		PositionedSymbol posSymbol = new PositionedSymbol(symbolFactory.createSymbol(1, 1, 1, 1, 1, 1), 10, 10, 1);
		localSign.addSymbol(posSymbol);

		document.getLocalDictionary().save(localSign);
		String jsonWithLocalDictionary = jsonConverter.toJson(document);

		String expectedJsonWithLocalDictionary = //
				"{\"templateVersion\":-1.0,\"fileTitle\":\"title\",\"sections\":[{\"paragraphs\":[{\"paragraphId\":\"3:1\",\"tokens\":[{\"Token\":\"SignItemToken\",\"id\":\"3:2\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":12345,\"lowerIdPart\":\"test1\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"signWidth\":50},\"signVisibility\":true,\"word\":\"test1\",\"searchWordVisibility\":true,\"isLayoutLocked\":false,\"isContentLocked\":false},{\"Token\":\"SignItemToken\",\"id\":\"3:3\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":12346,\"lowerIdPart\":\"test2\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"signWidth\":60},\"signVisibility\":true,\"word\":\"test2\",\"searchWordVisibility\":true,\"isLayoutLocked\":false,\"isContentLocked\":false}],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphId\":\"3:4\",\"tokens\":[],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":false,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false}],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphs\":[{\"paragraphId\":\"3:5\",\"tokens\":[{\"Token\":\"SignItemToken\",\"id\":\"3:6\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":12347,\"lowerIdPart\":\"test3\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"signWidth\":80},\"signVisibility\":true,\"word\":\"test3\",\"searchWordVisibility\":true,\"isLayoutLocked\":false,\"isContentLocked\":false}],\"isFreeTextLineVisible\":false,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphId\":\"3:7\",\"tokens\":[{\"Token\":\"SignItemToken\",\"id\":\"3:8\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":12347,\"lowerIdPart\":\"test4\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"signWidth\":80},\"signVisibility\":true,\"word\":\"test4\",\"searchWordVisibility\":true,\"isLayoutLocked\":false,\"isContentLocked\":false}],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":false,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false}],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false},{\"paragraphs\":[],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false}],\"localDictionary\":{\"dictionary\":{\"TestLocal\":[{\"signId\":{\"upperIdPart\":1234567,\"lowerIdPart\":\"TestLocal\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"modificationDate\":"
						+ "0"
						+ ",\"headSymbols\":[],\"disarrangedHeadSymbols\":[],\"handSymbols\":[{\"symbol\":{\"baseSymbol\":{\"category\":1,\"group\":1,\"symbol\":1,\"variation\":1},\"fill\":1,\"rotation\":1,\"width\":15,\"height\":30},\"x\":10,\"y\":10,\"z\":1,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"fingerAlphabetSymbols\":[],\"symbols\":[],\"revision\":0,\"comment\":\"Das ist ein Kommentar\",\"persistenceLocation\":\"NONE\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}]}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":true,\"automaticFreeTextLineEnabled\":true,\"showCollageGrid\":true,\"lockedLayout\":false,\"lockedContent\":false,\"templateName\":\"\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}";

		assertEquals(expectedJsonWithLocalDictionary, jsonWithLocalDictionary);
		Document documentWithLocalDictionary = jsonConverter.fromJson(jsonWithLocalDictionary, documentAuthor);

		assertFalse(documentWithLocalDictionary.getLocalDictionary().isEmpty());
		assertTrue(documentWithLocalDictionary.getLocalDictionary().contains(localSign.getSignId()));
	}

	@Test
	public void testAllTokens() {
		User newUser = new User("unknown", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(newUser, SignLocale.DGS, new FileTitle("title"), PageFormat.A4_PORTRAIT);

		Section section = new Section();
		Paragraph paragraph = new Paragraph(new Id(1, 1));

		FrameToken frameToken = tokenFactory.createFrameToken();
		ImageToken imageToken = tokenFactory.createImageToken();
		VideoToken videoToken = tokenFactory.createVideoToken();
		FreeTextToken freeTextToken = tokenFactory
				.createFreeTextToken(new TextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle());

		paragraph.addToken(frameToken);
		paragraph.addToken(imageToken);
		paragraph.addToken(videoToken);
		paragraph.addToken(freeTextToken);
		section.addParagraph(paragraph);
		document.addSection(section);
		String actual = jsonConverter.toJson(document);
		String expected = "{\"templateVersion\":-1.0,\"fileTitle\":\"title\",\"sections\":[{\"paragraphs\":[{\"paragraphId\":\"1:1\",\"tokens\":[{\"id\":\"3:1\",\"borderWidth_PX\":2,\"width\":150,\"height\":190,\"frameColor\":\"#000000\",\"backgroundColor\":\"#FFFFFF\",\"lockedLayout\":false,\"lockedContent\":false,\"Token\":\"FrameToken\"},{\"id\":\"3:2\",\"backgroundColor\":\"#808080\",\"width\":220,\"height\":207,\"url\":\"\",\"lockedLayout\":false,\"lockedContent\":false,\"Token\":\"ImageToken\"},{\"id\":\"3:3\",\"url\":\"\",\"width\":220,\"height\":207,\"backgroundColor\":\"#808080\",\"textBackgroundColor\":\"#EEEEEE\",\"urlVisible\":true,\"lockedLayout\":false,\"lockedContent\":false,\"Token\":\"VideoToken\"},{\"freeText\":\"\",\"width\":-1,\"fixedWidth\":false,\"isFreeTextLine\":false,\"visible\":true,\"lockedLayout\":false,\"lockedContent\":false,\"id\":\"3:4\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"Token\":\"FreeTextToken\"}],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"zIndex\":0,\"lockedLayout\":false,\"lockedContent\":false}],\"isCollage\":false,\"lockedLayout\":false,\"lockedContent\":false}],\"localDictionary\":{\"dictionary\":{}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":true,\"automaticFreeTextLineEnabled\":true,\"showCollageGrid\":true,\"lockedLayout\":false,\"lockedContent\":false,\"templateName\":\"\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}";
		assertEquals(expected, actual);

		Document actualDocument = jsonConverter.fromJson(actual, newUser);

		assertEquals(document, actualDocument);
	}

	@Test
	public void testUpdateSignItems() throws Exception {
		// Create sign
		int upperIdPart = 12345;
		String word = "Baum";
		SignId signId = new SignId(upperIdPart, word, SignLocale.DGS, SignSource.DELEGS);
		if (signDB.existsItem(signId)) {
			signDB.deleteSign(signId);
		}

		Date signModificationDate = new Date(1000);
		SimpleSign sign = new SimpleSign(signId, User.getUnknownUser(), SignLocale.DGS, signModificationDate, comment);
		PositionedSymbol leftMostSymbol = new PositionedSymbol(symbolFactory.createSymbol(01, 01, 001, 01, 01, 01), 1,
				1, 1);
		sign.addSymbol(leftMostSymbol);
		sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol(01, 01, 001, 01, 01, 02), 2, 2, 2));

		int posX1 = 100;
		PositionedSymbol rightMostSymbol = new PositionedSymbol(symbolFactory.createSymbol(01, 01, 001, 01, 01, 01),
				posX1, 1, 1);
		sign.addSymbol(rightMostSymbol);
		sign.setComment(comment);
		signDB.saveSign(word, sign);

		SignItem signItem = new SignItem(sign.getSignId(), sign.getWidth());

		// Create document
		User unknownUser = User.getUnknownUser();
		Document document = new Document(unknownUser, SignLocale.DGS, new FileTitle("title"), PageFormat.A4_PORTRAIT);

		Section section1 = new Section();
		document.addSection(section1);

		Id paragraphId1 = idFactory.createId();
		Paragraph paragraph1 = new Paragraph(paragraphId1);
		section1.addParagraph(paragraph1);
		SignItemToken token1 = tokenFactory.createSignItemToken("test1", signItem,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph1.addToken(token1);

		assertEquals(posX1 - leftMostSymbol.getX() + rightMostSymbol.getSymbol().getWidth(),
				((SignItemToken) document.getToken(token1.getId())).getSignItem().getSignWidth());

		// convert document to Json
		String jsonDocument = jsonConverter.toJson(document);

		// manipulate sign in document
		int posX2 = 200;
		PositionedSymbol rightMostSymbolNew = new PositionedSymbol(symbolFactory.createSymbol(01, 01, 001, 01, 01, 02),
				posX2, 2, 2);
		sign.addSymbol(rightMostSymbolNew);
		sign.setComment(comment);
		signDB.updateSign(sign);

		// read document from Json
		document = jsonConverter.fromJson(jsonDocument, unknownUser);

		// Make sure updated sign width is used
		assertEquals(posX2 - leftMostSymbol.getX() + rightMostSymbolNew.getSymbol().getWidth(),
				((SignItemToken) document.getToken(token1.getId())).getSignItem().getSignWidth());

		if (signDB.existsItem(signId)) {
			signDB.deleteSign(signId);
		}
	}

	@Test
	public void testHeadSymbolWithHeadPostureSerialization() {
		// Prepare
		PositionedHeadPostureSymbol positionedHeadPostureSymbol = (PositionedHeadPostureSymbol) positionedSymbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_CIRCLES.getIswaSymbol());

		HeadSymbol originalSymbol = positionedSymbolFactory.createHeadSymbol(positionedHeadPostureSymbol);
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithMouthSerialization() {
		// Prepare
		PositionedMouthSymbol positionedMouthSymbol = PositionedMouthSymbol
				.convertToValidMouthSymbol(new Symbol(4, 4, 1, 1, 1, 1, 36, 35));

		HeadSymbol originalSymbol = positionedSymbolFactory.createHeadSymbol(positionedMouthSymbol);
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithNeckSerialization() {
		// Prepare
		PositionedNeckSymbol positionedNeckSymbol = PositionedNeckSymbol
				.convertToValidNeckSymbol(new Symbol(4, 5, 11, 1, 1, 1, 36, 48));

		HeadSymbol originalSymbol = positionedSymbolFactory.createHeadSymbol(positionedNeckSymbol);
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithHairSerialization() {
		// Prepare
		PositionedHairSymbol positioneHairSymbols = PositionedHairSymbol
				.convertToValidHairSymbol(new Symbol(4, 5, 12, 1, 1, 1, 36, 36));

		HeadSymbol originalSymbol = positionedSymbolFactory.createHeadSymbol(positioneHairSymbols);
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithNoseSerialization() {
		// Prepare
		PositionedNoseSymbol positioneNoseSymbols = PositionedNoseSymbol
				.convertToValidNoseSymbol(new Symbol(4, 3, 4, 1, 1, 1, 36, 35));

		HeadSymbol originalSymbol = positionedSymbolFactory.createHeadSymbol(positioneNoseSymbols);
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithJawSerialization() {
		// Prepare
		List<PositionedJawSymbol> positionedJawSymbol = PositionedJawSymbol
				.convertToValidJawSymbol(new Symbol(4, 5, 9, 1, 1, 1, 10, 10));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positionedJawSymbol.toArray(new PositionedSymbol[positionedJawSymbol.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithExpressionSerialization() {
		// Prepare
		PositionedExpressionSymbol positioneExpressionSymbols = PositionedExpressionSymbol
				.convertToValidExpressionSymbol(new Symbol(4, 5, 13, 1, 1, 1, 47, 47));

		HeadSymbol originalSymbol = positionedSymbolFactory.createHeadSymbol(positioneExpressionSymbols);
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithBothEyesSerialization() {
		// Prepare
		List<PositionedEyeSymbol> positioneEyeSymbols = PositionedEyeSymbol
				.convertToValidEyeSymbols(EyesBaseSymbol.EYES_OPEN.getIswaSymbol());

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positioneEyeSymbols.toArray(new PositionedSymbol[positioneEyeSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithLeftEyesSerialization() {
		// Prepare
		List<PositionedSymbol> positioneEyeSymbols = new ArrayList<PositionedSymbol>();
		positioneEyeSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 2, 4, 1, 5, 1, 10, 10), Location.LEFT));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positioneEyeSymbols.toArray(new PositionedSymbol[positioneEyeSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithRightEyeSerialization() {
		// Prepare
		List<PositionedSymbol> positioneEyeSymbols = new ArrayList<PositionedSymbol>();
		positioneEyeSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 2, 4, 1, 5, 1, 10, 10), Location.RIGHT));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positioneEyeSymbols.toArray(new PositionedSymbol[positioneEyeSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithBothEarsSerialization() {
		// Prepare
		List<PositionedEarsSymbol> positioneEarsSymbols = PositionedEarsSymbol
				.convertToValidEarsSymbol(new Symbol(4, 3, 3, 1, 1, 1, 48, 35));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positioneEarsSymbols.toArray(new PositionedSymbol[positioneEarsSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithLeftEarSerialization() {
		// Prepare
		List<PositionedSymbol> positionedEarsSymbols = new ArrayList<PositionedSymbol>();
		positionedEarsSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 3, 3, 1, 5, 1, 10, 14), Location.LEFT));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positionedEarsSymbols.toArray(new PositionedSymbol[positionedEarsSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithRightEarSerialization() {
		// Prepare
		List<PositionedSymbol> positionedEarsSymbols = new ArrayList<PositionedSymbol>();
		positionedEarsSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 3, 3, 1, 4, 1, 10, 14), Location.RIGHT));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positionedEarsSymbols.toArray(new PositionedSymbol[positionedEarsSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithBothCheekSerialization() {
		// Prepare
		List<PositionedCheekSymbol> positioneEarsSymbols = PositionedCheekSymbol
				.convertToValidCheeksSymbol(new Symbol(4, 3, 1, 1, 1, 1, 36, 35));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positioneEarsSymbols.toArray(new PositionedSymbol[positioneEarsSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithLeftCheekSerialization() {
		// Prepare
		List<PositionedSymbol> positionedCheekSymbols = new ArrayList<PositionedSymbol>();
		positionedCheekSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 3, 1, 1, 5, 1, 9, 15), Location.LEFT));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positionedCheekSymbols.toArray(new PositionedSymbol[positionedCheekSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithRightCheekSerialization() {
		// Prepare
		List<PositionedSymbol> positionedCheekSymbols = new ArrayList<PositionedSymbol>();
		positionedCheekSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 3, 1, 1, 4, 1, 9, 15), Location.RIGHT));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positionedCheekSymbols.toArray(new PositionedSymbol[positionedCheekSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithBothBreathSerialization() {
		// Prepare
		List<PositionedBreathSymbol> positioneBreathSymbols = PositionedBreathSymbol
				.convertToValidBreathSymbol(new Symbol(4, 3, 5, 2, 1, 1, 48, 35));

		HeadSymbol originalSymbol = positionedSymbolFactory
				.createHeadSymbol(positioneBreathSymbols.toArray(new PositionedSymbol[positioneBreathSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithLeftBreathSerialization() {
		// Prepare
		List<PositionedSymbol> positionedBreathSymbols = new ArrayList<PositionedSymbol>();
		positionedBreathSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 3, 5, 2, 6, 1, 17, 22), Location.LEFT));

		HeadSymbol originalSymbol = positionedSymbolFactory.createHeadSymbol(
				positionedBreathSymbols.toArray(new PositionedSymbol[positionedBreathSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testHeadSymbolWithRightBreathSerialization() {
		// Prepare
		List<PositionedSymbol> positionedBreathSymbols = new ArrayList<PositionedSymbol>();
		positionedBreathSymbols.add(
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 3, 5, 2, 5, 1, 17, 22), Location.RIGHT));

		HeadSymbol originalSymbol = positionedSymbolFactory.createHeadSymbol(
				positionedBreathSymbols.toArray(new PositionedSymbol[positionedBreathSymbols.size()]));
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("TestConvert"),
				PageFormat.A4_PORTRAIT);
		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(),
				comment);

		expectedSign.addHeadSymbol(originalSymbol);

		LocalDictionary expectedDictionary = expectedDocument.getLocalDictionary();
		expectedDictionary.save(expectedSign);

		// Action
		String test = jsonConverter.toJson(expectedDocument);
		Document actualDocument = jsonConverter.fromJson(test, User.getUnknownUser());
		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDictionary, actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains("test"));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(originalSymbol, actualSign.getHeadSymbols().get(0));
	}

	@Test
	public void testLegacyHeadSymbolsWithIswaDeserializationForVersion_1_1() {
		// Prepare
		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("test"),
				PageFormat.A4_PORTRAIT);
		Token expectedToken = tokenFactory.createSignItemToken("Test",
				new SignItem(new SignId(0l, "1", SignLocale.DGS, SignSource.IMPORTED), 15), new Id(0, 1),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		Section expectedSection = new Section();
		Paragraph expectedParagraph = new Paragraph(new Id(1446112374531l, 1));
		expectedParagraph.addToken(expectedToken);
		expectedSection.addParagraph(expectedParagraph);
		expectedDocument.addSection(expectedSection);

		LocalDictionary expectedLocalDictionary = expectedDocument.getLocalDictionary();

		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(0),
				"MB angeordnet");
		List<PositionedSymbol> allSymbols = new ArrayList<PositionedSymbol>();
		// Eyes
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-02-001-01-06-01"),
				Location.LEFT));
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-02-001-01-05-01"),
				Location.RIGHT));
		// Mouth
		allSymbols
				.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-04-004-02-02-01")));
		// Cheeks
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-03-001-02-04-01"),
				Location.LEFT));
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-03-001-02-05-01"),
				Location.RIGHT));
		// Ears
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-03-003-01-05-01"),
				Location.LEFT));
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-03-003-01-04-01"),
				Location.RIGHT));
		// Nose
		allSymbols
				.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-03-004-01-02-01")));
		// Breath
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-03-005-01-06-01"),
				Location.LEFT));
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-03-005-01-05-01"),
				Location.RIGHT));
		// Jaw
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-05-009-01-02-01"),
				Location.LEFT));
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(Symbol.JAW_PART_HEAD_RIM, Location.BOTH));
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-05-009-01-02-01"),
				Location.RIGHT));
		// Neck
		allSymbols
				.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-05-011-01-02-01")));
		// Hair
		allSymbols
				.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-05-012-01-02-01")));
		// Expression
		allSymbols
				.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-05-013-01-02-01")));

		PositionedHeadPostureSymbol positionedHeadPosture = (PositionedHeadPostureSymbol) positionedSymbolFactory
				.createPositionedSymbol(symbolFactory.createSymbol("04-01-001-01-01-01"));
		HeadSymbol expectedHeadSymbol = positionedSymbolFactory.createHeadSymbol(positionedHeadPosture, 0, 30, 2,
				allSymbols.toArray(new PositionedSymbol[allSymbols.size()]));

		expectedSign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("02-03-006-01-01-01"), 62, 107, 6));
		expectedSign.addHeadSymbol(expectedHeadSymbol);
		expectedSign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("01-10-015-01-04-01"), 66, 87, 4));
		String localDictionaryKey = expectedSign.getSignId().getLowerIdPart();
		expectedLocalDictionary.save(expectedSign);

		String testDocument = "{\"fileTitle\":\"test\",\"sections\":[{\"paragraphs\":[{\"paragraphId\":\"1446112374531:1\",\"tokens\":[{\"Token\":\"SignItemToken\",\"word\":\"Test\",\"signItem\":{\"signId\":{\"upperIdPart\":0,\"lowerIdPart\":\"1\",\"signLocale\":\"DGS\",\"signSource\":\"IMPORTED\"},\"signWidth\":15,\"revision\":0},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"id\":\"0:1\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"}}],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"lockedLayout\":false,\"zIndex\":0}],\"isCollage\":false,\"lockedLayout\":false,\"collageId\":\"3:1\"}],\"localDictionary\":{\"dictionary\":{\"test\":[{\"signId\":{\"upperIdPart\":0,\"lowerIdPart\":\"test\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"modificationDate\":"
				+ "0"
				+ ",\"headSymbols\":[{\"headPostureSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":1,\"symbol\":1,\"variation\":1},\"fill\":1,\"rotation\":1,\"width\":36,\"height\":35},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"noseSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":3,\"symbol\":4,\"variation\":1},\"fill\":2,\"rotation\":1,\"width\":2,\"height\":12},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"neckSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":5,\"symbol\":11,\"variation\":1},\"fill\":2,\"rotation\":1,\"width\":20,\"height\":13},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"expressionSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":5,\"symbol\":13,\"variation\":1},\"fill\":2,\"rotation\":1,\"width\":47,\"height\":47},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"hairSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":5,\"symbol\":12,\"variation\":1},\"fill\":2,\"rotation\":1,\"width\":36,\"height\":36},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"mouthSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":4,\"symbol\":4,\"variation\":2},\"fill\":2,\"rotation\":1,\"width\":21,\"height\":10},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"eyeSymbols\":[{\"location\":\"LEFT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":2,\"symbol\":1,\"variation\":1},\"fill\":6,\"rotation\":1,\"width\":10,\"height\":10},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},{\"location\":\"RIGHT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":2,\"symbol\":1,\"variation\":1},\"fill\":5,\"rotation\":1,\"width\":10,\"height\":10},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"cheeksSymbols\":[{\"location\":\"LEFT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":3,\"symbol\":1,\"variation\":2},\"fill\":4,\"rotation\":1,\"width\":9,\"height\":16},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},{\"location\":\"RIGHT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":3,\"symbol\":1,\"variation\":2},\"fill\":5,\"rotation\":1,\"width\":9,\"height\":16},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"earsSymbols\":[{\"location\":\"LEFT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":3,\"symbol\":3,\"variation\":1},\"fill\":5,\"rotation\":1,\"width\":10,\"height\":14},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},{\"location\":\"RIGHT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":3,\"symbol\":3,\"variation\":1},\"fill\":4,\"rotation\":1,\"width\":10,\"height\":14},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"breathSymbols\":[{\"location\":\"LEFT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":3,\"symbol\":5,\"variation\":1},\"fill\":6,\"rotation\":1,\"width\":17,\"height\":22},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},{\"location\":\"RIGHT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":3,\"symbol\":5,\"variation\":1},\"fill\":5,\"rotation\":1,\"width\":17,\"height\":22},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"jawSymbols\":[{\"location\":\"LEFT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":5,\"symbol\":9,\"variation\":1},\"fill\":2,\"rotation\":1,\"width\":8,\"height\":9},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},{\"location\":\"BOTH\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":99,\"symbol\":999,\"variation\":96},\"fill\":1,\"rotation\":1,\"width\":14,\"height\":4},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},{\"location\":\"RIGHT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":5,\"symbol\":9,\"variation\":1},\"fill\":2,\"rotation\":1,\"width\":8,\"height\":9},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"isFreePositionable\":true,\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":1,\"symbol\":1,\"variation\":1},\"fill\":1,\"rotation\":1,\"width\":36,\"height\":35},\"x\":0,\"y\":30,\"z\":2,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"disarrangedHeadSymbols\":[],\"handSymbols\":[{\"symbol\":{\"baseSymbol\":{\"category\":1,\"group\":10,\"symbol\":15,\"variation\":1},\"fill\":4,\"rotation\":1,\"width\":15,\"height\":15},\"x\":66,\"y\":87,\"z\":4,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"fingerAlphabetSymbols\":[],\"symbols\":[{\"symbol\":{\"baseSymbol\":{\"category\":2,\"group\":3,\"symbol\":6,\"variation\":1},\"fill\":1,\"rotation\":1,\"width\":39,\"height\":17},\"x\":62,\"y\":107,\"z\":6,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"revision\":0,\"comment\":\"MB angeordnet\",\"persistenceLocation\":\"NONE\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}]}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":true,\"automaticFreeTextLineEnabled\":false,\"showCollageGrid\":true,\"lockedLayout\":false,\"author\":\"unknown\",\"signLocale\":\"DGS\"}";

		// Action
		Document actualDocument = jsonConverter.fromJson(testDocument, User.getUnknownUser());

		// Check
		assertEquals(expectedDocument, actualDocument);
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDocument.getLocalDictionary(), actualDictionary);
		assertTrue("actualDictionary does not contain the expected key",
				actualDictionary.getKeyWords().contains(localDictionaryKey));
		assertTrue("actualDictionary does not contain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getHeadSymbols().size());
		assertEquals(expectedHeadSymbol, actualSign.getHeadSymbolAt(0));
	}

	@Test
	public void testLegacyHeadSymbolsWithEnumNamesDeserializationForVersion1_0() {
		// Prepare

		Document expectedDocument = new Document(User.getUnknownUser(), SignLocale.DGS, new FileTitle("test"),
				PageFormat.A4_PORTRAIT);
		Token expectedToken = tokenFactory.createSignItemToken("test",
				new SignItem(new SignId(0l, "1", SignLocale.DGS, SignSource.IMPORTED), 78), new Id(0, 1),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		Section expectedSection = new Section();
		Paragraph expectedParagraph = new Paragraph(new Id(0, 1));
		expectedParagraph.addToken(expectedToken);
		expectedSection.addParagraph(expectedParagraph);
		expectedDocument.addSection(expectedSection);

		LocalDictionary expectedLocalDictionary = expectedDocument.getLocalDictionary();

		SignId expectedSignId = new SignId(0l, "test", SignLocale.DGS, SignSource.DELEGS);
		SimpleSign expectedSign = new SimpleSign(expectedSignId, User.getUnknownUser(), SignLocale.DGS, new Date(0),
				"");

		List<PositionedSymbol> allSymbols = new ArrayList<PositionedSymbol>();
		// Eyes
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-02-006-01-05-01"),
				Location.LEFT));
		allSymbols.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-02-006-01-05-01"),
				Location.RIGHT));
		// Mouth
		allSymbols
				.add(positionedSymbolFactory.createPositionedSymbol(symbolFactory.createSymbol("04-04-002-03-02-01")));

		PositionedHeadPostureSymbol positionedHeadPosture = (PositionedHeadPostureSymbol) positionedSymbolFactory
				.createPositionedSymbol(symbolFactory.createSymbol("04-01-001-01-01-01"));
		HeadSymbol expectedHeadSymbol = positionedSymbolFactory.createHeadSymbol(positionedHeadPosture, 66, 30, 1,
				allSymbols.toArray(new PositionedSymbol[allSymbols.size()]));

		expectedSign.addDisarrangedHeadSymbol(expectedHeadSymbol);
		expectedSign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("01-05-018-01-04-02"), 20, 41, 2));

		String localDictionaryKey = expectedSign.getSignId().getLowerIdPart();
		expectedLocalDictionary.save(expectedSign);

		// Action
		String testDocument = "{\"fileTitle\":\"test\",\"sections\":[{\"paragraphs\":[{\"paragraphId\":\"0:1\",\"tokens\":[{\"Token\":\"SignItemToken\",\"word\":\"test\",\"signItem\":{\"signId\":{\"upperIdPart\":0,\"lowerIdPart\":\"test\",\"signLocale\":\"DGS\",\"signSource\":\"IMPORTED\"},\"signWidth\":78,\"revision\":0},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"id\":\"0:1\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"}},{\"Token\":\"FreeTextToken\",\"freeText\":\"\",\"width\":-16,\"fixedWidth\":false,\"isFreeTextLine\":true,\"visible\":true,\"id\":\"3:1\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"}}],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"lockedLayout\":false,\"lockedContent\":false,\"zIndex\":0}],\"isCollage\":false,\"lockedLayout\":false, \"lockedContent\":false, \"collageId\":\"3:3\"}],\"localDictionary\":{\"dictionary\":{\"test\":[{\"signId\":{\"upperIdPart\":0,\"lowerIdPart\":\"test\",\"signLocale\":\"DGS\",\"signSource\":\"DELEGS\"},\"modificationDate\":"
				+ "0"
				+ ",\"headSymbols\":[],\"disarrangedHeadSymbols\":[{\"headPostureSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":1,\"symbol\":1,\"variation\":1},\"fill\":1,\"rotation\":1,\"width\":36,\"height\":35},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"noseSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":99,\"symbol\":999,\"variation\":97},\"fill\":1,\"rotation\":1,\"width\":18,\"height\":35},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"neckSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":99,\"symbol\":999,\"variation\":97},\"fill\":1,\"rotation\":1,\"width\":18,\"height\":35},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"expressionSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":99,\"symbol\":999,\"variation\":97},\"fill\":1,\"rotation\":1,\"width\":18,\"height\":35},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"hairSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":99,\"symbol\":999,\"variation\":97},\"fill\":1,\"rotation\":1,\"width\":18,\"height\":35},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"mouthSymbol\":{\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":4,\"symbol\":2,\"variation\":3},\"fill\":2,\"rotation\":1,\"width\":15,\"height\":6},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},\"eyeSymbols\":[{\"location\":\"LEFT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":2,\"symbol\":6,\"variation\":1},\"fill\":5,\"rotation\":1,\"width\":11,\"height\":9},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},{\"location\":\"RIGHT\",\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":2,\"symbol\":6,\"variation\":1},\"fill\":5,\"rotation\":1,\"width\":11,\"height\":9},\"x\":0,\"y\":0,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"cheeksSymbols\":[],\"earsSymbols\":[],\"breathSymbols\":[],\"jawSymbols\":[],\"isFreePositionable\":true,\"symbol\":{\"baseSymbol\":{\"category\":4,\"group\":1,\"symbol\":1,\"variation\":1},\"fill\":1,\"rotation\":1,\"width\":36,\"height\":35},\"x\":66,\"y\":30,\"z\":1,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"handSymbols\":[{\"symbol\":{\"baseSymbol\":{\"category\":1,\"group\":5,\"symbol\":18,\"variation\":1},\"fill\":4,\"rotation\":2,\"width\":23,\"height\":23},\"x\":20,\"y\":41,\"z\":2,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"fingerAlphabetSymbols\":[],\"symbols\":[{\"symbol\":{\"baseSymbol\":{\"category\":2,\"group\":3,\"symbol\":1,\"variation\":2},\"fill\":1,\"rotation\":6,\"width\":24,\"height\":24},\"x\":48,\"y\":69,\"z\":6,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"},{\"symbol\":{\"baseSymbol\":{\"category\":2,\"group\":3,\"symbol\":1,\"variation\":2},\"fill\":2,\"rotation\":6,\"width\":24,\"height\":24},\"x\":24,\"y\":76,\"z\":0,\"lineColor\":\"#000000\",\"fillColor\":\"#FFFFFF\"}],\"revision\":0,\"comment\":\"\",\"persistenceLocation\":\"NONE\",\"author\":\"unknown\",\"signLocale\":\"DGS\"}]}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":false,\"automaticFreeTextLineEnabled\":false,\"showCollageGrid\":true,\"lockedLayout\":false,\"lockedContent\":false,\"author\":\"unknown\",\"signLocale\":\"DGS\"}"; //

		Document actualDocument = jsonConverter.fromJson(testDocument, User.getUnknownUser());

		// Check
		LocalDictionary actualDictionary = actualDocument.getLocalDictionary();
		assertEquals(expectedDocument.getLocalDictionary(), actualDictionary);
		assertTrue("actualDictionary does not cotain the expected key",
				actualDictionary.getKeyWords().contains(localDictionaryKey));
		assertTrue("actualDictionary does not cotain the expected SignId", actualDictionary.contains(expectedSignId));
		SimpleSign actualSign = actualDictionary.getSign(expectedSignId);
		assertEquals(expectedSign, actualSign);
		assertEquals(1, actualSign.getDisarrangedHeadSymbols().size());
		assertEquals(expectedHeadSymbol, actualSign.getDisarrangedHeadSymbols().get(0));
	}

	@Test
	public void testConvertFrom1_0To1_1() {

		String oldDocument = "{\"fileTitle\":\"Test\",\"sections\":[{\"paragraphs\":[{\"paragraphId\":\"1447682865367:1\",\"tokens\":[{\"Token\":\"SignItemToken\",\"id\":\"1347377213664:6\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"backgroundColor\":\"#FFFFFF\",\"locale\":\"DGS\",\"signItem\":{\"signId\":{\"upperIdPart\":3968,\"lowerIdPart\":\"Birne\",\"signLocale\":\"DGS\",\"signSource\":\"IMPORTED\"},\"signVisibility\":true,\"signWidth\":130},\"word\":\"Birne\",\"searchWordVisibility\":true},{\"freeText\":\"\",\"width\":85,\"fixedWidth\":false,\"isFreeTextLine\":false,\"visible\":true,\"id\":\"1447682865367:2\",\"style\":{\"fontMetricSpecifier\":{\"font\":\"HELVETICA\",\"fontStyle\":\"NORMAL\",\"fontSize\":\"SIZE_13\",\"fontWeight\":\"NORMAL\"},\"fontColor\":\"#000000\",\"textBackgroundColor\":\"#EEEEEE\"},\"Token\":\"FreeTextToken\"}],\"isFreeTextLineVisible\":true,\"isSearchWordsLineVisible\":true,\"isSignLineVisible\":true,\"width\":0,\"positionX\":0,\"positionY\":0,\"automaticResize\":false,\"lockedLayout\":false,\"zIndex\":0}],\"isCollage\":false,\"lockedLayout\":false,\"collageId\":\"3:1\"}],\"localDictionary\":{\"dictionary\":{}},\"pageFormat\":\"A4 Hochformat\",\"underlinesVisible\":true,\"isGlossWritingActive\":true,\"automaticFreeTextLineEnabled\":true,\"showCollageGrid\":true,\"lockedLayout\":false,\"author\":\"system\",\"signLocale\":\"DGS\"}";
		User documentAuthor = new User("unknown", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		Document expected = new Document(documentAuthor, SignLocale.DGS, new FileTitle("Test"), PageFormat.A4_PORTRAIT);
		SignItemToken signItemToken = tokenFactory.createSignItemToken("Birne",
				new SignItem(new SignId(3968, "Birne", SignLocale.DGS, SignSource.IMPORTED), 130),
				new Id(1347377213664l, 6l), textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE,
				SignLocale.DGS, false, false);
		FreeTextToken freeTextToken = tokenFactory.createFreeTextToken(new Id(1447682865367l, 2l),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		freeTextToken.setFixedWidth(false, 85);
		Paragraph paragraph = new Paragraph(new Id(1447682865367l, 1l));
		paragraph.addToken(signItemToken);
		paragraph.addToken(freeTextToken);

		Section newSection = new Section();
		newSection.addParagraph(paragraph);
		expected.addSection(newSection);

		Document actual = jsonConverter.fromJson(oldDocument, documentAuthor);

		assertEquals(expected, actual);
	}

	/**
	 * Show character position and character value of the differences (to ease
	 * debugging).
	 */
	@SuppressWarnings("unused")
	private void dumpDiffs(String expected, String actual) {
		for (int i = 0; i < actual.length() || i < expected.length(); i++) {
			if (i >= actual.length()) {
				System.out.println("exp " + i + ".: " + (int) expected.charAt(i));
			} else if (i >= expected.length()) {
				System.out.println("act " + i + ".: " + (int) actual.charAt(i));
			} else if (actual.charAt(i) != expected.charAt(i)) {
				System.out.println(i + ".: act " + (int) actual.charAt(i) + " vs exp " + (int) expected.charAt(i));

				System.out.println("act '" + actual.substring(i) + "'");
				System.out.println("exp '" + expected.substring(i) + "'");

				break;
			}
		}

	}

}
