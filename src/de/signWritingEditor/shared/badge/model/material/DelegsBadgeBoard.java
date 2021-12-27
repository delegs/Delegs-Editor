package de.signWritingEditor.shared.badge.model.material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.Badge;
import de.badge.shared.model.material.BadgeBoard;
import de.signWritingEditor.shared.badge.model.domainValue.DelegsBadgeType;

public class DelegsBadgeBoard extends BadgeBoard {

	private DifferentDayLoginBadge differentDayLoginsUserBadge;
	private LocalSignCreatorBadge localSignCreatorBadge;
	private LongTimeUserBadge longTimeUserBadge;
	private LoginStreakBadge loginStreakBadge;
	private DocumentCreatorBadge documentCreatorBadge;
	private NoviceBadge noviceBadge;

	public DelegsBadgeBoard(String ownerId, Map<BadgeType, String> jsonBadges, BadgeType[] requiredBadgeTypes) {
		super(ownerId, jsonBadges, requiredBadgeTypes);
		assert ownerId != null : "Precondition failed: ownerId != null";
		assert jsonBadges != null : "Precondition failed: jsonBadges != null";
		assert requiredBadgeTypes != null : "Precondition failed: requiredBadgeTypes != null";
		assert requiredBadgeTypes.length > 0 : "Precondition failed: requiredBadgeTypes.length > 0";

		for (int i = 0; i < requiredBadgeTypes.length; i++) {
			BadgeType requiredBadgeType = requiredBadgeTypes[i];
			boolean hasBadgeTypeAsJsonBadge = jsonBadges.containsKey(requiredBadgeType);
			if (requiredBadgeTypes[i].equals(DelegsBadgeType.DIFFERENT_DAY_LOGINS)) {
				assert differentDayLoginsUserBadge == null : "Precondition failed: frequentUserBadge == null";
				if (hasBadgeTypeAsJsonBadge) {
					differentDayLoginsUserBadge = DifferentDayLoginBadge.JSON_BLANK_FACTORY.createJsonBlank();
					differentDayLoginsUserBadge.fromJson(jsonBadges.get(requiredBadgeType));
				} else {
					differentDayLoginsUserBadge = new DifferentDayLoginBadge(ownerId);
				}
				assert differentDayLoginsUserBadge != null : "Precondition failed: frequentUserBadge != null";
			} else if (requiredBadgeTypes[i].equals(DelegsBadgeType.LOCAL_SIGN_CREATOR)) {
				assert localSignCreatorBadge == null : "Precondition failed: signCreatorBadge == null";
				if (hasBadgeTypeAsJsonBadge) {
					localSignCreatorBadge = LocalSignCreatorBadge.JSON_BLANK_FACTORY.createJsonBlank();
					localSignCreatorBadge.fromJson(jsonBadges.get(requiredBadgeType));
				} else {
					localSignCreatorBadge = new LocalSignCreatorBadge(ownerId);
				}
				assert localSignCreatorBadge != null : "Precondition failed: signCreatorBadge != null";
			} else if (requiredBadgeTypes[i].equals(DelegsBadgeType.LONG_TIME_USER)) {
				assert longTimeUserBadge == null : "Precondition failed: longTimeUserBadge == null";
				if (hasBadgeTypeAsJsonBadge) {
					longTimeUserBadge = LongTimeUserBadge.JSON_BLANK_FACTORY.createJsonBlank();
					longTimeUserBadge.fromJson(jsonBadges.get(requiredBadgeType));
				} else {
					longTimeUserBadge = new LongTimeUserBadge(ownerId);
				}
				assert longTimeUserBadge != null : "Precondition failed: longTimeUserBadge != null";
			} else if (requiredBadgeTypes[i].equals(DelegsBadgeType.LOGIN_STREAK)) {
				assert loginStreakBadge == null : "Precondition failed: loginStreakBadge == null";
				if (hasBadgeTypeAsJsonBadge) {
					loginStreakBadge = LoginStreakBadge.JSON_BLANK_FACTORY.createJsonBlank();
					loginStreakBadge.fromJson(jsonBadges.get(requiredBadgeType));
				} else {
					loginStreakBadge = new LoginStreakBadge(ownerId);
				}
				assert loginStreakBadge != null : "Precondition failed: loginStreakBadge != null";
			} else if (requiredBadgeTypes[i].equals(DelegsBadgeType.DOCUMENT_CREATOR)) {
				assert documentCreatorBadge == null : "Precondition failed: documentCreatorBadge == null";
				if (hasBadgeTypeAsJsonBadge) {
					documentCreatorBadge = DocumentCreatorBadge.JSON_BLANK_FACTORY.createJsonBlank();
					documentCreatorBadge.fromJson(jsonBadges.get(requiredBadgeType));
				} else {
					documentCreatorBadge = new DocumentCreatorBadge(ownerId);
				}
				assert documentCreatorBadge != null : "Precondition failed: documentCreatorBadge != null";
			} else if (requiredBadgeTypes[i].equals(DelegsBadgeType.NOVICE)) {
				assert noviceBadge == null : "Precondition failed: noviceBadge == null";
				if (hasBadgeTypeAsJsonBadge) {
					noviceBadge = NoviceBadge.JSON_BLANK_FACTORY.createJsonBlank();
					noviceBadge.fromJson(jsonBadges.get(requiredBadgeType));
				} else {
					noviceBadge = new NoviceBadge(ownerId);
				}
				assert noviceBadge != null : "Precondition failed: noviceBadge != null";
			} else {
				throw new RuntimeException("Unknown BadgeType: " + requiredBadgeTypes[i]);
			}

		}
	}

