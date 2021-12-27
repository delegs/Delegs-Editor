package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public class PagePanel extends AbsolutePanel {

	private static final String PAGE_PANEL_STYLE_NAME = "pagePanel";
	private static final String FOOTER_STYLE_NAME = "footer";
	private Label footerPageNumberLabel;
	private OrientedFlowPanel innerPagePanel;

	public PagePanel(PageFormat pageFormat, String footerText) {
		setStylePrimaryName(PAGE_PANEL_STYLE_NAME);

		getElement().getStyle().setPaddingTop(pageFormat.getPixelPaddingTop(), Unit.PX);
		getElement().getStyle().setPaddingRight(pageFormat.getPixelPaddingRight(), Unit.PX);
		getElement().getStyle().setPaddingBottom(pageFormat.getPixelPaddingBottom(), Unit.PX);
		getElement().getStyle().setPaddingLeft(pageFormat.getPixelPaddingLeft_PX(), Unit.PX);

		// Workaround to make sure that the UI page has exactly the same size as
		// the layout page:
		final int borderWidth = 1;
		getElement().getStyle().setBorderWidth(borderWidth, Unit.PX);
		setPixelSize(pageFormat.getPixelWidth() + 2 * borderWidth, pageFormat.getPixelHeight() + 2 * borderWidth);

		innerPagePanel = new OrientedFlowPanel(pageFormat.getOrientation());
		add(innerPagePanel);
		getElement().getStyle().setOverflow(Overflow.VISIBLE);

		Label footerTextLabel = new Label(footerText);
		footerTextLabel.setStyleName(FOOTER_STYLE_NAME);
		footerTextLabel.getElement().getStyle().setBottom(pageFormat.getPixelPaddingRight(), Unit.PX);
		footerTextLabel.getElement().getStyle().setLeft(pageFormat.getPixelPaddingLeft_PX(), Unit.PX);
		add(footerTextLabel);

		footerPageNumberLabel = new Label();
		footerPageNumberLabel.setStyleName(FOOTER_STYLE_NAME);
		footerPageNumberLabel.getElement().getStyle().setBottom(pageFormat.getPixelPaddingRight(), Unit.PX);
		int centerPosition = (pageFormat.getPixelWidth() - pageFormat.getPixelPaddingRight()
				+ pageFormat.getPixelPaddingLeft_PX()) / 2;
		footerPageNumberLabel.getElement().getStyle().setLeft(centerPosition, Unit.PX);
		footerPageNumberLabel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		add(footerPageNumberLabel);

		Label footerCopyrightLabel = new Label(I18N.getDelegsCopyright());
		footerCopyrightLabel.setStyleName(FOOTER_STYLE_NAME);
		footerCopyrightLabel.getElement().getStyle().setBottom(pageFormat.getPixelPaddingRight(), Unit.PX);
		footerCopyrightLabel.getElement().getStyle().setRight(pageFormat.getPixelPaddingRight(), Unit.PX);
		add(footerCopyrightLabel);
	}

	public void updateFooterPageNumbers(int pageIndex, int pageCount) {
		footerPageNumberLabel.setText((pageIndex + 1) + "/" + pageCount);
	}

	protected OrientedFlowPanel getInnerPagePanel() {
		return innerPagePanel;
	}
}
