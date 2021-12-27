package de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial.TutorialVideoElement.TutorialNavigationListener;

public class SignEditorTutorial implements TutorialPart {

	private static final String OPEN_SIGN_EDITOR = "GebaerdeneditorOeffnen.mov";
	private static final String ADD_HEADSYMBOL = "KopfHinzufuegenUndLoeschen.mov";
	private static final String MANIPULATE_HEAD = "KopfBearbeiten.mov";
	private static final String POSITION_HEAD = "KoepfePositionieren.mov";
	private static final String ADD_VISMESYMBOL = "MundbildBearbeiten.mov";
	private static final String ADD_EYES = "AugenBearbeiten.mov";
	private static final String ADD_CHEEKS = "WangenBearbeiten.mov";
	private static final String ADD_BREATH = "AtemBearbeiten.mov";
	private static final String ADD_COLLECTION = "ExtrasBearbeiten.mov";
	private static final String ADD_HANDS = "HaendeHinzufuegen.mov";
	private static final String MANIPULATE_HANDS = "HaendeBearbeiten.mov";
	private static final String CHANGE_LAYER = "EbenenAendern.mov";
	private static final String CREATE_NAME_EXAMPLE = "GebaerdenNameErstellen.mov";
	private static final String FINGERALPHABET = "Fingeralphabet.mov";

	private List<TutorialVideoElement> videoList;
	private String path;

	public SignEditorTutorial(String pathToTheVideo, TutorialNavigationListener listener) {
		this.path = pathToTheVideo;
		listener.setCategory(new Label(I18N.getSignEditor()));
		videoList = new ArrayList<TutorialVideoElement>();
		videoList.add(new TutorialVideoElement(I18N.getOpenSignEditor(), path + OPEN_SIGN_EDITOR, listener));
		videoList.add(new TutorialVideoElement(I18N.getAddHeadSymbol(), path + ADD_HEADSYMBOL, listener));
		videoList.add(new TutorialVideoElement(I18N.getPositionHeadSymbols(), path + POSITION_HEAD, listener));
		videoList.add(new TutorialVideoElement(I18N.getEditViseme(), path + ADD_VISMESYMBOL, listener));
		videoList.add(new TutorialVideoElement(I18N.getEditEyes(), path + ADD_EYES, listener));
		videoList.add(new TutorialVideoElement(I18N.getEditHead(), path + MANIPULATE_HEAD, listener));
		videoList.add(new TutorialVideoElement(I18N.getEditCheeks(), path + ADD_CHEEKS, listener));
		videoList.add(new TutorialVideoElement(I18N.getEditBreath(), path + ADD_BREATH, listener));
		videoList.add(new TutorialVideoElement(I18N.getEditCollection(), path + ADD_COLLECTION, listener));
		videoList.add(new TutorialVideoElement(I18N.getAddHand(), path + ADD_HANDS, listener));
		videoList.add(new TutorialVideoElement(I18N.getEditHands(), path + MANIPULATE_HANDS, listener));
		videoList.add(new TutorialVideoElement(I18N.getChangeLayer(), path + CHANGE_LAYER, listener));
		videoList.add(new TutorialVideoElement(I18N.getCreateNameExample(), path + CREATE_NAME_EXAMPLE, listener));
		videoList.add(new TutorialVideoElement(I18N.getFingerAlphabet(), path + FINGERALPHABET, listener));
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
