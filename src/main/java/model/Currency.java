package model;

public class Currency {
    private CurrencyEnum abbreviation;
    private String currencyName;

    public Currency() {

    }

    public Currency(String currencyName, CurrencyEnum abbreviation) {
        setCurrencyName(currencyName);
        setAbbreviation(abbreviation);
    }

    public Currency(String currencyName, String abbreviation) {
        setCurrencyName(currencyName);
        setAbbreviation(CurrencyEnum.valueOf(abbreviation));
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public CurrencyEnum getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(CurrencyEnum abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {

        return getCurrencyName() + " (" + getAbbreviation() + ")";
    }
}
