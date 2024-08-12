/*
package com.example.currencyconverter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Map;

public class CurrencyConverterController {
    @FXML
    private TextField amountField;
    @FXML
    private ComboBox<String> fromCurrency;
    @FXML
    private ComboBox<String> toCurrency;
    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        populateCurrencies();
        resultLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        setupAmountFieldListener();
    }

    private void populateCurrencies() {
        Map<String, String> currencies = CurrencySymbol.getCurrencySymbols();
        fromCurrency.getItems().addAll(currencies.keySet());
        toCurrency.getItems().addAll(currencies.keySet());
    }

    private void setupAmountFieldListener() {
        amountField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.isEmpty()) {
                    fromCurrency.setValue(null);
                    toCurrency.setValue(null);
                }
            }
        });
    }

    @FXML
    private void convertCurrency() {
        String from = fromCurrency.getValue();
        String to = toCurrency.getValue();
        String amountText = amountField.getText();

        if (from == null || to == null || amountText.isEmpty()) {
            showAlert("Input Error", "Please select both currencies and enter an amount.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);
            double rate = CurrencyAPI.getConversionRate(from, to);
            double convertedAmount = amount * rate;
            String resultText = String.format("%.2f %s = %.2f %s",
                    amount, CurrencySymbol.getSymbol(from),
                    convertedAmount, CurrencySymbol.getSymbol(to));
            resultLabel.setText(resultText);
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid number for the amount.");
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
*/

package com.example.currencyconverter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Map;

public class CurrencyConverterController {
    @FXML
    private TextField amountField;
    @FXML
    private ComboBox<String> fromCurrency;
    @FXML
    private ComboBox<String> toCurrency;
    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        populateCurrencies();  // Calls the method to populate the currency dropdowns
        resultLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));  // Sets the font for the result label
        setupAmountFieldListener();  // Calls the method to set up a listener for the amount field
    }

    private void populateCurrencies() {
        Map<String, String> currencies = CurrencySymbol.getCurrencySymbols();  // Retrieves a map of currency symbols
        fromCurrency.getItems().addAll(currencies.keySet());  // Populates the 'from' currency dropdown with currency symbols
        toCurrency.getItems().addAll(currencies.keySet());  // Populates the 'to' currency dropdown with currency symbols
    }

    private void setupAmountFieldListener() {
        amountField.textProperty().addListener(new ChangeListener<String>() {  // Adds a listener to the amount field
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.isEmpty()) {  // Checks if the amount field is empty
                    fromCurrency.setValue(null);  // Clears the 'from' currency selection
                    toCurrency.setValue(null);  // Clears the 'to' currency selection
                }
            }
        });
    }

    @FXML
    private void convertCurrency() {
        String from = fromCurrency.getValue();  // Retrieves the selected 'from' currency
        String to = toCurrency.getValue();  // Retrieves the selected 'to' currency
        String amountText = amountField.getText();  // Retrieves the amount entered in the amount field

        if (from == null || to == null || amountText.isEmpty()) {  // Checks if any of the required fields are empty
            showAlert("Input Error", "Please select both currencies and enter an amount.");  // Shows an error alert
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);  // Parses the amount to a double
            double rate = CurrencyAPI.getConversionRate(from, to);  // Retrieves the conversion rate from a currency API
            double convertedAmount = amount * rate;  // Calculates the converted amount
            String resultText = String.format("%.2f %s = %.2f %s",
                    amount, CurrencySymbol.getSymbol(from),
                    convertedAmount, CurrencySymbol.getSymbol(to));  // Formats the result text
            resultLabel.setText(resultText);  // Sets the result label with the converted amount
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid number for the amount.");  // Shows an error alert for invalid input
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());  // Sets the result label with an error message
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);  // Creates an error alert
        alert.setTitle(title);  // Sets the title of the alert
        alert.setHeaderText(null);  // Clears the header text of the alert
        alert.setContentText(message);  // Sets the content text of the alert
        alert.showAndWait();  // Displays the alert and waits for user interaction
    }
}
