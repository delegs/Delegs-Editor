package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForExistingUserMock;
import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForUnknownUserMock;
import de.signWritingEditor.client.GWTClient.infrastructure.URLConverterClientImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.Tool.SavingFinishedListener;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.client.service.ContentReportServiceAsync;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.LoggingServiceAsync;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.client.service.UserServiceAsync;
import de.signWritingEditor.client.service.VideoServiceAsync;
import de.signWritingEditor.infrastructure.BadgeServiceMock;
import de.signWritingEditor.infrastructure.ContentReportServiceAsyncMock;
import de.signWritingEditor.infrastructure.DictionaryServiceAsyncMock;
import de.signWritingEditor.infrastructure.DocumentEditorListenerMock;
import de.signWritingEditor.infrastructure.DocumentServiceAsyncMock;
import de.signWritingEditor.infrastructure.LoggingServiceAsyncMock;
import de.signWritingEditor.infrastructure.MediaUrlServiceAsyncMock;
import de.signWritingEditor.infrastructure.PdfServiceAsyncMock;
import de.signWritingEditor.infrastructure.UserServiceAsyncMock;
import de.signWritingEditor.infrastructure.VideoServiceAsyncMock;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.test.integration.infrastructure.BrowserHistoryServiceMock;
import de.signWritingEditor.test.integration.infrastructure.IntegrationTestCase;

public class GWTDocumentEditorSaveTest extends IntegrationTestCase {

	private int permissionDeniedDialogCounter;
	private int openSaveDocumentDialogBoxCounter;
	private GWTDocumentEditorMock gwtDocumentEditorMock;

	@Test
	public void testHandleSave_tooManyTokensInsertedByUnknownUser() {
		// Prepare
		createGWTDocumentEditorMockExceedingMaxTokenCount(new LocalSessionServiceForUnknownUserMock());

		// Action
		gwtDocumentEditorMock.handleSave(new SavingFinishedListener() {
			@Override
			public void onSavingFinished() {
				fail();
			}
		});

		// Check
		assertEquals(1, permissionDeniedDialogCounter);
	}

	@Test
	public void testHandleSave_maximalTokensInsertedByUnknownUser() {
		// Prepare
		createGWTDocumentEditorMockWithMaxTokenCount(new LocalSessionServiceForUnknownUserMock());

		// Action
		gwtDocumentEditorMock.handleSave(new SavingFinishedListener() {
			@Override
			public void onSavingFinished() {
				// Nothing to do here...
			}
		});

		// Check
		assertEquals(1, openSaveDocumentDialogBoxCounter);
	}

	@Test
	public void testHandleSaveAs_tooManyTokensInsertedByUnknownUser() {
		// Prepare
		createGWTDocumentEditorMockExceedingMaxTokenCount(new LocalSessionServiceForUnknownUserMock());

		// Action
		gwtDocumentEditorMock.handleSaveAs();

		// Check
		assertEquals(1, permissionDeniedDialogCounter);
	}

	@Test
	public void testHandleSaveAs_maximalTokensInsertedByUnknownUser() {
		// Prepare
		createGWTDocumentEditorMockWithMaxTokenCount(new LocalSessionServiceForUnknownUserMock());

		// Action
		gwtDocumentEditorMock.handleSaveAs();

		// Check
		assertEquals(1, openSaveDocumentDialogBoxCounter);
	}

	@Test
	public void testHandleSave_moreTokensThanMaxTokenCountInsertedWithExistingUser() {
		// Prepare
		createGWTDocumentEditorMockExceedingMaxTokenCount(new LocalSessionServiceForExistingUserMock());

		// Action
		gwtDocumentEditorMock.handleSave(new SavingFinishedListener() {
			@Override
			public void onSavingFinished() {
				// Nothing to do here...
			}
		});

		// Check
		assertEquals(1, openSaveDocumentDialogBoxCounter);
	}

	@Test
	public void testHandleSaveAs_moreTokensThanMaxTokenCountInsertedWithExistingUser() {
		// Prepare
		createGWTDocumentEditorMockExceedingMaxTokenCount(new LocalSessionServiceForExistingUserMock());

		// Action
		gwtDocumentEditorMock.handleSaveAs();

		// Check
		assertEquals(1, openSaveDocumentDialogBoxCounter);
	}

