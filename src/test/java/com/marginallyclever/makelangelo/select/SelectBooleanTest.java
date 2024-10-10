package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectBooleanTest {
    private static final Logger logger = LoggerFactory.getLogger(SelectBooleanTest.class);

    @Test
    public void testInitialSelection() {
        /*
        Motivations: On veut s'assurer que le paramètre 'arg0' détermine correctement l'initialisation
        de l'objet 'SelectBoolean'. Ce paramètre est sensé déterminer comme attendu la sortie du getter
        'isSelected()'.
         */
        // Arrange and Act
        SelectBoolean selectBoolean = new SelectBoolean("testBoolean", "Test Label", false);

        // Assert
        assertFalse(selectBoolean.isSelected(), "Initial selection should be false");

        // Arrange and Act
        selectBoolean = new SelectBoolean("testBoolean", "Test Label", true);

        // Assert
        assertTrue(selectBoolean.isSelected(), "Initial selection should be true");
    }

    @Test
    public void testSetSelected() {
        /*
        Motivations: On souhaite vérifier le bon fonctionnement du setter 'setSelected'.
         */
        // Arrange
        SelectBoolean selectBoolean = new SelectBoolean("testBoolean", "Test Label", false);

        // Act
        selectBoolean.setSelected(true);

        // Assert
        assertTrue(selectBoolean.isSelected(), "Selection should be true after setting to true");

        // Act
        selectBoolean.setSelected(false);

        // Assert
        assertFalse(selectBoolean.isSelected(), "Selection should be false after setting to false");
    }

    @Test
    public void testEventFiring() {
        /*
        Motivations : Ce test a pour but de vérifier le bon fonctionnement des événements intéragissant
        avec l'objet 'SelectBoolean'. On définit un écouteur (listener) qui réagit aux changements d'état.
        Lorsqu'on modifie l'état de l'objet en appelant la méthode 'setSelected(true)', cet événement est
        déclenché et permet de valider que les valeurs anciennes et nouvelles sont correctes.
        Ainsi, on s'assure que l'état a bien changé de false à true, et que l'événement capture correctement
        cette transition.
         */
        // Arrange
        SelectBoolean selectBoolean = new SelectBoolean("testBoolean", "Test Label", false);

        selectBoolean.addSelectListener(event -> {

            // Assert
            assertFalse((Boolean) event.getOldValue(), "Old value should be false");
            assertTrue((Boolean) event.getNewValue(), "New value should be true");
        });

        // Act
        selectBoolean.setSelected(true);
    }
}
