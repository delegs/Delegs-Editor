package excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelImportDocument {

    private int rowIndex;
    private String id;
    private String fachbegriff;
    private String videoName;
    private ArrayList<String> fachbereiche = new ArrayList<>();
    private boolean empfehlung;
    private ArrayList<String> verwendungskontext; // todo: Enum ?
    private ArrayList<String> sprache;
    private ArrayList<String> urprung;
    private ArrayList<String> region;
    private String wiktionaryLink;
    private String bedeutungsnummer;
    private String wikipediaLink;
    private String optionalerLink;
    private String gebaerdende;
    private String filmproduktion;
    private String aufnahmeort;
    private Date aufnahmeDatum;
    private boolean ignorieren;

    private boolean isValidImport = true;
    private List<String> validationMessages = new ArrayList<>();

    public ExcelImportDocument(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFachbegriff() {
        return fachbegriff;
    }

    public void setFachbegriff(String fachbegriff) {
        this.fachbegriff = fachbegriff;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public ArrayList<String> getFachbereiche() {
        return fachbereiche;
    }

    public void setFachbereiche(ArrayList<String> fachbereiche) {
        this.fachbereiche = fachbereiche;
    }

    public boolean isEmpfehlung() {
        return empfehlung;
    }

    public void setEmpfehlung(boolean empfehlung) {
        this.empfehlung = empfehlung;
    }

    public ArrayList<String> getVerwendungskontext() {
        return verwendungskontext;
    }

    public void setVerwendungskontext(ArrayList<String> verwendungskontext) {
        this.verwendungskontext = verwendungskontext;
    }

    public ArrayList<String> getSprache() {
        return sprache;
    }

    public void setSprache(ArrayList<String> sprache) {
        this.sprache = sprache;
    }

    public ArrayList<String> getUrprung() {
        return urprung;
    }

    public void setUrprung(ArrayList<String> urprung) {
        this.urprung = urprung;
    }

    public ArrayList<String> getRegion() {
        return region;
    }

    public void setRegion(ArrayList<String> region) {
        this.region = region;
    }

    public String getWiktionaryLink() {
        return wiktionaryLink;
    }

    public void setWiktionaryLink(String wiktionaryLink) {
        this.wiktionaryLink = wiktionaryLink;
    }

    public String getBedeutungsnummer() {
        return bedeutungsnummer;
    }

    public void setBedeutungsnummer(String bedeutungsnummer) {
        this.bedeutungsnummer = bedeutungsnummer;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public String getOptionalerLink() {
        return optionalerLink;
    }

    public void setOptionalerLink(String optionalerLink) {
        this.optionalerLink = optionalerLink;
    }

    public String getGebaerdende() {
        return gebaerdende;
    }

    public void setGebaerdende(String gebaerdende) {
        this.gebaerdende = gebaerdende;
    }

    public String getFilmproduktion() {
        return filmproduktion;
    }

    public void setFilmproduktion(String filmproduktion) {
        this.filmproduktion = filmproduktion;
    }

    public String getAufnahmeort() {
        return aufnahmeort;
    }

    public void setAufnahmeort(String aufnahmeort) {
        this.aufnahmeort = aufnahmeort;
    }

    public Date getAufnahmeDatum() {
        return aufnahmeDatum;
    }

    public void setAufnahmeDatum(Date aufnahmeDatum) {
        this.aufnahmeDatum = aufnahmeDatum;
    }

    public boolean isIgnorieren() {
        return ignorieren;
    }

    public void setIgnorieren(boolean ignorieren) {
        this.ignorieren = ignorieren;
    }

    public boolean getIsValidImport() {
        return isValidImport;
    }

    public void setIsValidImport(boolean validImport) {
        isValidImport = validImport;
    }

    public List<String> getValidationMessages() { return validationMessages;}

    public void addValidationMessage(String importMessage) {
        importMessage = String.format("Zeile %s: %s",rowIndex, importMessage);
        validationMessages.add(importMessage);
    }
}
