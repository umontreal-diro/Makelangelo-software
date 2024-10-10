package com.marginallyclever.convenience;

import com.marginallyclever.convenience.helpers.StringHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringHelper {
    @Test
    public void testPaddedHex() {
        assertEquals("000001", StringHelper.paddedHex(0x1));
        assertEquals("0007ff",StringHelper.paddedHex(0x7ff));
        assertEquals("100001",StringHelper.paddedHex(0x100001));
        assertEquals("1000001",StringHelper.paddedHex(0x1000001));
        assertEquals("100000",StringHelper.paddedHex(0x100000));
    }


    /*  Teste la méthode formatFloat pour vérifier si un float est formaté correctement
     * avec 3 décimales selon la localisation US.*/
    @Test
    public void testFormatFloat() {
        float value = 123.456789f;
        String expected = "123.457";
        String actual = StringHelper.formatFloat(value);
        assertEquals(expected, actual);
    }

    /* Teste la méthode formatDouble pour vérifier si un double est formaté correctement
     * avec 3 décimales selon la localisation US.*/
    @Test
    public void testFormatDouble() {
        double value = 123.456789;
        String expected = "123.457";
        String actual = StringHelper.formatDouble(value);
        assertEquals(expected, actual);
    }

    /* Teste la méthode padRight pour vérifier si une chaîne de caractères
     * est correctement étendue en ajoutant des espaces à droite jusqu'à une longueur spécifiée.*/
    @Test
    public void testPadRight() {
        String value = "test";
        String expected = "test    "; // assuming 4 spaces are added
        String actual = StringHelper.padRight(value, 8);
        assertEquals(expected, actual);
    }

    /* Teste la méthode getElapsedTime pour vérifier si un nombre de secondes
     * est correctement converti en une chaîne de caractères au format HH:mm:ss.*/
    @Test
    public void testGetElapsedTime() {
        int seconds = 3661; // 1 hour, 1 minute, and 1 second
        String expected = "01:01:01";
        String actual = StringHelper.getElapsedTime(seconds);
        assertEquals(expected, actual);
    }
}
