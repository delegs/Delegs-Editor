package de.signWritingEditor.client.badge.gwtClient.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.badge.client.gwtService.LockingTimer;
import de.badge.shared.model.domainValue.BadgeLevel;
import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.Badge;
import de.badge.shared.model.material.BadgeReport;
import de.badge.shared.model.material.BadgeWithLevel;
import de.badge.shared.model.material.JsonBadgesWithUsername;
import de.signWritingEditor.client.service.BadgeServiceAsync;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.shared.badge.model.domainValue.DelegsBadgeType;
import de.signWritingEditor.shared.badge.model.material.DelegsBadgeBoard;

public class BadgeServiceClientImpl implements BadgeServiceClient {

	private static final int TIMER_PERIOD_MILLIS = 1000;

	private final BadgeServiceAsync badgeService;
	private final LocalSessionService localSessionService;

	private List<BadgesUpdatedListener> listeners = new ArrayList<BadgesUpdatedListener>();

	public BadgeServiceClientImpl(BadgeServiceAsync badgeService, LocalSessionService localSessionService) {
		assert badgeService != null : "Precondition failed: badgeService != null";

		this.badgeService = badgeService;
		this.localSessionService = localSessionService;
		localSessionService.setUserSessionToUnknownUserSession();
	}

	@Override
	public void addBadgesUpdatedListener(BadgesUpdatedListener listener) {
		assert listener != null : "Precondition failed: listener != null";

		listeners.add(listener);
	}

	@Override
	public void userLoggedIn() {
		final Date loginTime = new Date();
		final DelegsBadgeType[] badgeTypes = new DelegsBadgeType[] { DelegsBadgeType.DIFFERENT_DAY_LOGINS,
				DelegsBadgeType.LOGIN_STREAK };

		startLockingTimerUpdateBadgesTask(localSessionService.getCurrentUser().getUsername(), badgeTypes, this,
				new BadgeDomainOperationHandler() {

					@Override
					public List<Badge> doDomainOperationAndReturnBadgesWithNewLevel(DelegsBadgeBoard badgeBoard) {
						assert badgeBoard != null : "Precondition failed: badgeBoard != null";

						final List<Badge> newBadges = new ArrayList<Badge>();
						if (badgeBoard.getDifferentDayLoginBadge().userLoggedIn(loginTime)) {
							newBadges.add(badgeBoard.getDifferentDayLoginBadge());
						}
						if (badgeBoard.getLoginStreakBadge().userLoggedIn(loginTime)) {
							newBadges.add(badgeBoard.getLoginStreakBadge());
						}

						return newBadges;
					}
				});
	}

	@Override
	public void userLoggedOut() {
		localSessionService.setUserSessionToUnknownUserSession();
	}

	@Override
	public void userCreatedGlobalSign() {
		
	}

	@Override
	public void userUpdatedGlobalSign() {
		
	}

	@Override
	public void userDeletedGlobalSign() {
		
	}

	@Override
	public void userCreatedLocalSign() {
		final DelegsBadgeType[] badgeTypes = new DelegsBadgeType[] { DelegsBadgeType.LOCAL_SIGN_CREATOR };

		startLockingTimerUpdateBadgesTask(localSessionService.getCurrentUser().getUsername(), badgeTypes, this,
				new BadgeDomainOperationHandler() {

					@Override
					public List<Badge> doDomainOperationAndReturnBadgesWithNewLevel(DelegsBadgeBoard badgeBoard) {
						assert badgeBoard != null : "Precondition failed: badgeBoard != null";

						final List<Badge> newBadges = new ArrayList<Badge>();
						if (badgeBoard.getLocalSignCreatorBadge().userCreatedSign()) {
							newBadges.add(badgeBoard.getLocalSignCreatorBadge());
						}
						return newBadges;
					}
				});
	}

	@Override
	public void userUpdatedLocalSign() {
		
	}

