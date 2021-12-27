package de.signWritingEditor.shared.model.domainValue;

public enum SignLocale {

	ASL("American Sign Language"), BSL("British Sign Language"), DGS("Deutsche Gebärdensprache"),
	LIBRAS("Língua Brasileira de Sinais"), LSE("Lengua de Signos Española"), LSF("Langue des Signes Française"),
	LSFB("La Langue des Signes de Belgique Francophone"), LSM("Lingwi tas-Sinjali Maltin"),
	LSQ("Langue des Signes Québécoise"), PJM("Polski Jezyk Migowy"), SZJ("Slovenski Znakovni Jezik"),
	IS("International Sign"), TSE("Langue des signes tunisienne"), DSGS("Deutschschweizer Gebärdensprache");

	private String longForm;

	private SignLocale(String longForm) {
		assert longForm != null : "Precondition failed: longForm != null";
		this.longForm = longForm;
	}

	public String getLongForm() {
		return longForm;
	}

}
