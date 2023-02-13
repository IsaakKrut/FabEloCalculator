package com.isaakkrut.elocalculator.services;

import com.isaakkrut.elocalculator.dto.Request;
import com.isaakkrut.elocalculator.model.Match;
import com.isaakkrut.elocalculator.model.Tournament;
import com.isaakkrut.elocalculator.utils.Format;
import com.isaakkrut.elocalculator.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class EloServiceImpl implements EloService {

    String BASE_URL = "https://fabtcg.com/leaderboards/";
    private final CalculationService calculationService;
    private final HttpService httpService;

    public EloServiceImpl(CalculationService calculationService, HttpService httpService) {
        this.calculationService = calculationService;
        this.httpService = httpService;
    }

    @Override
    public int getEloByName(String name, Format format) {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("mode", Utils.getFormatParameter(format));
        parameters.put("query", name);

        return httpService.getResponse(BASE_URL, parameters);
    }

    @Override
    public Tournament calculateElo(Request request) {
        Tournament tournament = new Tournament();
        tournament.setkFactor(request.getkFactor());
        tournament.setFormat(Format.getFormat(request.getFormat()));
        tournament.setMatches(Utils.processMatches(request.getMatches()));
        tournament.setPlayer(tournament.getMatches().get(0).getPlayer1());
        tournament.getMatches().forEach(match -> {
            if (match.getPlayer1().getElo() == null){
                match.getPlayer1().setElo(getEloByName(match.getPlayer1().getName(), tournament.getFormat()));
            }
            if (match.getPlayer2().getElo() == null){
                match.getPlayer2().setElo(getEloByName(match.getPlayer2().getName(), tournament.getFormat()));
            }
            calculationService.calculateElo(match);
        });
        tournament.setPointsWon(tournament.getMatches().stream().mapToDouble(Match::getPointsWon).sum()*tournament.getkFactor());
        calculationService.setAverageOpponentElo(tournament);
        return tournament;
    }
}
