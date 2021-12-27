package excel;

import org.apache.poi.ss.usermodel.DateUtil;

import java.util.*;

public class ExcelImportConverter {

    public List<ExcelImportDocument> readResultToImportDocuments(String[][] readResult, Map<String, Integer> columnMapping) {

        List<ExcelImportDocument> excelImportDocuments = new ArrayList<>();

        for (int i = 0, readResultLength = readResult.length; i < readResultLength; i++) {
            String[] row = readResult[i];
            ExcelImportDocument excelImportDocument = new ExcelImportDocument(i + 1);

            String id = readString(ExcelImportSettings.ID_HEADER, row, columnMapping);
            excelImportDocument.setId(id);
            String fachbegriff = readString(ExcelImportSettings.FACHBEGRIFF_HEADER, row, columnMapping);
            excelImportDocument.setFachbegriff(fachbegriff);
            String videoname = readString(ExcelImportSettings.VIDEONAME_HEADER, row, columnMapping);
            excelImportDocument.setVideoName(videoname);
            ArrayList<String> fachbereiche = readFachbereiche(row, columnMapping);
            excelImportDocument.setFachbereiche(fachbereiche);
            boolean empfehlung = readBoolean(ExcelImportSettings.EMPFEHLUNG_HEADER, row, columnMapping);
            excelImportDocument.setEmpfehlung(empfehlung);
            ArrayList<String> verwendungskontext = readList(ExcelImportSettings.VERWENDUNGSKONTEXT_HEADER, row, columnMapping);
            excelImportDocument.setVerwendungskontext(verwendungskontext);
            ArrayList<String> sprache = readList(ExcelImportSettings.SPRACHE_HEADER, row, columnMapping);
            excelImportDocument.setSprache(sprache);
            ArrayList<String> ursprung = readList(ExcelImportSettings.URSPRUNG_HEADER, row, columnMapping);
            excelImportDocument.setUrprung(ursprung);
            ArrayList<String> region = readList(ExcelImportSettings.REGION_HEADER, row, columnMapping);
            excelImportDocument.setRegion(region);
            String wikipediaLink = readString(ExcelImportSettings.WIKIPEDIA_LINK_HEADER, row, columnMapping);
            excelImportDocument.setWikipediaLink(wikipediaLink);
            String bedeutungsnummer = readString(ExcelImportSettings.BEDEUTUNGSNUMMER_HEADER, row, columnMapping);
            excelImportDocument.setBedeutungsnummer(bedeutungsnummer);
            String wiktionaryLink = readString(ExcelImportSettings.WIKTIONARY_LINK_HEADER, row, columnMapping);
            excelImportDocument.setWiktionaryLink(wiktionaryLink);
            String optionalerLink = readString(ExcelImportSettings.OPTIONALER_LINK_HEADER, row, columnMapping);
            excelImportDocument.setOptionalerLink(optionalerLink);
            String gebaerdende = readString(ExcelImportSettings.GEBAERDENDE_HEADER, row, columnMapping);
            excelImportDocument.setGebaerdende(gebaerdende);
            String filmproduktion = readString(ExcelImportSettings.FILMPRODUKTION_HEADER, row, columnMapping);
            excelImportDocument.setFilmproduktion(filmproduktion);
            String aufnahmeort = readString(ExcelImportSettings.AUFNAHMEORT_HEADER, row, columnMapping);
            excelImportDocument.setAufnahmeort(aufnahmeort);
            Date aufnahmeDatum = readDate(ExcelImportSettings.AUFNAHMEDATUM_HEADER, row, columnMapping);
            excelImportDocument.setAufnahmeDatum(aufnahmeDatum);
            boolean ignorieren = readBoolean(ExcelImportSettings.IGNORIEREN_HEADER, row, columnMapping);
            excelImportDocument.setIgnorieren(ignorieren);

            excelImportDocuments.add(excelImportDocument);
        }

        return excelImportDocuments;
    }

    private String readString(String columnName, String[] row, Map<String, Integer> columnMapping) {
        int columnIndex = columnMapping.get(columnName);
        String string = row[columnIndex];
        return string != null ? string.trim() : null;
    }

    private boolean readBoolean(String columnName, String[] row, Map<String, Integer> columnMapping) {
        String value = readString(columnName, row, columnMapping);
        if (value == null)
            return false;

        String loweredString = value.toLowerCase();
        String trimmedString = loweredString.trim();
        return trimmedString.equals("x");
    }

    private Date readDate(String columnName, String[] row, Map<String, Integer> columnMapping) {
        String value = readString(columnName, row, columnMapping);
        if (value == null)
            return null;

        try {
            double doubleValue = Double.parseDouble(value);
            return DateUtil.getJavaDate(doubleValue);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private ArrayList<String> readList(String columnName, String[] row, Map<String, Integer> columnMapping) {
        String valuesAsString = readString(columnName, row, columnMapping);
        if (valuesAsString == null)
            return new ArrayList<>();

        String[] splittedValues = valuesAsString.split(ExcelImportSettings.ValueSeparator);
        return new ArrayList<>(Arrays.asList(splittedValues));
    }

    private ArrayList<String> readFachbereiche(String[] row, Map<String, Integer> columnMapping) {
        ArrayList<String> importedFachbereiche = readList(ExcelImportSettings.FACHBEREICHE_HEADER, row, columnMapping);

        ArrayList<String> fachbereiche = new ArrayList<>();
        for (String splittedFachbereich : importedFachbereiche) {
            String loweredFachbereich = splittedFachbereich.toLowerCase();
            String trimmedFachbereich = loweredFachbereich.trim();

            if (trimmedFachbereich.startsWith("ma"))
                fachbereiche.add("Mathematik");
            else if (trimmedFachbereich.startsWith("ph"))
                fachbereiche.add("Physik");
            else if (trimmedFachbereich.startsWith("ch"))
                fachbereiche.add("Chemie");
            else if (trimmedFachbereich.startsWith("bi"))
                fachbereiche.add("Biologie");
            else if (trimmedFachbereich.startsWith("ge"))
                fachbereiche.add("Geowissenschaft");
            else if (trimmedFachbereich.startsWith("me"))
                fachbereiche.add("Medizin");
            else if (trimmedFachbereich.startsWith("as"))
                fachbereiche.add("Astronomie");
            else if (trimmedFachbereich.startsWith("in"))
                fachbereiche.add("Informatik");
        }

        return fachbereiche;
    }
}
