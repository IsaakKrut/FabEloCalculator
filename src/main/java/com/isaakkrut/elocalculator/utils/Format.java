package com.isaakkrut.elocalculator.utils;

public enum Format {
    CONSTRUCTED("Constructed"),
    LIMITED("Limited");

    private final String value;

    Format(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Format getFormat(String index) {
        for (Format f : Format.values()) {
            if (f.value.equals(index)) return f;
        }
        throw new IllegalArgumentException("Format Not Found: " + index);
    }

}
