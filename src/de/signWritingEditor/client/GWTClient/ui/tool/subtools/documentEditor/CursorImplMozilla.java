package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class CursorImplMozilla extends CursorImplWebkit {

	@Override
	protected Widget createCursor(TextArea textBox) {
		SimplePanel outerSpan = new SimplePanel();
		outerSpan.setStyleName("cursor");
		Style outerSpanStyle = outerSpan.getElement().getStyle();
		outerSpanStyle.setDisplay(Display.INLINE_BLOCK);
		outerSpanStyle.setPosition(Position.RELATIVE);
		outerSpanStyle.setLeft(0, Unit.PX);
		outerSpanStyle.setTop(0, Unit.PX);
		outerSpan.setWidth("0px");
		outerSpan.setHeight("12px");

		textBox.setStyleName("cursor");
		textBox.setTabIndex(-1);
		Style textBoxStyle = textBox.getElement().getStyle();
		textBoxStyle.setMargin(0, Unit.PX);
		textBoxStyle.setPadding(0, Unit.PX);
		textBoxStyle.setBorderStyle(BorderStyle.NONE);
		textBoxStyle.setBackgroundColor("transparent");
		textBoxStyle.setProperty("outline", "none");
		textBoxStyle.setPosition(Position.ABSOLUTE);
		textBoxStyle.setLeft(-1, Unit.PX);
		textBoxStyle.setTop(0, Unit.PX);
		textBox.setWidth("1px");

		outerSpan.add(textBox);
		return outerSpan;
	}
}
