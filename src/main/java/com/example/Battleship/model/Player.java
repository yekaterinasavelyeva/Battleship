package com.example.Battleship.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Player {

    public static final String ATTR = "player";
    private final String name;
    private final Map<String, CellStatus> playerField = new HashMap<>();
    private boolean playerFieldValid = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, CellStatus> getPlayerField() {
        return playerField;
    }

    public boolean isPlayerFieldValid() {
        return playerFieldValid;
    }

    public void setShips(Set<String> addresses) {
        if(playerFieldValid) {
            throw new IllegalStateException("Field is set already");
        }
        playerField.clear();
        for(var addr : addresses) {
            playerField.put(addr, CellStatus.SHIP);
        }
        playerFieldValid = playerField.size() > 3 && playerField.size() <= 20;
    }

}
