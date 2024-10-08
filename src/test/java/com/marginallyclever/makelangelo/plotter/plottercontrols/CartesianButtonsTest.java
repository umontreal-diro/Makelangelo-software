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
     * Test unitaire qui vérifie la méthode isCenterZone(int).
     * On teste avec deux valeurs : une pour une zone qui n'est pas le centre et une pour la zone centrale.
     * On s'assure que la méthode retourne false pour une zone non-centrale et true pour la zone centrale.
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
     * Test unitaire qui vérifie la méthode getQuadrant(int).
     * On passe un point en paramètre et on vérifie que la méthode retourne 0, indiquant
     * que le point est dans le premier quadrant ou qu'il n'y a pas de quadrant défini.
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
     * Test unitaire qui vérifie la méthode getZone(int).
     * On teste avec deux valeurs : un point dans une zone non-centrale, et un point dans la zone centrale.
     * La méthode doit retourner 1 pour une zone non-centrale et -1 pour la zone centrale.
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
