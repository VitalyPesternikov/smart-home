package ru.sbt.mipt.oop;

/**
 * Created by Vitaly on 16.12.2017.
 */
public interface EventHandler {
    void handle(SmartHome smartHome, SensorEvent event);
}
