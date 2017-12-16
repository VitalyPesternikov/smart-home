package ru.sbt.mipt.oop;

public class Door {
    private final String id;
    private boolean isOpen;
    private Room room;

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Room getRoom() {
        return room;
    }
}
