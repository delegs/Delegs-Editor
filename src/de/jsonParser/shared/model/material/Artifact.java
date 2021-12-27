package de.jsonParser.shared.model.material;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.jsonParser.shared.infrastructure.JsonParser;
import de.jsonParser.shared.infrastructure.JsonParser.Type;

public abstract class Artifact implements Serializable {
	public static abstract class JsonBlankFactory<A extends Artifact> {

		public A createJsonBlank() {
			A result = doCreateJsonBlank();
			assert result != null : "Postcondition failed: result != null";
			assert result.isJsonBlank() : "Postcondition failed: result.isJsonBlank()";
			return result;
		}

		// protected interface

		protected abstract A doCreateJsonBlank();

	}

	public static final String ID_REGEX = "[A-Za-z0-9+#_\\-|.:'ÄÖÜäöü]+";

	public static final long VERSION = 1L;
	private static final long serialVersionUID = VERSION;

	private String id;

	@Deprecated
	protected Artifact() {
		super();
	}

	protected Artifact(String id) {
		assert id != null : "Precondition failed: id != null";
		assert id.matches(ID_REGEX) : "Precondition failed: id.matches(\"" + ID_REGEX + "\"): " + id;

		this.id = id;
	}

	public String getId() {
		assert id != null : "Postcondition failed: result != null";
		assert id.matches(ID_REGEX) : "Postcondition failed: result.matches(\"" + ID_REGEX + "\"): " + id;
		return id;
	}

	public final boolean isJsonBlank() {
		return id == null;
	}

	public final void fromJson(String json) {
		assert isJsonBlank() : "Precondition failed: isJsonBlank()";
		setJson(new JsonParser(json, 0));
	}

