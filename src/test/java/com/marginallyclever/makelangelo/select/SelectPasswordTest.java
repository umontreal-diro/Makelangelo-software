package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectPasswordTest {
    private static final Logger logger = LoggerFactory.getLogger(SelectPasswordTest.class);

    @Test
    public void testInitialPassword() {
        /*
        Motivations: On souhaite tester l'initialisation de l'objet SelectPassword, en
        vérifiant que la valeur initialisée est bien celle attendue en utilisant le getter
        'getPassword()'.
         */
        // Arrange and Act
        SelectPassword selectPassword = new SelectPassword("testPassword", "Test Label", "defaultPass");

        // Assert
        assertEquals("defaultPass", selectPassword.getPassword(), "Initial password should be 'defaultPass'");
    }

    @Test
    public void testSetPassword() {
        /*
        Motivations: On souhaite tester le setter de l'attribut password de l'objet 'SelectPassword'.
        On l'essaye à deux reprises avec deux mot de passe différents pour être sûr que l'utiliser
        une première fois ne cause pas de problème pour une utilisation ultérieure de ce setter.
         */
        // Arrange
        SelectPassword selectPassword = new SelectPassword("testPassword", "Test Label", "defaultPass");

        // Act
        selectPassword.setPassword("newPass");

        // Assert
        assertEquals("newPass", selectPassword.getPassword(), "Password should be 'newPass' after setting");

        // Act
        selectPassword.setPassword("anotherPass");

        // Assert
        assertEquals("anotherPass", selectPassword.getPassword(), "Password should be 'anotherPass' after setting");
    }
}
