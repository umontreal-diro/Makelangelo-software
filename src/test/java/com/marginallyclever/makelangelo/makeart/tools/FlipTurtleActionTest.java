package com.marginallyclever.makelangelo.makeart.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.marginallyclever.makelangelo.turtle.Turtle;

import java.awt.Color;
import java.awt.color.ColorSpace;

import org.junit.jupiter.api.Test;

class FlipTurtleActionTest {
    /**
     * Method under test:
     * {@link FlipTurtleAction#FlipTurtleAction(double, double, String)}
     */
    @Test
    void testNewFlipTurtleAction() {
        // Arrange and Act
        FlipTurtleAction actualFlipTurtleAction = new FlipTurtleAction(2.0d, 3.0d, "Name");

        // Assert
        Object[] keys = actualFlipTurtleAction.getKeys();
        assertEquals("Name", keys[0]);
        assertEquals(0, actualFlipTurtleAction.getPropertyChangeListeners().length);
        assertEquals(1, keys.length);
        assertTrue(actualFlipTurtleAction.isEnabled());
    }

    /**
     * Method under test: {@link FlipTurtleAction#run(Turtle)}
     */
    @Test
    void testRun() {
        // Arrange
        FlipTurtleAction flipTurtleAction = new FlipTurtleAction(2.0d, 3.0d, "Name");

        // Act and Assert
        Color firstColor = flipTurtleAction.run(new Turtle()).getFirstColor();
        ColorSpace expectedColorSpace = firstColor.getColorSpace();
        assertSame(expectedColorSpace, firstColor.darker().getColorSpace());
    }
}
