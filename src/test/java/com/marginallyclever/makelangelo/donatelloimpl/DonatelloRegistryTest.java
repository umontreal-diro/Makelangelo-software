package com.marginallyclever.makelangelo.donatelloimpl;

import com.marginallyclever.nodegraphcore.DAO4JSONFactory;
import com.marginallyclever.nodegraphcore.NodeFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DonatelloRegistryTest {
    private static final Logger logger = LoggerFactory.getLogger(DonatelloRegistryTest.class);

    @BeforeAll
    public static void beforeAll() {
        DonatelloRegistry registry = new DonatelloRegistry();
        registry.registerDAO();
        registry.registerNodes();
    }

    @Test
    public void testNodeFactoryRegistration() {
        assertNotEquals(0, NodeFactory.getNames().length, "NodeFactory should have registered nodes.");
        for (String nodeName : NodeFactory.getNames()) {
            logger.info("Registered node: " + nodeName);
            assertNotNull(NodeFactory.createNode(nodeName), "NodeFactory should create node: " + nodeName);
        }
    }

    @Test
    public void testDAOFactoryRegistration() {
        assertNotNull(DAO4JSONFactory.getDAO(Turtle.class), "DAO4JSONFactory should have registered Turtle DAO.");
    }
}
