package com.isaakkrut.elocalculator.services;

import com.isaakkrut.elocalculator.model.Match;
import com.isaakkrut.elocalculator.model.Tournament;

public interface CalculationService {

    public void calculateElo(Match match);

    public void setAverageOpponentElo(Tournament tournament);
}