	@Override
	public void userOpenedOwnDocument() {
		final DelegsBadgeType[] badgeTypes = new DelegsBadgeType[] { DelegsBadgeType.NOVICE };

		startLockingTimerUpdateBadgesTask(localSessionService.getCurrentUser().getUsername(), badgeTypes, this,
				new BadgeDomainOperationHandler() {

					@Override
					public List<Badge> doDomainOperationAndReturnBadgesWithNewLevel(DelegsBadgeBoard badgeBoard) {
						assert badgeBoard != null : "Precondition failed: badgeBoard != null";

						final List<Badge> newBadges = new ArrayList<Badge>();
						if (badgeBoard.getNoviceBadge().userOpenedOwnDocument()) {
							newBadges.add(badgeBoard.getNoviceBadge());
						}
						return newBadges;
					}
				});
	}

	@Override
	public void userCreatedDocument() {
		final DelegsBadgeType[] badgeTypes = new DelegsBadgeType[] { DelegsBadgeType.DOCUMENT_CREATOR,
				DelegsBadgeType.NOVICE };

		startLockingTimerUpdateBadgesTask(localSessionService.getCurrentUser().getUsername(), badgeTypes, this,
				new BadgeDomainOperationHandler() {

					@Override
					public List<Badge> doDomainOperationAndReturnBadgesWithNewLevel(DelegsBadgeBoard badgeBoard) {
						assert badgeBoard != null : "Precondition failed: badgeBoard != null";

						final List<Badge> newBadges = new ArrayList<Badge>();
						if (badgeBoard.getDocumentCreatorBadge().userCreatedDocument()) {
							newBadges.add(badgeBoard.getDocumentCreatorBadge());
						}
						if (badgeBoard.getNoviceBadge().userCreatedDocument()) {
							newBadges.add(badgeBoard.getNoviceBadge());
						}
						return newBadges;
					}
				});
	}

	@Override
	public void userUpdatedDocument() {
		
	}

	@Override
	public void userOpenedSignEditor() {
		final DelegsBadgeType[] badgeTypes = new DelegsBadgeType[] { DelegsBadgeType.NOVICE };

		startLockingTimerUpdateBadgesTask(localSessionService.getCurrentUser().getUsername(), badgeTypes, this,
				new BadgeDomainOperationHandler() {

					@Override
					public List<Badge> doDomainOperationAndReturnBadgesWithNewLevel(DelegsBadgeBoard badgeBoard) {
						assert badgeBoard != null : "Precondition failed: badgeBoard != null";

						final List<Badge> newBadges = new ArrayList<Badge>();
						if (badgeBoard.getNoviceBadge().userOpenedSignEditor()) {
							newBadges.add(badgeBoard.getNoviceBadge());
						}
						return newBadges;
					}
				});
	}

	@Override
	public void getActiveUsersBadges(final BadgeType[] badgeTypes, final AsyncCallback<List<Badge>> asyncCallback) {
		badgeService.getBadgesForUser(localSessionService.getCurrentUser(),
				localSessionService.getCurrentUser().getUsername(), badgeTypes, true,
				new AsyncCallback<JsonBadgesWithUsername>() {
					@Override
					public void onFailure(Throwable caught) {
						asyncCallback.onFailure(caught);
					}

					@Override
					public void onSuccess(JsonBadgesWithUsername result) {
						assert result != null : "Precondition failed: result != null";

						DelegsBadgeBoard badgeBoard = new DelegsBadgeBoard(result.getUsername(), result.getBadges(),
								badgeTypes);
						asyncCallback.onSuccess(badgeBoard.getAllBadges());
					}
				});
	}

	@Override
	public void getCSVBadgeReportsSince(Date date, final AsyncCallback<String> asyncCallback) {
		assert date != null : "Precondition failed: date != null";
		assert localSessionService.getCurrentUser()
				.isAdmin() : "Precondition failed: localSessionService.getCurrentUser().isAdmin()";

		badgeService.getBadgeReportsSince(localSessionService.getCurrentUser(), date,
				new AsyncCallback<List<BadgeReport>>() {

					@Override
					public void onFailure(Throwable caught) {
						asyncCallback.onFailure(caught);
					}

					@Override
					public void onSuccess(List<BadgeReport> result) {
						assert result != null : "Precondition failed: result != null";

						asyncCallback.onSuccess(getCSVFromReports(result));
					}
				});
	}

