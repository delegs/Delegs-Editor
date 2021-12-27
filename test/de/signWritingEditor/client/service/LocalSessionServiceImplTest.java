package de.signWritingEditor.client.service;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.signWritingEditor.client.service.infrastructure.AuthenticationServiceAsyncMock;
import de.signWritingEditor.client.service.infrastructure.SessionServiceAsyncMock;

public class LocalSessionServiceImplTest {

	private SessionServiceAsync sessionService = new SessionServiceAsyncMock();
	private AuthenticationServiceAsync authenticationService = new AuthenticationServiceAsyncMock();
	private LocalSessionService localSessionService = new LocalSessionServiceImpl(sessionService, null,
			authenticationService, new StoringReporter());

	private int methodCallCounter;

	private String reportedTitle;
	private String reportedMessage;

	class StoringReporter implements LocalSessionServiceImpl.Reporter {
		@Override
		public void report(String title, String message) {
			reportedTitle = title;
			reportedMessage = message;
		}
	}

	@Test
	public void testLoginHans() {
		localSessionService.setLocalSessionServiceListener(new LogonListener() {
			@Override
			public void onLoginFailed(String loginErrorMessage) {
				fail();
			}

			@Override
			public void onLogin() {
				assertEquals("Hans", localSessionService.getCurrentUser().getUsername());
			}
		});
		localSessionService.login("Hans", "passwort1");
	}

	@Test
	public void testLoginHansWrongPassword() {
		localSessionService.setLocalSessionServiceListener(new LogonListener() {
			@Override
			public void onLoginFailed(String loginErrorMessage) {
				fail();
			}

			@Override
			public void onLogin() {
				fail();
			}
		});
		localSessionService.login("Hans", "passwort2");
		assertTrue(localSessionService.getCurrentUser().isUnknown());
	}

	@Test
	public void testLoginFranz() {
		localSessionService.setLocalSessionServiceListener(new LogonListener() {
			@Override
			public void onLoginFailed(String loginErrorMessage) {
				++methodCallCounter;
			}

			@Override
			public void onLogin() {
				fail();
			}
		});
		localSessionService.login("Franz", "passwort1");
		assertEquals(1, methodCallCounter);
	}

	@Test
	public void testRegisterUserInvalidUsernameContainingSpace() {
		localSessionService.registerUser("testi testmann", "Testi", "Testmann", "passwort1",
				"testi.testmann@testmail.com", 1);

		assertEquals(I18N.getRegistrationNotPossible(), reportedTitle);
		assertEquals(I18N.getInvalidUsername(), reportedMessage);
	}

	@Test
	public void testRegisterUserInvalidEmailAddressEndingWithDot() {
		localSessionService.registerUser("testiTestmann", "Testi", "Testmann", "passwort1", "testi.@testmail.com", 1);

		assertEquals(I18N.getRegistrationNotPossible(), reportedTitle);
		assertEquals(I18N.getInvalidEmailAddress(), reportedMessage);
	}

	@Test
	public void testRegisterHansAgainSameUsernameDifferentEmail() {
		localSessionService.registerUser("Hans", "Hans", "Meier", "passwort1", "testi.testmann@testmail.com", 1);

		assertEquals(I18N.getRegistrationNotPossible(), reportedTitle);
		assertEquals(I18N.getUserNameNotAvailable(), reportedMessage);
	}

	@Test
	public void testRegisterHansAgainDifferentUsernameSameEmail() {
		localSessionService.registerUser("Hansi", "Hans", "Meier", "passwort1", "hans.meier@yahoo.com", 1);

		assertEquals(I18N.getRegistrationNotPossible(), reportedTitle);
		assertEquals(I18N.getEmailAddressNotAvailable(), reportedMessage);
	}

	@Test
	public void testRegisterUserSuccessfully() {
		localSessionService.registerUser("testiTestmann", "Testi", "Testmann", "passwort1",
				"testi.testmann@testmail.com", 1);

		assertEquals(I18N.getActivateAccount(), reportedTitle);
		assertEquals(I18N.getRegistrationDialogueMessageTextForUser("Testi", "Testmann"), reportedMessage);
	}

}
