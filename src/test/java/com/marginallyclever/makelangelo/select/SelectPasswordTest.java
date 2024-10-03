package com.marginallyclever.makelangelo.select;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.color.ColorSpace;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SelectPasswordTest {
  /**
   * Method under test: {@link SelectPassword#getPassword()}
   */
  @Test
  void testGetPassword() {
    // Arrange, Act and Assert
    assert "Default Text".equals((new SelectPassword("Internal Name", "Label Key", "Default Text")).getPassword());
  }

  /**
   * Method under test: {@link SelectPassword#isEditable()}
   */
  @Test
  void testIsEditable() {
    // Arrange, Act and Assert
    assert (new SelectPassword("Internal Name", "Label Key", "Default Text")).isEditable();
  }

  /**
   * Method under test: {@link SelectPassword#getDragEnabled()}
   */
  @Test
  void testGetDragEnabled() {
    // Arrange, Act and Assert
    assert !(new SelectPassword("Internal Name", "Label Key", "Default Text")).getDragEnabled();
  }


  /**
   * Method under test:
   * {@link SelectPassword#SelectPassword(String, String, String)}
   */
  @Test
  void testNewSelectPassword() {
    // Arrange, Act
    Color background = (new SelectPassword("Internal Name", "Label Key", "Default Text")).getBackground();
    ColorSpace expectedColorSpace = background.getColorSpace();

    // Assert
    assert expectedColorSpace == background.darker().getColorSpace();
  }
}
