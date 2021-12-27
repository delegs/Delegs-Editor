package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.IdFactory;

public class DocumentItemTest {

	private FileItem documentItem;
	private Date creation;
	private Date change;
	private IdFactory idFactory;
	private String username;
	private FileItemColorLabel colorLabel;

	@Before
	public void setUp() throws Exception {
		creation = new Date();
		change = new Date();
		username = "user";
		colorLabel = FileItemColorLabel.RED;

		idFactory = new IdFactory(System.currentTimeMillis());
		documentItem = new DocumentItem(idFactory.createId(), username, new FileTitle("docName"), creation, change,
				colorLabel);
	}

	@Test
	public void test() {

		assertEquals("user", documentItem.getOwner());

		assertEquals("docName", documentItem.getFileTitle().getTitleString());

		assertEquals(creation, documentItem.getCreationDate());
		assertEquals(change, documentItem.getChangeDate());

		assertEquals(creation, documentItem.getCreationDate());

		// different ID
		FileItem doc2 = new DocumentItem(idFactory.createId(), username, new FileTitle("docName"), creation, change,
				colorLabel);
		assertFalse(doc2.equals(documentItem));

		assertEquals(documentItem, documentItem);

		FileItem doc3 = new DocumentItem(
				idFactory.reconstructId(documentItem.getId().getUpperIdPart(), documentItem.getId().getLowerIdPart()),
				username, new FileTitle("docName"), creation, change, colorLabel);

		assertEquals(doc3, documentItem);

		FileItem docDifferentColor = new DocumentItem(
				idFactory.reconstructId(documentItem.getId().getUpperIdPart(), documentItem.getId().getLowerIdPart()),
				username, new FileTitle("docName"), creation, change, FileItemColorLabel.GREEN);
		assertEquals(docDifferentColor, documentItem);
	}
}
