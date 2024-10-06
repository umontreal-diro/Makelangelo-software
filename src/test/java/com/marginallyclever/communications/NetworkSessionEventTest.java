package com.marginallyclever.communications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class NetworkSessionEventTest {

    @Test
    public void testNetworkSessionEventCreation() {
        Object source = new Object();
        int flag = NetworkSessionEvent.CONNECTION_OPENED;
        String data = "Test data";

        NetworkSessionEvent event = new NetworkSessionEvent(source, flag, data);

        assertSame(source, event.getSource(), "Source should be the same as the one provided");
        assertEquals(flag, event.flag, "Flag should match the one provided");
        assertEquals(data, event.data, "Data should match the one provided");
    }

    @Test
    public void testNetworkSessionEventFlags() {
        NetworkSessionEvent eventOpened = new NetworkSessionEvent(new Object(), NetworkSessionEvent.CONNECTION_OPENED, null);
        NetworkSessionEvent eventClosed = new NetworkSessionEvent(new Object(), NetworkSessionEvent.CONNECTION_CLOSED, null);
        NetworkSessionEvent eventError = new NetworkSessionEvent(new Object(), NetworkSessionEvent.CONNECTION_ERROR, null);

        assertEquals(NetworkSessionEvent.CONNECTION_OPENED, eventOpened.flag, "Flag should be CONNECTION_OPENED");
        assertEquals(NetworkSessionEvent.CONNECTION_CLOSED, eventClosed.flag, "Flag should be CONNECTION_CLOSED");
        assertEquals(NetworkSessionEvent.CONNECTION_ERROR, eventError.flag, "Flag should be CONNECTION_ERROR");
    }
}