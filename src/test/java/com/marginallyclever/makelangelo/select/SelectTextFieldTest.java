package com.marginallyclever.makelangelo.select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.color.ColorSpace;

import org.junit.jupiter.api.Test;

class SelectTextFieldTest {

    /**
     * Method under test:
     * SelectTextField#getText()
     */
    @Test
    void testGetText() {
        // Arrange
        SelectTextField selectTextField = new SelectTextField("Internal Name", "Label Key", "Default Text");

        // Act
        String result = selectTextField.getText();

        // Assert
        assertEquals("Default Text", result);
    }

    /**
     * Method under test:
     * SelectTextField#isEditable()
     */
    @Test
    void testIsEditable() {
        // Arrange
        SelectTextField selectTextField = new SelectTextField("Internal Name", "Label Key", "Default Text");

        // Act
        boolean result = selectTextField.isEditable();

        // Assert
        assertTrue(result);
    }

    /**
     * Method under test:
     * SelectTextField#getDragEnabled()
     */
    @Test
    void testGetDragEnabled() {
        // Arrange
        SelectTextField selectTextField = new SelectTextField("Internal Name", "Label Key", "Default Text");

        // Act
        boolean result = selectTextField.getDragEnabled();

        // Assert
        assertFalse(result);
    }

    /**
     * Method under test:
     * SelectTextField(String, String, String)
     */
    @Test
    void testNewSelectTextField() {
        // Arrange
        SelectTextField selectTextField = new SelectTextField("Internal Name", "Label Key", "Default Text");

        // Act
        Color foreground = selectTextField.getForeground();
        ColorSpace colorSpace = foreground.getColorSpace();
        ColorSpace darkerColorSpace = foreground.darker().getColorSpace();

        // Assert
        assertSame(colorSpace, darkerColorSpace);
    }
}
