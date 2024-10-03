package com.marginallyclever.makelangelo.plotter.marlinsimulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.marginallyclever.makelangelo.plotter.plottersettings.PlotterSettings;
import com.marginallyclever.makelangelo.plotter.plottersettings.PlotterSettingsManager;
import com.marginallyclever.makelangelo.turtle.Turtle;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public  class MarlinSimulationTest {
    /**
     * Test multiple methods related to buffer operations and recalculate methods.
     * recalculateAcceleration();
     * recalculateBackwards();
     * recalculateForwards()
     */
    @Test
    void testBufferAndRecalculateMethods() {
        // Arrange
        MarlinSimulation marlinSimulation = new MarlinSimulation(PlotterSettingsManager.buildMakelangelo5());
        Vector3d vector = new Vector3d(2.0d, 3.0d, 10.0d);

        // Act: Testing bufferLine
        marlinSimulation.bufferLine(vector, 10.0d, 10.0d);
        marlinSimulation.bufferSegment(vector, 10.0d, 10.0d, vector);

        // Act: Testing recalculate methods
        marlinSimulation.recalculateAcceleration();
        marlinSimulation.recalculateBackwards();
        marlinSimulation.recalculateForwards();

        // Assert
        assertEquals(0.0d, marlinSimulation.estimateAccelerationDistance(10.0d, 10.0d, 10.0d));
        assertEquals(Double.NaN, marlinSimulation.maxSpeedAllowed(10.0d, 10.0d, 10.0d));
    }

    /**
     * Test recalculateBackwardsBetween and recalculateForwardsBetween methods.
     * recalculateBackwardsBetween
     * recalculateForwardsBetween
     */
    @Test
    void testRecalculateBetweenMethods() {
        // Arrange
        MarlinSimulation marlinSimulation = new MarlinSimulation(PlotterSettingsManager.buildMakelangelo5());
        Vector3d endPose = new Vector3d(2.0d, 3.0d, 10.0d);
        MarlinSimulationBlock current = new MarlinSimulationBlock(endPose, new Vector3d(2.0d, 3.0d, 10.0d));

        // Act: Recalculate backwards between two blocks
        marlinSimulation.recalculateBackwardsBetween(current,
                new MarlinSimulationBlock(endPose, new Vector3d(2.0d, 3.0d, 10.0d)));

        // Assert: Backwards recalculation
        assertEquals(0.0d, current.entrySpeed);
        assertTrue(current.recalculate);

        // Act: Recalculate forwards between two blocks
        marlinSimulation.recalculateForwardsBetween(null, current);

        // Assert: Forwards recalculation
        assertEquals(0.0d, current.start.getX());
        assertEquals(0.0d, current.accelerateUntilD);
        assertEquals(0.0d, current.accelerateUntilT);
        assertEquals(0.0d, current.acceleration);
        assertEquals(0.0d, current.allowableSpeed);
        assertEquals(0.0d, current.decelerateAfterD);
        assertEquals(0.0d, current.decelerateAfterT);
        assertEquals(0.0d, current.end_s);
        assertEquals(0.0d, current.entrySpeed);
        assertEquals(0.0d, current.entrySpeedMax);
        assertEquals(0.0d, current.exitSpeed);
        assertEquals(0.0d, current.feedrate);
        assertEquals(0.0d, current.nominalSpeed);
        assertEquals(0.0d, current.plateauD);
        assertEquals(0.18814417367671946d, current.normal.getX());
        assertEquals(10.63014581273465d, current.distance);
        assertEquals(2.0d, current.delta.getX());
        assertEquals(2.0d, current.end.getX());
        assertFalse(current.busy);
        assertFalse(current.nominalLength);
        assertTrue(current.recalculate);
    }

    /**
     * Method under test:
     * maxSpeedAllowed()
     */
    @Test
    void testMaxSpeedAllowed() {
        // Arrange
        MarlinSimulation marlinSimulation = new MarlinSimulation(PlotterSettingsManager.buildMakelangelo5());

        // Act and Assert
        assertEquals(Double.NaN, marlinSimulation.maxSpeedAllowed(10.0d, 10.0d, 10.0d));
        assertEquals(7.745966692414834d, marlinSimulation.maxSpeedAllowed(2.0d, 10.0d, 10.0d));
        assertEquals(81.24038404635961d, marlinSimulation.maxSpeedAllowed(-325.0d, 10.0d, 10.0d));
        assertEquals(9.486832980505138d, marlinSimulation.maxSpeedAllowed(0.5d, 10.0d, 10.0d));
    }

    /**
     * Method under test:
     * estimateAccelerationDistance()
     */
    @Test
    void testEstimateAccelerationDistance() {
        // Arrange
        MarlinSimulation marlinSimulation = new MarlinSimulation(PlotterSettingsManager.buildMakelangelo5());

        // Act and Assert
        assertEquals(0.0d, marlinSimulation.estimateAccelerationDistance(10.0d, 10.0d, 10.0d));
        assertEquals(0.0d, marlinSimulation.estimateAccelerationDistance(10.0d, 10.0d, 0.0d));
        assertEquals(4.8d, marlinSimulation.estimateAccelerationDistance(2.0d, 10.0d, 10.0d));
        assertEquals(-5276.25d, marlinSimulation.estimateAccelerationDistance(-325.0d, 10.0d, 10.0d));
    }


    /**
     * Method under test:
     * intersectionDistance()
     * getTimeEstimate()
     */
    @Test
    void testIntersectionDistance() {
        // Arrange
        MarlinSimulation marlinSimulation = new MarlinSimulation(PlotterSettingsManager.buildMakelangelo5());
        marlinSimulation.historyAction(new Turtle(), mock(MarlinSimulation.SegmentFunction.class));

        // Act and Assert
        assertEquals(0.0d, marlinSimulation.getTimeEstimate(new Turtle()));
        assertEquals(5.0d, marlinSimulation.intersectionDistance(10.0d, 10.0d, 10.0d, 10.0d));
    }

    /**
     * Method under test:
     * marlinSimulation(PlotterSettings)
     */
    @Test
    void testNewMarlinSimulation() {
        // Arrange and Act
        MarlinSimulation actualMarlinSimulation = new MarlinSimulation(PlotterSettingsManager.buildMakelangelo5());

        // Assert
        assertEquals(0.0d, actualMarlinSimulation.estimateAccelerationDistance(10.0d, 10.0d, 10.0d));
        assertEquals(Double.NaN, actualMarlinSimulation.maxSpeedAllowed(10.0d, 10.0d, 10.0d));
    }
}
