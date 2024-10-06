package com.marginallyclever.makelangelo;

import com.marginallyclever.util.PreferencesHelper;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import javax.swing.*;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true", disabledReason = "headless environment")
public class DialogBadFirmwareVersionTest {
    private DialogFixture dialog;

    @BeforeEach
    public void setUp() {
        Robot robot = BasicRobot.robotWithNewAwtHierarchy();

        PreferencesHelper.start();
        Translator.start();

        DialogBadFirmwareVersion dialogBadFirmwareVersion = new DialogBadFirmwareVersion();
        JDialog badFirmwareDialog = new JDialog();
        badFirmwareDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        badFirmwareDialog.setSize(400, 200);
        badFirmwareDialog.setLocationRelativeTo(null);

        // Display the dialog
        SwingUtilities.invokeLater(() -> dialogBadFirmwareVersion.display(badFirmwareDialog, "1.0.0"));

        dialog = new DialogFixture(robot, badFirmwareDialog);
        dialog.show(); // shows the dialog to test
    }

    @AfterEach
    public void tearDown() {
        if (dialog != null) dialog.cleanUp();
    }

    @Test
    public void testDialogComponents() {
        dialog.requireVisible();
        dialog.label("DialogBadFirmwareVersion.Message").requireVisible();
        dialog.button("OK").requireVisible().click();
    }
}
