package de.menschomat.javakatas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrambliesKataTest {
    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests scramble");
        testing(ScrambliesKata.scramble("rkqodlw","world"), true);
        testing(ScrambliesKata.scramble("cedewaraaossoqqyt","codewars"),true);
        testing(ScrambliesKata.scramble("katas","steak"),false);
        testing(ScrambliesKata.scramble("scriptjavx","javascript"),false);
        testing(ScrambliesKata.scramble("scriptingjava","javascript"),true);
        testing(ScrambliesKata.scramble("scriptsjava","javascripts"),true);
        testing(ScrambliesKata.scramble("javscripts","javascript"),false);
        testing(ScrambliesKata.scramble("aabbcamaomsccdd","commas"),true);
        testing(ScrambliesKata.scramble("commas","commas"),true);
        testing(ScrambliesKata.scramble("sammoc","commas"),true);
    }
}