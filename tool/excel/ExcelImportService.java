package excel;

import de.signWritingEditor.server.service.ConfigurationService;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

public class ExcelImportService {

    private final ExcelImportReader excelImportReader = new ExcelImportReader();
    private final ExcelImportConverter excelImportConverter = new ExcelImportConverter();
    private final ExcelImportDataProvider excelImportDataProvider;
    private final ExcelImportValidator excelImportValidator;
    private final ExcelImportProcessor excelImportProcessor;

    public ExcelImportService(ConfigurationService configurationService) throws IOException {
        excelImportDataProvider = new ExcelImportDataProvider(configurationService);
        excelImportValidator = new ExcelImportValidator(configurationService, excelImportDataProvider);
        excelImportProcessor = new ExcelImportProcessor(excelImportDataProvider);

    }

    public void runImport(File excelFile) {

        try (FileInputStream stream = new FileInputStream(excelFile)) {

            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet worksheet = workbook.getSheetAt(0);
            String[][] readResult = excelImportReader.readRows(worksheet);

            Map<String, Integer> columnPositionsMap = excelImportReader.readColumnHeaders(worksheet);
            boolean requiredColumnsPresent = excelImportValidator.validateRequiredColumns(columnPositionsMap);

            if (requiredColumnsPresent) {
                List<ExcelImportDocument> excelImportDocuments = excelImportConverter.readResultToImportDocuments(readResult, columnPositionsMap);
                excelImportValidator.validateImports(excelImportDocuments);
                excelImportProcessor.processImports(excelImportDocuments);
            }

        } catch (Exception e) {
            ExcelImportLogger.logError(e.getMessage());
        }

        ExcelImportTimer.setTimeStamp(ExcelImportTimerState.IMPORT);
        String importDurationString = ExcelImportTimer.getDurationString(ExcelImportTimerState.COPY, ExcelImportTimerState.IMPORT);
        String importDurationMessage = String.format("Import der Lexikoneinträge abgeschlossen. %s", importDurationString);
        ExcelImportLogger.logInfo(importDurationMessage);
    }
}
