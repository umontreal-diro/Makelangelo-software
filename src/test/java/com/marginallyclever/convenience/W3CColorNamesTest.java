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
        Color color = W3CColorNames.get("blue");
        assertNotNull(color);
        assertEquals(new Color(0x00, 0x00, 0xFF), color);
    }

    /**
     * Tests that the get method returns null for an unknown color name.
     */
    @Test
    public void testGetUnknownColorName() {
        Color color = W3CColorNames.get("unknowncolor");
        assertNull(color);
    }

    /**
     * Tests that the get method returns the correct color name for a known Color object.
     */
    @Test
    public void testGetKnownColorObject() {
        String colorName = W3CColorNames.get(new Color(0x00, 0x00, 0xFF));
        assertNotNull(colorName);
        assertEquals("blue", colorName);
    }

    /**
     * Tests that the get method returns null for an unknown Color object.
     */
    @Test
    public void testGetUnknownColorObject() {
        String colorName = W3CColorNames.get(new Color(0x12, 0x34, 0x56));
        assertNull(colorName);
    }
}
