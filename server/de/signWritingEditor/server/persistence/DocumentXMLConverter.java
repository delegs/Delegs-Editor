package de.signWritingEditor.server.persistence;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mchange.util.AssertException;

import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.FingerAlphabet;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.DateFormToken;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FormToken;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.Locatable;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedBreathSymbol;
import de.signWritingEditor.shared.model.material.PositionedCheekSymbol;
import de.signWritingEditor.shared.model.material.PositionedEarsSymbol;
import de.signWritingEditor.shared.model.material.PositionedEyeSymbol;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedJawSymbol;
import de.signWritingEditor.shared.model.material.PositionedMouthSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.SymbolToHeadSymbolConverter;
import de.signWritingEditor.shared.model.material.TagToken;
import de.signWritingEditor.shared.model.material.TextbasedToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.UrlFormToken;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.VideoToken;

public class DocumentXMLConverter {

	private static final Logger LOG = Logger.getLogger(DocumentXMLConverter.class);

	private static final String PARAGRAPH_WIDTH = "paragraphWidth";
	private static final String PARAGRAPH_IS_AUTOMATIC_RESIZE_ACTIVE = "automaticResize";
	private static final String PARAGRAPH_POSITION_Y = "paragraphPositionY";
	private static final String PARAGRAPH_POSITION_X = "paragraphPositionX";
	private static final String SECTION_FREE_POSITIONABLE = "collage";
	private static final String HEAD_SYMBOLS_ELEMENT = "headSymbols";
	private static final String HEAD_SYMBOLS_DISARRANGED_ELEMENT = "disarrangedHeadSymbols";
	private static final String HEAD_SYMBOL_ELEMENT = "headSymbol";
	private static final String HEAD_SYMBOL_EYES_ATTRIBUTE = "eyes";
	private static final String HEAD_SYMBOL_LEFT_EYES_ATTRIBUTE = "leftEyes";
	private static final String HEAD_SYMBOL_RIGHT_EYES_ATTRIBUTE = "rightEyes";
	private static final String HEAD_SYMBOL_MOUTH_ATTRIBUTE = "mouth";
	private static final String HEAD_SYMBOL_HEAD_POSTURE_ATTRIBUTE = "headPosture";
	private static final String HEAD_SYMBOL_LEFT_CHEEK_ATTRIBUTE = "leftCheek";
	private static final String HEAD_SYMBOL_RIGHT_CHEEK_ATTRIBUTE = "rightCheek";
	private static final String HEAD_SYMBOL_CHEEKS_ATTRIBUTE = "cheeks";
	private static final String HEAD_SYMBOL_NOSE_ATTRIBUTE = "nose";
	private static final String HEAD_SYMBOL_EARS_ATTRIBUTE = "ears";
	private static final String HEAD_SYMBOL_LEFT_EAR_ATTRIBUTE = "leftEar";
	private static final String HEAD_SYMBOL_RIGHT_EAR_ATTRIBUTE = "rightEar";
	private static final String HEAD_SYMBOL_BREATH_ATTRIBUTE = "breath";
	private static final String HEAD_SYMBOL_LEFT_BREATH_ATTRIBUTE = "leftBreath";
	private static final String HEAD_SYMBOL_RIGHT_BREATH_ATTRIBUTE = "rightBreath";
	private static final String HEAD_SYMBOL_JAW_ATTRIBUTE = "jaw";
	private static final String HEAD_SYMBOL_NECK_ATTRIBUTE = "neck";
	private static final String HEAD_SYMBOL_EXPRESSION_ATTRIBUTE = "expression";
	private static final String HEAD_SYMBOL_HAIR_ATTRIBUTE = "hair";
	private static final String HEAD_SYMBOL_FREE_POSITIONABLE_ATTRIBUTE = "freePositionableHeadSymbol";
	private static final String HAND_SYMBOLS_ELEMENT = "handSymbols";
	private static final String FINGER_ALPHABET_SYMBOLS_ELEMENT = "fingerAlphabetSymbols";
	private static final String VISEMES = "visemes";
	private static final String SYMBOLS = "symbols";
	private static final String DICTIONARY = "dictionary";
	private static final String DICTIONARY_ENTRY = "entry";
	private static final String DICTIONARY_ENTRY_ATTRIBUTE_WORD = "word";
	private static final String PARAGRAPH_ID = "id";
	private static final String PARAGRAPH_Z_INDEX = "zindex";
	private static final String DOCUMENT = "document";
	private static final String DOCUMENT_TITLE = "name";
	private static final String GLOSS_WRITING_ACTIVE = "isGlossWritingActive";
	private static final String AUTOMATIC_FREE_TEXT_LINE_ENABLED = "automaticFreeTextLineEnabled";
	private static final String SEARCH_WORDS_VISIBLE = "searchWordsVisible";
	private static final String SIGNS_VISIBLE = "signsVisible";
	private static final String FREETEXT_VISIBLE = "freeTextVisible";
	private static final String FREETEXT = "freetext";
	private static final String SIGN_MEANING = "meaning";
	private static final String SIGN_COMMENT = "comment";
	private static final String SIGN_REGION = "region";
	private static final String SIGN_AUTHOR = "owner";
	private static final String SIGN_MDT = "mdt";
	private static final String SIGN = "sign";
	private static final String SIGN_ITEM = "signItem";
	private static final String ISWA_ID = PARAGRAPH_ID;
	private static final String SYMBOL_Z = "z";
	private static final String SYMBOL_Y = "y";
	private static final String SYMBOL_X = "x";
	private static final String POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_BLACK = "positionedSymbolColorCodeForFormerBlack";
	private static final String POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_WHITE = "positionedSymbolColorCodeForFormerWhite";
	private static final String LOCATION = "location";
	private static final String PARAGRAPH = "paragraph";
	private static final String SECTION = "section";
	private static final String TOKEN = "token";
	private static final String LOCKEDLAYOUT = "lockedLayout";
	private static final String LOCKEDCONTENT = "lockedContent";

	private static final String TOKEN_TYPE = "tokenType";
	private static final String TOKEN_BACKGROUND_COLOR = "backgroundColor";

	@Deprecated
	private static final String TEXTBASED_TOKEN_VALUE = "value";
	private static final String TEXTBASED_TOKEN_TEXT = "freeTextTokenText";
	private static final String TEXTBASED_TOKEN_TEXT_BOX_COLOR = "textBasedTokenTextBoxColor";
	private static final String TEXTBASED_TOKEN_FONT_SIZE = "tokenFontSize";
	private static final String TEXTBASED_TOKEN_FONT_STYLE = "tokenFontStyle";
	private static final String TEXTBASED_TOKEN_FONT_WEIGHT = "tokenFontWeight";
	private static final String TEXTBASED_TOKEN_FONT_NAME = "tokenFontName";
	private static final String TEXTBASED_TOKEN_FONT_COLOR = "tokenFontColor";

	private static final String FREE_TEXT_TOKEN = "freeTextToken";
	private static final String FREE_TEXT_TOKEN_HAS_FIXED_WIDTH = "freeTextTokenHasFixedWidth";
	private static final String FREE_TEXT_TOKEN_WIDTH = "freeTextTokenMaxWidth";
	private static final String FREE_TEXT_TOKEN_IS_LINE = "freeTextTokenIsLine";

	private static final String SIGN_ITEM_TOKEN = "signItemToken";
	private static final String SIGN_ITEM_TOKEN_SIGN_LOCALE = "signItemSignLocale";

	private static final String TOKEN_ID = PARAGRAPH_ID;
	private static final String UNKNOWN = "unknown";
	private static final String SIGN_ID = PARAGRAPH_ID;
	private static final String SIGN_UPPER_ID = "upperId";
	private static final String SIGN_LOWER_ID = "lowerId";
	private static final String SIGN_SOURCE = "source";
	private static final String SIGN_WIDTH = "width";
	private static final String PAGE_DIMENSION = "pageDimension";
	private static final String POSITIONED_SYMBOL = "posSymbol";

	private static final String DOCUMENTVERSION = "documentVersion";
	public static final String TEMPLATE_VERSION = "templateVersion";
	private static final String TEMPLATE_VALIDITY = "templateValidity";
	private static final String FREE_POSITIONABLE_PAGE_POSITIONING_GRID_VISIBILITY = "collagePositioningGridVisibility";
	private static final String FREE_TEXT_TOKEN_VISIBILITY = "freeTextTokenVisibility";
	private static final String FRAME_TOKEN_COLOR = "frameTokenColor";
	private static final String FRAME_TOKEN_BORDER_WIDTH = "frameTokenBorderWidth";
	private static final String FRAME_TOKEN_WIDTH = "frameTokenWidth";
	private static final String FRAME_TOKEN_HEIGHT = "frameTokenHeight";
	private static final String FRAME_TOKEN = "frameToken";
	private static final String VIDEO_TOKEN = "videoToken";
	private static final String VIDEO_TOKEN_URL = "videoTokenUrl";
	private static final String VIDEO_TOKEN_COLOR = "videoTokenColor";
	private static final String VIDEO_TOKEN_WIDTH = "videoTokenWidth";
	private static final String VIDEO_TOKEN_HEIGHT = "videoTokenHeight";
	private static final String VIDEO_TOKEN_URL_VISIBILITY = "videoTokenUrlVisible";
	private static final String IMAGE_TOKEN = "imageToken";
	private static final String IMAGE_TOKEN_URL = "imageTokenUrl";
	private static final String IMAGE_TOKEN_COLOR = "imageTokenColor";
	private static final String IMAGE_TOKEN_WIDTH = "imageTokenWidth";
	private static final String IMAGE_TOKEN_HEIGHT = "imageTokenHeight";
	private static final String FINGER_ALPHABET_SYMBOL_ELEMENT = "fingerAlphabetSymbolElement";
	private static final String FINGER_ALPHABET_SYMBOL = "fingerAlphabet";
	private static final String FORM_TOKEN = "formToken";
	private static final String FORM_TOKEN_INPUT = "formTokenInput";
	private static final String FORM_TOKEN_DESCRIPTION = "formTokenDescription";
	private static final String FORM_TOKEN_CONTENT_EXPLANATION = "formTokenContentExplanation";
	private static final String FORM_TOKEN_ID = PARAGRAPH_ID;
	private static final String FORM_TOKEN_DESCRIPTION_WIDTH = "formTokenDescriptionWidth";
	private static final String FORM_TOKEN_INPUT_WIDTH = "formTokenInputWidth";

	private static final String TAG_TOKEN = "tagToken";
	private static final String TAG_TOKEN_SUGGESTIONS = "tagTokenSuggestions";
	private static final String TAG_TOKEN_SELECTED_TAGS = "tagTokenSelectedTags";
	private static final String TAG_TOKEN_DESCRIPTION = "tagTokenDescription";
	private static final String TAG_TOKEN_HEIGHT = "tagTokenHeight";
	private static final String TAG_TOKEN_DESCRIPTION_WIDTH = "tagTokenDescriptionWidth";
	private static final String TAG_TOKEN_INPUT_WIDTH = "tagTokenInputWidth";

	private static final String URL_FORM_TOKEN = "urlFormToken";
	private static final String FORM_TOKEN_PATTERN = "pattern";
	private static final String DATE_FORM_TOKEN = "dateFormToken";

	private static final String TEMPLATE_NAME = "templateName";

	private final UserDb authorDB;
	private final SignDB signDB;
	private final SymbolFactory symbolFactory;
	private TokenFactory tokenFactory;
	private IdFactory idFactory;

	private Set<SignItem> allReadSignItems;
	private PositionedSymbolFactory positionedSymbolFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	private float documentVersion;
	private float templateVersion;

	public DocumentXMLConverter(UserDb authorDB, SignDB signDB, SymbolFactory symbolFactory,
			TextbasedTokenStyleFactory textbasedTokenStyleFactory, PositionedSymbolFactory positionedSymbolFactory,
			long seed) {
		assert authorDB != null : "authorDB != null";
		assert signDB != null : "Precondition failed: signDB != null";
		assert symbolFactory != null : "symbolFactory != null";
		assert textbasedTokenStyleFactory != null : "Precondition failed:  textbasedTokenStyleFactory != null";
		assert positionedSymbolFactory != null : "Precondition failed: positionedSymbolFactory != null";
		this.authorDB = authorDB;
		this.signDB = signDB;
		this.symbolFactory = symbolFactory;
		this.textbasedTokenStyleFactory = textbasedTokenStyleFactory;
		this.positionedSymbolFactory = positionedSymbolFactory;
		idFactory = new IdFactory(seed);
		tokenFactory = new TokenFactory(idFactory);
	}

