package ru.sbt.mipt.oop;

import java.util.Iterator;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class DoorScenarioRunner implements EventHandler {
    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        Iterator roomIter = smartHome.getRoomsIterator();
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            // событие от двери
            while (roomIter.hasNext()) {
                Room room = (Room)roomIter.next();
                Iterator doorIter = room.getDoorsIterator();
                while (doorIter.hasNext()) {
                    Door door = (Door)doorIter.next();
                    if (door.getId().equals(event.getObjectId()) && door.getId().equals("4")) {
                        if (event.getType() == SensorEventType.DOOR_CLOSED) {
                            makeDoorsAndLightsOn(smartHome, false);
                        } else {
                            makeDoorsAndLightsOn(smartHome, true);
                        }
                    }
                }
            }
        }
    }

    private void makeDoorsAndLightsOn(SmartHome smartHome, boolean b) {
        Iterator roomIter = smartHome.getRoomsIterator();
        while (roomIter.hasNext()) {
            Room room = (Room)roomIter.next();
            Iterator doorIter = room.getDoorsIterator();
            Iterator lightIter = room.getLightsIterator();
            while (doorIter.hasNext()) {
                Door door = (Door)doorIter.next();
                door.setOpen(b);
            }
            while (lightIter.hasNext()) {
                Light light = (Light)lightIter.next();
                light.setOn(b);
            }
        }
    }
}




