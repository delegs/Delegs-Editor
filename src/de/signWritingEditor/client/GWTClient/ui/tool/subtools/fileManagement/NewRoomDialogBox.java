package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.workbench.TextAreaWithWatermark;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.material.RoomPolicy;

public abstract class NewRoomDialogBox extends FormDialogBox {

	private static final int TEXTAREA_HEIGHT = 80;
	private static final int NEW_ROOM_DIALOG_ELEMENT_WIDTH = 138;

	private static final String USERNAME_SEPARATOR = ";";

	private TextBox titleTextBox;
	private ListBox roomPolicyListBox;
	private TextArea roomUsersTextBox;
	private TextArea roomOwnersTextBox;
	private TextArea roomDescriptionTextBox;
	private CheckBox hiddenCheckBox;

	public NewRoomDialogBox(String ownerName, boolean isAdmin) {
		super(I18N.getNewRoom(), I18N.getNewFile());

		titleTextBox = new TextBox();
		titleTextBox.setText(I18N.getNewRoom());
		addInputField(I18N.getRoomName() + ":", titleTextBox);

		roomPolicyListBox = createRoomPolicyListBox();
		addInputField(I18N.getRoomPolicy() + ":", roomPolicyListBox);
		roomPolicyListBox.setWidth(NEW_ROOM_DIALOG_ELEMENT_WIDTH + "px");

		String watermarkText = I18N.getUserName() + USERNAME_SEPARATOR + " " + I18N.getUserName() + USERNAME_SEPARATOR
				+ " ...";

		roomOwnersTextBox = new TextArea();
		addInputField(I18N.getResponsible() + ":", roomOwnersTextBox);
		roomOwnersTextBox.setTitle(I18N.getTooltipRoomOwnerTextBox());
		roomOwnersTextBox.setText(ownerName + ";");
		roomOwnersTextBox.getElement().getStyle().setProperty("resize", "none");
		roomOwnersTextBox.setPixelSize(NEW_ROOM_DIALOG_ELEMENT_WIDTH, TEXTAREA_HEIGHT);

		roomUsersTextBox = new TextAreaWithWatermark(watermarkText);
		addInputField(I18N.getRoomUsers() + ":", roomUsersTextBox);
		roomUsersTextBox.getElement().getStyle().setProperty("resize", "none");
		roomUsersTextBox.setPixelSize(NEW_ROOM_DIALOG_ELEMENT_WIDTH, TEXTAREA_HEIGHT);

		roomDescriptionTextBox = new TextArea();
		roomDescriptionTextBox.setText(I18N.getRoomDescription());
		addInputField(I18N.getRoomDescription() + ":", roomDescriptionTextBox);
		roomDescriptionTextBox.getElement().getStyle().setProperty("resize", "none");
		roomDescriptionTextBox.setPixelSize(NEW_ROOM_DIALOG_ELEMENT_WIDTH, TEXTAREA_HEIGHT);

		// Soll beim Entfernen der Rolle Admin mitentfern werden
		hiddenCheckBox = new CheckBox();
		hiddenCheckBox.setValue(true);
		if (isAdmin) {
			addInputField(I18N.getPrivateRoom(), hiddenCheckBox);
		}
	}

	@Override
	public void center() {
		super.center();

		titleTextBox.setSelectionRange(0, titleTextBox.getText().length());
		titleTextBox.setFocus(true);
	}

	@Override
	protected void handleSubmit() {
		final String roomNameInput = titleTextBox.getText();
		final RoomPolicy roomPolicy = RoomPolicy.values().get(roomPolicyListBox.getSelectedIndex());
		final List<String> roomOwnersNames = tokenizeUsernames(roomOwnersTextBox.getText());
		final List<String> roomUserNames = tokenizeUsernames(roomUsersTextBox.getText());
		final String roomDescription = roomDescriptionTextBox.getText();
		final boolean isHidden = hiddenCheckBox.getValue();

		if (FileTitle.isValidTitle(roomNameInput)) {
			// There must be at least one owner
			if (!roomOwnersNames.isEmpty()) {
				checkForRoomnameDuplications(roomNameInput, roomPolicy, roomOwnersNames, roomUserNames, isHidden,
						roomDescription);
			} else {
				new MessageDialogBox(I18N.getNote(), I18N.getPleaseEnterValidUsernames()).center();
			}
		} else {
			new MessageDialogBox(I18N.getNote(), I18N.getPleaseEnterValidRoomName()).center();
		}
	}

	protected abstract void checkForRoomnameDuplications(String roomNameInput, RoomPolicy roomPolicy,
			List<String> roomOwnersNames, List<String> roomUserNames, boolean isHidden, String roomDescription);

	public void handleDuplicateRoomname(final String roomNameInput, final RoomPolicy roomPolicy,
			final List<String> roomOwnersNames, final List<String> roomUserNames, final boolean isHidden,
			final String roomDescription) {
		new YesNoDialogBox(I18N.getNote(), I18N.getRoomNameDuplicateWarning()) {

			@Override
			public void onYes() {
				createNewRoom(roomNameInput, roomPolicy, roomOwnersNames, roomUserNames, isHidden, roomDescription);
			}

			@Override
			public void onNo() {
			}
		}.center();
	}

	public void createNewRoom(final String roomNameInput, final RoomPolicy roomPolicy,
			final List<String> roomOwnersNames, final List<String> roomUserNames, final boolean isHidden,
			String roomDescription) {
		handleNewRoom(new FileTitle(roomNameInput), roomOwnersNames, roomUserNames, roomPolicy, isHidden,
				roomDescription);
		hide();
	}

	protected abstract void handleNewRoom(FileTitle roomName, List<String> roomOwners, List<String> roomUsers,
			RoomPolicy roomPolicy, boolean isHidden, String roomDescription);

	private List<String> tokenizeUsernames(String text) {
		assert text != null : "Precondition failed: text != null";

		List<String> result = new ArrayList<String>();

		String textWithoutSpaces = text.replaceAll(" ", "");

		if (!textWithoutSpaces.isEmpty()) {
			String[] usernames = textWithoutSpaces.split(";");

			for (String username : usernames) {
				result.add(username);
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private ListBox createRoomPolicyListBox() {
		ListBox result = new ListBox();

		for (RoomPolicy roomPolicy : RoomPolicy.values()) {
			if (roomPolicy.equals(RoomPolicy.COLLECTIVE_CONTENT)) {
				result.addItem(I18N.getRoomPolicyCollective());
			} else if (roomPolicy.equals(RoomPolicy.SHARED_CONTENT)) {
				result.addItem(I18N.getRoomPolicyShared());
			} else if (roomPolicy.equals(RoomPolicy.INDIVIDUAL_CONTENT)) {
				result.addItem(I18N.getRoomPolicyIndividual());
			} else if (roomPolicy.equals(RoomPolicy.SHOWROOM)) {
				result.addItem(I18N.getRoomPolicyShowroom());
			}
		}

		result.setSelectedIndex(0);
		result.setVisibleItemCount(1);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
