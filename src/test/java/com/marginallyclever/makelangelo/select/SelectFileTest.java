package com.marginallyclever.makelangelo.select;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.filechooser.FileFilter;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SelectFileTest {
    private static final Logger logger = LoggerFactory.getLogger(SelectFileTest.class);

    @Test
    public void testInitialText() {
        SelectFile selectFile = new SelectFile("testFile", "Test Label", "default.txt");
        assertEquals("default.txt", selectFile.getText(), "Initial text should be 'default.txt'");
    }

    @Test
    public void testSetText() {
        SelectFile selectFile = new SelectFile("testFile", "Test Label", "default.txt");
        selectFile.setText("newfile.txt");
        assertEquals("newfile.txt", selectFile.getText(), "Text should be 'newfile.txt' after setting");
    }

    @Test
    public void testFileSelection() {
        SelectFile selectFile = spy(new SelectFile("testFile", "Test Label", "default.txt"));
        doReturn("selectedFile.txt").when(selectFile).selectFile(anyString());

        selectFile.setText("selectedFile.txt");
        assertEquals("selectedFile.txt", selectFile.getText(), "Text should be 'selectedFile.txt' after file selection");
    }

    @Test
    public void testSetFilter() {
        SelectFile selectFile = new SelectFile("testFile", "Test Label", "default.txt");
        FileFilter filter = mock(FileFilter.class);
        selectFile.setFilter(filter);
    }
}
