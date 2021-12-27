package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class CursorImplTrident extends AbstractCursorImpl {

	@Override
	protected Widget createCursor(TextArea textBox) {
		SpanPanel outerSpan = new SpanPanel();
		outerSpan.setStyleName("cursor");
		Style outerSpanStyle = outerSpan.getElement().getStyle();
		outerSpanStyle.setDisplay(Display.INLINE_BLOCK);
		outerSpanStyle.setPosition(Position.RELATIVE);
		outerSpan.setWidth("0px");
		outerSpan.setHeight("14px");

		SimplePanel cutPanel = new SimplePanel();
		cutPanel.setWidth("1px");
		Style cutPanelStyle = cutPanel.getElement().getStyle();
		cutPanelStyle.setOverflow(Overflow.HIDDEN);
		cutPanelStyle.setPosition(Position.ABSOLUTE);
		cutPanelStyle.setLeft(0, Unit.PX);
		cutPanelStyle.setTop(2, Unit.PX);
		outerSpan.add(cutPanel);

		textBox.setStyleName("cursor");
		textBox.setTabIndex(-1);
		Style textBoxStyle = textBox.getElement().getStyle();
		textBoxStyle.setMargin(0, Unit.PX);
		textBoxStyle.setPadding(0, Unit.PX);
		textBoxStyle.setBorderStyle(BorderStyle.NONE);
		textBoxStyle.setBackgroundColor("transparent");
		textBoxStyle.setProperty("outline", "none");
		textBox.setWidth("20px");

		cutPanel.add(textBox);
		return outerSpan;
	}
}
