package services;

import model.Currency;
import model.CurrencyEnum;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CurrencyService {
    private final ArrayList<Currency> currencies = new ArrayList<>();

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
            Currency currency = new Currency(sc.next(), CurrencyEnum.valueOf(sc.next()));
            currencies.add(currency);
        }
    }

    public Currency[] getArrayCurrencies(){
        return this.currencies.toArray(new Currency[0]);
    }
}
