package com.marginallyclever.makelangelo.paper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaperSizeTest {

    @Test
    public void testConstructorAndGetters() {
        /*
        Motivations: Ici on vérifie l'initialisation correcte de 'PaperSize' et de ses 3
        paramètres qui doivent équivaloir aux 3 attributs correspondant.
         */
        // Arrange and Act
        PaperSize paperSize = new PaperSize("A4", 210, 297);

        // Assert
        Assertions.assertEquals("A4", paperSize.name, "Name should be 'A4'");
        Assertions.assertEquals(210, paperSize.width, "Width should be 210");
        Assertions.assertEquals(297, paperSize.height, "Height should be 297");
    }

    @Test
    public void testToString() {
        /*
        Motivations: On veut tester la méthode 'toString()' de la classe 'PaperSize'.
        On s'assure que le format du string en sortie est comme attendu, donc bien lisible.
         */
        // Arrange
        PaperSize paperSize = new PaperSize("A4", 210, 297);
        String expectedString = "A4 (210 x 297)";

        // Act
        String testedString = paperSize.toString();

        // Assert
        Assertions.assertEquals(expectedString, testedString, "toString should return 'A4 (210 x 297)'");
    }
}