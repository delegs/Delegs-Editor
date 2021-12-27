package de.signWritingEditor.server.communication.infrastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.gwt.editor.client.Editor.Ignore;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.DictionaryIndex;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.DictionaryStructure;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.WordToSignsDictionaryEntry;

public class JsonSerializerTest {

	private JsonSerializer jsonSerializer;

	@Before
	public void setUp() throws Exception {
		jsonSerializer = new JsonSerializer();
	}

	@Test
	@Ignore
	public void testSerializeMapStringSignItemAsJson() {

		Map<String, List<SignItem>> signItemListMap = new HashMap<String, List<SignItem>>();

		SignItem signItemHallo1 = new SignItem(new SignId(12345, "Hallo", SignLocale.DGS, SignSource.DELEGS), 134);
		signItemHallo1.setRevision(1235);
		SignItem signItemHallo2 = new SignItem(new SignId(523432, "Hallo", SignLocale.DGS, SignSource.DELEGS), 65);
		signItemHallo2.setRevision(1236);
		List<SignItem> itemsForHallo = new ArrayList<SignItem>();
		itemsForHallo.add(signItemHallo1);
		itemsForHallo.add(signItemHallo2);

		signItemListMap.put("Hallo", itemsForHallo);

		SignItem signItemTest = new SignItem(new SignId(8743323, "Test", SignLocale.DGS, SignSource.DELEGS), 345);
		signItemTest.setRevision(1234);
		List<SignItem> itemsForTest = new ArrayList<SignItem>();
		itemsForTest.add(signItemTest);

		signItemListMap.put("Hallo", itemsForHallo);
		signItemListMap.put("Test", itemsForTest);

		String expectedString = "{\"Hallo\":[{\"width\":\"134\",\"id\":{\"language\":\"DGS\",\"lowerId\":\"Hallo\",\"source\":\"DELEGS\",\"upperId\":\"12345\"},\"revision\":\"1235\"},{\"width\":\"65\",\"id\":{\"language\":\"DGS\",\"lowerId\":\"Hallo\",\"source\":\"DELEGS\",\"upperId\":\"523432\"},\"revision\":\"1236\"}],\"Test\":[{\"width\":\"345\",\"id\":{\"language\":\"DGS\",\"lowerId\":\"Test\",\"source\":\"DELEGS\",\"upperId\":\"8743323\"},\"revision\":\"1234\"}]}";
		assertEquals(expectedString, jsonSerializer.serializeMapStringSignItemAsJson(signItemListMap));

	}

