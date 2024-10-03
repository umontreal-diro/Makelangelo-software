package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectSpinnerTest {
    private SelectSpinner selectSpinner;

    @BeforeEach
    public void setUp() {
        // Initialize the SelectSpinner with sample values
        selectSpinner = new SelectSpinner("testSpinner", "Test Spinner", 0, 10, 5);
    }



    @Test
    public void testGetValue() {
        // Check the initial value returned by getValue()
        assertThat(selectSpinner.getValue()).isEqualTo(5);

        // Change the value and check again
        selectSpinner.setValue(7);
        assertThat(selectSpinner.getValue()).isEqualTo(7);
    }

    @Test
    public void testSetValue() {
        // Set a new value
        selectSpinner.setValue(3);
        assertThat(selectSpinner.getValue()).isEqualTo(3); // Verify the value is updated

        // Set another value
        selectSpinner.setValue(10);
        assertThat(selectSpinner.getValue()).isEqualTo(10); // Verify the new value
    }


}
