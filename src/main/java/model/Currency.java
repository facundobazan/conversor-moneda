package model;

public class Currency {
    //https://app.exchangerate-api.com/dashboard
    //Your API Key: ea36d1f082c9891cf9f157cd
    //Example Request: https://v6.exchangerate-api.com/v6/ea36d1f082c9891cf9f157cd/latest/USD
    private String abbreviation;
    private String currencyName;
    private Double price;

    public Currency() {

    }

    public Currency(String currencyName, String abbreviation) {
        setCurrencyName(currencyName);
        setAbbreviation(abbreviation);
    }

    public Currency(String currencyName, String abbreviation, Double price) {
        setCurrencyName(currencyName);
        setAbbreviation(abbreviation);
        setPrice(price);
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrencyName()).append(" (").append(getAbbreviation()).append(")");

        return sb.toString().toUpperCase();
    }
}
