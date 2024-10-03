package com.marginallyclever.makelangelo.select;

import static org.junit.jupiter.api.Assertions.assertSame;
import java.awt.Color;
import java.awt.color.ColorSpace;
import org.junit.jupiter.api.Test;

class SelectPasswordTest {
  /**
   * Method under test:
   * {@link SelectPassword#SelectPassword(String, String, String)}
   */
  @Test
  void testNewSelectPassword() {
    // Arrange, Act and Assert
    Color background = (new SelectPassword("Internal Name", "Label Key", "Default Text")).getBackground();
    ColorSpace expectedColorSpace = background.getColorSpace();
    assertSame(expectedColorSpace, background.darker().getColorSpace());
  }
}
