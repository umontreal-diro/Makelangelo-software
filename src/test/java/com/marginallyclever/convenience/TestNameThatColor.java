package com.marginallyclever.convenience;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestNameThatColor {
    @Test
    public void testRedComponent() {
        NameThatColor nameThatColor = new NameThatColor();
        float red = nameThatColor.red(0xFFA07A);  // hex value for "light salmon"
        assertEquals(255, red, "Red component should be 255");
    }

    @Test
    public void testGreenComponent() {
        NameThatColor nameThatColor = new NameThatColor();
        float green = nameThatColor.green(0xFFA07A);  // hex value for "light salmon"
        assertEquals(160, green, "Green component should be 160");
    }

    @Test
    public void testBlueComponent() {
        NameThatColor nameThatColor = new NameThatColor();
        float blue = nameThatColor.blue(0xFFA07A);  // hex value for "light salmon"
        assertEquals(122, blue, "Blue component should be 122");
    }
}
