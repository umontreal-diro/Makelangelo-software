package com.marginallyclever.convenience;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLineInterpolator {

    private LineInterpolator line;
    private Point2D start;
    private Point2D end;

    @BeforeEach
    public void setUp() {
        start = new Point2D(0, 0);
        end = new Point2D(10, 10);
        line = new LineInterpolator(start, end);
    }


    @Test
    public void testSetStart() {
        Point2D newStart = new Point2D(2, 2);
        line.setStart(newStart);
        assertEquals(newStart, line.getStart(), "El punto de inicio debería ser el asignado");
    }

    @Test
    public void testSetEnd() {
        Point2D newEnd = new Point2D(8, 8);
        line.setEnd(newEnd);
        assertEquals(newEnd, line.getEnd(), "El punto final debería ser el asignado");
    }

}

