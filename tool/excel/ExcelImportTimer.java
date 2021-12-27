package excel;

import java.util.SortedMap;
import java.util.TreeMap;

public class ExcelImportTimer {

    private static final SortedMap<ExcelImportTimerState, Long> timestamps = new TreeMap<>();

    public static void setTimeStamp(ExcelImportTimerState state) {
        long currentTime = System.nanoTime();
        timestamps.put(state, currentTime);
    }

    public static String getDurationString(ExcelImportTimerState state) {
        if(!timestamps.containsKey(state))
            return getDurationString(0);

        long duration = timestamps.get(state);
        return getDurationString(duration);
    }

    public static String getDurationString(ExcelImportTimerState state1, ExcelImportTimerState state2) {
        if(!timestamps.containsKey(state1) || !timestamps.containsKey(state2))
            return getDurationString(0);

        long duration1 = timestamps.get(state1);
        long duration2 = timestamps.get(state2);
        long duration = ((duration2 - duration1));
        return getDurationString(duration);
    }

    private static String getDurationString(long duration) {
        long durationInMilliseconds = (duration / 1000000);
        long milliseconds = durationInMilliseconds % 1000;
        long seconds = (durationInMilliseconds / 1000) % 60;
        long minutes = (durationInMilliseconds / (1000 * 60)) % 60;

        String durationString = String.format("Dauer: %02d Minuten %02d Sekunden", minutes, seconds);

        if (minutes == 0 && seconds > 0)
            durationString = String.format("Dauer: %02d Sekunden", seconds);
        if (minutes == 0 && seconds == 0)
            durationString = String.format("Dauer: %02d Millisekunden", milliseconds);

        return durationString;
    }
}


