package de.badge.shared.model.domainValue;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum BadgeLevel {
	NONE, BRONZE, SILVER, GOLD;

	public boolean isMax() {
		return this.equals(GOLD);
	}

	public static enum Comparators implements Comparator<BadgeLevel> {

		BY_WORTH {
			public int compare(final BadgeLevel badge1, final BadgeLevel badge2) {
				int badge1IsWorthLess = -1;
				int badge1IsWorthMore = 1;
				int badgesAreOfEqualWorth = 0;

				int result = -2;

				if (badge1 == null && badge2 == null) {
					result = badgesAreOfEqualWorth;
				} else if (badge1 == null) {
					result = badge1IsWorthLess;
				} else if (badge2 == null) {
					result = badge1IsWorthMore;
				} else if (badge1.ordinal() > badge2.ordinal()) {
					result = badge1IsWorthMore;
				} else if (badge1.ordinal() < badge2.ordinal()) {
					result = badge1IsWorthLess;
				} else {
					result = badgesAreOfEqualWorth;
				}

				assert result >= -1 : "Postcondition failed: result >= -1";
				assert result <= 1 : "Postcondition failed: result <= 1";

				return result;
			}

			public void sort(final List<BadgeLevel> badgeLevels) {
				Collections.sort(badgeLevels, BY_WORTH);
			}
		};

		/** Sorts the list by this criterion. */
		public abstract void sort(List<BadgeLevel> badgeLevels);
	}
}
