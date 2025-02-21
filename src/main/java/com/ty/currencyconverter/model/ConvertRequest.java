package com.ty.currencyconverter.model;

public class ConvertRequest {
    private String from;
    private String to;
    private double amount;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
}
