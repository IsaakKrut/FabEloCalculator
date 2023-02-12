package com.isaakkrut.elocalculator.utils;

import com.isaakkrut.elocalculator.model.Match;
import com.isaakkrut.elocalculator.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Utils {


    public static String getFormatParameter(Format format){
        switch (format){
            case CONSTRUCTED -> {
                return "elo_cons";
            }
            case LIMITED -> {
                return "elo_lim";
            }
            default -> throw new IllegalArgumentException("Invalid Format Value");
        }
    }


    public static List<Match> processMatches(String input){
        List<Match> matches = new ArrayList<>();
        String[] matchStrings = input.split("\n");
        for (var matchString : matchStrings){
            String[] tokens = matchString.split("\t");
            if (!tokens[0].contains("Round") && !tokens[0].contains("Playoff") && tokens.length >= 4){
                Match match = new Match();
                Player player1 = new Player();
                Player player2 = new Player();
                player1.setName(tokens[1].replaceAll("\\(.*\\)", "").trim());
                player2.setName(tokens[2].replaceAll("\\(.*\\)", "").trim());
                match.setPlayer1(player1);
                match.setPlayer2(player2);
                if (tokens[3].contains("1")){
                    match.setResult(Result.WIN);
                }
                else if (tokens[3].contains("2")){
                    match.setResult(Result.LOSS);
                }
                else {
                    match.setResult(Result.DRAW);
                }
                matches.add(match);
            }

        }

        Player mainPlayer = new Player();
        if (matches.get(0).getPlayer1().getName().equals(matches.get(1).getPlayer1().getName()) ||
                matches.get(0).getPlayer1().getName().equals(matches.get(1).getPlayer2().getName())){
            mainPlayer.setName(matches.get(0).getPlayer1().getName());
        }
        else mainPlayer.setName(matches.get(0).getPlayer2().getName());

        matches.forEach(match -> {
            if (match.getPlayer1().getName().equals(mainPlayer.getName())){
                match.setPlayer1(mainPlayer);
            }
            else {
                match.setResult(Result.getResult(-match.getResult().getValue()));
                Player player2 = match.getPlayer1();
                match.setPlayer1(mainPlayer);
                match.setPlayer2(player2);
            }
        });
        return matches;
    }

}
