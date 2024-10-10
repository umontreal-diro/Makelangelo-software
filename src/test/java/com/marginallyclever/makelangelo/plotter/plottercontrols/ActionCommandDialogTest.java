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

    /* Teste la méthode saveResult lorsque la sélection est nulle.
     * Il signifie que la boîte de dialogue est fermée lorsque rien n'est sélectionné.*/
    @Test
    public void testSaveResult_NullSelection() {
        JOptionPane pane = new JOptionPane();
        int result = dialog.saveResult(pane, null);
        assertEquals(JOptionPane.CLOSED_OPTION, result, "Result should be CLOSED_OPTION when selection is null.");
    }

    /* Teste la méthode saveResult lorsque des choix sont fournis. La méthode saveResult est appelée après avoir
     * simulé la sélection de "Choice 2" par l'utilisateur. Le test vérifie que le résultat renvoyé est 1,
     * ce qui correspond à l'indice de "Choice 2" dans le tableau des choix.*/
    @Test
    public void testSaveResult_WithChoices() {
        JOptionPane pane = new JOptionPane();
        String[] choices = {"Choice 1", "Choice 2"};
        pane.setValue("Choice 2"); // Simulating user selection
        int result = dialog.saveResult(pane, choices);
        assertEquals(1, result, "Result should be 1 (index of 'Choice 2').");
    }
}

