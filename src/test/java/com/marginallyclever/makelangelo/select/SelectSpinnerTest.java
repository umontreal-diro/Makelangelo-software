package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the SelectSpinner class.
 */
public class SelectSpinnerTest {

    /**
     * Tests that the initial value of the spinner is returned correctly.
     */
    @Test
    public void getValue_initialValue_returnsCorrectValue() {
        // Arrange
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);

        // Act
        int value = spinner.getValue();

        // Assert
        assertEquals(5, value);
    }

    /**
     * Tests that setting a valid value updates the spinner's value.
     */
    @Test
    public void setValue_validValue_updatesValue() {
        // Arrange
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);

        // Act
        spinner.setValue(7);
        int value = spinner.getValue();

        // Assert
        assertEquals(7, value);
    }

    /**
     * Tests that setting a value out of the allowed range throws an IllegalArgumentException.
     */
    @Test
    public void setValue_valueOutOfRange_throwsIllegalArgumentException() {
        // Arrange
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> spinner.setValue(11));
    }

    /**
     * Tests that setting a value below the allowed range throws an IllegalArgumentException.
     */
    @Test
    public void setValue_valueBelowRange_throwsIllegalArgumentException() {
        // Arrange
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> spinner.setValue(-1));
    }

    /**
     * Tests that the value returned after setting a new value is the updated value.
     */
    @Test
    public void getValue_afterSettingValue_returnsUpdatedValue() {
        // Arrange
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);

        // Act
        spinner.setValue(3);
        int value = spinner.getValue();

        // Assert
        assertEquals(3, value);
    }
}