package com.marginallyclever.makelangelo.rangeslider;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for RangeSlider.
 */
public class RangeSliderTest {

    /**
     * Test that checks if setting the upper value out of range is handled correctly.
     */
    @Test
    public void testSetUpperValueOutOfRange() {
        // Arrange
        RangeSlider slider = new RangeSlider(0, 100);  // Create a RangeSlider with a range from 0 to 100.

        // Act
        slider.setUpperValue(150);  // Exceeds the maximum value of 100.

        // Assert
        assertEquals(100, slider.getUpperValue(), "The upper value should not exceed the allowed maximum.");
    }
}
