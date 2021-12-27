package de.signWritingEditor.test.integration.ui.collage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.CollagePanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ExtendedRichTextArea;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.Pair;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.test.integration.infrastructure.CopyPasteIntegrationTestCase;

public class CopyPasteIntegrationTest extends CopyPasteIntegrationTestCase {

	private Clipboard clipboard;
	private TokenFactory tokenFactory;
	private DocumentPanel documentPanel;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();

		documentPanel = (DocumentPanel) getPanel(getGwtDocumentEditor());
		clipboard = getClipBoard(getGwtDocumentEditor());
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		tokenFactory = new TokenFactory(getIdFactory());
	}

	@Override
	protected void gwtTearDown() throws Exception {
		super.gwtTearDown();
	}

	public DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	public TokenFactory getTokenFactory() {
		return tokenFactory;
	}

	@Test
	public void testPasteTokensWithFreeTextLineToPage() {
		Pair<String, List<Section>> copiedSection = createCopyConstructWithOneSectionAndMultipleParagraphsWithFreeTextLines();

		getClipboard().setText(copiedSection.getA());
		getClipboard().setContent(copiedSection.getB());
		int tokenCount = countToken(copiedSection.getB());

		getDocumentEditorSidebarListener().onAddCollage();
		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		assertEquals(CollagePageLayout.class, getGwtDocumentLayouter().getPage(1).getClass());
		assertEquals(CollagePanel.class, getDocumentPanel().getPage(1).getParent().getClass());
		CollagePanel collage = (CollagePanel) getDocumentPanel().getPage(1).getParent();
		ExtendedRichTextArea area = getCollageInvisibleTextArea(collage);
		area.setFocus(true);

		// Action
		createPasteEvent(copiedSection.getA(), area);

		// Test
		assertEquals(1, getDocumentPanel().getSnippetCount(1));
		assertEquals(200, getDocumentPanel().getSnippet(1, 0).getOffsetWidth());
		assertEquals(6, getDocumentPanel().getLineCount(new LineIndex(1, 0, 0)));

		AbstractTokenBoxWidget tokenBoxWidget100 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 0, 0));
		assertNotNull(tokenBoxWidget100);
		assertEquals(LayoutedSignItemTokenBoxWidget.class, tokenBoxWidget100.getClass());
		AbstractTokenBoxWidget tokenBoxWidget101 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 1, 0));
		assertNotNull(tokenBoxWidget101);
		assertEquals(LayoutedSignItemTokenBoxWidget.class, tokenBoxWidget101.getClass());
		AbstractTokenBoxWidget tokenBoxWidget102 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 2, 0));
		assertNotNull(tokenBoxWidget102);
		assertEquals(FreeTextTokenBoxWidget.class, tokenBoxWidget102.getClass());
		AbstractTokenBoxWidget tokenBoxWidget103 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 3, 0));
		assertNotNull(tokenBoxWidget103);
		assertEquals(LayoutedSignItemTokenBoxWidget.class, tokenBoxWidget103.getClass());
		AbstractTokenBoxWidget tokenBoxWidget104 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 4, 0));
		assertNotNull(tokenBoxWidget104);
		assertEquals(LayoutedSignItemTokenBoxWidget.class, tokenBoxWidget104.getClass());
		AbstractTokenBoxWidget tokenBoxWidget105 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 5, 0));
		assertNotNull(tokenBoxWidget105);
		assertEquals(FreeTextTokenBoxWidget.class, tokenBoxWidget105.getClass());

		assertEquals("Hi", ((SignItemTokenBox) tokenBoxWidget100.getTokenBox()).getText());
		assertEquals("Test", ((SignItemTokenBox) tokenBoxWidget101.getTokenBox()).getText());

		assertEquals("Haus", ((SignItemTokenBox) tokenBoxWidget103.getTokenBox()).getText());
		assertEquals("Hund", ((SignItemTokenBox) tokenBoxWidget104.getTokenBox()).getText());
	}

	@Test
	public void testPasteTokensWithFreeTextLineToParagraph() {
		Pair<String, List<Section>> copiedSection = createCopyConstructWithOneSectionAndMultipleParagraphsWithFreeTextLines();
		getClipboard().setText(copiedSection.getA());
		getClipboard().setContent(copiedSection.getB());
		int tokenCount = countToken(copiedSection.getB());
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getGwtDocumentEditor().getDocument().getSection(1).getCollageId();
		getDocumentUiListener().addParagraph(collageId, 0, 0, 200, true);

		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentPanel().getLineCount(new LineIndex(1, 0, 0)));

		assertEquals(SnippetLayout.class, getGwtDocumentLayouter().getSnippet(1, 0).getClass());
		assertEquals(SelectedFlowPanel.class, getDocumentPanel().getPage(1).getWidget(0).getClass());
		SelectedFlowPanel snippet = (SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0);
		ExtendedRichTextArea area = getSnippetInvisibleTextArea(snippet);
		area.setFocus(true);

		// Action
		createPasteEvent(copiedSection.getA(), area);

		// Test
		assertEquals(6, getDocumentPanel().getLineCount(new LineIndex(1, 0, 0)));

		AbstractTokenBoxWidget tokenBoxWidget100 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 0, 0));
		assertNotNull(tokenBoxWidget100);
		assertEquals(LayoutedSignItemTokenBoxWidget.class, tokenBoxWidget100.getClass());
		AbstractTokenBoxWidget tokenBoxWidget101 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 1, 0));
		assertNotNull(tokenBoxWidget101);
		assertEquals(LayoutedSignItemTokenBoxWidget.class, tokenBoxWidget101.getClass());
		AbstractTokenBoxWidget tokenBoxWidget102 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 2, 0));
		assertNotNull(tokenBoxWidget102);
		assertEquals(FreeTextTokenBoxWidget.class, tokenBoxWidget102.getClass());
		AbstractTokenBoxWidget tokenBoxWidget103 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 3, 0));
		assertNotNull(tokenBoxWidget103);
		assertEquals(LayoutedSignItemTokenBoxWidget.class, tokenBoxWidget103.getClass());
		AbstractTokenBoxWidget tokenBoxWidget104 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 4, 0));
		assertNotNull(tokenBoxWidget104);
		assertEquals(LayoutedSignItemTokenBoxWidget.class, tokenBoxWidget104.getClass());
		AbstractTokenBoxWidget tokenBoxWidget105 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 5, 0));
		assertNotNull(tokenBoxWidget105);
		assertEquals(FreeTextTokenBoxWidget.class, tokenBoxWidget105.getClass());

		assertEquals("Hi", ((SignItemTokenBox) tokenBoxWidget100.getTokenBox()).getText());
		assertEquals("Test", ((SignItemTokenBox) tokenBoxWidget101.getTokenBox()).getText());

		assertEquals("Haus", ((SignItemTokenBox) tokenBoxWidget103.getTokenBox()).getText());
		assertEquals("Hund", ((SignItemTokenBox) tokenBoxWidget104.getTokenBox()).getText());
	}

	private int countToken(List<Section> sections) {
		int count = 0;
		for (Section section : sections) {
			count += countToken(section);
		}
		return count;
	}

	private int countToken(Section section) {
		int count = 0;
		for (Paragraph paragraph : section.getParagraphs()) {
			count += countToken(paragraph);
		}
		return count;
	}

	private int countToken(Paragraph paragraph) {
		return paragraph.getTokenCount();
	}

	private Pair<String, List<Section>> createCopyConstructWithOneSectionAndMultipleParagraphsWithFreeTextLines() {

		List<Section> sections = new ArrayList<Section>();
		Section section = new Section();
		Paragraph paragraph1 = new Paragraph(getIdFactory().createId());
		paragraph1.addToken(getTokenFactory().createSignItemToken("Hi",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph1.addToken(getTokenFactory().createSignItemToken("Test",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph1.addToken(getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle()));

		Paragraph paragraph2 = new Paragraph(getIdFactory().createId());
		paragraph2.addToken(getTokenFactory().createSignItemToken("Haus",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory().createSignItemToken("Hund",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle()));

		section.addParagraph(paragraph1);
		section.addParagraph(paragraph2);
		sections.add(section);

		String copyString = "Hi Test \n Haus Hund ";

		return new Pair<String, List<Section>>(copyString, sections);
	}

}
