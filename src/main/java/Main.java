import api.ExchangerateApi;
import model.Currency;
import services.CurrencyService;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static CurrencyService currencyService = new CurrencyService();
    private static ExchangerateApi exchangerateApi;

    static {
        try {
            exchangerateApi = new ExchangerateApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MainForm mf = new MainForm();
        mf.setContentPane(new MainForm().panel);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setResizable(false);


        mf.setVisible(true);
        mf.pack();

        ArrayList<Currency> currencies = currencyService.getCurrencies();

        for (Currency currency: currencies){
            System.out.println(currency);
        }

        try {
            Double result = exchangerateApi.getConvertion(1.0,"USD","ARS");
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
