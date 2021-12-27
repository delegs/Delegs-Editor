package de.signWritingEditor.client.GWTClient.ui.tool.subtools.pdfViewer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ButtonBar;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.Tool;
import de.signWritingEditor.shared.model.material.PdfFileItem;

public class PdfViewer implements Tool {

	private HorizontalPanel mainPanel;
	private String pdfPath;

	private PdfViewerButtonBar buttonBar;

	public PdfViewer() {
		this.mainPanel = new HorizontalPanel();
		mainPanel.setWidth("100%");
		mainPanel.setHeight("100%");
		this.pdfPath = null;
		buttonBar = new PdfViewerButtonBar();
	}

	public void loadPdf(PdfFileItem document) {
		this.pdfPath = GWT.getModuleBaseURL().replaceAll(GWT.getModuleName() + "/", "") + document.getPath()
				+ document.getFileTitle().getTitleString() + ".pdf&lehrmaterialie=true";
		Frame frame = new Frame(this.pdfPath);
		frame.setHeight("100%");
		frame.setWidth("100%");
		frame.addStyleName("iFrame");
		mainPanel.add(frame);
	}

	@Override
	public Widget getPanel() {
		return mainPanel;
	}

	@Override
	public ButtonBar getButtonBar() {
		return buttonBar;
	}

	@Override
	public int getButtonBarPosition() {
		return 1;
	}

	@Override
	public String getTitle() {
		return this.pdfPath;
	}

	@Override
	public boolean hasUnsavedChanges() {
		return false;
	}

	@Override
	public void logout() {
		

	}

	@Override
	public void open() {
		

	}

	@Override
	public void close() {
		mainPanel.clear();
	}

	@Override
	public void handleSave(SavingFinishedListener listener) {
		

	}

	@Override
	public Image getIcon() {
		
		return null;
	}

	@Override
	public boolean hasHistorySupport() {
		return false;
	}

	@Override
	public void discardChanges() {
		

	}

}