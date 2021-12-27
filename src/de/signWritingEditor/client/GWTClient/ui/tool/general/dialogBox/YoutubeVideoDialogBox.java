package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial.TutorialMainPanel;

public class YoutubeVideoDialogBox extends ModalDialogBox {

	public YoutubeVideoDialogBox(String videoId, int width, int height) {
		assert videoId != null : "Precondition failed: videoId != null";
		assert width >= 0 : "Precondition failed: width >= 0";
		assert height >= 0 : "Precondition failed: height >= 0";

		AbsolutePanel mainPanel = new AbsolutePanel();
		mainPanel.setPixelSize(width, height);
		add(mainPanel);

		TutorialMainPanel tutorialWidget = new TutorialMainPanel(Unit.PX);
		mainPanel.add(tutorialWidget, 0, 0);

		Image closeImage = new Image(RESOURCE.getCloseButtonIcon());
		mainPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		mainPanel.add(closeImage, width - 5, -22);

		closeImage.getElement().getStyle().setCursor(Cursor.POINTER);
		closeImage.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// To prevent a black screen when removing youtube video in IE8

				YoutubeVideoDialogBox.this.hide();
				YoutubeVideoDialogBox.this.removeFromParent();
			}
		});

	}
}
