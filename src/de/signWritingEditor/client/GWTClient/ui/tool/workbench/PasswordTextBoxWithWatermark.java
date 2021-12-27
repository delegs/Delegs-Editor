package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class PasswordTextBoxWithWatermark extends PasswordTextBox {
	private String watermark;

	public PasswordTextBoxWithWatermark(String watermarkText) {
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
		if (getText().equals(watermark)) {
			removeWatermark();
		}
	}

	private void handleBlur() {
		if (getText().equals("")) {
			displayWatermark();
		}
	}

	public void displayWatermark() {
		addStyleName("passwordWatermark");
		setText(watermark);
	}

	public void removeWatermark() {
		removeStyleName("passwordWatermark");
		setText("");
	}
}
