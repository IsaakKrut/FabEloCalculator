package com.isaakkrut.elocalculator.services;

import java.util.Map;

public interface HttpService {

    public int getResponse(String url, Map<String, String> parameters);
}
