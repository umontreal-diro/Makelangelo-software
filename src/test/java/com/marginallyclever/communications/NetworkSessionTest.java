package com.marginallyclever.communications;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NetworkSessionTest {

    private NetworkSession networkSession;
    private NetworkSessionListener mockListener;

    @BeforeEach
    public void setUp() {
        networkSession = new NetworkSession(); // Ensure this constructor initializes all necessary fields
        mockListener = mock(NetworkSessionListener.class);
        networkSession.addListener(mockListener);
    }

    @Test
    public void testSetNameAndGetName() {
        String expectedName = "TestSession";
        networkSession.setName(expectedName);
        assertEquals(expectedName, networkSession.getName(), "Name should match the one set");
    }

    @Test
    public void testAddAndRemoveListener() {
        NetworkSessionListener anotherListener = mock(NetworkSessionListener.class);
        networkSession.addListener(anotherListener);
        networkSession.removeListener(mockListener);
        networkSession.notifyDataReceived("Test data");
        verify(anotherListener, times(1)).networkSessionEvent(any(NetworkSessionEvent.class));
        verify(mockListener, never()).networkSessionEvent(any(NetworkSessionEvent.class));
    }

    @Test
    public void testNotifyDataReceived() {
        String data = "Test data";
        networkSession.notifyDataReceived(data);
        verify(mockListener, times(1)).networkSessionEvent(any(NetworkSessionEvent.class));
    }

    @Test
    public void testNotifyDataSent() {
        String data = "Test data";
        networkSession.notifyDataSent(data);
        verify(mockListener, times(1)).networkSessionEvent(any(NetworkSessionEvent.class));
    }
}