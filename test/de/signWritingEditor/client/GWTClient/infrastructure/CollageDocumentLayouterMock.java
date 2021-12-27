package de.signWritingEditor.client.GWTClient.infrastructure;

import de.signWritingEditor.infrastructure.GWTDocumentLayouterMock;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.ContinuousPageLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.Token;

public class CollageDocumentLayouterMock extends GWTDocumentLayouterMock {
	private String addTokenWord;
	private boolean isSearchWordVisible;
	private PageFormat pageFormat;
	private Id newTokenId;
	private boolean isRemoveTokenBoxesCalled;
	private Document dummyDocument;
	private int pageCount;

	public CollageDocumentLayouterMock(Document document) {
		dummyDocument = document;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public int getPageCount() {
		return pageCount;
	}

	@Override
	public PageLayout getPage(int pageIndex) {
		return new CollagePageLayout(getPageFormat(), getNewTokenId(), true);
	}

	@Override
	public void addPage(PageFormat pageFormat) {
		this.pageFormat = pageFormat;
	}

	@Override
	public void addToken(Token token, boolean searchWordVisible, boolean signVisible) {
		assert token != null : "Precondition failed: token != null";
		assert token instanceof SignItemToken : "Precondition failed: token instanceof SignItemToken";

		this.newTokenId = token.getId();
		this.addTokenWord = ((SignItemToken) token).getText();
		this.isSearchWordVisible = searchWordVisible;
	}

	@Override
	public Id getLastTokenIdInLine(Id tokenId) {
		return dummyDocument.getToken(0, 0, 0).getId();
	}

	@Override
	public void removeTokenBox(Id tokenBoxId) {
		isRemoveTokenBoxesCalled = true;
	}

	@Override
	public BoxIndex getIdBoxIndex(Id id) {
		return new BoxIndex(0, 0, 0);
	}

	@Override
	public void scrollToTopOfPageWithNumber(int pageIndex) {
	}

	private ContinuousPageLayout createDummyPageLayout() {
		return new ContinuousPageLayout(PageFormat.A4_LANDSCAPE);
	}

	public String getAddTokenWord() {
		return addTokenWord;
	}

	public boolean isSearchWordVisible() {
		return isSearchWordVisible;
	}

	public PageFormat getPageFormat() {
		return pageFormat;
	}

	public void setPageFormat(PageFormat format) {
	}

	public Id getNewTokenId() {
		return newTokenId;
	}

	public boolean isRemoveTokenBoxesCalled() {
		return isRemoveTokenBoxesCalled;
	}
}
