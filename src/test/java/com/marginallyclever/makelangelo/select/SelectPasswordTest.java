package com.marginallyclever.makelangelo.select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.color.ColorSpace;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SelectPasswordTest {

  /**
   * Method under test:
   * SelectPassword#getPassword()
   */
  @Test
  void testGetPassword() {
    // Arrange
    SelectPassword selectPassword = new SelectPassword("Internal Name", "Label Key", "Default Text");

    // Act
    String password = selectPassword.getPassword();

    // Assert
    assertEquals("Default Text", password);
  }

  /**
   * Method under test:
   * SelectPassword#isEditable()
   */
  @Test
  void testIsEditable() {
    // Arrange
    SelectPassword selectPassword = new SelectPassword("Internal Name", "Label Key", "Default Text");

    // Act
    boolean isEditable = selectPassword.isEditable();

    // Assert
    assertTrue(isEditable);
  }


  /**
   * Method under test:
   * SelectPassword(String, String, String)
   */
  @Test
  void testNewSelectPassword() {
    // Arrange
    SelectPassword selectPassword = new SelectPassword("Internal Name", "Label Key", "Default Text");

    // Act
    Color background = selectPassword.getBackground();
    ColorSpace colorSpace = background.getColorSpace();
    ColorSpace darkerColorSpace = background.darker().getColorSpace();

    // Assert
    assertSame(colorSpace, darkerColorSpace);
  }
}
