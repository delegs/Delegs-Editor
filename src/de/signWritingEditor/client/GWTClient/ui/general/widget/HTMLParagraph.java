package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class HTMLParagraph extends Widget implements HasText {

	public HTMLParagraph() {
		setElement(DOM.createElement("p"));
	}

	public HTMLParagraph(String text) {
		this();
		setText(text);
	}

	public String getText() {
		return getElement().getInnerText();
	}

	public void setText(String text) {
		getElement().setInnerText(text);
	}
}
