package services;

import api.ExchangerateApi;
import model.CurrencyEnum;

import java.io.IOException;

public class ConverterService {
    public Double converterCurrencies(Double value, CurrencyEnum sourceCurrency, CurrencyEnum targetCurrency) throws IOException {
        ExchangerateApi exchangerateApi = new ExchangerateApi();

        return exchangerateApi.getConvertion(value, sourceCurrency, targetCurrency);
    }

    public Double celsiusToFahrenheit(Double celsiusDegrees) {
        return celsiusDegrees * 1.8 + 32;
    }

    public Double fahrenheitToCelsius(Double fahrenheitDegrees) {
        return (fahrenheitDegrees - 32) / 1.8;
    }

    public Double millimetersToCentimeters(Double value) {
        return value * 0.1;
    }

    public Double centimetersToMillimeters(Double value) {
        return value / 0.1;
    }

    public Double centimetersToMeters(Double value) {
        return value * 0.01;
    }

    public Double metersToCentimeters(Double value) {
        return value / 0.01;
    }

    public Double centimetersToInches(Double value) {
        return value / 2.54;
    }

    public Double inchesToCentimeters(Double value) {
        return value * 2.54;
    }

    public Double metersToFeet(Double value) {
        return value * 3.281;
    }

    public Double feetToMeters(Double value) {
        return value / 3.281;
    }
}
