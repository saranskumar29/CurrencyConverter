package com.ty.currencyconverter.service;

import com.ty.currencyconverter.exception.CurrencyException;
import com.ty.currencyconverter.model.CurrencyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class CurrencyService {
    private final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public Map<String, Double> getExchangeRates(String base) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + base;
        CurrencyResponse response = restTemplate.getForObject(url, CurrencyResponse.class);
        if (response == null || response.getRates() == null) {
            throw new CurrencyException("Failed to fetch exchange rates.");
        }
        return response.getRates();
    }

    public double convertCurrency(String from, String to, double amount) {
        Map<String, Double> rates = getExchangeRates(from);
        if (!rates.containsKey(to)) {
            throw new CurrencyException("Invalid currency code: " + to);
        }
        return amount * rates.get(to);
    }
}
