package com.marginallyclever.makelangelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MakelangeloVersionTest {
    @Test
    public void testGetFullOrLiteVersionStringRelativeToSysEnvDevValue() {
        try (MockedStatic<System> mockedSystem = Mockito.mockStatic(System.class)) {
            // Mock DEV set to true
            mockedSystem.when(() -> System.getenv("DEV")).thenReturn("true");
            String version = MakelangeloVersion.getFullOrLiteVersionStringRelativeToSysEnvDevValue();
            Assertions.assertTrue(version.contains(MakelangeloVersion.DETAILED_VERSION), "Should return full version when DEV is true.");

            // Mock DEV set to false
            mockedSystem.when(() -> System.getenv("DEV")).thenReturn("false");
            version = MakelangeloVersion.getFullOrLiteVersionStringRelativeToSysEnvDevValue();
            Assertions.assertFalse(version.contains(MakelangeloVersion.DETAILED_VERSION), "Should return lite version when DEV is false.");
        }
    }
}