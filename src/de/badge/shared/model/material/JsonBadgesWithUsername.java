package de.badge.shared.model.material;

import java.io.Serializable;
import java.util.Map;

import de.badge.shared.model.domainValue.BadgeType;

public class JsonBadgesWithUsername implements Serializable {

	private static final long serialVersionUID = -163239312337198031L;

	private Map<BadgeType, String> badges;
	private String username;

	public JsonBadgesWithUsername(Map<BadgeType, String> badges, String username) {
		assert badges != null : "Precondition failed: badges != null";
		assert username != null : "Precondition failed: username != null";

		this.badges = badges;
		this.username = username;
	}

	// GWT RPC requirement
	@SuppressWarnings("unused")
	@Deprecated
	private JsonBadgesWithUsername() {
	}

	public Map<BadgeType, String> getBadges() {
		return badges;
	}

	public String getUsername() {
		return username;
	}
}
