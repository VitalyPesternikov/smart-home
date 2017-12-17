package ru.sbt.mipt.oop;

import java.util.Iterator;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class LightEventHandler implements EventHandler {
    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        Iterator roomIter = smartHome.getRoomsIterator();
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                // событие от источника света
                while (roomIter.hasNext()) {
                    Room room = (Room)roomIter.next();
                    Iterator lightIter = room.getLightsIterator();
                    while (lightIter.hasNext()) {
                        Light light = (Light)lightIter.next();
                        if (light.getId().equals(event.getObjectId())) {
                            if (event.getType() == LIGHT_ON) {
                                light.setOn(true);
                                System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                            } else {
                                light.setOn(false);
                                System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                            }
                        }
                    }
                }
            }
    }
}
