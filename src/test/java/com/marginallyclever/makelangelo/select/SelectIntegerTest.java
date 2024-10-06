package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectIntegerTest {
    private static final Logger logger = LoggerFactory.getLogger(SelectIntegerTest.class);

    @Test
    public void testInitialValue() {
        SelectInteger selectInteger = new SelectInteger("testInteger", "Test Label", 0);
        assertEquals(0, selectInteger.getValue(), "Initial value should be 0");

        selectInteger = new SelectInteger("testInteger", "Test Label", 10);
        assertEquals(10, selectInteger.getValue(), "Initial value should be 10");
    }

    @Test
    public void testSetValue() {
        SelectInteger selectInteger = new SelectInteger("testInteger", "Test Label", 0);
        selectInteger.setValue(20);
        assertEquals(20, selectInteger.getValue(), "Value should be 20 after setting");

        selectInteger.setValue(-5);
        assertEquals(-5, selectInteger.getValue(), "Value should be -5 after setting");
    }

    @Test
    public void testEventFiring() {
        SelectInteger selectInteger = new SelectInteger("testInteger", "Test Label", 0);
        selectInteger.addSelectListener(event -> {
            assertEquals(0, event.getOldValue(), "Old value should be 0");
            assertEquals(15, event.getNewValue(), "New value should be 15");
        });

        selectInteger.setValue(15);
    }
}
