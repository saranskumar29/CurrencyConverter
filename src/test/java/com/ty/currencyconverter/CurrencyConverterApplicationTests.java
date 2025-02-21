package com.ty.currencyconverter;

import com.ty.currencyconverter.exception.CurrencyException;
import com.ty.currencyconverter.service.CurrencyService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class CurrencyServiceTest {
    private final CurrencyService service = new CurrencyService();

    @Test
    void testFetchExchangeRates() {
        Map<String, Double> rates = service.getExchangeRates("USD");
        assertNotNull(rates);
        assertTrue(rates.containsKey("EUR"));
    }

    @Test
    void testConvertCurrency() {
        double result = service.convertCurrency("USD", "EUR", 100);
        assertTrue(result > 0);
    }

    @Test
    void testInvalidCurrency() {
        assertThrows(CurrencyException.class, () -> service.convertCurrency("USD", "XYZ", 100));
    }
}
