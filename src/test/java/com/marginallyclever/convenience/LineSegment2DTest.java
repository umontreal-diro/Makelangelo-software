package com.marginallyclever.convenience;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;

public class LineSegment2DTest {
    @Test
    public void testFlip() {
        Point2D start = new Point2D(1.0, 2.0);
        Point2D end = new Point2D(4.0, 6.0);
        LineSegment2D segment = new LineSegment2D(start, end, Color.RED);

        segment.flip();

        assertEquals(start, segment.end);
        assertEquals(end, segment.start);
    }

}
