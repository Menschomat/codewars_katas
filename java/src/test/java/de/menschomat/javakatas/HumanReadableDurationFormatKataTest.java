package de.menschomat.javakatas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanReadableDurationFormatKataTest {
    @Test
    public void exampleTests() {
        assertEquals("1 second", HumanReadableDurationFormatKata.formatDuration(1));
        assertEquals("1 minute and 2 seconds", HumanReadableDurationFormatKata.formatDuration(62));
        assertEquals("2 minutes", HumanReadableDurationFormatKata.formatDuration(120));
        assertEquals("1 hour", HumanReadableDurationFormatKata.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", HumanReadableDurationFormatKata.formatDuration(3662));
    }

}