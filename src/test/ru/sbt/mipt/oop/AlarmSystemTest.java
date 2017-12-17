package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vitaly on 17.12.2017.
 */
public class AlarmSystemTest {

    @Test
    public void testCreationState(){
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
    }

    @Test
    public void testOffTurnOn(){
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
        alarmSystem.turnOn();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ON);
    }

    @Test
    public void testOffEnterPass(){
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
        alarmSystem.enterPassword("wer");
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
    }

    @Test
    public void testOffOnSensEv(){
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED,"1");
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
        alarmSystem.onSensorEvent(event);
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
    }

    @Test
    public void testOffTurnOff(){
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
        alarmSystem.turnOff();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
    }

    @Test
    public void testOnTurnOn(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ON);
        alarmSystem.turnOn();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ON);
    }

    @Test
    public void testOnEnterPass(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ON);
        alarmSystem.enterPassword("qwe");
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ON);
    }

    @Test
    public void testOnOnSenEv(){
        AlarmSystem alarmSystem = new AlarmSystem();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED,"1");
        alarmSystem.turnOn();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ON);
        alarmSystem.onSensorEvent(event);
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
    }

    @Test
    public void testOnTurnOff(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ON);
        alarmSystem.turnOff();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
    }

    @Test
    public void testWaitForPassTurnOn(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemWaitForPW(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
        alarmSystem.turnOn();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
    }

    @Test
    public void testWaitForPassEnterWrongPass(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemWaitForPW(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
        alarmSystem.enterPassword("qwe");
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
    }

    @Test
    public void testWaitForPassEnterRightPass(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemWaitForPW(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
        alarmSystem.enterPassword("PassWord");
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
    }

    @Test
    public void testWaitForPassOnSensEv(){
        AlarmSystem alarmSystem = new AlarmSystem();
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED,"1");
        alarmSystem.setAlarmSystemState(new AlarmSystemWaitForPW(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
        alarmSystem.onSensorEvent(event);
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
    }

    @Test
    public void testWaitForPassTurnOff(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemWaitForPW(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
        alarmSystem.turnOff();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.WAIT_FOR_PASSWORD);
    }

    @Test
    public void testAlarmTurnOn(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemAlarm(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
        alarmSystem.turnOn();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
    }

    @Test
    public void testAlarmEnterWrongPass(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemAlarm(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
        alarmSystem.enterPassword("qwe");
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
    }

    @Test
    public void testAlarmEnterRightPass(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemAlarm(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
        alarmSystem.enterPassword("PassWord");
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.OFF);
    }

    @Test
    public void testAlarmOnSensEv(){
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED,"1");
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemAlarm(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
        alarmSystem.onSensorEvent(event);
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
    }

    @Test
    public void testAlarmTurnOff(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemAlarm(alarmSystem));
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
        alarmSystem.turnOff();
        assertEquals(alarmSystem.getSystemState(),StatesOfAlarmSystem.ALARM);
    }
}