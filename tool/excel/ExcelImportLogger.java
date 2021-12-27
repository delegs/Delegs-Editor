package excel;

public class ExcelImportLogger {

    private static StringBuilder logText = new StringBuilder();

    public static void logInfo(String infoText) {
        String infoPrefix = "[INFO]";
        String outputText = String.format("%s - %s", infoPrefix, infoText);
        addToLog(outputText);
    }

    public static void logWarning(String warningText) {
        String warningPrefix = "[WARN]";
        String outputText = String.format("%s - %s", warningPrefix, warningText);
        addToLog(outputText);
    }

    public static void logError(String errorText) {
        String errorPrefix = "[ERROR]";
        String outputText = String.format("%s - %s", errorPrefix, errorText);
        addToLog(outputText);
    }

    public static void clear() {
        logText = new StringBuilder();
    }

    public static String getLogText() {
        return logText.toString();
    }

    private static void addToLog(String outputText) {
        if (logText.length() > 0)
            logText.append("\r\n");

        logText.append(outputText);
        System.out.println(outputText);
    }
}
