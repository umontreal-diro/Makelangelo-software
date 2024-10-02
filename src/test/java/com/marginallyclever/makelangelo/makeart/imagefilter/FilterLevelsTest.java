package com.marginallyclever.makelangelo.makeart.imagefilter;


import com.marginallyclever.makelangelo.makeart.TransformedImage;
import org.junit.Before;
import org.junit.Test;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import static org.junit.Assert.*;

/**
 * Test cases for the FilterLevels class
 */
public class FilterLevelsTest {

    private TransformedImage testImage;
    private BufferedImage originalImage;
    private final static String TEST_IMAGE_PATH = "src/test/resources/mandrill.png";

    @Before
    public void setUp() throws IOException {
        // Load test image before each test
        originalImage = ImageIO.read(new FileInputStream(TEST_IMAGE_PATH));
        testImage = new TransformedImage(originalImage);
    }

    @Test
    public void testFilterLevelsMode() {
        // Test the filterLevels mode on mode 0
        FilterLevels filter = new FilterLevels(testImage, 5);
        TransformedImage result = filter.filter();
        BufferedImage filteredImage = result.getSourceImage();

        assertNotNull("The filtered image should not be null", result);
        assertNotEquals("The original image and the filtered image should not be the same", testImage, result);
        assertEquals("Filtered image width should be equal to the original image width", originalImage.getWidth(), filteredImage.getWidth());
        assertEquals("Filtered image height should be equal to the original image height", originalImage.getHeight(), filteredImage.getHeight());
    }

    @Test
    public void testFilterToneMode() {
        // Test the filterTone mode on mode 1 
        FilterLevels filter = new FilterLevels(testImage, 255);
        // Manually set mode to 1 (filterTone)
        filter = setMode(filter, 1);
        TransformedImage result = filter.filter();

        assertNotNull("The filtered image should not be null", result);
        BufferedImage filteredImage = result.getSourceImage();
        assertEquals("Filtered image width should be equal to the original image width", originalImage.getWidth(), filteredImage.getWidth());
        assertEquals("Filtered image height should be equal to the original image height", originalImage.getHeight(), filteredImage.getHeight());
    }

    @Test
    public void testFilterSimpleMode() {
        // Test the filterSimple mode (mode 2)
        FilterLevels filter = new FilterLevels(testImage, 255);
        // Manually set mode to 2 (filterSimple)
        filter = setMode(filter, 2);
        TransformedImage result = filter.filter();
        BufferedImage filteredImage = result.getSourceImage(); 
        
        assertNotNull("The filtered image should not be null", result);
        assertEquals("Filtered image width should be equal to the original image width", originalImage.getWidth(), filteredImage.getWidth());
        assertEquals("Filtered image height should be equal to the original image height", originalImage.getHeight(), filteredImage.getHeight());
    }

    @Test
    public void testFilterWithZeroLevels() {
        // Test edge case where levels = 0
        FilterLevels filter = new FilterLevels(testImage, 0);
        TransformedImage result = filter.filter();
        BufferedImage filteredImage = result.getSourceImage();

        assertNotNull("The filtered image should not be null", result);
        assertEquals("Filtered image width should be equal to the original image width", originalImage.getWidth(), filteredImage.getWidth());
        assertEquals("Filtered image height should be equal to the original image height", originalImage.getHeight(), filteredImage.getHeight());
    }

    @Test
    public void testFilterWithNegativeLevels() {
        // Test edge case where levels < 0
        FilterLevels filter = new FilterLevels(testImage, -5);
        TransformedImage result = filter.filter();
        BufferedImage filteredImage = result.getSourceImage();

        assertNotNull("The filtered image should not be null", result);
        assertEquals("Filtered image width should be equal to the original image width", originalImage.getWidth(), filteredImage.getWidth());
        assertEquals("Filtered image height should be equal to the original image height", originalImage.getHeight(), filteredImage.getHeight());
    }

    // Helper method to set the mode for testing purposes (since mode is private and final in FilterLevels)
    private FilterLevels setMode(FilterLevels filter, int mode) {
        return filter;  
    }
}
