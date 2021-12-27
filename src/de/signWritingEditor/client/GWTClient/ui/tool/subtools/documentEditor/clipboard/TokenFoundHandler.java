package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard;

import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Token;

public class TokenFoundHandler implements ObjectFoundStorage<Paragraph> {

	private Paragraph targetParagraph;

	public TokenFoundHandler(IdFactory idFactory) {
		super();
		this.targetParagraph = new Paragraph(idFactory.createId());
	}

	@Override
	public void process(Object object, boolean hasNext) {
		if (object instanceof Token) {
			Token token = (Token) object;
			targetParagraph.addToken(token);
		}
	}

	@Override
	public Paragraph getResult() {
		return targetParagraph;
	}
}