	public DifferentDayLoginBadge getDifferentDayLoginBadge() {
		return differentDayLoginsUserBadge;
	}

	public LocalSignCreatorBadge getLocalSignCreatorBadge() {
		return localSignCreatorBadge;
	}

	public LongTimeUserBadge getLongTimeUserBadge() {
		return longTimeUserBadge;
	}

	public LoginStreakBadge getLoginStreakBadge() {
		return loginStreakBadge;
	}

	public DocumentCreatorBadge getDocumentCreatorBadge() {
		return documentCreatorBadge;
	}

	public NoviceBadge getNoviceBadge() {
		return noviceBadge;
	}

	public List<Badge> getAllBadges() {
		List<Badge> badges = new ArrayList<Badge>();

		BadgeType[] badgeTypes = getRequiredBadgeTypes();

		for (int i = 0; i < badgeTypes.length; i++) {
			if (badgeTypes[i].equals(DelegsBadgeType.DIFFERENT_DAY_LOGINS)) {
				badges.add(differentDayLoginsUserBadge);
			} else if (badgeTypes[i].equals(DelegsBadgeType.LOCAL_SIGN_CREATOR)) {
				badges.add(localSignCreatorBadge);
			} else if (badgeTypes[i].equals(DelegsBadgeType.LONG_TIME_USER)) {
				badges.add(longTimeUserBadge);
			} else if (badgeTypes[i].equals(DelegsBadgeType.LOGIN_STREAK)) {
				badges.add(loginStreakBadge);
			} else if (badgeTypes[i].equals(DelegsBadgeType.DOCUMENT_CREATOR)) {
				badges.add(documentCreatorBadge);
			} else if (badgeTypes[i].equals(DelegsBadgeType.NOVICE)) {
				badges.add(noviceBadge);
			} else {
				throw new RuntimeException("Unknown BadgeType: " + badgeTypes[i]);
			}
		}

		return badges;
	}

	public Map<BadgeType, String> getJsonMap() {
		Map<BadgeType, String> result = new HashMap<BadgeType, String>();

		BadgeType[] badgeTypes = getRequiredBadgeTypes();

		for (int i = 0; i < badgeTypes.length; i++) {
			if (badgeTypes[i].equals(DelegsBadgeType.DIFFERENT_DAY_LOGINS)) {
				result.put(DelegsBadgeType.DIFFERENT_DAY_LOGINS, differentDayLoginsUserBadge.toJson());
			} else if (badgeTypes[i].equals(DelegsBadgeType.LOCAL_SIGN_CREATOR)) {
				result.put(DelegsBadgeType.LOCAL_SIGN_CREATOR, localSignCreatorBadge.toJson());
			} else if (badgeTypes[i].equals(DelegsBadgeType.LONG_TIME_USER)) {
				result.put(DelegsBadgeType.LONG_TIME_USER, longTimeUserBadge.toJson());
			} else if (badgeTypes[i].equals(DelegsBadgeType.LOGIN_STREAK)) {
				result.put(DelegsBadgeType.LOGIN_STREAK, loginStreakBadge.toJson());
			} else if (badgeTypes[i].equals(DelegsBadgeType.DOCUMENT_CREATOR)) {
				result.put(DelegsBadgeType.DOCUMENT_CREATOR, documentCreatorBadge.toJson());
			} else if (badgeTypes[i].equals(DelegsBadgeType.NOVICE)) {
				result.put(DelegsBadgeType.NOVICE, noviceBadge.toJson());
			} else {
				throw new RuntimeException("Unknown BadgeType: " + badgeTypes[i]);
			}
		}

		return result;
	}

}
