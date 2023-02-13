package com.isaakkrut.elocalculator.services;

import com.isaakkrut.elocalculator.model.Match;
import com.isaakkrut.elocalculator.model.Tournament;
import com.isaakkrut.elocalculator.utils.Result;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {
    @Override
    public void calculateElo(Match match) {
        double expectedScore = 1/(1+Math.pow(10, (match.getPlayer2().getElo() - match.getPlayer1().getElo())/400.0));
        double pointsWon = (match.getResult() == Result.WIN ? 1 : 0) - expectedScore;
        match.setPointsWon(pointsWon);
    }

    @Override
    public void setAverageOpponentElo(Tournament tournament) {
        int totalOpponentElo = tournament.getMatches().stream().mapToInt(match->match.getPlayer2().getElo()).sum();
        double averageOpponentElo = (totalOpponentElo *1.0) / tournament.getMatches().size();
        tournament.setAverageElo(averageOpponentElo);
    }


}
