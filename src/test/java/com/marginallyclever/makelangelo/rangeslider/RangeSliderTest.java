package com.marginallyclever.makelangelo.rangeslider;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for RangeSlider.
 */
public class RangeSliderTest {

    /**
     * Test unitaire qui vérifie que la valeur supérieure ne dépasse pas la limite maximale du RangeSlider.
     * On essaie de définir une valeur supérieure hors de portée, et on s'assure qu'elle est limitée à 100.
     */
    @Test
    public void testSetUpperValueOutOfRange() {
        RangeSlider slider = new RangeSlider(0, 100);  // Create a RangeSlider with a range from 0 to 100.
        slider.setUpperValue(150);  // Exceeds the maximum value of 100.
        assertEquals(100, slider.getUpperValue(), "The upper value should not exceed the allowed maximum.");
    }
}
