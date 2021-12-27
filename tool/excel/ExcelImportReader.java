package excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.util.Map;
import java.util.TreeMap;

public class ExcelImportReader {

    public Map<String, Integer> readColumnHeaders(XSSFSheet worksheet) {
        XSSFRow row = worksheet.getRow(0);
        int cellCount = row.getPhysicalNumberOfCells();

        Map<String, Integer> columnPositionsMap = new TreeMap<>();

        for (int i = 0; i <= cellCount; i++) {
            String headerValue = readCellValue(row, i);
            if(headerValue.length() > 0)
                columnPositionsMap.put(headerValue, i);
        }

        return columnPositionsMap;
    }

    /**
     * Liefert den Inhalt aller Zeilen des Worksheets
     * @param worksheet Das Worksheet, dessen Inhalt ausgelesen werden soll
     * @return den ausgelesenen Inhalt als zweidimensionales Array
     */
    public String[][] readRows(XSSFSheet worksheet) {

        XSSFRow firstRow = worksheet.getRow(0);
        int rowCount = worksheet.getPhysicalNumberOfRows();
        int columnCount = firstRow.getLastCellNum();

        String[][] readResult = new String[rowCount - 1][columnCount];

        try {
            for (int rowIndex = 1; rowIndex <= rowCount - 1; rowIndex++) {
                XSSFRow row = worksheet.getRow(rowIndex);

                if(row == null) {
                    String errorText = String.format("Zeile %d ist ungültig", rowIndex);
                    ExcelImportLogger.logError(errorText);
                    return null;
                }
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++){
                    String cellValue = readCellValue(row, columnIndex);
                    readResult[rowIndex - 1][columnIndex] = cellValue;
                }
            }
        }
        catch (Exception e)  {
            String errorText = String.format("Fehler beim Auslesen der Excel Datei. %s", e.getMessage());
            ExcelImportLogger.logError(errorText);
            return null;
        }

        return readResult;
    }

    /**
     * Liefert den Inhalt einer Zelle
     * @param row Die Zeile, in der sich die Zelle befindet
     * @param cellNumber die Position der Zelle in der Zeile
     * @return der Inhalt der Zelle als String
     */
    public String readCellValue(XSSFRow row, int cellNumber) {
        assert row != null : "Precondition failed: row != null";
        assert cellNumber >= 0 : "Precondition failed: cellNumber >= 0";

        XSSFCell cell = row.getCell(cellNumber);
        if (cell != null) {
            CellType cellType = cell.getCellTypeEnum();

            if (cellType == CellType.NUMERIC)
                return readNumericValue(cell);
            if (cellType == CellType.STRING)
                return readStringValue(cell);
        }

        return "";
    }

    private String readNumericValue(XSSFCell cell) {
        int cellValue = (int) cell.getNumericCellValue();
        return String.format("%d",cellValue);
    }

    private String readStringValue(XSSFCell cell) {

        StringBuilder resultStringBuilder = new StringBuilder();
        XSSFRichTextString richTextString = cell.getRichStringCellValue();
        String richTextStringValue = richTextString.toString();
        resultStringBuilder.append(richTextStringValue);

        XSSFCellStyle cellStyle = cell.getCellStyle();
        XSSFFont font = cellStyle.getFont();
        int formattingRuns = richTextString.numFormattingRuns();

        for (int i = 0; i < formattingRuns; i ++) {

            XSSFFont currentFont = richTextString.getFontOfFormattingRun(i);
            if(currentFont != null)
                font = currentFont;

            short fontTypeOffset = font.getTypeOffset();

            int formattingRunIndex = richTextString.getIndexOfFormattingRun(i);
            String formattedRunPrefix = richTextStringValue.substring(formattingRunIndex, formattingRunIndex + 1);

            if(fontTypeOffset == XSSFFont.SS_SUPER)
                formattedRunPrefix = String.format("_hoch_%s", formattedRunPrefix);
            if(fontTypeOffset == XSSFFont.SS_SUB)
                formattedRunPrefix = String.format("_unten_%s", formattedRunPrefix);

            resultStringBuilder.replace(formattingRunIndex, formattingRunIndex + 1, formattedRunPrefix);
        }

        String string = resultStringBuilder.toString();
        return string.trim();
    }
}
