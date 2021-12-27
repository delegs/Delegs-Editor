package de.signWritingEditor.server.persistence.documentConverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.infrastructure.DocumentDbMock;
import de.signWritingEditor.server.persistence.AllXMLDocumentsToJSON;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentJSONConverter;
import de.signWritingEditor.server.persistence.DocumentXMLConverter;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.infrastructure.migration.DocumentMetaDaten;
import de.signWritingEditor.shared.infrastructure.migration.Tupel;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;

public class AllXMLDocumentsToJSONTest {
	private List<Tupel<String, DocumentMetaDaten>> listOfDocuments;
	private DocumentDbMock documentDb;
	private DocumentXMLConverter xmlConverter;
	private UserDb userDb;
	private DocumentJSONConverter jsonConverter;
	private AllXMLDocumentsToJSON converter;

	@Before
	public void setUp() throws IOException {
		final ConfigurationService configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		DbConnector config = new DbConnector(configurationService);

		documentDb = new DocumentDbMock(config);
		userDb = new UserDb(config);

		SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(config).getAllSymbols());
		SignDB signDB = new SignDB(config, userDb, symbolFactory, configurationService);
		TokenFactory tokenFactory = new TokenFactory(new IdFactory(7));
		jsonConverter = new DocumentJSONConverter(userDb, signDB, tokenFactory);

		xmlConverter = new DocumentXMLConverter(userDb, signDB, symbolFactory, new TextbasedTokenStyleFactory(),
				new PositionedSymbolFactory(), 3);

		converter = new AllXMLDocumentsToJSON(documentDb, xmlConverter, userDb, jsonConverter);
	}

	@Test
	public void testConversionDocumentDirectory() {
		listOfDocuments = documentDb.getAllDocuments();
		List<DocumentMetaDaten> expected = getMetadaten(listOfDocuments);

		converter.transformAllDbEntries();

		listOfDocuments = documentDb.getAllDocuments();
		List<DocumentMetaDaten> actual = getMetadaten(listOfDocuments);

		assertEquals(expected, actual);
	}

	@Test
	public void testConversion() throws IOException {
		listOfDocuments = documentDb.getAllDocuments();
		List<Document> expected = getDocumentsXml(listOfDocuments);

		converter.transformAllDbEntries();

		listOfDocuments = documentDb.getAllDocuments();
		List<Document> actual = getDocumentsJson(listOfDocuments);

		assertEquals(actual.size(), expected.size());

		for (int i = 0; i < actual.size(); i++) {
			assertNotSame(expected.get(i), actual.get(i));
			assertEquals(expected.get(i), actual.get(i));
		}
	}

	@Test
	public void testCorruptStaysTheSame() {
		documentDb.getAllDocuments(); // inits the fake db-docs
		documentDb.addCorruptDocument();

		listOfDocuments = documentDb.getAllDocuments();

		String expected = listOfDocuments.get(listOfDocuments.size() - 1).content;

		converter.transformAllDbEntries();

		String actual = documentDb.getAllDocuments().get(listOfDocuments.size() - 1).content;

		assertEquals(expected, actual);
	}

	private List<DocumentMetaDaten> getMetadaten(List<Tupel<String, DocumentMetaDaten>> documents) {
		List<DocumentMetaDaten> result = new ArrayList<DocumentMetaDaten>();

		for (Tupel<String, DocumentMetaDaten> document : documents) {
			result.add(document.data);
		}

		return result;
	}

	private List<Document> getDocumentsXml(List<Tupel<String, DocumentMetaDaten>> documents) {
		List<Document> result = new ArrayList<>();

		for (Tupel<String, DocumentMetaDaten> document : documents) {
			result.add(xmlConverter.fromXML(document.content, User.getUnknownUser()));
		}

		return result;
	}

	private List<Document> getDocumentsJson(List<Tupel<String, DocumentMetaDaten>> documents) {
		List<Document> result = new ArrayList<>();

		for (Tupel<String, DocumentMetaDaten> document : documents) {
			result.add(jsonConverter.fromJson(document.content, User.getUnknownUser()));
		}

		return result;
	}
}
