package excel;

import de.signWritingEditor.server.persistence.*;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelImportProcessor {

    private final DocumentXMLConverter documentXMLConverter;

    private final DocumentDb documentDb;
    private final UserDb userDb;
    private final SignDB signDb;
    private final SymbolDB symbolDB;

    User defaultUser;
    String importVorlageXML;

    private final List<User> existingUsers;

    SimpleDateFormat dateFormat = new SimpleDateFormat(ExcelImportSettings.DEFAULT_DATE_FORMAT);

    public ExcelImportProcessor(ExcelImportDataProvider excelImportDataProvider) throws IOException {
        documentDb = excelImportDataProvider.getDocumentDb();
        userDb = excelImportDataProvider.getUserDb();
        signDb = excelImportDataProvider.getSignDb();
        symbolDB = excelImportDataProvider.getSymbolDB();

        List<Map<String, String>> allSymbols = symbolDB.getAllSymbols();
        SymbolFactory symbolFactory = new SymbolFactory(allSymbols);
        TextbasedTokenStyleFactory textbasedStyleFactory = new TextbasedTokenStyleFactory();
        PositionedSymbolFactory positionedSymbolFactory = new PositionedSymbolFactory();
        documentXMLConverter = new DocumentXMLConverter(userDb, signDb, symbolFactory, textbasedStyleFactory, positionedSymbolFactory, 3);

        FileTitle importVorlageFileTitle = new FileTitle(ExcelImportSettings.SIGN2MINT_IMPORT_VORLAGE);
        DocumentItem importVorlage = documentDb.getDocumentItem(importVorlageFileTitle, ExcelImportSettings.SIGN2MINT_EXPORTS_FOLDER_ID);
        Id importVorlageId = importVorlage.getId();
        importVorlageXML = documentDb.getDocumentContent(importVorlageId);


        existingUsers = userDb.getAllUsers();
        defaultUser = existingUsers.stream().filter(user -> user.getUsername().equals(ExcelImportSettings.DEFAULT_USERNAME)).findFirst().orElse(null);
    }

    public void processImports(List<ExcelImportDocument> importDocuments) {

        List<DocumentItem> existingDocuments = this.documentDb.getDocumentItemsInFolder(ExcelImportSettings.IMPORT_FOLDER_ID);

        for (ExcelImportDocument importDocument : importDocuments) {

            String id = importDocument.getId();
            String fachbegriff = importDocument.getFachbegriff();

            String documentTitle = String.format("%s - %s", id, fachbegriff);
            FileTitle fileTitle = new FileTitle(documentTitle);

            DocumentItem existingDocument = existingDocuments.stream().filter(document -> {
                        FileTitle currentFileTitle = document.getFileTitle();
                        String currentFileTitleString = currentFileTitle.getTitleString();
                        return currentFileTitleString.equals(documentTitle);
                    })
                    .findFirst()
                    .orElse(null);

            if (existingDocument != null)
                updateDocument(existingDocument, importDocument);
            else
                createDocument(fileTitle, importDocument);
        }
    }

    /**
     * Aktualisiert ein bestehendes Dokument
     *
     * @param existingDocumentItem das Dokument, was aktualisiert werden soll
     * @param importedDocument     das aus der Excel Datei gelesene Dokument mit den aktualisierten Daten
     */
    private void updateDocument(DocumentItem existingDocumentItem, ExcelImportDocument importedDocument) {

        Id existingDocumentItemId = existingDocumentItem.getId();
        String ownerName = existingDocumentItem.getOwner();
        User owner = existingUsers.stream().filter(user -> user.getUsername().equals(ownerName)).findFirst().orElse(null);
        String existingDocumentXML = documentDb.getDocumentContent(existingDocumentItemId);
        Document existingDocument = documentXMLConverter.fromXML(existingDocumentXML, owner);
        FileItemColorLabel fileItemColorLabel = existingDocumentItem.getColorLabel();

        List<Token> documentTokens = existingDocument.getAllTokens();
        for (Token token : documentTokens) {
            if (token instanceof DateFormToken) {
                DateFormToken dateFormToken = (DateFormToken) token;
                String description = dateFormToken.getDescription();

                if (description.equals(ExcelImportSettings.AUFNAHMEDATUM_TOKEN)) {
                    Date aufnahmedatum = importedDocument.getAufnahmeDatum();
                    String newAufnahmedatum = dateFormat.format(aufnahmedatum);
                    String oldAufnahmedatum = dateFormToken.getInputContent();
                    if (!oldAufnahmedatum.equals(newAufnahmedatum))
                        dateFormToken.setInputContent(newAufnahmedatum);
                }
            } else if (token instanceof FormToken) {
                FormToken formToken = (FormToken) token;
                String description = formToken.getDescription();

                if (description.equals(ExcelImportSettings.FACHBEGRIFF_TOKEN)) {
                    String newFachbegriff = importedDocument.getFachbegriff();
                    String oldFachbegriff = formToken.getInputContent();
                    if (!oldFachbegriff.equals(newFachbegriff))
                        formToken.setInputContent(newFachbegriff);
                }
                if (description.equals(ExcelImportSettings.WIKTIONARY_LINK_TOKEN)) {
                    String newWiktionaryLink = importedDocument.getWiktionaryLink();
                    String oldWiktionaryLink = formToken.getInputContent();
                    if (!oldWiktionaryLink.equals(newWiktionaryLink))
                        formToken.setInputContent(newWiktionaryLink);
                }
                if (description.equals(ExcelImportSettings.BEDEUTUNGSNUMMER_TOKEN)) {
                    String newBedeutungsnummer = importedDocument.getBedeutungsnummer();
                    String oldBedeutungsnummer = formToken.getInputContent();
                    if (!oldBedeutungsnummer.equals(newBedeutungsnummer))
                        formToken.setInputContent(newBedeutungsnummer);
                }
                if (description.equals(ExcelImportSettings.WIKIPEDIA_LINK_TOKEN)) {
                    String newWikipediaLink = importedDocument.getWikipediaLink();
                    String oldWikipediaLink = formToken.getInputContent();
                    if (!oldWikipediaLink.equals(newWikipediaLink))
                        formToken.setInputContent(newWikipediaLink);
                }
                if (description.equals(ExcelImportSettings.OPTIONALER_LINK_TOKEN)) {
                    String newOptionalerLink = importedDocument.getOptionalerLink();
                    String oldOptionalerLink = formToken.getInputContent();
                    if (!oldOptionalerLink.equals(newOptionalerLink))
                        formToken.setInputContent(newOptionalerLink);
                }
                if (description.equals(ExcelImportSettings.GEBAERDENDE_TOKEN)) {
                    String newGebaerdende = importedDocument.getGebaerdende();
                    String oldGebaerdende = formToken.getInputContent();
                    if (!oldGebaerdende.equals(newGebaerdende))
                        formToken.setInputContent(newGebaerdende);
                }
                if (description.equals(ExcelImportSettings.FILMPRODUKTION_TOKEN)) {
                    String newFilmproduktion = importedDocument.getFilmproduktion();
                    String oldFilmproduktion = formToken.getInputContent();
                    if (!oldFilmproduktion.equals(newFilmproduktion))
                        formToken.setInputContent(newFilmproduktion);
                }
                if (description.equals(ExcelImportSettings.AUFNAHMEORT_TOKEN)) {
                    String newAufnahmeort = importedDocument.getAufnahmeort();
                    String oldAufnahmeort = formToken.getInputContent();
                    if (!oldAufnahmeort.equals(newAufnahmeort))
                        formToken.setInputContent(newAufnahmeort);
                }
            } else if (token instanceof TagToken) {
                TagToken tagToken = (TagToken) token;
                String description = tagToken.getDescription();
                tagToken.resetItems();

                if (description.equals(ExcelImportSettings.FACHBEREICHE_TOKEN)) {
                    ArrayList<String> fachbereiche = importedDocument.getFachbereiche();
                    fachbereiche.forEach(fachbereich -> setSelectedTag(tagToken, fachbereich));
                }
                if (description.equals(ExcelImportSettings.SPRACHE_TOKEN)) {
                    ArrayList<String> sprache = importedDocument.getSprache();
                    sprache.forEach(s -> setSelectedTag(tagToken, s));
                }
                if (description.equals(ExcelImportSettings.URSPRUNG_TOKEN)) {
                    ArrayList<String> ursprung = importedDocument.getUrprung();
                    ursprung.forEach(u -> setSelectedTag(tagToken, u));
                }
                if (description.equals(ExcelImportSettings.VERWENDUNGSKONTEXT_TOKEN)) {
                    ArrayList<String> verwendungskontext = importedDocument.getVerwendungskontext();
                    verwendungskontext.forEach(v -> setSelectedTag(tagToken, v));
                }
                if (description.equals(ExcelImportSettings.REGION_TOKEN)) {
                    ArrayList<String> region = importedDocument.getRegion();
                    region.forEach(r -> setSelectedTag(tagToken, r));
                }
                if (description.equals(ExcelImportSettings.EMPFEHLUNG_TOKEN)) {
                    boolean isEmpfehlung = importedDocument.isEmpfehlung();
                    if (isEmpfehlung)
                        setSelectedTag(tagToken, "ja");
                }

                tagToken.sortItems();
            } else if (token instanceof SignItemToken) {
                SignItemToken signToken = (SignItemToken) token;
                String tokenText = signToken.getText();

                if (tokenText.isEmpty()) {
                    boolean assignSuccess = tryToAssignGebaerdenschrift(importedDocument, signToken);
                    if (!assignSuccess)
                        fileItemColorLabel = FileItemColorLabel.YELLOW;
                }
            } else if (token instanceof VideoToken) {
                VideoToken videoToken = (VideoToken) token;
                String newVideoName = importedDocument.getVideoName();
                String newVideoUrl = ExcelImportSettings.VIDEO_SERVLET_URL + newVideoName + ExcelImportSettings.VIDEO_FILE_EXTENSION;
                String oldVideoUrl = videoToken.getUrl();
                if (!oldVideoUrl.equals(newVideoUrl))
                    videoToken.setUrl(newVideoUrl);
            }
        }

        String updatedDocumentXML = documentXMLConverter.toXML(existingDocument);
        if (!existingDocumentXML.equals(updatedDocumentXML))
            documentDb.updateDocument(existingDocumentItem, updatedDocumentXML, fileItemColorLabel);
    }

    private void createDocument(FileTitle fileTitle, ExcelImportDocument importedDocument) {

        Document document = documentXMLConverter.fromXML(importVorlageXML, defaultUser);
        document.setDocumentTitle(fileTitle);

        FileItemColorLabel fileItemColorLabel = FileItemColorLabel.NONE;

        List<Token> documentTokens = document.getAllTokens();
        for (Token token : documentTokens) {
            if (token instanceof DateFormToken) {
                DateFormToken dateFormToken = (DateFormToken) token;
                String description = dateFormToken.getDescription();

                if (description.equals(ExcelImportSettings.AUFNAHMEDATUM_TOKEN)) {
                    Date aufnahmeDatum = importedDocument.getAufnahmeDatum();
                    String formattedAufnahmeDatum = dateFormat.format(aufnahmeDatum);
                    dateFormToken.setInputContent(formattedAufnahmeDatum);
                }
                if (description.equals(ExcelImportSettings.HOCHLADEDATUM_TOKEN)) {
                    Date hochladeDatum = new Date();
                    String formattedAufnahmeDatum = dateFormat.format(hochladeDatum);
                    dateFormToken.setInputContent(formattedAufnahmeDatum);
                }
            } else if (token instanceof FormToken) {
                FormToken formToken = (FormToken) token;
                String description = formToken.getDescription();

                if (description.equals(ExcelImportSettings.FACHBEGRIFF_TOKEN)) {
                    String fachgebriff = importedDocument.getFachbegriff();
                    formToken.setInputContent(fachgebriff);
                }
                if (description.equals(ExcelImportSettings.WIKTIONARY_LINK_TOKEN)) {
                    String wiktionaryLink = importedDocument.getWiktionaryLink();
                    formToken.setInputContent(wiktionaryLink);
                }
                if (description.equals(ExcelImportSettings.BEDEUTUNGSNUMMER_TOKEN)) {
                    String bedeutungsnummer = importedDocument.getBedeutungsnummer();
                    formToken.setInputContent(bedeutungsnummer);
                }
                if (description.equals(ExcelImportSettings.WIKIPEDIA_LINK_TOKEN)) {
                    String wikipediaLink = importedDocument.getWikipediaLink();
                    formToken.setInputContent(wikipediaLink);
                }
                if (description.equals(ExcelImportSettings.OPTIONALER_LINK_TOKEN)) {
                    String optionalerLink = importedDocument.getOptionalerLink();
                    formToken.setInputContent(optionalerLink);
                }
                if (description.equals(ExcelImportSettings.GEBAERDENDE_TOKEN)) {
                    String gebaerdende = importedDocument.getGebaerdende();
                    formToken.setInputContent(gebaerdende);
                }
                if (description.equals(ExcelImportSettings.FILMPRODUKTION_TOKEN)) {
                    String filmproduktion = importedDocument.getFilmproduktion();
                    formToken.setInputContent(filmproduktion);
                }
                if (description.equals(ExcelImportSettings.AUFNAHMEORT_TOKEN)) {
                    String aufnahmeort = importedDocument.getAufnahmeort();
                    formToken.setInputContent(aufnahmeort);
                }
            } else if (token instanceof TagToken) {
                TagToken tagToken = (TagToken) token;
                String description = tagToken.getDescription();

                List<String> itemList = tagToken.getItemList();
                List<String> selectedItems = tagToken.getSelectedItemList();
                itemList.addAll(selectedItems);
                selectedItems.clear();

                if (description.equals(ExcelImportSettings.FACHBEREICHE_TOKEN)) {
                    ArrayList<String> fachbereiche = importedDocument.getFachbereiche();
                    fachbereiche.forEach(fachbereich -> setSelectedTag(tagToken, fachbereich));
                }
                if (description.equals(ExcelImportSettings.SPRACHE_TOKEN)) {
                    ArrayList<String> sprache = importedDocument.getSprache();
                    sprache.forEach(s -> setSelectedTag(tagToken, s));
                }
                if (description.equals(ExcelImportSettings.URSPRUNG_TOKEN)) {
                    ArrayList<String> ursprung = importedDocument.getUrprung();
                    ursprung.forEach(u -> setSelectedTag(tagToken, u));
                }
                if (description.equals(ExcelImportSettings.VERWENDUNGSKONTEXT_TOKEN)) {
                    ArrayList<String> verwendungskontext = importedDocument.getVerwendungskontext();
                    verwendungskontext.forEach(v -> setSelectedTag(tagToken, v));
                }
                if (description.equals(ExcelImportSettings.REGION_TOKEN)) {
                    ArrayList<String> region = importedDocument.getRegion();
                    region.forEach(r -> setSelectedTag(tagToken, r));
                }
                if (description.equals(ExcelImportSettings.EMPFEHLUNG_TOKEN)) {
                    boolean isEmpfehlung = importedDocument.isEmpfehlung();
                    if (isEmpfehlung)
                        setSelectedTag(tagToken, "ja");
                }
            } else if (token instanceof SignItemToken) {
                SignItemToken signToken = (SignItemToken) token;
                boolean assignSuccess = tryToAssignGebaerdenschrift(importedDocument, signToken);
                if (!assignSuccess)
                    fileItemColorLabel = FileItemColorLabel.YELLOW;

            } else if (token instanceof VideoToken) {
                VideoToken videoToken = (VideoToken) token;
                String videname = importedDocument.getVideoName();
                String videoUrl = ExcelImportSettings.VIDEO_SERVLET_URL + videname + ExcelImportSettings.VIDEO_FILE_EXTENSION;
                videoToken.setUrl(videoUrl);
            }
        }

        String contentXML = documentXMLConverter.toXML(document);
        String defaultUserDisplayName = defaultUser.getDisplayUsername();
        DocumentItem documentItem = documentDb.createDocument(fileTitle, defaultUserDisplayName);
        Id documentId = documentItem.getId();
        documentDb.saveDocument(documentId, fileTitle, contentXML, defaultUserDisplayName, fileItemColorLabel, ExcelImportSettings.IMPORT_FOLDER_ID);
    }

    private void setSelectedTag(TagToken tagToken, String word) {
        List<String> selectableItems = tagToken.getItemList();
        if (selectableItems.contains(word)) {
            selectableItems.remove(word);
            tagToken.selectWord(word);
        }
    }

    private boolean tryToAssignGebaerdenschrift(ExcelImportDocument importedDocument, SignItemToken signToken) {
        String videoName = importedDocument.getVideoName();
        String id = importedDocument.getId();
        String glosse = videoName.substring(id.length() + 1).toUpperCase();
        List<SignItem> signs = signDb.findSigns(glosse, SignLocale.DGS);
        signToken.setText(glosse);
        if (signs.size() > 0) {
            SignItem firstFoundSign = signs.get(0);
            signToken.setSignItem(firstFoundSign);
        }

        // Nur true, wenn es EINE Gebärdenschrift gibt
        return signs.size() == 1;
    }
}
