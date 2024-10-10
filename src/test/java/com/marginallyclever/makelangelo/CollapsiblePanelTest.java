package com.marginallyclever.makelangelo;

import com.marginallyclever.util.PreferencesHelper;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true", disabledReason = "headless environment")
public class CollapsiblePanelTest {
    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        Robot robot = BasicRobot.robotWithNewAwtHierarchy();

        PreferencesHelper.start();
        Translator.start();

        JFrame frame = new JFrame();
        CollapsiblePanel collapsiblePanel = new CollapsiblePanel(frame, "Test Panel", 400, true);
        frame.setContentPane(collapsiblePanel);
        frame.setSize(new Dimension(600, 400));
        frame.setLocationRelativeTo(null);
        window = new FrameFixture(robot, frame);
        window.show(); // affiche la fenêtre à tester
    }

    @AfterEach
    public void tearDown() {
        if (window != null) window.cleanUp();
    }

    @Test
    public void testToggleVisibility() {
        /*
        Motivations: Ce test sert à vérifier le comportement d'un panneau rétractable.
        En effet il doit initiallement être rétracté, puis se développer et afficher ses
        éléments, puis se rétracter à nouveau à chaque clique et faire disparaitre ses éléments.
        On a besoin d'un set up au préalable, ainsi que de la définition d'une fonction qui
        permet de constater la visibilité du panneau.
        Attention: le test ne s'exécute pas dans le cas de CI (test graphique).
         */
        // Arrange
        JPanelFixture panel = window.panel(CollapsiblePanel.class.getSimpleName());

        // Act
        panel.requireVisible();

        // Assert
        // Initiallement rétracté
        assertFalse(hasVisibleComponents(panel), "Panel should be initially collapsed");

        // Cliquer pour développer
        panel.click();
        assertTrue(hasVisibleComponents(panel), "Panel should be expanded after click");

        // Cliquer pour rétracter de nouveau
        panel.click();
        assertFalse(hasVisibleComponents(panel), "Panel should be collapsed after second click");
    }

    private boolean hasVisibleComponents(JPanelFixture panel) {
        // Vérifie s'il y a au moins un composant visible sur le panneau
        return panel.target().getComponents().length > 0 && panel.target().getComponent(0).isVisible();
    }
}
