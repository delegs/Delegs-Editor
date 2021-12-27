package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import de.signWritingEditor.client.GWTClient.infrastructure.CopyDocumentEditorMock;
import de.signWritingEditor.client.GWTClient.infrastructure.CopyPasteUnitTestCase;
import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForUnknownUserMock;
import de.signWritingEditor.infrastructure.BadgeServiceMock;
import de.signWritingEditor.infrastructure.DictionaryServiceAsyncMock;
import de.signWritingEditor.infrastructure.DocumentEditorListenerMock;
import de.signWritingEditor.infrastructure.DocumentServiceAsyncMock;
import de.signWritingEditor.infrastructure.FontSizeServiceMock;
import de.signWritingEditor.infrastructure.GWTDocumentLayouterMock;
import de.signWritingEditor.infrastructure.MediaUrlServiceAsyncMock;
import de.signWritingEditor.infrastructure.PdfServiceAsyncMock;
import de.signWritingEditor.infrastructure.VideoServiceAsyncMock;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.test.integration.infrastructure.BrowserHistoryServiceMock;

public class DocumentEditorCopyTest extends CopyPasteUnitTestCase {

	private DocumentEditor documentEditor;
	private Clipboard clipboard;

	@Override
	public void setUp() throws Exception {
		super.setUp();

		documentEditor = new CopyDocumentEditorMock(new DictionaryServiceAsyncMock(),
				new DocumentServiceAsyncMock(getIdFactory()), new PdfServiceAsyncMock(), new VideoServiceAsyncMock(),
				new MediaUrlServiceAsyncMock(), new BrowserHistoryServiceMock(), new FontSizeServiceMock(),
				new BadgeServiceMock(), getIdFactory(), getStyleFactory(), new LocalSessionServiceForUnknownUserMock(),
				createDummyRoot(), SignLocale.DGS, new DocumentEditorListenerMock());

		CopyDocumentEditorMock copyDocumentEditorMock = (CopyDocumentEditorMock) documentEditor;
		clipboard = copyDocumentEditorMock.getClipboard();
		copyDocumentEditorMock.setDocument(getDocument());
		copyDocumentEditorMock.setDocumentLayouter(new GWTDocumentLayouterMock() {
			@Override
			public BoxIndex getIdBoxIndex(Id id) {
				return new BoxIndex(0, 0, 0);
			}
		});
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	public DocumentEditor getDocumentEditor() {
		return documentEditor;
	}

	private void selectToken(Id leftTokenId, Id rightTokenId) {
		setFieldValue(getDocumentEditor(), DocumentEditor.class, "firstSelectedTokenId", leftTokenId);
		setFieldValue(getDocumentEditor(), DocumentEditor.class, "currentCursorTokenId", rightTokenId);
	}

	private void selectSnippets(Paragraph... paragraphs) {
		for (Paragraph paragraph : paragraphs) {
			getDocumentEditor().handleToggleSnippetSelection(paragraph.getParagraphId(), true);
		}
	}

	@Test
	public void testOnCopyOnlyTokensInOneParagraph() {
		// Prepare
		Paragraph paragraph = getDocument().getParagraph(0, 1);
		assertTrue(paragraph.getTokenCount() > 3);
		Id leftTokenId = paragraph.getToken(0).getId();
		Id rightTokenId = paragraph.getToken(3).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		assertNotNull(getClipboard().getContent());
		assertTrue(getClipboard().getContent() instanceof List);
		List<Section> content = getClipboard().getContent();
		assertEquals(1, content.size());
		Section copiedSection = content.get(0);
		assertEquals(1, copiedSection.getParagraphCount());
		Paragraph copiedParagraph = copiedSection.getParagraph(0);
		assertEquals(4, copiedParagraph.getTokenCount());
		assertEquals(getDocument().getToken(leftTokenId), copiedParagraph.getToken(0));
		assertEquals(getDocument().getToken(rightTokenId),
				copiedParagraph.getToken(copiedParagraph.getTokenCount() - 1));
	}

	@Test
	public void testOnCopyTwoPartialParagraphs() {
		// Prepare
		Paragraph paragraph = getDocument().getParagraph(1, 0);
		Paragraph paragraph2 = getDocument().getParagraph(1, 1);
		assertTrue(paragraph.getTokenCount() == 6);
		Id leftTokenId = paragraph.getToken(5).getId();
		Id rightTokenId = paragraph2.getToken(0).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		assertNotNull(getClipboard().getContent());
		assertTrue(getClipboard().getContent() instanceof List);
		List<Section> content = getClipboard().getContent();
		assertEquals(1, content.size());
		Section copiedSection = content.get(0);
		assertEquals(2, copiedSection.getParagraphCount());
		Paragraph copiedParagraph = copiedSection.getParagraph(0);
		Paragraph copiedParagraph2 = copiedSection.getParagraph(copiedSection.getParagraphCount() - 1);
		assertEquals(getDocument().getToken(leftTokenId), copiedParagraph.getToken(0));
		assertEquals(getDocument().getToken(rightTokenId),
				copiedParagraph2.getToken(copiedParagraph2.getTokenCount() - 1));
	}

	@Test
	public void testOnCopyTokensAndCompleteParagraphs() {
		// Prepare
		Section section1 = getDocument().getSection(0);
		Section section2 = getDocument().getSection(1);

		Paragraph paragraph = section1.getParagraph(0);
		Paragraph paragraph2 = section2.getParagraph(section2.getParagraphCount() - 1);

		Id leftTokenId = paragraph.getToken(0).getId();
		Id rightTokenId = paragraph2.getToken(0).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		assertNotNull(getClipboard().getContent());
		assertTrue(getClipboard().getContent() instanceof List);
		List<Section> content = getClipboard().getContent();
		assertEquals(2, content.size());
		Section copiedSection = content.get(0);
		Section copiedSection2 = content.get(content.size() - 1);
		assertEquals(section1.getParagraphCount(), copiedSection.getParagraphCount());
		assertEquals(section2.getParagraphCount(), copiedSection2.getParagraphCount());
		Paragraph copiedFirstParagraph = copiedSection.getParagraph(0);
		Paragraph copiedLastParagraph = copiedSection2.getParagraph(copiedSection2.getParagraphCount() - 1);
		assertEquals(getDocument().getToken(leftTokenId), copiedFirstParagraph.getToken(0));
		assertEquals(getDocument().getToken(rightTokenId),
				copiedLastParagraph.getToken(copiedLastParagraph.getTokenCount() - 1));
	}

	@Test
	public void testOnCopyTokensAndSections() {
		// Prepare
		Section section1 = getDocument().getSection(0);
		Section section2 = getDocument().getSection(2);

		Paragraph paragraph = section1.getParagraph(0);
		Paragraph paragraph2 = section2.getParagraph(section2.getParagraphCount() - 1);

		Id leftTokenId = paragraph.getToken(0).getId();
		Id rightTokenId = paragraph2.getToken(paragraph2.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		assertNotNull(getClipboard().getContent());
		assertTrue(getClipboard().getContent() instanceof List);
		List<Section> content = getClipboard().getContent();
		assertEquals(3, content.size());
		Section copiedSection = content.get(0);
		Section copiedSection2 = content.get(2);
		assertEquals(section1.getParagraphCount(), copiedSection.getParagraphCount());
		assertEquals(section2.getParagraphCount(), copiedSection2.getParagraphCount());
		Paragraph copiedFirstParagraph = copiedSection.getParagraph(0);
		Paragraph copiedLastParagraph = copiedSection2.getParagraph(copiedSection2.getParagraphCount() - 1);
		assertEquals(getDocument().getToken(leftTokenId), copiedFirstParagraph.getToken(0));
		assertEquals(getDocument().getToken(rightTokenId),
				copiedLastParagraph.getToken(copiedLastParagraph.getTokenCount() - 1));
	}

	@Test
	public void testOnCopyOverPartialSections() {
		// Prepare
		Section section1 = getDocument().getSection(0);
		Paragraph paragraph1 = section1.getParagraph(section1.getParagraphCount() - 1);
		Section section2 = getDocument().getSection(1);
		Paragraph paragraph2 = section2.getParagraph(section2.getParagraphCount() - 1);
		Id leftTokenId = paragraph1.getToken(0).getId();
		Id rightTokenId = paragraph2.getToken(paragraph2.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		assertNotNull(getClipboard().getContent());
		assertTrue(getClipboard().getContent() instanceof List);
		List<Section> content = getClipboard().getContent();
		assertEquals(2, content.size());
		Section copiedSection = content.get(0);
		Section copiedSection2 = content.get(1);
		assertEquals(1, copiedSection.getParagraphCount());
		assertEquals(paragraph1, copiedSection.getParagraph(0));
		assertEquals(section2, copiedSection2);
	}

	@Test
	public void testOnCopyOverTwoPartialSectionsWithDifferentTokenCounts() {
		// Prepare
		Section section1 = getDocument().getSection(0);
		Paragraph paragraph1 = section1.getParagraph(section1.getParagraphCount() - 1);
		paragraph1.removeToken(0); // causes different token count
		Section section2 = getDocument().getSection(1);
		Paragraph paragraph2 = section2.getParagraph(section2.getParagraphCount() - 1);
		Id leftTokenId = paragraph1.getToken(0).getId();
		Id rightTokenId = paragraph2.getToken(paragraph2.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		assertNotNull(getClipboard().getContent());
		assertTrue(getClipboard().getContent() instanceof List);
		List<Section> content = getClipboard().getContent();
		assertEquals(2, content.size());
		Section copiedSection = content.get(0);
		Section copiedSection2 = content.get(1);
		assertEquals(1, copiedSection.getParagraphCount());
		assertEquals(paragraph1, copiedSection.getParagraph(0));
		assertEquals(section2, copiedSection2);
	}

	@Test
	public void testOnCopyOverCompleteSections() {
		// Prepare
		Section section = getDocument().getSection(0);
		Section section2 = getDocument().getSection(1);
		Paragraph paragraphFrom = section.getParagraph(0);
		Paragraph paragraphTo = section2.getParagraph(1);
		Id leftTokenId = paragraphFrom.getToken(0).getId();
		Id rightTokenId = paragraphTo.getToken(paragraphTo.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		assertNotNull(getClipboard().getContent());
		assertTrue(getClipboard().getContent() instanceof List);
		List<Section> content = getClipboard().getContent();
		assertEquals(2, content.size());
		Section copiedSection = content.get(0);
		Section copiedSection2 = content.get(1);
		assertEquals(section, copiedSection);
		assertEquals(section2, copiedSection2);
	}

	@Test
	public void testOnCopyClipboardTextForAllTokensInParagraph() {
		// Prepare
		Paragraph paragraph = getDocument().getParagraph(0, 1);
		assertTrue(paragraph.getTokenCount() > 3);
		Id leftTokenId = paragraph.getToken(0).getId();
		Id rightTokenId = paragraph.getToken(paragraph.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		String clipboardText = getClipboard().getText();
		assertNotNull(clipboardText);
		assertEquals("Spiderschwein Spiderschwein macht was ein Spiderschwein so tut", clipboardText);
	}

	@Test
	public void testOnCopyClipboardTextOverTwoParagraphs() {
		// Prepare
		Paragraph paragraph = getDocument().getParagraph(1, 0);
		assertTrue(paragraph.getTokenCount() > 3);
		Paragraph paragraph2 = getDocument().getParagraph(1, 1);
		Id leftTokenId = paragraph.getToken(0).getId();
		Id rightTokenId = paragraph2.getToken(paragraph2.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		String clipboardText = getClipboard().getText();
		assertNotNull(clipboardText);
		assertEquals("Da . Da . Da .\nIch lieb dich nicht du liebst mich nicht", clipboardText);
	}

	@Test
	public void testOnCopyClipboardTextForTwoSnippets() {
		// Prepare
		Paragraph paragraph = getDocument().getParagraph(0, 1);
		Paragraph paragraph2 = getDocument().getParagraph(1, 1);

		// Action
		selectSnippets(paragraph, paragraph2);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		String clipboardText = getClipboard().getText();
		assertNotNull(clipboardText);
		assertEquals(
				"Spiderschwein Spiderschwein macht was ein Spiderschwein so tut\nIch lieb dich nicht du liebst mich nicht",
				clipboardText);
	}

	@Test
	public void testOnCopyClipboardTextOverTwoPartialSections() {
		// Prepare
		Paragraph paragraph = getDocument().getParagraph(0, 1);
		assertTrue(paragraph.getTokenCount() > 3);
		Paragraph paragraph2 = getDocument().getParagraph(1, 1);
		Id leftTokenId = paragraph.getToken(0).getId();
		Id rightTokenId = paragraph2.getToken(paragraph2.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		String clipboardText = getClipboard().getText();
		assertNotNull(clipboardText);
		assertEquals(
				"Spiderschwein Spiderschwein macht was ein Spiderschwein so tut\fDa . Da . Da .\nIch lieb dich nicht du liebst mich nicht",
				clipboardText);
	}

	@Test
	public void testOnCopyClipboardTextOverTwoPartialSectionsWithDifferentTokenCounts() {
		// Prepare
		Paragraph paragraph = getDocument().getParagraph(0, 1);
		paragraph.removeToken(0); // causes different token counts
		assertTrue(paragraph.getTokenCount() > 3);
		Paragraph paragraph2 = getDocument().getParagraph(1, 1);
		Id leftTokenId = paragraph.getToken(0).getId();
		Id rightTokenId = paragraph2.getToken(paragraph2.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		String clipboardText = getClipboard().getText();
		assertNotNull(clipboardText);
		assertEquals(
				"Spiderschwein macht was ein Spiderschwein so tut\fDa . Da . Da .\nIch lieb dich nicht du liebst mich nicht",
				clipboardText);
	}

	@Test
	public void testOnCopyClipboardTextOverTwoCompleteSections() {
		// Prepare
		Paragraph paragraph = getDocument().getParagraph(0, 0);
		Paragraph paragraph2 = getDocument().getParagraph(1, 1);
		Id leftTokenId = paragraph.getToken(0).getId();
		Id rightTokenId = paragraph2.getToken(paragraph2.getTokenCount() - 1).getId();

		// Action
		selectToken(leftTokenId, rightTokenId);
		callMethod(documentEditor, DocumentEditor.class, "handleCopy");

		// Check
		String clipboardText = getClipboard().getText();
		assertNotNull(clipboardText);
		assertEquals(
				"Hallo\nSpiderschwein Spiderschwein macht was ein Spiderschwein so tut\fDa . Da . Da .\nIch lieb dich nicht du liebst mich nicht",
				clipboardText);
	}

}
