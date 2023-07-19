package model;

public class Currency {
    //https://app.exchangerate-api.com/dashboard
    //Your API Key: ea36d1f082c9891cf9f157cd
    //Example Request: https://v6.exchangerate-api.com/v6/ea36d1f082c9891cf9f157cd/latest/USD

    private String country;
    private String abbreviation;
    private String currencyName;
    private String code;
    private byte[] flag;
    private Double price;

    public Currency() {

    }

    public Currency(String country, String abbreviation, String currencyName, Double price) {
        setCountry(country);
        setAbbreviation(abbreviation);
        setCurrencyName(currencyName);
        setPrice(price);
    }

    public Currency(String country, String abbreviation, String currencyName, byte[] flag, Double price) {
        setCountry(country);
        setAbbreviation(abbreviation);
        setCurrencyName(currencyName);
        setFlag(flag);
        setPrice(price);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getFlag() {
        return flag;
    }

    public void setFlag(byte[] flag) {
        this.flag = flag;
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
        sb.append("->").append(country).append(" - ").append(currencyName).append(" ")
                .append("(").append(abbreviation).append(") - code: ").append(code);

        return sb.toString().toUpperCase();
    }
}
