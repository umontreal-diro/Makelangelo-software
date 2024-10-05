package com.marginallyclever.convenience;

import com.marginallyclever.convenience.helpers.StringHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringHelper {
    @Test
    public void testPaddedHex() {
        assertEquals("000001", StringHelper.paddedHex(0x1));
        assertEquals("0007ff",StringHelper.paddedHex(0x7ff));
        assertEquals("100001",StringHelper.paddedHex(0x100001));
        assertEquals("1000001",StringHelper.paddedHex(0x1000001));
        assertEquals("100000",StringHelper.paddedHex(0x100000));
    }
    @Test
    public void testFormatFloat_withPositiveNumber() {
        // Arrange: Create a positive float number
        float input = 123.4567f;

        // Act: Format the float using formatFloat method
        String result = StringHelper.formatFloat(input);

        // Assert: Verify that the output is formatted to three decimal places in US locale
        assertEquals("123.457", result);
    }
}
