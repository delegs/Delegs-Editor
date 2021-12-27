package de.badge.shared.model.material;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.badge.shared.model.domainValue.BadgeType;

public class BadgeBoard {

	private BadgeType[] requiredBadgeTypes;
	private Map<BadgeType, String> jsonBadges;
	private String ownerid;

	public BadgeBoard(String ownerId, Map<BadgeType, String> jsonBadges, BadgeType[] requiredBadgeTypes) {
		assert ownerId != null : "Precondition failed: ownerId != null";
		assert jsonBadges != null : "Precondition failed: jsonBadges != null";
		assert requiredBadgeTypes != null : "Precondition failed: requiredBadgeTypes != null";
		assert requiredBadgeTypes.length > 0 : "Precondition failed: requiredBadgeTypes.length > 0";

		this.ownerid = ownerId;
		this.jsonBadges = jsonBadges;
		this.requiredBadgeTypes = requiredBadgeTypes;
	}

	protected final BadgeType[] getRequiredBadgeTypes() {
		return requiredBadgeTypes;
	}

	protected final Map<BadgeType, String> getJsonBadges() {
		return jsonBadges;
	}

	public String getOwnerId() {
		return ownerid;
	}

	public List<? extends Badge> getAllBadges() {
		throw new RuntimeException("should be overwritten");
		// should be overwritten
	}

	public Map<BadgeType, String> getJsonMap() {
		Map<BadgeType, String> result = new HashMap<BadgeType, String>();

		List<? extends Badge> allBadges = getAllBadges();

		for (int i = 0; i < allBadges.size(); i++) {
			result.put(allBadges.get(i).getBadgeType(), allBadges.get(i).toJson());
		}

		return result;
	}
}
