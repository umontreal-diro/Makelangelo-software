package com.marginallyclever.convenience;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

public class TestColorRGB {
    private void assertColorsEqual(ColorRGB c,int r,int g,int b) {
        Assertions.assertEquals(r,c.red);
        Assertions.assertEquals(g,c.green);
        Assertions.assertEquals(b,c.blue);
    }

    @Test
    public void test() {
        assertColorsEqual(new ColorRGB(0xff123456),0x12,0x34,0x56);
    }

    @Test
    public void testWithFaker() {
        //Nous testons la classe  ColorRgb car elle gère les représentations de couleurs RGB, essentielles pour
        // le rendu graphique de l'application. Assurer la précision des opérations sur les couleurs, telles que
        // l'addition, la soustraction et la conversion en entier ou en chaîne hexadécimale, est crucial pour
        // maintenir la cohérence visuelle et éviter les erreurs de couleur qui pourraient nuire à
        // l'expérience utilisateur.
        // Arrange
        Faker faker = new Faker();
        int expectedRed = faker.number().numberBetween(0, 256);
        int expectedGreen = faker.number().numberBetween(0, 256);
        int expectedBlue = faker.number().numberBetween(0, 256);

        // Act
        ColorRGB color = new ColorRGB(expectedRed, expectedGreen, expectedBlue);

        // Assert
        assertColorsEqual(color, expectedRed, expectedGreen, expectedBlue);
    }


}
