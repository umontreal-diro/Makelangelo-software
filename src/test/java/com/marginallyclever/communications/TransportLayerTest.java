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
        /*
        Motivations: Ici on veut s'assurer que la méthode '.openConnection()' de l'objet
        'DummmyTransportLayer' ait le comportement attendu, c'est à dire ouvrir une session
        avec le nom attendu de la configuration passé en entrée.
         */
        // Arrange
        Configuration config = new Configuration(transportLayer, "dummy");

        // Act
        NetworkSession session = transportLayer.openConnection(config);

        // Assert
        assertNotNull(session, "NetworkSession should not be null");
        assertEquals("dummy", session.getName(), "Session name should be 'dummy'");
    }

    @Test
    public void testListConnections() {
        /*
        Motivations: On veut vérifier qu'on puisse bien récupérer l'information des sessions
        encore actives avec 'listConnections()'. On utilise le test précédent en tant
        qu'arrange, et le test devrait vérifier que le nom de la session initialisée
        précédemment est bien récupérable.
         */
        // Arrange - le test précédent fait office d'arrange
        // Act
        List<String> connections = transportLayer.listConnections();

        // Assert
        assertEquals(List.of("dummy"), connections, "Connections should match the expected list");
    }
}