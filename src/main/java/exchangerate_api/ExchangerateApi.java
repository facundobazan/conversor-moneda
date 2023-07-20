package exchangerate_api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class ExchangerateApi {
    private String apiKey;
    private String url_str;

    public ExchangerateApi() throws IOException {
        Properties properties = new Properties();

        properties.load(new FileReader("./src/resources.properties"));

        apiKey = properties.getProperty("API-Key");
        url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";
    }

    public Double getConvertion(Double value, String sourceCurrency, String targetCurrency) throws IOException {
        URL url = new URL(url_str.concat(targetCurrency));
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject().get("conversion_rates").getAsJsonObject();

        Double result = jsonobj.get(sourceCurrency.toUpperCase()).getAsDouble();

        return value * result;

        //System.out.println(jsonobj.get("conversion_rates"));

        // Accessing object
        //String req_result = jsonobj.get("result").getAsString();
    }

    /*MODEL:
    {
        "result":"success",
            "documentation":"https://www.exchangerate-api.com/docs",
            "terms_of_use":"https://www.exchangerate-api.com/terms",
            "time_last_update_unix":1689811201,
            "time_last_update_utc":"Thu, 20 Jul 2023 00:00:01 +0000",
            "time_next_update_unix":1689897601,
            "time_next_update_utc":"Fri, 21 Jul 2023 00:00:01 +0000",
            "base_code":"USD",
            "conversion_rates":{
                "USD":1,
                "AED":3.6725,
                "AFN":85.8361,
                "ALL":90.1297,
                "AMD":386.6293,
                "ANG":1.7900,
                "AOA":837.0487,
                "ARS":267.4337,
                "AUD":1.4773,
                "AWG":1.7900,
                "AZN":1.7000,
                "BAM":1.7446,
                "BBD":2.0000,
                "BDT":108.5919,
                "BGN":1.7444,
                "BHD":0.3760,
                "BIF":2821.1094,
                "BMD":1.0000,
                "BND":1.3255,
                "BOB":6.9119,
                "BRL":4.8118,
                "BSD":1.0000,
                "BTN":82.0893,
                "BWP":13.1080,
                "BYN":2.8828,
                "BZD":2.0000,
                "CAD":1.3169,
                "CDF":2383.9146,
                "CHF":0.8585,
                "CLP":816.0163,
                "CNY":7.2256,
                "COP":3997.4441,
                "CRC":537.2935,
                "CUP":24.0000,
                "CVE":98.3581,
                "CZK":21.3306,
                "DJF":177.7210,
                "DKK":6.6548,
                "DOP":56.0617,
                "DZD":134.3257,
                "EGP":30.9031,
                "ERN":15.0000,
                "ETB":55.2155,
                "EUR":0.8925,
                "FJD":2.2140,
                "FKP":0.7735,
                "FOK":6.6548,
                "GBP":0.7735,
                "GEL":2.5635,
                "GGP":0.7735,
                "GHS":11.4289,
                "GIP":0.7735,
                "GMD":62.6162,
                "GNF":8571.8459,
                "GTQ":7.8450,
                "GYD":209.6796,
                "HKD":7.8080,
                "HNL":24.6203,
                "HRK":6.7209,
                "HTG":137.5932,
                "HUF":335.5751,
                "IDR":14991.7247,
                "ILS":3.5851,
                "IMP":0.7735,
                "INR":82.0893,
                "IQD":1308.7294,
                "IRR":42078.3119,
                "ISK":130.5237,
                "JEP":0.7735,
                "JMD":154.4128,
                "JOD":0.7090,
                "JPY":139.6680,
                "KES":141.5050,
                "KGS":87.8073,
                "KHR":4126.7035,
                "KID":1.4774,
                "KMF":438.8429,
                "KRW":1265.6510,
                "KWD":0.3066,
                "KYD":0.8333,
                "KZT":443.7064,
                "LAK":19109.6125,
                "LBP":15000.0000,
                "LKR":322.7827,
                "LRD":184.1203,
                "LSL":17.8979,
                "LYD":4.7333,
                "MAD":9.7464,
                "MDL":17.8032,
                "MGA":4427.4950,
                "MKD":54.7598,
                "MMK":2099.2985,
                "MNT":3444.6259,
                "MOP":8.0422,
                "MRU":36.4991,
                "MUR":45.4389,
                "MVR":15.4443,
                "MWK":1053.7863,
                "MXN":16.7344,
                "MYR":4.5424,
                "MZN":64.5541,
                "NAD":17.8979,
                "NGN":770.1130,
                "NIO":36.5651,
                "NOK":10.0407,
                "NPR":131.3428,
                "NZD":1.5982,
                "OMR":0.3845,
                "PAB":1.0000,
                "PEN":3.5774,
                "PGK":3.6013,
                "PHP":54.6127,
                "PKR":281.3925,
                "PLN":3.9679,
                "PYG":7259.7293,
                "QAR":3.6400,
                "RON":4.4049,
                "RSD":104.3209,
                "RUB":91.3545,
                "RWF":1203.7570,
                "SAR":3.7500,
                "SBD":8.3115,
                "SCR":13.3689,
                "SDG":580.2794,
                "SEK":10.2700,
                "SGD":1.3255,
                "SHP":0.7735,
                "SLE":19.6023,
                "SLL":19602.3196,
                "SOS":569.1624,
                "SRD":38.4639,
                "SSP":989.0069,
                "STN":21.8544,
                "SYP":2490.5842,
                "SZL":17.8979,
                "THB":34.0660,
                "TJS":10.9157,
                "TMT":3.4990,
                "TND":3.0376,
                "TOP":2.3196,
                "TRY":26.8865,
                "TTD":6.7661,
                "TVD":1.4774,
                "TWD":31.0480,
                "TZS":2447.5738,
                "UAH":36.7737,
                "UGX":3668.8787,
                "UYU":38.0684,
                "UZS":11677.9325,
                "VES":28.8789,
                "VND":23640.8358,
                "VUV":117.1554,
                "WST":2.7028,
                "XAF":585.1238,
                "XCD":2.7000,
                "XDR":0.7387,
                "XOF":585.1238,
                "XPF":106.4460,
                "YER":250.0905,
                "ZAR":17.8911,
                "ZMW":19.0647,
                "ZWL":4766.7532
    }
    }*/
}
