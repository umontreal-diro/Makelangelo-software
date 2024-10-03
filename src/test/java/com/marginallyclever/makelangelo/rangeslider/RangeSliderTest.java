package com.marginallyclever.makelangelo.rangeslider;

import java.awt.Color;
import java.awt.color.ColorSpace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit test class for RangeSlider.
 */
public class RangeSliderTest {

  /**
   * Method under test: {@link RangeSlider#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals(50, (new RangeSlider()).getValue());
  }

  /**
   * Method under test: {@link RangeSlider#getUpperValue()}
   */
  @Test
  void testGetUpperValue() {
    // Arrange, Act and Assert
    assertEquals(50, (new RangeSlider()).getUpperValue());
  }

  /**
   * Method under test: {@link RangeSlider#RangeSlider()}
   */
  @Test
  void testNewRangeSlider() {
    // Arrange, Act and Assert
    Color background = (new RangeSlider()).getBackground();
    ColorSpace expectedColorSpace = background.getColorSpace();
    assertSame(expectedColorSpace, background.darker().getColorSpace());
  }

  /**
   * Method under test: {@link RangeSlider#RangeSlider(int, int)}
   */
  @Test
  void testNewRangeSlider2() {
    // Arrange, Act and Assert
    Color background = (new RangeSlider(1, 3)).getBackground();
    ColorSpace expectedColorSpace = background.getColorSpace();
    assertSame(expectedColorSpace, background.darker().getColorSpace());
  }

  /**
   * Test that checks if setting the upper value out of range is handled
   * correctly.
   */
  @Test
  public void testSetUpperValueOutOfRange() {
    RangeSlider slider = new RangeSlider(0, 100); // Create a RangeSlider with a range from 0 to 100.
    slider.setUpperValue(150); // Exceeds the maximum value of 100.
    assertEquals(100, slider.getUpperValue(), "The upper value should not exceed the allowed maximum.");
  }
}
