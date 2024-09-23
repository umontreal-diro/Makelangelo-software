package com.marginallyclever.makelangelo.paper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaperSizeTest {

    @Test
    public void testPaperSizeInitialization() {

        PaperSize paper = new PaperSize("A4", 210, 297);

        assertEquals("A4", paper.name);
        assertEquals(210, paper.width);
        assertEquals(297, paper.height);
    }

    @Test
    public void testToStringMethod() {

        PaperSize paper = new PaperSize("A4", 210, 297);

        String expected = "A4 (210 x 297)";
        assertEquals(expected, paper.toString());
    }
}
