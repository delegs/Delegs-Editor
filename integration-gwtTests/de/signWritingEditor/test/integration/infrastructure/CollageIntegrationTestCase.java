package de.signWritingEditor.test.integration.infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.Token;

public abstract class CollageIntegrationTestCase extends IntegrationTestCase {
	private List<Id> generatedParagraphs;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
	}

	protected Document getDocument() {
		return getGwtDocumentEditor().getDocument();
	}

	protected Id generateParagraph(int sectionIndex, int x, int y, int width) {
		Id collageId = this.getDocument().getSection(sectionIndex).getCollageId();
		return generateParagraph(collageId, sectionIndex, x, y, width);
	}

	protected Id generateParagraph(Id collageId, int x, int y, int width) {
		int sectionIndex = getDocument().getSectionIndexForCollageId(collageId);
		return generateParagraph(collageId, sectionIndex, x, y, width);
	}

	private Id generateParagraph(Id collageId, int sectionIndex, int x, int y, int width) {
		getDocumentUiListener().addParagraph(collageId, x, y, width, false);
		Section section = getDocument().getSection(sectionIndex);
		Id paragraphId = section.getParagraph(section.getParagraphCount() - 1).getParagraphId();
		getGeneratedParagraphs().add(paragraphId);
		return paragraphId;
	}

	protected Id generateParagraph(int sectionIndex) {
		return generateParagraph(sectionIndex, 10, 10, 100);
	}

	protected void generateParagraphs(int count, int sectionIndex) {
		for (int i = 0; i < count; i++) {
			generateParagraph(sectionIndex);
		}
	}

	protected BoxIndex getBoxIndexFromParagraphId(Id paragraphId) {
		Paragraph paragraph = getDocument().getParagraph(paragraphId);
		Token firstToken = paragraph.getToken(0);
		BoxIndex idBoxIndex = getGwtDocumentLayouter().getIdBoxIndex(firstToken.getId());
		return idBoxIndex;
	}

	protected int getPageIndexFromParagraphId(Id paragraphId) {
		return getBoxIndexFromParagraphId(paragraphId).getPageIndex();
	}

	public List<Id> getGeneratedParagraphs() {
		if (generatedParagraphs == null) {
			this.generatedParagraphs = new ArrayList<Id>();
		}
		return generatedParagraphs;
	}

	protected native SimplePanel getSelectionBorderForSnippet(SelectedFlowPanel panel)/*-{
																										return panel.@de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::selectedBorderPanel;
																										}-*/;
}
