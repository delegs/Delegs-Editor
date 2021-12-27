# Sign2MINT Importer

Mithilfe des Sign2MINT Importers lassen sich neue Fachgebärden für Sign2MINT einfach in die Datenbank einfügen.

## Vorraussetzungen 

Der Import basiert auf einer Excel Datei, welche folgendermaßen aufgebaut sein muss:

| Spalte             | Beschreibung                                                                                                          | Beispiel                                                                                                                         |
|--------------------|-----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| Id                 | Id des Fachbegriffs. Beginnt mit einem W, gefolgt von einer fünfstelligen fortlaufenden Nummer. Muss einzigartig sein | 'W00012'                                                                                                                         |
| Fachbegriff        | Bezeichnung der Fachgebärde                                                                                           | Komet                                                                                                                            |
| Videoname          | Dateiname muss mit dem Video-Namen übereinstimmen und setzt sich zusammen aus "Id_Fachbegriff(+Variantenzahl)"        | W00012_Komet3                                                                                                                    |
| Fachbereiche       | Gibt an, zu welchen Fachbereichen der Begriff gehört                                                                  | Phy, Mat, Inf                                                                                                                     |
| Empfehlung         | Gibt an, ob die Variante des Fachbegriffs von Sign2MINT empfohlen wurde                                               | 'x' für ja, leer lassen für nein                                                                                                 |
| Verwendungskontext | Der Kontext, in dem der Fachbegriff verwendet wird                                                                    | 'Alltäglicher Bereich', 'Schulischer Bereich' und 'Akademischer Bereich'                                                         |
| Sprache            | Die Sprache, aus welcher der Fachbegriff stammt                                                                       | 'DGS','ASL', usw.                                                                                                                |
| Ursprung           | Ursprung des Fachbegriffs                                                                                             | 'Bestand', 'Neuschöpfung', 'Entlehnung' oder 'International'                                                                     |
| Region             | Region, aus welcher der Fachbegriff stammt                                                                            | 'Nord', 'Ost', 'Süd' oder 'West'                                                                                                 |
| Wiktionary Link    | Wiktionary Link zur Definition des Fachbegriffs                                                                       | 'https://de.wiktionary.org/wiki/Komet'                                                                                           |
| Bedeutungsnummer   | Bedeutungsnummer aus dem Wiktionary Eintrag (Wenn es mehrere Definitionen gibt)                                       | '3'                                                                                                                              |
| Wikipedia Link     | Wikipedia Link zum Fachbegriff                                                                                        | 'https://de.wikipedia.org/wiki/Komet'                                                                                            |
| Optionaler Link    | Bietet die Möglichkeit, einen zusätzlichen Link zum Fachbegriff anzugeben                                             | 'https://www.spektrum.de/lexikon/physik/kometen/8190'                                                                            |
| Gebärdende         | Name des Gebärdenden im Video                                                                                         | 'Arthur Dent'                                                                                                                    |
| Filmproduktion     | Name der Person, die das Video aufgenommen hat                                                                        | 'Friedrich Wilhelm'                                                                                                              |
| Aufnahmeort        | Ort, an dem die Aufnahme des Videos durchgeführt wurde                                                                | 'Dippoldiswalde'                                                                                                                 |
| Aufnahmedatum      | Datum der Aufnahme des Videos                                                                                         | 28.10.2021                                                                                                                       |
| Ignorieren         | Gibt an, ob die Zeile vom Importer ignoriert werden soll                                                              | 'nein', wenn die Zeile nicht berücksichtigt werden soll. Leer lassen, wenn der Fachbegriff importiert bzw. geupdatet werden soll |

Dabei gibt es folgende Besonderheiten, die beim Hinzufügen einer neuen Fachgebärde beachtet werden müssen:

- Unterstriche ('_'), Klammern ('(' und ')'), Doppelpunkte (':') und Kommas (',') werden während des Imports entfernt
- Die Umlaute ü, ö und ä, sowie das ß werden vom Importer durch ue, oe und ae bzw. ss ersetzt. 
- Hochgestellte Zahlen benötigen im Videonamen das Präfix '_hoch_' und müssen ausgeschrieben werden (z.B. 'x_hoch_zwei')
- Tiefgestellte Zahlen benötigen im Videonamen das Präfix '_unten_' und müssen ausgeschrieben werden (z.B. 'H_unten_zwei_O')

## Konfiguration

Vor dem Import muss in der `environment.ts` des Sign2MINT Fronends der Endpunkt des Delegs Importers hinterlegt werden.

## Import

Der Import kann durch die Sign2MINT Komponente `excel-import`, welche über `/import` erreichbar ist, durchgeführt werden. Dazu wird die Excel Datei mit den neuen Lexikoneinträgen und optional die Zip-Datei mit den Videos einfach im Drop Bereich der Anwendung abgelegt. Durch einen Klick auf `Import`
kann der Import dann gestartet werden. Zu beachten ist, dass die Zip-Datei maximal 2GB groß sein darf und keine Ordner enthalten darf. Die Dateien werden daraufhin zum delegs Server übertragen. Nach der Übertragung wird die Zip Datei entpackt und alle darin enthaltenen `.mp4` Videos per [ffmpeg](https://ffmpeg.org/)
komprimiert. Im Anschluss werden sie in den `upload` Ordner kopiert. 

**Achtung:** Videos, welche nicht in einem delegs Dokument referenziert sind, werden einmal täglich automatisch wieder gelöscht, wenn diese seit über einem Tag auf dem Server liegen.

Im nächsten Schritt wird die Excel Datei ausgelesen. Die enthaltenen Datensätze werden validiert und gültige Einträge in das delegs Verzeichnis `/Home/Geprüfte Gebärden/Test` Ordner importiert. Sollte ein Lexikoneintrag bereits existieren, werden dessen Eigenschaften aktualisiert. 

Nach dem Import zeigt eine Zusammenfassung mögliche Fehler und die benötigte Zeit der einzelnen Operationen.
