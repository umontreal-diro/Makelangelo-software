package com.marginallyclever.convenience;

import org.junit.jupiter.api.Test;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the W3CColorNames class. Note: Some of those tests are not necessary because they are already covered by the general test of the makeangelo project.
 * (See src/test/java/com/marginallyclever/makelangelo/MakelangeloTest.java and other test classes in the same directory)
 * Mainly we are testing the get method with a string parameter.
 */
public class W3CColorNamesTest {

    /**
     * Tests that the get method returns the correct Color object for a known color name.
     */
    @Test
    public void testGetKnownColorName() {
        // Arrange
        String colorName = "blue";

        // Act
        Color color = W3CColorNames.get(colorName);

        // Assert
        assertNotNull(color);
        assertEquals(new Color(0x00, 0x00, 0xFF), color);
    }

    /**
     * Tests that the get method returns null for an unknown color name.
     */
    @Test
    public void testGetUnknownColorName() {
        // Arrange
        String colorName = "unknowncolor";

        // Act
        Color color = W3CColorNames.get(colorName);

        // Assert
        assertNull(color);
    }

    /**
     * Tests that the get method returns the correct color name for a known Color object.
     */
    @Test
    public void testGetKnownColorObject() {
        // Arrange
        Color color = new Color(0x00, 0x00, 0xFF);

        // Act
        String colorName = W3CColorNames.get(color);

        // Assert
        assertNotNull(colorName);
        assertEquals("blue", colorName);
    }

    /**
     * Tests that the get method returns null for an unknown Color object.
     */
    @Test
    public void testGetUnknownColorObject() {
        // Arrange
        Color color = new Color(0x12, 0x34, 0x56);

        // Act
        String colorName = W3CColorNames.get(color);

        // Assert
        assertNull(colorName);
    }
}