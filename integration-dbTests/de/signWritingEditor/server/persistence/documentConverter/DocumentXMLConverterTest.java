package de.signWritingEditor.server.persistence.documentConverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentXMLConverter;
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
import de.signWritingEditor.shared.model.domainValue.VersionNumber;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.HeadSymbol;
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

public class DocumentXMLConverterTest {

	private DocumentXMLConverter xmlConverter;
	private TokenFactory tokenFactory;
	private IdFactory idFactory;
	private SymbolFactory symbolFactory;
	private SignDB signDB;
	private String comment;
	private DbConnector connector;
	private PositionedSymbolFactory positionedSymbolFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp() throws IOException {
		ConfigurationService configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		connector = new DbConnector(configurationService);
		UserDb userDb = new UserDb(connector);

		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		signDB = new SignDB(connector, userDb, symbolFactory, configurationService);
		int uniqueNumber = 3;
		idFactory = new IdFactory(uniqueNumber);
		tokenFactory = new TokenFactory(idFactory);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		xmlConverter = new DocumentXMLConverter(userDb, signDB, symbolFactory, textbasedTokenStyleFactory,
				new PositionedSymbolFactory(), uniqueNumber);
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
		String xmlString = xmlConverter.toXML(document);

		// Check
		String expectedString = //
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
						+ "<document name=\"title\" region=\"DGS\" pageDimension=\"A4 Hochformat\" documentVersion=\"1.6\" isGlossWritingActive=\"true\" automaticFreeTextLineEnabled=\"true\" collagePositioningGridVisibility=\"true\" lockedLayout=\"false\" lockedContent=\"false\">"
						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\" /><section collage=\"true\" lockedLayout=\"false\" lockedContent=\"false\" /><section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\" /></document>\r\n";
		assertEquals(expectedString, xmlString);
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
		String xmlString = xmlConverter.toXML(document);

		// Check
		String expectedString = //
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
						+ "<document name=\"title\" region=\"DGS\" pageDimension=\"A4 Hochformat\" documentVersion=\""
						+ Document.CURRENT_DOCUMENT_VERSION
						+ "\" isGlossWritingActive=\"true\" automaticFreeTextLineEnabled=\"true\" collagePositioningGridVisibility=\"true\" lockedLayout=\"false\" lockedContent=\"false\">"
						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\" />" //
						+ "<section collage=\"true\" lockedLayout=\"false\" lockedContent=\"false\">" //
						+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\"" //
						+ snippetId.toString() //
						+ "\" paragraphPositionX=\"" //
						+ xPos //
						+ "\" paragraphPositionY=\"" //
						+ yPos //
						+ "\" paragraphWidth=\"" //
						+ width //
						+ "\" automaticResize=\"true\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\" /></section>" //
						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\" />" + //
						"</document>\r\n";
		assertEquals(expectedString, xmlString);
	}

