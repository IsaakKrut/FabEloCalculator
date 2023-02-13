package com.isaakkrut.elocalculator.dto;

import com.isaakkrut.elocalculator.utils.Format;

public class Request {
    private String matches;
    private int kFactor;
    private String format;

    public Request() {
    }

    public Request(String matches, int kFactor, String format) {
        this.matches = matches;
        this.kFactor = kFactor;
        this.format = format;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public int getkFactor() {
        return kFactor;
    }

    public void setkFactor(int kFactor) {
        this.kFactor = kFactor;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Request{" +
                "matches='" + matches + '\'' +
                ", kFactor=" + kFactor +
                ", format='" + format + '\'' +
                '}';
    }
}
