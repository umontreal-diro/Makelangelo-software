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
        window.show(); // shows the frame to test
    }

    @AfterEach
    public void tearDown() {
        if (window != null) window.cleanUp();
    }

    @Test
    public void testToggleVisibility() {
        JPanelFixture panel = window.panel(CollapsiblePanel.class.getSimpleName());
        panel.requireVisible();

        // Initially collapsed
        assertFalse(hasVisibleComponents(panel), "Panel should be initially collapsed");

        // Click to expand
        panel.click();
        assertTrue(hasVisibleComponents(panel), "Panel should be expanded after click");

        // Click to collapse again
        panel.click();
        assertFalse(hasVisibleComponents(panel), "Panel should be collapsed after second click");
    }

    private boolean hasVisibleComponents(JPanelFixture panel) {
        // Check if any components inside the panel are visible
        return panel.target().getComponents().length > 0 && panel.target().getComponent(0).isVisible();
    }
}
