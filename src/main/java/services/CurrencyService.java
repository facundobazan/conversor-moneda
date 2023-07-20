package services;

import model.Currency;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CurrencyService {
    private ArrayList<Currency> currencies = new ArrayList<>();

    public CurrencyService() {
        try {
            loadCurrencies();
        } catch (IOException e) {
            System.out.print("NO SE PUDO CARGAR EL ARCHIVO.\nERROR: ");
            System.out.print(e.getMessage());
        }
    }

    private void loadCurrencies() throws IOException {
        Path currencyFile = Paths.get("./resources/currency");
        //System.out.println(Paths.get("resources/currency").toAbsolutePath());
        Scanner sc = new Scanner(currencyFile, StandardCharsets.UTF_8);
        sc.useDelimiter("[,;\\t\\n\\r]+");

        while (sc.hasNext()){
            Currency currency = new Currency(sc.next(), sc.next());
            currencies.add(currency);
        }
    }

    public ArrayList<Currency> getCurrencies(){
        return this.currencies;
    }

    public Currency getCurrencyByAbbreviation(String abbreviation){
        return (Currency) this.currencies.stream()
                .filter(currency -> currency.getAbbreviation() == abbreviation);
    }

    public Currency getCurrencyByName(String currencyName){
        return (Currency) this.currencies.stream()
                .filter(currency -> currency.getCurrencyName() == currencyName);
    }
}
