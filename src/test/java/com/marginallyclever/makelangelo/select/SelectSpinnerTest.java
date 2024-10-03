package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectSpinnerTest {
    private SelectSpinner selectSpinner;

    @BeforeEach
    public void setUp() {
        // Arrange: Initialize the SelectSpinner with sample values
        selectSpinner = new SelectSpinner("testSpinner", "Test Spinner", 0, 10, 5);
    }

    @Test
    public void testSetAndGetValue() {
        // Act: Get the initial value
        int initialValue = selectSpinner.getValue();
        // Assert: Check the initial value
        assertThat(initialValue).isEqualTo(5);

        // Act: Set a new value and get it
        selectSpinner.setValue(7);
        int updatedValue = selectSpinner.getValue();

        // Assert: Verify the updated value
        assertThat(updatedValue).isEqualTo(7);
        // Act: Set another value and get it
        selectSpinner.setValue(3);
        int newValue = selectSpinner.getValue();

        // Assert: Verify the new value
        assertThat(newValue).isEqualTo(3);

        // Act: Set a different value and get it
        selectSpinner.setValue(10);
        int finalValue = selectSpinner.getValue();

        // Assert: Verify the final value
        assertThat(finalValue).isEqualTo(10);
    }
}