	/**
	 * Creates a SignWritingDocument object from the given XML String. The XML
	 * String is expected to be valid.
	 * 
	 * @param string The XML String
	 * 
	 * @require string != null
	 */
	@SuppressWarnings("unchecked")
	public Document fromXML(String string, User documentAuthor) throws AssertException, AssertionError {
		assert string != null : "string != null";
		assert documentAuthor != null : "Precondition failed: documentAuthor != null";

		this.allReadSignItems = new HashSet<>();

		SAXBuilder builder = new SAXBuilder();

		Document result = null;

		try {
			org.jdom.Document doc = builder.build(new StringReader(string));
			Element root = doc.getRootElement();

			SignLocale language = SignLocale.valueOf(root.getAttributeValue(SIGN_REGION));

			String pageDimensionName = root.getAttributeValue(PAGE_DIMENSION);
			if (pageDimensionName == null || pageDimensionName.equals("")) {
				pageDimensionName = PageFormat.A4_PORTRAIT.getName();
			}

			String documentTitleString = root.getAttributeValue(DOCUMENT_TITLE);

			PageFormat defaultPageDimension = PageFormat.getDefaultPageDimension(pageDimensionName);
			if (defaultPageDimension == null) {
				defaultPageDimension = PageFormat.A4_PORTRAIT;
				LOG.warn("The page dimension of document " + documentTitleString + " does not exist: "
						+ pageDimensionName);
			}

			boolean isGlossWritingActive = Boolean.parseBoolean(root.getAttributeValue(GLOSS_WRITING_ACTIVE));

			boolean automaticFreeTextLineEnabled = Boolean.parseBoolean(root.getAttributeValue(AUTOMATIC_FREE_TEXT_LINE_ENABLED));

			documentVersion = 0f;
			Attribute documentVersionAttribute = root.getAttribute(DOCUMENTVERSION);
			if (documentVersionAttribute != null) {
				documentVersion = Float.parseFloat(documentVersionAttribute.getValue());
			}

			templateVersion = 0f;
			Attribute templateVersionAttribute = root.getAttribute(TEMPLATE_VERSION);
			if (templateVersionAttribute != null) {
				templateVersion = Float.parseFloat(templateVersionAttribute.getValue());
			}

			String templateName = "";
			Attribute templateNameAttribute = root.getAttribute(TEMPLATE_NAME);
			if (templateNameAttribute != null) {
				templateName = templateNameAttribute.getValue();
			}

			Document document = new Document(documentAuthor, language, new FileTitle(documentTitleString.trim()),
					defaultPageDimension);
			document.setGlossWritingActive(isGlossWritingActive);
			document.setAutomaticFreeTextLineEnabled(automaticFreeTextLineEnabled);

			if (documentVersion < 1.2f) {
				document.setCollageGridVisibility(true);
			} else {
				Attribute documentGridVisibilityAttriubute = root
						.getAttribute(FREE_POSITIONABLE_PAGE_POSITIONING_GRID_VISIBILITY);
				document.setCollageGridVisibility(documentGridVisibilityAttriubute.getBooleanValue());
			}

			// read local dictionary if local signs exist
			LocalDictionary localDictionary = null;
			Element dictionaryElement = root.getChild(DICTIONARY);
			if (dictionaryElement != null) {
				localDictionary = readLocalDictionaryElement(dictionaryElement, language);
				document.setLocalDictionary(localDictionary);
			}

			List<Element> sectionElements = root.getChildren(SECTION);
			boolean isCollage = false;
			for (Element sectionElement : sectionElements) {
				if (documentVersion < 1f) {
					convertSectionFromUnversionedDocument(sectionElement, localDictionary, language);
				}
				if (documentVersion < 1.1f) {
					sectionElement.setAttribute(SECTION_FREE_POSITIONABLE, Boolean.toString(false));
					for (Element paragraphElement : (List<Element>) sectionElement.getChildren(PARAGRAPH)) {
						paragraphElement.setAttribute(PARAGRAPH_POSITION_X, "0");
						paragraphElement.setAttribute(PARAGRAPH_POSITION_Y, "0");
						paragraphElement.setAttribute(PARAGRAPH_WIDTH, "0");
						paragraphElement.setAttribute(PARAGRAPH_IS_AUTOMATIC_RESIZE_ACTIVE, String.valueOf(false));
						paragraphElement.setAttribute(PARAGRAPH_Z_INDEX, "0");
						List<Element> tokens = paragraphElement.getChildren(TOKEN);
						for (Element tokenElement : tokens) {
							String value = tokenElement.getAttribute(TOKEN_TYPE).getValue();
							if (FREE_TEXT_TOKEN.equals(value)) {
								int width = tokenElement.getAttribute(FREE_TEXT_TOKEN_WIDTH).getIntValue();
								// 15 is slider width in version 1.1
								width -= 15;
								tokenElement.removeAttribute(FREE_TEXT_TOKEN_WIDTH);
								tokenElement.setAttribute(FREE_TEXT_TOKEN_WIDTH, Integer.toString(width));
							}
						}
					}
				}
				if (documentVersion == 1.1f) {
					Attribute attribute = sectionElement.getAttribute("freePositionableSection");
					isCollage = (attribute != null) && attribute.getBooleanValue();
					sectionElement.setAttribute(SECTION_FREE_POSITIONABLE, Boolean.toString(isCollage));
				}

				document.addSection(parseSection(sectionElement, localDictionary, language, documentVersion));
			}

			if (!allReadSignItems.isEmpty()) {
				signDB.loadSignItemWidth(allReadSignItems, document.getSignLocale());
			}

			if (documentVersion >= 1.4f) {
				document.lockLayout(Boolean.parseBoolean(root.getAttribute(LOCKEDLAYOUT).getValue()));
				document.lockContent(Boolean.parseBoolean(root.getAttribute(LOCKEDCONTENT).getValue()));
			}

			if (documentVersion >= 1.6f) {
				if (templateVersion != 0f) {
					document.setTemplateVersion(templateVersion);
					document.setTemplateName(templateName);
				}
			}

			// End try block with assignment to make sure result is either null
			// or valid
			result = document;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private Section parseSection(Element sectionElement, LocalDictionary localDictionaryOrNull, SignLocale language,
			float DocumentVersion) {

		Section section = new Section();
		boolean isCollage = Boolean.parseBoolean(sectionElement.getAttribute(SECTION_FREE_POSITIONABLE).getValue());
		section.setIsCollage(isCollage, idFactory.createId());

		@SuppressWarnings("unchecked")
		List<Element> paragraphElements = sectionElement.getChildren(PARAGRAPH);

		for (Element paragraphElement : paragraphElements) {
			Paragraph paragraph = readParagraphElement(paragraphElement, localDictionaryOrNull, language,
					DocumentVersion);
			section.addParagraph(paragraph);
		}

		if (DocumentVersion >= 1.4f) {
			section.lockLayout(Boolean.parseBoolean(sectionElement.getAttribute(LOCKEDLAYOUT).getValue()));
			section.lockContent(Boolean.parseBoolean(sectionElement.getAttribute(LOCKEDCONTENT).getValue()));
		}

		return section;
	}

	public String toXML(Document document) {
		assert document != null : "Precondition failed: document != null";

		Element documentElement = new Element(DOCUMENT);

		documentElement.setAttribute(DOCUMENT_TITLE, document.getDocumentTitle().getTitleString());
		documentElement.setAttribute(SIGN_REGION, document.getSignLocale().name());
		documentElement.setAttribute(PAGE_DIMENSION, document.getPageFormat().getName());
		documentElement.setAttribute(DOCUMENTVERSION, Document.CURRENT_DOCUMENT_VERSION.toString());
		if (document.getTemplateVersion() > 0.0f) {
			documentElement.setAttribute(TEMPLATE_VERSION, document.getTemplateVersion().toString());
			documentElement.setAttribute(TEMPLATE_VALIDITY, document.isValid().toString());
			documentElement.setAttribute(TEMPLATE_NAME, document.getTemplateName());
		}
		documentElement.setAttribute(GLOSS_WRITING_ACTIVE, String.valueOf(document.isGlossWritingActive()));
		documentElement.setAttribute(AUTOMATIC_FREE_TEXT_LINE_ENABLED,
				String.valueOf(document.isAutomaticFreeTextLineEnabled()));
		documentElement.setAttribute(FREE_POSITIONABLE_PAGE_POSITIONING_GRID_VISIBILITY,
				Boolean.toString(document.showCollageGrid()));
		documentElement.setAttribute(LOCKEDLAYOUT, Boolean.toString(document.isLayoutLocked()));
		documentElement.setAttribute(LOCKEDCONTENT, Boolean.toString(document.isContentLocked()));
		// Save local dictionary if local signs exist
		LocalDictionary dictionary = document.getLocalDictionary();

		if (!dictionary.isEmpty()) {
			Element dictionaryElement = new Element(DICTIONARY);

			Set<Entry<String, List<SimpleSign>>> entrySet = dictionary.getEntries();

			for (Entry<String, List<SimpleSign>> entry : entrySet) {
				Element entryElement = new Element(DICTIONARY_ENTRY);

				entryElement.setAttribute(new Attribute(DICTIONARY_ENTRY_ATTRIBUTE_WORD, entry.getKey()));

				for (SimpleSign sign : entry.getValue()) {
					entryElement.addContent(createSignElement(sign));
				}

				dictionaryElement.addContent(entryElement);
			}

			documentElement.addContent(dictionaryElement);
		}

		// Save document's sections
		for (int secIndex = 0; secIndex < document.getSectionCount(); secIndex++) {
			Section section = document.getSection(secIndex);
			documentElement.addContent(createSectionElement(section));
		}

		org.jdom.Document xmlDocument = new org.jdom.Document(documentElement);

		return new XMLOutputter().outputString(xmlDocument);
	}

	public class InterfaceAdapter implements JsonSerializer, JsonDeserializer {

		private static final String CLASSNAME = "CLASSNAME";
		private static final String DATA = "DATA";

		/******
		 * Helper method to get the className of the object to be deserialized
		 *****/
		public Class getObjectClass(String className) {
			try {
				return Class.forName(className);
			} catch (ClassNotFoundException e) {
				throw new JsonParseException(e.getMessage());
			}
		}

		@Override
		public Object deserialize(JsonElement jsonElement, Type Type,
				JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
			com.google.gson.JsonObject jsonObject = jsonElement.getAsJsonObject();
			JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
			String className = prim.getAsString();
			Class klass = getObjectClass(className);
			return jsonDeserializationContext.deserialize(jsonObject.get(DATA), klass);
		}

		@Override
		public JsonElement serialize(Object jsonElement, Type type, JsonSerializationContext jsonSerializationContext) {
			com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
			jsonObject.addProperty(CLASSNAME, jsonElement.getClass().getName());
			jsonObject.add(DATA, jsonSerializationContext.serialize(jsonElement));
			return jsonObject;
		}
	}

	private void convertSectionFromUnversionedDocument(Element sectionElement, LocalDictionary localDictionaryOrNull,
			SignLocale language) {
		@SuppressWarnings("unchecked")
		List<Element> paragraphElements = sectionElement.getChildren(PARAGRAPH);

		for (Element paragraphElement : paragraphElements) {
			convertParagraphElementsFromUnversionedDocumentToVersion1(paragraphElement, localDictionaryOrNull,
					language);
		}
	}

	private void convertParagraphElementsFromUnversionedDocumentToVersion1(Element paragraphElement,
			LocalDictionary localDictionaryOrNull, SignLocale language) {

		Element freetextElement = paragraphElement.getChild(FREETEXT);
		FreeTextToken freeTextToken = (FreeTextToken) tokenFactory
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		freeTextToken.setText(freetextElement.getText());
		paragraphElement.removeAttribute(FREETEXT);

		if (!paragraphElement.getAttributes().toString().contains(SIGNS_VISIBLE)) {
			paragraphElement.setAttribute(SIGNS_VISIBLE, Boolean.toString(true));
		}

		@SuppressWarnings("unchecked")
		List<Element> translationElements = paragraphElement.getChildren(TOKEN);

		for (Element tokenElement : translationElements) {
			convertTokenElementForUnversionedDocuments(tokenElement, localDictionaryOrNull, language);
		}

		paragraphElement.addContent(createTokenElement(freeTextToken));
	}

	private Paragraph readParagraphElement(Element paragraphElement, LocalDictionary localDictionaryOrNull,
			SignLocale signLocale, float DocumentVerison) {
		// first, extract id
		Id paragraphId = new Id(paragraphElement.getAttribute(PARAGRAPH_ID).getValue());

		Paragraph paragraph = new Paragraph(paragraphId);

		paragraph.setFreeTextLineVisible(
				Boolean.parseBoolean(paragraphElement.getAttribute(FREETEXT_VISIBLE).getValue()));
		paragraph.setSearchWordLineVisible(
				Boolean.parseBoolean(paragraphElement.getAttribute(SEARCH_WORDS_VISIBLE).getValue()));
		paragraph.setSignLineVisible(Boolean.parseBoolean(paragraphElement.getAttribute(SIGNS_VISIBLE).getValue()));
		paragraph.setPositionX(Integer.parseInt(paragraphElement.getAttribute(PARAGRAPH_POSITION_X).getValue()));
		paragraph.setPositionY(Integer.parseInt(paragraphElement.getAttribute(PARAGRAPH_POSITION_Y).getValue()));
		paragraph.setWidth(Integer.parseInt(paragraphElement.getAttribute(PARAGRAPH_WIDTH).getValue()));
		paragraph.setAutomaticResizeActive(
				Boolean.parseBoolean(paragraphElement.getAttribute(PARAGRAPH_IS_AUTOMATIC_RESIZE_ACTIVE).getValue()));
		paragraph.setZIndex(Integer.parseInt(paragraphElement.getAttribute(PARAGRAPH_Z_INDEX).getValue()));

		@SuppressWarnings("unchecked")
		List<Element> translationElements = paragraphElement.getChildren(TOKEN);

		for (Element tokenElement : translationElements) {
			paragraph.addToken(readTokenElement(tokenElement, localDictionaryOrNull, signLocale, DocumentVerison));
		}

		if (DocumentVerison >= 1.4f) {
			paragraph.lockLayout(Boolean.parseBoolean(paragraphElement.getAttribute(LOCKEDLAYOUT).getValue()));
			paragraph.lockContent(Boolean.parseBoolean(paragraphElement.getAttribute(LOCKEDCONTENT).getValue()));
		}

		return paragraph;
	}

	private Token readTokenElement(Element tokenElement, LocalDictionary localDictionaryOrNull, SignLocale signLocale,
			float DocumentVersion) {
		assert tokenElement.getAttribute(TOKEN_TYPE) != null : "Precondition failed tokenElement has attribute";

		String tokenType = tokenElement.getAttributeValue(TOKEN_TYPE);
		Token newToken = null;
		if (tokenType.equals(SIGN_ITEM_TOKEN)) {
			newToken = readSignItemToken(tokenElement, localDictionaryOrNull, signLocale);
		} else if (tokenType.equals(FREE_TEXT_TOKEN)) {
			newToken = readFreeTextToken(tokenElement, localDictionaryOrNull, signLocale);
		} else if (tokenType.equals(FRAME_TOKEN)) {
			newToken = readFrameToken(tokenElement, localDictionaryOrNull, signLocale);
		} else if (VIDEO_TOKEN.equals(tokenType)) {
			newToken = readVideoToken(tokenElement, localDictionaryOrNull, signLocale);
		} else if (IMAGE_TOKEN.equals(tokenType)) {
			newToken = readImageToken(tokenElement, localDictionaryOrNull, signLocale);
		} else if (URL_FORM_TOKEN.equals(tokenType)) {
			newToken = readUrlFormToken(tokenElement);
		} else if (DATE_FORM_TOKEN.equals(tokenType)) {
			newToken = readDateFormToken(tokenElement);
		} else if (FORM_TOKEN.equals(tokenType)) {
			newToken = readFormToken(tokenElement);
		} else if (TAG_TOKEN.equals(tokenType)) {
			newToken = readTagToken(tokenElement, localDictionaryOrNull, signLocale);
		}

		if (1.4f <= DocumentVersion) {
			newToken.lockLayout(Boolean.parseBoolean(tokenElement.getAttribute(LOCKEDLAYOUT).getValue()));
			newToken.lockContent(Boolean.parseBoolean(tokenElement.getAttribute(LOCKEDCONTENT).getValue()));
		}

		if (tokenElement.getAttributeValue(TOKEN_BACKGROUND_COLOR) != null) {
			newToken.setBackgroundColor(
					Color.makeFromCssString(tokenElement.getAttributeValue(TOKEN_BACKGROUND_COLOR)));
		}

		return newToken;
	}

	private Token readDateFormToken(Element tokenElement) {
		ReadOnlyTextbasedTokenStyle tokenStyle = getReadOnlyTextbasedTokenStyleFromTokenElement(tokenElement);

		Id tokenId = new Id(tokenElement.getAttributeValue(FORM_TOKEN_ID));
		String description = tokenElement.getAttributeValue(FORM_TOKEN_DESCRIPTION);
		String inputContent = tokenElement.getAttributeValue(FORM_TOKEN_INPUT);

		DateFormToken formToken = tokenFactory.createDateFormToken(tokenId, tokenStyle, description);

		int descriptionWidth = Integer.parseInt(tokenElement.getAttributeValue(FORM_TOKEN_DESCRIPTION_WIDTH));
		int inputWidth = Integer.parseInt(tokenElement.getAttributeValue(FORM_TOKEN_INPUT_WIDTH));
		String contentExplanation = tokenElement.getAttributeValue(FORM_TOKEN_CONTENT_EXPLANATION);
		formToken.setDescriptionWidth(descriptionWidth);
		formToken.setInputWidth(inputWidth);
		formToken.setContentExplanation(contentExplanation);
		formToken.setInputContent(inputContent);

		return formToken;
	}

	private Token readUrlFormToken(Element tokenElement) {
		ReadOnlyTextbasedTokenStyle tokenStyle = getReadOnlyTextbasedTokenStyleFromTokenElement(tokenElement);

		Id tokenId = new Id(tokenElement.getAttributeValue(FORM_TOKEN_ID));
		String description = tokenElement.getAttributeValue(FORM_TOKEN_DESCRIPTION);
		String inputContent = tokenElement.getAttributeValue(FORM_TOKEN_INPUT);
		String urlPattern = tokenElement.getAttributeValue(FORM_TOKEN_PATTERN);

		UrlFormToken urlFormToken = tokenFactory.createUrlFormToken(tokenId, tokenStyle, description, urlPattern);

		int descriptionWidth = Integer.parseInt(tokenElement.getAttributeValue(FORM_TOKEN_DESCRIPTION_WIDTH));
		int inputWidth = Integer.parseInt(tokenElement.getAttributeValue(FORM_TOKEN_INPUT_WIDTH));
		String contentExplanation = tokenElement.getAttributeValue(FORM_TOKEN_CONTENT_EXPLANATION);
		urlFormToken.setDescriptionWidth(descriptionWidth);
		urlFormToken.setInputWidth(inputWidth);
		urlFormToken.setInputContent(inputContent);
		urlFormToken.setContentExplanation(contentExplanation);

		return urlFormToken;
	}

	private Token readFormToken(Element tokenElement) {
		ReadOnlyTextbasedTokenStyle tokenStyle = getReadOnlyTextbasedTokenStyleFromTokenElement(tokenElement);

		Id tokenId = new Id(tokenElement.getAttributeValue(FORM_TOKEN_ID));
		String description = tokenElement.getAttributeValue(FORM_TOKEN_DESCRIPTION);
		String inputContent = tokenElement.getAttributeValue(FORM_TOKEN_INPUT);

		FormToken formToken = tokenFactory.createFormToken(tokenId, tokenStyle, description);

		if (documentVersion > 1.5f) {
			int descriptionWidth = Integer.parseInt(tokenElement.getAttributeValue(FORM_TOKEN_DESCRIPTION_WIDTH));
			int inputWidth = Integer.parseInt(tokenElement.getAttributeValue(FORM_TOKEN_INPUT_WIDTH));
			formToken.setDescriptionWidth(descriptionWidth);
			formToken.setInputWidth(inputWidth);
		}

		formToken.setInputContent(inputContent);

		if (documentVersion >= 1.6f) {
			String pattern = tokenElement.getAttributeValue(FORM_TOKEN_PATTERN);
			String contentExplanation = tokenElement.getAttributeValue(FORM_TOKEN_CONTENT_EXPLANATION);
			formToken.setPattern(pattern);
			formToken.setContentExplanation(contentExplanation);
		}

		return formToken;
	}

	private Token readVideoToken(Element tokenElement, LocalDictionary localDictionaryOrNull, SignLocale signLocale) {
		Id tokenId = new Id(tokenElement.getAttributeValue(TOKEN_ID));
		Color color = Color.makeFromCssString(tokenElement.getAttributeValue(VIDEO_TOKEN_COLOR));
		String url = tokenElement.getAttributeValue(VIDEO_TOKEN_URL);
		String visibilityString = tokenElement.getAttributeValue(VIDEO_TOKEN_URL_VISIBILITY);

		VideoToken videoToken = tokenFactory.createVideoToken(tokenId);
		videoToken.setUrl(url);
		videoToken.setBackgroundColor(color);

		if (documentVersion > 1.4f) {
			String videoWidth = tokenElement.getAttributeValue(VIDEO_TOKEN_WIDTH);
			String videoHeight = tokenElement.getAttributeValue(VIDEO_TOKEN_HEIGHT);
			videoToken.setWidth(Integer.parseInt(videoWidth));
			videoToken.setHeight(Integer.parseInt(videoHeight));
		}

		if (visibilityString != null) {
			boolean urlVisible = true;
			urlVisible = Boolean.parseBoolean(visibilityString);
			videoToken.setUrlVisible(urlVisible);
		}

		return videoToken;
	}

	private Token readTagToken(Element tokenElement, LocalDictionary localDictionaryOrNull, SignLocale signLocale) {

		ReadOnlyTextbasedTokenStyle tokenStyle = getReadOnlyTextbasedTokenStyleFromTokenElement(tokenElement);

		Id tokenId = new Id(tokenElement.getAttributeValue(TOKEN_ID));
		String tagSelections = tokenElement.getAttributeValue(TAG_TOKEN_SUGGESTIONS);
		String selectedTags = tokenElement.getAttributeValue(TAG_TOKEN_SELECTED_TAGS);

		String[] items = tagSelections.split(",");
		ArrayList<String> itemList = new ArrayList<String>();
		for (int i = 0; i < items.length; i++) {
			itemList.add(items[i]);
		}

		String[] selectedItems = selectedTags.split(",");
		ArrayList<String> selectedItemList = new ArrayList<String>();
		for (int i = 0; i < selectedItems.length; i++) {
			if (!selectedItems[i].equals("")) {
				selectedItemList.add(selectedItems[i]);
			}
		}

		TagToken tagToken = tokenFactory.createTagToken(tokenId, tokenStyle);
		if (documentVersion > 1.5f) {
			String description = tokenElement.getAttributeValue(TAG_TOKEN_DESCRIPTION);
			int descriptionWidth = Integer.parseInt(tokenElement.getAttributeValue(TAG_TOKEN_DESCRIPTION_WIDTH));
			int inputWidth = Integer.parseInt(tokenElement.getAttributeValue(TAG_TOKEN_INPUT_WIDTH));
			int tagTokenHeight = Integer.parseInt(tokenElement.getAttributeValue(TAG_TOKEN_HEIGHT));

			tagToken.setDescription(description);
			tagToken.setDescriptionWidth(descriptionWidth);
			tagToken.setInputWidth(inputWidth);
			tagToken.setHeight(tagTokenHeight);
		}
		tagToken.setItemList(itemList);
		tagToken.setSelectedItemList(selectedItemList);

		return tagToken;
	}

	private Token readImageToken(Element tokenElement, LocalDictionary localDictionaryOrNull, SignLocale signLocale) {
		Id tokenId = new Id(tokenElement.getAttributeValue(TOKEN_ID));
		Color color = Color.makeFromCssString(tokenElement.getAttributeValue(IMAGE_TOKEN_COLOR));
		String url = tokenElement.getAttributeValue(IMAGE_TOKEN_URL);

		ImageToken imageToken = tokenFactory.createImageToken(tokenId);

		String imageTokenHeightString = tokenElement.getAttributeValue(IMAGE_TOKEN_HEIGHT);
		String imageTokenWidthString = tokenElement.getAttributeValue(IMAGE_TOKEN_WIDTH);

		if (imageTokenHeightString != null) {
			imageToken.setHeight(Integer.parseInt(imageTokenHeightString));
		}
		if (imageTokenWidthString != null) {
			imageToken.setWidth(Integer.parseInt(imageTokenWidthString));
		}

		imageToken.setUrl(url);
		imageToken.setBackgroundColor(color);

		return imageToken;
	}

	private Token readFrameToken(Element tokenElement, LocalDictionary localDictionaryOrNull, SignLocale signLocale) {
		Id tokenId = new Id(tokenElement.getAttributeValue(TOKEN_ID));
		Color color = Color.makeFromCssString(tokenElement.getAttributeValue(FRAME_TOKEN_COLOR));

		String borderWidthString = tokenElement.getAttributeValue(FRAME_TOKEN_BORDER_WIDTH);
		int borderWidth = 0;
		if (borderWidthString != null) {
			borderWidth = Integer.parseInt(borderWidthString);
		}

		String widthString = tokenElement.getAttributeValue(FRAME_TOKEN_WIDTH);
		int width = 0;
		if (widthString != null) {
			width = Integer.parseInt(widthString);
		}

		String heightString = tokenElement.getAttributeValue(FRAME_TOKEN_HEIGHT);
		int height = 0;
		if (heightString != null) {
			height = Integer.parseInt(heightString);
		}

		FrameToken frameToken = tokenFactory.createFrameToken(tokenId);
		frameToken.setBorderWidth(borderWidth);
		frameToken.setFrameColor(color);
		frameToken.setHeight(height);
		frameToken.setWidth(width);

		return frameToken;
	}

	private ReadOnlyTextbasedTokenStyle getReadOnlyTextbasedTokenStyleFromTokenElement(Element tokenElement) {
		FontSize fontSize = TextbasedTokenStyleFactory.DEFAULT_FONT_SIZE;
		String fontSizeString = tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_SIZE);
		if (fontSizeString != null) {
			fontSize = FontSize.valueOf(Integer.parseInt(fontSizeString));
		}

		FontStyle fontStyle = TextbasedTokenStyleFactory.DEFAULT_FONT_STYLE;
		if (tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_STYLE) != null) {
			fontStyle = FontStyle.valueOf(tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_STYLE));
		}

