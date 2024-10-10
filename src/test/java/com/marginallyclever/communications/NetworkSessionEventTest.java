package com.marginallyclever.communications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class NetworkSessionEventTest {

    @Test
    public void testNetworkSessionEventCreation() {
        /*
        Motivations: On veut s'assurer qu'il n'y a pas de souci lors de l'initialisation
        d'un objet 'NetworkSessionEvent()', et que les arguments passés à l'initialisation
        sont bien ceux que l'on retrouve dans l'objet en soi.
         */
        // Arrange
        Object source = new Object();
        int flag = NetworkSessionEvent.CONNECTION_OPENED;
        String data = "Test data";

        // Act
        NetworkSessionEvent event = new NetworkSessionEvent(source, flag, data);

        // Assert
        assertSame(source, event.getSource(), "Source should be the same as the one provided");
        assertEquals(flag, event.flag, "Flag should match the one provided");
        assertEquals(data, event.data, "Data should match the one provided");
    }

    @Test
    public void testNetworkSessionEventFlags() {
        /*
        Motivations: Les motivations ressemblent à celles du test précédent. Ici, on veut
        s'assurer que chaque valeur possible d'un flag se retransmette correctement dans
        l'objet lors de l'initialisation.
         */
        // Arrange and Act
        NetworkSessionEvent eventOpened = new NetworkSessionEvent(new Object(), NetworkSessionEvent.CONNECTION_OPENED, null);
        NetworkSessionEvent eventClosed = new NetworkSessionEvent(new Object(), NetworkSessionEvent.CONNECTION_CLOSED, null);
        NetworkSessionEvent eventError = new NetworkSessionEvent(new Object(), NetworkSessionEvent.CONNECTION_ERROR, null);

        // Assert
        assertEquals(NetworkSessionEvent.CONNECTION_OPENED, eventOpened.flag, "Flag should be CONNECTION_OPENED");
        assertEquals(NetworkSessionEvent.CONNECTION_CLOSED, eventClosed.flag, "Flag should be CONNECTION_CLOSED");
        assertEquals(NetworkSessionEvent.CONNECTION_ERROR, eventError.flag, "Flag should be CONNECTION_ERROR");
    }
}