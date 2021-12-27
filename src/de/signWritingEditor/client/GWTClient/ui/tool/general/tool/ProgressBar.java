package de.signWritingEditor.client.GWTClient.ui.tool.general.tool;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

public class ProgressBar extends Widget {

	private final Element progress;
	private String text;

	public ProgressBar(double value, double max) {
		assert max != 0;

		progress = DOM.createElement("progress");
		progress.setAttribute("max", Double.toString(max));
		progress.setAttribute("value", Double.toString(value));

		setElement(progress);
	}

	public void setProgress(double percentage) {
		progress.setAttribute("value", Double.toString(percentage));
		text = "" + Math.floor(percentage * 100) + " %";
	}

	public String getText() {
		return text;
	}
}
