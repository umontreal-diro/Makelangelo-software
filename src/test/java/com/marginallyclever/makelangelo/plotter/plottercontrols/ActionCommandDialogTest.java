package com.marginallyclever.makelangelo.plotter.plottercontrols;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ActionCommandDialogTest {
    private ActionCommandDialog dialog;

    @BeforeEach
    public void setUp() {
        dialog = new ActionCommandDialog();
    }

    @Test
    public void testSaveResult_NullSelection() {
        JOptionPane pane = new JOptionPane();
        int result = dialog.saveResult(pane, null);
        assertEquals(JOptionPane.CLOSED_OPTION, result, "Result should be CLOSED_OPTION when selection is null.");
    }

    @Test
    public void testSaveResult_WithChoices() {
        JOptionPane pane = new JOptionPane();
        String[] choices = {"Choice 1", "Choice 2"};
        pane.setValue("Choice 2"); // Simulating user selection
        int result = dialog.saveResult(pane, choices);
        assertEquals(1, result, "Result should be 1 (index of 'Choice 2').");
    }


    @Test
    public void testRun() {
        dialog.setPromptMessage("Select a color:");
        dialog.addOption("Red");
        dialog.addOption("Green");
        dialog.addOption("Blue");

        dialog.run(null, "Color Selection", (Integer result) -> {
            assertNotNull(result, "Result should not be null after running the dialog.");
        });
    }
}

