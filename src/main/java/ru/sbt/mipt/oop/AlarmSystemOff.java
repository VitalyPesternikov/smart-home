package ru.sbt.mipt.oop;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class AlarmSystemOff implements AlarmSystemState {
    private final AlarmSystem alarmSystem;

    public AlarmSystemOff(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
        alarmSystem.setAlarmSystemState(new AlarmSystemOn(alarmSystem));
    }

    @Override
    public void enterPassword(String password) {

    }

    @Override
    public void onSensorEvent(SensorEvent event) {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public StatesOfAlarmSystem getState() {
        return StatesOfAlarmSystem.OFF;
    }
}