	public final String toJson() {
		assert !isJsonBlank() : "Precondition failed: !isJsonBlank()";
		StringBuilder result = new StringBuilder("{ ").append(getJson()).append(" }");
		assert result != null : "Postcondition failed: result != null";
		return result.toString();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj.getClass().equals(getClass())) {
			result = ((Artifact) obj).id.equals(id);
		}
		return result;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return id;
	}

	// protected interface

	protected void setJson(JsonParser jsonParser) {
		assert jsonParser != null : "Precondition failed: jsonParser != null";

		id = readStringFromJson(jsonParser, "id");
	}

	protected String getJson() {
		StringBuilder result = new StringBuilder();

		writeStringToJson(result, "id", id);

		assert result != null : "Postcondition failed: result != null";
		return result.toString();
	}

	protected final boolean canReadFromJson(JsonParser jsonParser, String key) {
		assert jsonParser != null : "Precondition failed: jsonParser != null";
		assert Type.OBJECT
				.equals(jsonParser.getType()) : "Precondition failed: Type.OBJECT.equals(jsonParser.getType())";
		assert !jsonParser.isConsumed() : "Precondition failed: !jsonParser.isConsumed()";
		assert key != null : "Precondition failed: key != null";
		assert jsonParser.getChildKey().equals(key) : "Precondition failed: jsonParser.getChildKey().equals(key)";
		return true;
	}

	protected final boolean readBooleanFromJson(JsonParser jsonParser, String key) {
		assert canReadFromJson(jsonParser, key);
		boolean result = jsonParser.getChild().getBooleanValue();
		jsonParser.proceedToNextChild();
		return result;
	}

	protected final int readIntFromJson(JsonParser jsonParser, String key) {
		assert canReadFromJson(jsonParser, key);
		int result = jsonParser.getChild().getNumberValue();
		jsonParser.proceedToNextChild();
		return result;
	}

	protected final long readLongFromJson(JsonParser jsonParser, String key) {
		assert canReadFromJson(jsonParser, key);
		long result = Long.parseLong(jsonParser.getChild().getStringValue(), 16);
		jsonParser.proceedToNextChild();
		return result;
	}

	protected final Long readLongObjectFromJson(JsonParser jsonParser, String key) {
		assert canReadFromJson(jsonParser, key);
		Long result = null;
		JsonParser child = jsonParser.getChild();
		if (!child.isNull()) {
			result = Long.parseLong(child.getStringValue(), 16);
		}
		jsonParser.proceedToNextChild();
		return result;
	}

	protected final String readStringFromJson(JsonParser jsonParser, String key) {
		assert canReadFromJson(jsonParser, key);

		String result = null;
		JsonParser child = jsonParser.getChild();
		if (!child.isNull()) {
			result = child.getStringValue();
		}
		jsonParser.proceedToNextChild();
		return result;
	}

	protected final String[] readStringArrayFromJson(JsonParser jsonParser, String key) {
		assert canReadFromJson(jsonParser, key);

		List<String> result = null;
		JsonParser child = jsonParser.getChild();
		if (!child.isNull()) {
			result = new ArrayList<String>();
			while (!child.isConsumed()) {
				String string = null;
				JsonParser grandChild = child.getChild();
				if (!grandChild.isNull()) {
					string = grandChild.getStringValue();
				}
				result.add(string);
				child.proceedToNextChild();
			}
		}
		jsonParser.proceedToNextChild();
		assert result != null : "Postcondition failed: result != null";
		return result.toArray(new String[result.size()]);
	}

	protected final <E extends Enum<?>> E readEnumFromJson(JsonParser jsonParser, String key, E[] values) {
		assert canReadFromJson(jsonParser, key);
		assert values != null : "Precondition failed: values != null";

		E result = null;
		JsonParser child = jsonParser.getChild();
		if (!child.isNull()) {
			String value = child.getStringValue();
			for (int i = 0; result == null && i < values.length; i++) {
				if (value.equals(values[i].name())) {
					result = values[i];
				}
			}
		}
		jsonParser.proceedToNextChild();
		return result;
	}

	protected final <A extends Artifact> A readArtifactFromJson(JsonParser jsonParser, String key,
			Artifact.JsonBlankFactory<A> artifactFactory) {
		assert canReadFromJson(jsonParser, key);
		assert artifactFactory != null : "Precondition failed: artifactFactory != null";

		A result = null;
		JsonParser child = jsonParser.getChild();
		if (!child.isNull()) {
			result = artifactFactory.createJsonBlank();
			result.setJson(child);
		}
		jsonParser.proceedToNextChild();
		return result;
	}

	protected final <L extends List<A>, A extends Artifact> L readArtifactListFromJson(JsonParser jsonParser,
			String key, L list, Artifact.JsonBlankFactory<A> artifactFactory) {
		assert canReadFromJson(jsonParser, key);
		assert list != null : "Precondition failed: list != null";
		assert list.isEmpty() : "Precondition failed: list.isEmpty()";
		assert artifactFactory != null : "Precondition failed: artifactFactory != null";

		L result = null;
		JsonParser child = jsonParser.getChild();
		if (!child.isNull()) {
			result = list;
			while (!child.isConsumed()) {
				A artifact = null;
				JsonParser grandChild = child.getChild();
				if (!grandChild.isNull()) {
					artifact = artifactFactory.createJsonBlank();
					artifact.setJson(grandChild);
				}
				list.add(artifact);
				child.proceedToNextChild();
			}
		}
		jsonParser.proceedToNextChild();
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	protected final <M extends Map<String, A>, A extends Artifact> M readArtifactMapFromJson(JsonParser jsonParser,
			String key, M map, Artifact.JsonBlankFactory<A> artifactFactory) {
		assert canReadFromJson(jsonParser, key);
		assert map != null : "Precondition failed: map != null";
		assert map.isEmpty() : "Precondition failed: map.isEmpty()";
		assert artifactFactory != null : "Precondition failed: artifactFactory != null";

		M result = null;
		JsonParser child = jsonParser.getChild();
		if (!child.isNull()) {
			result = map;
			while (!child.isConsumed()) {
				String artifactKey = child.getChildKey();
				A artifact = null;
				JsonParser grandChild = child.getChild();
				if (!grandChild.isNull()) {
					artifact = artifactFactory.createJsonBlank();
					artifact.setJson(grandChild);
				}
				map.put(artifactKey, artifact);
				child.proceedToNextChild();
			}
		}
		jsonParser.proceedToNextChild();
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	protected void writeKeyToJson(StringBuilder builder, String key) {
		assert builder != null : "Precondition failed: builder != null";
		assert key != null : "Precondition failed: key != null";
		if (builder.length() > 0) {
			builder.append(", ");
		}
		builder.append("'").append(key).append("': ");
	}

	protected final void writeBooleanToJson(StringBuilder builder, String key, boolean booleanValue) {
		writeKeyToJson(builder, key);
		builder.append(booleanValue ? JsonParser.JSON_TRUE : JsonParser.JSON_FALSE);
	}

	protected final void writeIntToJson(StringBuilder builder, String key, int intValue) {
		writeKeyToJson(builder, key);
		builder.append(intValue);
	}

	protected final void writeLongToJson(StringBuilder builder, String key, long longValue) {
		writeKeyToJson(builder, key);
		builder.append("'").append(Long.toHexString(longValue)).append("'");
	}

	protected final void writeLongObjectToJson(StringBuilder builder, String key, Long optionalLongValue) {
		writeKeyToJson(builder, key);
		if (optionalLongValue == null) {
			builder.append(JsonParser.JSON_NULL);
		} else {
			builder.append("'").append(Long.toHexString(optionalLongValue)).append("'");
		}
	}

	protected final void writeStringToJson(StringBuilder builder, String key, String optionalString) {
		writeKeyToJson(builder, key);
		if (optionalString == null) {
			builder.append(JsonParser.JSON_NULL);
		} else {
			builder.append("'").append(escapeJsonString(optionalString)).append("'");
		}
	}

	protected final void writeStringArrayToJson(StringBuilder builder, String key, String[] optionalArray) {
		writeKeyToJson(builder, key);
		if (optionalArray == null) {
			builder.append(JsonParser.JSON_NULL);
		} else {
			builder.append("[");
			boolean isFirst = true;
			for (String string : optionalArray) {
				if (isFirst) {
					builder.append(" ");
					isFirst = false;
				} else {
					builder.append(", ");
				}
				if (string == null) {
					builder.append("null");
				} else {
					builder.append("'").append(escapeJsonString(string)).append("'");
				}
			}
			builder.append(" ]");
		}
	}

	protected final void writeEnumToJson(StringBuilder builder, String key, Enum<?> optionalEnum) {
		writeKeyToJson(builder, key);
		if (optionalEnum == null) {
			builder.append(JsonParser.JSON_NULL);
		} else {
			builder.append("'").append(optionalEnum.name()).append("'");
		}
	}

	protected final void writeArtifactToJson(StringBuilder builder, String key, Artifact optionalArtifact) {
		writeKeyToJson(builder, key);
		if (optionalArtifact == null) {
			builder.append(JsonParser.JSON_NULL);
		} else {
			builder.append(optionalArtifact.toJson());
		}
	}

	protected final void writeArtifactListToJson(StringBuilder builder, String key,
			List<? extends Artifact> optionalList) {
		writeKeyToJson(builder, key);
		if (optionalList == null) {
			builder.append(JsonParser.JSON_NULL);
		} else {
			builder.append("[");
			boolean isFirst = true;
			for (Artifact artifact : optionalList) {
				if (isFirst) {
					builder.append(" ");
					isFirst = false;
				} else {
					builder.append(", ");
				}
				builder.append(artifact.toJson());
			}
			builder.append(" ]");
		}
	}

	protected final void writeArtifactMapToJson(StringBuilder builder, String key,
			Map<String, ? extends Artifact> optionalMap) {
		writeKeyToJson(builder, key);
		if (optionalMap == null) {
			builder.append(JsonParser.JSON_NULL);
		} else {
			builder.append("{");
			boolean isFirst = true;
			for (String artifactKey : optionalMap.keySet()) {
				Artifact artifact = optionalMap.get(artifactKey);
				if (isFirst) {
					builder.append(" ");
					isFirst = false;
				} else {
					builder.append(", ");
				}
				builder.append("'").append(artifactKey).append("': ").append(artifact.toJson());
			}
			builder.append(" }");
		}
	}

	protected String escapeJsonString(String string) {
		assert string != null : "Precondition failed: string != null";
		String result = string.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'");
		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
