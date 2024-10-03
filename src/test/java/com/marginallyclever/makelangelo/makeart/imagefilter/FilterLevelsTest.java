package com.marginallyclever.makelangelo.makeart.imagefilter;

import com.marginallyclever.makelangelo.makeart.TransformedImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class FilterLevelsTest  {

    private TransformedImage img;
    private FilterLevels filterLevels;

    @BeforeEach
    void setUp() throws IOException {
        // Arrange
        BufferedImage inputImage = ImageIO.read(new File("src/test/resources/mandrill.png"));
        img = new TransformedImage(inputImage);
        filterLevels = new FilterLevels(img, 255); // You can vary the levels
    }

    @Test
    void testFilterLevels() {
        // Act
        TransformedImage result = filterLevels.filter();

        // Assert
        assertNotNull(result);
        BufferedImage resultImage = result.getSourceImage();
        assertEquals(img.getSourceImage().getWidth(), resultImage.getWidth(), "Image width should match");
        assertEquals(img.getSourceImage().getHeight(), resultImage.getHeight(), "Image height should match");

        // Additional validation: Check if some pixel transformations are within expected ranges
        int rgbOriginal = img.getSourceImage().getRGB(0, 0);
        int rgbFiltered = resultImage.getRGB(0, 0);

        // You can add more detailed assertions if you expect specific behavior on pixel values
        assertNotEquals(rgbOriginal, rgbFiltered, "Filtered image should have different pixel values than the original");
    }
}
