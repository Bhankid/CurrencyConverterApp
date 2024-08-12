/*package com.example.currencyconverter;

import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExchangeRateHistoryAPI {
    private static final String API_URL = "https://api.exchangerate.host/timeseries";

    public static List<ExchangeRateData> getExchangeRateHistory(String fromCurrency, String toCurrency) throws Exception {
        List<ExchangeRateData> exchangeRateHistory = new ArrayList<>();
        String urlString = String.format("%s?start_date=2023-01-01&end_date=2023-07-01&base=%s&symbols=%s", API_URL, fromCurrency, toCurrency);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Scanner scanner = new Scanner(reader);
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();

        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.has("rates")) {
            JSONObject rates = jsonObject.getJSONObject("rates");
            for (String date : rates.keySet()) {
                double rate = rates.getJSONObject(date).getDouble(toCurrency);
                exchangeRateHistory.add(new ExchangeRateData(date, rate));
            }
        } else {
            throw new Exception("Failed to fetch exchange rate history");
        }

        return exchangeRateHistory;
    }

    public static class ExchangeRateData {
        private final String date;
        private final double rate;

        public ExchangeRateData(String date, double rate) {
            this.date = date;
            this.rate = rate;
        }

        public String getDate() {
            return date;
        }

        public double getRate() {
            return rate;
        }
    }
}*/
