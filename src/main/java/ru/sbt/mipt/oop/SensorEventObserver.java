package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class SensorEventObserver {
    private Collection<EventHandler> handlers = new ArrayList<>();

    public SensorEventObserver(Collection<EventHandler> handlers) {
        this.handlers = handlers;
    }

    public SensorEventObserver() {
    }

    public void addEventHandler(EventHandler eventHandler) {
        handlers.add(eventHandler);
    }

    public void handle(SmartHome smartHome, SensorEvent event) {
        for (EventHandler handler : handlers) {
            handler.handle(smartHome, event);
        }
    }
}
