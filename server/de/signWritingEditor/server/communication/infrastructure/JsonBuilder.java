package de.signWritingEditor.server.communication.infrastructure;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonBuilder {

	public String getMapAsJson(Map<?, ?> map) {
		assert map != null : "Precondition failed: map != null";

		StringBuffer result = new StringBuffer("{");

		Iterator<?> keyIterator = map.keySet().iterator();
		while (keyIterator.hasNext()) {
			Object key = keyIterator.next();
			String keyString = key.toString().replace("\"", "\\\"");

			String valueString;
			Object value = map.get(key);
			if (value instanceof Map) {
				valueString = getMapAsJson((Map<?, ?>) value);
			} else if (value instanceof List) {
				valueString = getListAsJson((List<?>) value);
			} else {
				// Escape parenthesis
				valueString = map.get(key).toString().replace("\"", "\\\"");
				valueString = "\"" + valueString + "\"";
			}

			result.append("\"" + keyString + "\":" + valueString);
			if (keyIterator.hasNext()) {
				result.append(",");
			}
		}
		result.append("}");

		return result.toString();
	}

	public String getListAsJson(List<?> list) {
		assert list != null : "Precondition failed: list != null";

		StringBuffer result = new StringBuffer("[");

		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			String itemString;
			if (object instanceof Map) {
				itemString = getMapAsJson((Map<?, ?>) object);
			} else if (object instanceof List) {
				itemString = getListAsJson((List<?>) object);
			} else {
				// Escape parenthesis
				itemString = object.toString().replace("\"", "\\\"");
				itemString = "\"" + itemString + "\"";
			}
			result.append(itemString);
			if (iterator.hasNext()) {
				result.append(",");
			}
		}
		result.append("]");

		return result.toString();
	}
}
