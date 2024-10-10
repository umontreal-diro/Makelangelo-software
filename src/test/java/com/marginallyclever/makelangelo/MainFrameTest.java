package com.marginallyclever.makelangelo;

import com.marginallyclever.util.PreferencesHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.swing.JFrame;

import java.awt.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the MainFrame class.
 * These tests focus on verifying the window size and position settings,
 * ensuring that the MainFrame class correctly reads preferences and applies them
 * to the window dimensions and screen position it should open at.
 */
public class MainFrameTest {

    private static final int DEFAULT_WIDTH = 800;  // Default width of the window
    private static final int DEFAULT_HEIGHT = 600; // Default height of the window

    @BeforeAll
    public static void beforeAll() {
        // Initialize the PreferencesHelper before any tests run
        PreferencesHelper.start();
    }

    @AfterEach
    public void clean() throws BackingStoreException {
        // Clean up preferences after each test run to avoid side effects
        Preferences graphics = PreferencesHelper.getPreferenceNode(PreferencesHelper.MakelangeloPreferenceKey.GRAPHICS);
        graphics.remove("windowWidth");
        graphics.remove("windowHeight");
        graphics.remove("windowX");
        graphics.remove("windowY");
        graphics.remove("isFullscreen");
        graphics.flush();
    }

    /**
     * Test to verify that the MainFrame initializes with default size and position
     * according to the predefined preferences when no custom settings are provided.
     */
    @Test
    public void testDefaultSizeAndPosition() {
        Preferences graphics = PreferencesHelper.getPreferenceNode(PreferencesHelper.MakelangeloPreferenceKey.GRAPHICS);

        // Set default values explicitly to ensure test uses them
        graphics.putInt("windowWidth", DEFAULT_WIDTH);
        graphics.putInt("windowHeight", DEFAULT_HEIGHT);
        graphics.putInt("windowX", (Toolkit.getDefaultToolkit().getScreenSize().width - DEFAULT_WIDTH) / 2);
        graphics.putInt("windowY", (Toolkit.getDefaultToolkit().getScreenSize().height - DEFAULT_HEIGHT) / 2);

        // Create MainFrame with the given preferences
        MainFrame frame = new MainFrame("", graphics);
        frame.setWindowSizeAndPosition();

        // Verify that the frame has the default size
        assertEquals(DEFAULT_WIDTH, frame.getWidth());
        assertEquals(DEFAULT_HEIGHT, frame.getHeight());

        // Verify that the frame is centered on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        assertEquals((screenSize.width - DEFAULT_WIDTH) / 2, frame.getX());
        assertEquals((screenSize.height - DEFAULT_HEIGHT) / 2, frame.getY());
    }

    /**
     * Test to confirm that the MainFrame's size and position can be customized
     * and that it adheres to the given size and position preferences.
     */
    @Test
    public void testCustomSizeAndPosition() throws BackingStoreException {
        int width = 100;  // Custom width for the window
        int height = 200; // Custom height for the window
        int x = 300;      // Custom X position for the window
        int y = 400;      // Custom Y position for the window
        Preferences graphics = PreferencesHelper.getPreferenceNode(PreferencesHelper.MakelangeloPreferenceKey.GRAPHICS);
        graphics.putInt("windowWidth", width);
        graphics.putInt("windowHeight", height);
        graphics.putInt("windowX", x);
        graphics.putInt("windowY", y);
        graphics.flush();

        // Create MainFrame with the given preferences
        MainFrame frame = new MainFrame("", graphics);
        frame.setWindowSizeAndPosition();

        // Verify that the frame has the custom size
        assertEquals(width, frame.getWidth());
        assertEquals(height, frame.getHeight());

        // Verify that the frame is positioned according to the custom settings
        assertEquals(x, frame.getX());
        assertEquals(y, frame.getY());
    }

}