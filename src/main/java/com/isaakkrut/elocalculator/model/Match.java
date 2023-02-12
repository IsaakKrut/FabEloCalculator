package com.isaakkrut.elocalculator.model;

import com.isaakkrut.elocalculator.utils.Result;

public class Match {
    private Player player1;
    private Player player2;
    private Result result;
    private double pointsWon;

    public Match() {
    }

    public Match(Player player1, Player player2, Result result, double pointsWon) {
        this.player1 = player1;
        this.player2 = player2;
        this.result = result;
        this.pointsWon = pointsWon;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public double getPointsWon() {
        return pointsWon;
    }

    public void setPointsWon(double pointsWon) {
        this.pointsWon = pointsWon;
    }
}
