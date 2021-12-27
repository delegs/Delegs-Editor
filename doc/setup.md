# Setup

## Verwendete Technologien

- [Ant](https://ant.apache.org/bindownload.cgi)
- [Java 8](https://adoptium.net/?variant=openjdk8&jvmVariant=hotspot) (eine höhere Version kann aufgrund von GWT 2.8.2
  nicht verwendet werden)
- [GWT 2.8.2](https://goo.gl/pZZPXS)
- MariaDB 10.1.41

Optional kann die Datenbank auch mittels docker und docker-compose betrieben werden.  
Zum Deployment auf einem Server kann beispielsweise Tomcat oder ein entsprechendes docker-Image verwendet werden,
siehe [Server Setup](#server-setup).

## Abhängigkeiten

### DelegsVideoSupplier

Im Editor können Videos hochgeladen werden. Die Speicherung und Bereitstellung dieser Videos übernimmt dabei das, in einem separat
gepflegten Repository befindliche, Servlet "DelegsVideoSupplier". Wenn dieser Dienst nicht läuft, können keine Videos hochgeladen werden,
alles andere funktioniert jedoch weiterhin.

### SignPuddle

Der delegs-Editor sucht einmal täglich (zu einer [konfigurierbaren Uhrzeit](#konfiguration)) nach neuen
GebärdenSchriften auf SignPuddle und importiert diese.

## Lokales Setup

### IDEs

<details>
<summary>Eclipse</summary>

#### Installation von Eclipse

1. Die "Eclipse IDE for Java Developers" herunterladen unter: https://www.eclipse.org/downloads/packages
2. In den gewünschten Zielordner entpacken
3. Eclipse öffnen und Workspace im gewünschten Zielpfad anlegen

#### Projektkonfiguration

4. Den Repository-Ordner (d.h. den Root-Ordner delegseditor des geklonten Repositories) in den Workspace importieren:
    + File &rarr; Open Projects from File System
5. Assertions erlauben:
    + Window &rarr; Preferences &rarr; Java &rarr; Installed JREs &rarr; Jre auswählen &rarr; Edit
    + Unter **Default VM Arguments** den Eintrag **-ea** hinzufügen
6. Die delegs-Eclipse Templates importieren aus *\doc\entwicklerarbeitsplatz\templates\template.xml*
    + Window &rarr; Preferences &rarr; Java &rarr; Editor &rarr; Templates &rarr; Import...
7. Den Java-Compiler für das Projekt auf `1.8` setzen:
    + Rechtsklick auf Projekt &rarr; Properties &rarr; Java Compiler
    + **Enable project specific settings** aktivieren und Compiler auf `1.8` setzen
8. Die ZIP **ISWA2010_PNG_4x.zip** (im setup Ordner) in den Ordner **symbolImages** entpacken
9. Die Dateien aus dem Ordner **config\local** (**OHNE** Unterordner) in den Ordner **config** kopieren
10. In der Datei **buildscript.properties** im Ordner config/ kann der verwendete RAM und die Anzahl an CPU Kernen (d.h.
    die Ressourcen) festgelegt werden, die das Build-Skript verwenden darf. Diese Werte können bei Bedarf an die
    Hardware des verwendeten Rechners angepasst werden

#### Einbinden des GWT-Plugins

11. Das GWT-Plugin installieren:

+ Help &rarr; Install New Software
    + Im Feld **Work with:** die URL eingeben: http://storage.googleapis.com/gwt-eclipse-plugin/v3/snapshot
    + ENTER-Taste drücken
    + Alle Checkboxen des GWT-Plugins selektieren
    + next
    + Lizenzbedingungen zustimmen und Plugin installieren
    + Zwischendurch fragt Eclipse, ob der Inhalt vertrauenswürdig ist. Dies muss bestätigt werden
    + Nach dem Installieren Eclipse neu starten

12. Das GWT-Plugin für das Projekt einbinden:

+ Window &rarr; Preferences &rarr; GWT &rarr; GWT Settings &rarr; Haken bei GWT 2.8.2 setzen &rarr; Apply and Close
+ Rechtsklick auf das Projekt &rarr; Properties &rarr; GWT &rarr; General Settings
+ Checkbox **Use GWT** selektieren
+ **Use specific SDK** mit **GWT 2.8.2 - 2.8.2** auswählen
    + Falls kein SDK in der Auswahl erscheint, hilft es, die Checkbox **Use GWT** zu de- und wieder zu selektieren. Hilf
      auch dies nicht, dann auf **configure SDKs...** klicken. Zweimal **Apply and close** und anschließend noch einmal
      die Properties öffnen. Das *default GWT sdk* sollte jetzt da sein.
+ **Apply and close** auswählen

</details>
<details>
<summary>IntelliJ</summary>

#### Voraussetzungen

- IntelliJ **Ultimate** ([Download](https://www.jetbrains.com/de-de/idea/download/))

#### Projektkonfiguration

1. IntelliJ öffnen und das delegseditor Repository klonen und
   anschließend öffnen
2. Nach dem Öffnen erscheinen im unteren rechten Bereich zwei Popups:
   `Ant Build Script found` -> Hier reicht ein Klick auf "Add Ant Build File"  
   `Frameworks Detected` -> Hier auf "Configure" klicken und anschließend alle Konfigurationsdateien  
   auswählen und die Auswahl mit "OK" bestätigen
3. Über `File` > `Project Structure` die Projekteinstellungen aufrufen und unter `Projekt`
   als `Project SDK` `corretto-1.8 Version 1.8.0_292` festlegen
4. Dann unter `Module` das Modul `SignWritingEditor` auswählen und das
   Plugin `com.gwtplugins.gwt.eclipse.core.GWT_CONTAINER/GWT2.8.2` entfernen
5. Als nächstes auf `Facets` klicken und unter `GWT` den GWT Pfad überprüfen
6. Nun auf `Target Web Facet` das Web Modul auswählen, dessen `Web Resource Directory` auf das `\war` Verzeichnis des
   Repositorys verweist
7. Jetzt noch über den Button `Create Artifact` das Artifakt erstellen und dann die Projekteinstellungen mit `OK`
   schließen

#### Startkonfiguration

8. Zum Erstellen der Run Configuration in der Menüleiste oben rechts auf `Add Configuration` klicken
9. Im folgenden Dialog auf `Add new` und dann auf `GWT Configuration`
10. Als `Name` der Konfiguration `Delegs` eingeben
11. Das Modul `SignWritingEditor` auswählen
12. In den `VM Options` die Parameter `-Xmx2G -ea` eingeben
13. Das Working Directory auf das `\war` Verzeichnis des Repositorys setzen
14. Das Häckchen bei `with JavaScript debugger` setzen und die Konfiguration mit `OK` speichern

#### Abschluss

15. Im Repository Verzeichnis einen neuen Ordner `symbolImages` anlegen
15. In das Verzeichnis `setup` des Repositorys wechseln und den Inhalt der Datei `ISWA2010_PNGs_4x.zip` in den neu
    erstellten Ordner `symbolImages` entpacken
16. Jetzt in den Ordner `config\local` des Repositorys wechseln und alle Dateien (ohne Unterordner) in das `\config`
    Verzeichnis kopieren
17. Unter `\config` die Datei `ESConfig.properties` öffnen und im oberen Bereich die Angaben für die lokale Datenbank
    machen
18. Zurück zu IntelliJ wechseln und die Anwendung über `Alt`+`F5` oder den Play Button in der Menüleiste starten

</details>

### Datenbank

#### Docker-Variante

Der einfachste Weg die Datenbank lokal zum Laufen zu bekommen ist über docker bzw. docker-compose. Ist docker-compose
installiert, so wird über den Befehl `docker-compose up -d` eine lauffähige Datenbank gestartet. Alle systemrelevanten
Daten sind dort bereits vorinitialisiert.

#### Native Variante

Soll die Datenbank nativ eingerichtet werden, so muss erstmal ein entsprechender
Server ([z.B. MariaDB 10.1.41](https://mariadb.org/download/?tab=mariadb&prod=mariadb&rel=10.1.41&old=true&os=windows&cpu=x86_64&pkg=msi))
installiert werden. Anschließend müssen nur noch die Skripte aus `infrastructur/mariadb/` ausgeführt werden.

### DelegsVideoSupplier

Um den `DelegsVideoSupplier` lokal Starten zu können, sind folgende Schritte notwendig:  

1. `mvn clean package`
2. `docker build -t <Name des Docker Containers> .`
3. `docker run -i -t --rm -p <Port auf dem Host>:<Port des Containers> -v <Pfad zum Host Upload Verzeichnis>:<Pfad zum Container Upload Verzeichnis> <Name des Docker Containers>`

Der Pfad zum Upload Verzeichnis (`video.upload.dir`) muss mit dem gleichnamigen Pfad des delegseditors übereinstimmen.


### Konfiguration

Zur Konfiguration der Anwendung werden ESF-Properties verwendet. 
In den Unterordnern von `config/` liegen verschiedene Konfigurationen vor (`local`, `ci` und `prod`).
Die aktuelle Konfiguration liegt immer unter `config/ESFConfig.properties`.

Um alle Tests in einer CI-Pipeline laufen zu lassen, kann das Target `ci-test` verwendet werden.  
Soll zusätzlich auch ein deploybares Artefakt erstellt werden, kann das Target `ci-prod-test-build` verwendet werden.  
Um lokal alle Tests laufen zu lassen, kann entweder `local-run-junit-only` oder `local-run-all-tests` verwendet werden.  

Diese Konfigurationen enthalten alle folgende Einstellungen:

| Property | Erklärung | Beispiel |
|---|---|---|
| esf.operating.system | Gibt das Betriebssystem an, auf dem die Software läuft. (*Windows* / *Linux*) | Linux |
| esf.session.expiryTimeMillis | Gibt an, wie lange eine Session gültig ist und sich danach erneut eingeloggt werden muss. | 28800000 |
| esf.db.url | URL, über welche die Datenbank erreichbar ist | jdbc:mysql://localhost/signbase |
| esf.db.schemaName | Name des Datenbank-Schemas | signbase |
| esf.db.username | Nutzername des Datenbank-Users | foo |
| esf.db.password | Passwort des Datenbank-Users | bar |
| esf.db.driver | Datenbank-Treiber, der verwendet werden soll | com.mysql.jdbc.Driver |
| esf.db.importTime | Stunde des Tages, zu der Daten von SignPuddle importiert werden sollen | 2 |
| esf.startup.importSignpuddle | Gibt an, ob beim Start des Server direkt von SignPuddle importiert werden soll. (* true* / *false*) | false |
| esf.smtp.hostname | Hostname des E-Mail Providers | smtp.sampleHost.de |
| esf.smtp.port | SMTP-Port des E-Mail Providers | 465 |
| esf.smtp.accountname | Name des Accounts beim E-Mail Provider | smtp@meineTolleDomain.de |
| esf.smtp.password | Passwort des Accounts beim E-Mail Provider | crazyHorseStableBattery |
| esf.email.info | E-Mail Absender von Systemnachrichten | info@meineTolleDomain.de |
| esf.mail.team | E-Mail-Verteiler des Teams, welcher z.B. bei gemeldeten Inhalten benachrichtigt werden soll | team@meineTolleDomain.de |
| esf.app.type | URL, unter welcher die Anwendung läuft | https://apps.delegs.de/delegseditor |
| esf.war.path | Pfad zur war-Datei | `./` |
| esf.app.path | Subpfad, unter dem die App später deployt ist | `signwritingeditor/` |
| esf.image.api | SubPfad, über den die Bilder der Gebärdenverschriftlichungen abgefragt werden sollen | `signwritingeditor/signimages?` |
| esf.pdf.path | Pfad zum Dateisystemordner, in welchem generierte PDFs gespeichert werden sollen | `../pdf` |
| esf.pdf.url | SubPfad, über den generierte PDFs abgefragt werden sollen | `signwritingeditor/pdf?filename=` |
| esf.lehrmaterialien.path | Pfad zu den PDF-["Lehrmaterialien"](https://delegs.de/lehrmaterialien/) , damit diese auch im Editor angezeigt werden können | `../lehrmaterialien` |
| esf.tutorial.path | Pfad zu den Hilfsvideos, welche im Editor unter Hilfe abgespielt werden können | `../hilfsvideos/` |
| esf.symbolprovider.url | Pfad zu den SymbolImages | `../symbolImages/` |
| esf.migration.url | Pfad zu den Datenbank-Migrationsskripten | `migration/` |
| esf.backgroundimage | Pfad zum Hintergrundbild des Editors | `background.jpg` |
| esf.signimagecache.url | Pfad zum signImageCache-Ordner, wo generierte Verschriftlichungen zwischengespeichert werden | `../signImageCache/` |
| esf.video.lib.dir | Pfad zum Ordner mit ffmpeg für die Videokonvertierung | `../video-lib` |
| esf.video.upload.dir | Ordner, in welchen hochgeladene Videos gespeichert werden sollen | `../upladed-videos` |
| esf.video.cache.dir | Ordner, in dem die gecachten und komprimierten Videos gespeichert werden | `../video-cache` |
| esf.mediaservlet.url | URL zum DelegsVideoSupplier-Endpunkt, welcher hochgeladene Videos speichert und bereitstellt | https://apps.delegs.de/delegseditormedia/DelegsVideoSupplierServlet |

## Server Setup

### Voraussetzung

1. Laufende Datenbank
2. Java 8 installiert
3. Tomcat installiert
4. Alle in der Konfigurationsdatei hinterlegten Ordner wurden angelegt

### Deployment

#### Delegs

1. Das Artefakt (`delegseditor.war`) mit der richten Konfiguration bauen, z.B. über `prod-prod-build`
2. Das Artefakt auf den Server hochladen
3. Das Artefakt in den `webapps`-Ordner von Tomcat verschieben
4. Wenn Tomcat noch nicht läuft, muss Tomcat nun gestartet werden
5. Tomcat sollte das Artefakt nun automatisch entpacken und die Anwendung deployen
6. Dieser Prozess kann einen Moment dauern

#### DelegsVideoSupplier

1. Das Artefakt (`DelegsVideoSupplier.war`) bauen
2. Weiteres Vorgehen wie beim [delegs](#delegs) Deployment

#### Sonstige

Alle anderen im Projekt befindlichen Anwendungen können auf die gleiche Art und Weise wie der DelegsVideoSupplier deployt werden.

### Regelmäßige Backups

Wir empfehlen in regelmäßigen Abständen Backups von der Datenbank und den Videos aus dem Ordner aus `esf.video.upload.dir` zu machen (z.B. über [rsync](https://www.man7.org/linux/man-pages/man1/rsync.1.html)).
Alle anderen Ordner beinhalten entweder statische Ressourcen oder Caches, welche jederzeit neu generiert werden können. 