package com.marginallyclever.makelangelo.paper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaperSizeTest {

    @Test
    public void testConstructorAndGetters() {
        PaperSize paperSize = new PaperSize("A4", 210, 297);

        Assertions.assertEquals("A4", paperSize.name, "Name should be 'A4'");
        Assertions.assertEquals(210, paperSize.width, "Width should be 210");
        Assertions.assertEquals(297, paperSize.height, "Height should be 297");
    }

    @Test
    public void testToString() {
        PaperSize paperSize = new PaperSize("A4", 210, 297);
        String expectedString = "A4 (210 x 297)";

        Assertions.assertEquals(expectedString, paperSize.toString(), "toString should return 'A4 (210 x 297)'");
    }
}