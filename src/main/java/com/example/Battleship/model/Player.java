package com.example.Battleship.model;

public class Player {

    public static final String ATTR = "player";
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
