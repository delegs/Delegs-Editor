package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;

public class RoomItem extends FolderItem {
	private static final long serialVersionUID = -4456067859443949572L;

	private RoomPolicy roomPolicy;
	private String description;

	private List<String> roomUsers;
	private List<String> roomAdmins;
	private boolean isHidden;

	private RecycleBinItem recycleBinItem;

	public RoomItem(Id id, String owner, List<String> roomUsers, List<String> roomAdmins, FileTitle fileTitle,
			Date creation, Date change, RoomPolicy roomPolicy) {
		this(id, owner, roomUsers, roomAdmins, fileTitle, creation, change, roomPolicy, "");
	}

	public RoomItem(Id id, String owner, List<String> roomUsers, List<String> roomAdmins, FileTitle fileTitle,
			Date creation, Date change, RoomPolicy roomPolicy, String description) {
		super(id, owner, fileTitle, creation, change, FileItemColorLabel.NONE, SortCriteria.TYPE);

		assert roomUsers != null : "Precondition failed: roomUsers != null";
		assert roomAdmins != null : "Precondition failed: roomAdmins != null";
		assert roomPolicy != null : "Precondition failed: roomPolicy != null";

		this.roomAdmins = roomAdmins;
		this.roomUsers = roomUsers;
		this.roomPolicy = roomPolicy;
		this.description = description;
		this.isHidden = true;
	}

	@Deprecated
	public RoomItem() {
		this.roomPolicy = RoomPolicy.SHARED_CONTENT;
		this.roomAdmins = new ArrayList<String>();
		this.roomUsers = new ArrayList<String>();
		this.isHidden = true;
	}

	public List<String> getRoomUsers() {
		return roomUsers;
	}

	public void addUserToRoom(String addedUser) {
		roomUsers.add(addedUser);
	}

	public void deleteUserFromRoom(String userName) {
		deleteAdminFromRoom(userName);
		for (String user : roomUsers) {
			if (user.equals(userName)) {
				roomUsers.remove(user);
				break;
			}
		}
	}

	// Performance related: only called when admin was successfully added to DB
	public void addAdminToRoom(String newAdmin) {
		if (!roomAdmins.contains(newAdmin)) {
			roomAdmins.add(newAdmin);
			if (roomUsers.contains(newAdmin)) {
				roomUsers.remove(newAdmin);
			}
		}
	}

	public void deleteAdminFromRoom(String adminName) {
		for (String user : roomAdmins) {
			if (user.equals(adminName)) {
				roomUsers.add(user);
				roomAdmins.remove(user);
				break;
			}
		}

	}

	public void setRoomPolicy(RoomPolicy selectedPolicy) {
		this.roomPolicy = selectedPolicy;
	}