	private void createGWTDocumentEditorMockWithMaxTokenCount(LocalSessionService localSessionService) {
		gwtDocumentEditorMock = createMock(localSessionService);
		createEmptyTokens(gwtDocumentEditorMock, gwtDocumentEditorMock.getMaxTokenCountForUnknownUser()
				- gwtDocumentEditorMock.getDocument().getTokenCount());
	}

	private void createGWTDocumentEditorMockExceedingMaxTokenCount(LocalSessionService localSessionService) {
		gwtDocumentEditorMock = createMock(localSessionService);
		createEmptyTokens(gwtDocumentEditorMock, gwtDocumentEditorMock.getMaxTokenCountForUnknownUser() + 1);
	}

	private void createEmptyTokens(GWTDocumentEditor documentEditor, int tokenCount) {
		Id firstTokenId = documentEditor.getDocument().getFirstTokenInDocument().getId();
		List<Token> tokens = createEmptyTokens(tokenCount);
		documentEditor.insertTokensAfter(firstTokenId, tokens);
	}

	private List<Token> createEmptyTokens(int tokenCount) {
		List<Token> tokenList = new ArrayList<Token>(tokenCount);

		for (int i = 0; i < tokenCount; i++) {
			tokenList.add(getTokenFactory()
					.createFreeTextToken(getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle()));
		}

		return tokenList;
	}

	private GWTDocumentEditorMock createMock(LocalSessionService localSessionService) {
		return new GWTDocumentEditorMock(new UserServiceAsyncMock(), new DictionaryServiceAsyncMock(),
				new DocumentServiceAsyncMock(getIdFactory()), new PdfServiceAsyncMock(), new VideoServiceAsyncMock(),
				new MediaUrlServiceAsyncMock(), new LoggingServiceAsyncMock(), new BrowserHistoryServiceMock(),
				new BadgeServiceMock(), new ContentReportServiceAsyncMock(), new URLConverterClientImpl(),
				getIdFactory(), getTextbasedTokenStyleFactory(), "Test app", localSessionService, createDummyRoot(),
				true, SignLocale.DGS, new DocumentEditorListenerMock(), new TokenBoxFactory(getFontSizeService()),
				getFontSizeService());
	}

	private class GWTDocumentEditorMock extends GWTDocumentEditor {
		public GWTDocumentEditorMock(UserServiceAsync userService, DictionaryServiceAsync dictionaryService,
				DocumentServiceAsync documentService, PdfServiceAsync pdfService, VideoServiceAsync videoService,
				MediaUrlServiceAsync mediaUrlService, LoggingServiceAsync loggingService,
				BrowserHistoryService browserHistoryService, BadgeServiceClient badgeService,
				ContentReportServiceAsync contentReportService, URLConverter urlConverter, IdFactory idFactory,
				TextbasedTokenStyleFactory textbasedTokenStyleFactory, String applicationTitle,
				LocalSessionService localSessionService, RoomItem rootRoom, boolean createNewDocument,
				SignLocale defaultSignLocale, DocumentEditorListener listener, TokenBoxFactory tokenBoxFactory,
				FontSizeService fontSizeService) {
			super(userService, dictionaryService, documentService, pdfService, videoService, mediaUrlService,
					loggingService, browserHistoryService, badgeService, contentReportService, urlConverter, idFactory,
					textbasedTokenStyleFactory, applicationTitle, localSessionService, rootRoom, createNewDocument,
					defaultSignLocale, listener, tokenBoxFactory, fontSizeService);
		}

		@Override
		protected void openPermissionToSaveDeniedDialogBox() {
			permissionDeniedDialogCounter++;
		}

		@Override
		protected void openSaveDocumentDialogBox(FileTitle fileTitle, final DocumentSaveSuccessListener listener) {
			++openSaveDocumentDialogBoxCounter;
		}

		@Override
		protected int getMaxTokenCountForUnknownUser() {
			return 10;
		}
	}

}
