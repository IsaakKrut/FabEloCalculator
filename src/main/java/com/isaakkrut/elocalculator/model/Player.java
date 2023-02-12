package com.isaakkrut.elocalculator.model;

public class Player {
    private String name;
    private Integer elo;

    public Player(String name, int elo) {
        this.name = name;
        this.elo = elo;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getElo() {
        return elo;
    }

    public void setElo(Integer elo) {
        this.elo = elo;
    }
}
