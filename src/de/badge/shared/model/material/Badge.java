package de.badge.shared.model.material;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import de.badge.shared.model.domainValue.BadgeLevel;
import de.badge.shared.model.domainValue.BadgeType;
import de.jsonParser.shared.infrastructure.JsonParser;
import de.jsonParser.shared.model.material.Artifact;

public abstract class Badge extends Artifact {

	private static final long serialVersionUID = 62573532641143233L;

	private BadgeType badgeType;
	private String ownerId;
	private Date dateEarned;

	public Badge(String ownerId, BadgeType badgeType, Date dateEarned) {
		super(ownerId + "'s'BADGE_" + badgeType.getId());
		assert ownerId != null : "Precondition failed: ownerId != null";
		assert badgeType != null : "Precondition failed: badgeType != null";

		this.ownerId = ownerId;
		this.badgeType = badgeType;
		this.dateEarned = dateEarned;

	}

	@Deprecated
	protected Badge() {
		super();
	}

	protected void setDateEarned(Date dateEarned) {
		this.dateEarned = dateEarned;
	}

	public boolean isEarned() {
		return getCurrentLevel() != BadgeLevel.NONE;
	}

	public Date getDateEarned() {
		return this.dateEarned;
	}

	public BadgeType getBadgeType() {
		return badgeType;
	}

	@Override
	public String toString() {
		return "Badge [badgeType=" + badgeType + ", ownerId=" + ownerId + ", title=" + getTitle() + ", description="
				+ getDescription() + "]";
	}

	@Override
	protected void setJson(JsonParser jsonParser) {
		assert jsonParser != null : "Precondition failed: jsonParser != null";

		super.setJson(jsonParser);

		badgeType = BadgeType.valueOf(readStringFromJson(jsonParser, "badgeType"));
		Long longValue = readLongObjectFromJson(jsonParser, "dateEarned");
		dateEarned = longValue == null ? null : new Date(longValue);
		ownerId = readStringFromJson(jsonParser, "ownerId");

	}

	@Override
	protected String getJson() {
		StringBuilder result = new StringBuilder(super.getJson());

		writeStringToJson(result, "badgeType", badgeType.getId());
		writeLongObjectToJson(result, "dateEarned", dateEarned == null ? null : dateEarned.getTime());
		writeStringToJson(result, "ownerId", ownerId);

		assert result != null : "Postcondition failed: result != null";
		return result.toString();
	}

	protected void doConsistencyCheck() {
		if ((dateEarned == null && getCurrentLevel() != BadgeLevel.NONE)
				|| (dateEarned != null && getCurrentLevel() == BadgeLevel.NONE)) {
			throw new RuntimeException(
					"Wrong configuration, cannot have an earned date without a badgeLevel and vice versa");
		}
	}

	public String getBadgeEarnedText() {
		throw new RuntimeException("should be overwritten");
		// should be overwritten
	}

	public abstract String getNextLevelBadgeEarnedText();

	public abstract String getTitle();

	public abstract String getDescription();

	public abstract String getStatus();

	protected abstract String getUnearnedBadgeAsBase64();

	protected abstract String getBronzeBadgeAsBase64();

	protected abstract String getSilverBadgeAsBase64();

	protected abstract String getGoldBadgeAsBase64();

	public final String getImageAsBase64() {
		BadgeLevel currentLevel = getCurrentLevel();
		switch (currentLevel) {
		case NONE:
			return getUnearnedBadgeAsBase64();
		case BRONZE:
			return getBronzeBadgeAsBase64();
		case SILVER:
			return getSilverBadgeAsBase64();
		case GOLD:
			return getGoldBadgeAsBase64();
		default:
			throw new RuntimeException("you cannot call getImageAsBase64() for level " + currentLevel);
		}
	}

	public final String getNextLevelImageAsBase64() {
		BadgeLevel currentLevel = getCurrentLevel();
		assert currentLevel != BadgeLevel.GOLD : "Precondition failed: assert currentLevel != BadgeLevel.GOLD";
		switch (currentLevel) {
		case NONE:
			return getBronzeBadgeAsBase64();
		case BRONZE:
			return getSilverBadgeAsBase64();
		case SILVER:
			return getGoldBadgeAsBase64();
		case GOLD:
		default:
			throw new RuntimeException("you cannot call getNextLevelImageAsBase64() for level " + currentLevel);
		}
	}

	public abstract BadgeLevel getCurrentLevel();

	public static enum Comparators implements Comparator<Badge> {
		BY_TITLE {
			public int compare(final Badge badge1, final Badge badge2) {
				return badge1.getTitle().compareTo(badge2.getTitle());
			}

			public void sort(final List<Badge> badges) {
				Collections.sort(badges, BY_TITLE);
			}
		},
		BY_ID {
			public int compare(final Badge badge1, final Badge badge2) {
				return badge1.getId().compareTo(badge2.getId());
			}

			public void sort(final List<Badge> badges) {
				Collections.sort(badges, BY_ID);
			}
		},
		BY_LEARN_PATH {
			public int compare(final Badge badge1, final Badge badge2) {
				int result = -2;

				int badge1HasAGreaterLearningEffect = -1;
				int badge1HasASmallerLearningEffect = 1;
				int badgesHaveSameLearningEffect = 0;

				if (badge1.getCurrentLevel().isMax() && !badge2.getCurrentLevel().isMax()) {
					result = badge1HasASmallerLearningEffect;
				} else if (!badge1.getCurrentLevel().isMax() && badge2.getCurrentLevel().isMax()) {
					result = badge1HasAGreaterLearningEffect;
				} else if (badge1.getBadgeType().getBadgeLearningValue().ordinal() > badge2.getBadgeType()
						.getBadgeLearningValue().ordinal()) {
					result = badge1HasAGreaterLearningEffect;
				} else if (badge1.getBadgeType().getBadgeLearningValue().ordinal() < badge2.getBadgeType()
						.getBadgeLearningValue().ordinal()) {
					result = badge1HasASmallerLearningEffect;
				} else {
					result = badgesHaveSameLearningEffect;
				}

				assert result >= -1 : "Postcondition failed: result >= -1";
				assert result <= 1 : "Postcondition failed: result <= 1";
				return result;
			}

			public void sort(final List<Badge> badges) {
				Collections.sort(badges, BY_LEARN_PATH);
			}
		},
		BY_LATEST_EARNED {
			public int compare(final Badge badge1, final Badge badge2) {
				int result = -2;

				int badge1IsNewer = -1;
				int badge1IsOlder = 1;
				int badgesAreOfSameDate = 0;

				if ((badge1 == null || badge1.getDateEarned() == null)
						&& (badge2 == null || badge2.getDateEarned() == null)) {
					result = badgesAreOfSameDate;
				} else if (badge1 == null || badge1.getDateEarned() == null) {
					result = badge1IsOlder;
				} else if (badge2 == null || badge2.getDateEarned() == null) {
					result = badge1IsNewer;
				} else if (badge1.getDateEarned().getTime() > badge2.getDateEarned().getTime()) {
					result = badge1IsNewer;
				} else if (badge1.getDateEarned().getTime() < badge2.getDateEarned().getTime()) {
					result = badge1IsOlder;
				} else {
					result = badgesAreOfSameDate;
				}

				assert result >= -1 : "Postcondition failed: result >= -1";
				assert result <= 1 : "Postcondition failed: result <= 1";
				return result;
			}

			public void sort(final List<Badge> badges) {
				Collections.sort(badges, BY_LATEST_EARNED);
			}
		};

		/** Sorts the list by this criterion. */
		public abstract void sort(List<Badge> badges);
	}
}
