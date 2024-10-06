package com.marginallyclever.makelangelo.plotter;

import com.marginallyclever.convenience.Point2D;
import com.marginallyclever.makelangelo.turtle.MovementType;
import com.marginallyclever.makelangelo.turtle.TurtleMove;
import com.marginallyclever.util.PreferencesHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotterTest {

    Plotter plotter;

    @BeforeEach
    void setUp() {
        PreferencesHelper.start();
        plotter = new Plotter();
    }

    @Test
    void turtleTravel() {
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.TRAVEL);
        TurtleMove m1 = new TurtleMove(0.0, 0.0, MovementType.TRAVEL);

        plotter.findHome();
        plotter.turtleMove(m0);
        plotter.turtleMove(m1);

        Point2D expectedPosition = new Point2D(0.0, 0.0);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertTrue(plotter.getPenIsUp());
    }

    @Test
    void turtleMove() {
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.DRAW_LINE);
        TurtleMove m1 = new TurtleMove(0.0, 0.0, MovementType.DRAW_LINE);

        plotter.findHome();
        plotter.turtleMove(m0);
        plotter.turtleMove(m1);

        Point2D expectedPosition = new Point2D(0.0, 0.0);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertFalse(plotter.getPenIsUp());
    }

    @Test
    void turtleFindHome(){
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.DRAW_LINE);

        plotter.turtleMove(m0);

        Assertions.assertFalse(plotter.getDidFindHome());

        plotter.findHome();

        Point2D expectedPosition = new Point2D(0.0, 0.0);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertTrue(plotter.getPenIsUp());
        Assertions.assertTrue(plotter.getDidFindHome());
    }

    @Test
    void turtleComplexCommandSequence(){
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.TRAVEL);
        TurtleMove m1 = new TurtleMove(-10.0, -10.0, MovementType.DRAW_LINE);
        TurtleMove m2 = new TurtleMove(12.3, 32.1, MovementType.TRAVEL);

        plotter.findHome();
        plotter.turtleMove(m0);
        plotter.turtleMove(m1);
        plotter.turtleMove(m2);

        Point2D expectedPosition = new Point2D(12.3, 32.1);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertTrue(plotter.getPenIsUp());
    }

    @Test
    void turtleToolChange(){
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.TOOL_CHANGE);

        plotter.findHome();
        plotter.turtleMove(m0);

        Point2D expectedPosition = new Point2D(0.0, 0.0);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertTrue(plotter.getPenIsUp());
    }
}