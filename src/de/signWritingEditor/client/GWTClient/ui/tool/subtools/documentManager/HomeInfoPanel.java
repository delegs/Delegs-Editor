package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.shared.model.domainValue.Orientation;

public class HomeInfoPanel extends Composite {

	public HomeInfoPanel() {

		OrientedFlowPanel mainPanel = new OrientedFlowPanel(Orientation.VERTICAL);
		initWidget(mainPanel);
		setStyleName("roomInfoPanel");

		Image roomIcon = new Image(Resources.RESOURCE.getIconHomeBig());
		roomIcon.setStyleName("homeIcon");
		mainPanel.add(roomIcon);

		FlowPanel floatPanel = new OrientedFlowPanel(Orientation.VERTICAL);
		mainPanel.add(floatPanel);

		Label roomNameLabel = new Label(I18N.getRootFolderName());
		roomNameLabel.setStyleName("homeLabel");
		floatPanel.add(roomNameLabel);

	}

}
