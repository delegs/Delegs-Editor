package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;

public class FileItemTest {
	private Date creation;
	private Date change;
	private IdFactory idFactory;
	private String username;
	private FileItemColorLabel colorLabel;

	@Before
	public void setUp() {
		creation = new Date();
		change = new Date();
		username = "user";
		colorLabel = FileItemColorLabel.GREEN;

		idFactory = new IdFactory(System.currentTimeMillis());
	}

	@Test
	public void testConstructor() {
		Id id = idFactory.createId();
		FileTitle fileTitle = new FileTitle("test");
		FileItem fileItem = new FileItem(id, username, fileTitle, creation, change, colorLabel);

		assertEquals(id, fileItem.getId());
		assertEquals(username, fileItem.getOwner());
		assertEquals(fileTitle, fileItem.getFileTitle());
		assertEquals(creation, fileItem.getCreationDate());
		assertEquals(change, fileItem.getChangeDate());
		assertEquals(colorLabel, fileItem.getColorLabel());
	}
}
