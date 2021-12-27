package de.signWritingEditor.client.GWTClient.infrastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Before;

import de.signWritingEditor.infrastructure.UnitTestCase;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;

public abstract class CopyPasteUnitTestCase extends UnitTestCase {

	private IdFactory idFactory;
	private TokenFactory tokenFactory;
	private Document dummyDocument;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp() throws Exception {
		idFactory = new IdFactory(10);
		tokenFactory = new TokenFactory(getIdFactory());
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		dummyDocument = createDummyDocument();
	}

	protected TokenFactory getTokenFactory() {
		return tokenFactory;
	}

	protected TextbasedTokenStyleFactory getStyleFactory() {
		return textbasedTokenStyleFactory;
	}

	protected Document getDocument() {
		return dummyDocument;
	}

	protected IdFactory getIdFactory() {
		return idFactory;
	}

	protected Document createDummyDocument() {
		PageFormat format = new PageFormat("Hochkant", Orientation.HORIZONTAL, 72, 300, 200, 1, 1, 1, 1);
		Document document = new Document(
				new User("peterle", "peter", "parker", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
				SignLocale.DGS, new FileTitle("Erstes Dokument"), format);
		Section section = new Section();
		Paragraph paragraph = new Paragraph(getIdFactory().createId());
		paragraph.addToken(getTokenFactory().createSignItemToken("Hallo",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		section.addParagraph(paragraph);
		Paragraph paragraph2 = new Paragraph(getIdFactory().createId());
		paragraph2.addToken(getTokenFactory().createSignItemToken("Spiderschwein",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory().createSignItemToken("Spiderschwein",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory().createSignItemToken("macht",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory().createSignItemToken("was",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory().createSignItemToken("ein",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory().createSignItemToken("Spiderschwein",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory().createSignItemToken("so",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory().createSignItemToken("tut",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		section.addParagraph(paragraph2);
		document.addSection(section);

		Section section2 = new Section();
		Paragraph paragraph3 = new Paragraph(getIdFactory().createId());
		paragraph3.addToken(getTokenFactory().createSignItemToken("Da",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph3.addToken(getTokenFactory().createSignItemToken(".",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph3.addToken(getTokenFactory().createSignItemToken("Da",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph3.addToken(getTokenFactory().createSignItemToken(".",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph3.addToken(getTokenFactory().createSignItemToken("Da",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph3.addToken(getTokenFactory().createSignItemToken(".",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		section2.addParagraph(paragraph3);

		Paragraph paragraph4 = new Paragraph(getIdFactory().createId());
		paragraph4.addToken(getTokenFactory().createSignItemToken("Ich",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph4.addToken(getTokenFactory().createSignItemToken("lieb",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph4.addToken(getTokenFactory().createSignItemToken("dich",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph4.addToken(getTokenFactory().createSignItemToken("nicht",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph4.addToken(getTokenFactory().createSignItemToken("du",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph4.addToken(getTokenFactory().createSignItemToken("liebst",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph4.addToken(getTokenFactory().createSignItemToken("mich",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph4.addToken(getTokenFactory().createSignItemToken("nicht",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		section2.addParagraph(paragraph4);

		Section section3 = new Section();
		Paragraph paragraph5 = new Paragraph(getIdFactory().createId());
		paragraph5.addToken(getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		section3.addParagraph(paragraph5);

		Section section4 = new Section();
		Paragraph paragraph6 = new Paragraph(getIdFactory().createId());
		paragraph6.addToken(getTokenFactory().createSignItemToken("This",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph6.addToken(getTokenFactory().createSignItemToken("is",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph6.addToken(getTokenFactory().createSignItemToken("The",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph6.addToken(getTokenFactory().createSignItemToken("End",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph6.addToken(getTokenFactory().createSignItemToken("My",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph6.addToken(getTokenFactory().createSignItemToken("only",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph6.addToken(getTokenFactory().createSignItemToken("Friend",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph6.addToken(getTokenFactory().createSignItemToken("The",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph6.addToken(getTokenFactory().createSignItemToken("End",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		section4.addParagraph(paragraph6);

		document.addSection(section2);
		document.addSection(section3);
		document.addSection(section4);
		return document;
	}

	protected RoomItem createDummyRoot() {
		return new RoomItem(RoomItem.ROOT_FOLDER_ID, "user", new ArrayList<String>(), new ArrayList<String>(),
				new FileTitle("/"), new Date(), new Date(), RoomPolicy.SHARED_CONTENT);
	}
}
