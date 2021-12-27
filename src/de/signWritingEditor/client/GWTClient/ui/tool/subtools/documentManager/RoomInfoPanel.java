package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ImageButton;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;
import de.signWritingEditor.client.GWTClient.ui.tool.workbench.TextBoxWithWatermark;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.User;

public class RoomInfoPanel extends Composite {

	private static final String IMAGE_BUTTON_HOVER_STYLE = "imageButton-hover";
	private static final int ROOM_INFO_PANEL_BOTTOM_MARGIN = 100;
	private static final int TEXT_AREA_HEIGHT = 20;
	private static final int TEXT_AREA_WIDTH = 150;
	private static final int BUTTON_HEIGHT = 27;
	private static final int BUTTON_WIDTH = 55;
	private static final Map<RoomPolicy, Integer> policySelectionMap = new HashMap<RoomPolicy, Integer>();

	static {
		policySelectionMap.put(RoomPolicy.COLLECTIVE_CONTENT, 0);
		policySelectionMap.put(RoomPolicy.SHARED_CONTENT, 1);
		policySelectionMap.put(RoomPolicy.INDIVIDUAL_CONTENT, 2);
		policySelectionMap.put(RoomPolicy.SHOWROOM, 3);
	}

	private static final Map<String, Integer> userRoleSelectionMap = new HashMap<String, Integer>();

	static {
		userRoleSelectionMap.put(I18N.getResponsible(), 0);
		userRoleSelectionMap.put(I18N.getRoomUsers(), 1);
	}

	private HTML roomNameLabel;
	private HTML ownerNameLabel;
	private HTML ownerTitleLabel;
	private HTML userNamesLabel;
	private HTML userTitleLabel;
	private HTML roomTitleDescriptionLabel;
	private HTML roomDescriptionLabel;
	private HTML roomPolicyTitleLabel;
	private HTML roomPolicyNameLabel;
	private HTML roomPolicyLabel;
	private HTML roomManagementLabel;
	private HTML roomUserManagementLabel;
	private HTML roomPolicyManagementLabel;
	private Grid roomUserManagementGrid;
	private RoomItem room;
	private Image roomPolicyIcon;
	private FlowPanel roomManagementPanel;
	private User currentUser;
	private UserManagementListener listener;
	private ListBox roomPolicyListBox;
	private FlexTable userTable;
	private boolean isLoaded;
	private FlowPanel leaveRoomForeverPanel;

	public RoomInfoPanel(UserManagementListener userManagementListener) {
		assert userManagementListener != null : "Precondition failed: userManagementListener != null";

		OrientedFlowPanel mainPanel = new OrientedFlowPanel(Orientation.VERTICAL);
		initWidget(mainPanel);
		setStyleName("roomInfoPanel");

		Image roomIcon = new Image(Resources.RESOURCE.getIconRoomBig());
		roomIcon.setStyleName("roomIcon");
		mainPanel.add(roomIcon);

		roomNameLabel = new HTML("");
		roomNameLabel.setStyleName("roomNameLabel");
		mainPanel.add(roomNameLabel);

		// -----
		roomTitleDescriptionLabel = new HTML(I18N.getRoomDescription());
		roomTitleDescriptionLabel.setStyleName("titleLabel");
		mainPanel.add(roomTitleDescriptionLabel);

		roomDescriptionLabel = new HTML("");
		roomDescriptionLabel.setStyleName("contentLabel");
		mainPanel.add(roomDescriptionLabel);
		// -----

		ownerTitleLabel = new HTML(I18N.getResponsible());
		ownerTitleLabel.setStyleName("titleLabel");
		mainPanel.add(ownerTitleLabel);

		ownerNameLabel = new HTML("");
		ownerNameLabel.setStyleName("contentLabel");
		mainPanel.add(ownerNameLabel);

		userTitleLabel = new HTML(I18N.getRoomUsers());
		userTitleLabel.setStyleName("titleLabel");
		mainPanel.add(userTitleLabel);

		userNamesLabel = new HTML("");
		userNamesLabel.setStyleName("contentLabel");
		mainPanel.add(userNamesLabel);

		roomPolicyTitleLabel = new HTML("");
		roomPolicyTitleLabel.setStyleName("titleLabel");
		mainPanel.add(roomPolicyTitleLabel);

		roomPolicyIcon = new Image();
		roomPolicyIcon.setStyleName("roomPolicyIcon");
		mainPanel.add(roomPolicyIcon);

		roomPolicyNameLabel = new HTML("");
		roomPolicyNameLabel.setStyleName("contentLabel");
		mainPanel.add(roomPolicyNameLabel);

		roomPolicyLabel = new HTML("");
		roomPolicyLabel.setStyleName("contentLabel");
		mainPanel.add(roomPolicyLabel);

		leaveRoomForeverPanel = createLeaveRoomPanel();

		mainPanel.add(leaveRoomForeverPanel);
		leaveRoomForeverPanel.getElement().getStyle().clearDisplay();

		roomManagementPanel = createRoomMangementPanel();
		mainPanel.add(roomManagementPanel);
		this.listener = userManagementListener;

		this.addHandler(new ResizeHandler() {

			@Override
			public void onResize(ResizeEvent event) {
				updatePanelHeight();
			}
		}, ResizeEvent.getType());

		ensureDebugId("roomInfoPanel");

	}

