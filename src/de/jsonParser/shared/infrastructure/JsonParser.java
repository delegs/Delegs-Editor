package de.jsonParser.shared.infrastructure;

import java.io.Serializable;

public class JsonParser implements Serializable {

	public static final String JSON_NULL = "null";
	public static final String JSON_TRUE = "true";
	public static final String JSON_FALSE = "false";
	public static final String JSON_BOOLEAN_REGEX = "(" + JSON_TRUE + "|" + JSON_FALSE + ")";
	public static final String JSON_NUMBER_REGEX = "-?[0-9]+";

	private static final long serialVersionUID = 1L;

	public static enum Type {
		NULL, BOOLEAN, NUMBER, STRING, ARRAY, OBJECT;
	}

	private String json;
	private int pos;

	private Type type;

	private String key;
	private Serializable value;
	private boolean isConsumed;

	public JsonParser(String json, int pos) {
		assert json != null : "Precondition failed: json != null";
		assert pos >= 0 : "Precondition failed: pos >= 0";
		assert pos < json.length() : "Precondition failed: pos < json.length()";

		this.json = json;
		this.pos = pos;

		this.key = null;
		this.value = null;
		this.isConsumed = false;

		char c = proceedToNextChar();
		if (c == '{') { // object
			this.pos++;
			this.type = Type.OBJECT;

			proceedToNextChild();
		} else if (c == '[') { // array
			this.pos++;
			this.type = Type.ARRAY;

			proceedToNextChild();
		} else {
			this.isConsumed = true;

			if (c == '\'' || c == '\"') { // string
				StringBuilder builder = new StringBuilder();
				boolean isClosed = false;
				boolean isEscaped = false;
				int nextPos = this.pos + 1;
				while (nextPos < json.length() && !isClosed) {
					char cStr = json.charAt(nextPos);
					if (isEscaped) {
						builder.append(cStr);
						isEscaped = false;
					} else if (cStr == '\\') {
						isEscaped = true;
					} else if (cStr == c) {
						isClosed = true;
					} else {
						builder.append(cStr);
					}
					nextPos++;
				}
				nextPos++;
				if (!isClosed) {
					throw new RuntimeException(
							"unclosed string at pos " + this.pos + ": " + this.json.substring(this.pos));
				}
				value = builder.toString();
				this.type = Type.STRING;
				this.pos = nextPos;
			} else {
				int nextPos = minValidPos(json.indexOf(',', this.pos), json.indexOf(']', this.pos),
						json.indexOf('}', this.pos));
				value = json.substring(this.pos, nextPos).trim();
				if (JSON_NULL.equals(value)) {
					this.type = Type.NULL;
				} else if (((String) value).matches(JSON_NUMBER_REGEX)) {
					value = Integer.parseInt((String) value);
					this.type = Type.NUMBER;
				} else if (((String) value).matches(JSON_BOOLEAN_REGEX)) {
					value = JSON_TRUE.equals(value);
					this.type = Type.BOOLEAN;
				} else {
					throw new RuntimeException(
							"invalid value at pos " + this.pos + ": " + this.json.substring(this.pos));
				}
				this.pos = nextPos;
			}
		}
	}

	public String getJson() {
		assert json != null : "Postcondition failed: result != null";
		return json;
	}

	public int getPos() {
		assert pos >= 0 : "Postcondition failed: result >= 0";
		assert pos < getJson().length() : "Postcondition failed: result < getJson().length()";
		return pos;
	}

	public boolean isConsumed() {
		return isConsumed;
	}

	public Type getType() {
		assert type != null : "Postcondition failed: result != null";
		return type;
	}

	public boolean isNull() {
		return Type.NULL.equals(type);
	}

	public boolean getBooleanValue() {
		assert Type.BOOLEAN.equals(getType()) : "Precondition failed: Type.BOOLEAN.equals(getType())";
		return (Boolean) value;
	}

	public int getNumberValue() {
		assert Type.NUMBER.equals(getType()) : "Precondition failed: Type.NUMBER.equals(getType())";
		return (Integer) value;
	}

	public String getStringValue() {
		assert Type.STRING.equals(getType()) : "Precondition failed: Type.STRING.equals(getType())";
		assert value != null : "Postcondition failed: result != null";
		return (String) value;
	}

	public final void proceedToNextChild() {
		assert Type.ARRAY.equals(getType()) || Type.OBJECT.equals(
				getType()) : "Precondition failed: Type.ARRAY.equals(getType()) || Type.OBJECT.equals(getType())";
		assert !isConsumed() : "Precondition failed: !isConsumed()";

		if (value != null) {
			while (!((JsonParser) value).isConsumed() && (Type.ARRAY.equals(((JsonParser) value).getType())
					|| Type.OBJECT.equals(((JsonParser) value).getType()))) {
				((JsonParser) value).proceedToNextChild();
			}
			pos = ((JsonParser) value).getPos();
		}

		char c = proceedToNextChar();
		if (c == ',') {
			pos++;
		} else if (Type.ARRAY.equals(getType()) && c == ']') {
			pos++;
			isConsumed = true;
		} else if (Type.OBJECT.equals(getType()) && c == '}') {
			pos++;
			isConsumed = true;
		}

		key = null;
		value = null;
		if (!isConsumed) {
			if (Type.OBJECT.equals(getType())) {
				c = proceedToNextChar();
				if (c == '\'' || c == '\"') { // string
					pos++;
					int nextPos = json.indexOf(c, pos);
					if (nextPos < 0) {
						throw new RuntimeException("unclosed string at pos " + pos + ": " + json.substring(pos));
					}
					key = json.substring(pos, nextPos);

					pos = nextPos + 1;
					c = proceedToNextChar();
					if (c != ':') {
						throw new RuntimeException("missing colon at pos " + pos + ": " + json.substring(pos));
					}

					pos++;
				} else {
					throw new RuntimeException("key is not a string at pos" + pos + ": " + json.substring(pos));
				}
			}

			value = new JsonParser(json, pos);
		}
	}

	public String getChildKey() {
		assert Type.OBJECT.equals(getType()) : "Precondition failed: Type.OBJECT.equals(getType())";
		assert !isConsumed() : "Precondition failed: !isConsumed()";
		assert key != null : "Postcondition failed: result != null";
		return key;
	}

	public JsonParser getChild() {
		assert Type.ARRAY.equals(getType()) || Type.OBJECT.equals(
				getType()) : "Precondition failed: Type.ARRAY.equals(getType()) || Type.OBJECT.equals(getType())";
		assert !isConsumed() : "Precondition failed: !isConsumed()";
		assert value != null : "Postcondition failed: result != null";
		return (JsonParser) value;
	}

	// protected interface

	protected final char proceedToNextChar() {
		char c = json.charAt(pos);
		while (c == ' ' || c == '\t' || c == '\n' || c == '\f' || c == '\r') {
			pos++;
			c = json.charAt(pos);
		}
		return c;
	}

	protected static int minValidPos(int... poses) {
		assert poses != null : "Precondition failed: poses != null";
		int result = -1;
		for (int pos : poses) {
			if ((result < 0 || result > pos) && pos >= 0) {
				result = pos;
			}
		}
		return result;
	}
}
