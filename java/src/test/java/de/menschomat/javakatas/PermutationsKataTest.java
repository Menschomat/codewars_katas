package de.menschomat.javakatas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsKataTest {

    @Test
    public void example1() {
        assertEquals(new ArrayList<String>(Arrays.asList("a")),
                PermutationsKata.singlePermutations("a").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example2() {
        assertEquals(new ArrayList<String>(Arrays.asList("ab", "ba")),
                PermutationsKata.singlePermutations("ab").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example3() {
        assertEquals(new ArrayList<String>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                PermutationsKata.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()));
    }
}