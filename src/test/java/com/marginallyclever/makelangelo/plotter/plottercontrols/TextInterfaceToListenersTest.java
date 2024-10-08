package com.marginallyclever.makelangelo.plotter.plottercontrols;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextInterfaceToListenersTest {

    private TextInterfaceToListeners textInterface;

    @BeforeEach
    public void setUp() {
        textInterface = new TextInterfaceToListeners();
    }

    /* Teste la méthode sendCommand pour s'assurer qu'elle envoie la commande correcte via un ActionListener.*/
    @Test
    public void testSendCommand() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assertEquals("test command", e.getActionCommand());
            }
        };
        textInterface.addActionListener(listener);
        textInterface.sendCommand("test command");
        textInterface.removeActionListener(listener);
    }

    /* Teste la méthode getCommand pour s'assurer qu'elle retourne la commande correcte.*/
    @Test
    public void testGetCommand() {
        textInterface.setCommand("test command");
        assertEquals("test command", textInterface.getCommand());
    }
}

