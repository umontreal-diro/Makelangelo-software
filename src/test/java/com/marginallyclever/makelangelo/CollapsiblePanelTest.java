package com.marginallyclever.makelangelo;


import com.marginallyclever.makelangelo.paper.PaperSettingsPanel;
import com.marginallyclever.makelangelo.select.*;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;


import javax.swing.*;
import java.awt.*;

import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import static org.assertj.swing.edt.GuiActionRunner.execute;

public class CollapsiblePanelTest {
    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        Robot robot = BasicRobot.robotWithNewAwtHierarchy();
        JFrame frame = new JFrame("Collapsible Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        SelectBoolean a = new SelectBoolean("A", "AAAAAAAAAAA", false);
        jPanel.add(a, BorderLayout.NORTH);

        CollapsiblePanel cpanel = new CollapsiblePanel(frame, "lot of buttons", 400, true);
        jPanel.add(cpanel, BorderLayout.CENTER);

        SelectButton b = new SelectButton("B", "B");
        SelectColor c = new SelectColor("C", "CCCCCC", Color.BLACK, frame);
        SelectFile d = new SelectFile("D", "D", null);
        SelectDouble e = new SelectDouble("E", "E", 0.0f);
        SelectInteger f = new SelectInteger("F", "FFF", 0);
        String[] list = {"cars", "trains", "planes", "boats", "rockets"};
        SelectOneOfMany g = new SelectOneOfMany("G", "G", list, 0);
        String ipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        SelectReadOnlyText h = new SelectReadOnlyText("H", "H " + ipsum);
        SelectSlider i = new SelectSlider("I", "I", 200, 0, 100);
        SelectTextArea j = new SelectTextArea("J", "J", ipsum);

        cpanel.add(b);
        cpanel.add(c);
        cpanel.add(d);
        cpanel.add(e);
        cpanel.add(f);
        cpanel.add(g);
        cpanel.add(h);
        cpanel.add(i);
        cpanel.add(j);

        frame.setPreferredSize(new Dimension(600, 90));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(true);
        window = new FrameFixture(robot, frame);
        window.show(); // shows the frame to test
    }

    @AfterEach
    public void tearDown() {
        if (window != null) window.cleanUp();
    }

    @SuppressWarnings("unlikely-arg-type")

    @Test
    public void testRemoveByComponent() {
        JFrame frame = new JFrame("Collapsible Panel");
        CollapsiblePanel panel = new CollapsiblePanel(frame, "lot of buttons", 400, true);

        // Añadir componentes al panel
            JLabel label1 = new JLabel("Label 1");
            JLabel label2 = new JLabel("Label 2");
            panel.add(label1);
            panel.add(label2);

            // Verificar que los componentes han sido añadidos
            assert(panel.innerPanel.getComponentCount())==(2);

            // Eliminar un componente directamente
            panel.remove(label1);

            // Verificar que el componente ha sido eliminado
            assert(panel.innerPanel.getComponentCount())==(1);
            assert(panel.innerPanel.getComponent(0))==(label2); // Solo debería quedar el segundo componente

    }


}
