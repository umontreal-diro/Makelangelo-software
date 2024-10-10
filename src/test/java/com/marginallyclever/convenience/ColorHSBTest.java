package com.marginallyclever.convenience;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColorHSBTest {

    /* Ce test vérifie le bon fonctionnement du constructeur et S'assure que l'initialisation se fait correctement.*/
    @Test
    public void testColorHSBConstructor() {
        ColorHSB color = new ColorHSB(0.5f, 0.7f, 0.8f);

        assertEquals(0.5f, color.getHue());
        assertEquals(0.7f, color.getSaturation());
        assertEquals(0.8f, color.getBrightness());
    }

    /* Ce test vérifie la méthode set() qui permet de changer les valeurs de hue,
     * saturation, et brightness après l'initialisation.*/
    @Test
    public void testColorHSBSetMethod() {
        ColorHSB color = new ColorHSB();
        color.set(0.3f, 0.4f, 0.5f);

        assertEquals(0.3f, color.getHue());
        assertEquals(0.4f, color.getSaturation());
        assertEquals(0.5f, color.getBrightness());
    }

    /* Ce test vérifie la méthode equals(), qui compare deux objets ColorHSB.*/
    @Test
    public void testColorHSBEqualsMethod() {
        ColorHSB color1 = new ColorHSB(0.2f, 0.3f, 0.4f);
        ColorHSB color2 = new ColorHSB(0.2f, 0.3f, 0.4f);
        ColorHSB color3 = new ColorHSB(0.3f, 0.4f, 0.5f);

        assertEquals(color1, color2);
        assertNotEquals(color1, color3);
    }

    /* Ce test vérifie la méthode diff(), qui calcule la différence entre deux objets ColorHSB.*/
    @Test
    public void testColorHSBDiffMethod() {
        ColorHSB color1 = new ColorHSB(0.2f, 0.3f, 0.4f);
        ColorHSB color2 = new ColorHSB(0.3f, 0.4f, 0.5f);

        float difference = color1.diff(color2);

        assertEquals(0.17320508f, difference, 0.00001f); // Adjust delta for floating-point comparison
    }
}

