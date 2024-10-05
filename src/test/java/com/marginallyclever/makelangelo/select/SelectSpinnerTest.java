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
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);
        assertEquals(5, spinner.getValue());
    }

    /**
     * Tests that setting a valid value updates the spinner's value.
     */
    @Test
    public void setValue_validValue_updatesValue() {
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);
        spinner.setValue(7);
        assertEquals(7, spinner.getValue());
    }

    /**
     * Tests that setting a value out of the allowed range throws an IllegalArgumentException.
     */
    @Test
    public void setValue_valueOutOfRange_throwsIllegalArgumentException() {
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);
        assertThrows(IllegalArgumentException.class, () -> spinner.setValue(11));
    }

    /**
     * Tests that setting a value below the allowed range throws an IllegalArgumentException.
     */
    @Test
    public void setValue_valueBelowRange_throwsIllegalArgumentException() {
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);
        assertThrows(IllegalArgumentException.class, () -> spinner.setValue(-1));
    }

    /**
     * Tests that the value returned after setting a new value is the updated value.
     */
    @Test
    public void getValue_afterSettingValue_returnsUpdatedValue() {
        SelectSpinner spinner = new SelectSpinner("test", "Test Label", 0, 10, 5);
        spinner.setValue(3);
        assertEquals(3, spinner.getValue());
    }
}