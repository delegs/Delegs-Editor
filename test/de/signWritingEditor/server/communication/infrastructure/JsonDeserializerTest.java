package de.signWritingEditor.server.communication.infrastructure;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JsonDeserializerTest {

	private JsonDeserializer jsonDeserializer;

	@Before
	public void setUp() {
		jsonDeserializer = new JsonDeserializer();

	}

	@Test
	public void testConvertTokensToList() {

		String jsonString = "{\"searchTokens\":[\"Hallo\",\"Das\",\"ist\",\"ein\",\"Test\"]}";

		List<String> expected = new ArrayList<String>();
		expected.add("Hallo");
		expected.add("Das");
		expected.add("ist");
		expected.add("ein");
		expected.add("Test");

		List<String> result = jsonDeserializer.convertTokensToList(jsonString);
		assertEquals(expected, result);

	}

}