		FontWeight fontWeight = TextbasedTokenStyleFactory.DEFAULT_FONT_WEIGHT;
		if (tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_WEIGHT) != null) {
			fontWeight = FontWeight.valueOf(tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_WEIGHT));
		}

		Font font = TextbasedTokenStyleFactory.DEFAULT_FONT;
		if (tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_NAME) != null) {
			font = Font.fromString(tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_NAME));
		}

		Color textBackgroundColor = TextbasedTokenStyleFactory.DEFAULT_TEXT_BACKGROUND_COLOR;
		if (tokenElement.getAttributeValue(TEXTBASED_TOKEN_TEXT_BOX_COLOR) != null) {
			textBackgroundColor = Color
					.makeFromCssString(tokenElement.getAttributeValue(TEXTBASED_TOKEN_TEXT_BOX_COLOR));
		}

		Color fontColor = TextbasedTokenStyleFactory.DEFAULT_FONT_COLOR;
		if (tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_COLOR) != null) {
			fontColor = Color.makeFromCssString(tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_COLOR));
		}

		assert fontColor != null : "Postcondition failed: result != null";
		assert fontSize != null : "Postcondition failed: result != null";
		assert fontStyle != null : "Postcondition failed: result != null";
		assert fontWeight != null : "Postcondition failed: result != null";
		assert font != null : "Postcondition failed: result != null";
		assert textBackgroundColor != null : "Postcondition failed: result != null";
		return textbasedTokenStyleFactory.createTextbasedTokenStyle(fontSize, fontColor, textBackgroundColor, fontStyle,
				fontWeight, font);
	}

	private Token readFreeTextToken(Element tokenElement, LocalDictionary localDictionaryOrNull,
			SignLocale signLocale) {

		Id tokenId = new Id(tokenElement.getAttributeValue(TOKEN_ID));
		String freeText = tokenElement.getAttributeValue(TEXTBASED_TOKEN_TEXT);

		String hasFixedWidthString = tokenElement.getAttributeValue(FREE_TEXT_TOKEN_HAS_FIXED_WIDTH);
		String maxWidthString = tokenElement.getAttributeValue(FREE_TEXT_TOKEN_WIDTH);
		String visibilityString = tokenElement.getAttributeValue(FREE_TEXT_TOKEN_VISIBILITY);
		String isLineString = tokenElement.getAttributeValue(FREE_TEXT_TOKEN_IS_LINE);

		int maxWidth = -1;
		boolean fixedWidth = false;
		boolean visible = true;
		boolean isLine = false;

		if (hasFixedWidthString != null) {
			fixedWidth = Boolean.parseBoolean(hasFixedWidthString);
		}

		if (visibilityString != null) {
			visible = Boolean.parseBoolean(visibilityString);
		}

		if (isLineString != null) {
			isLine = Boolean.parseBoolean(isLineString);
		}

		if (maxWidthString != null) {
			maxWidth = Integer.parseInt(maxWidthString);
		}

		ReadOnlyTextbasedTokenStyle readOnlyTextbasedTokenStyle = getReadOnlyTextbasedTokenStyleFromTokenElement(
				tokenElement);
		FreeTextToken freeTextToken = tokenFactory.createFreeTextToken(tokenId, freeText, readOnlyTextbasedTokenStyle);
		freeTextToken.setFixedWidth(fixedWidth, maxWidth);
		freeTextToken.setVisible(visible);
		freeTextToken.setIsFreeTextLine(isLine);

		TextbasedToken token = freeTextToken;

		return token;
	}

	private Token readSignItemToken(Element tokenElement, LocalDictionary localDictionaryOrNull,
			SignLocale signLocale) {
		String word = tokenElement.getAttributeValue(TEXTBASED_TOKEN_VALUE);
		Id tokenId = new Id(tokenElement.getAttributeValue(TOKEN_ID));
		SignItem signItem = null;

		String signItemLocaleString = tokenElement.getAttributeValue(SIGN_ITEM_TOKEN_SIGN_LOCALE);

		Color fontColor = Color.makeFromCssString(tokenElement.getAttributeValue(TEXTBASED_TOKEN_FONT_COLOR));
		Element signItemElement = tokenElement.getChild(SIGN_ITEM);
		if (signItemElement != null) {
			signItem = readSignItemElement(signItemElement, false, signLocale);
			if (localDictionaryOrNull != null) {
				if (localDictionaryOrNull.contains(signItem.getSignId())) {
					signItem = new SignItem(localDictionaryOrNull.getSign(signItem.getSignId()));
				}
			}
		} else {
			Element signElement = tokenElement.getChild(SIGN);
			if (signElement != null) {
				SimpleSign sign = readSignElement(signElement, signLocale);
				signItem = new SignItem(sign.getSignId(), sign.getWidth());
			}
		}

		// Collect all signItems to later check if width has changed
		if (signItem != null) {
			allReadSignItems.add(signItem);
		}

		ReadOnlyTextbasedTokenStyle readOnlyTextbasedTokenStyle = getReadOnlyTextbasedTokenStyleFromTokenElement(
				tokenElement);
		SignItemToken token = tokenFactory.createSignItemToken(word, signItem, tokenId, readOnlyTextbasedTokenStyle,
				Color.WHITE, signLocale, false, false);

		if (signItemLocaleString != null) {
			SignLocale locale = SignLocale.valueOf(signItemLocaleString);
			token.setSignLocale(locale);
		} else {
			token.setSignLocale(signLocale);
		}

		return token;
	}

	private void convertTokenElementForUnversionedDocuments(Element tokenElement, LocalDictionary localDictionaryOrNull,
			SignLocale signLocale) {
		SignItemToken token = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, signLocale);

		tokenElement.setAttribute(TOKEN_TYPE, SIGN_ITEM_TOKEN);
		tokenElement.setAttribute(SIGN_ITEM_TOKEN_SIGN_LOCALE, signLocale.name());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_COLOR, token.getFontColor().getCssValue());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_SIZE,
				Integer.toString(token.getStyle().getFontSize().getSize()));
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_STYLE, token.getStyle().getFontStyle().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_WEIGHT, token.getStyle().getFontWeight().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_NAME, token.getStyle().getFont().toString());
	}

	private SignItem readSignItemElement(Element signItemElement, boolean convertToIswa2008,
			SignLocale fallbackSignLocale) {
		long signUpperId = Long.parseLong(signItemElement.getAttributeValue(SIGN_UPPER_ID));
		String signLowerId = signItemElement.getAttributeValue(SIGN_LOWER_ID);
		String source = signItemElement.getAttributeValue(SIGN_SOURCE);
		int signWidth = Integer.parseInt(signItemElement.getAttributeValue(SIGN_WIDTH));

		SignLocale signLocale;
		String signLocaleName = signItemElement.getAttributeValue(SIGN_REGION);
		if (signLocaleName != null) {
			signLocale = SignLocale.valueOf(signLocaleName);
		} else {
			signLocale = fallbackSignLocale;
		}

		SignSource signSource;
		if (source == null) {
			signSource = SignSource.UNKNOWN;
		} else {
			signSource = SignSource.valueOf(source);
		}
		// Needed as no unknown Sources exist
		if (signSource == SignSource.UNKNOWN) {
			signSource = SignSource.IMPORTED;
		}

		if (signLowerId.contains(" ")) {
			signLowerId = signLowerId.replace(' ', '+');
		}

		return new SignItem(new SignId(signUpperId, signLowerId, signLocale, signSource), signWidth);
	}

	private SimpleSign readSignElement(Element signElement, SignLocale fallbackSignLocale)
			throws AssertException, AssertionError {
		assert signElement != null : "Precondition failed: signElement != null";
		assert fallbackSignLocale != null : "Precondition failed: fallbackSignLocale != null";

		String signComment = signElement.getAttributeValue(SIGN_COMMENT);
		if (signComment == null) {
			signComment = "";
		}

		String signAuthorName = signElement.getAttributeValue(SIGN_AUTHOR);
		if (signAuthorName == null || signAuthorName.equals("")) {
			signAuthorName = UNKNOWN;
		}

		String mdtString = signElement.getAttributeValue(SIGN_MDT);
		Date signModificationDate;
		if (mdtString == null || mdtString.equals("")) {
			signModificationDate = new Date();
		} else {
			signModificationDate = new Date(Long.valueOf(signElement.getAttributeValue(SIGN_MDT)));
		}

		String signLocaleName = signElement.getAttributeValue(SIGN_REGION);
		SignLocale language;
		// backwards compatibility
		if (signLocaleName == null || signLocaleName.equals("")) {
			language = fallbackSignLocale;
		} else {
			language = SignLocale.valueOf(signLocaleName);
		}

		String lowerIdPart = signElement.getAttributeValue(SIGN_MEANING);
		long signId = Long.parseLong(signElement.getAttributeValue(SIGN_ID));

		SignSource source = SignSource.UNKNOWN;
		String sourceString = signElement.getAttributeValue(SIGN_SOURCE);
		if (sourceString != null) {
			if (!sourceString.equals("")) {
				source = SignSource.valueOf(sourceString);
			}
		}

		User author = authorDB.getUser(signAuthorName);
		if (author == null) {
			author = User.getUnknownUser();
		}

		if (lowerIdPart.contains(" ")) {
			lowerIdPart = lowerIdPart.replace(' ', '+');
		}

		SimpleSign sign = lowerIdPart.isEmpty() ? null
				: new SimpleSign(new SignId(signId, lowerIdPart, language, source), author, language,
						signModificationDate, signComment);

		if (sign != null) {
			// For documents from v1.19 up
			Element visemesElement = signElement.getChild(VISEMES);
			if (visemesElement != null) {
				List<HeadSymbol> headSymbols = extractHeadSymbolsFromVisemes(visemesElement);
				// Add legacy visemes as head symbols
				for (HeadSymbol headSymbol : headSymbols) {
					sign.addHeadSymbol(headSymbol);
				}
			}
			// For documents from v1.25 up
			Element handSymbolsElement = signElement.getChild(HAND_SYMBOLS_ELEMENT);
			if (handSymbolsElement != null) {
				for (int i = 0; i < handSymbolsElement.getChildren().size(); i++) {
					Element symbolElement = (Element) handSymbolsElement.getChildren().get(i);
					PositionedSymbol positionedSymbol = parsePositionedSymbolElement(symbolElement);
					if (positionedSymbol != null) {
						sign.addSymbol(positionedSymbol);
					}
				}
			}

			Element headSymbolsElement = signElement.getChild(HEAD_SYMBOLS_ELEMENT);
			if (headSymbolsElement != null) {
				@SuppressWarnings("unchecked")
				List<Element> headSymbolChildren = headSymbolsElement.getChildren();

				for (Element headSymbolElement : headSymbolChildren) {
					HeadSymbol headSymbol = readHeadSymbolElement(headSymbolElement);
					if (headSymbol != null) {
						sign.addHeadSymbol(headSymbol);
					}
				}
			}

			Element disarrangedHeadSymbolsElement = signElement.getChild(HEAD_SYMBOLS_DISARRANGED_ELEMENT);
			if (disarrangedHeadSymbolsElement != null) {
				@SuppressWarnings("unchecked")
				List<Element> disarrangedHeadSymbolChildren = disarrangedHeadSymbolsElement.getChildren();

				for (Element headSymbolElement : disarrangedHeadSymbolChildren) {
					HeadSymbol headSymbol = readHeadSymbolElement(headSymbolElement);
					if (headSymbol != null) {
						sign.addDisarrangedHeadSymbol(headSymbol);
					}
				}
			}

			Element fingerAlphabetSymbolsElement = signElement.getChild(FINGER_ALPHABET_SYMBOLS_ELEMENT);
			if (fingerAlphabetSymbolsElement != null) {
				for (int i = 0; i < fingerAlphabetSymbolsElement.getChildren().size(); i++) {
					Element symbolElement = (Element) fingerAlphabetSymbolsElement.getChildren().get(i);
					PositionedFingerAlphabetSymbol positionedSymbol = parsePositionedFingerAlphabetSymbolElement(
							symbolElement);
					if (positionedSymbol != null) {
						sign.addFingerAlphabetSymbol(positionedSymbol);
					}
				}
			}

			Element symbolsElement = signElement.getChild(SYMBOLS);

			if (symbolsElement == null) {
				// Old documents (pre-1.19)
				symbolsElement = signElement;
			}

			sign.addSymbols(extractPositionedSymbols(symbolsElement));
		}
		return sign;
	}

	private PositionedFingerAlphabetSymbol parsePositionedFingerAlphabetSymbolElement(
			Element fingerAlphabetSymbolElement) {

		Element xElement = fingerAlphabetSymbolElement.getChild(SYMBOL_X);
		Element yElement = fingerAlphabetSymbolElement.getChild(SYMBOL_Y);
		Element zElement = fingerAlphabetSymbolElement.getChild(SYMBOL_Z);

		int xValue = Integer.parseInt(xElement.getText());
		int yValue = Integer.parseInt(yElement.getText());
		int zValue = Integer.parseInt(zElement.getText());

		Element colorCodeElementForFormerBlack = fingerAlphabetSymbolElement
				.getChild(POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_BLACK);
		Element colorCodeElementForFormerWhite = fingerAlphabetSymbolElement
				.getChild(POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_WHITE);

		String lineColor = colorCodeElementForFormerBlack == null ? Color.BLACK.getCssValue()
				: colorCodeElementForFormerBlack.getText();
		String fillColor = colorCodeElementForFormerWhite == null ? Color.WHITE.getCssValue()
				: colorCodeElementForFormerWhite.getText();

		Element fingerAlphabetElement = fingerAlphabetSymbolElement.getChild(FINGER_ALPHABET_SYMBOL);

		Symbol symbol = symbolFactory.createSymbol(fingerAlphabetElement.getText());

		FingerAlphabet fingerAlphabet = FingerAlphabet.getFingerAlphabetSymbolFor(symbol);

		PositionedFingerAlphabetSymbol positionedFingerAlphabetSymbol = new PositionedFingerAlphabetSymbol(
				fingerAlphabet, xValue, yValue, zValue);

		positionedFingerAlphabetSymbol.setLineColor(Color.makeFromCssString(lineColor));
		positionedFingerAlphabetSymbol.setFillColor(Color.makeFromCssString(fillColor));

		return positionedFingerAlphabetSymbol;

	}

	private List<PositionedSymbol> extractPositionedSymbols(Element symbolsElement) {
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		for (int i = 0; i < symbolsElement.getChildren(POSITIONED_SYMBOL).size(); i++) {
			Element symbolElement = (Element) symbolsElement.getChildren(POSITIONED_SYMBOL).get(i);
			PositionedSymbol positionedSymbol = parsePositionedSymbolElement(symbolElement);
			if (positionedSymbol != null) {
				positionedSymbols.add(positionedSymbol);
			}
		}
		return positionedSymbols;
	}

	private List<HeadSymbol> extractHeadSymbolsFromVisemes(Element visemesElement) {
		assert visemesElement != null : "Precondition failed: visemesElement != null";

		List<PositionedSymbol> visemePositionedSymbols = new ArrayList<PositionedSymbol>();

		for (int i = 0; i < visemesElement.getChildren().size(); i++) {
			Element visemeElement = (Element) visemesElement.getChildren().get(i);
			PositionedSymbol positionedSymbol = parsePositionedSymbolElement(visemeElement);
			if (positionedSymbol != null) {
				visemePositionedSymbols.add(positionedSymbol);
			}
		}
		return new SymbolToHeadSymbolConverter(positionedSymbolFactory).convertToHeadSymbols(visemePositionedSymbols);
	}

	private HeadSymbol readHeadSymbolElement(Element headSymbolElement) {
		assert headSymbolElement != null : "Precondition failed: headSymbolElement != null";

		List<PositionedSymbol> allSymbols = new ArrayList<PositionedSymbol>();

		allSymbols.add(parseSingleHeadRelatedElement(headSymbolElement, HEAD_SYMBOL_NOSE_ATTRIBUTE));

		allSymbols.add(parseSingleHeadRelatedElement(headSymbolElement, HEAD_SYMBOL_NECK_ATTRIBUTE));

		allSymbols.add(parseSingleHeadRelatedElement(headSymbolElement, HEAD_SYMBOL_EXPRESSION_ATTRIBUTE));

		allSymbols.add(parseSingleHeadRelatedElement(headSymbolElement, HEAD_SYMBOL_HAIR_ATTRIBUTE));

		// Old documents might have their mouths, headPostures and eyes saved as
		// their enum names
		PositionedHeadPostureSymbol headPostureSymbol = parsePositionedHeadPostureSymbol(headSymbolElement);

		allSymbols.add(parsePositionedMouthSymbol(headSymbolElement));

		allSymbols.addAll(parsePositionedCheekSymbols(headSymbolElement));

		allSymbols.addAll(parsePositionedEyeSymbol(headSymbolElement));

		allSymbols.addAll(parsePositionedEarSymbols(headSymbolElement));

		allSymbols.addAll(parsePositionedBreathSymbols(headSymbolElement));

		allSymbols.addAll(parsePositionedJawSymbols(headSymbolElement));

		int xValue = Integer.parseInt(headSymbolElement.getAttributeValue(SYMBOL_X));
		int yValue = Integer.parseInt(headSymbolElement.getAttributeValue(SYMBOL_Y));
		int zValue = Integer.parseInt(headSymbolElement.getAttributeValue(SYMBOL_Z));

		boolean isFreePositionable = true;
		Attribute isFreePositionableAttribute = headSymbolElement.getAttribute(HEAD_SYMBOL_FREE_POSITIONABLE_ATTRIBUTE);
		if (isFreePositionableAttribute != null) {
			isFreePositionable = Boolean.parseBoolean(isFreePositionableAttribute.getValue());
		}

		HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(headPostureSymbol, xValue, yValue, zValue,
				allSymbols.toArray(new PositionedSymbol[allSymbols.size()]));
		headSymbol.setFreePositionable(isFreePositionable);

		return headSymbol;
	}

	private List<PositionedSymbol> parsePositionedCheekSymbols(Element headSymbolElement) {
		List<PositionedSymbol> cheekSymbols = new ArrayList<PositionedSymbol>();

		Element cheekElement = headSymbolElement.getChild(HEAD_SYMBOL_CHEEKS_ATTRIBUTE);
		if (cheekElement != null) {
			// up from document version 1.3
			cheekSymbols.addAll(parseMultipleHeadRelatedElement(cheekElement));
		} else {
			// pre document version 1.3
			String leftCheeksAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_LEFT_CHEEK_ATTRIBUTE);
			String rightCheeksAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_RIGHT_CHEEK_ATTRIBUTE);
			Symbol leftCheekSymbol = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL;
			Symbol rightCheekSymbol = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL;

			if (symbolFactory.isValidSymbol(leftCheeksAttributeValue)) {
				leftCheekSymbol = CheeksBaseSymbol
						.getLeftCheekFor(symbolFactory.createSymbol(leftCheeksAttributeValue).getBaseSymbol());
			} else if (leftCheeksAttributeValue != null) {
				leftCheekSymbol = CheeksBaseSymbol.getLeftCheekFor(
						CheeksBaseSymbol.valueOf(leftCheeksAttributeValue).getIswaSymbol().getBaseSymbol());
			}
			if (leftCheekSymbol != Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL) {
				cheekSymbols.add(positionedSymbolFactory.createPositionedSymbol(leftCheekSymbol, Location.LEFT));
			}

			if (symbolFactory.isValidSymbol(rightCheeksAttributeValue)) {
				rightCheekSymbol = CheeksBaseSymbol
						.getRightCheekFor(symbolFactory.createSymbol(rightCheeksAttributeValue).getBaseSymbol());
			} else if (rightCheeksAttributeValue != null) {
				rightCheekSymbol = CheeksBaseSymbol.getRightCheekFor(
						CheeksBaseSymbol.valueOf(rightCheeksAttributeValue).getIswaSymbol().getBaseSymbol());
			}
			if (rightCheekSymbol != Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL) {
				cheekSymbols.add(positionedSymbolFactory.createPositionedSymbol(rightCheekSymbol, Location.RIGHT));
			}
		}
		return cheekSymbols;
	}

	private List<PositionedSymbol> parsePositionedEarSymbols(Element headSymbolElement) {
		List<PositionedSymbol> earSymbols = new ArrayList<PositionedSymbol>();

		String earsAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_EARS_ATTRIBUTE);
		if (earsAttributeValue == null) {
			Element earsElement = headSymbolElement.getChild(HEAD_SYMBOL_EARS_ATTRIBUTE);
			if (earsElement != null) {
				// up from document version 1.3
				earSymbols.addAll(parseMultipleHeadRelatedElement(earsElement));
			} else {
				// pre document version 1.3
				String leftEarAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_LEFT_EAR_ATTRIBUTE);
				String rightEarAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_RIGHT_EAR_ATTRIBUTE);
				if (leftEarAttributeValue != null) {
					Symbol leftEarSymbol = symbolFactory.createSymbol(leftEarAttributeValue);
					earSymbols.add(positionedSymbolFactory.createPositionedSymbol(leftEarSymbol, Location.LEFT));
				}
				if (rightEarAttributeValue != null) {
					Symbol rightEarSymbol = symbolFactory.createSymbol(rightEarAttributeValue);
					earSymbols.add(positionedSymbolFactory.createPositionedSymbol(rightEarSymbol, Location.RIGHT));
				}
			}

		} else {
			// convertOldEarsToNew while there was only one ear symbol with 5
			// fills
			if (symbolFactory.isValidSymbol(earsAttributeValue)) {
				Symbol oldSymbol = symbolFactory.createSymbol(earsAttributeValue);
				if (EarsBaseSymbol.isAnyEarsSymbol(oldSymbol)) {
					Symbol leftEarSymbol = EarsBaseSymbol.getLeftEarFor(oldSymbol);
					if (leftEarSymbol != Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL) {
						earSymbols.add(positionedSymbolFactory.createPositionedSymbol(leftEarSymbol, Location.LEFT));
					}
					Symbol rightEarSymbol = EarsBaseSymbol.getRightEarFor(oldSymbol);
					if (rightEarSymbol != Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL) {
						earSymbols.add(positionedSymbolFactory.createPositionedSymbol(rightEarSymbol, Location.RIGHT));
					}
				}
			}
		}

		return earSymbols;
	}

	private PositionedHeadPostureSymbol parsePositionedHeadPostureSymbol(Element headSymbolElement) {
		PositionedSymbol headPostureSymbol = PositionedHeadPostureSymbol.getEmptyHeadPostureSymbol();

		String headPostureAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_HEAD_POSTURE_ATTRIBUTE);
		if (headPostureAttributeValue == null) {
			// up from document version 1.3
			Element headPostureElement = headSymbolElement.getChild(HEAD_SYMBOL_HEAD_POSTURE_ATTRIBUTE);
			if (headPostureElement != null) {
				headPostureSymbol = parseSingleHeadRelatedElement(headPostureElement);
			}
		} else if (symbolFactory.isValidSymbol(headPostureAttributeValue)) {
			// pre document version 1.3
			headPostureSymbol = positionedSymbolFactory
					.createPositionedSymbol(symbolFactory.createSymbol(headPostureAttributeValue));
		} else {
			Map<String, Symbol> oldHeadPostureConversionEnums = createOldHeadPostureConversionEnums();
			if (oldHeadPostureConversionEnums.containsKey(headPostureAttributeValue)) {
				headPostureSymbol = positionedSymbolFactory
						.createPositionedSymbol(oldHeadPostureConversionEnums.get(headPostureAttributeValue));
			} else {
				headPostureSymbol = positionedSymbolFactory.createPositionedSymbol(
						HeadPostureBaseSymbol.valueOf(headPostureAttributeValue).getIswaSymbol());
			}
		}
		return (PositionedHeadPostureSymbol) headPostureSymbol;
	}

	private PositionedSymbol parseSingleHeadRelatedElement(Element headSymbolElement, String symbolKey) {
		PositionedSymbol positionedSymbol = positionedSymbolFactory
				.createPositionedSymbol(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL);
		String attributeValue = headSymbolElement.getAttributeValue(symbolKey);
		if (attributeValue == null) {
			// up from document version 1.3
			Element symbolElement = headSymbolElement.getChild(symbolKey);
			if (symbolElement != null) {
				positionedSymbol = parseSingleHeadRelatedElement(symbolElement);
			}
		} else {
			// pre document version 1.3
			if (symbolFactory.isValidSymbol(attributeValue)) {
				positionedSymbol = positionedSymbolFactory
						.createPositionedSymbol(symbolFactory.createSymbol(attributeValue));
			}
		}
		assert positionedSymbol != null : "Postcondition failed: symbol != null";
		return positionedSymbol;
	}

	private List<PositionedSymbol> parseMultipleHeadRelatedElement(Element headRelatedElement) {
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		for (Object element : headRelatedElement.getChildren()) {
			positionedSymbols.add(parseSingleHeadRelatedElement((Element) element));
		}
		return positionedSymbols;
	}

	private List<PositionedSymbol> parsePositionedJawSymbols(Element headSymbolElement) {
		List<PositionedSymbol> jawSymbols = new ArrayList<PositionedSymbol>();

		Element jawElement = headSymbolElement.getChild(HEAD_SYMBOL_JAW_ATTRIBUTE);
		if (jawElement != null) {
			// up from document version 1.3
			jawSymbols.addAll(parseMultipleHeadRelatedElement(jawElement));
		} else {
			String jawAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_JAW_ATTRIBUTE);
			// pre document version 1.3
			if (symbolFactory.isValidSymbol(jawAttributeValue)) {
				jawSymbols.addAll(
						PositionedJawSymbol.convertToValidJawSymbol(symbolFactory.createSymbol(jawAttributeValue)));
			}
		}

		return jawSymbols;
	}

	private List<PositionedSymbol> parsePositionedBreathSymbols(Element headSymbolElement) {
		List<PositionedSymbol> breathSymbols = new ArrayList<PositionedSymbol>();

		Element breathElement = headSymbolElement.getChild(HEAD_SYMBOL_BREATH_ATTRIBUTE);

		if (breathElement != null) {
			// up from document version 1.3
			breathSymbols.addAll(parseMultipleHeadRelatedElement(breathElement));
		} else {
			// pre document version 1.3
			String leftBreathAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_LEFT_BREATH_ATTRIBUTE);
			String rightBreathAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_RIGHT_BREATH_ATTRIBUTE);
			if (symbolFactory.isValidSymbol(leftBreathAttributeValue)) {
				breathSymbols.add(positionedSymbolFactory.createPositionedSymbol(
						BreathBaseSymbol.getLeftBreathSymbolFor(symbolFactory.createSymbol(leftBreathAttributeValue)),
						Location.LEFT));
			}
			if (symbolFactory.isValidSymbol(rightBreathAttributeValue)) {
				breathSymbols.add(positionedSymbolFactory.createPositionedSymbol(
						BreathBaseSymbol.getRightBreathSymbolFor(symbolFactory.createSymbol(rightBreathAttributeValue)),
						Location.RIGHT));
			}
		}
		return breathSymbols;
	}

	private PositionedSymbol parsePositionedMouthSymbol(Element headSymbolElement) {
		PositionedSymbol mouthSymbol = PositionedMouthSymbol.getEmptySymbol();

		String mouthAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_MOUTH_ATTRIBUTE);
		if (mouthAttributeValue == null) {
			// up from document version 1.3
			Element mouthElement = headSymbolElement.getChild(HEAD_SYMBOL_MOUTH_ATTRIBUTE);
			if (mouthElement != null) {
				mouthSymbol = parseSingleHeadRelatedElement(mouthElement);
			}
		} else if (symbolFactory.isValidSymbol(mouthAttributeValue)) {
			// pre document version 1.3
			mouthSymbol = positionedSymbolFactory
					.createPositionedSymbol(symbolFactory.createSymbol(mouthAttributeValue));
		} else {
			// was a basesymbol once
			if ("TONGUE_INSIDE_MOUTH_RELAXED_BOTTOM".equals(mouthAttributeValue)) {
				mouthSymbol = positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 1, 5, 2, 5, 10, 10));
			} else if ("MOUTH_EMPTY".equals(mouthAttributeValue)) {
				mouthSymbol = PositionedMouthSymbol.getEmptySymbol();
			} else {
				mouthSymbol = positionedSymbolFactory
						.createPositionedSymbol(MouthBaseSymbol.valueOf(mouthAttributeValue).getIswaSymbol());
			}
		}

		assert mouthSymbol != null : "Postcondition failed: result != null";
		return mouthSymbol;
	}

	private List<PositionedSymbol> parsePositionedEyeSymbol(Element headSymbolElement) {
		List<PositionedSymbol> eyeSymbols = new ArrayList<PositionedSymbol>();

		String eyesAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_EYES_ATTRIBUTE);
		if (eyesAttributeValue == null) {
			Element eyeElement = headSymbolElement.getChild(HEAD_SYMBOL_EYES_ATTRIBUTE);
			// up from document version 1.3
			if (eyeElement != null) {
				eyeSymbols = parseMultipleHeadRelatedElement(eyeElement);
			} else {
				// It is a new document with left and right eye
				String leftEyesAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_LEFT_EYES_ATTRIBUTE);
				String rightEyesAttributeValue = headSymbolElement.getAttributeValue(HEAD_SYMBOL_RIGHT_EYES_ATTRIBUTE);
				if (symbolFactory.isValidSymbol(leftEyesAttributeValue)) {
					eyeSymbols.add(positionedSymbolFactory
							.createPositionedSymbol(symbolFactory.createSymbol(leftEyesAttributeValue), Location.LEFT));
				} else if (leftEyesAttributeValue != null) {
					if ("EYE_WINK__SQUEEZED_EYE_BLINK_".equals(leftEyesAttributeValue)) {
						eyeSymbols.add(positionedSymbolFactory
								.createPositionedSymbol(new Symbol(4, 2, 5, 5, 5, 1, 12, 9), Location.LEFT));
					} else {
						eyeSymbols.add(positionedSymbolFactory.createPositionedSymbol(
								EyesBaseSymbol
										.getLeftEyeFor(EyesBaseSymbol.valueOf(leftEyesAttributeValue).getIswaSymbol()),
								Location.LEFT));
					}
				}
				if (symbolFactory.isValidSymbol(rightEyesAttributeValue)) {
					eyeSymbols.add(positionedSymbolFactory.createPositionedSymbol(
							symbolFactory.createSymbol(rightEyesAttributeValue), Location.RIGHT));
				} else if (rightEyesAttributeValue != null) {
					if ("EYE_WINK__SQUEEZED_EYE_BLINK_".equals(rightEyesAttributeValue)) {
						eyeSymbols.add(positionedSymbolFactory
								.createPositionedSymbol(new Symbol(4, 2, 5, 5, 5, 1, 12, 9), Location.RIGHT));
					} else {
						eyeSymbols.add(positionedSymbolFactory.createPositionedSymbol(
								EyesBaseSymbol.getRightEyeFor(
										EyesBaseSymbol.valueOf(rightEyesAttributeValue).getIswaSymbol()),
								Location.RIGHT));
					}
				}
			}
		} else {
			// If the document contains the keyword "eyes" it's an old document
			// and must be handled differently
			if (symbolFactory.isValidSymbol(eyesAttributeValue)) {
				Symbol eyeSymbol = symbolFactory.createSymbol(eyesAttributeValue);
				if ("EYE_WINK__SQUEEZED_EYE_BLINK_".equals(eyesAttributeValue)) {
					eyeSymbols.add(positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 2, 5, 5, 5, 1, 12, 9),
							Location.LEFT));
					eyeSymbols.add(positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 2, 5, 5, 5, 1, 12, 9),
							Location.RIGHT));
				} else {
					eyeSymbols.addAll(PositionedEyeSymbol.convertToValidEyeSymbols(eyeSymbol));
				}
			} else {
				Symbol eyeSymbol = EyesBaseSymbol.valueOf(eyesAttributeValue).getIswaSymbol();
				eyeSymbols.addAll(PositionedEyeSymbol.convertToValidEyeSymbols(eyeSymbol));
			}
		}
		return eyeSymbols;
	}

	private Map<String, Symbol> createOldHeadPostureConversionEnums() {
		Map<String, Symbol> result = new HashMap<String, Symbol>();

		result.put("HEAD_RIMS_NORTH", new Symbol(4, 1, 2, 1, 1, 1, 36, 35));
		result.put("HEAD_RIMS_NORTH_WEST", new Symbol(4, 1, 2, 1, 1, 2, 36, 35));
		result.put("HEAD_RIMS_WEST", new Symbol(4, 1, 2, 1, 1, 3, 36, 35));
		result.put("HEAD_RIMS_SOUTH_WEST", new Symbol(4, 1, 2, 1, 1, 4, 36, 35));
		result.put("HEAD_RIMS_SOUTH", new Symbol(4, 1, 2, 1, 1, 5, 36, 35));
		result.put("HEAD_RIMS_SOUTH_EAST", new Symbol(4, 1, 2, 1, 1, 6, 36, 35));
		result.put("HEAD_RIMS_EAST", new Symbol(4, 1, 2, 1, 1, 7, 36, 35));
		result.put("HEAD_RIMS_NORTH_EAST", new Symbol(4, 1, 2, 1, 1, 8, 36, 35));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_NORTH", new Symbol(4, 1, 3, 1, 1, 1, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_NORTH_WEST", new Symbol(4, 1, 3, 1, 1, 2, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_WEST", new Symbol(4, 1, 3, 1, 1, 3, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_SOUTH_WEST", new Symbol(4, 1, 3, 1, 1, 4, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_SOUTH", new Symbol(4, 1, 3, 1, 1, 5, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_SOUTH_EAST", new Symbol(4, 1, 3, 1, 1, 6, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_EAST", new Symbol(4, 1, 3, 1, 1, 7, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_NORTH_EAST", new Symbol(4, 1, 3, 1, 1, 8, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_NORTH", new Symbol(4, 1, 3, 1, 2, 1, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_NORTH_WEST", new Symbol(4, 1, 3, 1, 2, 2, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_WEST", new Symbol(4, 1, 3, 1, 2, 3, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_SOUTH_WEST", new Symbol(4, 1, 3, 1, 2, 4, 40, 45));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_SOUTH", new Symbol(4, 1, 3, 1, 2, 5, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_SOUTH_EAST", new Symbol(4, 1, 3, 1, 2, 6, 40, 45));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_EAST", new Symbol(4, 1, 3, 1, 2, 7, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_NORTH_EAST", new Symbol(4, 1, 3, 1, 2, 8, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_ALTERNATING_NORTH", new Symbol(4, 1, 3, 1, 3, 1, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_ALTERNATING_NORTH_WEST",
				new Symbol(4, 1, 3, 1, 3, 2, 44, 42));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_ALTERNATING_WEST", new Symbol(4, 1, 3, 1, 3, 3, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_ALTERNATING_SOUTH_WEST",
				new Symbol(4, 1, 3, 1, 3, 4, 44, 43));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_ALTERNATING_SOUTH", new Symbol(4, 1, 3, 1, 3, 5, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_ALTERNATING_SOUTH_EAST",
				new Symbol(4, 1, 3, 1, 3, 6, 44, 43));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_ALTERNATING_EAST", new Symbol(4, 1, 3, 1, 3, 7, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_DOUBLE_ALTERNATING_NORTH_EAST",
				new Symbol(4, 1, 3, 1, 3, 8, 44, 42));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_NORTH", new Symbol(4, 1, 3, 1, 4, 1, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_NORTH_WEST", new Symbol(4, 1, 3, 1, 4, 2, 46, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_WEST", new Symbol(4, 1, 3, 1, 4, 3, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_SOUTH_WEST", new Symbol(4, 1, 3, 1, 4, 4, 48, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_SOUTH", new Symbol(4, 1, 3, 1, 4, 5, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_SOUTH_EAST", new Symbol(4, 1, 3, 1, 4, 6, 48, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_EAST", new Symbol(4, 1, 3, 1, 4, 7, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_NORTH_EAST", new Symbol(4, 1, 3, 1, 4, 8, 46, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_ALTERNATING_NORTH", new Symbol(4, 1, 3, 1, 5, 1, 36, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_ALTERNATING_NORTH_WEST",
				new Symbol(4, 1, 3, 1, 5, 2, 46, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_ALTERNATING_WEST", new Symbol(4, 1, 3, 1, 5, 3, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_ALTERNATING_SOUTH_WEST",
				new Symbol(4, 1, 3, 1, 5, 4, 46, 44));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_ALTERNATING_SOUTH", new Symbol(4, 1, 3, 1, 5, 5, 36, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_ALTERNATING_SOUTH_EAST",
				new Symbol(4, 1, 3, 1, 5, 6, 46, 44));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_ALTERNATING_EAST", new Symbol(4, 1, 3, 1, 5, 7, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_WALL_PLANE_TRIPLE_ALTERNATING_NORTH_EAST",
				new Symbol(4, 1, 3, 1, 5, 8, 46, 47));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_NORTH_WEST", new Symbol(4, 1, 4, 1, 1, 1, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_NORTH_EAST", new Symbol(4, 1, 4, 1, 1, 2, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_DOUBLE_NORTH_WEST", new Symbol(4, 1, 4, 1, 2, 1, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_DOUBLE_NORTH_EAST", new Symbol(4, 1, 4, 1, 2, 2, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_TRIPLE_NORTH_WEST", new Symbol(4, 1, 4, 1, 3, 1, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_TRIPLE_NORTH_EAST", new Symbol(4, 1, 4, 1, 3, 2, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_ARROW_EAST", new Symbol(4, 1, 4, 1, 4, 1, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_ARROW_WEST", new Symbol(4, 1, 4, 1, 4, 2, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_ARROWS_ALTERNATING_EAST", new Symbol(4, 1, 4, 1, 5, 1, 36, 45));
		result.put("HEAD_MOVEMENT_TILTS_WALL_PLANE_ARROWS_ALTERNATING_WEST", new Symbol(4, 1, 4, 1, 5, 2, 36, 45));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_NORTH", new Symbol(4, 1, 5, 1, 1, 1, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_NORTH_WEST", new Symbol(4, 1, 5, 1, 1, 2, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_WEST", new Symbol(4, 1, 5, 1, 1, 3, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_SOUTH_WEST", new Symbol(4, 1, 5, 1, 1, 4, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_SOUTH", new Symbol(4, 1, 5, 1, 1, 5, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_SOUTH_EAST", new Symbol(4, 1, 5, 1, 1, 6, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_EAST", new Symbol(4, 1, 5, 1, 1, 7, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_NORTH_EAST", new Symbol(4, 1, 5, 1, 1, 8, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_NORTH", new Symbol(4, 1, 5, 1, 2, 1, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_NORTH_WEST", new Symbol(4, 1, 5, 1, 2, 2, 44, 42));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_WEST", new Symbol(4, 1, 5, 1, 2, 3, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_SOUTH_WEST", new Symbol(4, 1, 5, 1, 2, 4, 41, 44));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_SOUTH", new Symbol(4, 1, 5, 1, 2, 5, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_SOUTH_EAST", new Symbol(4, 1, 5, 1, 2, 6, 41, 44));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_EAST", new Symbol(4, 1, 5, 1, 2, 7, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_NORTH_EAST", new Symbol(4, 1, 5, 1, 2, 8, 44, 42));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_ALTERNATING_NORHT", new Symbol(4, 1, 5, 1, 3, 1, 36, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_ALTERNATING_NORTH_WEST",
				new Symbol(4, 1, 5, 1, 3, 2, 44, 41));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_ALTERNATING_WEST", new Symbol(4, 1, 5, 1, 3, 3, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_ALTERNATING_SOUTH_WEST",
				new Symbol(4, 1, 5, 1, 3, 4, 43, 42));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_ALTERNATING_SOUTH", new Symbol(4, 1, 5, 1, 3, 5, 36, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_ALTERNATING_SOUTH_EAST",
				new Symbol(4, 1, 5, 1, 3, 6, 43, 42));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_ALTERNATING_EAST", new Symbol(4, 1, 5, 1, 3, 7, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_DOUBLE_ALTERNATING_NORTH_EAST",
				new Symbol(4, 1, 5, 1, 3, 8, 44, 41));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_NORTH", new Symbol(4, 1, 5, 1, 4, 1, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_NORTH_WEST", new Symbol(4, 1, 5, 1, 4, 2, 46, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_WEST", new Symbol(4, 1, 5, 1, 4, 3, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_SOUTH_WEST", new Symbol(4, 1, 5, 1, 4, 4, 47, 45));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_SOUTH", new Symbol(4, 1, 5, 1, 4, 5, 36, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_SOUTH_EAST", new Symbol(4, 1, 5, 1, 4, 6, 47, 45));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_EAST", new Symbol(4, 1, 5, 1, 4, 7, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_NORTH_EAST", new Symbol(4, 1, 5, 1, 4, 8, 46, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_ALTERNATING_NORTH", new Symbol(4, 1, 5, 1, 5, 1, 36, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_ALTERNATING_NORTH_EAST",
				new Symbol(4, 1, 5, 1, 5, 2, 46, 46));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_ALTERNATING_EAST", new Symbol(4, 1, 5, 1, 5, 3, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_ALTERNATING_SOUTH_EAST",
				new Symbol(4, 1, 5, 1, 5, 4, 45, 44));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_ALTERNATING_SOUTH", new Symbol(4, 1, 5, 1, 5, 5, 36, 47));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_ALTERNATING_SOUTH_WEST",
				new Symbol(4, 1, 5, 1, 5, 6, 45, 44));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_ALTERNATING_WEST", new Symbol(4, 1, 5, 1, 5, 7, 36, 48));
		result.put("HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE_TRIPLE_ALTERNATING_NORTH_WEST",
				new Symbol(4, 1, 5, 1, 5, 8, 46, 46));
		result.put("HEAD_MOVEMENT_CURVES_WALL_PLANE_SOUTH_WEST", new Symbol(4, 1, 6, 1, 1, 1, 36, 44));
		result.put("HEAD_MOVEMENT_CURVES_WALL_PLANE_NORTH_EAST", new Symbol(4, 1, 6, 1, 1, 2, 36, 44));
		result.put("HEAD_MOVEMENT_CURVES_WALL_PLANE_SOUTH_EAST", new Symbol(4, 1, 6, 1, 1, 3, 36, 43));
		result.put("HEAD_MOVEMENT_CURVES_WALL_PLANE_NORTH_WEST", new Symbol(4, 1, 6, 1, 1, 4, 36, 44));
		result.put("HEAD_MOVEMENT_CURVES_FLOOR_PLANE_SOUTH_WEST", new Symbol(4, 1, 7, 1, 1, 1, 36, 42));
		result.put("HEAD_MOVEMENT_CURVES_FLOOR_PLANE_WEST", new Symbol(4, 1, 7, 1, 1, 2, 36, 47));
		result.put("HEAD_MOVEMENT_CURVES_FLOOR_PLANE_SOUTH_EAST", new Symbol(4, 1, 7, 1, 1, 3, 36, 42));
		result.put("HEAD_MOVEMENT_CURVES_FLOOR_PLANE_EAST", new Symbol(4, 1, 7, 1, 1, 4, 36, 47));
		result.put("HEAD_MOVEMENT_CIRCLES_EAST", new Symbol(4, 1, 8, 1, 1, 1, 36, 38));
		result.put("HEAD_MOVEMENT_CIRCLES_WEST", new Symbol(4, 1, 8, 1, 1, 2, 36, 38));
		result.put("HEAD_MOVEMENT_CIRCLES_EAST_DOUBLE", new Symbol(4, 1, 8, 1, 1, 3, 36, 38));
		result.put("HEAD_MOVEMENT_CIRCLES_WEST_DOUBLE", new Symbol(4, 1, 8, 1, 1, 4, 36, 38));
		result.put("NOSE_FORWARD_TILTING_NORTH_WEST", new Symbol(4, 1, 9, 1, 1, 1, 36, 35));
		result.put("NOSE_FORWARD_TILTING_NORTH_EAST", new Symbol(4, 1, 9, 1, 1, 2, 36, 35));
		result.put("NOSE_UP_OR_DOWN_NORTH", new Symbol(4, 1, 10, 1, 1, 1, 36, 44));
		result.put("NOSE_UP_OR_DOWN_NORTH_WEST", new Symbol(4, 1, 10, 1, 1, 2, 36, 44));
		result.put("NOSE_UP_OR_DOWN_WEST", new Symbol(4, 1, 10, 1, 1, 3, 36, 44));
		result.put("NOSE_UP_OR_DOWN_SOUTH_WEST", new Symbol(4, 1, 10, 1, 1, 4, 36, 42));
		result.put("NOSE_UP_OR_DOWN_SOUTH", new Symbol(4, 1, 10, 1, 1, 5, 36, 42));
		result.put("NOSE_UP_OR_DOWN_SOUTH_EAST", new Symbol(4, 1, 10, 1, 1, 6, 36, 42));
		result.put("NOSE_UP_OR_DOWN_EAST", new Symbol(4, 1, 10, 1, 1, 7, 36, 44));
		result.put("NOSE_UP_OR_DOWN_NORTH_EAST", new Symbol(4, 1, 10, 1, 1, 8, 36, 44));
		result.put("NOSE_UP_OR_DOWN_MIRRORED_NORTH", new Symbol(4, 1, 10, 1, 1, 9, 36, 44));
		result.put("NOSE_UP_OR_DOWN_MIRRORED_NORTH_WEST", new Symbol(4, 1, 10, 1, 1, 10, 36, 44));
		result.put("NOSE_UP_OR_DOWN_MIRRORED_WEST", new Symbol(4, 1, 10, 1, 1, 11, 36, 44));
		result.put("NOSE_UP_OR_DOWN_MIRRORED_SOUTH_WEST", new Symbol(4, 1, 10, 1, 1, 12, 36, 42));
		result.put("NOSE_UP_OR_DOWN_MIRRORED_SOUTH", new Symbol(4, 1, 10, 1, 1, 13, 36, 42));
		result.put("NOSE_UP_OR_DOWN_MIRRORED_SOUTH_EAST", new Symbol(4, 1, 10, 1, 1, 14, 36, 42));
		result.put("NOSE_UP_OR_DOWN_MIRRORED_EAST", new Symbol(4, 1, 10, 1, 1, 15, 36, 44));
		result.put("NOSE_UP_OR_DOWN_MIRRORED_NORTH_EAST", new Symbol(4, 1, 10, 1, 1, 16, 36, 44));
		result.put("NOSE_UP_OR_DOWN_TILTING_NORTH", new Symbol(4, 1, 10, 2, 1, 1, 36, 43));
		result.put("NOSE_UP_OR_DOWN_TILTING_NORTH_WEST", new Symbol(4, 1, 10, 2, 1, 2, 36, 43));
		result.put("NOSE_UP_OR_DOWN_TILTING_WEST", new Symbol(4, 1, 10, 2, 1, 3, 36, 44));
		result.put("NOSE_UP_OR_DOWN_TILTING_SOUTH_WEST", new Symbol(4, 1, 10, 2, 1, 4, 36, 43));
		result.put("NOSE_UP_OR_DOWN_TILTING_SOUTH", new Symbol(4, 1, 10, 2, 1, 5, 36, 43));
		result.put("NOSE_UP_OR_DOWN_TILTING_SOUTH_EAST", new Symbol(4, 1, 10, 2, 1, 6, 36, 42));
		result.put("NOSE_UP_OR_DOWN_TILTING_EAST", new Symbol(4, 1, 10, 2, 1, 7, 36, 44));
		result.put("NOSE_UP_OR_DOWN_TILTING_NORTH_EAST", new Symbol(4, 1, 10, 2, 1, 8, 36, 44));
		result.put("NOSE_UP_OR_DOWN_TILTING_MIRRORED_NORTH", new Symbol(4, 1, 10, 2, 1, 9, 36, 43));
		result.put("NOSE_UP_OR_DOWN_TILTING_MIRRORED_NORTH_WEST", new Symbol(4, 1, 10, 2, 1, 10, 36, 43));
		result.put("NOSE_UP_OR_DOWN_TILTING_MIRRORED_WEST", new Symbol(4, 1, 10, 2, 1, 11, 36, 44));
		result.put("NOSE_UP_OR_DOWN_TILTING_MIRRORED_SOUTH_WEST", new Symbol(4, 1, 10, 2, 1, 12, 36, 43));
		result.put("NOSE_UP_OR_DOWN_TILTING_MIRRORED_SOUTH", new Symbol(4, 1, 10, 2, 1, 13, 36, 43));
		result.put("NOSE_UP_OR_DOWN_TILTING_MIRRORED_SOUTH_EAST", new Symbol(4, 1, 10, 2, 1, 14, 36, 42));
		result.put("NOSE_UP_OR_DOWN_TILTING_MIRRORED_EAST", new Symbol(4, 1, 10, 2, 1, 15, 36, 44));
		result.put("NOSE_UP_OR_DOWN_TILTING_MIRRORED_NORTH_EAST", new Symbol(4, 1, 10, 2, 1, 16, 36, 44));

		return result;
	}

	private PositionedSymbol parsePositionedSymbolElement(Element symbolElement)
			throws AssertException, AssertionError {
		assert symbolElement != null : "Precondition failed: symbolElement != null";

		PositionedSymbol positionedSymbol = null;

		Element symbolCode = symbolElement.getChild(ISWA_ID);
		String iswaCode = symbolCode.getText();

		if (symbolFactory.isValidSymbol(iswaCode)) {
			Element xElement = symbolElement.getChild(SYMBOL_X);
			Element yElement = symbolElement.getChild(SYMBOL_Y);
			Element zElement = symbolElement.getChild(SYMBOL_Z);
			Element colorCodeElementForFormerBlack = symbolElement
					.getChild(POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_BLACK);
			Element colorCodeElementForFormerWhite = symbolElement
					.getChild(POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_WHITE);

			Symbol symbol = symbolFactory.createSymbol(iswaCode);
			int x = Integer.parseInt(xElement.getText());
			int y = Integer.parseInt(yElement.getText());
			int z = Integer.parseInt(zElement.getText());
			String lineColor = colorCodeElementForFormerBlack == null ? Color.BLACK.getCssValue()
					: colorCodeElementForFormerBlack.getText();
			String fillColor = colorCodeElementForFormerWhite == null ? Color.WHITE.getCssValue()
					: colorCodeElementForFormerWhite.getText();

			positionedSymbol = new PositionedSymbol(symbol, x, y, z);
			positionedSymbol.setLineColor(Color.makeFromCssString(lineColor));
			positionedSymbol.setFillColor(Color.makeFromCssString(fillColor));
		}

		return positionedSymbol;
	}

	private PositionedSymbol parseSingleHeadRelatedElement(Element symbolElement) {
		assert symbolElement != null : "Precondition failed: symbolElement != null";

		Element symbolCode = symbolElement.getChild(ISWA_ID);
		String iswaCode = symbolCode.getText();
		PositionedSymbol positionedSymbol = null;

		if (symbolFactory.isValidSymbol(iswaCode)) {
			Element xElement = symbolElement.getChild(SYMBOL_X);
			Element yElement = symbolElement.getChild(SYMBOL_Y);
			Element zElement = symbolElement.getChild(SYMBOL_Z);
			Element colorCodeElementForFormerBlack = symbolElement
					.getChild(POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_BLACK);
			Element colorCodeElementForFormerWhite = symbolElement
					.getChild(POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_WHITE);

			Symbol symbol = symbolFactory.createSymbol(iswaCode);
			int x = Integer.parseInt(xElement.getText());
			int y = Integer.parseInt(yElement.getText());
			int z = Integer.parseInt(zElement.getText());
			String lineColor = colorCodeElementForFormerBlack == null ? Color.BLACK.getCssValue()
					: colorCodeElementForFormerBlack.getText();
			String fillColor = colorCodeElementForFormerWhite == null ? Color.WHITE.getCssValue()
					: colorCodeElementForFormerWhite.getText();

			Element locationElement = symbolElement.getChild(LOCATION);
			if (locationElement == null) {
				positionedSymbol = positionedSymbolFactory.createPositionedSymbol(symbol, x, y, z);
			} else {
				Location location = Location.valueOf(locationElement.getText());
				positionedSymbol = positionedSymbolFactory.createPositionedSymbol(symbol, location, x, y, z);
			}
			positionedSymbol.setLineColor(Color.makeFromCssString(lineColor));
			positionedSymbol.setFillColor(Color.makeFromCssString(fillColor));
		}

		return positionedSymbol;
	}

	private LocalDictionary readLocalDictionaryElement(Element dictionaryElement, SignLocale signLocale)
			throws AssertException, AssertionError {
		assert dictionaryElement != null : "Precondition failed: dictionaryElement != null";

		LocalDictionary result = new LocalDictionary();

		@SuppressWarnings("unchecked")
		List<Element> entryElements = dictionaryElement.getChildren(DICTIONARY_ENTRY);

		for (Element entryElement : entryElements) {
			@SuppressWarnings("unchecked")
			List<Element> signElements = entryElement.getChildren(SIGN);
			String key = entryElement.getAttribute(DICTIONARY_ENTRY_ATTRIBUTE_WORD).getValue();

			for (Element signElement : signElements) {
				result.save(readSignElement(signElement, signLocale));
			}
		}

		return result;
	}

	private Element createSectionElement(Section section) {
		Element sectionElement = new Element(SECTION);
		sectionElement.setAttribute(SECTION_FREE_POSITIONABLE, Boolean.toString(section.isCollage()));
		sectionElement.setAttribute(LOCKEDLAYOUT, Boolean.toString(section.isLayoutLocked()));
		sectionElement.setAttribute(LOCKEDCONTENT, Boolean.toString(section.isContentLocked()));

		for (int parIndex = 0; parIndex < section.getParagraphCount(); parIndex++) {
			Paragraph paragraph = section.getParagraph(parIndex);
			sectionElement.addContent(createParagraphElement(paragraph));
		}
		return sectionElement;
	}

	private Element createParagraphElement(Paragraph paragraph) {
		Element paragraphElement = new Element(PARAGRAPH);

		paragraphElement.setAttribute(FREETEXT_VISIBLE, "" + paragraph.isFreeTextLineVisible());
		paragraphElement.setAttribute(SEARCH_WORDS_VISIBLE, "" + paragraph.isSearchWordLineVisible());
		paragraphElement.setAttribute(SIGNS_VISIBLE, "" + paragraph.isSignLineVisible());
		paragraphElement.setAttribute(PARAGRAPH_ID, paragraph.getParagraphId().toString());
		paragraphElement.setAttribute(PARAGRAPH_POSITION_X, Integer.toString(paragraph.getPositionX()));
		paragraphElement.setAttribute(PARAGRAPH_POSITION_Y, Integer.toString(paragraph.getPositionY()));
		paragraphElement.setAttribute(PARAGRAPH_WIDTH, Integer.toString(paragraph.getWidth()));
		paragraphElement.setAttribute(PARAGRAPH_IS_AUTOMATIC_RESIZE_ACTIVE,
				Boolean.toString(paragraph.isAutomaticResize()));
		paragraphElement.setAttribute(PARAGRAPH_Z_INDEX, Integer.toString(paragraph.getZIndex()));
		paragraphElement.setAttribute(LOCKEDLAYOUT, Boolean.toString(paragraph.isLayoutLocked()));
		paragraphElement.setAttribute(LOCKEDCONTENT, Boolean.toString(paragraph.isContentLocked()));

		for (int tokenIndex = 0; tokenIndex < paragraph.getTokenCount(); tokenIndex++) {
			Token token = paragraph.getToken(tokenIndex);
			paragraphElement.addContent(createTokenElement(token));
		}
		return paragraphElement;
	}

	private Element createTokenElement(Token token) {
		Element result = null;
		if (token instanceof SignItemToken) {
			result = createSignItemTokenElement((SignItemToken) token);
		} else if (token instanceof FreeTextToken) {
			result = createFreeTextTokenElement((FreeTextToken) token);
		} else if (token instanceof FrameToken) {
			result = createFrameTokenElement((FrameToken) token);
		} else if (token instanceof VideoToken) {
			result = createVideoTokenElement((VideoToken) token);
		} else if (token instanceof ImageToken) {
			result = createImageTokenElement((ImageToken) token);
		} else if (token instanceof UrlFormToken) {
			result = createUrlFormTokenElement((UrlFormToken) token);
		} else if (token instanceof DateFormToken) {
			result = createDateFormTokenElement((DateFormToken) token);
		} else if (token instanceof FormToken) {
			result = createFormTokenElement((FormToken) token);
		} else if (token instanceof TagToken) {
			result = createTagTokenElement((TagToken) token);
		} else {
			throw new RuntimeException("unsupported token: " + token.getClass().toString());
		}
		assert result != null : "Postcondition failed result!= null";

		Color backgroundColor = token.getBackgroundColor() != null ? token.getBackgroundColor() : Color.WHITE;
		result.setAttribute(TOKEN_BACKGROUND_COLOR, backgroundColor.getCssValue());
		result.setAttribute(LOCKEDLAYOUT, Boolean.toString(token.isLayoutLocked()));
		result.setAttribute(LOCKEDCONTENT, Boolean.toString(token.isContentLocked()));

		if (token instanceof TextbasedToken) {
			result.setAttribute(TEXTBASED_TOKEN_TEXT_BOX_COLOR,
					((TextbasedToken) token).getTextBackgroundColor().getCssValue());
		}

		return result;
	}

	private Element createVideoTokenElement(VideoToken token) {
		Element tokenElement = new Element(TOKEN);

		tokenElement.setAttribute(TOKEN_TYPE, VIDEO_TOKEN);
		tokenElement.setAttribute(TOKEN_ID, token.getId().toString());
		if (token.getUrl() == null) {
			tokenElement.setAttribute(VIDEO_TOKEN_URL, "");
		} else {
			tokenElement.setAttribute(VIDEO_TOKEN_URL, token.getUrl());
		}
		tokenElement.setAttribute(VIDEO_TOKEN_URL_VISIBILITY, Boolean.toString(token.isUrlVisible()));
		tokenElement.setAttribute(VIDEO_TOKEN_WIDTH, Integer.toString(token.getWidth()));
		tokenElement.setAttribute(VIDEO_TOKEN_HEIGHT, Integer.toString(token.getHeight()));
		tokenElement.setAttribute(VIDEO_TOKEN_COLOR, token.getBackgroundColor().getCssValue());

		return tokenElement;
	}

	private Element createImageTokenElement(ImageToken token) {
		Element tokenElement = new Element(TOKEN);

		tokenElement.setAttribute(TOKEN_TYPE, IMAGE_TOKEN);
		tokenElement.setAttribute(TOKEN_ID, token.getId().toString());
		if (token.getUrl() == null) {
			tokenElement.setAttribute(IMAGE_TOKEN_URL, "");
		} else {
			tokenElement.setAttribute(IMAGE_TOKEN_URL, token.getUrl());
		}
		tokenElement.setAttribute(IMAGE_TOKEN_WIDTH, Integer.toString(token.getWidth()));
		tokenElement.setAttribute(IMAGE_TOKEN_HEIGHT, Integer.toString(token.getHeight()));
		tokenElement.setAttribute(IMAGE_TOKEN_COLOR, token.getBackgroundColor().getCssValue());

		return tokenElement;
	}

	private Element createTagTokenElement(TagToken token) {
		Element tokenElement = new Element(TOKEN);

		tokenElement.setAttribute(TOKEN_TYPE, TAG_TOKEN);
		tokenElement.setAttribute(TOKEN_ID, token.getId().toString());
		tokenElement.setAttribute(TAG_TOKEN_DESCRIPTION, token.getDescription());
		tokenElement.setAttribute(TAG_TOKEN_SUGGESTIONS, token.getItemListString());
		tokenElement.setAttribute(TAG_TOKEN_SELECTED_TAGS, token.getSelectedItemString());
		tokenElement.setAttribute(TAG_TOKEN_DESCRIPTION_WIDTH, Integer.toString(token.getDescriptionWidth_PX()));
		tokenElement.setAttribute(TAG_TOKEN_INPUT_WIDTH, Integer.toString(token.getInputWidth_PX()));
		tokenElement.setAttribute(TAG_TOKEN_HEIGHT, Integer.toString(token.getHeight()));
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_NAME, token.getStyle().getFont().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_STYLE, token.getStyle().getFontStyle().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_WEIGHT, token.getStyle().getFontWeight().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_SIZE,
				Integer.toString(token.getStyle().getFontSize().getSize()));
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_COLOR, token.getFontColor().getCssValue());
		tokenElement.setAttribute(LOCKEDCONTENT, Boolean.toString(token.isContentLocked()));
		tokenElement.setAttribute(LOCKEDLAYOUT, Boolean.toString(token.isLayoutLocked()));

		return tokenElement;
	}

	private Element createSignItemTokenElement(SignItemToken token) {
		Element tokenElement = new Element(TOKEN);
		tokenElement.setAttribute(TOKEN_TYPE, SIGN_ITEM_TOKEN);
		tokenElement.setAttribute(TOKEN_ID, token.getId().toString());
		tokenElement.setAttribute(SIGN_ITEM_TOKEN_SIGN_LOCALE, token.getLocale().name());
		tokenElement.setAttribute(TEXTBASED_TOKEN_VALUE, token.getText());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_NAME, token.getStyle().getFont().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_STYLE, token.getStyle().getFontStyle().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_WEIGHT, token.getStyle().getFontWeight().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_SIZE,
				Integer.toString(token.getStyle().getFontSize().getSize()));
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_COLOR, token.getFontColor().getCssValue());

		SignItem signItem = token.getSignItem();
		if (signItem != null) {
			tokenElement.addContent(createSignItemElement(signItem));
		}
		return tokenElement;
	}

	private Element createFrameTokenElement(FrameToken token) {
		Element tokenElement = new Element(TOKEN);

		tokenElement.setAttribute(TOKEN_TYPE, FRAME_TOKEN);
		tokenElement.setAttribute(TOKEN_ID, token.getId().toString());
		tokenElement.setAttribute(FRAME_TOKEN_BORDER_WIDTH, Integer.toString(token.getBorderWidth_PX()));
		tokenElement.setAttribute(FRAME_TOKEN_WIDTH, Integer.toString(token.getWidth()));
		tokenElement.setAttribute(FRAME_TOKEN_HEIGHT, Integer.toString(token.getHeight()));
		tokenElement.setAttribute(FRAME_TOKEN_COLOR, token.getFrameColor().getCssValue());

		return tokenElement;
	}

	private Element createFreeTextTokenElement(FreeTextToken token) {
		Element tokenElement = new Element(TOKEN);

		tokenElement.setAttribute(TOKEN_TYPE, FREE_TEXT_TOKEN);
		tokenElement.setAttribute(TOKEN_ID, token.getId().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_TEXT, token.getText());
		tokenElement.setAttribute(FREE_TEXT_TOKEN_HAS_FIXED_WIDTH, token.hasFixedWidth().toString());
		tokenElement.setAttribute(FREE_TEXT_TOKEN_WIDTH, Integer.toString(token.getWidth()));
		tokenElement.setAttribute(FREE_TEXT_TOKEN_IS_LINE, "" + token.isFreeTextLine());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_NAME, token.getStyle().getFont().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_STYLE, token.getStyle().getFontStyle().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_WEIGHT, token.getStyle().getFontWeight().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_SIZE,
				Integer.toString(token.getStyle().getFontSize().getSize()));
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_COLOR, token.getFontColor().getCssValue());
		tokenElement.setAttribute(FREE_TEXT_TOKEN_VISIBILITY, "" + token.isVisible());

		return tokenElement;
	}

	private Element createFormTokenElement(FormToken token) {
		Element tokenElement = new Element(TOKEN);

		tokenElement.setAttribute(TOKEN_TYPE, FORM_TOKEN);
		tokenElement.setAttribute(FORM_TOKEN_ID, token.getId().toString());
		tokenElement.setAttribute(FORM_TOKEN_DESCRIPTION, token.getDescription());
		tokenElement.setAttribute(FORM_TOKEN_INPUT, token.getInputContent());
		tokenElement.setAttribute(FORM_TOKEN_PATTERN, token.getPattern());
		tokenElement.setAttribute(FORM_TOKEN_CONTENT_EXPLANATION, token.getContentExplanation());
		tokenElement.setAttribute(FORM_TOKEN_DESCRIPTION_WIDTH, Integer.toString(token.getDescriptionWidthPx()));
		tokenElement.setAttribute(FORM_TOKEN_INPUT_WIDTH, Integer.toString(token.getInputWidthPx()));
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_NAME, token.getStyle().getFont().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_STYLE, token.getStyle().getFontStyle().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_WEIGHT, token.getStyle().getFontWeight().toString());
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_SIZE,
				Integer.toString(token.getStyle().getFontSize().getSize()));
		tokenElement.setAttribute(TEXTBASED_TOKEN_FONT_COLOR, token.getFontColor().getCssValue());
		tokenElement.setAttribute(LOCKEDCONTENT, Boolean.toString(token.isContentLocked()));
		tokenElement.setAttribute(LOCKEDLAYOUT, Boolean.toString(token.isLayoutLocked()));

		return tokenElement;
	}

	private Element createDateFormTokenElement(DateFormToken token) {
		Element tokenElement = createFormTokenElement(token);

		tokenElement.setAttribute(TOKEN_TYPE, DATE_FORM_TOKEN);
		tokenElement.setAttribute(FORM_TOKEN_PATTERN, token.getPattern());

		return tokenElement;
	}

	private Element createUrlFormTokenElement(UrlFormToken token) {
		Element tokenElement = createFormTokenElement(token);

		tokenElement.setAttribute(TOKEN_TYPE, URL_FORM_TOKEN);
		tokenElement.setAttribute(FORM_TOKEN_PATTERN, token.getPattern());

		return tokenElement;
	}

	private Element createSignItemElement(SignItem signItem) {
		Element signElement = new Element(SIGN_ITEM);

		SignId signId = signItem.getSignId();
		signElement.setAttribute(SIGN_UPPER_ID, Long.toString(signId.getUpperIdPart()));
		signElement.setAttribute(SIGN_LOWER_ID, signId.getLowerIdPart());
		signElement.setAttribute(SIGN_REGION, signId.getSignLocale().name());
		signElement.setAttribute(SIGN_WIDTH, Long.toString(signItem.getSignWidth()));
		signElement.setAttribute(SIGN_SOURCE, signId.getSignSource().name());

		return signElement;
	}

	private Element createSignElement(SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";

		Element signElement = new Element(SIGN);

		signElement.setAttribute(SIGN_AUTHOR, sign.getAuthor().getUsername());
		signElement.setAttribute(SIGN_REGION, sign.getSignLocale().name());
		signElement.setAttribute(SIGN_MEANING, sign.getSignId().getLowerIdPart());
		signElement.setAttribute(SIGN_ID, Long.toString(sign.getSignId().getUpperIdPart()));
		signElement.setAttribute(SIGN_SOURCE, sign.getSignId().getSignSource().name());
		signElement.setAttribute(SIGN_MDT, Long.toString(sign.getModificationDate().getTime()));
		signElement.setAttribute(SIGN_COMMENT, sign.getComment());

		Element symbolsElement = new Element(SYMBOLS);

		for (PositionedSymbol symbol : sign.getOtherSymbols()) {
			symbolsElement.addContent(createPositionedSymbolElement(symbol));
		}

		signElement.addContent(symbolsElement);

		Element headSymbolsElement = new Element(HEAD_SYMBOLS_ELEMENT);

		for (HeadSymbol headSymbol : sign.getHeadSymbols()) {
			headSymbolsElement.addContent(createHeadSymbolElement(headSymbol));
		}

		signElement.addContent(headSymbolsElement);

		Element disarrangedHeadSymbolsElement = new Element(HEAD_SYMBOLS_DISARRANGED_ELEMENT);

		for (HeadSymbol headSymbol : sign.getDisarrangedHeadSymbols()) {
			disarrangedHeadSymbolsElement.addContent(createHeadSymbolElement(headSymbol));
		}

		signElement.addContent(disarrangedHeadSymbolsElement);

		Element handSymbolsElement = new Element(HAND_SYMBOLS_ELEMENT);

		for (PositionedSymbol symbol : sign.getHandSymbols()) {
			handSymbolsElement.addContent(createPositionedSymbolElement(symbol));
		}

		signElement.addContent(handSymbolsElement);

		Element fingerAlphabetSymbolsElement = new Element(FINGER_ALPHABET_SYMBOLS_ELEMENT);

		for (PositionedFingerAlphabetSymbol symbol : sign.getFingerAlphabetSymbols()) {
			fingerAlphabetSymbolsElement.addContent(createFingerAlphabetSymbolElement(symbol));
		}

		signElement.addContent(fingerAlphabetSymbolsElement);

		return signElement;
	}

	private Element createFingerAlphabetSymbolElement(PositionedFingerAlphabetSymbol symbol) {

		Element result = createPositionedSymbolElement(symbol, FINGER_ALPHABET_SYMBOL_ELEMENT);

		FingerAlphabet fingerAlphabet = symbol.getFingerAlphabetSymbol();

		Element elementFingerAlphabet = new Element(FINGER_ALPHABET_SYMBOL);

		elementFingerAlphabet.addContent(fingerAlphabet.getIswaSymbol().toString());
		result.addContent(elementFingerAlphabet);

		return result;
	}

	private Element createHeadSymbolElement(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		Element result = new Element(HEAD_SYMBOL_ELEMENT);

		result.setAttribute(SYMBOL_X, Integer.toString(headSymbol.getX()));
		result.setAttribute(SYMBOL_Y, Integer.toString(headSymbol.getY()));
		result.setAttribute(SYMBOL_Z, Integer.toString(headSymbol.getZ()));

		result.setAttribute(HEAD_SYMBOL_FREE_POSITIONABLE_ATTRIBUTE, Boolean.toString(headSymbol.isFreePositionable()));

		Element eyes = new Element(HEAD_SYMBOL_EYES_ATTRIBUTE);
		for (PositionedEyeSymbol eyeSymbol : headSymbol.getPositionedEyeSymbols()) {
			eyes.addContent(createPositionedSymbolElement(eyeSymbol));
		}
		result.addContent(eyes);

		Element cheeks = new Element(HEAD_SYMBOL_CHEEKS_ATTRIBUTE);
		for (PositionedCheekSymbol cheekSymbol : headSymbol.getPositionedCheekSymbols()) {
			cheeks.addContent(createPositionedSymbolElement(cheekSymbol));
		}
		result.addContent(cheeks);

		Element ears = new Element(HEAD_SYMBOL_EARS_ATTRIBUTE);
		for (PositionedEarsSymbol earSymbol : headSymbol.getPositionedEarSymbols()) {
			ears.addContent(createPositionedSymbolElement(earSymbol));
		}
		result.addContent(ears);

		Element breath = new Element(HEAD_SYMBOL_BREATH_ATTRIBUTE);
		for (PositionedBreathSymbol breathSymbol : headSymbol.getPositionedBreathSymbols()) {
			breath.addContent(createPositionedSymbolElement(breathSymbol));
		}
		result.addContent(breath);

		Element jaws = new Element(HEAD_SYMBOL_JAW_ATTRIBUTE);
		for (PositionedJawSymbol jawSymbol : headSymbol.getPositionedJawSymbols()) {
			jaws.addContent(createPositionedSymbolElement(jawSymbol));
		}
		result.addContent(jaws);

		result.addContent(
				createPositionedSymbolElement(headSymbol.getPositionedNeckSymbol(), HEAD_SYMBOL_NECK_ATTRIBUTE));
		result.addContent(
				createPositionedSymbolElement(headSymbol.getPositionedNoseSymbol(), HEAD_SYMBOL_NOSE_ATTRIBUTE));
		result.addContent(createPositionedSymbolElement(headSymbol.getPositionedExpressionSymbol(),
				HEAD_SYMBOL_EXPRESSION_ATTRIBUTE));
		result.addContent(
				createPositionedSymbolElement(headSymbol.getPositionedHairSymbol(), HEAD_SYMBOL_HAIR_ATTRIBUTE));
		result.addContent(
				createPositionedSymbolElement(headSymbol.getPositionedMouthSymbol(), HEAD_SYMBOL_MOUTH_ATTRIBUTE));
		result.addContent(createPositionedSymbolElement(headSymbol.getPositionedHeadPostureSymbol(),
				HEAD_SYMBOL_HEAD_POSTURE_ATTRIBUTE));

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private Element createPositionedSymbolElement(PositionedSymbol symbol) {
		return createPositionedSymbolElement(symbol, POSITIONED_SYMBOL);
	}

	private Element createPositionedSymbolElement(PositionedSymbol symbol, String symbolKey) {
		assert symbol != null : "Precondition failed: symbol != null";

		Element result = new Element(symbolKey);

		Element idElement = new Element(ISWA_ID);
		Element xElement = new Element(SYMBOL_X);
		Element yElement = new Element(SYMBOL_Y);
		Element zElement = new Element(SYMBOL_Z);
		Element colorCodeElementForFormerBlack = new Element(POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_BLACK);
		Element colorCodeElementForFormerWhite = new Element(POSITIONED_SYMBOL_COLOR_CODE_FOR_FORMER_WHITE);

		idElement.setText(symbol.getSymbol().toString());
		xElement.setText(Integer.toString(symbol.getX()));
		yElement.setText(Integer.toString(symbol.getY()));
		zElement.setText(Integer.toString(symbol.getZ()));
		colorCodeElementForFormerBlack.setText(symbol.getLineColor().getCssValue());
		colorCodeElementForFormerWhite.setText(symbol.getFillColor().getCssValue());

		result.addContent(xElement);
		result.addContent(yElement);
		result.addContent(zElement);
		result.addContent(idElement);
		result.addContent(colorCodeElementForFormerBlack);
		result.addContent(colorCodeElementForFormerWhite);

		if (symbol instanceof Locatable) {
			Element locationElement = new Element(LOCATION);
			Location location = ((Locatable) symbol).getLocation();
			locationElement.setText(location.name());
			result.addContent(locationElement);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

}