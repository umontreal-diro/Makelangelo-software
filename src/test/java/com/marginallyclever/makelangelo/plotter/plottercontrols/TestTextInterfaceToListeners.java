package com.marginallyclever.makelangelo.plotter.plottercontrols;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTextInterfaceToListeners {

    private TextInterfaceToListeners textInterface;

    @BeforeEach
    public void setUp() {
        textInterface = new TextInterfaceToListeners();
    }

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

    @Test
    public void testSendNow() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assertEquals("test command", e.getActionCommand());
            }
        };
        textInterface.addActionListener(listener);
        textInterface.setCommand("test command");
        textInterface.sendNow();
        textInterface.removeActionListener(listener);
    }

    @Test
    public void testGetCommand() {
        textInterface.setCommand("test command");
        assertEquals("test command", textInterface.getCommand());
    }
}

