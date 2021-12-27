package de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial;

import com.google.gwt.dom.client.MediaElement;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class TutorialVideoElement extends TutorialWidgetElement {

	private String videoFile;
	private String videoName;

	// videoFile without ending
	public TutorialVideoElement(String videoName, String videoFile, TutorialNavigationListener listener) {
		super(listener);
		this.videoName = videoName;
		createVideo(videoFile);
		this.headerLabel = new Label(videoName);
		this.navigationLabel = new Label(videoName);
		this.navigationLabel.getElement().getStyle().setCursor(Cursor.POINTER);
		this.headerLabel.getElement().getStyle().setCursor(Cursor.POINTER);
		navigationLabel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onNavigationChanged();
			}
		});

		this.videoFile = videoFile;
	}

	protected void onNavigationChanged() {
		listener.onNavigationChanged(headerLabel, navigationLabel, tutorialWidget);
	}

	private void createVideo(String videoFile) {
		Video video = Video.createIfSupported();
		video.setControls(true);
		video.setPoster(videoFile + ".jpg");
		video.setWidth("100%");
		video.setHeight("100%");
		video.setPreload(MediaElement.PRELOAD_NONE);
		video.addSource(videoFile + ".mp4");
		video.addSource(videoFile + ".webm");
		video.addSource(videoFile);
		this.tutorialWidget = video;
	}

	@Override
	public Widget getWidget() {
		if (tutorialWidget == null) {
			createVideo(videoFile);
		}
		return tutorialWidget;
	}

	@Override
	public String getName() {
		return videoName;
	}

	@Override
	public Widget getHeaderLabel() {
		return headerLabel;
	}

	@Override
	public Widget getNavigationLabel() {
		return navigationLabel;
	}

	public interface TutorialNavigationListener {

		void setCategory(Label categoryLabel);

		void onNavigationChanged(Label headerLabel, Label navigationLabel, Widget tutorialElement);
	}
}
