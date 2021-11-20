package de.menschomat.javakatas;
//https://www.codewars.com/kata/52742f58faf5485cae000b9a/java
public abstract class HumanReadableDurationFormatKata {
    public enum TimeUnit {
        SECOND(1, "second", "seconds"),
        MINUTE(60, "minute", "minutes"),
        HOUR(TimeUnit.MINUTE.value * 60, "hour", "hours"),
        DAY(TimeUnit.HOUR.value * 24, "day", "days"),
        YEAR(TimeUnit.DAY.value * 365, "year", "years");

        public final int value;
        public final String singular;
        public final String plural;

        TimeUnit(int value, String singular, String plural) {
            this.value = value;
            this.singular = singular;
            this.plural = plural;
        }
    }

    public static String formatDuration(int seconds) {
        StringBuilder out = new StringBuilder();
        if (seconds == 0)
            return "now";
        else
            doUnitCheck(seconds, out, TimeUnit.class.getEnumConstants().length - 1);
        return out.toString();
    }

    private static void doUnitCheck(int seconds, StringBuilder out, int i) {
        TimeUnit unit = TimeUnit.class.getEnumConstants()[i];
        if (seconds >= unit.value) {
            int minutes = (int) Math.floor(seconds / unit.value);
            seconds = seconds % unit.value;
            append(out, minutes + (minutes > 1 ? " " + unit.plural : " " + unit.singular), seconds == 0);
        }
        if (i > 0)
            doUnitCheck(seconds, out, --i);
    }

    private static void append(StringBuilder target, String toAdd, boolean isLast) {
        if (isLast) {
            target.append(target.length() == 0 ? "" : " and ");
        } else {
            target.append(target.length() == 0 ? "" : ", ");
        }
        target.append(toAdd);
    }
}
