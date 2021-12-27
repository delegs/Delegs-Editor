package de.signWritingEditor.server.service.pdfService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.client.service.SignWritingService;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.PasswordHashUtil;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.DictionaryEntry;
import de.signWritingEditor.server.service.DictionaryServiceImpl;
import de.signWritingEditor.server.service.FontMetricGenerationServiceImpl;
import de.signWritingEditor.server.service.SignImageService;
import de.signWritingEditor.server.service.SignWritingServiceImpl;
import de.signWritingEditor.server.service.VideoServiceImpl;
import de.signWritingEditor.shared.i18n.I18NImpl_de;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class PdfServiceImplTest {

	private static final String PDF_DOCUMENT_TITLE = "UnitTestDokument_¡¿ÄÀÁÂÃäàáâãÇçÈÉÊËèéêëÌÍÎìíîïÑñÖÒÓÔÕöòóôõøßŠšÜÙÚÛüùúûÝýÿŸŽž";
	private SignWritingService signWritingService;
	private SymbolFactory symbolFactory;
	private DbConnector connector;
	private IdFactory idFactory;
	private ConfigurationService configurationService;
	private PdfServiceImpl pdfServiceImpl;
	private int counter;
	private String comment;
	private VideoServiceImpl videoService;
	private UserSession authorSession;

	@Before
	public void setUp() throws Exception {
		FontSizeService fontSizeService = new FontSizeServiceImpl();
		configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
				configurationService);
		fontSizeService.setFontMetrics(fontMetricGenerationService.getFontMetrics());
		connector = new DbConnector(configurationService);
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

		signWritingService = new SignWritingServiceImpl(configurationService);
		videoService = new VideoServiceImpl(configurationService);
		idFactory = new IdFactory(9);
		UserDb userDb = new UserDb(connector);
		SignHistoryDB signHistoryDb = new SignHistoryDB(connector, userDb, configurationService, symbolFactory);

		SignDB signDb = new SignDB(connector, userDb, symbolFactory, configurationService);
		DictionaryServiceImpl dictionaryService = new DictionaryServiceImpl(signDb, signHistoryDb);
		SignImageService signImageService = new SignImageService(configurationService, dictionaryService);
		pdfServiceImpl = new PdfServiceImpl(configurationService, signImageService, videoService, fontSizeService);

		User user = new User("delegs", "signWritingTestUser", "", null, true,
				Arrays.asList(new UserRole[] { UserRole.AUTHOR }), 1);
		String password = "foobar";
		userDb = new UserDb(connector);
		userDb.saveUser(user, PasswordHashUtil.hash(password));

		authorSession = signWritingService.login(user.getUsername(), password);

		counter = 5;
		comment = "test";
	}

	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		UserDb userDb = new UserDb(connector);
		SignDB signDb = new SignDB(connector, userDb, symbolFactory, configurationService);
		signDb.purgeTableSigns();

		for (int i = 0; i < counter; i++) {
			deleteTestEntry(i);
		}

		connector = null;
	}

	@Test
	public void testExportToPdf() throws Exception {
		// Prepare
		Document testDocument = createTestDocument(User.getUnknownUser());
		String fileTitle = pdfServiceImpl.createFileTitle(testDocument.getDocumentTitle().getTitleString());
		File pdfFile = new File(configurationService.getProperty("esf.pdf.path"), fileTitle);
		if (pdfFile.exists()) {
			pdfFile.delete();
		}
		assertFalse(pdfFile.exists());

		// Action
		String exportedPdfPath = signWritingService.exportToPdf(testDocument, new I18NImpl_de());

		// Check
		assertNotNull(exportedPdfPath);
		assertTrue(exportedPdfPath.length() > 0);
		assertTrue(pdfFile.exists());
		// Checks the valid special characters
		assertEquals(fileTitle, pdfFile.getName());

		pdfFile.delete();
	}

	@Test
	public void testReplaceSpecialChars() {
		assertEquals("_", pdfServiceImpl.replaceSpecialChars("."));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars(":"));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars(","));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars("?"));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars("!"));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars("*"));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars("|"));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars("/"));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars("<"));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars(">"));
		assertEquals("_", pdfServiceImpl.replaceSpecialChars("\""));
		assertEquals("___________", pdfServiceImpl.replaceSpecialChars(".:,?!*|/<>\""));
	}

	private Document createTestDocument(User user) throws Exception {
		Document document = new Document(user, SignLocale.DGS, new FileTitle(PDF_DOCUMENT_TITLE),
				PageFormat.A4_PORTRAIT);
		Section section = new Section();
		document.addSection(section);

		section.addParagraph(new Paragraph(idFactory.createId()));
		TextbasedTokenStyleFactory textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		TokenFactory tokenFactory = new TokenFactory(idFactory);

		for (int i = 0; i < counter; i++) {
			DictionaryEntry entry = createTestEntry(i);
			SimpleSign sign = entry.getSign();
			if (!signWritingService.existsItem(sign.getSignId())) {
				sign.setComment("Das ist ein Kommentar");
				signWritingService.saveSign(entry.getWord(), sign, authorSession.getSessionKey());
			}
			SignItem signItem = new SignItem(sign.getSignId(), sign.getWidth());
			SignItemToken token = tokenFactory.createSignItemToken("test" + i, signItem,
					textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
			document.addToken(token);
		}

		// Add local sign
		DictionaryEntry entry = createTestEntry(99);
		SimpleSign localSign = entry.getSign();
		SignItem localSignItem = new SignItem(localSign);
		document.addToken(tokenFactory.createSignItemToken("test99", localSignItem,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		return document;
	}

	private DictionaryEntry createTestEntry(int i) {
		String word = "testMeaning" + i;
		SimpleSign sign = new SimpleSign(new SignId(12345 + i, word, SignLocale.DGS, SignSource.DELEGS),
				User.getUnknownUser(), SignLocale.DGS, new Date(111), comment);
		sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("02-05-005-01-01-01"), i, 2 * i, i));

		return new DictionaryEntry(word, sign);
	}

	private void deleteTestEntry(int i) {
		String word = "testMeaning" + i;
		SimpleSign sign = new SimpleSign(new SignId(12345 + i, word, SignLocale.DGS, SignSource.DELEGS),
				User.getUnknownUser(), SignLocale.DGS, new Date(111), comment);
		sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("02-05-005-01-01-01"), i, 2 * i, i));

		if (signWritingService.existsItem(sign.getSignId())) {
			signWritingService.deleteSign(sign);
		}

	}
}
