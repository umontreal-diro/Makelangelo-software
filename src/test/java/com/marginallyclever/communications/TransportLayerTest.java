package com.marginallyclever.communications;

import com.marginallyclever.communications.dummy.DummyTransportLayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransportLayerTest {

    private DummyTransportLayer transportLayer;

    @BeforeEach
    public void setUp() {
        transportLayer = new DummyTransportLayer();
    }

    @Test
    public void testOpenConnection() {
        Configuration config = new Configuration(transportLayer, "dummy");
        NetworkSession session = transportLayer.openConnection(config);
        assertNotNull(session, "NetworkSession should not be null");
        assertEquals("dummy", session.getName(), "Session name should be 'dummy'");
    }

    @Test
    public void testListConnections() {
        List<String> connections = transportLayer.listConnections();
        assertEquals(List.of("dummy"), connections, "Connections should match the expected list");
    }
}