	private FlowPanel createLeaveRoomPanel() {
		Label leaveRoomForeverLabel = new Label(I18N.getLeaveRoomForever());
		leaveRoomForeverLabel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);

		FlexTable table = new FlexTable();

		final ImageButton leaveRoomForeverButton = new ImageButton(new Image(RESOURCE.getRoomIcon()), "",
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						String title = I18N.getLeaveRoomForeverTitle();
						String message = I18N.getLeaveRoomForeverMessage();
						YesNoDialogBox yesNoDialogBox = new YesNoDialogBox(title, message) {

							@Override
							public void onYes() {
								listener.onDeleteUserFromRoom(room, currentUser.getUsername());
							}

							@Override
							public void onNo() {

							}
						};
						yesNoDialogBox.center();
					}
				});
		leaveRoomForeverButton.setPixelSize(45, 30);
		leaveRoomForeverButton.getElement().getStyle().setProperty("borderRadius", "6px");
		leaveRoomForeverButton.getElement().getStyle().setMarginLeft(5, Unit.PX);
		leaveRoomForeverButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		leaveRoomForeverButton.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				leaveRoomForeverButton.setStyleName(IMAGE_BUTTON_HOVER_STYLE);
			}
		});
		leaveRoomForeverButton.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				leaveRoomForeverButton.removeStyleName(IMAGE_BUTTON_HOVER_STYLE);
			}
		});

		table.setText(0, 0, I18N.getLeaveRoomForever());
		table.setWidget(0, 1, leaveRoomForeverButton);

		FlowPanel leaveRoomForeverPanel = new FlowPanel();
		leaveRoomForeverPanel.getElement().getStyle().setMarginTop(20, Unit.PX);

		leaveRoomForeverPanel.add(table);

		return leaveRoomForeverPanel;
	}

	private FlowPanel createRoomMangementPanel() {
		FlowPanel managementPanel = new FlowPanel();
		managementPanel.addStyleName("roomManagementPanel");

		this.roomPolicyListBox = new ListBox();
		roomPolicyListBox.addItem(I18N.getRoomPolicyCollective());
		roomPolicyListBox.addItem(I18N.getRoomPolicyShared());
		roomPolicyListBox.addItem(I18N.getRoomPolicyIndividual());
		roomPolicyListBox.addItem(I18N.getRoomPolicyShowroom());
		roomPolicyListBox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int index = roomPolicyListBox.getSelectedIndex();
				String selectedElement = roomPolicyListBox.getItemText(index);
				RoomPolicy selectedPolicy = null;
				if (selectedElement.equals(I18N.getRoomPolicyCollective())) {
					selectedPolicy = RoomPolicy.COLLECTIVE_CONTENT;
				} else if (selectedElement.equals(I18N.getRoomPolicyShared())) {
					selectedPolicy = RoomPolicy.SHARED_CONTENT;
				} else if (selectedElement.equals(I18N.getRoomPolicyIndividual())) {
					selectedPolicy = RoomPolicy.INDIVIDUAL_CONTENT;
				} else if (selectedElement.equals(I18N.getRoomPolicyShowroom())) {
					selectedPolicy = RoomPolicy.SHOWROOM;
				}
				assert selectedPolicy != null : "Postcondition failed: selectedPolicy != null";

				if (isRoomOwner(RoomInfoPanel.this.room, currentUser) && !isPublicOrRootFolder()) {
					listener.onPolicyChanged(RoomInfoPanel.this.room, selectedPolicy);
				}
			}
		});
		roomPolicyListBox.setWidth("183px");
		roomPolicyListBox.getElement().getStyle().setMarginLeft(3, Unit.PX);

		roomManagementLabel = new HTML("");
		roomManagementLabel.setStyleName("titleLabel");
		roomManagementLabel.setHTML(I18N.getRoomManagement());
		managementPanel.add(roomManagementLabel);

		roomPolicyManagementLabel = new HTML("");
		roomPolicyManagementLabel.setStyleName("subTitleLabel");
		roomPolicyManagementLabel.setHTML(I18N.getRoomPolicyManagement());

		managementPanel.add(roomPolicyManagementLabel);
		managementPanel.add(roomPolicyListBox);

		roomUserManagementLabel = new HTML("");
		roomUserManagementLabel.setStyleName("subTitleLabel");
		roomUserManagementLabel.setHTML(I18N.getRoomUserManagement());
		managementPanel.add(roomUserManagementLabel);
		roomUserManagementGrid = new Grid(1, 2);

		createTextBoxAndButtonRow(roomUserManagementGrid, 0, I18N.getAddUser(),
				new Image(RESOURCE.getToolBarIconAddUser()));

		managementPanel.add(roomUserManagementGrid);

		FlowPanel userManagementPanel = new FlowPanel();
		userManagementPanel.setWidth("100%");
		userManagementPanel.add(createUserTable());
		managementPanel.add(userManagementPanel);

		managementPanel.setVisible(false);

		return managementPanel;
	}

	private FlexTable createUserTable() {
		userTable = new FlexTable();
		userTable.setWidth("100%");

		return userTable;
	}

	private void updateUserTable() {

		userTable.removeAllRows();
		userTable.setText(0, 0, "Name");
		userTable.setText(0, 1, "Rolle");
		userTable.setText(0, 2, "");

		styleRow(0);

		int currentRow = 1;
		for (int i = 0; i < room.getRoomAdmins().size(); i++, currentRow++) {
			addUserRowToTable(currentRow, room.getRoomAdmins().get(i), I18N.getResponsible());
		}

		for (int i = 0; i < room.getRoomUsers().size(); i++, currentRow++) {
			addUserRowToTable(currentRow, room.getRoomUsers().get(i), I18N.getRoomUsers());
		}
	}

	private void addUserRowToTable(final int currentRow, final String user, final String role) {

		ToolBarButton deleteButton = new ToolBarButton(new Image(Resources.RESOURCE.getIconRemoveSymbol()), "",
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						String title = I18N.getRoomUserDeleteTitle();
						String message = I18N.getRoomUserDeleteMessage(user);

						YesNoDialogBox yesNoDialogBox = new YesNoDialogBox(title, message) {

							@Override
							public void onYes() {
								listener.onDeleteUserFromRoom(room, user);
							}

							@Override
							public void onNo() {

							}
						};
						yesNoDialogBox.center();
					}
				});

		ListBox userRoleListBox = createUserRoleListBox(currentRow, role);
		Label userName = new Label(user);
		userName.setStyleName("roomUserLabel");
		userName.setTitle(user);

		userTable.setWidget(currentRow, 0, userName);
		userTable.setWidget(currentRow, 1, userRoleListBox);
		userTable.setWidget(currentRow, 2, deleteButton);
		styleRow(currentRow);
	}

	private ListBox createUserRoleListBox(final int currentRow, final String role) {
		final ListBox userRoleListBox = new ListBox();
		userRoleListBox.addItem(I18N.getResponsible());
		userRoleListBox.addItem(I18N.getRoomUsers());
		userRoleListBox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (isRoomOwner(room, currentUser) && !isPublicOrRootFolder()) {
					int index = userRoleListBox.getSelectedIndex();
					String selectedElement = userRoleListBox.getItemText(index);
					String name = userTable.getText(currentRow, 0);

					if (selectedElement.equals(I18N.getResponsible())) {
						if (!room.getRoomAdmins().contains(name)) {
							listener.onAddAdminToRoom(room, name);
						}

					} else if (selectedElement.equals(I18N.getRoomUsers())) {
						if (!room.getRoomUsers().contains(name)) {
							listener.onDeleteAdminFromRoom(room, name);
						}

					}
				}

			}
		});
		userRoleListBox.setSelectedIndex(userRoleSelectionMap.get(role));
		return userRoleListBox;
	}

	private void styleRow(int row) {
		if (row % 2 == 1) {
			userTable.getRowFormatter().getElement(row).getStyle().setBackgroundColor("#EFEFEF");
		} else {
			userTable.getRowFormatter().getElement(row).getStyle().clearBackgroundColor();
		}

		userTable.getCellFormatter().getElement(row, 2).getStyle().setWidth(25, Unit.PX);
		userTable.getCellFormatter().getElement(row, 2).getStyle().setHeight(25, Unit.PX);
	}

	private void createTextBoxAndButtonRow(Grid grid, int row, String watermark, Image image) {
		final TextBoxWithWatermark textArea = new TextBoxWithWatermark(watermark);
		textArea.getElement().getStyle().setProperty("resize", "none");
		textArea.setPixelSize(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);

		textArea.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					if (isRoomOwner(room, currentUser) && !isPublicOrRootFolder()) {
						listener.onAddUserToRoom(room, textArea.getText());
					}
				}
			}
		});

		grid.setWidget(row, 0, textArea);

		ToolBarButton button = new ToolBarButton(image, "", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (isRoomOwner(room, currentUser) && !isPublicOrRootFolder()) {
					listener.onAddUserToRoom(room, textArea.getText());
				}
			}
		});
		button.getElement().getStyle().setTextAlign(TextAlign.LEFT);
		button.setPixelSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		grid.setWidget(row, 1, button);
	}

	public void clearTextArea(UserManagementMethod method) {
		switch (method) {
		case ADD_USER:
			((TextBoxWithWatermark) roomUserManagementGrid.getWidget(0, 0)).setText("");
			break;
		default:
			break;
		}
	}

	public void setRoom(RoomItem room, User user) {
		assert room != null : "Precondition failed: room != null";
		String description;

		boolean newRoom = !room.equals(this.room) || !isLoaded;
		this.room = room;
		this.currentUser = user;
		boolean roomOwner = isRoomOwner(room, user);
		leaveRoomForeverPanel.setVisible(!isPublicOrRootFolder());
		if ((!roomManagementPanel.isVisible() && roomOwner) || (roomManagementPanel.isVisible() && !roomOwner)
				|| newRoom) {
			this.getElement().getStyle().clearHeight();
			showManagementPanels(roomOwner);
			updatePanelHeight();
		}

		if (room.getDescription() == null) {
			description = "";
		} else {
			description = room.getDescription();
		}

		refreshLabels(description);
		updateUserTable();
		isLoaded = true;
	}

	private void updatePanelHeight() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				double height = getOffsetHeight();
				if (height > Window.getClientHeight() - ROOM_INFO_PANEL_BOTTOM_MARGIN) {
					setHeight((Window.getClientHeight() - ROOM_INFO_PANEL_BOTTOM_MARGIN) + "px");
				}
			}
		});
	}

	private boolean isRoomOwner(RoomItem room, User user) {
		return room.getRoomAdmins().contains(user.getUsername()) || user.getUsername().equals(room.getOwner());
	}

	private boolean isUserRoomAdmin(RoomItem room, String userName) {
		boolean result = false;
		for (String roomOwner : room.getRoomAdmins()) {
			if (roomOwner.equals(userName)) {
				result = true;
				break;
			}
		}
		if (room.getOwner().equals(userName)) {
			result = true;
		}
		return result;
	}

	private void showManagementPanels(boolean showPanel) {
		roomManagementPanel.setVisible(showPanel && !isPublicOrRootFolder());
	}

	private boolean isPublicOrRootFolder() {
		return room.getId().equals(FolderItem.PUBLIC_FOLDER_ID) || room.getId().equals(FolderItem.ROOT_FOLDER_ID);
	}

	private void refreshLabels(String description) {
		setRoomLabelText(room.getFileTitle().getDisplayTitleString());

		StringBuilder ownerNamesStringBuilder = new StringBuilder("");
		List<String> roomOwners = room.getRoomAdmins();
		if (!roomOwners.contains(room.getOwner())) {
			ownerNamesStringBuilder.append(room.getOwner());
			if (!roomOwners.isEmpty()) {
				ownerNamesStringBuilder.append(", ");
			}
		}
		for (int index = 0; index < roomOwners.size(); index++) {
			ownerNamesStringBuilder.append(roomOwners.get(index));
			if (index < roomOwners.size() - 1) {
				ownerNamesStringBuilder.append(", ");
			}
		}

		ownerNameLabel.setHTML(ownerNamesStringBuilder.toString());

		StringBuilder userNamesStringBuilder = new StringBuilder("");

		if (room.getId().equals(RoomItem.PUBLIC_FOLDER_ID) || room.getId().equals(RoomItem.SHOWROOM_FOLDER_ID)) {
			userNamesStringBuilder.append(I18N.getAllUsers());
		} else {
			List<String> roomUsers = room.getRoomUsers();
			for (int index = 0; index < roomUsers.size(); index++) {
				userNamesStringBuilder.append(roomUsers.get(index));
				if (index < roomUsers.size() - 1) {
					userNamesStringBuilder.append(", ");
				}
			}
		}

		userNamesLabel.setHTML(userNamesStringBuilder.toString());

		roomDescriptionLabel.setHTML(description);

		ImageResource roomPolicyImageResource = null;
		if (room.getRoomPolicy().equals(RoomPolicy.COLLECTIVE_CONTENT)) {
			roomPolicyImageResource = Resources.RESOURCE.getCollectiveRoomPolicyImage();
		} else if (room.getRoomPolicy().equals(RoomPolicy.SHARED_CONTENT)) {
			roomPolicyImageResource = Resources.RESOURCE.getSharedRoomPolicyImage();
		} else if (room.getRoomPolicy().equals(RoomPolicy.INDIVIDUAL_CONTENT)) {
			roomPolicyImageResource = Resources.RESOURCE.getIndividualRoomPolicyImage();
		} else if (room.getRoomPolicy().equals(RoomPolicy.SHOWROOM)) {
			roomPolicyImageResource = Resources.RESOURCE.getShowroomPolicyImage();
		}

		roomPolicyIcon.setResource(roomPolicyImageResource);
		roomPolicyIcon.setStyleName("roomPolicyIcon");
		roomPolicyTitleLabel.setHTML(I18N.getRoomPolicy());
		roomPolicyNameLabel
				.setHTML("<u>" + roomPolicyListBox.getItemText(policySelectionMap.get(room.getRoomPolicy())) + "</u>");
		roomPolicyLabel.setHTML(getLongDescriptionForRoomPolicy(room.getRoomPolicy()));

		roomPolicyListBox.setSelectedIndex(policySelectionMap.get(room.getRoomPolicy()));

	}

	private String getLongDescriptionForRoomPolicy(RoomPolicy roomPolicy) {
		String result = "";
		if (RoomPolicy.COLLECTIVE_CONTENT.equals(roomPolicy)) {
			result = I18N.getRoomPolicyCollectiveLongDescription();
		} else if (RoomPolicy.SHARED_CONTENT.equals(roomPolicy)) {
			result = I18N.getRoomPolicySharedLongDescription();
		} else if (RoomPolicy.INDIVIDUAL_CONTENT.equals(roomPolicy)) {
			result = I18N.getRoomPolicyIndividualLongDescription();
		} else if (RoomPolicy.SHOWROOM.equals(roomPolicy)) {
			result = I18N.getRoomPolicyShowroomLongDescription();
		}
		return result;
	}

	private static final RegExp CAMEL_CASE_BREAKS = RegExp.compile("([^A-Z])([A-Z])", "g");

	private void setRoomLabelText(String text) {
		assert text != null : "Precondition failed: text != null";
		// In Raumnamen sind auch spitze Klammern erlaubt,
		// diese sollen aber nicht als HTML interpretiert werden.
		String escaped = SafeHtmlUtils.htmlEscape(text);

		// Füge ein breitenloses Leerzeichen vor jedem Großbuchstaben ein, vor
		// dem kein Großbuchstabe steht, damit an diesen Stellen bei Bedarf
		// umgebrochen werden kann.
		String withCamelCaseBreaks = CAMEL_CASE_BREAKS.replace(escaped, "$1&#8203;$2");

		roomNameLabel.setHTML(withCamelCaseBreaks);
	}

	public enum UserManagementMethod {
		ADD_USER, DELETE_USER, ADD_ADMIN, DELETE_ADMIN, NONE
	}

	public interface UserManagementListener {
		void onAddUserToRoom(RoomItem room, String userName);

		void onDeleteAdminFromRoom(RoomItem room, String name);

		void onAddAdminToRoom(RoomItem room, String name);

		void onPolicyChanged(RoomItem room, RoomPolicy selectedPolicy);

		void onDeleteUserFromRoom(RoomItem room, String userName);
	}

	public void clearRoom() {
		isLoaded = false;
	}
}
