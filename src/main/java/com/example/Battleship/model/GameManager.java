package com.example.Battleship.model;

public class GameManager {

    public static final String ATTR = "manager";
    private Game pending;

    public synchronized Game join(Player player) {

        Game result;
        if (pending ==null) {
            pending = new Game(player);
            result = pending;
        } else {
            result = pending;
            pending = null;
            result.start(player);
        }
        return result;
    }
}