	@Test
	public void testAll() throws IOException {
		User documentAuthor = new User("unknown", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(documentAuthor, SignLocale.DGS, new FileTitle("title"),
				PageFormat.A4_PORTRAIT);

		// simple document

		String xmlString1 = xmlConverter.toXML(document);
		String expString1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<document name=\"title\" region=\"DGS\" pageDimension=\"A4 Hochformat\" documentVersion=\""
				+ Document.CURRENT_DOCUMENT_VERSION
				+ "\" isGlossWritingActive=\"true\" automaticFreeTextLineEnabled=\"true\" collagePositioningGridVisibility=\"true\" lockedLayout=\"false\" lockedContent=\"false\" />\r\n";
		assertEquals(expString1, xmlString1);

		Document convertedDocument1 = xmlConverter.fromXML(xmlString1, documentAuthor);
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

		String xmlString2 = xmlConverter.toXML(document);
		String expString2 = //
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
						+ "<document name=\"title\" region=\"DGS\" pageDimension=\"A4 Hochformat\" documentVersion=\""
						+ Document.CURRENT_DOCUMENT_VERSION
						+ "\" isGlossWritingActive=\"true\" automaticFreeTextLineEnabled=\"true\" collagePositioningGridVisibility=\"true\" lockedLayout=\"false\" lockedContent=\"false\">" //

						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\">" //

						+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\""//
						+ paragraphId1.toString()
						+ "\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\">"//
						+ "<token tokenType=\"signItemToken\" id=\""//
						+ token1.getId()//
						+ "\" signItemSignLocale=\"DGS\" value=\"test1\" "//
						+ "tokenFontName=\""//
						+ token1.getStyle().getFont()//
						+ "\" "//
						+ "tokenFontStyle=\""//
						+ token1.getStyle().getFontStyle().toString()//
						+ "\" "//
						+ "tokenFontWeight=\""//
						+ token1.getStyle().getFontWeight().toString()//
						+ "\" "//
						+ "tokenFontSize=\""//
						+ token1.getStyle().getFontSize().getSize()//
						+ "\" "//
						+ "tokenFontColor=\""//
						+ token1.getFontColor().getCssValue()//
						+ "\" "//
						+ "backgroundColor=\""//
						+ token1.getBackgroundColor().getCssValue()//
						+ "\" lockedLayout=\"false\" lockedContent=\"false\" "//
						+ "textBasedTokenTextBoxColor=\""//
						+ token1.getTextBackgroundColor().getCssValue()//
						+ "\""//
						+ ">"//
						+ "<signItem upperId=\"12345\" lowerId=\"test1\" region=\"DGS\" width=\"50\" source=\"DELEGS\" />"//
						+ "</token>"//
						+ "<token tokenType=\"signItemToken\" id=\""//
						+ token2.getId()//
						+ "\" signItemSignLocale=\"DGS\" value=\"test2\" "//
						+ "tokenFontName=\""//
						+ token2.getStyle().getFont()//
						+ "\" "//
						+ "tokenFontStyle=\""//
						+ token2.getStyle().getFontStyle().toString()//
						+ "\" "//
						+ "tokenFontWeight=\""//
						+ token2.getStyle().getFontWeight().toString()//
						+ "\" "//
						+ "tokenFontSize=\""//
						+ token2.getStyle().getFontSize().getSize()//
						+ "\" "//
						+ "tokenFontColor=\""//
						+ token2.getFontColor().getCssValue()//
						+ "\" "//
						+ "backgroundColor=\""//
						+ token2.getBackgroundColor().getCssValue()//
						+ "\" lockedLayout=\"false\" lockedContent=\"false\" "//
						+ "textBasedTokenTextBoxColor=\""//
						+ token2.getTextBackgroundColor().getCssValue()//
						+ "\""//
						+ ">"//
						+ "<signItem upperId=\"12346\" lowerId=\"test2\" region=\"DGS\" width=\"60\" source=\"DELEGS\" />"//
						+ "</token>" //
						+ "</paragraph>" //

						+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"false\" signsVisible=\"true\" id=\""//
						+ paragraphId2.toString()//
						+ "\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\" />"//
						+ "</section>"//

						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\">"//

						+ "<paragraph freeTextVisible=\"false\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\""//
						+ paragraphId3.toString()
						+ "\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\">"//
						+ "<token tokenType=\"signItemToken\" id=\""//
						+ token3.getId()//
						+ "\" signItemSignLocale=\"DGS\" value=\"test3\" "//
						+ "tokenFontName=\""//
						+ token3.getStyle().getFont()//
						+ "\" "//
						+ "tokenFontStyle=\""//
						+ token3.getStyle().getFontStyle().toString()//
						+ "\" "//
						+ "tokenFontWeight=\""//
						+ token3.getStyle().getFontWeight().toString()//
						+ "\" "//
						+ "tokenFontSize=\""//
						+ token3.getStyle().getFontSize().getSize()//
						+ "\" "//
						+ "tokenFontColor=\""//
						+ token3.getFontColor().getCssValue()//
						+ "\" "//
						+ "backgroundColor=\""//
						+ token3.getBackgroundColor().getCssValue()//
						+ "\" lockedLayout=\"false\" lockedContent=\"false\" "//
						+ "textBasedTokenTextBoxColor=\""//
						+ token3.getTextBackgroundColor().getCssValue()//
						+ "\""//
						+ ">"//
						+ "<signItem upperId=\"12347\" lowerId=\"test3\" region=\"DGS\" width=\"80\" source=\"DELEGS\" />"//
						+ "</token>" //
						+ "</paragraph>" //

						+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"false\" id=\""//
						+ paragraphId4.toString()//
						+ "\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\">"//
						+ "<token tokenType=\"signItemToken\" id=\""//
						+ token4.getId()//
						+ "\" signItemSignLocale=\"DGS\" value=\"test4\" "//
						+ "tokenFontName=\""//
						+ token4.getStyle().getFont()//
						+ "\" "//
						+ "tokenFontStyle=\""//
						+ token4.getStyle().getFontStyle().toString()//
						+ "\" "//
						+ "tokenFontWeight=\""//
						+ token4.getStyle().getFontWeight().toString()//
						+ "\" "//
						+ "tokenFontSize=\""//
						+ token4.getStyle().getFontSize().getSize()//
						+ "\" "//
						+ "tokenFontColor=\""//
						+ token4.getFontColor().getCssValue()//
						+ "\" "//
						+ "backgroundColor=\""//
						+ token4.getBackgroundColor().getCssValue()//
						+ "\" lockedLayout=\"false\" lockedContent=\"false\" "//
						+ "textBasedTokenTextBoxColor=\""//
						+ token4.getTextBackgroundColor().getCssValue()//
						+ "\""//
						+ ">"//
						+ "<signItem upperId=\"12347\" lowerId=\"test4\" region=\"DGS\" width=\"80\" source=\"DELEGS\" />"
						+ "</token>" //
						+ "</paragraph>" //

						+ "</section>"//

						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\" />"//

						+ "</document>\r\n";//
		assertEquals(expString2, xmlString2);

		Document convertedDocument2 = xmlConverter.fromXML(xmlString2, documentAuthor);
		assertTrue(document.equals(convertedDocument2));

		SimpleSign localSign = new SimpleSign(new SignId(1234567, "TestLocal", SignLocale.DGS, SignSource.DELEGS),
				User.getUnknownUser(), SignLocale.DGS, new Date(101), comment);
		PositionedSymbol posSymbol = new PositionedSymbol(symbolFactory.createSymbol(1, 1, 1, 1, 1, 1), 10, 10, 1);
		localSign.addSymbol(posSymbol);

		document.getLocalDictionary().save(localSign);
		String xmlWithLocalDictionary = xmlConverter.toXML(document);

		String expectedXmlWithLocalDictionary = //
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"//
						+ "<document name=\"title\" region=\"DGS\" pageDimension=\"A4 Hochformat\" documentVersion=\""
						+ Document.CURRENT_DOCUMENT_VERSION
						+ "\" isGlossWritingActive=\"true\" automaticFreeTextLineEnabled=\"true\" collagePositioningGridVisibility=\"true\" lockedLayout=\"false\" lockedContent=\"false\">"//

						+ "<dictionary>"//

						+ "<entry word=\"TestLocal\">"//

						+ "<sign owner=\"unknown\" region=\"DGS\" meaning=\"TestLocal\" id=\"1234567\" source=\"DELEGS\" mdt=\"101\" comment=\"Das ist ein Kommentar\">"//

						+ "<symbols />"//

						+ "<headSymbols />"//

						+ "<disarrangedHeadSymbols />"//

						+ "<handSymbols>"//

						+ "<posSymbol><x>10</x><y>10</y><z>1</z><id>01-01-001-01-01-01</id>"//

						+ "<positionedSymbolColorCodeForFormerBlack>#000000</positionedSymbolColorCodeForFormerBlack>"//

						+ "<positionedSymbolColorCodeForFormerWhite>#FFFFFF</positionedSymbolColorCodeForFormerWhite>"//

						+ "</posSymbol>"

						+ "</handSymbols>"//

						+ "<fingerAlphabetSymbols />"

						+ "</sign>"//

						+ "</entry>"//

						+ "</dictionary>"//

						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\">"//

						+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\""
						+ paragraphId1.toString()//
						+ "\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\">"//
						+ "<token tokenType=\"signItemToken\" id=\"" + token1.getId() + "\""
						+ " signItemSignLocale=\"DGS\" value=\"test1\" "//
						+ "tokenFontName=\"" + token1.getStyle().getFont() + "\" "//
						+ "tokenFontStyle=\"" + token1.getStyle().getFontStyle().toString() + "\" "//
						+ "tokenFontWeight=\"" + token1.getStyle().getFontWeight().toString() + "\" " //
						+ "tokenFontSize=\"" + token1.getStyle().getFontSize().getSize() + "\" " //
						+ "tokenFontColor=\"" + token1.getFontColor().getCssValue() + "\" "//
						+ "backgroundColor=\"" + token1.getBackgroundColor().getCssValue()
						+ "\" lockedLayout=\"false\" lockedContent=\"false\" " + "textBasedTokenTextBoxColor=\""
						+ token1.getTextBackgroundColor().getCssValue() + "\"" + ">"//
						+ "<signItem upperId=\"12345\" lowerId=\"test1\" region=\"DGS\" width=\"50\" source=\"DELEGS\" />"
						+ "</token>"//
						+ "<token tokenType=\"signItemToken\" id=\"" + token2.getId() + "\""
						+ " signItemSignLocale=\"DGS\" value=\"test2\" "//
						+ "tokenFontName=\"" + token2.getStyle().getFont() + "\" "//
						+ "tokenFontStyle=\"" + token2.getStyle().getFontStyle().toString() + "\" "//
						+ "tokenFontWeight=\"" + token2.getStyle().getFontWeight().toString() + "\" "//
						+ "tokenFontSize=\"" + token2.getStyle().getFontSize().getSize() + "\" "//
						+ "tokenFontColor=\"" + token2.getFontColor().getCssValue() + "\" "//
						+ "backgroundColor=\"" + token2.getBackgroundColor().getCssValue()
						+ "\" lockedLayout=\"false\" lockedContent=\"false\" " + "textBasedTokenTextBoxColor=\""
						+ token2.getTextBackgroundColor().getCssValue() + "\"" + ">"//
						+ "<signItem upperId=\"12346\" lowerId=\"test2\" region=\"DGS\" width=\"60\" source=\"DELEGS\" />"
						+ "</token>" //
						+ "</paragraph>" //

						+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"false\" signsVisible=\"true\" id=\""
						+ paragraphId2.toString()//
						+ "\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\" />"//

						+ "</section>"//

						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\">"//

						+ "<paragraph freeTextVisible=\"false\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\""
						+ paragraphId3.toString()//
						+ "\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\">"//
						+ "<token tokenType=\"signItemToken\" id=\"" + token3.getId() + "\""
						+ " signItemSignLocale=\"DGS\" value=\"test3\" "//
						+ "tokenFontName=\"" + token3.getStyle().getFont() + "\" "//
						+ "tokenFontStyle=\"" + token3.getStyle().getFontStyle().toString() + "\" "//
						+ "tokenFontWeight=\"" + token3.getStyle().getFontWeight().toString() + "\" "//
						+ "tokenFontSize=\"" + token3.getStyle().getFontSize().getSize() + "\" "//
						+ "tokenFontColor=\"" + token3.getFontColor().getCssValue() + "\" "//
						+ "backgroundColor=\"" + token3.getBackgroundColor().getCssValue()
						+ "\" lockedLayout=\"false\" lockedContent=\"false\" " + "textBasedTokenTextBoxColor=\""
						+ token3.getTextBackgroundColor().getCssValue() + "\"" + ">"//
						+ "<signItem upperId=\"12347\" lowerId=\"test3\" region=\"DGS\" width=\"80\" source=\"DELEGS\" />"
						+ "</token>" //
						+ "</paragraph>" //

						+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"false\" id=\""
						+ paragraphId4.toString()//
						+ "\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\">"//
						+ "<token tokenType=\"signItemToken\" id=\"" + token4.getId() + "\""
						+ " signItemSignLocale=\"DGS\" value=\"test4\" "//
						+ "tokenFontName=\"" + token4.getStyle().getFont() + "\" "//
						+ "tokenFontStyle=\"" + token4.getStyle().getFontStyle().toString() + "\" "//
						+ "tokenFontWeight=\"" + token4.getStyle().getFontWeight().toString() + "\" "//
						+ "tokenFontSize=\"" + token4.getStyle().getFontSize().getSize() + "\" "//
						+ "tokenFontColor=\"" + token4.getFontColor().getCssValue() + "\" "//
						+ "backgroundColor=\"" + token4.getBackgroundColor().getCssValue()
						+ "\" lockedLayout=\"false\" lockedContent=\"false\" " + "textBasedTokenTextBoxColor=\""
						+ token4.getTextBackgroundColor().getCssValue() + "\"" + ">"//
						+ "<signItem upperId=\"12347\" lowerId=\"test4\" region=\"DGS\" width=\"80\" source=\"DELEGS\" />"
						+ "</token>" //
						+ "</paragraph>" //

						+ "</section>"//

						+ "<section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\" />"//

						+ "</document>\r\n";
		assertEquals(expectedXmlWithLocalDictionary, xmlWithLocalDictionary);
		Document documentWithLocalDictionary = xmlConverter.fromXML(xmlWithLocalDictionary, documentAuthor);

		assertFalse(documentWithLocalDictionary.getLocalDictionary().isEmpty());
		assertTrue(documentWithLocalDictionary.getLocalDictionary().contains(localSign.getSignId()));
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
		SimpleSign sign = new SimpleSign(signId,
				new User("FC", "St.", "Pauli", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
				SignLocale.DGS, signModificationDate, comment);
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

		// convert document to xml
		String xmlDocument = xmlConverter.toXML(document);

		// manipulate sign in document
		int posX2 = 200;
		PositionedSymbol rightMostSymbolNew = new PositionedSymbol(symbolFactory.createSymbol(01, 01, 001, 01, 01, 02),
				posX2, 2, 2);
		sign.addSymbol(rightMostSymbolNew);
		sign.setComment(comment);
		signDB.updateSign(sign);

		// read document from xml
		document = xmlConverter.fromXML(xmlDocument, unknownUser);

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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
		String test = xmlConverter.toXML(expectedDocument);
		Document actualDocument = xmlConverter.fromXML(test, User.getUnknownUser());
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
	public void testOlderDocumentVersions() {
		Map<VersionNumber, String> versionToXmlMap = new HashMap<VersionNumber, String>();

		versionToXmlMap.put(new VersionNumber(1, 10),
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?><document name=\"Version 1.10\" region=\"DGS\" pageDimension=\"A4 Hochformat\"><author username=\"Stefan\" /><section><paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" id=\"1331449647630:1\"><freetext></freetext><token value=\"Denn\" id=\"1331449647630:2\"><sign author=\"imported\" region=\"DGS\" meaning=\"denn\" id=\"10615\"><symbol><x>131</x><y>55</y><z>5</z><id>01-01-001-01-05-01</id></symbol><symbol><x>98</x><y>25</y><z>3</z><id>01-01-001-01-06-01</id></symbol><symbol><x>101</x><y>60</y><z>4</z><id>02-06-008-01-01-09</id></symbol><symbol><x>29</x><y>0</y><z>1</z><id>03-03-005-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-04-001-05-01-01</id></symbol><symbol><x>58</x><y>0</y><z>2</z><id>03-04-001-05-01-01</id></symbol><symbol><x>116</x><y>85</y><z>6</z><id>05-01-003-01-01-01</id></symbol></sign></token><token value=\"so\" id=\"1331449647630:3\"><sign author=\"imported\" region=\"DGS\" meaning=\"so\" id=\"4857\"><symbol><x>37</x><y>48</y><z>2</z><id>01-05-015-01-04-02</id></symbol><symbol><x>1</x><y>49</y><z>3</z><id>01-05-015-01-04-10</id></symbol><symbol><x>46</x><y>82</y><z>4</z><id>02-03-001-01-01-05</id></symbol><symbol><x>8</x><y>82</y><z>5</z><id>02-03-001-01-02-05</id></symbol><symbol><x>28</x><y>1</y><z>1</z><id>03-03-004-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-04-004-01-01-01</id></symbol></sign></token><token value=\"sehr\" id=\"1331449647630:4\"><sign author=\"imported\" region=\"DGS\" meaning=\"sehr\" id=\"5537\"><symbol><x>52</x><y>46</y><z>3</z><id>01-09-002-01-03-02</id></symbol><symbol><x>83</x><y>59</y><z>4</z><id>02-05-001-02-01-07</id></symbol><symbol><x>29</x><y>0</y><z>0</z><id>03-03-005-01-01-01</id></symbol><symbol><x>58</x><y>0</y><z>2</z><id>03-04-001-05-01-05</id></symbol><symbol><x>0</x><y>0</y><z>1</z><id>03-04-004-01-01-01</id></symbol></sign></token><token value=\"hat\" id=\"1331449647630:5\"><sign author=\"imported\" region=\"DGS\" meaning=\"hat\" id=\"4020\"><symbol><x>21</x><y>45</y><z>2</z><id>01-05-015-01-01-03</id></symbol><symbol><x>27</x><y>69</y><z>3</z><id>02-01-001-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-03-006-03-01-01</id></symbol><symbol><x>29</x><y>1</y><z>1</z><id>03-04-001-05-01-01</id></symbol></sign></token><token value=\"Gott\" id=\"1331449647630:6\"><sign author=\"imported\" region=\"DGS\" meaning=\"Gott\" id=\"391\"><symbol><x>37</x><y>0</y><z>3</z><id>01-03-001-01-02-01</id></symbol><symbol><x>0</x><y>23</y><z>2</z><id>03-01-007-01-01-08</id></symbol><symbol><x>0</x><y>23</y><z>4</z><id>03-03-004-01-01-01</id></symbol><symbol><x>0</x><y>23</y><z>1</z><id>03-05-002-01-01-08</id></symbol><symbol><x>0</x><y>12</y><z>0</z><id>03-05-003-01-01-08</id></symbol></sign></token><token value=\"die\" id=\"1331449647630:7\"><sign author=\"imported\" region=\"DGS\" meaning=\"die\" id=\"22\"><symbol><x>54</x><y>44</y><z>2</z><id>01-06-008-01-03-01</id></symbol><symbol><x>31</x><y>1</y><z>1</z><id>03-03-005-02-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-04-001-05-01-01</id></symbol></sign></token><token value=\"Welt\" id=\"1331449647630:8\"><sign author=\"imported\" region=\"DGS\" meaning=\"Welt\" id=\"3128\"><symbol><x>56</x><y>110</y><z>2</z><id>01-02-001-01-04-01</id></symbol><symbol><x>37</x><y>110</y><z>3</z><id>01-02-001-01-04-09</id></symbol><symbol><x>58</x><y>59</y><z>0</z><id>01-02-001-01-06-01</id></symbol><symbol><x>35</x><y>59</y><z>1</z><id>01-02-001-01-06-09</id></symbol><symbol><x>48</x><y>144</y><z>6</z><id>02-01-001-01-01-01</id></symbol><symbol><x>77</x><y>94</y><z>5</z><id>02-06-002-01-01-13</id></symbol><symbol><x>9</x><y>92</y><z>4</z><id>02-06-002-01-02-05</id></symbol><symbol><x>30</x><y>0</y><z>8</z><id>03-03-005-01-01-01</id></symbol><symbol><x>60</x><y>1</y><z>9</z><id>03-04-001-04-01-01</id></symbol><symbol><x>88</x><y>2</y><z>10</z><id>03-04-001-05-01-01</id></symbol><symbol><x>0</x><y>0</y><z>7</z><id>03-04-006-01-01-01</id></symbol></sign></token><token value=\"ge\" id=\"1331449647630:9\"><sign author=\"imported\" region=\"DGS\" meaning=\"ge\" id=\"1857\"><symbol><x>69</x><y>21</y><z>3</z><id>01-05-015-01-01-01</id></symbol><symbol><x>68</x><y>52</y><z>4</z><id>02-05-001-01-01-05</id></symbol><symbol><x>31</x><y>0</y><z>1</z><id>03-03-005-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-04-001-05-01-05</id></symbol><symbol><x>17</x><y>40</y><z>2</z><id>04-01-001-01-01-01</id></symbol></sign></token><token value=\"liebt\" id=\"1331449647630:51\"><sign author=\"imported\" region=\"DGS\" meaning=\"liebt\" id=\"17891\"><symbol><x>50</x><y>62</y><z>0</z><id>01-05-015-01-01-02</id></symbol><symbol><x>45</x><y>61</y><z>3</z><id>01-05-015-01-01-10</id></symbol><symbol><x>54</x><y>48</y><z>2</z><id>02-01-001-01-01-01</id></symbol><symbol><x>7</x><y>12</y><z>9</z><id>03-01-004-03-04-01</id></symbol><symbol><x>37</x><y>12</y><z>10</z><id>03-01-004-03-04-01</id></symbol><symbol><x>65</x><y>14</y><z>11</z><id>03-01-004-03-04-01</id></symbol><symbol><x>95</x><y>12</y><z>7</z><id>03-01-004-03-04-01</id></symbol><symbol><x>29</x><y>0</y><z>5</z><id>03-03-005-02-01-01</id></symbol><symbol><x>57</x><y>0</y><z>6</z><id>03-03-008-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>4</z><id>03-04-001-04-01-01</id></symbol><symbol><x>88</x><y>0</y><z>8</z><id>03-04-001-05-01-01</id></symbol><symbol><x>49</x><y>42</y><z>1</z><id>04-01-001-01-01-01</id></symbol></sign></token><token value=\",\" id=\"1331449647630:10\"><sign author=\"imported\" region=\"DGS\" meaning=\",\" id=\"13548\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-001-01-01-03</id></symbol></sign></token><token value=\"dass\" id=\"1331449647630:11\"><sign author=\"imported\" region=\"DGS\" meaning=\"dass\" id=\"1909\"><symbol><x>114</x><y>4</y><z>3</z><id>01-01-001-01-02-01</id></symbol><symbol><x>93</x><y>57</y><z>4</z><id>01-01-001-01-04-02</id></symbol><symbol><x>113</x><y>47</y><z>5</z><id>02-03-001-01-01-05</id></symbol><symbol><x>30</x><y>1</y><z>1</z><id>03-03-006-03-01-01</id></symbol><symbol><x>0</x><y>1</y><z>0</z><id>03-04-001-05-01-01</id></symbol><symbol><x>61</x><y>0</y><z>2</z><id>03-04-004-01-01-01</id></symbol><symbol><x>115</x><y>68</y><z>6</z><id>05-01-003-01-01-01</id></symbol></sign></token><token value=\"er\" id=\"1331449647630:12\"><sign author=\"imported\" region=\"DGS\" meaning=\"er\" id=\"17958\"><symbol><x>82</x><y>12</y><z>2</z><id>01-01-001-01-03-01</id></symbol><symbol><x>90</x><y>0</y><z>3</z><id>02-03-001-01-01-01</id></symbol><symbol><x>39</x><y>34</y><z>1</z><id>03-01-007-01-02-08</id></symbol><symbol><x>0</x><y>25</y><z>4</z><id>03-03-005-01-01-01</id></symbol><symbol><x>44</x><y>45</y><z>5</z><id>03-04-001-05-02-05</id></symbol><symbol><x>31</x><y>14</y><z>0</z><id>03-05-003-01-01-08</id></symbol></sign></token><token value=\"seinen\" id=\"1331449647630:13\"><sign author=\"imported\" region=\"DGS\" meaning=\"seinen\" id=\"10577\"><symbol><x>183</x><y>28</y><z>2</z><id>01-05-015-01-03-01</id></symbol><symbol><x>204</x><y>15</y><z>3</z><id>02-05-001-01-01-08</id></symbol><symbol><x>215</x><y>25</y><z>14</z><id>02-05-001-01-01-08</id></symbol><symbol><x>6</x><y>6</y><z>13</z><id>03-01-001-01-04-01</id></symbol><symbol><x>36</x><y>7</y><z>12</z><id>03-01-001-01-04-01</id></symbol><symbol><x>66</x><y>6</y><z>11</z><id>03-01-001-01-04-01</id></symbol><symbol><x>96</x><y>6</y><z>10</z><id>03-01-001-01-04-01</id></symbol><symbol><x>125</x><y>7</y><z>9</z><id>03-01-001-01-04-01</id></symbol><symbol><x>156</x><y>7</y><z>8</z><id>03-01-001-01-04-01</id></symbol><symbol><x>119</x><y>0</y><z>0</z><id>03-03-005-01-01-01</id></symbol><symbol><x>60</x><y>0</y><z>5</z><id>03-03-005-02-01-01</id></symbol><symbol><x>30</x><y>0</y><z>4</z><id>03-03-006-03-01-01</id></symbol><symbol><x>90</x><y>0</y><z>6</z><id>03-04-001-05-01-01</id></symbol><symbol><x>149</x><y>0</y><z>7</z><id>03-04-001-05-01-01</id></symbol><symbol><x>0</x><y>0</y><z>1</z><id>03-04-004-01-01-01</id></symbol></sign></token><token value=\"eingeboren\" id=\"1331449647630:14\"><sign author=\"imported\" region=\"DGS\" meaning=\"eingeboren\" id=\"17959\"><symbol><x>81</x><y>36</y><z>13</z><id>01-01-001-01-01-01</id></symbol><symbol><x>132</x><y>65</y><z>5</z><id>01-05-015-01-02-06</id></symbol><symbol><x>170</x><y>65</y><z>4</z><id>01-05-015-01-02-14</id></symbol><symbol><x>82</x><y>72</y><z>14</z><id>02-03-001-01-01-05</id></symbol><symbol><x>191</x><y>81</y><z>3</z><id>02-08-012-01-01-02</id></symbol><symbol><x>107</x><y>82</y><z>2</z><id>02-08-012-01-02-01</id></symbol><symbol><x>194</x><y>1</y><z>9</z><id>03-03-004-01-01-01</id></symbol><symbol><x>133</x><y>0</y><z>8</z><id>03-03-005-01-01-01</id></symbol><symbol><x>31</x><y>0</y><z>10</z><id>03-03-005-02-01-01</id></symbol><symbol><x>0</x><y>0</y><z>11</z><id>03-03-006-03-01-01</id></symbol><symbol><x>164</x><y>1</y><z>0</z><id>03-03-008-01-01-01</id></symbol><symbol><x>61</x><y>1</y><z>12</z><id>03-04-001-05-01-01</id></symbol><symbol><x>105</x><y>1</y><z>7</z><id>03-04-001-05-01-05</id></symbol><symbol><x>140</x><y>41</y><z>1</z><id>04-01-001-01-01-01</id></symbol><symbol><x>143</x><y>95</y><z>6</z><id>04-01-001-01-01-01</id></symbol></sign></token><token value=\"Sohn\" id=\"1331799739922:3\"><sign author=\"imported\" region=\"DGS\" meaning=\"Sohn\" id=\"2413\"><symbol><x>76</x><y>46</y><z>3</z><id>01-09-002-01-05-01</id></symbol><symbol><x>77</x><y>84</y><z>2</z><id>02-03-001-02-01-05</id></symbol><symbol><x>31</x><y>0</y><z>1</z><id>03-03-004-01-01-01</id></symbol><symbol><x>62</x><y>0</y><z>4</z><id>03-04-001-05-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-04-004-01-01-01</id></symbol></sign></token><token value=\"gab\" id=\"1331449647630:22\"><sign author=\"imported\" region=\"DGS\" meaning=\"gab\" id=\"16297\"><symbol><x>101</x><y>30</y><z>3</z><id>01-05-015-01-01-01</id></symbol><symbol><x>102</x><y>0</y><z>4</z><id>01-05-015-01-04-01</id></symbol><symbol><x>115</x><y>25</y><z>5</z><id>02-05-001-01-01-01</id></symbol><symbol><x>29</x><y>0</y><z>1</z><id>03-03-006-03-01-01</id></symbol><symbol><x>57</x><y>0</y><z>2</z><id>03-03-008-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-04-001-05-01-05</id></symbol></sign></token><token value=\",\" id=\"1331449647630:23\"><sign author=\"imported\" region=\"DGS\" meaning=\",\" id=\"13548\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-001-01-01-03</id></symbol></sign></token><token value=\"damit\" id=\"1331449647630:24\"><sign author=\"imported\" region=\"DGS\" meaning=\"damit\" id=\"3749\"><symbol><x>71</x><y>52</y><z>0</z><id>01-01-001-01-03-02</id></symbol><symbol><x>46</x><y>90</y><z>1</z><id>01-01-001-01-04-02</id></symbol><symbol><x>70</x><y>76</y><z>2</z><id>02-03-001-02-01-05</id></symbol><symbol><x>61</x><y>0</y><z>6</z><id>03-03-001-01-01-01</id></symbol><symbol><x>92</x><y>0</y><z>7</z><id>03-03-005-02-01-01</id></symbol><symbol><x>30</x><y>1</y><z>4</z><id>03-03-006-03-01-01</id></symbol><symbol><x>0</x><y>1</y><z>5</z><id>03-04-001-05-01-01</id></symbol><symbol><x>123</x><y>1</y><z>8</z><id>03-04-001-05-01-01</id></symbol><symbol><x>75</x><y>110</y><z>3</z><id>05-01-003-01-01-01</id></symbol></sign></token><token value=\"alle\" id=\"1331449647630:25\"><sign author=\"imported\" region=\"DGS\" meaning=\"alle\" id=\"2840\"><symbol><x>32</x><y>54</y><z>4</z><id>01-05-015-01-06-02</id></symbol><symbol><x>54</x><y>47</y><z>5</z><id>02-09-001-02-01-09</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-01-004-01-01-01</id></symbol><symbol><x>30</x><y>0</y><z>3</z><id>03-01-004-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>2</z><id>03-03-006-03-01-01</id></symbol><symbol><x>30</x><y>0</y><z>1</z><id>03-04-001-04-01-01</id></symbol></sign></token><token value=\",\" id=\"1331449647630:26\"><sign author=\"imported\" region=\"DGS\" meaning=\",\" id=\"13548\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-001-01-01-03</id></symbol></sign></token><token value=\"die\" id=\"1331449647630:27\"><sign author=\"imported\" region=\"DGS\" meaning=\"die\" id=\"1768\"><symbol><x>45</x><y>45</y><z>2</z><id>01-01-001-01-06-08</id></symbol><symbol><x>72</x><y>31</y><z>5</z><id>02-09-001-02-01-09</id></symbol><symbol><x>0</x><y>0</y><z>4</z><id>03-01-008-01-01-08</id></symbol><symbol><x>30</x><y>0</y><z>3</z><id>03-01-008-01-01-08</id></symbol><symbol><x>30</x><y>0</y><z>1</z><id>03-03-005-02-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-04-001-05-01-01</id></symbol></sign></token><token value=\"an\" id=\"1331449647630:28\"><sign author=\"imported\" region=\"DGS\" meaning=\"an\" id=\"3864\"><symbol><x>64</x><y>35</y><z>2</z><id>01-05-015-01-03-01</id></symbol><symbol><x>70</x><y>14</y><z>3</z><id>02-05-001-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-03-006-03-01-01</id></symbol><symbol><x>29</x><y>0</y><z>1</z><id>03-04-001-05-01-01</id></symbol><symbol><x>70</x><y>7</y><z>4</z><id>05-01-003-01-01-01</id></symbol></sign></token><token value=\"ihn\" id=\"1331449647630:29\"><sign author=\"imported\" region=\"DGS\" meaning=\"ihn\" id=\"17961\"><symbol><x>74</x><y>9</y><z>2</z><id>01-01-001-01-03-01</id></symbol><symbol><x>80</x><y>0</y><z>5</z><id>02-03-001-01-01-01</id></symbol><symbol><x>8</x><y>31</y><z>4</z><id>03-01-007-01-02-08</id></symbol><symbol><x>40</x><y>32</y><z>3</z><id>03-01-007-01-02-08</id></symbol><symbol><x>0</x><y>23</y><z>1</z><id>03-03-005-02-01-01</id></symbol><symbol><x>31</x><y>24</y><z>0</z><id>03-04-001-05-01-01</id></symbol></sign></token><token value=\"glauben\" id=\"1331449647630:30\"><sign author=\"imported\" region=\"DGS\" meaning=\"glauben\" id=\"17960\"><symbol><x>76</x><y>65</y><z>8</z><id>01-03-001-01-01-03</id></symbol><symbol><x>149</x><y>9</y><z>7</z><id>01-03-001-01-02-02</id></symbol><symbol><x>95</x><y>91</y><z>10</z><id>02-01-001-01-01-01</id></symbol><symbol><x>137</x><y>0</y><z>4</z><id>02-01-001-01-01-01</id></symbol><symbol><x>128</x><y>56</y><z>11</z><id>02-03-001-02-01-04</id></symbol><symbol><x>88</x><y>14</y><z>3</z><id>03-03-004-03-01-01</id></symbol><symbol><x>59</x><y>14</y><z>6</z><id>03-03-006-03-01-01</id></symbol><symbol><x>118</x><y>14</y><z>5</z><id>03-03-008-01-01-01</id></symbol><symbol><x>29</x><y>14</y><z>1</z><id>03-04-001-04-01-01</id></symbol><symbol><x>0</x><y>14</y><z>0</z><id>03-04-001-05-01-05</id></symbol><symbol><x>118</x><y>14</y><z>2</z><id>03-05-002-01-01-08</id></symbol><symbol><x>91</x><y>56</y><z>9</z><id>04-01-001-01-01-01</id></symbol></sign></token><token value=\",\" id=\"1331449647630:31\"><sign author=\"imported\" region=\"DGS\" meaning=\",\" id=\"13548\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-001-01-01-03</id></symbol></sign></token><token value=\"nicht\" id=\"1331449647630:32\"><sign author=\"imported\" region=\"DGS\" meaning=\"nicht\" id=\"771\"><symbol><x>25</x><y>68</y><z>1</z><id>01-01-001-01-03-01</id></symbol><symbol><x>47</x><y>82</y><z>2</z><id>02-05-001-02-01-07</id></symbol><symbol><x>31</x><y>13</y><z>5</z><id>03-03-005-02-01-01</id></symbol><symbol><x>62</x><y>13</y><z>7</z><id>03-03-011-02-01-01</id></symbol><symbol><x>0</x><y>13</y><z>6</z><id>03-04-001-05-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-05-003-01-03-03</id></symbol><symbol><x>31</x><y>0</y><z>4</z><id>03-05-003-01-03-03</id></symbol><symbol><x>62</x><y>0</y><z>8</z><id>03-05-003-01-03-03</id></symbol><symbol><x>83</x><y>86</y><z>3</z><id>05-01-003-01-01-01</id></symbol></sign></token><token value=\"verloren\" id=\"1331449647630:33\"><sign author=\"imported\" region=\"DGS\" meaning=\"verloren\" id=\"16395\"><symbol><x>95</x><y>70</y><z>2</z><id>01-05-001-01-06-08</id></symbol><symbol><x>0</x><y>74</y><z>3</z><id>01-05-001-01-06-16</id></symbol><symbol><x>70</x><y>81</y><z>4</z><id>02-05-006-01-01-07</id></symbol><symbol><x>31</x><y>83</y><z>5</z><id>02-05-006-01-02-07</id></symbol><symbol><x>52</x><y>34</y><z>1</z><id>03-01-005-03-04-01</id></symbol><symbol><x>45</x><y>22</y><z>0</z><id>03-04-002-01-01-01</id></symbol><symbol><x>52</x><y>7</y><z>7</z><id>03-05-003-01-06-03</id></symbol><symbol><x>61</x><y>0</y><z>8</z><id>03-05-003-01-06-07</id></symbol><symbol><x>61</x><y>11</y><z>6</z><id>03-05-003-01-06-07</id></symbol><symbol><x>26</x><y>57</y><z>9</z><id>04-01-004-01-05-10</id></symbol></sign></token><token value=\"gehen\" id=\"1331449647630:34\"><sign author=\"imported\" region=\"DGS\" meaning=\"gehen\" id=\"4831\"><symbol><x>57</x><y>70</y><z>2</z><id>01-02-008-01-06-01</id></symbol><symbol><x>36</x><y>54</y><z>3</z><id>01-05-015-01-04-09</id></symbol><symbol><x>57</x><y>54</y><z>4</z><id>02-01-010-01-01-01</id></symbol><symbol><x>66</x><y>39</y><z>5</z><id>02-05-002-01-01-01</id></symbol><symbol><x>29</x><y>0</y><z>0</z><id>03-03-005-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>1</z><id>03-04-001-05-01-05</id></symbol></sign></token><token value=\",\" id=\"1331449647630:35\"><sign author=\"imported\" region=\"DGS\" meaning=\",\" id=\"13548\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-001-01-01-03</id></symbol></sign></token><token value=\"sondern\" id=\"1331449647630:36\"><sign author=\"imported\" region=\"DGS\" meaning=\"sondern\" id=\"12787\"><symbol><x>97</x><y>33</y><z>3</z><id>01-01-001-01-05-01</id></symbol><symbol><x>100</x><y>70</y><z>4</z><id>02-03-011-01-01-05</id></symbol><symbol><x>30</x><y>1</y><z>2</z><id>03-03-004-01-01-01</id></symbol><symbol><x>59</x><y>0</y><z>1</z><id>03-04-001-05-01-01</id></symbol><symbol><x>0</x><y>1</y><z>0</z><id>03-04-004-01-01-01</id></symbol></sign></token><token value=\"das\" id=\"1331449647630:37\"><sign author=\"imported\" region=\"DGS\" meaning=\"das\" id=\"2217\"><symbol><x>76</x><y>71</y><z>6</z><id>01-01-001-01-06-01</id></symbol><symbol><x>83</x><y>61</y><z>8</z><id>02-05-001-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>2</z><id>03-01-001-01-01-01</id></symbol><symbol><x>30</x><y>1</y><z>1</z><id>03-01-001-01-01-01</id></symbol><symbol><x>61</x><y>2</y><z>5</z><id>03-01-001-01-01-01</id></symbol><symbol><x>30</x><y>1</y><z>0</z><id>03-03-006-03-01-01</id></symbol><symbol><x>0</x><y>0</y><z>4</z><id>03-04-001-05-01-01</id></symbol><symbol><x>61</x><y>2</y><z>3</z><id>03-04-004-01-01-01</id></symbol><symbol><x>85</x><y>50</y><z>7</z><id>05-01-003-01-01-01</id></symbol></sign></token><token value=\"ewige\" id=\"1331449647630:38\"><sign author=\"imported\" region=\"DGS\" meaning=\"ewige\" id=\"17962\"><symbol><x>49</x><y>63</y><z>4</z><id>01-05-015-01-06-01</id></symbol><symbol><x>73</x><y>71</y><z>5</z><id>02-05-001-04-01-07</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-03-005-01-01-01</id></symbol><symbol><x>61</x><y>0</y><z>1</z><id>03-03-005-02-01-01</id></symbol><symbol><x>92</x><y>1</y><z>3</z><id>03-04-001-05-01-05</id></symbol><symbol><x>30</x><y>0</y><z>2</z><id>03-04-006-01-01-01</id></symbol><symbol><x>76</x><y>47</y><z>6</z><id>05-01-002-01-01-01</id></symbol></sign></token><token value=\"Leben\" id=\"1331449647630:39\"><sign author=\"imported\" region=\"DGS\" meaning=\"Leben\" id=\"47\"><symbol><x>60</x><y>88</y><z>3</z><id>01-10-001-01-05-01</id></symbol><symbol><x>9</x><y>87</y><z>4</z><id>01-10-001-01-05-09</id></symbol><symbol><x>57</x><y>47</y><z>5</z><id>02-06-011-01-01-01</id></symbol><symbol><x>9</x><y>50</y><z>0</z><id>02-06-011-01-02-09</id></symbol><symbol><x>29</x><y>1</y><z>1</z><id>03-03-005-01-01-01</id></symbol><symbol><x>60</x><y>2</y><z>2</z><id>03-03-008-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>6</z><id>03-04-001-04-01-01</id></symbol></sign></token><token value=\"haben\" id=\"1331449647630:40\"><sign author=\"imported\" region=\"DGS\" meaning=\"Haben\" id=\"9566\"><symbol><x>52</x><y>46</y><z>4</z><id>01-05-015-01-01-03</id></symbol><symbol><x>44</x><y>69</y><z>5</z><id>02-01-002-01-01-01</id></symbol><symbol><x>57</x><y>0</y><z>2</z><id>03-03-005-01-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-03-006-03-01-01</id></symbol><symbol><x>29</x><y>0</y><z>1</z><id>03-03-008-01-01-01</id></symbol><symbol><x>85</x><y>0</y><z>3</z><id>03-04-001-05-01-01</id></symbol></sign></token><token value=\".\" id=\"1331449647630:41\"><sign author=\"imported\" region=\"DGS\" meaning=\".\" id=\"1415\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-001-02-01-03</id></symbol></sign></token><token value=\"&quot;\" id=\"1331449647630:42\"><sign author=\"imported\" region=\"DGS\" meaning=\"&quot;\" id=\"374\"><symbol><x>83</x><y>12</y><z>2</z><id>01-02-003-01-03-01</id></symbol><symbol><x>4</x><y>45</y><z>3</z><id>01-02-003-01-03-09</id></symbol><symbol><x>0</x><y>32</y><z>5</z><id>02-02-002-01-01-01</id></symbol><symbol><x>81</x><y>0</y><z>4</z><id>02-02-002-01-01-01</id></symbol><symbol><x>33</x><y>12</y><z>1</z><id>03-01-001-01-01-01</id></symbol><symbol><x>33</x><y>12</y><z>0</z><id>03-03-008-01-01-01</id></symbol></sign></token><token value=\"(\" id=\"1331449647630:43\"><sign author=\"imported\" region=\"DGS\" meaning=\"(\" id=\"13552\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-003-01-01-03</id></symbol></sign></token><token value=\"Joh\" id=\"1331449647630:44\" /><token value=\"3\" id=\"1331449647630:45\"><sign author=\"imported\" region=\"DGS\" meaning=\"3\" id=\"3715\"><symbol><x>102</x><y>50</y><z>4</z><id>01-03-001-01-01-02</id></symbol><symbol><x>86</x><y>0</y><z>3</z><id>03-03-005-02-01-01</id></symbol><symbol><x>58</x><y>0</y><z>2</z><id>03-03-006-03-01-01</id></symbol><symbol><x>0</x><y>0</y><z>0</z><id>03-04-001-05-01-01</id></symbol><symbol><x>30</x><y>0</y><z>1</z><id>03-04-001-05-01-05</id></symbol></sign></token><token value=\",\" id=\"1331449647630:46\"><sign author=\"imported\" region=\"DGS\" meaning=\",\" id=\"13548\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-001-01-01-03</id></symbol></sign></token><token value=\"16\" id=\"1331449647630:47\"><sign author=\"imported\" region=\"DGS\" meaning=\"16\" id=\"5633\"><symbol><x>49</x><y>73</y><z>6</z><id>01-05-001-01-06-09</id></symbol><symbol><x>81</x><y>82</y><z>7</z><id>01-10-001-01-06-01</id></symbol><symbol><x>83</x><y>44</y><z>9</z><id>02-10-003-01-04-05</id></symbol><symbol><x>54</x><y>44</y><z>8</z><id>02-10-003-01-05-13</id></symbol><symbol><x>122</x><y>1</y><z>3</z><id>03-03-005-01-01-01</id></symbol><symbol><x>29</x><y>0</y><z>1</z><id>03-03-006-01-01-01</id></symbol><symbol><x>58</x><y>0</y><z>2</z><id>03-03-011-02-01-01</id></symbol><symbol><x>151</x><y>1</y><z>4</z><id>03-04-001-05-01-01</id></symbol><symbol><x>0</x><y>1</y><z>0</z><id>03-04-004-01-01-01</id></symbol><symbol><x>95</x><y>1</y><z>5</z><id>03-04-004-01-01-01</id></symbol></sign></token><token value=\")\" id=\"1331449647630:48\"><sign author=\"imported\" region=\"DGS\" meaning=\")\" id=\"13553\"><symbol><x>0</x><y>0</y><z>0</z><id>06-01-003-01-01-07</id></symbol></sign></token></paragraph><paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" id=\"1331449647630:50\"><freetext></freetext><token value=\"\" id=\"1331449647630:49\" /></paragraph></section><dictionary /></document>");
		versionToXmlMap.put(new VersionNumber(1, 27),
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?><document name=\"Version 1.27\" region=\"DGS\" pageDimension=\"A4 Hochformat\"><section><paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\"1357574748774:3\"><freetext></freetext><token value=\"Dies\" id=\"1357574748774:4\"><signItem upperId=\"4054\" lowerId=\"dies\" width=\"84\" /></token><token value=\"ist\" id=\"1357574748774:5\"><signItem upperId=\"1036\" lowerId=\"ist\" width=\"93\" /></token><token value=\"ein\" id=\"1357574748774:6\"><signItem upperId=\"1631\" lowerId=\"ein\" width=\"98\" /></token><token value=\"test\" id=\"1357574748774:7\"><signItem upperId=\"1272\" lowerId=\"Test\" width=\"126\" /></token><token value=\".\" id=\"1357574748774:8\"><signItem upperId=\"1415\" lowerId=\".\" width=\"8\" /></token><token value=\"Er\" id=\"1357574748774:9\"><signItem upperId=\"1191\" lowerId=\"er\" width=\"90\" /></token><token value=\"soll\" id=\"1357574748774:10\"><signItem upperId=\"1100\" lowerId=\"soll\" width=\"119\" /></token><token value=\"zeigen\" id=\"1357574748774:11\"><signItem upperId=\"1621\" lowerId=\"zeigen\" width=\"97\" /></token><token value=\",\" id=\"1357574748774:12\"><signItem upperId=\"13548\" lowerId=\",\" width=\"8\" /></token><token value=\"ob\" id=\"1357574748774:13\"><signItem upperId=\"3751\" lowerId=\"ob\" width=\"71\" /></token><token value=\"sich\" id=\"1357574748774:14\"><signItem upperId=\"10593\" lowerId=\"sich\" width=\"106\" /></token><token value=\"Dokumente\" id=\"1357574748774:15\" /><token value=\"dieser\" id=\"1357574748774:17\"><signItem upperId=\"10569\" lowerId=\"dieser\" width=\"70\" /></token><token value=\"Version\" id=\"1357574748774:19\" /><token value=\"später\" id=\"1357574748774:20\"><signItem upperId=\"4907\" lowerId=\"später\" width=\"125\" /></token><token value=\"noch\" id=\"1357574748774:21\"><signItem upperId=\"874\" lowerId=\"noch\" width=\"110\" /></token><token value=\"öffnen\" id=\"1357574748774:22\"><signItem upperId=\"5938\" lowerId=\"öffnen\" width=\"115\" /></token><token value=\"lassen\" id=\"1357574748774:23\"><signItem upperId=\"1340\" lowerId=\"lassen\" width=\"117\" /></token><token value=\".\" id=\"1357574748774:24\"><signItem upperId=\"1415\" lowerId=\".\" width=\"8\" /></token></paragraph></section></document>");

		Set<Entry<VersionNumber, String>> entrySet = versionToXmlMap.entrySet();

		for (Entry<VersionNumber, String> entry : entrySet) {
			try {
				Document document = xmlConverter.fromXML(entry.getValue(), User.getUnknownUser());

				assertNotNull(document);
			} catch (Exception e) {
				fail(e.toString());
			}
		}
	}

	@Test
	public void testLegacyHeadSymbolsWithIswaDeserializationForVersion_1_1() {
		// Prepare
		String testDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + //
				"<document name=\"test\" region=\"DGS\" pageDimension=\"A4 Hochformat\" documentVersion=\"1.1\" isGlossWritingActive=\"true\" automaticFreeTextLineEnabled=\"false\">"
				+ //
				"<dictionary>" + //
				"	<entry word=\"test\">" + //
				"		<sign owner=\"unknown\" region=\"DGS\" meaning=\"test\" id=\"0\" source=\"DELEGS\" mdt=\"0\" comment=\"MB angeordnet\">"
				+ //
				"			<symbols>" + //
				"				<posSymbol><x>62</x><y>107</y><z>6</z><id>02-03-006-01-01-01</id></posSymbol>" + //
				"			</symbols>" + //
				"			<headSymbols>" + //
				"				<headSymbol x=\"0\" y=\"30\" z=\"2\" freePositionableHeadSymbol=\"true\" "
				+ "leftEyes=\"04-02-001-01-06-01\" rightEyes=\"04-02-001-01-05-01\" " + "nose=\"04-03-004-01-02-01\" "
				+ "leftCheek=\"04-03-001-02-05-01\" rightCheek=\"04-03-001-02-04-01\" "
				+ "leftEar=\"04-03-003-01-05-01\" rightEar=\"04-03-003-01-04-01\" "
				+ "leftBreath=\"04-03-005-01-06-01\" rightBreath=\"04-03-005-01-05-01\" "
				+ "jaw=\"04-05-009-01-02-01\" " + "neck=\"04-05-011-01-02-01\" " + "expression=\"04-05-013-01-02-01\" "
				+ "hair=\"04-05-012-01-02-01\" " + "mouth=\"04-04-004-02-02-01\" "
				+ "headPosture=\"04-01-001-01-01-01\" />" + //
				"			</headSymbols>" + //
				"			<disarrangedHeadSymbols />" + //
				"			<handSymbols>" + //
				"				<posSymbol><x>66</x><y>87</y><z>4</z><id>01-10-015-01-04-01</id></posSymbol>" + //
				"			</handSymbols>" + //
				"		</sign>" + //
				"	</entry>" + //
				"</dictionary>" + //
				"<section collage=\"false\">" + //
				"	<paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\"1446112374531:1\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\">"
				+ //
				"		<token tokenType=\"signItemToken\" id=\"0:1\" signItemSignLocale=\"DGS\" value=\"Test\" tokenFontName=\"Helvetica\" tokenFontStyle=\"NORMAL\" tokenFontWeight=\"NORMAL\" tokenFontSize=\"13\" tokenFontColor=\"#000000\" backgroundColor=\"#FFFFFF\" textBasedTokenTextBoxColor=\"#EEEEEE\">"
				+ //
				"			<signItem upperId=\"0\" lowerId=\"1\" region=\"DGS\" width=\"15\" source=\"IMPORTED\" />" + //
				"		</token>" + //
				"	</paragraph>" + //
				"</section>" + //
				"</document>";

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

		// Action
		Document actualDocument = xmlConverter.fromXML(testDocument, User.getUnknownUser());

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
		String testDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" //
				+ "<document name=\"test\" region=\"DGS\" pageDimension=\"A4 Hochformat\">" //
				+ "<dictionary><entry word=\"test\">" //
				+ "<sign owner=\"unknown\" region=\"DGS\" meaning=\"test\" id=\"0\" source=\"DELEGS\" mdt=\"0\" comment=\"\">" //
				+ "<symbols><posSymbol><x>48</x><y>69</y><z>6</z><id>02-03-001-02-01-06</id></posSymbol>" //
				+ "<posSymbol><x>24</x><y>76</y><z>0</z><id>02-03-001-02-02-06</id></posSymbol></symbols>" //
				+ "<headSymbols />" //
				+ "<disarrangedHeadSymbols><headSymbol x=\"66\" y=\"30\" z=\"1\" " //
				+ "eyes=\"EYELASHES_UP\" " //
				+ "mouth=\"MOUTH_SMILE_OPEN\" " //
				+ "headPosture=\"STANDARD\" />" //
				+ "</disarrangedHeadSymbols>" //
				+ "<handSymbols><posSymbol><x>20</x><y>41</y><z>2</z><id>01-05-018-01-04-02</id></posSymbol></handSymbols>" //
				+ "</sign></entry></dictionary>" //
				+ "<section>" //
				+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\"0:1\">" //
				+ "<token value=\"test\" id=\"0:1\">" //
				+ "<signItem upperId=\"0\" lowerId=\"test\" width=\"78\" source=\"IMPORTED\" />" //
				+ "</token><freetext></freetext></paragraph></section></document>"; //

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
		Document actualDocument = xmlConverter.fromXML(testDocument, User.getUnknownUser());

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

		String oldDocument = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<document name=\"Test\" region=\"DGS\" pageDimension=\"A4 Hochformat\" documentVersion=\"1.0\" "
				+ "isGlossWritingActive=\"true\" automaticFreeTextLineEnabled=\"true\">" + "<section>"
				+ "<paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\"1447682865367:1\">"
				+ "<token tokenType=\"signItemToken\" id=\"1347377213664:6\" signItemSignLocale=\"DGS\" value=\"Birne\" "
				+ "tokenFontName=\"Helvetica\" tokenFontStyle=\"NORMAL\" tokenFontWeight=\"NORMAL\" tokenFontSize=\"13\" tokenFontColor=\"#000000\" "
				+ "backgroundColor=\"#FFFFFF\" textBasedTokenTextBoxColor=\"#EEEEEE\">"
				+ "<signItem upperId=\"3968\" lowerId=\"Birne\" region=\"DGS\" width=\"130\" source=\"IMPORTED\" />"
				+ "</token>"
				+ "<token tokenType=\"freeTextToken\" freeTextTokenText=\"\" id=\"1447682865367:2\" freeTextTokenHasFixedWidth=\"false\" freeTextTokenMaxWidth=\"100\" "
				+ "tokenFontName=\"Helvetica\" tokenFontStyle=\"NORMAL\" tokenFontWeight=\"NORMAL\" tokenFontSize=\"13\" tokenFontColor=\"#000000\" "
				+ "freeTextTokenVisibility=\"true\" freeTextTokenIsLine=\"false\" backgroundColor=\"#EEEEEE\" textBasedTokenTextBoxColor=\"#FFFFFF\" />"
				+ "</paragraph>" //
				+ "</section>" //
				+ "</document>";

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

		Document actual = xmlConverter.fromXML(oldDocument, documentAuthor);
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
