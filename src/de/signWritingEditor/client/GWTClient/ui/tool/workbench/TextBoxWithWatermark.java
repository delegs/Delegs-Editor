package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.TextBox;

public class TextBoxWithWatermark extends TextBox {
	private String watermark;

	public TextBoxWithWatermark(String watermarkText) {
		super();

		assert watermarkText != null : "Precondition failed: watermarkText != null";

		watermark = watermarkText;

		setStyleName("textBoxWithWatermark");

		displayWatermark();

		addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				handleBlur();
			}
		});

		addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				handleFocus();
			}
		});
	}

	private void handleFocus() {
		if (super.getText().equals(watermark)) {
			removeWatermark();
		}
	}

	private void handleBlur() {
		if (super.getText().equals("")) {
			displayWatermark();
		}
	}

	public void displayWatermark() {
		addStyleName("watermark");
		setText(watermark);
	}

	public void removeWatermark() {
		removeStyleName("watermark");
		setText("");
	}

	@Override
	public String getText() {
		String result = super.getText();

		if (result.equals(watermark)) {
			result = "";
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
