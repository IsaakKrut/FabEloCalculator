package com.isaakkrut.elocalculator.model;

import com.isaakkrut.elocalculator.utils.Format;

import java.util.List;

public class Tournament {

    private int kFactor;
    List<Match> matches;
    private Player player;
    Format format;
    Double pointsWon;
    Double averageElo;

    public Double getAverageElo() {
        return averageElo;
    }

    public void setAverageElo(Double averageElo) {
        this.averageElo = averageElo;
    }

    public Double getPointsWon() {
        return pointsWon;
    }

    public void setPointsWon(Double pointsWon) {
        this.pointsWon = pointsWon;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Tournament() {
    }

    public Tournament(int kFactor, List<Match> matches, Player player, Format format) {
        this.kFactor = kFactor;
        this.matches = matches;
        this.player = player;
        this.format = format;
    }

    public int getkFactor() {
        return kFactor;
    }

    public void setkFactor(int kFactor) {
        this.kFactor = kFactor;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
