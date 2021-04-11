package com.example.Battleship.model;

public class GameManager {

    public static final String ATTR = "manager";
    private Game pending;

    public synchronized Game join(Player player) {

        Game result;
        if (pending == null) {
            pending = new Game(player);
            result = pending;
        } else {
            result = pending;
            pending = null;
            result.start(player);
        }
        return result;
    }

    public synchronized void surrender(Game game, Player player) {
        if(game.getStatus() != GameStatus.FINISHED) {
            return;
        }
        game.surrender(player);
    }
}
