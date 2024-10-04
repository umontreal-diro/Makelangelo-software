package com.marginallyclever.makelangelo.plotter.plottercontrols;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Dimension;
import java.awt.Graphics;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CartesianButtonsTest {


    /**
     * Method under test: isCenterZone(int)
     */
    @Test
    void testIsCenterZone() {
        // Arrange
        int nonCenterZone = 1;
        int centerZone = CartesianButtons.ZONE_CENTER;

        // Act & Assert
        assertFalse(CartesianButtons.isCenterZone(nonCenterZone)); // Act & Assert for non-center zone
        assertTrue(CartesianButtons.isCenterZone(centerZone)); // Act & Assert for center zone
    }

    /**
     * Method under test: getQuadrant(int)
     */
    @Test
    void testGetQuadrant() {
        // Arrange
        int point = 1;

        // Act
        int result = CartesianButtons.getQuadrant(point);

        // Assert
        assertEquals(0, result);
    }

    /**
     * Method under test: getZone(int)
     */
    @Test
    void testGetZone() {
        // Arrange
        int point = 1;
        int centerZone = CartesianButtons.ZONE_CENTER;

        // Act
        int result1 = CartesianButtons.getZone(point);
        int result2 = CartesianButtons.getZone(centerZone);

        // Assert
        assertEquals(1, result1); // Non-center zone
        assertEquals(-1, result2); // Center zone
    }
}
