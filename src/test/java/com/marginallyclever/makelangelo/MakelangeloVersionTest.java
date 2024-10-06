package com.marginallyclever.makelangelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MakelangeloVersionTest {
    private static final Logger logger = LoggerFactory.getLogger(MakelangeloVersionTest.class);

    @Test
    public void testGetFullVersionString() {
        String fullVersion = MakelangeloVersion.getFullVersionString();
        logger.debug("Full version: {}", fullVersion);
        Assertions.assertTrue(fullVersion.contains(MakelangeloVersion.VERSION), "Full version should contain the basic version.");
        Assertions.assertTrue(fullVersion.contains(MakelangeloVersion.DETAILED_VERSION), "Full version should contain the detailed version.");
    }

    @Test
    public void testGetLiteVersionString() {
        String liteVersion = MakelangeloVersion.getLiteVersionString();
        logger.debug("Lite version: {}", liteVersion);
        Assertions.assertTrue(liteVersion.contains(MakelangeloVersion.VERSION), "Lite version should contain the basic version.");
    }

    @Test
    public void testGetFullOrLiteVersionStringRelativeToSysEnvDevValue() {
        String originalDevValue = System.getenv("DEV");

        try {
            // Test with DEV set to true
            setEnv("DEV", "true");
            String version = MakelangeloVersion.getFullOrLiteVersionStringRelativeToSysEnvDevValue();
            Assertions.assertTrue(version.contains(MakelangeloVersion.DETAILED_VERSION), "Should return full version when DEV is true.");

            // Test with DEV set to false
            setEnv("DEV", "false");
            version = MakelangeloVersion.getFullOrLiteVersionStringRelativeToSysEnvDevValue();
            Assertions.assertFalse(version.contains(MakelangeloVersion.DETAILED_VERSION), "Should return lite version when DEV is false.");
        } finally {
            // Restore original DEV value
            setEnv("DEV", originalDevValue);
        }
    }

    // Helper method to set environment variables for testing
    private void setEnv(String key, String value) {
        try {
            java.util.Map<String, String> env = System.getenv();
            java.lang.reflect.Field field = env.getClass().getDeclaredField("m");
            field.setAccessible(true);
            java.util.Map<String, String> writableEnv = (java.util.Map<String, String>) field.get(env);
            if (value == null) {
                writableEnv.remove(key);
            } else {
                writableEnv.put(key, value);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to set environment variable", e);
        }
    }
}