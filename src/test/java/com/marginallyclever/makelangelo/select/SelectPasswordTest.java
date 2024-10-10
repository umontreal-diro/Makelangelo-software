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
   * Test unitaire qui vérifie que la méthode getPassword() retourne correctement le mot de passe par défaut.
   * On initialise un objet SelectPassword avec un texte par défaut, et on vérifie que la méthode
   * getPassword() renvoie bien ce texte.
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
   * Test unitaire qui vérifie que la méthode isEditable() retourne true, indiquant que le champ de mot de passe
   * est modifiable par défaut. On crée un objet SelectPassword et on s'assure que la méthode isEditable() renvoie true.
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
   * Test unitaire qui vérifie que l'espace colorimétrique de l'arrière-plan reste le même après un assombrissement.
   * Après avoir créé un objet SelectPassword, on récupère la couleur de l'arrière-plan, puis on compare
   * les espaces colorimétriques avant et après avoir assombri cette couleur.
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