	protected String getCSVFromReports(List<BadgeReport> result) {
		assert result != null : "Precondition failed: result != null";

		String csv = "data:text/csv;charset=utf-8,sep=,\ncreationDate";
		for (BadgeType badgeType : DelegsBadgeType.values()) {
			for (BadgeLevel badgeLevel : BadgeLevel.values()) {
				csv += "," + badgeType.getId() + ":" + badgeLevel.name();
			}
		}

		for (BadgeReport badgeReport : result) {
			csv += "\n" + badgeReport.getCreationDate();
			for (BadgeWithLevel badgeWithLevel : badgeReport.getBadgeWithLevelToScore()) {
				csv += "," + badgeWithLevel.getAmount();
			}
		}

		return csv;
	}

	private void startLockingTimerUpdateBadgesTask(final String username, final DelegsBadgeType[] badgeTypes,
			BadgeServiceClientImpl badgeServiceClientImpl,
			final BadgeDomainOperationHandler badgeDomainOperationHandler) {
		assert username != null : "Precondition failed: username != null";
		assert badgeTypes != null : "Precondition failed: badgeTypes != null";
		assert badgeServiceClientImpl != null : "Precondition failed: badgeServiceClientImpl != null";
		assert badgeDomainOperationHandler != null : "Precondition failed: badgeDomainOperationHandler != null";

		LockingTimer lockingTimer = new LockingTimer() {

			@Override
			public void doRun() {
				tryUpdateBadges(username, badgeTypes, this, new BadgeDomainOperationHandler() {

					@Override
					public List<Badge> doDomainOperationAndReturnBadgesWithNewLevel(DelegsBadgeBoard badgeBoard) {
						assert badgeBoard != null : "Precondition failed: badgeBoard != null";

						return badgeDomainOperationHandler.doDomainOperationAndReturnBadgesWithNewLevel(badgeBoard);
					}
				});
			}
		};

		lockingTimer.run();
		lockingTimer.scheduleRepeating(TIMER_PERIOD_MILLIS);
	}

	private void tryUpdateBadges(final String badgeUsername, final DelegsBadgeType[] badgeTypes,
			final LockingTimer lockingTimer, final BadgeDomainOperationHandler badgeDomainOperationHandler) {
		assert badgeUsername != null : "Precondition failed: badgeUsername != null";
		assert badgeTypes != null : "Precondition failed: badgeTypes != null";
		assert lockingTimer != null : "Precondition failed: lockingTimer != null";
		assert badgeDomainOperationHandler != null : "Precondition failed: badgeDomainOperationHandler != null";

		// first try to get the requested badges
		badgeService.getBadgesForUser(localSessionService.getCurrentUser(), badgeUsername, badgeTypes, false,
				new AsyncCallback<JsonBadgesWithUsername>() {

					@Override
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
						lockingTimer.finished(false);
					}

					@Override
					public void onSuccess(JsonBadgesWithUsername result) {
						assert result != null : "Precondition failed: result != null";

						final DelegsBadgeBoard badgeBoard = new DelegsBadgeBoard(badgeUsername, result.getBadges(),
								badgeTypes);
						final List<Badge> newBadges = badgeDomainOperationHandler
								.doDomainOperationAndReturnBadgesWithNewLevel(badgeBoard);

						// try to store the changed badges
						JsonBadgesWithUsername jsonBadges = new JsonBadgesWithUsername(badgeBoard.getJsonMap(),
								badgeUsername);
						badgeService.updateBadgesForUser(localSessionService.getCurrentUser(), jsonBadges,
								new AsyncCallback<Void>() {

									@Override
									public void onFailure(Throwable caught) {
										caught.printStackTrace();
										lockingTimer.finished(false);
									}

									@Override
									public void onSuccess(Void result) {
										lockingTimer.finished(true);
										badgesUpdated(newBadges, badgeBoard.getAllBadges());
									}
								});
					}

				});
	}

	private void badgesUpdated(List<Badge> badgesThatReachedANewLevel, List<Badge> badgesThatUpdated) {
		if (badgesThatReachedANewLevel != null && badgesThatUpdated != null && badgesThatUpdated.size() > 0) {
			for (BadgesUpdatedListener listener : listeners) {
				listener.badgesUpdated(badgesThatReachedANewLevel, badgesThatUpdated);
			}
		}
	}

	private interface BadgeDomainOperationHandler {
		public List<Badge> doDomainOperationAndReturnBadgesWithNewLevel(DelegsBadgeBoard badgeBoard);
	}

}
