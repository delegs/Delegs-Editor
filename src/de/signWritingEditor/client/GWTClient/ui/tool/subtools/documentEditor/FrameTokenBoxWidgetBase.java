package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.FrameTokenBox;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.TokenBox;

abstract public class FrameTokenBoxWidgetBase extends AbstractTokenBoxWidget {

	protected static final String RESIZE_BUTTON_SIZE = "10px";
	protected static final int CONTENT_PANEL_STANDARD_HEIGHT = 200;
	protected FrameTokenBox frameTokenBox;
	protected FlowPanel framePanel;
	protected SimplePanel contentPanel;
	protected SimplePanel selectionPanel;
	protected boolean isSelected;
	protected InvisibleTextArea invisbleKeyHandlingTextArea;

	public FrameTokenBoxWidgetBase(FrameTokenBox tokenBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		super();
		assert tokenBox != null : "Precondition failed: tokenBox != null";

		contentPanel = new SimplePanel();
		contentPanel.addStyleName("frameTokenBoxWidget");
		contentPanel.setHeight(CONTENT_PANEL_STANDARD_HEIGHT + "px");

		frameTokenBox = tokenBox;
		framePanel = new FlowPanel();
		framePanel.addStyleName("framePanel");

		selectionPanel = new SimplePanel();
		selectionPanel.setStyleName("frameTokenBoxSelection");
		isSelected = false;
		contentPanel.add(selectionPanel);

		setTokenBox(tokenBox);

		addResizeButtonToPanel(framePanel);

		invisbleKeyHandlingTextArea = new InvisibleTextArea(eventTranslator, fontSizeService);
		framePanel.add(invisbleKeyHandlingTextArea);

		selectionPanel.add(framePanel);

		initWidget(contentPanel);
	}

	@Override
	public Id getId() {
		return frameTokenBox.getId();
	}

	@Override
	public void focus() {
		invisbleKeyHandlingTextArea.setFocus(true);
	}

	@Override
	public void toggleSelection() {
		isSelected = !isSelected;

		if (isSelected) {
			selectionPanel.addStyleDependentName("selected");
			focus();
		} else {
			selectionPanel.removeStyleDependentName("selected");
		}
	}

	@Override
	public void setTokenBox(TokenBox tokenBox) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";
		assert tokenBox instanceof FrameTokenBox : "Precondition failed: tokenBox instanceof FrameTokenBox";

		this.frameTokenBox = (FrameTokenBox) tokenBox;

		int contentPanelWidth = (int) (frameTokenBox.getWidth_PX() - frameTokenBox.getMarginRight());
		int contentPanelHeight = frameTokenBox.getHeight_PX();

		if (contentPanelHeight < CONTENT_PANEL_STANDARD_HEIGHT) {
			contentPanelHeight = CONTENT_PANEL_STANDARD_HEIGHT;
		}
		this.contentPanel.setPixelSize(contentPanelWidth, contentPanelHeight);
		this.contentPanel.getElement().getStyle().setMarginRight(frameTokenBox.getMarginRight(), Unit.PX);

		int selectionPanelWidth = frameTokenBox.getTokenBoxWidth() + 2 * frameTokenBox.getSelectionBorderWidth();
		int selectionPanelHeight = frameTokenBox.getTokenBoxHeight() + 2 * frameTokenBox.getSelectionBorderWidth();
		selectionPanel.setPixelSize(selectionPanelWidth, selectionPanelHeight);

		int framePanelWidth = frameTokenBox.getTokenBoxWidth() - frameTokenBox.getBorderWidth_PX();
		int framePanelHeight = frameTokenBox.getTokenBoxHeight() - frameTokenBox.getBorderWidth_PX();
		framePanel.setPixelSize(framePanelWidth, framePanelHeight);

		framePanel.getElement().getStyle().setBorderWidth(frameTokenBox.getBorderWidth_PX(), Unit.PX);
		framePanel.getElement().getStyle().setBorderColor(frameTokenBox.getFrameColor().getCssValue());

		selectionPanel.getElement().getStyle().setBackgroundColor(frameTokenBox.getBackgroundColor().getCssValue());
	}

	public boolean isSelected() {
		return isSelected;
	}

	@Override
	public TokenBox getTokenBox() {
		return frameTokenBox;
	}

	@Override
	protected void setTokenBoxSize(int width, int height) {
		int newWidth = width <= frameTokenBox.getMaxWidth() ? width : frameTokenBox.getMaxWidth();
		newWidth = newWidth >= frameTokenBox.getMinWidth() ? newWidth : frameTokenBox.getMinWidth();
		int newHeight = height >= frameTokenBox.getMinHeight() ? height : frameTokenBox.getMinHeight();
		frameTokenBox.setWidth(newWidth);
		frameTokenBox.setHeight(newHeight);
		setTokenBox(frameTokenBox);
	}

	@Override
	protected boolean isResizeable() {
		return true;
	}

}
