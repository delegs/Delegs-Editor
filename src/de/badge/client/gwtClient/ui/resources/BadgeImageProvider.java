package de.badge.client.gwtClient.ui.resources;

import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.ImageResource;

public interface BadgeImageProvider {

	@Source("icon-loading.gif")
	ImageResource getLoading();

	@Source("metal/icon-badge-gold.png")
	ImageResource getGoldBadge();

	@Source("metal/icon-badge-silver.png")
	ImageResource getSilverBadge();

	@Source("metal/icon-badge-bronze.png")
	ImageResource getBronzeBadge();

	@Source("metal/icon-badge-unearned.png")
	ImageResource getUnearnedBadge();

	@Source("longTimeUser/icon-long-time-user-bronze.png")
	ImageResource getLongTimeUserBronzeBadge();

	@Source("longTimeUser/icon-long-time-user-silver.png")
	ImageResource getLongTimeUserSilverBadge();

	@Source("longTimeUser/icon-long-time-user-gold.png")
	ImageResource getLongTimeUserGoldBadge();

	@Source("novice/icon-novice-bronze.png")
	ImageResource getNoviceBronzeBadge();

	@Source("novice/icon-novice-silver.png")
	ImageResource getNoviceSilverBadge();

	@Source("novice/icon-novice-gold.png")
	ImageResource getNoviceGoldBadge();

	@Source("loginStreak/icon-login-streak-bronze.png")
	ImageResource getLoginStreakBronzeBadge();

	@Source("loginStreak/icon-login-streak-silver.png")
	ImageResource getLoginStreakSilverBadge();

	@Source("loginStreak/icon-login-streak-gold.png")
	ImageResource getLoginStreakGoldBadge();

	@Source("localSignCreator/icon-local-sign-creator-bronze.png")
	ImageResource getLocalSignCreatorBronzeBadge();

	@Source("localSignCreator/icon-local-sign-creator-silver.png")
	ImageResource getLocalSignCreatorSilverBadge();

	@Source("localSignCreator/icon-local-sign-creator-gold.png")
	ImageResource getLocalSignCreatorGoldBadge();

	@Source("documentCreator/icon-document-creator-bronze.png")
	ImageResource getDocumentCreatorBronzeBadge();

	@Source("documentCreator/icon-document-creator-silver.png")
	ImageResource getDocumentCreatorSilverBadge();

	@Source("documentCreator/icon-document-creator-gold.png")
	ImageResource getDocumentCreatorGoldBadge();

	@Source("differentDayLogin/icon-different-day-login-bronze.png")
	ImageResource getDifferentDayLoginBronzeBadge();

	@Source("differentDayLogin/icon-different-day-login-silver.png")
	ImageResource getDifferentDayLoginSilverBadge();

	@Source("differentDayLogin/icon-different-day-login-gold.png")
	ImageResource getDifferentDayLoginGoldBadge();

}
