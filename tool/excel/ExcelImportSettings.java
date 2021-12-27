package excel;

import de.signWritingEditor.shared.model.domainValue.Id;

public class ExcelImportSettings {

    // Sign2MintExports/
    // Hier liegt die Import-Vorlage (Sign2MINT-Import-Vorlage)
    public static final Id SIGN2MINT_EXPORTS_FOLDER_ID = new Id("4838476458430815:128");

    // Geprüfte Gebärden/Test
    public static final Id IMPORT_FOLDER_ID = new Id("5451644410231515:80");

    public static final String ID_HEADER = "Id";
    public static final String FACHBEGRIFF_HEADER = "Fachbegriff";
    public static final String VIDEONAME_HEADER = "Videoname";
    public static final String FACHBEREICHE_HEADER = "Fachbereiche";
    public static final String EMPFEHLUNG_HEADER = "Empfehlung";
    public static final String VERWENDUNGSKONTEXT_HEADER = "Verwendungskontext";
    public static final String SPRACHE_HEADER = "Sprache";
    public static final String URSPRUNG_HEADER = "Ursprung";
    public static final String REGION_HEADER = "Region";
    public static final String WIKTIONARY_LINK_HEADER = "Wiktionary Link";
    public static final String BEDEUTUNGSNUMMER_HEADER = "Bedeutungsnummer";
    public static final String WIKIPEDIA_LINK_HEADER = "Wikipedia Link";
    public static final String OPTIONALER_LINK_HEADER = "Optionaler Link";
    public static final String GEBAERDENDE_HEADER = "Gebärdende";
    public static final String FILMPRODUKTION_HEADER = "Filmproduktion";
    public static final String AUFNAHMEORT_HEADER = "Aufnahmeort";
    public static final String AUFNAHMEDATUM_HEADER = "Aufnahmedatum";
    public static final String IGNORIEREN_HEADER = "Ignorieren";

    public static final String FACHBEGRIFF_TOKEN = "Fachbegriff";
    public static final String FACHBEREICHE_TOKEN = "Fachgebiet:";
    public static final String EMPFEHLUNG_TOKEN = "Empfehlung:";
    public static final String VERWENDUNGSKONTEXT_TOKEN = "Verwendungskontext:";
    public static final String SPRACHE_TOKEN = "Sprache:";
    public static final String URSPRUNG_TOKEN = "Ursprung:";
    public static final String REGION_TOKEN = "Region:";
    public static final String WIKTIONARY_LINK_TOKEN = "Wiktionary:";
    public static final String BEDEUTUNGSNUMMER_TOKEN = "Bedeutungsnummer:";
    public static final String WIKIPEDIA_LINK_TOKEN = "Wikipedia:";
    public static final String OPTIONALER_LINK_TOKEN = "Sonstiges:";
    public static final String GEBAERDENDE_TOKEN = "Gebärdender:";
    public static final String FILMPRODUKTION_TOKEN = "Filmproduzent:";
    public static final String AUFNAHMEORT_TOKEN = "CC / Ort:";
    public static final String AUFNAHMEDATUM_TOKEN = "Aufnahmedatum:";
    public static final String HOCHLADEDATUM_TOKEN = "Hochladedatum:";

    public static final String ValueSeparator = ",";
    public static final String VIDEO_FILE_EXTENSION = ".mp4";
    public static final String DEFAULT_USERNAME = "delegs";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final String SIGN2MINT_IMPORT_VORLAGE = "Sign2MINT-Import-Vorlage";
    public static final String VIDEO_UPLOAD_DIR = "esf.video.upload.dir";
    public static final String VIDEO_SERVLET_URL = "https://apps.delegs.de/delegseditormedia/DelegsVideoSupplierServlet/";

}
