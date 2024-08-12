/*
package com.example.currencyconverter;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class CurrencyAPI {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static double getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        URL url = new URL(API_URL + fromCurrency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Scanner scanner = new Scanner(reader);
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();

        JSONObject jsonObject = new JSONObject(response);
        return jsonObject.getJSONObject("rates").getDouble(toCurrency);
    }
}
*/

package com.example.currencyconverter;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class CurrencyAPI {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static double getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        URL url = new URL(API_URL + fromCurrency);  // Constructs the URL for the API request with the 'from' currency
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();  // Opens a connection to the API URL
        connection.setRequestMethod("GET");  // Sets the request method to GET

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());  // Reads the input stream from the API response
        Scanner scanner = new Scanner(reader);  // Creates a scanner to read the API response
        String response = scanner.useDelimiter("\\A").next();  // Reads the entire API response as a string
        scanner.close();  // Closes the scanner

        JSONObject jsonObject = new JSONObject(response);  // Creates a JSON object from the API response
        return jsonObject.getJSONObject("rates").getDouble(toCurrency);  // Retrieves the conversion rate for the 'to' currency from the JSON object
    }
}

