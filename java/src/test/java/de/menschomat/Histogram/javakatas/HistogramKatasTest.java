package de.menschomat.Histogram.javakatas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistogramKatasTest {

    @Test
    void renderH1() {
        final String expected =
                "6|##### 5\n" +
                        "5|\n" +
                        "4|# 1\n" +
                        "3|########## 10\n" +
                        "2|### 3\n" +
                        "1|####### 7\n";
        assertEquals(expected, HistogramKatas.renderH1(new int[]{7, 3, 10, 1, 0, 5}));
    }

    @Test
    void renderH2() {
        final String expected =
                "6|██ 5%\n" +
                        "5|\n" +
                        "4|███████ 15%\n" +
                        "3|███████████████████████████████████ 70%\n" +
                        "2|█ 3%\n" +
                        "1|███ 7%\n";
        assertEquals(expected, HistogramKatas.renderH2(new int[]{7, 3, 70, 15, 0, 5}));
    }

    @Test
    void renderV1() {
        final String expected =
                "    10\n" +
                        "    #\n" +
                        "    #\n" +
                        "7   #\n" +
                        "#   #\n" +
                        "#   #     5\n" +
                        "#   #     #\n" +
                        "# 3 #     #\n" +
                        "# # #     #\n" +
                        "# # # 1   #\n" +
                        "# # # #   #\n" +
                        "-----------\n" +
                        "1 2 3 4 5 6\n";
        assertEquals(expected, HistogramKatas.renderV1(new int[]{7, 3, 10, 1, 0, 5}));
    }

    @Test
    void renderV2() {
        final String expected =
                "      70%\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██ 15%\n" +
                        "7%    ██ ██\n" +
                        "██ 3% ██ ██    5%\n" +
                        "------------------\n" +
                        " 1  2  3  4  5  6\n";
        int results[] = new int[]{14, 6, 140, 30, 0, 10};
        String hist = HistogramKatas.renderV2(results);
        assertEquals(expected, hist);
    }

    @Test
    void renderV2_2() {
        final String expected2 =
                "      100%\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "      ██\n" +
                        "------------------\n" +
                        " 1  2  3  4  5  6\n";
        int results2[] = new int[]{0, 0, 1, 0, 0, 0};
        String hist2 = HistogramKatas.renderV2(results2);
        assertEquals(expected2, hist2);
    }

    @Test
    void renderV2_3() {
        final String expected2 =
                "   33%   33%   33%\n" +
                        "   ██    ██    ██\n" +
                        "   ██    ██    ██\n" +
                        "   ██    ██    ██\n" +
                        "   ██    ██    ██\n" +
                        "   ██    ██    ██\n" +
                        "------------------\n" +
                        " 1  2  3  4  5  6\n";
        int results2[] = new int[]{0, 2, 0, 2, 0, 2};
        String hist2 = HistogramKatas.renderV2(results2);
        assertEquals(expected2, hist2);
    }

    @Test
    void renderV2_4() {
        final String expected2 =
                "------------------\n" +
                        " 1  2  3  4  5  6\n";
        int results2[] = new int[]{0, 0, 0, 0, 0, 0};
        String hist2 = HistogramKatas.renderV2(results2);
        assertEquals(expected2, hist2);
    }

    @Test
    void renderV2_5() {
        final String expected2 =
                "               20%\n" +
                        "15%18%   19%18%██\n" +
                        "██ ██ 9% ██ ██ ██\n" +
                        "██ ██ ██ ██ ██ ██\n" +
                        "------------------\n" +
                        " 1  2  3  4  5  6\n";
        int results2[] = new int[]{30, 36, 18, 38, 37, 40};
        String hist2 = HistogramKatas.renderV2(results2);
        assertEquals(expected2, hist2);
    }

    @Test
    void calcHeights() {
        assertArrayEquals(new int[]{3, 1, 35, 7, 0, 2}, HistogramKatas.calcHeights(new double[]{7, 3, 70, 15, 0, 5}, 50));
        assertArrayEquals(new int[]{0, 0, 15, 0, 0, 0}, HistogramKatas.calcHeights(new double[]{0, 0, 100, 0, 0, 0}, 15));
    }


}