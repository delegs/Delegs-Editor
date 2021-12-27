package de.badge.shared.model.material;

import de.badge.shared.model.domainValue.BadgeLevel;
import de.badge.shared.model.domainValue.BadgeType;
import de.jsonParser.shared.infrastructure.JsonParser;
import de.jsonParser.shared.model.material.Artifact;

public class BadgeWithLevel extends Artifact {

	public static final JsonBlankFactory<BadgeWithLevel> JSON_BLANK_FACTORY = new JsonBlankFactory<BadgeWithLevel>() {
		@Override
		public BadgeWithLevel doCreateJsonBlank() {
			return new BadgeWithLevel();
		}
	};

	private static final long serialVersionUID = -584190258329143326L;

	private BadgeType badgeType;
	private BadgeLevel badgeLevel;
	private long amount;

	public BadgeWithLevel(BadgeType badgeType, BadgeLevel badgeLevel, long amount) {
		super("BadgeWithLevel_" + badgeType.getId() + "_" + badgeLevel.name());

		assert badgeType != null : "Precondition failed: badgeType != null";
		assert badgeLevel != null : "Precondition failed: badgeLevel != null";

		this.badgeType = badgeType;
		this.badgeLevel = badgeLevel;
		this.amount = amount;
	}

	@Deprecated
	private BadgeWithLevel() {
		super();
	}

	public BadgeLevel getBadgeLevel() {
		return badgeLevel;
	}

	public BadgeType getBadgeType() {
		return badgeType;
	}

	public long getAmount() {
		return amount;
	}

	public void increaseAmount() {
		this.amount++;
	}

	@Override
	protected void setJson(JsonParser jsonParser) {
		assert jsonParser != null : "Precondition failed: jsonParser != null";

		super.setJson(jsonParser);

		badgeType = BadgeType.valueOf(readStringFromJson(jsonParser, "badgeType"));
		badgeLevel = BadgeLevel.valueOf(readStringFromJson(jsonParser, "badgeLevel"));
		amount = readLongFromJson(jsonParser, "amount");
	}

	@Override
	protected String getJson() {
		StringBuilder result = new StringBuilder(super.getJson());

		writeStringToJson(result, "badgeType", badgeType.getId());
		writeStringToJson(result, "badgeLevel", badgeLevel.name());
		writeLongToJson(result, "amount", amount);

		assert result != null : "Postcondition failed: result != null";
		return result.toString();
	}

}
