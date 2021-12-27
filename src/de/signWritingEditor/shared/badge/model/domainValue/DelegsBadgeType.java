package de.signWritingEditor.shared.badge.model.domainValue;

import java.util.Arrays;
import java.util.List;

import de.badge.shared.model.domainValue.BadgeLearningValue;
import de.badge.shared.model.domainValue.BadgeType;

public class DelegsBadgeType extends BadgeType {

	private static final long serialVersionUID = 2186665428525046076L;

	public static DelegsBadgeType DIFFERENT_DAY_LOGINS = new DelegsBadgeType("DIFFERENT_DAY_LOGINS",
			BadgeLearningValue.MINOR_AS_SIDE_EFFECT); //
	public static DelegsBadgeType LOCAL_SIGN_CREATOR = new DelegsBadgeType("LOCAL_SIGN_CREATOR",
			BadgeLearningValue.SOME_LEARNING_EFFECT); //
	public static DelegsBadgeType LONG_TIME_USER = new DelegsBadgeType("LONG_TIME_USER", BadgeLearningValue.NONE); //
	public static DelegsBadgeType LOGIN_STREAK = new DelegsBadgeType("LOGIN_STREAK",
			BadgeLearningValue.MINOR_AS_SIDE_EFFECT); //
	public static DelegsBadgeType DOCUMENT_CREATOR = new DelegsBadgeType("DOCUMENT_CREATOR",
			BadgeLearningValue.SOME_LEARNING_EFFECT); //
	public static DelegsBadgeType NOVICE = new DelegsBadgeType("NOVICE", BadgeLearningValue.SPECIFIC_FOR_LEARNING); //

	public DelegsBadgeType(String badgeTypeId, BadgeLearningValue badgeLearningValue) {
		super(badgeTypeId, badgeLearningValue);
		assert badgeTypeId != null : "Precondition failed: badgeTypeId != null";
		assert badgeLearningValue != null : "Precondition failed: badgeLearningValue != null";
	}

	public static DelegsBadgeType[] values() {
		return new DelegsBadgeType[] { DIFFERENT_DAY_LOGINS, LOCAL_SIGN_CREATOR, LONG_TIME_USER, LOGIN_STREAK,
				DOCUMENT_CREATOR, NOVICE };

	}

	public static void initialize() {
		List<BadgeType> badgeTypes = Arrays.asList(BadgeType.values());
		for (DelegsBadgeType badge : DelegsBadgeType.values()) {
			if (!badgeTypes.contains(badge)) {
				throw new RuntimeException("BadgeType was not initialized correctly");
			}
		}
	}

	// GWT RPC requirement
	@SuppressWarnings("unused")
	@Deprecated
	private DelegsBadgeType() {
		super();
	}

}
