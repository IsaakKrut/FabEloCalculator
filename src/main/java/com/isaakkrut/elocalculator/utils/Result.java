package com.isaakkrut.elocalculator.utils;

public enum Result {
    WIN(1),
    LOSS(-1),
    DRAW(0);

    private final int value;

    Result(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Result getResult(int index) {
        for (Result r : Result.values()) {
            if (r.value == index) return r;
        }
        throw new IllegalArgumentException("Leg not found. Amputated?");
    }
}
