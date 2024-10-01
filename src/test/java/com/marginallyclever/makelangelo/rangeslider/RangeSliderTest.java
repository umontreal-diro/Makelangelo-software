package com.marginallyclever.makelangelo.rangeslider;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangeSliderTest {


    @Test
    public void testSetUpperValueOutOfRange() {
        RangeSlider slider = new RangeSlider(0, 100);
        slider.setUpperValue(150);  // Excede el máximo
        assertEquals(100, slider.getUpperValue(), "El valor superior no debería ser mayor que el máximo permitido.");
    }
}
