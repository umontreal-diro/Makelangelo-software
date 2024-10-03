package com.marginallyclever.makelangelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CollapsiblePanelTest {

    private CollapsiblePanel collapsiblePanel;
    private JFrame testFrame;

    @BeforeEach
    void setUp() {
        testFrame = new JFrame();
        collapsiblePanel = new CollapsiblePanel(testFrame, "Test Panel", 400, true);
    }


    @Test
    void testAddComponent() {
        JButton testButton = new JButton("Test Button");
        collapsiblePanel.add(testButton);
        assertEquals(1, collapsiblePanel.getComponentCount(), "There should be one component in the panel.");
        assertFalse(testButton.isVisible(), "The component should be hidden by default.");
    }

    @Test
    void testToggleVisibility() {
        JButton testButton = new JButton("Test Button");
        collapsiblePanel.add(testButton);

        // Simulate click to expand
        collapsiblePanel.toggleVisibility(true);
        assertTrue(testButton.isVisible(), "The button should be visible after expanding.");

        // Simulate click to collapse
        collapsiblePanel.toggleVisibility(false);
        assertFalse(testButton.isVisible(), "The button should be hidden after collapsing.");
    }

    @Test
    void testSetTitle() {
        collapsiblePanel.setTitle("New Title");
        assertEquals("New Title", collapsiblePanel.getTitle(), "The title should be updated.");
    }
}
