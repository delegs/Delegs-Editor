package excel;

import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.material.DocumentItem;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class ExcelImportValidator {

    private static final String ID_PATTERN = "W[0-9]{5}";
    private static final String FACHBEGRIFF_PATTERN = "[A-Za-zÄÖÜäöüß0-9:.°\\-]+[,]{0,1}[\\s]{0,1}[(]{0,1}([A-Za-zÄÖÜäöüß0-9(°_][\\s]{0,1})*[).]{0,1}";
    private static final String VIDEONAME_PATTERN = "^W[0-9]{5}_[A-Za-z0-9\\-\\_]+([A-Za-z1-9]$)";
    private static final String URL_PATTERN = "(((ftp|http|https):\\/\\/)|(\\/)|(..\\/))(\\w+:{0,1}\\w*@)?(\\S+)(:[0-9]+)?(\\/|\\/([\\w#!:.?+=&%@!\\-\\/]))?";

    private final DocumentDb documentDb;
    private final String videoDirectoryPath;
    private List<File> videoFileNames;
    private List<DocumentItem> existingDocuments = new ArrayList<>();

    private final List<String> requiredColumns = Arrays.asList(
            ExcelImportSettings.ID_HEADER,
            ExcelImportSettings.FACHBEGRIFF_HEADER,
            ExcelImportSettings.VIDEONAME_HEADER,
            ExcelImportSettings.FACHBEREICHE_HEADER,
            ExcelImportSettings.EMPFEHLUNG_HEADER,
            ExcelImportSettings.VERWENDUNGSKONTEXT_HEADER,
            ExcelImportSettings.SPRACHE_HEADER,
            ExcelImportSettings.URSPRUNG_HEADER,
            ExcelImportSettings.REGION_HEADER,
            ExcelImportSettings.WIKTIONARY_LINK_HEADER,
            ExcelImportSettings.BEDEUTUNGSNUMMER_HEADER,
            ExcelImportSettings.WIKIPEDIA_LINK_HEADER,
            ExcelImportSettings.OPTIONALER_LINK_HEADER,
            ExcelImportSettings.GEBAERDENDE_HEADER,
            ExcelImportSettings.FILMPRODUKTION_HEADER,
            ExcelImportSettings.AUFNAHMEORT_HEADER,
            ExcelImportSettings.AUFNAHMEDATUM_HEADER,
            ExcelImportSettings.IGNORIEREN_HEADER);

    public ExcelImportValidator(ConfigurationService configurationService, ExcelImportDataProvider excelImportDataProvider) {
        documentDb = excelImportDataProvider.getDocumentDb();
        videoDirectoryPath = configurationService.getProperty(ExcelImportSettings.VIDEO_UPLOAD_DIR);
    }

    public boolean validateRequiredColumns(Map<String, Integer> columnPositionsMap) {
        Set<String> columns = columnPositionsMap.keySet();
        boolean requiredColumnsPresent = columns.containsAll(requiredColumns);

        if (!requiredColumnsPresent) {
            List<String> missingColumns = new ArrayList<>(requiredColumns);
            missingColumns.removeAll(columns);
            String missingColumnsString = String.join(",", missingColumns);
            String errorMessage = String.format("Folgende Spalte(n) wurden nicht gefunden: %s", missingColumnsString);
            ExcelImportLogger.logError(errorMessage);
        }

        return requiredColumnsPresent;
    }

    public void validateImports(List<ExcelImportDocument> importDocuments) {

        existingDocuments = documentDb.getDocumentItemsInFolder(ExcelImportSettings.IMPORT_FOLDER_ID);

        List<ExcelImportDocument> importsToIgnore = importDocuments.stream().filter(ExcelImportDocument::isIgnorieren).collect(Collectors.toList());
        importDocuments.removeAll(importsToIgnore);

        List<ExcelImportDocument> invalidImportDocuments = new ArrayList<>();

        validateId(importDocuments, invalidImportDocuments);
        validateFachbegriff(importDocuments, invalidImportDocuments);
        validateVideoname(importDocuments, invalidImportDocuments);
        validateUrls(importDocuments, invalidImportDocuments);
        validateDatum(importDocuments, invalidImportDocuments);

        invalidImportDocuments.forEach(invalidImportDocument -> {
            List<String> errorMessages = invalidImportDocument.getValidationMessages();
            errorMessages.forEach(ExcelImportLogger::logError);
            importDocuments.remove(invalidImportDocument);
        });
    }

    private void validateId(List<ExcelImportDocument> importDocuments, List<ExcelImportDocument> invalidImportDocuments) {

        for (ExcelImportDocument importDocument : importDocuments) {
            String id = importDocument.getId();
            if (id == null || !id.matches(ID_PATTERN)) {
                String errorMessage = String.format("Die Id %s ist ungültig", id);
                importDocument.addValidationMessage(errorMessage);
                if (!invalidImportDocuments.contains(importDocument))
                    invalidImportDocuments.add(importDocument);
            }
        }
    }

    private void validateFachbegriff(List<ExcelImportDocument> importDocuments, List<ExcelImportDocument> invalidImportDocuments) {

        for (ExcelImportDocument importDocument : importDocuments) {
            String fachbegriff = importDocument.getFachbegriff();
            if (fachbegriff == null || !fachbegriff.matches(FACHBEGRIFF_PATTERN)) {
                String errorMessage = String.format("Der Fachbegriff %s ist ungültig", fachbegriff);
                importDocument.addValidationMessage(errorMessage);
                if (!invalidImportDocuments.contains(importDocument))
                    invalidImportDocuments.add(importDocument);
            }

            String id = importDocument.getId();
            DocumentItem existingDocument = existingDocuments
                    .stream()
                    .filter(document -> document.getFileTitle().getTitleString().contains(id))
                    .findFirst()
                    .orElse(null);

            if(existingDocument != null) {
                String documentTitle = String.format("%s - %s", id, fachbegriff);
                String existingDocumentTitle = existingDocument.getFileTitle().getTitleString();

                if(!documentTitle.equals(existingDocumentTitle)) {
                    String errorMessage = String.format("Der Fachbegriff des Dokuments mit der Id %s darf nicht geändert werden", id);
                    importDocument.addValidationMessage(errorMessage);
                    if (!invalidImportDocuments.contains(importDocument))
                        invalidImportDocuments.add(importDocument);
                }
            }
        }
    }

    private void validateVideoname(List<ExcelImportDocument> importDocuments, List<ExcelImportDocument> invalidImportDocuments) {

        loadVideos();

        for (ExcelImportDocument importDocument : importDocuments) {
            String videoname = importDocument.getVideoName();

            if (videoname == null) {
                String errorMessage = "Der Videoname darf nicht leer sein";
                importDocument.addValidationMessage(errorMessage);
                importDocument.setIsValidImport(false);
                continue;
            }

            boolean isVideoNameValid = videoname.matches(VIDEONAME_PATTERN);
            if (!isVideoNameValid) {
                String errorMessage = String.format("Der Videoname %s ist ungültig", videoname);
                importDocument.addValidationMessage(errorMessage);
                importDocument.setIsValidImport(false);
            }

            boolean videoExists = videoFileNames.stream().anyMatch(video -> {
                String currentVideoName = FilenameUtils.removeExtension(video.getName());
                return currentVideoName.equals(videoname);
            });
            if (!videoExists) {
                String errorMessage = String.format("Das Video %s existiert nicht", videoname);
                importDocument.addValidationMessage(errorMessage);
                importDocument.setIsValidImport(false);
            }

            if (isVideoNameValid) {
                String fachbegriff = importDocument.getFachbegriff();
                String formattedFachebgriff = formatLikeVideoname(fachbegriff);
                String fachbegriffInVideo = videoname.substring(6);
                if (fachbegriffInVideo.equals(formattedFachebgriff)) {
                    String errorMessage = "Der Videoname stimmt nicht mit dem Fachbegriff überein";
                    importDocument.addValidationMessage(errorMessage);
                    importDocument.setIsValidImport(false);
                }
            }

            if (!importDocument.getIsValidImport() && !invalidImportDocuments.contains(importDocument))
                invalidImportDocuments.add(importDocument);
        }
    }

    private void validateUrls(List<ExcelImportDocument> importDocuments, List<ExcelImportDocument> invalidImportDocuments) {

        for (ExcelImportDocument importDocument : importDocuments) {

            String wikipediaUrl = importDocument.getWikipediaLink();
            if (wikipediaUrl != null && !wikipediaUrl.isEmpty() && (!wikipediaUrl.matches(URL_PATTERN) || !wikipediaUrl.contains("wikipedia.org/"))) {
                String errorMessage = String.format("%s enthält keine gültige Wikipedia URL", ExcelImportSettings.WIKIPEDIA_LINK_HEADER);
                importDocument.addValidationMessage(errorMessage);
                importDocument.setIsValidImport(false);
            }

            String wiktionaryUrl = importDocument.getWiktionaryLink();
            if (wikipediaUrl != null && !wiktionaryUrl.isEmpty() && (!wiktionaryUrl.matches(URL_PATTERN) || !wiktionaryUrl.contains("wiktionary.org/"))) {
                String errorMessage = String.format("%s enthält keine gültige Wiktionary URL", ExcelImportSettings.WIKTIONARY_LINK_HEADER);
                importDocument.addValidationMessage(errorMessage);
                importDocument.setIsValidImport(false);
            }

            String optionaleUrl = importDocument.getOptionalerLink();
            if (optionaleUrl != null && !optionaleUrl.isEmpty() && !optionaleUrl.matches(URL_PATTERN)) {
                String errorMessage = String.format("%s enthält keine gültige URL", ExcelImportSettings.OPTIONALER_LINK_HEADER);
                importDocument.addValidationMessage(errorMessage);
                importDocument.setIsValidImport(false);
            }

            if (!importDocument.getIsValidImport() && !invalidImportDocuments.contains(importDocument))
                invalidImportDocuments.add(importDocument);
        }
    }

    private void validateDatum(List<ExcelImportDocument> importDocuments, List<ExcelImportDocument> invalidImportDocuments) {

        for (ExcelImportDocument importDocument : importDocuments) {

            Date aufnahmedatum = importDocument.getAufnahmeDatum();
            if (aufnahmedatum == null) {
                String errorMessage = String.format("%s enthält kein Aufnahmedatum", ExcelImportSettings.AUFNAHMEDATUM_HEADER);
                importDocument.addValidationMessage(errorMessage);
                invalidImportDocuments.add(importDocument);
            }
        }
    }

    private String formatLikeVideoname(String string) {

        string = string.replace("ü", "ue");
        string = string.replace("ä", "ae");
        string = string.replace("ö", "oe");
        string = string.replace("ß", "ss");
        string = string.replaceAll("Ü(?=[a-zäöüß ])", "Ue");
        string = string.replaceAll("Ä(?=[a-zäöüß ])", "Ae");
        string = string.replaceAll("Ö(?=[a-zäöüß ])", "Oe");
        string = string.replaceAll("\\(", "");
        string = string.replaceAll("\\)", "");
        string = string.replaceAll(":", "");
        string = string.replaceAll(",", "");
        return string.replaceAll(" ", "_");
    }

    private void loadVideos() {
        File videoDirectory = new File(videoDirectoryPath);
        if (videoDirectory.exists()) {
            File[] videoDirectoryFiles = videoDirectory.listFiles();
            if (videoDirectoryFiles != null)
                videoFileNames = Arrays.stream(videoDirectoryFiles).filter(file -> file.getName().endsWith("mp4")).collect(Collectors.toList());
        } else
            videoFileNames = new ArrayList<>();
    }
}
