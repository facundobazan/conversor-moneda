package model;

import java.util.Arrays;
import java.util.List;

public enum Divisa {
    ARS,
    EUR,
    GBP,
    JPY,
    KRW,
    USD;

    public String getValue(Divisa value){
        switch (value.ordinal()){
            case 0:
                return "Peso Argentino";
            case 1:
                return "Euro";
            case 2:
                return "Libra Esterlina";
            case 3:
                return "Yen";
            case 4:
                return "Won";
            case 5:
                return "Dolar Estadounidense";
            default:
                return null;
        }
    }

    public Divisa getDivisa(Integer value){
        switch (value){
            case 0:
                return Divisa.ARS;
            case 1:
                return Divisa.EUR;
            case 2:
                return Divisa.GBP;
            case 3:
                return Divisa.JPY;
            case 4:
                return Divisa.KRW;
            case 5:
                return Divisa.USD;
            default:
                return null;
        }
    }

    public Divisa getDivisa(String string){
        switch (string){
            case "Peso Argentino":
                return Divisa.ARS;
            case "Euro":
                return Divisa.EUR;
            case "Libra Esterlina":
                return Divisa.GBP;
            case "Yen":
                return Divisa.JPY;
            case "Won":
                return Divisa.KRW;
            case "Dolar Estadounidense":
                return Divisa.USD;
            default:
                return null;
        }
    }
}
