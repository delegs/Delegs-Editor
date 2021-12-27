/**
 * 
 */
package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Label;

public class CharacterLabel extends Label {

	private static final String SELECTED = "selected";

	/**
	 * In IE \r\n or \n will not be reported through the normal
	 * getText()-method. So we have to deliver the correct text.
	 */
	private String text;

	public CharacterLabel(String text) {
		super(DOM.createSpan());
		setText(text);
		sinkEvents(Event.ONCLICK);
		sinkEvents(Event.ONMOUSEDOWN);
		sinkEvents(Event.ONMOUSEUP);
		sinkEvents(Event.ONMOUSEMOVE);
		getElement().getStyle().setHeight(100, Unit.PCT);
		getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);

	}

	/**
	 * 
	 * @require text != null
	 */
	@Override
	public void setText(String text) {
		assert text != null : "text != null";
		super.setText(text);
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}

	public void setSelection(boolean selected) {
		if (selected) {
			addStyleName(SELECTED);
		} else {
			removeStyleName(SELECTED);
		}
	}

	public boolean isSelected() {
		return getStyleName().matches(".*\\b" + SELECTED + "\\b.*");
	}

	protected void toggleSelection() {
		setSelection(!isSelected());
	}
}