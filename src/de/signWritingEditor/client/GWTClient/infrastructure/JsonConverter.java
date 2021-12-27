package de.signWritingEditor.client.GWTClient.infrastructure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.Locatable;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.TextbasedToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.VideoToken;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class JsonConverter {
	private static final String TOKEN_BACKGROUND_COLOR = "token_backgroundColor";
	private static final String TOKEN_ID = "token_id";
	private static final String SECTION_PARAGRAPHS = "section_paragraphs";
	private static final String SECTION_IS_FREE_POSITIONABLE = "section_isFreePositionable";
	private static final String SECTION_FREE_POSTIONED_SECTION_ID = "section_freePostionedSectionId";
	private static final String VIDEO_TOKEN_URL = "videoToken_url";
	private static final String VIDEO_TOKEN_HEIGHT = "videoToken_height";
	private static final String VIDEO_TOKEN_WIDTH = "videoToken_width";
	private static final String IMAGE_TOKEN_URL = "imageToken_url";
	private static final String IMAGE_TOKEN_HEIGHT = "imageToken_height";
	private static final String IMAGE_TOKEN_WIDTH = "imageToken_width";
	private static final String FRAME_TOKEN_HEIGHT = "frameToken_height";
	private static final String FRAME_TOKEN_WIDTH = "frameToken_width";
	private static final String FRAME_TOKEN_BORDER_WIDTH = "frameToken_borderWidth";
	private static final String FRAME_TOKEN_FRAME_COLOR = "frameToken_frameColor";
	private static final String FREE_TEXT_TOKEN_IS_FREE_TEXT_LINE = "freeTextToken_isFreeTextLine";
	private static final String FREE_TEXT_TOKEN_FIXEDWIDTH = "freeTextToken_fixedwidth";
	private static final String FREE_TEXT_TOKEN_WIDTH = "freeTextToken_width";
	private static final String TEXTBASED_TOKEN_TEXT = "textbasedToken_text";
	private static final String TEXTBASED_TOKEN_TEXT_BACKGROUND_COLOR = "signItemToken_textBackgroundColor";
	private static final String TEXTBASED_TOKEN_FONT_COLOR = "textbasedToken_fontColor";
	private static final String TEXTBASED_TOKEN_FONT_SIZE = "textbasedToken_fontSize";
	private static final String TEXTBASED_TOKEN_FONT_STYLE = "textbasedToken_fontStyle";
	private static final String TEXTBASED_TOKEN_FONT_WEIGHT = "textbasedToken_fontWeight";
	private static final String TEXTBASED_TOKEN_FONT = "textbasedToken_font";
	private static final String SIGN_ITEM_TOKEN_LOCALE = "signItemToken_locale";
	private static final String SIGN_ITEM_TOKEN_SIGN_ITEM = "signItemToken_signItem";
	private static final String ID_LOWER_PART = "id_lowerPart";
	private static final String ID_UPPER_PART = "id_upperPart";
	private static final String PARAGRAPH_TOKENS = "paragraph_tokens";
	private static final String PARAGRAPH_ZINDEX = "paragraph_zindex";
	private static final String PARAGRAPH_POSITIONX = "paragraph_positionx";
	private static final String PARAGRAPH_POSITIONY = "paragraph_positiony";
	private static final String PARAGRAPH_WIDTH = "paragraph_width";
	private static final String PARAGRAPH_ID = "paragraph_id";
	private static final String VALUE_KEY = "value";
	private static final String CLASS_KEY = "class";
	private static final String HEAD_SYMBOLS_KEY = "headSymbols";
	private static final String DISARRANGED_HEAD_SYMBOLS_KEY = "disarrangedHeadSymbols";
	private static final String HEAD_POSTURE_SYMBOL_KEY = "headPostureSymbol";
	private static final String MOUTH_SYMBOL_KEY = "mouthSymbol";
	private static final String NOSE_SYMBOL_KEY = "noseSymbol";
	private static final String NECK_SYMBOL_KEY = "neckSymbol";
	private static final String EXPRESSION_SYMBOL_KEY = "expressionSymbol";
	private static final String HAIR_SYMBOL_KEY = "hairSymbol";
	private static final String HAND_SYMBOLS_KEY = "handSymbols";
	private static final String EYE_SYMBOLS_KEY = "eyeSymbols";
	private static final String CHEEK_SYMBOLS_KEY = "cheekSymbols";
	private static final String EAR_SYMBOLS_KEY = "earSymbols";
	private static final String BREATH_SYMBOLS_KEY = "breathSymbols";
	private static final String JAW_SYMBOLS_KEY = "jawSymbols";
	private static final String COLOR_KEY = "cssColor";
	private static final String ROTATION_KEY = "rotation";
	private static final String FILL_KEY = "fill";
	private static final String VARIATION_KEY = "variation";
	private static final String GROUP_KEY = "group";
	private static final String CATEGORY_KEY = "category";
	private static final String X_KEY = "x";
	private static final String Y_KEY = "y";
	private static final String Z_KEY = "z";
	private static final String SYMBOL_KEY = "symbol";
	private static final String LOWER_ID_KEY = "lowerId";
	private static final String UPPER_ID_KEY = "upperId";
	private static final String SOURCE_ID_KEY = "source";
	private static final String LAST_NAME_KEY = "lastName";
	private static final String FIRST_NAME_KEY = "firstName";
	private static final String EMAIL_ADDRESS_KEY = "emailAddress";
	private static final String USER_ROLES_KEY = "userRoles";
	private static final String USER_NAME_KEY = "userName";
	private static final String ACCEPTED_PRIVACY_POLICY_VERSION_KEY = "acceptedPrivacyPolicyVersion";
	private static final String LANGUAGE_KEY = "language";
	private static final String AUTHOR_KEY = "author";
	private static final String SYMBOLS_KEY = "symbols";
	private static final String LOCAL_SIGN_KEY = "localSign";
	private static final String WIDTH_KEY = "width";
	private static final String ID_KEY = "id";
	private static final String MDT_KEY = "mdt";
	private static final String COMMENT_KEY = "comment";
	private static final String HEIGHT_KEY = "height";
	private static final String LOCATION_KEY = "location";

	private PositionedSymbolFactory positionedSymbolFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;
	private TokenFactory tokenFactory;

	public JsonConverter(TokenFactory tokenFactory, TextbasedTokenStyleFactory textbasedTokenStyleFactory,
			PositionedSymbolFactory positionedSymbolFactory) {
		assert positionedSymbolFactory != null : "Precondition failed: positionedSymbolFactory != null";
		assert textbasedTokenStyleFactory != null : "Precondition failed:  textbasedTokenStyleFactory != null";
		assert tokenFactory != null : "Precondition failed:  tokenFactory != null";

		this.tokenFactory = tokenFactory;
		this.textbasedTokenStyleFactory = textbasedTokenStyleFactory;
		this.positionedSymbolFactory = positionedSymbolFactory;
	}

	private String deserializeJsonString(JSONValue jsonValue) {
		assert jsonValue != null : "Precondition failed: jsonValue != null";

		String result = null;
		if (jsonValue instanceof JSONString) {
			result = ((JSONString) jsonValue).stringValue();
		}
		return result;
	}

	private JSONValue serializeSignItemToken(SignItemToken signItemToken) {
		assert signItemToken != null : "Precondition failed: value != null";

		JSONObject result = new JSONObject();
		result.put(SIGN_ITEM_TOKEN_SIGN_ITEM, serializeObject(signItemToken.getSignItem()));
		result.put(SIGN_ITEM_TOKEN_LOCALE, serializeObject(signItemToken.getLocale()));
		serializeTokenAttributesAndSaveInJsonObject(signItemToken, result);
		serializeTextbasedTokenAttributesAndSaveInJsonObject(signItemToken, result);

		return result;
	}

	private JSONValue serializeList(List<?> value) {
		assert value != null : "Precondition failed: value != null";

		JSONArray result = new JSONArray();
		for (Object obj : value) {
			JSONValue jsonValue = serializeObject(obj);
			result.set(result.size(), jsonValue);
		}
		return result;
	}

	private JSONValue serializeId(Id value) {
		assert value != null : "Precondition failed: value != null";

		JSONObject result = new JSONObject();
		result.put(ID_LOWER_PART, serializeObject(value.getLowerIdPart()));
		result.put(ID_UPPER_PART, serializeObject(value.getUpperIdPart()));

		return result;
	}

	private JSONValue serializeFreeTextToken(FreeTextToken value) {
		assert value != null : "Precondition failed: value != null";

		JSONObject result = new JSONObject();
		result.put(FREE_TEXT_TOKEN_WIDTH, serializeObject(value.getWidth()));
		result.put(FREE_TEXT_TOKEN_FIXEDWIDTH, serializeObject(value.hasFixedWidth()));
		result.put(FREE_TEXT_TOKEN_IS_FREE_TEXT_LINE, serializeObject(value.isFreeTextLine()));
		serializeTokenAttributesAndSaveInJsonObject(value, result);
		serializeTextbasedTokenAttributesAndSaveInJsonObject(value, result);

		return result;
	}

	private JSONValue serializeFrameToken(FrameToken value) {
		assert value != null : "Precondition failed: value != null";

		JSONObject result = new JSONObject();
		result.put(FRAME_TOKEN_FRAME_COLOR, serializeObject(value.getFrameColor().getCssValue()));
		result.put(FRAME_TOKEN_BORDER_WIDTH, serializeObject(value.getBorderWidth_PX()));
		result.put(FRAME_TOKEN_WIDTH, serializeObject(value.getWidth()));
		result.put(FRAME_TOKEN_HEIGHT, serializeObject(value.getHeight()));
		serializeTokenAttributesAndSaveInJsonObject(value, result);

		return result;
	}

	private JSONValue serializeVideoToken(VideoToken value) {
		assert value != null : "Precondition failed: value != null";

		JSONObject result = new JSONObject();
		result.put(VIDEO_TOKEN_WIDTH, serializeObject(value.getWidth()));
		result.put(VIDEO_TOKEN_HEIGHT, serializeObject(value.getHeight()));
		result.put(VIDEO_TOKEN_URL, serializeObject(value.getUrl()));
		serializeTokenAttributesAndSaveInJsonObject(value, result);

		return result;
	}

	private JSONValue serializeImageToken(ImageToken imageToken) {
		assert imageToken != null : "Precondition failed: value != null";

		JSONObject result = new JSONObject();
		result.put(IMAGE_TOKEN_WIDTH, serializeObject(imageToken.getWidth()));
		result.put(IMAGE_TOKEN_HEIGHT, serializeObject(imageToken.getHeight()));
		result.put(IMAGE_TOKEN_URL, serializeObject(imageToken.getUrl()));
		serializeTokenAttributesAndSaveInJsonObject(imageToken, result);

		return result;
	}

	private JSONValue serializeColor(Color color) {
		assert color != null : "Precondition failed: color != null";

		JSONObject result = new JSONObject();
		result.put(COLOR_KEY, new JSONString(color.getCssValue()));

		assert result != null : "Precondition failed: result != null";
		assert result.get(COLOR_KEY) != null : "Precondition failed: result.get(COLOR_KEY) != null";
		assert result.get(
				COLOR_KEY) instanceof JSONString : "Precondition failed: result.get(COLOR_KEY) instanceof JSONString";
		assert ((JSONString) result.get(COLOR_KEY))
				.stringValue() != null : "Precondition failed: ((JSONString)result.get(COLOR_KEY)).stringValue() != null";
		assert ((JSONString) result.get(COLOR_KEY)).stringValue()
				.length() == 7 : "Precondition failed: ((JSONString)result.get(COLOR_KEY)).stringValue().length() == 7";

		return result;
	}

	private JSONValue serializeObject(Object value) {
		JSONValue result;
		if (value != null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(CLASS_KEY, checkTypeAndSerializeObject(value.getClass().getName()));
			jsonObject.put(VALUE_KEY, checkTypeAndSerializeObject(value));
			result = jsonObject;
		} else {
			result = JSONNull.getInstance();
		}
		return result;
	}

	private JSONValue checkTypeAndSerializeObject(Object value) {
		if (value instanceof String) {
			return new JSONString(value.toString());
		} else if (value instanceof Number) {
			return new JSONNumber(((Number) value).doubleValue());
		} else if (value instanceof Boolean) {
			return JSONBoolean.getInstance((Boolean) value);
		} else if (value instanceof Enum<?>) {
			Enum<?> enumeration = (Enum<?>) value;
			return new JSONString(enumeration.name());
		} else if (value instanceof List) {
			return serializeList((List<?>) value);
		} else if (value instanceof Id) {
			return serializeId((Id) value);
		} else if (value instanceof Section) {
			return serializeSection((Section) value);
		} else if (value instanceof Paragraph) {
			return serializeParagraph((Paragraph) value);
		} else if (value instanceof SignItem) {
			return serializeSignItem((SignItem) value);
		} else if (value instanceof SignItemToken) {
			return serializeSignItemToken((SignItemToken) value);
		} else if (value instanceof FreeTextToken) {
			return serializeFreeTextToken((FreeTextToken) value);
		} else if (value instanceof FrameToken) {
			return serializeFrameToken((FrameToken) value);
		} else if (value instanceof VideoToken) {
			return serializeVideoToken((VideoToken) value);
		} else if (value instanceof ImageToken) {
			return serializeImageToken((ImageToken) value);
		} else if (value instanceof Color) {
			return serializeColor((Color) value);
		} else {
			throw reportUnsupportedType(value);
		}
	}

	private void serializeTokenAttributesAndSaveInJsonObject(Token token, JSONObject object) {
		assert token != null : "Precondition failed: textbasedToken != null";
		assert object != null : "Precondition failed: object != null";

		object.put(TOKEN_ID, serializeObject(token.getId()));
		object.put(TOKEN_BACKGROUND_COLOR, serializeObject(token.getBackgroundColor().getCssValue()));
	}

	private void serializeTextbasedTokenAttributesAndSaveInJsonObject(TextbasedToken textbasedToken,
			JSONObject object) {
		assert textbasedToken != null : "Precondition failed: textbasedToken != null";
		assert object != null : "Precondition failed: object != null";

		object.put(TEXTBASED_TOKEN_TEXT, serializeObject(textbasedToken.getText()));
		object.put(TEXTBASED_TOKEN_FONT, serializeObject(textbasedToken.getStyle().getFont()));
		object.put(TEXTBASED_TOKEN_FONT_WEIGHT, serializeObject(textbasedToken.getStyle().getFontWeight()));
		object.put(TEXTBASED_TOKEN_FONT_STYLE, serializeObject(textbasedToken.getStyle().getFontStyle()));
		object.put(TEXTBASED_TOKEN_FONT_SIZE, serializeObject(textbasedToken.getStyle().getFontSize()));
		object.put(TEXTBASED_TOKEN_FONT_COLOR, serializeObject(textbasedToken.getFontColor().getCssValue()));
		object.put(TEXTBASED_TOKEN_TEXT_BACKGROUND_COLOR,
				serializeObject(textbasedToken.getTextBackgroundColor().getCssValue()));
	}

	private <T> T deserializeJson(String jsonString) {
		assert jsonString != null : "Precondition failed: jsonString != null";

		JSONValue jsonValue = JSONParser.parseStrict(jsonString);

		return deserializeJson(jsonValue);
	}

	@SuppressWarnings("unchecked")
	private <T> T deserializeJson(JSONValue jsonValue) {
		Object result;
		if (jsonValue instanceof JSONArray) {
			result = deserializeList(jsonValue.isArray());
		} else if (jsonValue instanceof JSONBoolean) {
			result = deserializeJsonBoolean(jsonValue.isBoolean());
		} else if (jsonValue instanceof JSONString) {
			result = deserializeJsonString(jsonValue.isString());
		} else if (jsonValue instanceof JSONObject || jsonValue instanceof JSONNumber) {
			result = deserializeJsonObject(jsonValue.isObject());
		} else if (jsonValue instanceof JSONNull) {
			return null;
		} else {
			throw reportUnsupportedType(jsonValue);
		}
		return (T) result;
	}

	private Object deserializeJsonObject(JSONObject object) {
		if (object.size() == 2 && object.containsKey(CLASS_KEY) && object.containsKey(VALUE_KEY)) {
			JSONValue classkey = object.get(CLASS_KEY);
			JSONValue value = object.get(VALUE_KEY);
			if (!(classkey instanceof JSONNull) && value instanceof JSONValue) {
				JSONString string = classkey.isString();
				if (string != null) {
					String classname = string.stringValue();

					if (Integer.class.getName().equals(classname)) {
						return deserializeJsonNumberToInteger(value.isNumber());
					} else if (Float.class.getName().equals(classname)) {
						return deserializeJsonNumberToFloat(value.isNumber());
					} else if (Long.class.getName().equals(classname)) {
						return deserializeJsonNumberToLong(value.isNumber());
					} else if (Double.class.getName().equals(classname)) {
						return deserializeJsonNumberToDouble(value.isNumber());
					} else if (Id.class.getName().equals(classname)) {
						return deserializeId(value.isObject());
					} else if (SignItem.class.getName().equals(classname)) {
						return deserializeSignItem(value.isObject());
					} else if (SignItemToken.class.getName().equals(classname)) {
						return deserializeSignItemToken(value.isObject());
					} else if (FreeTextToken.class.getName().equals(classname)) {
						return deserializeFreeTextToken(value.isObject());
					} else if (FrameToken.class.getName().equals(classname)) {
						return deserializeFrameToken(value.isObject());
					} else if (VideoToken.class.getName().equals(classname)) {
						return deserializeVideoToken(value.isObject());
					} else if (ImageToken.class.getName().equals(classname)) {
						return deserializeImageToken(value.isObject());
					} else if (Paragraph.class.getName().equals(classname)) {
						return deserializeParagraph(value.isObject());
					} else if (Section.class.getName().equals(classname)) {
						return deserializeSection(value.isObject());
					} else if (Font.class.getName().equals(classname)) {
						return deserializeEnum(value.isString(), Font.class);
					} else if (FontStyle.class.getName().equals(classname)) {
						return deserializeEnum(value.isString(), FontStyle.class);
					} else if (FontWeight.class.getName().equals(classname)) {
						return deserializeEnum(value.isString(), FontWeight.class);
					} else if (FontSize.class.getName().equals(classname)) {
						return deserializeEnum(value.isString(), FontSize.class);
					} else if (SignLocale.class.getName().equals(classname)) {
						return deserializeEnum(value.isString(), SignLocale.class);
					} else if (Color.class.getName().equals(classname)) {
						return deserializeColor(value.isObject());
					} else {
						return deserializeJson(value);
					}
				}
			}
		}
		throw new RuntimeException("Class wrapper is invalid. Object: " + object + " "
				+ (object == null ? "null" : object.getClass().getName()));

	}

	private Object deserializeSection(JSONObject object) {
		assert object != null : "Precondition failed: object != null";

		Id collageId = deserializeJson(object.get(SECTION_FREE_POSTIONED_SECTION_ID));
		boolean isFreePositionable = deserializeJson(object.get(SECTION_IS_FREE_POSITIONABLE));
		List<Paragraph> paragraphs = deserializeJson(object.get(SECTION_PARAGRAPHS));

		Section result = new Section();
		result.setIsCollage(isFreePositionable, collageId);
		for (Paragraph paragraph : paragraphs) {
			result.addParagraph(paragraph);
		}
		return result;
	}

	private Object deserializeVideoToken(JSONObject object) {
		assert object != null : "Precondition failed: object != null";

		Id id = deserializeJson(object.get(TOKEN_ID));
		String backgroundColor = deserializeJson(object.get(TOKEN_BACKGROUND_COLOR));
		int height = deserializeJson(object.get(VIDEO_TOKEN_HEIGHT));
		int width = deserializeJson(object.get(VIDEO_TOKEN_WIDTH));
		String url = deserializeJson(object.get(VIDEO_TOKEN_URL));

		VideoToken result = tokenFactory.createVideoToken(id);
		result.setBackgroundColor(Color.makeFromCssString(backgroundColor));
		result.setHeight(height);
		result.setWidth(width);
		result.setUrl(url);
		return result;
	}

	private Object deserializeImageToken(JSONObject object) {
		assert object != null : "Precondition failed: object != null";

		Id id = deserializeJson(object.get(TOKEN_ID));
		String backgroundColor = deserializeJson(object.get(TOKEN_BACKGROUND_COLOR));
		int height = deserializeJson(object.get(IMAGE_TOKEN_HEIGHT));
		int width = deserializeJson(object.get(IMAGE_TOKEN_WIDTH));
		String url = deserializeJson(object.get(IMAGE_TOKEN_URL));

		ImageToken result = tokenFactory.createImageToken(id);
		result.setBackgroundColor(Color.makeFromCssString(backgroundColor));
		result.setHeight(height);
		result.setWidth(width);
		result.setUrl(url);
		return result;
	}

	private Object deserializeFrameToken(JSONObject object) {
		assert object != null : "Precondition failed: object != null";

		Id id = deserializeJson(object.get(TOKEN_ID));
		String backgroundColor = deserializeJson(object.get(TOKEN_BACKGROUND_COLOR));
		int width = deserializeJson(object.get(FRAME_TOKEN_WIDTH));
		int height = deserializeJson(object.get(FRAME_TOKEN_HEIGHT));
		int borderWidth = deserializeJson(object.get(FRAME_TOKEN_BORDER_WIDTH));
		String frameColor = deserializeJson(object.get(FRAME_TOKEN_FRAME_COLOR));

		FrameToken result = tokenFactory.createFrameToken(id);
		result.setBackgroundColor(Color.makeFromCssString(backgroundColor));
		result.setBorderWidth(borderWidth);
		result.setFrameColor(Color.makeFromCssString(frameColor));
		result.setHeight(height);
		result.setWidth(width);

		return result;
	}

	private Object deserializeFreeTextToken(JSONObject object) {
		assert object != null : "Precondition failed: object != null";

		Id id = deserializeJson(object.get(TOKEN_ID));
		boolean fixedWidth = deserializeJson(object.get(FREE_TEXT_TOKEN_FIXEDWIDTH));
		int width = deserializeJson(object.get(FREE_TEXT_TOKEN_WIDTH));
		boolean isLine = deserializeJson(object.get(FREE_TEXT_TOKEN_IS_FREE_TEXT_LINE));
		String text = deserializeJson(object.get(TEXTBASED_TOKEN_TEXT));

		ReadOnlyTextbasedTokenStyle readOnlyTextbasedTokenStyle = deserializeTokenStyle(object);
		FreeTextToken freeTextToken = tokenFactory.createFreeTextToken(id, readOnlyTextbasedTokenStyle);

		freeTextToken.setFixedWidth(fixedWidth, width);
		freeTextToken.setIsFreeTextLine(isLine);
		freeTextToken.setText(text);

		return freeTextToken;
	}

	private Color deserializeColor(JSONObject object) {
		assert object != null : "Precondition failed: object != null";
		assert object.get(COLOR_KEY) != null : "Precondition failed: object.get(COLOR_KEY) != null";
		assert object.get(
				COLOR_KEY) instanceof JSONString : "Precondition failed: object.get(COLOR_KEY) instanceof JSONString";
		assert ((JSONString) object.get(COLOR_KEY))
				.stringValue() != null : "Precondition failed: ((JSONString)object.get(COLOR_KEY)).stringValue() != null";
		assert ((JSONString) object.get(COLOR_KEY)).stringValue()
				.length() == 7 : "Precondition failed: ((JSONString)object.get(COLOR_KEY)).stringValue().length() == 7";

		return Color.makeFromCssString(((JSONString) object.get(COLOR_KEY)).stringValue());
	}

	private <T extends Enum<T>> T deserializeEnum(JSONString jsonString, Class<T> clazz) {
		assert jsonString != null : "Precondition failed: jsonString != null";
		assert clazz != null : "Precondition failed: enumClass != null";

		String stringValue = jsonString.stringValue();
		return Enum.valueOf(clazz, stringValue);
	}

	private <T> List<T> deserializeList(JSONArray array) {
		assert array != null : "Precondition failed: array != null";

		List<T> result = new ArrayList<T>();
		for (int i = 0; i < array.size(); i++) {
			T obj = deserializeJson(array.get(i));
			result.add(obj);
		}

		return result;
	}

	private Id deserializeId(JSONObject valueObject) {
		assert valueObject != null : "Precondition failed: valueObject != null";

		long upperIdPart = deserializeJson(valueObject.get(ID_UPPER_PART));
		long lowerIdPart = deserializeJson(valueObject.get(ID_LOWER_PART));

		return new Id(upperIdPart, lowerIdPart);
	}

	private RuntimeException reportUnsupportedType(Object object) {
		throw new RuntimeException(
				"Unsupported Json data type " + object + " " + (object == null ? "null" : object.getClass().getName()));
	}

	private double deserializeJsonNumberToDouble(JSONNumber number) {
		return (double) number.doubleValue();
	}

	private long deserializeJsonNumberToLong(JSONNumber number) {
		return (long) number.doubleValue();
	}

	private float deserializeJsonNumberToFloat(JSONNumber number) {
		return (float) number.doubleValue();
	}

	private int deserializeJsonNumberToInteger(JSONNumber valueObject) {
		return (int) valueObject.doubleValue();
	}

	private Object deserializeSignItemToken(JSONObject object) {
		assert object != null : "Precondition failed: object != null";

		SignItem signItem = deserializeJson(object.get(SIGN_ITEM_TOKEN_SIGN_ITEM));
		Id id = deserializeJson(object.get(TOKEN_ID));
		String backgroundColor = deserializeJson(object.get(TOKEN_BACKGROUND_COLOR));
		SignLocale signLocale = deserializeJson(object.get(SIGN_ITEM_TOKEN_LOCALE));
		String text = deserializeJson(object.get(TEXTBASED_TOKEN_TEXT));

		ReadOnlyTextbasedTokenStyle readOnlyTextbasedTokenStyle = deserializeTokenStyle(object);
		SignItemToken signItemToken = tokenFactory.createSignItemToken("", signItem, id, readOnlyTextbasedTokenStyle,
				Color.makeFromCssString(backgroundColor), signLocale, false, false);

		signItemToken.setSignLocale(signLocale);

		signItemToken.setText(text);

		return signItemToken;
	}

	private ReadOnlyTextbasedTokenStyle deserializeTokenStyle(JSONObject object) {
		assert object != null : "Precondition failed: object != null";

		String text = deserializeJson(object.get(TEXTBASED_TOKEN_TEXT));
		Font font = deserializeJson(object.get(TEXTBASED_TOKEN_FONT));
		FontStyle fontStyle = deserializeJson(object.get(TEXTBASED_TOKEN_FONT_STYLE));
		FontWeight fontWeight = deserializeJson(object.get(TEXTBASED_TOKEN_FONT_WEIGHT));
		String textBackgroundColor = deserializeJson(object.get(TEXTBASED_TOKEN_TEXT_BACKGROUND_COLOR));
		FontSize fontSize = deserializeJson(object.get(TEXTBASED_TOKEN_FONT_SIZE));
		String fontColor = deserializeJson(object.get(TEXTBASED_TOKEN_FONT_COLOR));

		assert text != null : "Precondition failed: text != null";
		assert font != null : "Precondition failed: font != null";
		assert fontStyle != null : "Precondition failed: fontStyle != null";
		assert fontWeight != null : "Precondition failed: fontWeight != null";
		assert textBackgroundColor != null : "Precondition failed: textBackgroundColor != null";
		assert fontSize != null : "Precondition failed: fontSize != null";
		assert fontColor != null : "Precondition failed: fontColor != null";

		return textbasedTokenStyleFactory.createTextbasedTokenStyle(fontSize, Color.makeFromCssString(fontColor),
				Color.makeFromCssString(textBackgroundColor), fontStyle, fontWeight, font);
	}

	private Object deserializeParagraph(JSONObject valueObject) {
		assert valueObject != null : "Precondition failed: valueObject != null";

		Id paragraphId = deserializeJson(valueObject.get(PARAGRAPH_ID));
		int width = deserializeJson(valueObject.get(PARAGRAPH_WIDTH));
		int positionX = deserializeJson(valueObject.get(PARAGRAPH_POSITIONX));
		int positionY = deserializeJson(valueObject.get(PARAGRAPH_POSITIONY));
		int zIndex = deserializeJson(valueObject.get(PARAGRAPH_ZINDEX));
		List<Token> tokenList = deserializeJson(valueObject.get(PARAGRAPH_TOKENS));
		Paragraph result = new Paragraph(paragraphId, width, positionX, positionY, zIndex);
		for (Token token : tokenList) {
			result.addToken(token);
		}
		return result;
	}

	private Boolean deserializeJsonBoolean(JSONBoolean bool) {
		assert bool != null : "Precondition failed: bool != null";
		return bool.booleanValue();
	}

	public String convert(Object o) {
		return serializeObject(o).toString();
	}

	public <T> T reconvert(String json) {
		return deserializeJson(json);
	}

	public String convertSignItemList(List<SignItem> signItems) {
		assert signItems != null : "Precondition failed: signItems != null";

		JSONArray signItemJsonArray = new JSONArray();

		for (SignItem signItem : signItems) {
			if (signItem == null) {
				signItemJsonArray.set(signItemJsonArray.size(), JSONNull.getInstance());
			} else {
				signItemJsonArray.set(signItemJsonArray.size(), serializeSignItem(signItem));
			}
		}

		return signItemJsonArray.toString();
	}

	public List<SignItem> reconvertSignItemList(String jsonString) {
		assert jsonString != null : "Precondition failed: jsonString != null";
		assert !jsonString.isEmpty() : "Precondition failed: !jsonString.isEmpty()";

		JSONArray signItemJsonArray = JSONParser.parseStrict(jsonString).isArray();
		List<SignItem> result = new ArrayList<SignItem>();

		for (int i = 0; i < signItemJsonArray.size(); i++) {
			JSONValue jsonValue = signItemJsonArray.get(i);

			if (jsonValue.isNull() != null) {
				result.add(null);
			} else {
				result.add(deserializeSignItem(jsonValue.isObject()));
			}
		}

		return result;
	}

	/**
	 * use {@link #convert(Object)} instead
	 * 
	 * @param string
	 * @return
	 */
	@Deprecated
	public String convertString(String string) {
		assert string != null : "Precondition failed: string != null";

		return new JSONString(string).toString();
	}

	/**
	 * use {@link #reconvert(String)} instead
	 * 
	 * @param jsonString
	 * @return
	 */
	@Deprecated
	public String reconvertString(String jsonString) {
		assert jsonString != null : "Precondition failed: jsonString != null";

		return JSONParser.parseStrict(jsonString).isString().stringValue();
	}

	private JSONValue serializeSection(Section value) {
		assert value != null : "Precondition failed: value != null";

		JSONObject result = new JSONObject();
		result.put(SECTION_FREE_POSTIONED_SECTION_ID, serializeObject(value.getCollageId()));
		result.put(SECTION_IS_FREE_POSITIONABLE, serializeObject(value.isCollage()));
		result.put(SECTION_PARAGRAPHS, serializeObject(value.getParagraphs()));

		return result;
	}

	private JSONValue serializeParagraph(Paragraph value) {
		assert value != null : "Precondition failed: value != null";

		JSONObject result = new JSONObject();
		result.put(PARAGRAPH_WIDTH, serializeObject(value.getWidth()));
		result.put(PARAGRAPH_POSITIONX, serializeObject(value.getPositionX()));
		result.put(PARAGRAPH_POSITIONY, serializeObject(value.getPositionY()));
		result.put(PARAGRAPH_ZINDEX, serializeObject(value.getZIndex()));
		result.put(PARAGRAPH_ID, serializeObject(value.getParagraphId()));
		result.put(PARAGRAPH_TOKENS, serializeObject(value.getTokens()));

		return result;
	}

	private JSONObject serializeSignItem(SignItem signItem) {
		assert signItem != null : "Precondition failed: signItem != null";

		JSONObject result = new JSONObject();

		result.put(ID_KEY, serializeSignId(signItem.getSignId()));
		result.put(WIDTH_KEY, new JSONNumber(signItem.getSignWidth()));
		if (signItem.hasLocalSign()) {
			result.put(LOCAL_SIGN_KEY, serializeSign(signItem.getLocalSign()));
		}

		return result;
	}

	private JSONObject serializeSign(SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";

		JSONObject result = new JSONObject();

		result.put(LANGUAGE_KEY, new JSONString(sign.getSignLocale().name()));
		result.put(ID_KEY, serializeSignId(sign.getSignId()));
		result.put(AUTHOR_KEY, serializeUser(sign.getAuthor()));
		result.put(SYMBOLS_KEY, serializePositionedSymbolList(sign.getOtherSymbols()));
		result.put(HEAD_SYMBOLS_KEY, serializeHeadSymbolList(sign.getHeadSymbols()));
		result.put(DISARRANGED_HEAD_SYMBOLS_KEY, serializeHeadSymbolList(sign.getDisarrangedHeadSymbols()));
		result.put(HAND_SYMBOLS_KEY, serializePositionedSymbolList(sign.getHandSymbols()));
		result.put(MDT_KEY, serializeDate(sign.getModificationDate()));
		result.put(COMMENT_KEY, new JSONString(sign.getComment()));

		return result;
	}

	private JSONNumber serializeDate(Date modificationDate) {
		assert modificationDate != null : "Precondition failed: modificationDate != null";

		return new JSONNumber(modificationDate.getTime());
	}

	private JSONObject serializeHeadSymbol(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		JSONObject result = new JSONObject();

		JSONObject mouth = serializePositionedSymbol(headSymbol.getPositionedMouthSymbol());
		result.put(MOUTH_SYMBOL_KEY, mouth);
		JSONObject headPosture = serializePositionedSymbol(headSymbol.getPositionedHeadPostureSymbol());
		result.put(HEAD_POSTURE_SYMBOL_KEY, headPosture);
		JSONObject nose = serializePositionedSymbol(headSymbol.getPositionedNoseSymbol());
		result.put(NOSE_SYMBOL_KEY, nose);
		JSONObject neck = serializePositionedSymbol(headSymbol.getPositionedNeckSymbol());
		result.put(NECK_SYMBOL_KEY, neck);
		JSONObject expression = serializePositionedSymbol(headSymbol.getPositionedExpressionSymbol());
		result.put(EXPRESSION_SYMBOL_KEY, expression);
		JSONObject hair = serializePositionedSymbol(headSymbol.getPositionedHairSymbol());
		result.put(HAIR_SYMBOL_KEY, hair);

		JSONArray eyes = serializePositionedSymbolList(headSymbol.getPositionedEyeSymbols());
		result.put(EYE_SYMBOLS_KEY, eyes);
		JSONArray cheeks = serializePositionedSymbolList(headSymbol.getPositionedCheekSymbols());
		result.put(CHEEK_SYMBOLS_KEY, cheeks);
		JSONArray ears = serializePositionedSymbolList(headSymbol.getPositionedEarSymbols());
		result.put(EAR_SYMBOLS_KEY, ears);
		JSONArray breath = serializePositionedSymbolList(headSymbol.getPositionedBreathSymbols());
		result.put(BREATH_SYMBOLS_KEY, breath);
		JSONArray jaw = serializePositionedSymbolList(headSymbol.getPositionedJawSymbols());
		result.put(JAW_SYMBOLS_KEY, jaw);

		result.put(X_KEY, new JSONNumber(headSymbol.getX()));
		result.put(Y_KEY, new JSONNumber(headSymbol.getY()));
		result.put(Z_KEY, new JSONNumber(headSymbol.getZ()));

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private JSONArray serializeHeadSymbolList(List<HeadSymbol> headSymbols) {
		assert headSymbols != null : "Precondition failed: headSymbols != null";

		JSONArray result = new JSONArray();

		for (HeadSymbol headSymbol : headSymbols) {
			result.set(result.size(), serializeHeadSymbol(headSymbol));
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private <T extends PositionedSymbol> JSONArray serializePositionedSymbolList(List<T> symbols) {
		assert symbols != null : "Precondition failed: symbols != null";

		JSONArray result = new JSONArray();

		for (PositionedSymbol positionedSymbol : symbols) {
			JSONObject positionedSymbolJsonObject = serializePositionedSymbol(positionedSymbol);
			result.set(result.size(), positionedSymbolJsonObject);
		}

		return result;
	}

	private JSONObject serializePositionedSymbol(PositionedSymbol positionedSymbol) {
		assert positionedSymbol != null : "Precondition failed: positionedSymbol != null";

		JSONObject result = new JSONObject();

		result.put(SYMBOL_KEY, serializeSymbol(positionedSymbol.getSymbol()));
		result.put(X_KEY, new JSONNumber(positionedSymbol.getX()));
		result.put(Y_KEY, new JSONNumber(positionedSymbol.getY()));
		result.put(Z_KEY, new JSONNumber(positionedSymbol.getZ()));

		if (positionedSymbol instanceof Locatable) {
			result.put(LOCATION_KEY, new JSONString(((Locatable) positionedSymbol).getLocation().name()));
		}

		return result;
	}

	private JSONObject serializeSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		JSONObject result = new JSONObject();

		result.put(CATEGORY_KEY, new JSONNumber(symbol.getCategory()));
		result.put(GROUP_KEY, new JSONNumber(symbol.getGroup()));
		result.put(SYMBOL_KEY, new JSONNumber(symbol.getSymbol()));
		result.put(VARIATION_KEY, new JSONNumber(symbol.getVariation()));
		result.put(FILL_KEY, new JSONNumber(symbol.getFill()));
		result.put(ROTATION_KEY, new JSONNumber(symbol.getRotation()));
		result.put(WIDTH_KEY, new JSONNumber(symbol.getWidth()));
		result.put(HEIGHT_KEY, new JSONNumber(symbol.getHeight()));

		return result;
	}

	private JSONObject serializeUser(User user) {
		assert user != null : "Precondition failed: user != null";

		JSONObject result = new JSONObject();

		result.put(USER_NAME_KEY, new JSONString(user.getUsername()));
		result.put(FIRST_NAME_KEY, new JSONString(user.getFirstName()));
		result.put(LAST_NAME_KEY, new JSONString(user.getLastName()));

		result.put(USER_ROLES_KEY, serializeUserRolesList(user.getRoles()));

		if (user.hasEmailAddress()) {
			result.put(EMAIL_ADDRESS_KEY, new JSONString(user.getEmailAddress().asString()));
		}

		result.put(ACCEPTED_PRIVACY_POLICY_VERSION_KEY, new JSONNumber(user.getAcceptedPrivacyPolicyVersion()));

		return result;
	}

	private JSONArray serializeUserRolesList(List<UserRole> roles) {
		assert roles != null : "Precondition failed: roles != null";

		JSONArray result = new JSONArray();

		for (UserRole userRole : roles) {
			result.set(result.size(), new JSONString(userRole.name()));
		}

		return result;
	}

	private JSONObject serializeSignId(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		JSONObject result = new JSONObject();

		result.put(UPPER_ID_KEY, new JSONNumber(signId.getUpperIdPart()));
		result.put(LOWER_ID_KEY, new JSONString(signId.getLowerIdPart()));
		result.put(LANGUAGE_KEY, new JSONString(signId.getSignLocale().name()));
		result.put(SOURCE_ID_KEY, new JSONString(signId.getSignSource().name()));
		return result;
	}

	private SignItem deserializeSignItem(JSONObject signItemJsonObject) {
		assert signItemJsonObject.containsKey(ID_KEY) : "Precondition failed: signItemJsonObject.containsKey(ID_KEY)";
		assert signItemJsonObject
				.containsKey(WIDTH_KEY) : "Precondition failed: signItemJsonObject.containsKey(WIDTH_KEY)";

		SignId id = deserializeSignId(signItemJsonObject.get(ID_KEY).isObject());
		int width = (int) signItemJsonObject.get(WIDTH_KEY).isNumber().doubleValue();

		SignItem result = new SignItem(id, width);

		if (signItemJsonObject.containsKey(LOCAL_SIGN_KEY)) {
			result.setLocalSign(deserializeSign(signItemJsonObject.get(LOCAL_SIGN_KEY).isObject()));
		}

		return result;
	}

	private SimpleSign deserializeSign(JSONObject signJsonObject) {
		assert signJsonObject != null : "Precondition failed: signJsonObject != null";
		assert signJsonObject.containsKey(ID_KEY) : "Precondition failed: signJsonObject.containsKey(ID_KEY)";
		assert signJsonObject.containsKey(SYMBOLS_KEY) : "Precondition failed: signJsonObject.containsKey(SYMBOLS_KEY)";
		assert signJsonObject.containsKey(AUTHOR_KEY) : "Precondition failed: signJsonObject.containsKey(AUTHOR_KEY)";
		assert signJsonObject
				.containsKey(LANGUAGE_KEY) : "Precondition failed: signJsonObject.containsKey(LANGUAGE_KEY)";
		assert signJsonObject.containsKey(MDT_KEY) : "Precondition failed: signJsonObject.containsKey(MDT_KEY)";
		assert signJsonObject.containsKey(COMMENT_KEY) : "Precondition failed: signJsonObject.containsKey(COMMENT_KEY)";

		SignLocale language = SignLocale.valueOf(signJsonObject.get(LANGUAGE_KEY).isString().stringValue());
		SignId id = deserializeSignId(signJsonObject.get(ID_KEY).isObject());
		List<PositionedSymbol> symbols = deserializePositionedSymbolList(signJsonObject.get(SYMBOLS_KEY).isArray());
		List<HeadSymbol> headSymbols = deserializeHeadSymbolList(signJsonObject.get(HEAD_SYMBOLS_KEY).isArray());
		List<HeadSymbol> disarrangedHeadSymbols = deserializeHeadSymbolList(
				signJsonObject.get(DISARRANGED_HEAD_SYMBOLS_KEY).isArray());
		List<PositionedSymbol> handSymbols = deserializePositionedSymbolList(
				signJsonObject.get(HAND_SYMBOLS_KEY).isArray());
		User author = deserializeUser(signJsonObject.get(AUTHOR_KEY).isObject());
		Date modificationDate = new Date((long) signJsonObject.get(MDT_KEY).isNumber().doubleValue());
		String comment = signJsonObject.get(COMMENT_KEY).isString().stringValue();

		SimpleSign result = new SimpleSign(id, author, language, modificationDate, comment);

		for (PositionedSymbol positionedSymbol : symbols) {
			result.addSymbol(positionedSymbol);
		}

		for (HeadSymbol headSymbol : headSymbols) {
			result.addHeadSymbol(headSymbol);
		}

		for (HeadSymbol disarrangedHeadSymbol : disarrangedHeadSymbols) {
			result.addDisarrangedHeadSymbol(disarrangedHeadSymbol);
		}

		for (PositionedSymbol handSymbol : handSymbols) {
			result.addSymbol(handSymbol);
		}

		return result;
	}

	private List<HeadSymbol> deserializeHeadSymbolList(JSONArray headSymbolsArray) {
		assert headSymbolsArray != null : "Precondition failed: headSymbolsArray != null";

		List<HeadSymbol> result = new ArrayList<HeadSymbol>(headSymbolsArray.size());

		for (int index = 0, listSize = headSymbolsArray.size(); index < listSize; index++) {
			result.add(deserializeHeadSymbol(headSymbolsArray.get(index).isObject()));
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private HeadSymbol deserializeHeadSymbol(JSONObject headSymbolJsonObject) {
		assert headSymbolJsonObject != null : "Precondition failed: headSymbolJsonObject != null";

		assert headSymbolJsonObject.containsKey(X_KEY) : "Precondition failed: headSymbolJsonObject.containsKey(X_KEY)";
		assert headSymbolJsonObject.containsKey(Y_KEY) : "Precondition failed: headSymbolJsonObject.containsKey(Y_KEY)";
		assert headSymbolJsonObject.containsKey(Z_KEY) : "Precondition failed: headSymbolJsonObject.containsKey(Z_KEY)";

		List<PositionedSymbol> allSymbols = new ArrayList<PositionedSymbol>();
		// Parse MouthSymbol
		if (headSymbolJsonObject.containsKey(MOUTH_SYMBOL_KEY)) {
			JSONValue positionedMouthSymbol = headSymbolJsonObject.get(MOUTH_SYMBOL_KEY);
			allSymbols.add(deserializePositionedSymbol(positionedMouthSymbol.isObject()));
		}
		// Parse HeadPostureSymbol
		PositionedHeadPostureSymbol headPostureSymbol = PositionedHeadPostureSymbol.getStandardHeadPostureSymbol();
		if (headSymbolJsonObject.containsKey(HEAD_POSTURE_SYMBOL_KEY)) {
			JSONValue positionedHeadPostureSymbol = headSymbolJsonObject.get(HEAD_POSTURE_SYMBOL_KEY);
			headPostureSymbol = (PositionedHeadPostureSymbol) deserializePositionedSymbol(
					positionedHeadPostureSymbol.isObject());
			allSymbols.add(headPostureSymbol);
		}
		// Parse NoseSymbol
		if (headSymbolJsonObject.containsKey(NOSE_SYMBOL_KEY)) {
			JSONValue positionedNoseSymbol = headSymbolJsonObject.get(NOSE_SYMBOL_KEY);
			allSymbols.add(deserializePositionedSymbol(positionedNoseSymbol.isObject()));
		}
		// // Parse NeckSymbol
		if (headSymbolJsonObject.containsKey(NECK_SYMBOL_KEY)) {
			JSONValue positionedNeckSymbol = headSymbolJsonObject.get(NECK_SYMBOL_KEY);
			allSymbols.add(deserializePositionedSymbol(positionedNeckSymbol.isObject()));
		}
		// // Parse ExpressionSymbol
		if (headSymbolJsonObject.containsKey(EXPRESSION_SYMBOL_KEY)) {
			JSONValue positionedExpressionSymbol = headSymbolJsonObject.get(EXPRESSION_SYMBOL_KEY);
			allSymbols.add(deserializePositionedSymbol(positionedExpressionSymbol.isObject()));
		}
		// // Parse HairSymbol
		if (headSymbolJsonObject.containsKey(HAIR_SYMBOL_KEY)) {
			JSONValue positionedHairSymbol = headSymbolJsonObject.get(HAIR_SYMBOL_KEY);
			allSymbols.add(deserializePositionedSymbol(positionedHairSymbol.isObject()));
		}
		// Parse EyeSymbols
		if (headSymbolJsonObject.containsKey(EYE_SYMBOLS_KEY)) {
			JSONValue positionedEyeSymbols = headSymbolJsonObject.get(EYE_SYMBOLS_KEY);
			allSymbols.addAll(deserializePositionedSymbolList(positionedEyeSymbols.isArray()));
		}
		// Parse CheekSymbols
		if (headSymbolJsonObject.containsKey(CHEEK_SYMBOLS_KEY)) {
			JSONValue positionedCheekSymbols = headSymbolJsonObject.get(CHEEK_SYMBOLS_KEY);
			allSymbols.addAll(deserializePositionedSymbolList(positionedCheekSymbols.isArray()));
		}
		// Parse EarSymbols
		if (headSymbolJsonObject.containsKey(EAR_SYMBOLS_KEY)) {
			JSONValue positionedEarSymbols = headSymbolJsonObject.get(EAR_SYMBOLS_KEY);
			allSymbols.addAll(deserializePositionedSymbolList(positionedEarSymbols.isArray()));
		}
		// Parse BreathSymbols
		if (headSymbolJsonObject.containsKey(BREATH_SYMBOLS_KEY)) {
			JSONValue positionedBreathSymbols = headSymbolJsonObject.get(BREATH_SYMBOLS_KEY);
			allSymbols.addAll(deserializePositionedSymbolList(positionedBreathSymbols.isArray()));
		}
		// Parse JawSymbols
		if (headSymbolJsonObject.containsKey(JAW_SYMBOLS_KEY)) {
			JSONValue positionedJawSymbols = headSymbolJsonObject.get(JAW_SYMBOLS_KEY);
			allSymbols.addAll(deserializePositionedSymbolList(positionedJawSymbols.isArray()));
		}

		int x = (int) headSymbolJsonObject.get(X_KEY).isNumber().doubleValue();
		int y = (int) headSymbolJsonObject.get(Y_KEY).isNumber().doubleValue();
		int z = (int) headSymbolJsonObject.get(Z_KEY).isNumber().doubleValue();

		HeadSymbol result = positionedSymbolFactory.createHeadSymbol(headPostureSymbol, x, y, z,
				allSymbols.toArray(new PositionedSymbol[allSymbols.size()]));

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private List<PositionedSymbol> deserializePositionedSymbolList(JSONArray positionedSymbolsJsonArray) {
		assert positionedSymbolsJsonArray != null : "Precondition failed: positionedSymbolsJsonArray != null";

		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>(positionedSymbolsJsonArray.size());

		for (int i = 0; i < positionedSymbolsJsonArray.size(); i++) {
			result.add(deserializePositionedSymbol(positionedSymbolsJsonArray.get(i).isObject()));
		}

		return result;
	}

	private PositionedSymbol deserializePositionedSymbol(JSONObject positionedSymbolJsonObject) {
		assert positionedSymbolJsonObject != null : "Precondition failed: positionedSymbolJsonObject != null";
		assert positionedSymbolJsonObject
				.containsKey(SYMBOL_KEY) : "Precondition failed: positionedSymbolJsonObject.containsKey(SYMBOL_KEY)";
		assert positionedSymbolJsonObject
				.containsKey(X_KEY) : "Precondition failed: positionedSymbolJsonObject.containsKey(X_KEY)";
		assert positionedSymbolJsonObject
				.containsKey(Y_KEY) : "Precondition failed: positionedSymbolJsonObject.containsKey(Y_KEY)";
		assert positionedSymbolJsonObject
				.containsKey(Z_KEY) : "Precondition failed: positionedSymbolJsonObject.containsKey(Z_KEY)";

		PositionedSymbol positionedSymbol;
		Symbol symbol = deserializeSymbol(positionedSymbolJsonObject.get(SYMBOL_KEY).isObject());
		int x = (int) positionedSymbolJsonObject.get(X_KEY).isNumber().doubleValue();
		int y = (int) positionedSymbolJsonObject.get(Y_KEY).isNumber().doubleValue();
		int z = (int) positionedSymbolJsonObject.get(Z_KEY).isNumber().doubleValue();

		if (SymbolCategoryAnalyzer.isHeadSymbol(symbol)) {
			if (positionedSymbolJsonObject.containsKey(LOCATION_KEY)) {
				JSONValue locationValue = positionedSymbolJsonObject.get(LOCATION_KEY);
				Location location = deserializeEnum(locationValue.isString(), Location.class);
				positionedSymbol = positionedSymbolFactory.createPositionedSymbol(symbol, location, x, y, z);
			} else {
				positionedSymbol = positionedSymbolFactory.createPositionedSymbol(symbol, x, y, z);
			}
		} else {
			positionedSymbol = new PositionedSymbol(symbol, x, y, z);
		}

		return positionedSymbol;
	}

	private Symbol deserializeSymbol(JSONObject symbolJsonObject) {
		assert symbolJsonObject != null : "Precondition failed: symbolJsonObject != null";
		assert symbolJsonObject.containsKey(FILL_KEY) : "Precondition failed: symbolJsonObject.containsKey(FILL_KEY)";
		assert symbolJsonObject
				.containsKey(CATEGORY_KEY) : "Precondition failed: symbolJsonObject.containsKey(CATEGORY_KEY)";
		assert symbolJsonObject.containsKey(GROUP_KEY) : "Precondition failed: symbolJsonObject.containsKey(GROUP_KEY)";
		assert symbolJsonObject
				.containsKey(VARIATION_KEY) : "Precondition failed: symbolJsonObject.containsKey(VARIATION_KEY)";
		assert symbolJsonObject
				.containsKey(SYMBOL_KEY) : "Precondition failed: symbolJsonObject.containsKey(SYMBOL_KEY)";
		assert symbolJsonObject
				.containsKey(ROTATION_KEY) : "Precondition failed: symbolJsonObject.containsKey(ROTATION_KEY)";
		assert symbolJsonObject.containsKey(WIDTH_KEY) : "Precondition failed: symbolJsonObject.containsKey(WIDTH_KEY)";
		assert symbolJsonObject
				.containsKey(HEIGHT_KEY) : "Precondition failed: symbolJsonObject.containsKey(HEIGHT_KEY)";

		int fill = (int) symbolJsonObject.get(FILL_KEY).isNumber().doubleValue();
		int category = (int) symbolJsonObject.get(CATEGORY_KEY).isNumber().doubleValue();
		int group = (int) symbolJsonObject.get(GROUP_KEY).isNumber().doubleValue();
		int variation = (int) symbolJsonObject.get(VARIATION_KEY).isNumber().doubleValue();
		int symbol = (int) symbolJsonObject.get(SYMBOL_KEY).isNumber().doubleValue();
		int rotation = (int) symbolJsonObject.get(ROTATION_KEY).isNumber().doubleValue();
		int width = (int) symbolJsonObject.get(WIDTH_KEY).isNumber().doubleValue();
		int height = (int) symbolJsonObject.get(HEIGHT_KEY).isNumber().doubleValue();

		return new Symbol(category, group, symbol, variation, fill, rotation, width, height);
	}

	private User deserializeUser(JSONObject userJsonObject) {
		assert userJsonObject != null : "Precondition failed: userJsonObject != null";
		assert userJsonObject
				.containsKey(USER_NAME_KEY) : "Precondition failed: userJsonObject.containsKey(USER_NAME_KEY)";
		assert userJsonObject
				.containsKey(FIRST_NAME_KEY) : "Precondition failed: userJsonObject.containsKey(FIRST_NAME_KEY)";
		assert userJsonObject
				.containsKey(LAST_NAME_KEY) : "Precondition failed: userJsonObject.containsKey(LAST_NAME_KEY)";
		assert userJsonObject
				.containsKey(USER_ROLES_KEY) : "Precondition failed: userJsonObject.containsKey(USER_ROLES_KEY)";
		assert userJsonObject.containsKey(
				ACCEPTED_PRIVACY_POLICY_VERSION_KEY) : "Precondition failed: userJsonObject.containsKey(ACCEPTED_PRIVACY_POLICY_VERSION_KEY)";

		String userName = userJsonObject.get(USER_NAME_KEY).isString().stringValue();
		String firstName = userJsonObject.get(FIRST_NAME_KEY).isString().stringValue();
		String lastName = userJsonObject.get(LAST_NAME_KEY).isString().stringValue();
		List<UserRole> userRoles = deserializeUserRoles(userJsonObject.get(USER_ROLES_KEY).isArray());

		EmailAddress emailAddress = null;
		if (userJsonObject.containsKey(EMAIL_ADDRESS_KEY)) {
			emailAddress = new EmailAddress(userJsonObject.get(EMAIL_ADDRESS_KEY).isString().stringValue());
		}

		int acceptedPrivacyPolicyVersionNumber = new Double(
				userJsonObject.get(ACCEPTED_PRIVACY_POLICY_VERSION_KEY).isNumber().doubleValue()).intValue();

		return new User(userName, firstName, lastName, emailAddress, userRoles, acceptedPrivacyPolicyVersionNumber);
	}

	private List<UserRole> deserializeUserRoles(JSONArray array) {
		assert array != null : "Precondition failed: array != null";

		List<UserRole> result = new ArrayList<UserRole>();

		for (int i = 0; i < array.size(); i++) {
			JSONValue jsonValue = array.get(i);

			if (jsonValue.isNull() == null) {
				result.add(UserRole.valueOf(jsonValue.isString().stringValue()));
			}
		}

		return result;
	}

	private SignId deserializeSignId(JSONObject signIdJsonObject) {
		assert signIdJsonObject != null : "Precondition failed: signIdJsonObject != null";
		assert signIdJsonObject
				.containsKey(UPPER_ID_KEY) : "Precondition failed: signIdJsonObject.containsKey(UPPER_ID_KEY)";
		assert signIdJsonObject
				.containsKey(LOWER_ID_KEY) : "Precondition failed: signIdJsonObject.containsKey(LOWER_ID_KEY)";
		assert signIdJsonObject
				.containsKey(SOURCE_ID_KEY) : "Precondition failed: signIdJsonObject.containsKey(SOURCE_ID_KEY)";
		assert signIdJsonObject
				.containsKey(LANGUAGE_KEY) : "Precondition failed: signIdJsonObject.containsKey(LANGUAGE_KEY)";

		long upperId = (long) signIdJsonObject.get(UPPER_ID_KEY).isNumber().doubleValue();
		String lowerId = signIdJsonObject.get(LOWER_ID_KEY).isString().stringValue();
		SignLocale language = SignLocale.valueOf(signIdJsonObject.get(LANGUAGE_KEY).isString().stringValue());
		SignSource source = SignSource.valueOf(signIdJsonObject.get(SOURCE_ID_KEY).isString().stringValue());

		return new SignId(upperId, lowerId, language, source);
	}
}
