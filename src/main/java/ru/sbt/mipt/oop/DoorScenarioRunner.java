package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class DoorScenarioRunner implements EventHandler {
    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            // событие от двери
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId()) && door.getRoom().getName().equals("hall")) {
                        if (event.getType() == SensorEventType.DOOR_CLOSED) {
                            makeDoorsAndLights(smartHome, false);
                        } else {
                            makeDoorsAndLights(smartHome, true);
                        }
                    }
                }
            }
        }
    }

    private void makeDoorsAndLights(SmartHome smartHome, boolean b) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                door.setOpen(b);
            }
            for (Light light : room.getLights()) {
                light.setOn(b);
            }
        }
    }
}




