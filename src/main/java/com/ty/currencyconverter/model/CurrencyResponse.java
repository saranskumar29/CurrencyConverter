package com.ty.currencyconverter.model;

import java.util.Map;

public class CurrencyResponse {
    private String base;
    private Map<String, Double> rates;

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}
