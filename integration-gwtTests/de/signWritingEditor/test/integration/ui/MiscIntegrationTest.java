package de.signWritingEditor.test.integration.ui;

import org.junit.Test;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.test.integration.infrastructure.IntegrationTestCase;

public class MiscIntegrationTest extends IntegrationTestCase {
	private DocumentPanel documentPanel;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		documentPanel = (DocumentPanel) getPanel(getGwtDocumentEditor());
	}

	protected DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	@Test
	public void testSetFooterText() {
		// Prepare
		String testText = "TestText im Footer";

		// Action
		getGwtDocumentEditor().setFooterText(testText);

		// Check
		assertEquals(testText, getDocumentPanel().getFooterText());
	}

}
