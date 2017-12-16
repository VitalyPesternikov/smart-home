package ru.sbt.mipt.oop;

/**
 * Created by Vitaly on 16.12.2017.
 */
public class AlarmSystem {
    private AlarmSystemState alarmSystemState;

    public AlarmSystem(){
        this.alarmSystemState = new AlarmSystemOff(this);
    }

    public void turnOn(){
        alarmSystemState.turnOn();
    }
    public void enterPassword(String password){
        alarmSystemState.enterPassword(password);
    }
    public void onSensorEvent(SensorEvent event){
        alarmSystemState.onSensorEvent(event);
    }
    public void turnOff(){
        alarmSystemState.turnOff();
    }

    public StatesOfAlarmSystem getSystemState(){
        return alarmSystemState.getState();
    }

    public void setAlarmSystemState(AlarmSystemState alarmSystemState) {
        this.alarmSystemState = alarmSystemState;
    }
}
