package de.signWritingEditor.shared.infrastructure;

import java.io.Serializable;
import java.util.Map;

import de.signWritingEditor.shared.model.domainValue.VersionNumber;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.RoomItem;

public class InitBundle implements Serializable {

	private static final long serialVersionUID = -5421970780022247630L;
	private long idSeed;
	private RoomItem rootRoomItem;
	private String backgroundImageName;
	private VersionNumber versionNumber;
	private int privacyPolicyVersionNumber;
	private Map<FontMetricSpecifier, FontMetric> fontMetrics;

	public InitBundle(long idSeed, RoomItem rootRoomItem, String backgroundImageName, VersionNumber versionNumber,
			int privacyPolicyVersionNumber, Map<FontMetricSpecifier, FontMetric> fontMetrics) {
		assert rootRoomItem != null : "Precondition failed: rootRoomItem != null";
		assert backgroundImageName != null : "Precondition failed: backgroundImageName != null";
		assert idSeed > 0 : "Precondition failed: idSeed > 0";
		assert versionNumber != null : "Precondition failed: versionNumber != null";
		assert privacyPolicyVersionNumber >= 0 : "Precondition failed: privacyPolicyVersionNumber >= 0";
		assert fontMetrics != null : "Precondition failed: fontMetrics != null";

		this.idSeed = idSeed;
		this.rootRoomItem = rootRoomItem;
		this.backgroundImageName = backgroundImageName;
		this.versionNumber = versionNumber;
		this.privacyPolicyVersionNumber = privacyPolicyVersionNumber;
		this.fontMetrics = fontMetrics;
	}

	public VersionNumber getVersionNumber() {
		return versionNumber;
	}

	public int getPrivacyPolicyVersionNumber() {
		return privacyPolicyVersionNumber;
	}

	public long getIdSeed() {
		return idSeed;
	}

	public RoomItem getRootRoomItem() {
		return rootRoomItem;
	}

	public String getBackgroundImageName() {
		return backgroundImageName;
	}

	@Deprecated
	public InitBundle() {
	}

	public Map<FontMetricSpecifier, FontMetric> getFontMetrics() {
		return fontMetrics;
	}
}
