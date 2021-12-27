package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public abstract class NewDocumentDialogBox extends FormDialogBox {
	private TextBox documentTitleTextBox;
	private ListBox signLocaleListBox;
	private ListBox choosePageFormatBox;

	public NewDocumentDialogBox(SignLocale defaultSignLocale) {
		super(I18N.getNewDocument(), I18N.getNewFile());

		assert defaultSignLocale != null : "Precondition failed: defaultSignLocale != null";

		// TextBox to enter document name:
		documentTitleTextBox = new TextBox();
		documentTitleTextBox.setText(new FileTitle(I18N.getNewDocument()).getTitleString());
		documentTitleTextBox.ensureDebugId("documentTitleTextBox");
		addInputField(I18N.getDocumentName() + ":", documentTitleTextBox);

		signLocaleListBox = createSignLocaleListBox(defaultSignLocale);
		addInputField(I18N.getSignLocaleDescription() + ":", signLocaleListBox);

		choosePageFormatBox = createPageFormatListBox();
		addInputField(I18N.getPageFormatDescription() + ":", choosePageFormatBox);
	}

	@Override
	public void center() {
		super.center();

		documentTitleTextBox.setSelectionRange(0, documentTitleTextBox.getText().length());
		documentTitleTextBox.setFocus(true);
	}

	protected ListBox createPageFormatListBox() {
		ListBox result = new ListBox();

		for (PageFormat pageFormat : PageFormat.DEFAULTS) {
			result.addItem(pageFormat.getDisplayName());
		}

		result.setSelectedIndex(0);
		result.setVisibleItemCount(1);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	protected ListBox createSignLocaleListBox(SignLocale defaultSignLocale) {
		assert defaultSignLocale != null : "Precondition failed: defaultSignLocale != null";

		ListBox result = new ListBox();

		int selectedIndex = 0;

		for (int i = 0, l = SignLocale.values().length; i < l; i++) {
			SignLocale signLocale = SignLocale.values()[i];

			result.addItem(signLocale.name() + " (" + signLocale.getLongForm() + ")");

			if (signLocale.equals(defaultSignLocale)) {
				selectedIndex = i;
			}
		}

		result.setSelectedIndex(selectedIndex);
		result.setVisibleItemCount(1);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	protected void handleSubmit() {
		String documentTitleInput = documentTitleTextBox.getText();

		if (FileTitle.isValidTitle(documentTitleInput)) {
			handleNewDocument(new FileTitle(documentTitleInput),
					PageFormat.DEFAULTS[choosePageFormatBox.getSelectedIndex()],
					SignLocale.values()[signLocaleListBox.getSelectedIndex()]);
			hide();
		} else {
			new MessageDialogBox(I18N.getNote(), I18N.getPleaseEnterValidFileName()).center();
		}
	}

	protected abstract void handleNewDocument(FileTitle fileTitle, PageFormat pageFormat, SignLocale signLocale);
}
