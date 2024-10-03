package com.marginallyclever.makelangelo.plotter.plottercontrols;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CartesianButtonsTest {

    /**
     * Method under test: {@link CartesianButtons#isCenterZone(int)}
     */
    @Test
    void testIsCenterZone() {
        // Arrange, Act and Assert
        assertFalse(CartesianButtons.isCenterZone(1));
        assertTrue(CartesianButtons.isCenterZone(CartesianButtons.ZONE_CENTER));
    }

    /**
     * Method under test: {@link CartesianButtons#getQuadrant(int)}
     */
    @Test
    void testGetQuadrant() {
        // Arrange, Act and Assert
        assertEquals(0, CartesianButtons.getQuadrant(1));
    }

    /**
     * Method under test: {@link CartesianButtons#getZone(int)}
     */
    @Test
    void testGetZone() {
        // Arrange, Act and Assert
        assertEquals(1, CartesianButtons.getZone(1));
        assertEquals(-1, CartesianButtons.getZone(CartesianButtons.ZONE_CENTER));
    }




}
