package ru.sbt.mipt.oop;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class AlarmSystemOn implements AlarmSystemState {
    private final AlarmSystem alarmSystem;

    public AlarmSystemOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void enterPassword(String password) {

    }

    @Override
    public void onSensorEvent(SensorEvent event) {
        alarmSystem.setAlarmSystemState(new AlarmSystemAlarm(alarmSystem));
    }

    @Override
    public void turnOff() {
        alarmSystem.setAlarmSystemState(new AlarmSystemWaitForPW(alarmSystem));

    }

    @Override
    public StatesOfAlarmSystem getState() {
        return StatesOfAlarmSystem.ON;
    }
}
