package com.example.Battleship.model;

public class Record {

    private final int id;

    private final String name;

    private final long points;

    public Record(int id, String name, long points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPoints() {
        return points;
    }
}
