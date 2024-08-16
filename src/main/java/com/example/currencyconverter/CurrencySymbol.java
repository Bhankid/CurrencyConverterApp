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
        currencySymbols.put("HUF", "Ft");
        currencySymbols.put("AED", "د.إ");
        currencySymbols.put("SAR", "﷼");
        currencySymbols.put("EGP", "£");
        currencySymbols.put("KWD", "د.ك");
        currencySymbols.put("BHD", "ب.د");
        currencySymbols.put("QAR", "﷼");
        currencySymbols.put("OMR", "ر.ع.");
        currencySymbols.put("JOD", "د.ا");
        currencySymbols.put("MAD", "د.م.");
        currencySymbols.put("TWD", "NT$");
        currencySymbols.put("PKR", "₨");
        currencySymbols.put("BDT", "৳");
        currencySymbols.put("LKR", "Rs");
        currencySymbols.put("NPR", "Rs");
        currencySymbols.put("MMK", "K");
        currencySymbols.put("KHR", "៛");
        currencySymbols.put("LAK", "₭");
        currencySymbols.put("MNT", "₮");
        currencySymbols.put("KZT", "₸");
        currencySymbols.put("UZS", "лв");
        currencySymbols.put("TJS", "ЅМ");
        currencySymbols.put("GEL", "₾");
        currencySymbols.put("AMD", "֏");
        currencySymbols.put("AZN", "₼");
        currencySymbols.put("BYN", "Br");
        currencySymbols.put("MDL", "L");
        currencySymbols.put("UAH", "₴");
        currencySymbols.put("BAM", "KM");
        currencySymbols.put("MKD", "ден");
        currencySymbols.put("RSD", "дин");
        currencySymbols.put("HRK", "kn");
        currencySymbols.put("BGN", "лв");
        currencySymbols.put("RON", "lei");
        currencySymbols.put("ISK", "kr");
        currencySymbols.put("ALL", "L");
        currencySymbols.put("DZD", "د.ج");
        currencySymbols.put("TND", "د.ت");
        currencySymbols.put("LYD", "ل.د");
        currencySymbols.put("SDG", "ج.س.");
        currencySymbols.put("ETB", "Br");
        currencySymbols.put("KES", "KSh");
        currencySymbols.put("TZS", "TSh");
        currencySymbols.put("UGX", "USh");
        currencySymbols.put("RWF", "FRw");
        currencySymbols.put("BIF", "FBu");
        currencySymbols.put("CDF", "FC");
        currencySymbols.put("ZMW", "ZK");
        currencySymbols.put("MWK", "MK");
        currencySymbols.put("MZN", "MT");
        currencySymbols.put("AOA", "Kz");
        currencySymbols.put("NAD", "$");
        currencySymbols.put("BWP", "P");
        currencySymbols.put("SZL", "E");
        currencySymbols.put("LSL", "L");
        currencySymbols.put("MUR", "₨");
        currencySymbols.put("SCR", "₨");
        currencySymbols.put("MGA", "Ar");
        currencySymbols.put("XAF", "FCFA");
        currencySymbols.put("XCD", "$");
        currencySymbols.put("XDR", "SDR");
        currencySymbols.put("XPF", "₣");
        currencySymbols.put("YER", "﷼");
        currencySymbols.put("ZWL", "$");
    }

    public static Map<String, String> getCurrencySymbols() {
        return currencySymbols; // Returns the map of currency symbols
    }

    public static String getSymbol(String currency) {
        return currencySymbols.getOrDefault(currency, ""); // Retrieves the symbol for the specified currency
        // or an empty string if not found
    }
}

