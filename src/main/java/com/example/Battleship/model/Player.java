package com.example.Battleship.model;

import java.util.*;

public class Player {

    public static final String ATTR = "player";
    private final String name;
    private Map<String, CellStatus> playerField = new HashMap<>();
    private Map<String, CellStatus> opponentView = new HashMap<>();
    private List<String> history = new ArrayList<>();
    private boolean playerFieldValid = false;

    public Player(String name) {
        this.name = name;
    }

    public void addHistory(Player player, String addr, boolean isHit) {
        String name = player == this ? "me" : player.getName();
        var result = isHit ? "hit": "miss";
        var msg = String.format("%s attacked %s: %s", name, addr, result);
        history.add(msg);
    }

    public String getName() {
        return name;
    }

    public Map<String, CellStatus> getPlayerField() {
        return playerField;
    }

    public Map<String, CellStatus> getOpponentView() {
        return opponentView;
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

    public void setPlayerFieldCell(String addr, CellStatus status) {
        playerField.put(addr, status);
    }

    public CellStatus getPlayerFieldCell(String addr) {
        return playerField.getOrDefault(addr, CellStatus.EMPTY);
    }

    public boolean hasMoreShips() {
        return playerField.containsValue(CellStatus.SHIP);
    }

    public void setOpponentViewCell(String addr, CellStatus status) {
        opponentView.put(addr, status);
    }

    public boolean hasShipsLeft() {
        return playerField.entrySet().stream().anyMatch(entry -> entry.getValue().equals(CellStatus.SHIP));
    }

    public List<String> getHistory() {
        return history;
    }

    public void reset() {
        playerField = new HashMap<>();
        opponentView = new HashMap<>();
        history = new ArrayList<>();
        playerFieldValid = false;
    }
}
