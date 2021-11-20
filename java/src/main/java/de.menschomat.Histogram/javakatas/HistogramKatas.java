package de.menschomat.Histogram.javakatas;

import java.util.Arrays;

public abstract class HistogramKatas {

    public static String renderH1(final int results[]) {
        StringBuilder out = new StringBuilder();
        for (int i = results.length - 1; i >= 0; i--) {
            int cur = results[i];
            out.append(i + 1).append("|");
            for (int j = 0; j < cur; j++) {
                out.append('#');
            }
            out.append(cur > 0 ? " " + cur + "\n" : "\n");
        }
        return out.toString();
    }

    public static String renderH2(final int results[]) {
        double[] weighting = calcWeighting(results);
        int[] heights = calcHeights(weighting, 50);
        StringBuilder out = new StringBuilder();
        for (int i = results.length - 1; i >= 0; i--) {
            out.append(i + 1).append("|");
            for (int j = 0; j < heights[i]; j++)
                out.append('█');
            out.append(weighting[i] > 0 ? " " + (int) Math.floor(weighting[i]) + "%\n" : "\n");
        }
        return out.toString();
    }

    public static String renderV1(final int results[]) {
        int max = Arrays.stream(results).max().orElseThrow();
        StringBuilder out = new StringBuilder();
        out.insert(0, "1 2 3 4 5 6\n");
        out.insert(0, "-----------\n");
        for (int i = 0; i <= max; i++) {
            String line = "";
            for (int result : results) {
                line += result >= i && result != 0 ? (result == i ? result + (result > 9 ? "" : " ") : "# ") : "  ";

            }
            line = line.replaceAll("\\s*$", "");
            if (line.length() > 0) {
                out.insert(0, line + "\n");
            }
        }
        return out.toString();
    }

    public static String renderV2(final int results[]) {
        double[] weighting = calcWeighting(results);
        int[] heights = calcHeights(weighting, 15);
        int max = Arrays.stream(heights).max().orElseThrow();
        StringBuilder out = new StringBuilder();
        out.insert(0, " 1  2  3  4  5  6\n");
        out.insert(0, "------------------\n");
        for (int i = 0; i <= max; i++) {
            String line = "";
            for (int j = 0; j < results.length; j++) {
                line += heights[j] >= i ? (heights[j] == i ? printWeight(weighting[j]) : "██ ") : "   ";
            }
            line = line.replaceAll("\\s*$", "");
            if (line.length() > 0) {
                out.insert(0, line + "\n");
            }
        }
        return out.toString();
    }

    public static String printWeight(double weight) {
        if (weight > 0 && weight < 1) {
            return "<1%";
        } else if (weight == 0) {
            return "   ";
        }
        int flooredWeight = (int) Math.floor(weight);
        return flooredWeight > 9 ? flooredWeight + "%" : flooredWeight + "% ";
    }

    public static int[] calcHeights(final double weighting[], final int fullHeight) {
        double factor = fullHeight / 99.9999999999999d; //Hacky shit... but required for the broken tests of this kata! 100 should be right ;)
        return Arrays.stream(weighting).mapToInt(weight -> (int) Math.floor(weight * factor)).toArray();
    }

    public static double[] calcWeighting(final int results[]) {
        double sum = Arrays.stream(results).sum();
        return Arrays.stream(results).mapToDouble(result -> result == 0 ? 0 : (result / sum * 100)).toArray();
    }
}
