package com.marginallyclever.makelangelo.plotter;

import com.marginallyclever.convenience.Point2D;
import com.marginallyclever.makelangelo.turtle.MovementType;
import com.marginallyclever.makelangelo.turtle.TurtleMove;
import com.marginallyclever.util.PreferencesHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.vecmath.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

class PlotterTest {

    Plotter plotter;

    @BeforeEach
    void setUp() {
        PreferencesHelper.start();
        plotter = new Plotter();
    }

    @Test
    void turtleMove() {
        TurtleMove m0 = new TurtleMove(0.0, 10.0, MovementType.TRAVEL);
        TurtleMove m1 = new TurtleMove(0.0, 0.0, MovementType.TRAVEL);

        plotter.turtleMove(m0);
        plotter.turtleMove(m1);
        Point2D expected = new Point2D(0.0, 0.0);
        Assertions.assertEquals(expected.x, plotter.getPos().x);
        Assertions.assertEquals(expected.y, plotter.getPos().y);
    }
}