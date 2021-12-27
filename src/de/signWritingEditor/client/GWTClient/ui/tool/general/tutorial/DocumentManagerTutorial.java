package de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial.TutorialVideoElement.TutorialNavigationListener;

public class DocumentManagerTutorial implements TutorialPart {

	private List<TutorialVideoElement> videoList;
	private String path;

	private static final String COPY_DOCUMENT = "DateiKopieren.mov";
	private static final String RENAME_DOCUMENT = "DokumentUmbenennen.mov";
	private static final String CHANGE_DOCUMENT_LABEL_COLOR = "Farbetikette.mov";
	private static final String DELETE_DOCUMENT = "Loeschen.mov";
	private static final String CREATE_NEW_FOLDER = "NeuenOrdnerAnlegen.mov";
	private static final String SEARCH_FOR_DOCUMENT = "Suchen.mov";

	public DocumentManagerTutorial(String pathToVideo, TutorialNavigationListener listener) {
		path = pathToVideo;
		listener.setCategory(new Label(I18N.getDocumentManager()));
		videoList = new ArrayList<TutorialVideoElement>();
		videoList.add(new TutorialVideoElement(I18N.getCopyDocument(), path + COPY_DOCUMENT, listener));
		videoList.add(new TutorialVideoElement(I18N.getRenameDocument(), path + RENAME_DOCUMENT, listener));
		videoList.add(
				new TutorialVideoElement(I18N.getChangeColorLabel(), path + CHANGE_DOCUMENT_LABEL_COLOR, listener));
		videoList.add(new TutorialVideoElement(I18N.getDeleteDocument(), path + DELETE_DOCUMENT, listener));
		videoList.add(new TutorialVideoElement(I18N.getCreateNewFolder(), path + CREATE_NEW_FOLDER, listener));
		videoList.add(new TutorialVideoElement(I18N.getSearchForDocument(), path + SEARCH_FOR_DOCUMENT, listener));

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
