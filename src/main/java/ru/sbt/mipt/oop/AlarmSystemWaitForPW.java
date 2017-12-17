package ru.sbt.mipt.oop;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class AlarmSystemWaitForPW implements AlarmSystemState {
    private final AlarmSystem alarmSystem;

    public AlarmSystemWaitForPW(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void enterPassword(String password) {
        if (password.equals("PassWord")) alarmSystem.setAlarmSystemState(new AlarmSystemOff(alarmSystem));
        else alarmSystem.setAlarmSystemState(new AlarmSystemAlarm(alarmSystem));
    }

    @Override
    public void onSensorEvent(SensorEvent event) {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public StatesOfAlarmSystem getState() {
        return StatesOfAlarmSystem.WAIT_FOR_PASSWORD;
    }
}
