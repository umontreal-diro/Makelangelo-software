package com.marginallyclever.makelangelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JMenuItem;

import com.marginallyclever.util.PreferencesHelper;
import com.marginallyclever.util.PreferencesHelper.MakelangeloPreferenceKey;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RecentFiles class.
 * These tests cover the functionality of managing a list of recent files,
 * including adding, retrieving, removing filenames, and ensuring persistence
 * of this list using preferences.
 */
public class RecentFilesTest {
    private RecentFiles recentFiles;
    protected int testObservation; // Counter to test observer pattern

    @BeforeEach
    public void beforeEach() throws BackingStoreException {
        // Clear the preferences to ensure a clean state before each test
        Preferences prefs = PreferencesHelper.getPreferenceNode(MakelangeloPreferenceKey.LEGACY_MAKELANGELO_ROOT);
        prefs.clear();

        // Initialize the RecentFiles instance before each test
        recentFiles = new RecentFiles("Reopen");
    }

    /**
     * Test adding filenames to RecentFiles.
     * Verify that filenames are added correctly with the most recent on top,
     * duplicates are not added twice, and invalid inputs are ignored.
     */
    @Test
    public void testAddFilename() {
        recentFiles.addFilename("/home/test/file1.txt");
        assertEquals("/home/test/file1.txt", recentFiles.getFile(0));

        recentFiles.addFilename("/home/test/file2.txt");
        assertEquals("/home/test/file2.txt", recentFiles.getFile(0));
        assertEquals("/home/test/file1.txt", recentFiles.getFile(1));
        // Verify that if a filename already exists, it will be moved to the top of the list
        recentFiles.addFilename("/home/test/file1.txt");
        assertEquals("/home/test/file1.txt", recentFiles.getFile(0));
        assertEquals("/home/test/file2.txt", recentFiles.getFile(1));

        // Verify null value (should not add to the list)
        recentFiles.addFilename(null);
        assertEquals(2, recentFiles.getMenuComponentCount(), "Null filename should not be added");

        // Verify empty value (should not add to the list)
        recentFiles.addFilename("");
        assertEquals(2, recentFiles.getMenuComponentCount(), "Empty filename should not be added");

        // Verify blank value (should not add to the list)
        recentFiles.addFilename("   ");
        assertEquals(2, recentFiles.getMenuComponentCount(), "Blank filename should not be added");

        // Verify adding more filenames
        Set<String> uniqueFilenames = new HashSet<>();
        uniqueFilenames.add("/home/test/file1.txt");
        uniqueFilenames.add("/home/test/file2.txt");

        int filesToAdd = recentFiles.getMaxFiles() + 1; // filesToAdd = 11

        for (int i = 0; i < filesToAdd; i++) {
            String filename = "/home/test/file" + i + ".txt";
            uniqueFilenames.add(filename);
            recentFiles.addFilename(filename);
        }

        int expectedMenuComponentCount = uniqueFilenames.size();

        assertEquals(expectedMenuComponentCount, recentFiles.getMenuComponentCount(),
            "Menu component count should reflect the number of unique valid filenames added");
    }

    /**
     * Test to ensure the maximum limit of recent files stored is correct.
     */
    @Test
    public void testGetMaxFiles() {
        assertEquals(10, recentFiles.getMaxFiles(), 
            "The maximum number of recent files should be 10");
    }

    /**
     * Test the persistence of the recent files list through storage and retrieval.
     * Ensure that files added to one instance are retrieved correctly in a new instance.
     */
    @Test
    public void testStorageAndRetrieval() {
        recentFiles.addFilename("file1.txt");
        recentFiles.addFilename("file2.txt");

        RecentFiles newRecentFiles = new RecentFiles("Reopen");
        assertEquals("file2.txt", newRecentFiles.getFile(0));
        assertEquals("file1.txt", newRecentFiles.getFile(1));
    }

    /**
     * Test removing filenames from the RecentFiles list.
     * Ensure that the list updates correctly after removals.
     */
    @Test
    public void testRemoveFilename() {
        recentFiles.addFilename("/home/test/file1.txt");
        recentFiles.addFilename("/home/test/file2.txt");
        assertEquals("/home/test/file2.txt", recentFiles.getFile(0));
        assertEquals("/home/test/file1.txt", recentFiles.getFile(1));
        recentFiles.removeFilename("/home/test/file2.txt");
        assertEquals("/home/test/file1.txt", recentFiles.getFile(0));
        recentFiles.removeFilename("/home/test/file1.txt");
        assertEquals(0, recentFiles.getMenuComponentCount());
    }

    /**
     * Test adding a duplicate filename to ensure duplicates are not stored twice.
     */
    @Test
    public void testAddFileNameTwice() {
        recentFiles.addFilename("file1.txt");
        recentFiles.addFilename("file2.txt");
        recentFiles.addFilename("file1.txt"); // Add duplicate
        assertEquals(2, recentFiles.getMenuComponentCount(), 
                     "Menu must contain 2 elements; the duplicated filename is not added twice");
        assertEquals("file1.txt", recentFiles.getFile(0));
        assertEquals("file2.txt", recentFiles.getFile(1));
    }

    /**
     * Test adding an empty filename to ensure it is not added to the list.
     */
    @Test
    public void testAddEmptyFileName() {
        recentFiles.addFilename(""); // Add empty filename
        assertEquals(0, recentFiles.getMenuComponentCount(), "Menu must be empty");
    }

    /**
     * Test behavior when trying to remove a filename that doesn't exist in the list.
     */
    @Test
    public void testRemoveNonExistentFilename() {
        recentFiles.addFilename("file1.txt");
        recentFiles.removeFilename("file2.txt"); // Removing a file that doesn't exist
        assertEquals(1, recentFiles.getMenuComponentCount(), 
            "Menu should still contain the existing file");
        assertEquals("file1.txt", recentFiles.getFile(0));
    }

    /**
     * Test the functionality of adding a submenu listener to handle file selection.
     */
    @Test
    public void testAddSubmenuListener() {
        // Test observer fires
        testObservation = 0;
        recentFiles.addFilename("file1.txt");
        recentFiles.addSubmenuListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++testObservation;
                assertEquals("file1.txt", e.getActionCommand());
            }
        });
        ((JMenuItem) recentFiles.getMenuComponent(0)).doClick();
        assertTrue(testObservation > 0);
    }
}