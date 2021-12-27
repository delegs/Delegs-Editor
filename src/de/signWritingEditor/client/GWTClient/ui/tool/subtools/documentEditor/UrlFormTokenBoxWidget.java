package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.user.client.Window;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.layout.UrlFormTokenBox;

public class UrlFormTokenBoxWidget extends FormTokenBoxWidget {

	public UrlFormTokenBoxWidget(UrlFormTokenBox urlFormTokenBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		super(urlFormTokenBox, eventTranslator, fontSizeService);

		displayShortendLink();

		inputTextBox.addBlurHandler(event -> {
			displayShortendLink();
		});

		inputTextBox.addFocusHandler(event -> {
			displayFullLink();
		});

		inputTextBox.addClickHandler(event -> {
			if (event.getNativeEvent().getCtrlKey()) { // Ctrl + left click
				Window.open(((UrlFormTokenBox) formTokenBox).getInputContent(), "_blank", null);
			}
		});

	}

	private void updateToolTip() {
		inputTextBox.getElement().setAttribute("title",
				I18NAccess.I18N.getCLickCtrlLeftToOpen() + ((UrlFormTokenBox) formTokenBox).getInputContent());
	}

	private void displayFullLink() {
		inputTextBox.setText(formTokenBox.getInputContent());
		inputTextBox.removeStyleName("urlBoxHyperlink");
		inputTextBox.getElement().setPropertyString("pattern", ((UrlFormTokenBox) formTokenBox).getPattern());
	}

	private void displayShortendLink() {
		if (inputTextBox.getText().matches(((UrlFormTokenBox) formTokenBox).getPattern())) {
			inputTextBox.setText(((UrlFormTokenBox) formTokenBox).getShortenedLink());
			inputTextBox.addStyleName("urlBoxHyperlink");
			inputTextBox.getElement().setPropertyString("pattern",
					((UrlFormTokenBox) formTokenBox).getDefaultPattern());
			updateToolTip();
		} else {
			inputTextBox.getElement().removeAttribute("title");
			inputTextBox.getElement().setPropertyString("pattern", ((UrlFormTokenBox) formTokenBox).getPattern());
		}
	}

}
