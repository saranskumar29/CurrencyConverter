
package com.ty.currencyconverter.controller;

import com.ty.currencyconverter.model.ConvertRequest;
import com.ty.currencyconverter.model.ConvertResponse;
import com.ty.currencyconverter.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/rates")
    public Map<String, Double> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        return currencyService.getExchangeRates(base);
    }

    @PostMapping("/convert")
    public ConvertResponse convertCurrency(@RequestBody ConvertRequest request) {
        double convertedAmount = currencyService.convertCurrency(request.getFrom(), request.getTo(), request.getAmount());
        return new ConvertResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
    }
}
