package de.badge.shared.model.domainValue;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BadgeType implements Serializable {

	private static final long serialVersionUID = -7720071554061242398L;

	private String id;
	private BadgeLearningValue badgeLearningValue;

	private static Set<BadgeType> badgeTypes = new HashSet<BadgeType>();

	public BadgeType(String badgeTypeId, BadgeLearningValue badgeLearningValue) {
		assert badgeTypeId != null : "Precondition failed: badgeTypeId != null";
		assert badgeLearningValue != null : "Precondition failed: badgeLearningValue != null";

		this.id = badgeTypeId;
		this.badgeLearningValue = badgeLearningValue;
		badgeTypes.add(this);
	}

	// GWT RPC requirement
	@Deprecated
	protected BadgeType() {
	}

	public BadgeLearningValue getBadgeLearningValue() {
		return badgeLearningValue;
	}

	public String getId() {
		return id;
	}

	public static BadgeType[] values() {
		BadgeType[] badgeTypeArray = badgeTypes.toArray(new BadgeType[badgeTypes.size()]);
		assert badgeTypeArray.length > 0 : "Postcondition failed:badgeTypeArray.length > 0 ";
		return badgeTypeArray;
	}

	public static BadgeType valueOf(String id) {
		assert id != null : "Precondition failed: id != null";

		BadgeType result = null;
		for (BadgeType badgeTypeInterface : badgeTypes) {
			if (badgeTypeInterface.getId().equals(id)) {
				result = badgeTypeInterface;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other != null && other.getClass() == getClass()) {
			if (other == this || this.getId().equals(((BadgeType) other).getId())) {
				result = true;
			}
		}
		return result;
	}

}
