package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SelectReadOnlyTextTest {
    private static final Logger logger = LoggerFactory.getLogger(SelectReadOnlyTextTest.class);
    private SelectReadOnlyText selectReadOnlyText;

    @BeforeEach
    public void setUp() {
        selectReadOnlyText = new SelectReadOnlyText("testReadOnly", "Initial Text");
    }

    @Test
    public void testInitialText() {
        assertEquals("Initial Text", selectReadOnlyText.getText(), "Initial text should be 'Initial Text'");
    }

    @Test
    public void testSetText() {
        selectReadOnlyText.setText("New Text");
        assertEquals("New Text", selectReadOnlyText.getText(), "Text should be 'New Text' after setting");
    }

    @Test
    public void testReadOnly() {
        assertFalse(selectReadOnlyText.isEditable(), "Text field should be read-only");
    }
}
