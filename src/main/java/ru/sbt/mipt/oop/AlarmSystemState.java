package ru.sbt.mipt.oop;

/**
 * Created by Vitaly on 16.12.2017.
 */
public interface AlarmSystemState {
    public void turnOn();
    public void enterPassword(String password);
    public void onSensorEvent(SensorEvent event);
    public void turnOff();

    public StatesOfAlarmSystem getState();
}
