package de.badge.shared.model.material;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.badge.shared.model.domainValue.BadgeLevel;
import de.badge.shared.model.domainValue.BadgeType;
import de.jsonParser.shared.infrastructure.JsonParser;
import de.jsonParser.shared.model.material.Artifact;

public class BadgeReport extends Artifact {

	public static final JsonBlankFactory<BadgeReport> JSON_BLANK_FACTORY = new JsonBlankFactory<BadgeReport>() {
		@Override
		public BadgeReport doCreateJsonBlank() {
			return new BadgeReport();
		}
	};

	private static final long serialVersionUID = 2324215536147281614L;

	private List<BadgeWithLevel> badgeWithLevelToScore = new ArrayList<BadgeWithLevel>();
	private Date creationDate;

	public BadgeReport(List<BadgeBoard> userBadgeBoards) {
		super("BadgeReport" + String.valueOf(new Date().getTime()));
		assert userBadgeBoards != null : "Precondition failed: userBadgeBoards != null";
		assert userBadgeBoards.size() > 0 : "Precondition failed: userBadgeBoards.size() > 0";

		for (BadgeType badgeType : BadgeType.values()) {
			for (BadgeLevel badgeLevel : BadgeLevel.values()) {
				badgeWithLevelToScore.add(new BadgeWithLevel(badgeType, badgeLevel, 0));
			}
		}

		for (BadgeBoard badgeBoard : userBadgeBoards) {
			for (Badge badge : badgeBoard.getAllBadges()) {
				BadgeWithLevel badgeWithLevel = new BadgeWithLevel(badge.getBadgeType(), badge.getCurrentLevel(), 1);
				int index = badgeWithLevelToScore.indexOf(badgeWithLevel);
				badgeWithLevelToScore.get(index).increaseAmount();
			}
		}

		this.creationDate = new Date();
	}

	@Deprecated
	private BadgeReport() {
		super();
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public List<BadgeWithLevel> getBadgeWithLevelToScore() {
		return badgeWithLevelToScore;
	}

	@Override
	protected void setJson(JsonParser jsonParser) {
		assert jsonParser != null : "Precondition failed: jsonParser != null";

		super.setJson(jsonParser);

		badgeWithLevelToScore = readArtifactListFromJson(jsonParser, "badgeWithLevelToScore", badgeWithLevelToScore,
				BadgeWithLevel.JSON_BLANK_FACTORY);
		creationDate = new Date(readLongFromJson(jsonParser, "creationDate"));
	}

	@Override
	protected String getJson() {
		StringBuilder result = new StringBuilder(super.getJson());

		writeArtifactListToJson(result, "badgeWithLevelToScore", badgeWithLevelToScore);
		writeLongToJson(result, "creationDate", (creationDate != null) ? creationDate.getTime() : 0);

		assert result != null : "Postcondition failed: result != null";
		return result.toString();
	}

}
