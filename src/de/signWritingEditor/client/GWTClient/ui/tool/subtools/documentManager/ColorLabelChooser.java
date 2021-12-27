package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;

public class ColorLabelChooser extends Composite {

	private ColorLabelChooserListener listener;

	public ColorLabelChooser(ColorLabelChooserListener listener) {
		assert listener != null : "Precondition failed: listener != null";

		this.listener = listener;

		FlowPanel mainPanel = new FlowPanel();
		mainPanel.setStyleName("colorLabelChooser");
		initWidget(mainPanel);

		for (FileItemColorLabel colorLabel : FileItemColorLabel.values()) {
			mainPanel.add(createColorLabelButton(colorLabel));
		}
	}

	private Widget createColorLabelButton(final FileItemColorLabel colorLabel) {
		assert colorLabel != null : "Precondition failed: colorLabel != null";

		SimplePanel result = new SimplePanel();
		result.setStyleName("button");
		result.addStyleName(colorLabel.getStyleName());

		result.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onColorLabelChosen(colorLabel);
			}
		}, ClickEvent.getType());
		result.sinkEvents(Event.ONCLICK);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public interface ColorLabelChooserListener {
		void onColorLabelChosen(FileItemColorLabel colorLabel);
	}
}
