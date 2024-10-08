package com.marginallyclever.convenience;

import com.marginallyclever.convenience.helpers.StringHelper;
import org.junit.jupiter.api.Assertions;

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

 @Test
    public void testGetElapsedTime() {
        //Raison : Nous testons la classe TestStringHelper car elle fournit des fonctions utilitaires
        // essentielles pour la manipulation des chaînes de caractères dans l'application. Garantir le bon
        // fonctionnement de ces méthodes assure une gestion correcte des formats de données textuelles, ce qui est
        // important pour l'affichage, le traitement des entrées utilisateurs, et l'intégrité des données textuelles
        // manipulées par le programme.
        // Test case 1: Vérifie que 3661 secondes se convertissent en "01:01:01"
        // Arrange
        int seconds = 3661;
        String expected = "01:01:01";

        // Act
        String result = StringHelper.getElapsedTime(seconds);

        // Assert
        Assertions.assertEquals(expected, result);

        // Test case 2: Vérifie que 0 seconde se convertit en "00:00:00"
        // Arrange
        seconds = 0;
        expected = "00:00:00";


        // Act
        result = StringHelper.getElapsedTime(seconds);

        // Assert
        Assertions.assertEquals(expected, result);


    }
}
