package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class SensorEventObserverTest {
    @Test
    public void test() {
        SmartHome smartHome = mock(SmartHome.class);
        LightEventHandler lightEventHandler = mock(LightEventHandler.class);
        DoorEventHandler doorEventHandler = mock(DoorEventHandler.class);
        DoorScenarioRunner doorScenarioRunner = mock(DoorScenarioRunner.class);

        SensorEventObserver sensorEventObserver = new SensorEventObserver();
        sensorEventObserver.addEventHandler(lightEventHandler);
        sensorEventObserver.addEventHandler(doorEventHandler);
        sensorEventObserver.addEventHandler(doorScenarioRunner);

        SensorEvent sensorEvent = mock(SensorEvent.class);
        sensorEventObserver.handle(smartHome, sensorEvent);

        verify(lightEventHandler).handle(smartHome, sensorEvent);
        verify(doorEventHandler).handle(smartHome, sensorEvent);
        verify(doorScenarioRunner).handle(smartHome, sensorEvent);
    }
}