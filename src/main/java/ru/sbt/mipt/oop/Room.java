package ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Iterator;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }


    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Light light: lights)
            light.executeAction(action);
        for (Door door: doors)
            door.executeAction(action);
    }

    public Iterator getLightsIterator() {
        return lights.iterator();
    }

    public Iterator getDoorsIterator() {
        return doors.iterator();
    }
}
