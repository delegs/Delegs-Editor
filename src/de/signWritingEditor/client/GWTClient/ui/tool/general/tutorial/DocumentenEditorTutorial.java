package de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial.TutorialVideoElement.TutorialNavigationListener;

public class DocumentenEditorTutorial implements TutorialPart {

	private static final String SIGN_UP = "Registrieren.mov";
	private static final String LOGIN = "Anmelden.mov";// !!!
	private static final String CREATE_NEW_DOCUMENT = "Dokumenterstellen.mov";
	private static final String SAVE_DOCUMENT = "DokumentSpeichern.mov";
	private static final String CHANGE_LINE_VISIBILITY = "Zeilen.mov";
	private static final String GLOSSWRITING_AUTOMATIC_FREETEXTLINE = "Zeilen22.mov";
	private static final String INSERT_DELETE_AND_RISIZE_TOKEN = "DokBearbeitenAb1.mov";
	private static final String FONT_FORMATING = "DokBearbeitenAb2.mov";
	private static final String CREATE_PDF = "PDFErzeugen.mov";
	private static final String ADD_SIGNTOKEN = "GebaerdeHinzufuegen.mov";
	private static final String CHANGE_SIGN_BACKGROUND = "GebaerdenhintergrundWaehlen.mov";
	private static final String CHANGE_SIGNWORD_VISIBILITY = "GebaerdenschriftzeileEinAus.mov";
	private static final String GLOSSWRITING_ON_OFF = "GlossenschriftEinAus.mov";
	private static final String ADD_NEW_PAGE = "NeueSeite.mov";
	private static final String CHANGE_FONT_STYLE = "SchriftartAnpassen.mov";
	private static final String TOGGLE_SEARCHWORD_VISIBILITY = "SuchwortzeileEinAus.mov";
	private static final String ADD_TEXTBOX = "TextboxHinzufuegen.mov";
	private static final String CHANGE_FONT_COLOR = "TextfarbeWaehlen.mov";
	private static final String CHANGE_FONT_BACKGROUND_COLOR = "TexthintergrundWaehlen.mov";
	private static final String CHANGE_SIGN_VARIATION = "Varianten.mov";
	private static final String COLLAGE = "Collagen.mov";
	private static final String BADGE = "Abzeichen.mov";

	private List<TutorialVideoElement> videoList;
	private String path;

	public DocumentenEditorTutorial(String pathToTheVideo, TutorialNavigationListener listener) {
		this.path = pathToTheVideo;
		listener.setCategory(new Label(I18N.getDocumentEditor()));
		videoList = new ArrayList<TutorialVideoElement>();

		videoList.add(new TutorialVideoElement(I18N.getSignUp(), path + SIGN_UP, listener));
		videoList.add(new TutorialVideoElement(I18N.getLogin(), path + LOGIN, listener));
		videoList.add(new TutorialVideoElement(I18N.getCreateNewDocument(), path + CREATE_NEW_DOCUMENT, listener));
		videoList.add(new TutorialVideoElement(I18N.getSaveDocument(), path + SAVE_DOCUMENT, listener));
		videoList
				.add(new TutorialVideoElement(I18N.getChangeLineVisibility(), path + CHANGE_LINE_VISIBILITY, listener));
		videoList.add(new TutorialVideoElement(I18N.getGlossWritingAndAutomaticFreeTextLine(),
				path + GLOSSWRITING_AUTOMATIC_FREETEXTLINE, listener));
		videoList.add(new TutorialVideoElement(I18N.getInsertDeleteAndResizeToken(),
				path + INSERT_DELETE_AND_RISIZE_TOKEN, listener));
		videoList.add(new TutorialVideoElement(I18N.getFontFormating(), path + FONT_FORMATING, listener));
		videoList.add(new TutorialVideoElement(I18N.getDoCreatePdf(), path + CREATE_PDF, listener));
		videoList.add(new TutorialVideoElement(I18N.getAddSignToken(), path + ADD_SIGNTOKEN, listener));
		videoList
				.add(new TutorialVideoElement(I18N.getChangeSignBackground(), path + CHANGE_SIGN_BACKGROUND, listener));
		videoList.add(new TutorialVideoElement(I18N.getChangeSignwordVisibility(), path + CHANGE_SIGNWORD_VISIBILITY,
				listener));
		videoList.add(new TutorialVideoElement(I18N.getGlossWritingOnOff(), path + GLOSSWRITING_ON_OFF, listener));
		videoList.add(new TutorialVideoElement(I18N.getAddNewPage(), path + ADD_NEW_PAGE, listener));
		videoList.add(new TutorialVideoElement(I18N.getChangeFontStyle(), path + CHANGE_FONT_STYLE, listener));
		videoList.add(new TutorialVideoElement(I18N.getToggleSearchWordVisibility(),
				path + TOGGLE_SEARCHWORD_VISIBILITY, listener));
		videoList.add(new TutorialVideoElement(I18N.getAddTextbox(), path + ADD_TEXTBOX, listener));
		videoList.add(new TutorialVideoElement(I18N.getChangeFontColor(), path + CHANGE_FONT_COLOR, listener));
		videoList.add(new TutorialVideoElement(I18N.getChangeFontBackgroundColor(), path + CHANGE_FONT_BACKGROUND_COLOR,
				listener));
		videoList.add(new TutorialVideoElement(I18N.getChangeSignVartiation(), path + CHANGE_SIGN_VARIATION, listener));
		videoList.add(
				new TutorialVideoElement(I18N.getCollage(), path + COLLAGE, listener));
		videoList.add(new TutorialVideoElement(I18N.getBadge(), path + BADGE, listener));
	}

	@Override
	public TutorialWidgetElement getTutorialElement(int element) {
		return videoList.get(element);
	}

	@Override
	public int getLectionSize() {
		return videoList.size();
	}
}
