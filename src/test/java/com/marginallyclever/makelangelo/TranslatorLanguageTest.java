package com.marginallyclever.makelangelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TranslatorLanguageTest {

    private TranslatorLanguage translatorLanguage;

    @BeforeEach
    public void setUp() {
        translatorLanguage = new TranslatorLanguage();
    }

    @Test
    public void testLoadFromString() {
        String languageFile = "path/to/language/file.xml"; // Replace with actual path
        translatorLanguage.loadFromString(languageFile);
        assertNotNull(translatorLanguage.getName(), "Language name should be loaded");
        assertFalse(translatorLanguage.getAuthors().isEmpty(), "Authors should be loaded");
        assertFalse(translatorLanguage.getKeys().isEmpty(), "Translations should be loaded");
    }

    @Test
    public void testLoadFromInputStream() {
        InputStream inputStream = getClass().getResourceAsStream("/path/to/language/file.xml"); // Replace with actual path
        assertNotNull(inputStream, "Input stream should not be null");
        translatorLanguage.loadFromInputStream(inputStream);
        assertNotNull(translatorLanguage.getName(), "Language name should be loaded");
        assertFalse(translatorLanguage.getAuthors().isEmpty(), "Authors should be loaded");
        assertFalse(translatorLanguage.getKeys().isEmpty(), "Translations should be loaded");
    }

    @Test
    public void testGetTranslation() {
        String key = "hello";
        String expectedTranslation = "Hello"; // Replace with expected translation
        assertEquals(expectedTranslation, translatorLanguage.get(key), "Translation should match expected value");
    }

    @Test
    public void testGetMissingTranslation() {
        String missingKey = "missingKey";
        assertNull(translatorLanguage.get(missingKey), "Missing translation should return null or a default value");
    }

    @Test
    public void testGetAuthors() {
        List<String> authors = translatorLanguage.getAuthors();
        assertNotNull(authors, "Authors list should not be null");
        assertFalse(authors.isEmpty(), "Authors list should not be empty");
    }

    @Test
    public void testGetKeys() {
        Set<String> keys = translatorLanguage.getKeys();
        assertNotNull(keys, "Keys set should not be null");
        assertFalse(keys.isEmpty(), "Keys set should not be empty");
    }
}
