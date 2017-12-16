package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by Vitaly on 12.10.2017.
 */
public class ProcessingEvents {
    SensorEvent event = ReadingEvent.getNextSensorEvent();
    SmartHome smartHome;

    public ProcessingEvents(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void process() {
        SensorEventObserver sensorEventObserver = new SensorEventObserver();
        sensorEventObserver.addEventHandler(new LightEventHandler());
        sensorEventObserver.addEventHandler(new DoorEventHandler());
        sensorEventObserver.addEventHandler(new DoorScenarioRunner());

        while (event != null) {
            System.out.println("Got event: " + event);
            sensorEventObserver.handle(smartHome, event);
            event = ReadingEvent.getNextSensorEvent();
        }
    }

    static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
