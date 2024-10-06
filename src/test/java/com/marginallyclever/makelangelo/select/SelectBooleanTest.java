package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectBooleanTest {
    private static final Logger logger = LoggerFactory.getLogger(SelectBooleanTest.class);

    @Test
    public void testInitialSelection() {
        SelectBoolean selectBoolean = new SelectBoolean("testBoolean", "Test Label", false);
        assertFalse(selectBoolean.isSelected(), "Initial selection should be false");

        selectBoolean = new SelectBoolean("testBoolean", "Test Label", true);
        assertTrue(selectBoolean.isSelected(), "Initial selection should be true");
    }

    @Test
    public void testSetSelected() {
        SelectBoolean selectBoolean = new SelectBoolean("testBoolean", "Test Label", false);
        selectBoolean.setSelected(true);
        assertTrue(selectBoolean.isSelected(), "Selection should be true after setting to true");

        selectBoolean.setSelected(false);
        assertFalse(selectBoolean.isSelected(), "Selection should be false after setting to false");
    }

    @Test
    public void testEventFiring() {
        SelectBoolean selectBoolean = new SelectBoolean("testBoolean", "Test Label", false);
        selectBoolean.addSelectListener(event -> {
            assertFalse((Boolean) event.getOldValue(), "Old value should be false");
            assertTrue((Boolean) event.getNewValue(), "New value should be true");
        });

        selectBoolean.setSelected(true);
    }
}
