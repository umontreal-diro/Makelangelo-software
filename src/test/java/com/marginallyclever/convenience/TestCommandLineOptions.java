package com.marginallyclever.convenience;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCommandLineOptions {

    @Test
    void testCommandLineOptions() {
        String[] testArgs = {"-test", "--help", "input.txt"};
        CommandLineOptions.setFromMain(testArgs);
        assertTrue(CommandLineOptions.hasOption("-test"));
        assertFalse(CommandLineOptions.hasOption("-verbose"));
    }
}