	@Test
	public void testSerializeSignAsJson() throws IOException {

		DbConnector connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		SymbolDB symbolDB = new SymbolDB(connector);
		SymbolFactory symbolFactory = new SymbolFactory(symbolDB.getAllSymbols());

		SimpleSign sign = new SimpleSign(new SignId(1234, "word", SignLocale.DGS, SignSource.DELEGS),
				User.getUnknownUser(), SignLocale.DGS, new Date(54321), "Kommentar");
		String signAsJson = jsonSerializer.serializeSignAsJson(sign);

		assertTrue(signAsJson.indexOf("\"upperId\":\"1234\"") > -1);
		assertTrue(signAsJson.indexOf("\"lowerId\":\"word\"") > -1);
		assertTrue(signAsJson.indexOf("\"width\":\"0\"") > -1);
		assertTrue(signAsJson.indexOf("\"symbols\":[]") > -1);
		assertTrue(signAsJson.indexOf("\"mdt\":\"54321\"") > -1);
		assertTrue(signAsJson.indexOf("\"source\":\"DELEGS\"") > -1);
		assertTrue(signAsJson.indexOf("\"comment\":\"Kommentar\"") > -1);

		sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol(1, 1, 1, 1, 1, 1), 2, 3, 4));
		signAsJson = jsonSerializer.serializeSignAsJson(sign);

		assertTrue(signAsJson.indexOf("\"symbols\":[{") > -1);
		assertTrue(signAsJson.indexOf("\"iswaId\":\"01-01-001-01-01-01\"") > -1);
		assertTrue(signAsJson.indexOf("\"x\":\"2\"") > -1);
		assertTrue(signAsJson.indexOf("\"y\":\"3\"") > -1);
		assertTrue(signAsJson.indexOf("\"z\":\"4\"") > -1);

		connector = null;
	}

	@Test
	public void testSerializeDictionaryEntryListAsJson() {
		List<SignId> signIds = new ArrayList<SignId>();
		signIds.add(new SignId(123, "word", SignLocale.DGS, SignSource.DELEGS));
		signIds.add(new SignId(124, "test", SignLocale.DGS, SignSource.DELEGS));
		WordToSignsDictionaryEntry dictionaryEntry = new WordToSignsDictionaryEntry("hallo", signIds);

		ArrayList<SignId> signIds2 = new ArrayList<SignId>();
		signIds2.add(new SignId(234, "blau", SignLocale.DGS, SignSource.DELEGS));
		signIds2.add(new SignId(235, "fuß", SignLocale.DGS, SignSource.DELEGS));
		WordToSignsDictionaryEntry dictionaryEntry2 = new WordToSignsDictionaryEntry("moin", signIds2);

		List<WordToSignsDictionaryEntry> dictionaryEntries = new ArrayList<WordToSignsDictionaryEntry>();
		dictionaryEntries.add(dictionaryEntry);
		dictionaryEntries.add(dictionaryEntry2);

		String dictionaryEntryListAsJson = jsonSerializer.serializeDictionaryEntryListAsJson(dictionaryEntries);

		assertTrue(dictionaryEntryListAsJson.startsWith("[[\"hallo\",{"));

		assertTrue(dictionaryEntryListAsJson.indexOf("\"upperId\":\"123\"") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"lowerId\":\"word\"") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"source\":\"DELEGS\"") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"upperId\":\"124\"") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"lowerId\":\"test\"") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"source\":\"DELEGS\"") > -1);

		assertTrue(dictionaryEntryListAsJson.indexOf("}],[\"moin\",{") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"upperId\":\"234\"") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"lowerId\":\"blau\"") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"upperId\":\"235\"") > -1);
		assertTrue(dictionaryEntryListAsJson.indexOf("\"lowerId\":\"fuß\"") > -1);

		assertEquals(5, dictionaryEntryListAsJson.split("\"source\":\"DELEGS\"").length);

		assertTrue(dictionaryEntryListAsJson.endsWith("}]]"));
	}

	@Test
	public void testSerializeDictionaryStructureAsJson() {
		DictionaryStructure dictionaryStructure = new DictionaryStructure();
		dictionaryStructure.addDictionaryIndex(new DictionaryIndex('a'), 3);
		dictionaryStructure.addDictionaryIndex(new DictionaryIndex('b'), 4);

		String dictionaryStructureAsJson = jsonSerializer.serializeDictionaryStructureAsJson(dictionaryStructure);

		assertTrue(dictionaryStructureAsJson.startsWith("{"));
		assertTrue(dictionaryStructureAsJson.indexOf("\"a\":\"3\"") > -1);
		assertTrue(dictionaryStructureAsJson.indexOf("\"b\":\"4\"") > -1);
		assertTrue(dictionaryStructureAsJson.endsWith("}"));
	}

	@Test
	public void testSerializeSignLocalesAsJson() {
		SignLocale[] signLocales = new SignLocale[2];
		signLocales[0] = SignLocale.DGS;
		signLocales[1] = SignLocale.ASL;

		String signLocalesAsJson = jsonSerializer.serializeSignLocalesAsJson(signLocales);

		boolean containsDGS1 = signLocalesAsJson
				.contains("{\"localeId\":\"DGS\",\"description\":\"Deutsche Gebärdensprache\"}");
		boolean containsDGS2 = signLocalesAsJson
				.contains("{\"description\":\"Deutsche Gebärdensprache\",\"localeId\":\"DGS\"}");
		assertTrue(containsDGS1 || containsDGS2);

		boolean containsASL1 = signLocalesAsJson
				.contains("{\"localeId\":\"ASL\",\"description\":\"American Sign Language\"}");
		boolean containsASL2 = signLocalesAsJson
				.contains("{\"description\":\"American Sign Language\",\"localeId\":\"ASL\"}");
		assertTrue(containsASL1 || containsASL2);
	}
}
