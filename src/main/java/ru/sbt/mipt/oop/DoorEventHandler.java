package ru.sbt.mipt.oop;

import java.util.Iterator;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class DoorEventHandler implements EventHandler{
    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        Iterator roomIter = smartHome.getRoomsIterator();
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            // событие от двери
//
            while (roomIter.hasNext()) {
                Room room = (Room)roomIter.next();
                Iterator doorIter = room.getDoorsIterator();
                while (doorIter.hasNext()) {
                    Door door = (Door)doorIter.next();
                    if (door.getId().equals(event.getObjectId())) {
                        if (event.getType() == DOOR_OPEN) {
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                        } else {
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                            // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                            // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                            if (room.getName().equals("hall")) {
                                Iterator roomIter2 = smartHome.getRoomsIterator();
                                while (roomIter2.hasNext()) {
                                    Room homeRoom = (Room)roomIter2.next();
                                    Iterator lightIter = homeRoom.getLightsIterator();
                                    while (lightIter.hasNext()) {
                                        Light light = (Light)lightIter.next();
                                        light.setOn(false);
                                        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                        ProcessingEvents.sendCommand(command);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
