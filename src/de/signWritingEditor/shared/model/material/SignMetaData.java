package de.signWritingEditor.shared.model.material;

import java.util.List;

import de.signWritingEditor.shared.model.domainValue.SignCategory;
import de.signWritingEditor.shared.model.domainValue.SignDialectRegion;
import de.signWritingEditor.shared.model.domainValue.SignStatus;
import de.signWritingEditor.shared.model.domainValue.SignType;

public class SignMetaData {

	private SignStatus status;
	private SignCategory category;
	private SignType type;
	private List<SignDialectRegion> dialectRegions;
	private boolean isLBG;
	private boolean isDGS;
	private String explanationText;

	public SignMetaData(SignStatus status, SignCategory category, SignType type, List<SignDialectRegion> dialectRegions,
			boolean isLBG, boolean isDGS, String explanationText) {
		super();
		this.status = status;
		this.category = category;
		this.type = type;
		this.dialectRegions = dialectRegions;
		this.isLBG = isLBG;
		this.isDGS = isDGS;
		this.explanationText = explanationText;
	}

	public SignMetaData() {
		super();
	}

	public SignStatus getStatus() {
		return status;
	}

	public void setStatus(SignStatus status) {
		this.status = status;
	}

	public SignCategory getCategory() {
		return category;
	}

	public void setCategory(SignCategory category) {
		this.category = category;
	}

	public SignType getType() {
		return type;
	}

	public void setType(SignType type) {
		this.type = type;
	}

	public List<SignDialectRegion> getDialectRegions() {
		return dialectRegions;
	}

	public void setDialectRegions(List<SignDialectRegion> dialectRegions) {
		this.dialectRegions = dialectRegions;
	}

	public boolean isLBG() {
		return isLBG;
	}

	public void setLBG(boolean isLBG) {
		this.isLBG = isLBG;
	}

	public boolean isDGS() {
		return isDGS;
	}

	public void setDGS(boolean isDGS) {
		this.isDGS = isDGS;
	}

	public String getExplanationText() {
		return explanationText;
	}

	public void setExplanationText(String explanationText) {
		this.explanationText = explanationText;
	}

}
