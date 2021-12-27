package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.UserRole;

public class RoomItemTest {
	private User owner;
	private User user;
	private User unknownUser;
	private User additionalOwner;
	private IdFactory idfactory;
	private Date date;
	private ArrayList<String> roomUsers;
	private ArrayList<String> roomOwners;

	@Before
	public void setUp() throws Exception {
		owner = new User("owner", "firstname", "lastname", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		additionalOwner = new User("additionalOwner", "firstname", "lastname", null,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		user = new User("user", "firstname", "lastname", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		unknownUser = User.getUnknownUser();
		idfactory = new IdFactory(10);

		date = new Date();

		roomUsers = new ArrayList<String>();
		roomUsers.add(user.getUsername());

		roomOwners = new ArrayList<String>();
		roomOwners.add(additionalOwner.getUsername());
	}

	@Test
	public void testConstructor() {
		Id createId = idfactory.createId();
		Date creationDate = new Date();
		Date changeDate = new Date();
		List<String> roomUsers = new ArrayList<String>();
		List<String> roomOwners = new ArrayList<String>();
		RoomItem roomItem = new RoomItem(createId, owner.getUsername(), roomUsers, roomOwners, new FileTitle("room"),
				creationDate, changeDate, RoomPolicy.SHARED_CONTENT);

		assertEquals(createId, roomItem.getId());
		assertEquals(owner.getUsername(), roomItem.getOwner());
		assertEquals("room", roomItem.getFileTitle().getTitleString());
		assertEquals(creationDate, roomItem.getCreationDate());
		assertEquals(changeDate, roomItem.getChangeDate());
	}

	@Test
	public void testIsReadFilePermitted_IndividualContent_RoomOwner() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isReadFilePermitted(owner.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(owner.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_IndividualContent_RoomAdmin() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isReadFilePermitted(additionalOwner.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(additionalOwner.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_IndividualContent_RoomUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isReadFilePermitted(user.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(user.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_IndividualContent_UnknownUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem1));
		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_IndividualContent_RoomOwner() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isModifyFilePermitted(owner.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(owner.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_IndividualContent_RoomAdmin() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isModifyFilePermitted(additionalOwner.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(additionalOwner.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_IndividualContent_RoomUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isModifyFilePermitted(user.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(user.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_IndividualContent_UnknownUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem1));
		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem2));
	}

	@Test
	public void testIsRoomAcessPermitted_RoomOwner() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		assertTrue(individualRoom.isRoomAccessPermitted(owner.getUsername()));

	}

	@Test
	public void testIsRoomAcessPermitted_RoomAdmin() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		assertTrue(individualRoom.isRoomAccessPermitted(additionalOwner.getUsername()));
	}

	@Test
	public void testIsRoomAcessPermitted_RoomUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		assertTrue(individualRoom.isRoomAccessPermitted(user.getUsername()));
	}

	@Test
	public void testIsRoomAcessPermitted_UnknownUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.INDIVIDUAL_CONTENT);

		assertFalse(individualRoom.isRoomAccessPermitted(unknownUser.getUsername()));
	}

	@Test
	public void testIsReadFilePermitted_SharedContent_RoomOwner() {
		RoomItem individualRoom = createRoom(RoomPolicy.SHARED_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isReadFilePermitted(owner.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(owner.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_SharedContent_RoomAdmin() {
		RoomItem individualRoom = createRoom(RoomPolicy.SHARED_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isReadFilePermitted(additionalOwner.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(additionalOwner.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_SharedContent_RoomUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.SHARED_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isReadFilePermitted(user.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(user.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_SharedContent_UnknownUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.SHARED_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem1));
		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_SharedContent_RoomOwner() {
		RoomItem individualRoom = createRoom(RoomPolicy.SHARED_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isModifyFilePermitted(owner.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(owner.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_SharedContent_RoomAdmin() {
		RoomItem individualRoom = createRoom(RoomPolicy.SHARED_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isModifyFilePermitted(additionalOwner.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(additionalOwner.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_SharedContent_RoomUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.SHARED_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isModifyFilePermitted(user.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(user.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_SharedContent_UnknownUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.SHARED_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem1));
		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_CollectiveContent_RoomOwner() {
		RoomItem individualRoom = createRoom(RoomPolicy.COLLECTIVE_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isReadFilePermitted(owner.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(owner.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_CollectiveContent_RoomAdmin() {
		RoomItem individualRoom = createRoom(RoomPolicy.COLLECTIVE_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isReadFilePermitted(additionalOwner.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(additionalOwner.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_CollectiveContent_RoomUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.COLLECTIVE_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isReadFilePermitted(user.getUsername(), fileItem1));
		assertTrue(individualRoom.isReadFilePermitted(user.getUsername(), fileItem2));
	}

	@Test
	public void testIsReadFilePermitted_CollectiveContent_UnknownUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.COLLECTIVE_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem1));
		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_CollectiveContent_RoomOwner() {
		RoomItem individualRoom = createRoom(RoomPolicy.COLLECTIVE_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isModifyFilePermitted(owner.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(owner.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_CollectiveContent_RoomAdmin() {
		RoomItem individualRoom = createRoom(RoomPolicy.COLLECTIVE_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isModifyFilePermitted(additionalOwner.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(additionalOwner.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_CollectiveContent_RoomUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.COLLECTIVE_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertTrue(individualRoom.isModifyFilePermitted(user.getUsername(), fileItem1));
		assertTrue(individualRoom.isModifyFilePermitted(user.getUsername(), fileItem2));
	}

	@Test
	public void testIsModifyFilePermitted_CollectiveContent_UnknownUser() {
		RoomItem individualRoom = createRoom(RoomPolicy.COLLECTIVE_CONTENT);

		FileItem fileItem1 = createFileItem(owner.getUsername());
		FileItem fileItem2 = createFileItem(user.getUsername());

		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem1));
		assertFalse(individualRoom.isModifyFilePermitted(unknownUser.getUsername(), fileItem2));
	}

	@Test
	public void testIsCreateFilePermitted_ShowroomPolicy_RoomUser() {
		RoomItem showroom = createRoom(RoomPolicy.SHOWROOM);

		assertFalse(showroom.isCreateFilePermitted(user));
	}

	@Test
	public void testIsCreateFilePermitted_ShowroomPolicy_RoomAdmin() {
		RoomItem showroom = createRoom(RoomPolicy.SHOWROOM);

		assertTrue(showroom.isCreateFilePermitted(owner));
	}

	@Test
	public void testIsReadFilePermitted_ShowroomPolicy_RoomUser() {
		RoomItem showroom = createRoom(RoomPolicy.SHOWROOM);
		FileItem fileItem = createFileItem(owner.getUsername());

		assertTrue(showroom.isReadFilePermitted(user.getUsername(), fileItem));
	}

	@Test
	public void testIsReadFilePermitted_ShowroomPolicy_RoomOwner() {
		RoomItem showroom = createRoom(RoomPolicy.SHOWROOM);
		FileItem fileItem = createFileItem(owner.getUsername());

		assertTrue(showroom.isReadFilePermitted(owner.getUsername(), fileItem));
	}

	@Test
	public void testIsModifyFilePermitted_ShowroomPolicy_RoomOwner() {
		RoomItem showroom = createRoom(RoomPolicy.SHOWROOM);
		FileItem fileItem = createFileItem(owner.getUsername());

		assertTrue(showroom.isModifyFilePermitted(owner.getUsername(), fileItem));
	}

	@Test
	public void testIsModifyFilePermitted_ShowroomPolicy_RoomUser() {
		RoomItem showroom = createRoom(RoomPolicy.SHOWROOM);
		FileItem fileItem = createFileItem(owner.getUsername());

		assertFalse(showroom.isModifyFilePermitted(user.getUsername(), fileItem));
	}

	private RoomItem createRoom(RoomPolicy roomPolicy) {
		return new RoomItem(idfactory.createId(), owner.getUsername(), roomUsers, roomOwners, new FileTitle("room"),
				date, date, roomPolicy);
	}

	private FileItem createFileItem(String fileOwnerName) {
		return new FileItem(idfactory.createId(), fileOwnerName, new FileTitle("fileTitle"), date, date,
				FileItemColorLabel.NONE);
	}
}
