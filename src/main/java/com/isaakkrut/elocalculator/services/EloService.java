package com.isaakkrut.elocalculator.services;

import com.isaakkrut.elocalculator.dto.Request;
import com.isaakkrut.elocalculator.model.Tournament;
import com.isaakkrut.elocalculator.utils.Format;

import java.io.IOException;

public interface EloService {

    int getEloByName(String name, Format format);

    Tournament calculateElo(Request request);
}
