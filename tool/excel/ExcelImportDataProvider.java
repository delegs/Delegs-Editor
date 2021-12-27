package excel;

import de.signWritingEditor.server.persistence.*;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.material.SymbolFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelImportDataProvider {

    private final DocumentDb documentDb;
    private final UserDb userDb;
    private final SignDB signDb;
    private final SymbolDB symbolDB;

    public ExcelImportDataProvider(ConfigurationService configurationService) throws IOException {
        try {
            DbConnector dbConnector = new DbConnector(configurationService);
            documentDb = new DocumentDb(dbConnector);
            userDb = new UserDb(dbConnector);
            symbolDB = new SymbolDB(dbConnector);

            List<Map<String, String>> allSymbols = symbolDB.getAllSymbols();
            SymbolFactory symbolFactory = new SymbolFactory(allSymbols);
            signDb = new SignDB(dbConnector, userDb, symbolFactory, configurationService);

        } catch (IOException e) {
            String errorMessage = String.format("Fehler beim Initialisieren der Datenbank. %s", e.getMessage());
            ExcelImportLogger.logError(errorMessage);
            throw e;
        }
    }

    public DocumentDb getDocumentDb() {
        return documentDb;
    }

    public UserDb getUserDb() {
        return userDb;
    }

    public SignDB getSignDb() {
        return signDb;
    }

    public SymbolDB getSymbolDB() {
        return symbolDB;
    }
}