	public void setIsHidden(Boolean value) {
		isHidden = value;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public List<String> getRoomAdmins() {
		return roomAdmins;
	}

	public String getDescription() {
		return description;
	}

	public RoomPolicy getRoomPolicy() {
		return roomPolicy;
	}

	public boolean hasRecycleBinItem() {
		return recycleBinItem != null;
	}

	public void setRecycleBinItem(RecycleBinItem recycleBinItem) {
		this.recycleBinItem = recycleBinItem;
	}

	public RecycleBinItem getRecycleBinItem() {
		return recycleBinItem;
	}

	public boolean isRoomAccessPermitted(String userName) {
		assert userName != null : "Precondition failed: username != null";

		return isResponsible(userName) || this.getRoomUsers().contains(userName);
	}

	public boolean isReadFilePermitted(String userName, FileItem fileItem) {
		assert userName != null : "Precondition failed: user != null";
		assert fileItem != null : "Precondition failed: fileItem != null";

		boolean result = false;

		if (this.roomPolicy.equals(RoomPolicy.INDIVIDUAL_CONTENT)) {
			result = isResponsible(userName) || (roomUsers.contains(userName) && fileItem.getOwner().equals(userName));
		} else {
			result = isRoomAccessPermitted(userName);
		}

		return result;
	}

	public boolean isCreateFilePermitted(User user) {
		assert user != null : "Precondition failed: user != null";

		if (this.roomPolicy.equals(RoomPolicy.SHOWROOM) && !isResponsible(user.getUsername())) {
			return false;
		}

		return true;
	}

	// Modify includes overwrite, delete, move and rename
	public boolean isModifyFilePermitted(String userName, FileItem fileItem) {
		assert userName != null : "Precondition failed: user != null";
		assert fileItem != null : "Precondition failed: fileItem != null";

		boolean result = false;

		if (this.roomPolicy.equals(RoomPolicy.COLLECTIVE_CONTENT)) {
			result = isRoomAccessPermitted(userName);
		} else if (this.roomPolicy.equals(RoomPolicy.SHARED_CONTENT)) {
			result = isResponsible(userName) || fileItem.getOwner().equals(userName)
					|| fileItem.getOwner().equals(User.getUnknownUser().getUsername());
		} else if (this.roomPolicy.equals(RoomPolicy.INDIVIDUAL_CONTENT)) {
			result = isResponsible(userName) || fileItem.getOwner().equals(userName);
		} else if (this.roomPolicy.equals(RoomPolicy.SHOWROOM)) {
			result = isResponsible(userName);
		}

		return result;
	}

	public boolean isResponsible(String userName) {
		return this.getOwner().equals(userName) || this.getRoomAdmins().contains(userName);
	}

	@Override
	public String toString() {
		return "Room [id=" + getId() + ", title=" + getFileTitle().getTitleString() + ", room policy=" + roomPolicy
				+ "]";
	}

	public static RoomItem getRootRoomItem(RoomItem roomItem) {
		assert roomItem != null : "Precondition failed: roomItem != null";
		assert roomItem.getId().equals(
				RoomItem.ROOT_FOLDER_ID) : "Precondition failed: roomItem.getId().equals(RoomItem.ROOT_FOLDER_ID)";
		return new RootRoomItem(roomItem);
	}

	public static RoomItem getPublicRoomItem(RoomItem roomItem) {
		assert roomItem != null : "Precondition failed: roomItem != null";
		assert roomItem.getId().equals(
				RoomItem.PUBLIC_FOLDER_ID) : "Precondition failed: roomItem.getId().equals(RoomItem.PUBLIC_FOLDER_ID)";
		return new PublicRoomItem(roomItem);
	}

	public static RoomItem getSystemRoomItem(RoomItem roomItem) {
		assert roomItem != null : "Precondition failed: roomItem != null";
		assert roomItem.getId().equals(
				RoomItem.SYSTEM_FOLDER_ID) : "Precondition failed: roomItem.getId().equals(RoomItem.SYSTEM_FOLDER_ID)";
		return new SystemRoomItem(roomItem);
	}

	public static RoomItem getShowRoomItem(RoomItem roomItem) {
		assert roomItem != null : "Precondition failed: roomItem != null";
		assert roomItem.getId().equals(
				RoomItem.SHOWROOM_FOLDER_ID) : "Precondition failed: roomItem.getId().equals(RoomItem.SHOWROOM_FOLDER_ID)";
		return new ShowRoomItem(roomItem);
	}

	protected static class ShowRoomItem extends RoomItem {
		private static final long serialVersionUID = -1998446613640970697L;

		public ShowRoomItem(RoomItem roomItem) {
			super(roomItem.getId(), roomItem.getOwner(), roomItem.getRoomUsers(), roomItem.getRoomAdmins(),
					roomItem.fileTitle, roomItem.getCreationDate(), roomItem.getChangeDate(), roomItem.getRoomPolicy(),
					roomItem.getDescription());
			assert roomItem != null : "Precondition failed: rootRoomItem != null";
			assert roomItem.getId().equals(
					RoomItem.SHOWROOM_FOLDER_ID) : "Precondition failed: rootRoomItem.getId().equals(RoomItem.ROOT_FOLDER_ID)";
		}

		@Deprecated
		protected ShowRoomItem() {
		}

		@Override
		public boolean isRoomAccessPermitted(String user) {
			return true;
		}

		@Override
		public boolean isCreateFilePermitted(User user) {
			return user.getUsername().equals("delegs");
		}

		@Override
		public boolean isModifyFilePermitted(String user, FileItem fileItem) {
			return user.equals("delegs");
		}
	}

	protected static class RootRoomItem extends RoomItem {
		private static final long serialVersionUID = -6478566902241857855L;

		public RootRoomItem(RoomItem rootRoom) {
			super(rootRoom.getId(), rootRoom.getOwner(), rootRoom.getRoomUsers(), rootRoom.getRoomAdmins(),
					rootRoom.getFileTitle(), rootRoom.getCreationDate(), rootRoom.getChangeDate(),
					rootRoom.getRoomPolicy(), rootRoom.getDescription());
			assert rootRoom != null : "Precondition failed: rootRoomItem != null";
			assert rootRoom.getId().equals(
					RoomItem.ROOT_FOLDER_ID) : "Precondition failed: rootRoomItem.getId().equals(RoomItem.ROOT_FOLDER_ID)";
		}

		@Deprecated
		protected RootRoomItem() {
		}

		@Override
		public boolean isRoomAccessPermitted(String user) {
			return true;
		}

		@Override
		public boolean isCreateFilePermitted(User user) {
			return false;
		}

		@Override
		public boolean isModifyFilePermitted(String user, FileItem fileItem) {
			boolean result = false;
			if (fileItem instanceof RoomItem) {
				result = ((RoomItem) fileItem).isResponsible(user);
			}
			return result;
		}

	}

	protected static class PublicRoomItem extends RoomItem {
		private static final long serialVersionUID = -5066060352507139632L;

		public PublicRoomItem(RoomItem publicRoom) {
			super(publicRoom.getId(), publicRoom.getOwner(), publicRoom.getRoomUsers(), publicRoom.getRoomAdmins(),
					publicRoom.fileTitle, publicRoom.getCreationDate(), publicRoom.getChangeDate(),
					publicRoom.getRoomPolicy(), publicRoom.getDescription());
			setIsHidden(publicRoom.isHidden());
			assert publicRoom != null : "Precondition failed: rootRoomItem != null";
			assert publicRoom.getId().equals(
					RoomItem.PUBLIC_FOLDER_ID) : "Precondition failed: publicRoomItem.getId().equals(RoomItem.PUBLIC_FOLDER_ID)";
		}

		@Deprecated
		protected PublicRoomItem() {
		}

		@Override
		public boolean isRoomAccessPermitted(String user) {
			return true;
		}
	}

	protected static class SystemRoomItem extends RoomItem {

		private static final long serialVersionUID = 1L;

		public SystemRoomItem(RoomItem systemRoom) {
			super(systemRoom.getId(), systemRoom.getOwner(), systemRoom.getRoomUsers(), systemRoom.getRoomAdmins(),
					systemRoom.getFileTitle(), systemRoom.getCreationDate(), systemRoom.getChangeDate(),
					systemRoom.getRoomPolicy(), systemRoom.getDescription());
			assert systemRoom != null : "Precondition failed: rootRoomItem != null";
			assert systemRoom.getId().equals(
					RoomItem.SYSTEM_FOLDER_ID) : "Precondition failed: publicRoomItem.getId().equals(RoomItem.SYSTEM_FOLDER_ID)";
		}

		@Deprecated
		protected SystemRoomItem() {
		}

		@Override
		public boolean isRoomAccessPermitted(String user) {
			return false;
		}

		@Override
		public boolean isModifyFilePermitted(String userName, FileItem fileItem) {
			return true;
		}

	}

}
