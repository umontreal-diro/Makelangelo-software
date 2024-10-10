package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectIntegerTest {
    private static final Logger logger = LoggerFactory.getLogger(SelectIntegerTest.class);

    @Test
    public void testInitialValue() {
        /*
        Motivations: Ici on test l'initialisation de 'SelectInteger', particulièrement du paramètre
        'defaultValue'. On veut vérifier qu'il n'y a pas d'erreur qu'on entre 0 ou un entier positif
        quelconque.
         */
        // Arrange and Act
        SelectInteger selectInteger = new SelectInteger("testInteger", "Test Label", 0);

        // Assert
        assertEquals(0, selectInteger.getValue(), "Initial value should be 0");

        // Arrange and Act
        selectInteger = new SelectInteger("testInteger", "Test Label", 10);

        // Assert
        assertEquals(10, selectInteger.getValue(), "Initial value should be 10");
    }

    @Test
    public void testSetValue() {
        /*
        Motivations: On souhaite tester le setter de l'attribut 'value' de la classe 'SelectInteger'.
         */
        // Arrange
        SelectInteger selectInteger = new SelectInteger("testInteger", "Test Label", 0);

        // Act
        selectInteger.setValue(20);

        // Assert
        assertEquals(20, selectInteger.getValue(), "Value should be 20 after setting");

        // Act
        selectInteger.setValue(-5);

        // Assert
        assertEquals(-5, selectInteger.getValue(), "Value should be -5 after setting");
    }

    @Test
    public void testEventFiring() {
        /*
        Motivations : Ce test a pour but de vérifier le bon fonctionnement des événements intéragissant
        avec l'objet 'SelectInteger'. On définit un écouteur (listener) qui réagit aux changements d'état.
        Lorsqu'on modifie l'état de l'objet en appelant la méthode 'setValue(15)', cet événement est
        déclenché et permet de valider que les valeurs anciennes et nouvelles sont correctes.
        Ainsi, on s'assure que l'état a bien changé de l'ancienne valeur (0) à la nouvelle (15), et que
        l'événement capture correctement cette transition.
         */

        // Arrange
        SelectInteger selectInteger = new SelectInteger("testInteger", "Test Label", 0);
        selectInteger.addSelectListener(event -> {

            // Assert
            assertEquals(0, event.getOldValue(), "Old value should be 0");
            assertEquals(15, event.getNewValue(), "New value should be 15");
        });

        // Act
        selectInteger.setValue(15);
    }
}
