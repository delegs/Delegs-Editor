package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;

public class SignHistoryItemTest {

	private SignHistoryItem signHistoryItem;
	private SignId signId;
	private String authorName;
	private String comment;
	private Date date;
	private int revision;

	@Before
	public void setUp() {
		signId = new SignId(12344, "SignHistoryItem", SignLocale.DGS, SignSource.DELEGS);
		authorName = "AngeloMerte";
		comment = "Das ist mein Kommentar";
		date = new Date();
		revision = 34234;

		signHistoryItem = new SignHistoryItem(signId, authorName, comment, date, revision);
	}

	@Test
	public void testGetSignId() {
		assertEquals(signId, signHistoryItem.getSignId());
	}

	@Test
	public void testGetDate() {
		assertEquals(date, signHistoryItem.getDate());
	}

	@Test
	public void testGetAuthorname() {
		assertEquals(authorName, signHistoryItem.getAuthorname());
	}

	@Test
	public void testgetComment() {
		assertEquals(comment, signHistoryItem.getComment());
	}

	@Test
	public void testGetRevision() {
		assertEquals(revision, signHistoryItem.getRevision());
	}

	@Test
	public void testEquals() {

		SignHistoryItem equalsOtherSignHistoryItem = new SignHistoryItem(signId, authorName, comment, date, revision);
		assertEquals(equalsOtherSignHistoryItem, signHistoryItem);

		SignHistoryItem equalsOtherSignHistoryItemWithDifferentAuthorName = new SignHistoryItem(signId, "Test", comment,
				date, revision);
		assertEquals(equalsOtherSignHistoryItemWithDifferentAuthorName, signHistoryItem);

		SignHistoryItem equalsOtherSignHistoryItemWithDifferentDate = new SignHistoryItem(signId, authorName, comment,
				new Date(2), revision);
		assertEquals(equalsOtherSignHistoryItemWithDifferentDate, signHistoryItem);

		SignHistoryItem differenSignHistoryItemWithOtherSignId = new SignHistoryItem(
				new SignId(44444444, "WhatWord", SignLocale.ASL, SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS),
				authorName, comment, date, revision);
		assertFalse(differenSignHistoryItemWithOtherSignId.equals(signHistoryItem));

		SignHistoryItem differenSignHistoryItemWithOtherRevision = new SignHistoryItem(signId, authorName, comment,
				date, revision + 3);
		assertFalse(differenSignHistoryItemWithOtherRevision.equals(signHistoryItem));

		SignHistoryItem differentSignHistoryItemWithOtherComment = new SignHistoryItem(signId, authorName,
				"An other comment.", date, revision);
		assertFalse(differentSignHistoryItemWithOtherComment.equals(signHistoryItem));
	}

	@Test
	public void testHashCode() {

		SignHistoryItem equalsOtherSignHistoryItem = new SignHistoryItem(signId, authorName, comment, date, revision);
		assertEquals(equalsOtherSignHistoryItem.hashCode(), signHistoryItem.hashCode());

		SignHistoryItem equalsOtherSignHistoryItemWithDifferentAuthorName = new SignHistoryItem(signId, "Test", comment,
				date, revision);
		assertEquals(equalsOtherSignHistoryItemWithDifferentAuthorName.hashCode(), signHistoryItem.hashCode());

		SignHistoryItem equalsOtherSignHistoryItemWithDifferentComment = new SignHistoryItem(signId, authorName,
				"An other comment.", date, revision);
		assertEquals(equalsOtherSignHistoryItemWithDifferentComment.hashCode(), signHistoryItem.hashCode());

		SignHistoryItem equalsOtherSignHistoryItemWithDifferentDate = new SignHistoryItem(signId, authorName, comment,
				new Date(2), revision);
		assertEquals(equalsOtherSignHistoryItemWithDifferentDate.hashCode(), signHistoryItem.hashCode());

		SignHistoryItem differenSignHistoryItemWithOtherSignId = new SignHistoryItem(
				new SignId(44444444, "WhatWord", SignLocale.ASL, SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS),
				authorName, comment, date, revision);
		assertFalse(differenSignHistoryItemWithOtherSignId.hashCode() == signHistoryItem.hashCode());

		SignHistoryItem differenSignHistoryItemWithOtherRevision = new SignHistoryItem(signId, authorName, comment,
				date, revision + 3);
		assertFalse(differenSignHistoryItemWithOtherRevision.hashCode() == signHistoryItem.hashCode());
	}
}
