package com.marginallyclever.convenience;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Point2DTest {

    @Test
    public void testConstructorAndSetters() {
        Point2D p = new Point2D(3.0, 4.0);
        Point2D q = new Point2D(1.0, 2.0);


        p.set(5.0, 6.0);
        assertEquals(5.0, p.x, 0.001);
        assertEquals(6.0, p.y, 0.001);

        p.set(q);
        assertEquals(1.0, p.x, 0.001);
        assertEquals(2.0, p.y, 0.001);
    }

    @Test
    public void testScale() {
        Point2D p = new Point2D(1.0, 2.0);

        p.scale(2.0);

        assertEquals(2.0, p.x, 0.001);
        assertEquals(4.0, p.y, 0.001);
    }

    @Test
    public void testAdd() {
        Point2D p = new Point2D(1.0, 2.0);
        Point2D q = new Point2D(3.0, 4.0);

        p.add(q);

        assertEquals(4.0, p.x, 0.001);
        assertEquals(6.0, p.y, 0.001);
    }
}
