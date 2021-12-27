package de.signWritingEditor.server.persistence;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.VideoToken;

public class DocumentJSONConverter {

	private GsonBuilder gsonbuilder;
	private UserDb userDb;
	private SignDB signDB;
	private TokenFactory tokenFactory;

	public DocumentJSONConverter(UserDb userDb, SignDB signDB, TokenFactory tokenFactory) {
		this.userDb = userDb;
		this.signDB = signDB;
		this.tokenFactory = tokenFactory;

		gsonbuilder = new GsonBuilder();

		gsonbuilder.registerTypeAdapter(Id.class, new JsonSerializer<Id>() {
			@Override
			public JsonElement serialize(Id id, Type type, JsonSerializationContext context) {
				return new JsonPrimitive(id.toString());
			}
		});

		gsonbuilder.registerTypeAdapter(Id.class, new JsonDeserializer<Id>() {
			@Override
			public Id deserialize(JsonElement element, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				return new Id(element.getAsString());
			}
		});

		gsonbuilder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
			@Override
			public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
				return new JsonPrimitive(date.getTime());
			}
		});

		gsonbuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			@Override
			public Date deserialize(JsonElement element, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				return new Date(element.getAsLong());
			}
		});

		gsonbuilder.registerTypeAdapter(FileTitle.class, new JsonSerializer<FileTitle>() {
			@Override
			public JsonElement serialize(FileTitle fileTitle, Type type, JsonSerializationContext context) {
				return new JsonPrimitive(fileTitle.getTitleString());
			}
		});

		gsonbuilder.registerTypeAdapter(FileTitle.class, new JsonDeserializer<FileTitle>() {
			@Override
			public FileTitle deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				return new FileTitle(jsonElement.getAsString());
			}
		});

		gsonbuilder.registerTypeAdapter(PageFormat.class, new JsonSerializer<PageFormat>() {
			@Override
			public JsonElement serialize(PageFormat pageFormat, Type type, JsonSerializationContext context) {
				return new JsonPrimitive(pageFormat.getName());
			}
		});

		gsonbuilder.registerTypeAdapter(PageFormat.class, new JsonDeserializer<PageFormat>() {
			@Override
			public PageFormat deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				return PageFormat.getDefaultPageDimension(jsonElement.getAsString());
			}
		});

		gsonbuilder.registerTypeAdapter(Token.class, new JsonSerializer<Token>() {
			@Override
			public JsonElement serialize(Token token, Type type, JsonSerializationContext context) {
				Class<?> tokenClass = token.getClass();
				JsonObject jsonObject = context.serialize(token, tokenClass).getAsJsonObject();
				jsonObject.addProperty("Token", tokenClass.getSimpleName());
				return jsonObject;
			}
		});

		gsonbuilder.registerTypeAdapter(Token.class, new JsonDeserializer<Token>() {
			@Override
			public Token deserialize(JsonElement json, Type Type, JsonDeserializationContext context)
					throws JsonParseException {
				JsonObject jsonObject = json.getAsJsonObject();

				String tokenString = jsonObject.get("Token").getAsString();
				switch (tokenString) {
				case "SignItemToken":
					return context.deserialize(json, SignItemToken.class);

				case "FreeTextToken":
					return context.deserialize(json, FreeTextToken.class);

				case "ImageToken":
					return context.deserialize(json, ImageToken.class);

				case "VideoToken":
					return context.deserialize(json, VideoToken.class);

				case "FrameToken":
					return context.deserialize(json, FrameToken.class);

				default:
					throw new RuntimeException("unsupported token: " + json);
				}
			}
		});

		gsonbuilder.registerTypeAdapter(ReadOnlyTextbasedTokenStyle.class,
				new JsonSerializer<ReadOnlyTextbasedTokenStyle>() {
					@Override
					public JsonElement serialize(ReadOnlyTextbasedTokenStyle style, Type type,
							JsonSerializationContext context) {
						return context.serialize(style, TextbasedTokenStyle.class);
					}
				});

		gsonbuilder.registerTypeAdapter(ReadOnlyTextbasedTokenStyle.class,
				new JsonDeserializer<ReadOnlyTextbasedTokenStyle>() {
					@Override
					public ReadOnlyTextbasedTokenStyle deserialize(JsonElement json, Type Type,
							JsonDeserializationContext context) throws JsonParseException {
						return context.deserialize(json, TextbasedTokenStyle.class);
					}
				});

		gsonbuilder.registerTypeAdapter(SignItemToken.class, new JsonSerializer<SignItemToken>() {
			@Override
			public JsonElement serialize(SignItemToken token, Type type, JsonSerializationContext context) {
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("Token", "SignItemToken");

				jsonObject.add("id", context.serialize(token.getId()));
				jsonObject.add("style", context.serialize(token.getStyle()));
				jsonObject.add("backgroundColor", context.serialize(token.getBackgroundColor()));
				jsonObject.addProperty("locale", token.getLocale().name());

				jsonObject.add("signItem", context.serialize(token.getSignItem()));

				jsonObject.addProperty("signVisibility", token.isSignVisibility());
				jsonObject.addProperty("word", token.getText());
				jsonObject.addProperty("searchWordVisibility", token.isSearchWordVisibility());
				jsonObject.addProperty("isLayoutLocked", token.isLayoutLocked());
				jsonObject.addProperty("isContentLocked", token.isContentLocked());

				return jsonObject;
			}
		});

		gsonbuilder.registerTypeAdapter(SignItemToken.class, new JsonDeserializer<SignItemToken>() {
			@Override
			public SignItemToken deserialize(JsonElement json, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				JsonObject jsonObject = json.getAsJsonObject();

				Id id = context.deserialize(jsonObject.get("id"), Id.class);
				TextbasedTokenStyle textBaseStyle = context.deserialize(jsonObject.get("style"),
						TextbasedTokenStyle.class);
				Color backgroundColor = context.deserialize(jsonObject.get("backgroundColor"), Color.class);
				String locale = jsonObject.get("locale").getAsString();
				String word = jsonObject.get("word").getAsString();

				SignItem signItem = context.deserialize(jsonObject.get("signItem"), SignItem.class);
				boolean signVisibility = true;

				boolean isLayoutLocked = getAsBoolean(jsonObject, "isLayoutLocked", false);
				boolean isContentLocked = getAsBoolean(jsonObject, "isContentLocked", false);

				boolean searchWordVisibility = getAsBoolean(jsonObject, "searchWordVisibility", true);

				final SignItemToken signItemToken = DocumentJSONConverter.this.tokenFactory.createSignItemToken(word,
						signItem, id, textBaseStyle, backgroundColor, SignLocale.valueOf(locale), isLayoutLocked,
						isContentLocked);
				signItemToken.setSignVisibility(signVisibility);
				signItemToken.setSearchWordVisibility(searchWordVisibility);
				return signItemToken;
			}
		});

		gsonbuilder.registerTypeAdapter(SignItem.class, new JsonSerializer<SignItem>() {
			@Override
			public JsonElement serialize(SignItem token, Type type, JsonSerializationContext context) {
				JsonObject signItemJSON = new JsonObject();
				signItemJSON.add("signId", context.serialize(token.getSignId()));
				signItemJSON.addProperty("signWidth", token.getSignWidth());
				return signItemJSON;
			}
		});

		gsonbuilder.registerTypeAdapter(SignItem.class, new JsonDeserializer<SignItem>() {
			@Override
			public SignItem deserialize(JsonElement json, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				SignItem result = null;
				if (!json.isJsonNull()) {
					JsonObject jsonObject = json.getAsJsonObject();
					SignId signId = context.deserialize(jsonObject.get("signId"), SignId.class);

					if (DocumentJSONConverter.this.signDB.existsItem(signId)) {
						SimpleSign sign = DocumentJSONConverter.this.signDB.getSign(signId);
						result = new SignItem(sign.getSignId(), sign.getWidth());
					} else {
						// Lokale Gebärden werden direkt im Anschluss an das
						// Json-Parsen von der Methode
						// loadSignsFromLocalDictionary geladen.
						int signWidth = jsonObject.get("signWidth").getAsInt();
						result = new SignItem(signId, signWidth);
					}
				}
				return result;
			}
		});

		gsonbuilder.registerTypeAdapter(Color.class, new JsonSerializer<Color>() {
			@Override
			public JsonElement serialize(Color color, Type type, JsonSerializationContext context) {
				return new JsonPrimitive(color.getCssValue());
			}
		});

		gsonbuilder.registerTypeAdapter(Color.class, new JsonDeserializer<Color>() {
			@Override
			public Color deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				return Color.makeFromCssString(jsonElement.getAsString());
			}
		});

		gsonbuilder.registerTypeAdapter(User.class, new JsonSerializer<User>() {
			@Override
			public JsonElement serialize(User user, Type type, JsonSerializationContext context) {
				return new JsonPrimitive(user.getUsername());
			}
		});

		gsonbuilder.registerTypeAdapter(User.class, new JsonDeserializer<User>() {
			@Override
			public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				String username = jsonElement.getAsString();
				User user = DocumentJSONConverter.this.userDb.getUser(username);
				if (user == null) {
					user = User.getUnknownUser();
				}
				return user;
			}
		});
	}

	public String toJson(Document document) {
		return gsonbuilder.create().toJson(document, Document.class);
	}

	public Document fromJson(String jsonString, User user) {
		assert jsonString != null : "Precondition failed: jsonString != null";

		Gson gson = gsonbuilder.create();
		Document document = gson.fromJson(jsonString, Document.class);
		document.setAuthor(user);

		return loadSignsFromLocalDictionary(document);
	}

	private boolean getAsBoolean(JsonObject jsonObject, String key, boolean defaultValue) {
		return jsonObject.has(key) ? jsonObject.get(key).getAsBoolean() : defaultValue;
	}

	/**
	 * Signs from the local dictionary need to be loaded eagerly, because they
	 * cannot possibly be found inside signDB.findSigns.
	 */
	private Document loadSignsFromLocalDictionary(Document doc) {
		LocalDictionary localDictionaryOrNull = doc.getLocalDictionary();
		if (localDictionaryOrNull == null)
			return doc;

		int count = doc.getSectionCount();

		for (int i = 0; i < count; i++) {
			Section section = doc.getSection(i);
			for (Paragraph paragraph : section.getParagraphs()) {
				for (Token token : paragraph.getTokens()) {
					if (token instanceof SignItemToken) {
						SignItemToken signItemToken = (SignItemToken) token;
						SignItem signItem = signItemToken.getSignItem();
						if (signItem != null && localDictionaryOrNull.contains(signItem.getSignId())) {
							signItem = new SignItem(localDictionaryOrNull.getSign(signItem.getSignId()));
							signItemToken.setSignItem(signItem);
						}
					}
				}
			}
		}
		return doc;
	}
}
