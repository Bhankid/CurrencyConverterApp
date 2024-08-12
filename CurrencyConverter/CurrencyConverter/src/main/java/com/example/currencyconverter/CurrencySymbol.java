package com.example.currencyconverter;


import java.util.HashMap;
import java.util.Map;

public class CurrencySymbol {
    private static final Map<String, String> currencySymbols = new HashMap<>();
    // Initializes a map to store currency symbols
    static {
        // Populates the map with currency symbols for various currencies
        currencySymbols.put("USD", "$");
        currencySymbols.put("EUR", "€");
        currencySymbols.put("GBP", "£");
        currencySymbols.put("JPY", "¥");
        currencySymbols.put("CAD", "$");
        currencySymbols.put("AUD", "$");
        currencySymbols.put("CHF", "CHF");
        currencySymbols.put("CNY", "��");
        currencySymbols.put("DKK", "kr");
        currencySymbols.put("HKD", "$");
        currencySymbols.put("NZD", "$");
        currencySymbols.put("SEK", "kr");
        currencySymbols.put("SGD", "$");
        currencySymbols.put("NOK", "kr");
        currencySymbols.put("MXN", "$");
        currencySymbols.put("BRL", "R$");
        currencySymbols.put("TRY", "�");
        currencySymbols.put("ZAR", "R");
        currencySymbols.put("INR", "₹");
        currencySymbols.put("RUB", "₽");
        currencySymbols.put("PLN", "zł");
        currencySymbols.put("CZK", "Kč");
        currencySymbols.put("ILS", "��");
        currencySymbols.put("PHP", "��");
        currencySymbols.put("MYR", "RM");
        currencySymbols.put("KRW", "��");
        currencySymbols.put("VND", "�");
        currencySymbols.put("THB", "฿");
        currencySymbols.put("IDR", "Rp");
        currencySymbols.put("GHS", "GH₵");
        currencySymbols.put("NGR", "₦");
        currencySymbols.put("FRA", "CFA");
    }

    public static Map<String, String> getCurrencySymbols() {
        return currencySymbols; // Returns the map of currency symbols
    }

    public static String getSymbol(String currency) {
        return currencySymbols.getOrDefault(currency, ""); // Retrieves the symbol for the specified currency
        // or an empty string if not found
    }
}

