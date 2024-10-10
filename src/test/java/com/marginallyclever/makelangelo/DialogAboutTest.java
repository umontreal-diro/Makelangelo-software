package com.marginallyclever.makelangelo;

import com.marginallyclever.util.PreferencesHelper;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import javax.swing.*;
import java.awt.*;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true", disabledReason = "headless environment")
public class DialogAboutTest {
    private DialogFixture dialog;

    @BeforeEach
    public void setUp() {
        Robot robot = BasicRobot.robotWithNewAwtHierarchy();

        PreferencesHelper.start();
        Translator.start();

        DialogAbout dialogAbout = new DialogAbout();
        JDialog aboutDialog = new JDialog();
        aboutDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        aboutDialog.setSize(new Dimension(400, 300));
        aboutDialog.setLocationRelativeTo(null);

        // Affichage de la boite de dialogue
        SwingUtilities.invokeLater(() -> dialogAbout.display(aboutDialog, "1.0.0", "hash-123456"));

        dialog = new DialogFixture(robot, aboutDialog);
        dialog.show(); // affiche le dialogue à tester
    }

    @AfterEach
    public void tearDown() {
        if (dialog != null) dialog.cleanUp();
    }

    @Test
    public void testDialogComponents() {
        /* Motivations: On veut vérifier la présence d'éléments dans la boite de dialogue 'DialogAbout'.
        Dans l'ordre: la boite en elle-même, ensuite un élément avec pour label:
        'DialogAbout.AboutHTML', et un bouton 'OK' sur lequel on clique pour finalement
        fermer la boite de dialogue.
        Attention: le test ne s'exécute pas dans le cas de CI (test graphique).
         */
        // Arrange - voir setup

        // Act and Assert
        dialog.requireVisible();
        dialog.label("DialogAbout.AboutHTML").requireVisible();
        dialog.button("OK").requireVisible().click();
    }
}
