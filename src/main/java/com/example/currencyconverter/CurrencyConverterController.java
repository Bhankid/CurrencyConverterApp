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

package com.example.currencyconverter; // The package declaration for the CurrencyConverterController class.

import javafx.fxml.FXML; // Import for FXML annotations used to bind UI components.
import javafx.scene.chart.BarChart; // Import for BarChart UI component.
import javafx.scene.chart.CategoryAxis; // Import for the categorical X-axis of the BarChart.
import javafx.scene.chart.NumberAxis; // Import for the numerical Y-axis of the BarChart.
import javafx.scene.chart.XYChart; // Import for XYChart data series used in the BarChart.
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox; // Import for ComboBox UI component.
import javafx.scene.control.Label; // Import for Label UI component.
import javafx.scene.control.TextField; // Import for TextField UI component.
import javafx.scene.text.Font; // Import for setting the font of the Label.
import javafx.scene.text.FontWeight; // Import for setting the font weight of the Label.

import java.util.Map; // Import for using the Map data structure.

public class CurrencyConverterController {
    // Fields bound to FXML elements using @FXML annotations
    @FXML
    private TextField amountField; // TextField where the user enters the amount to convert.
    @FXML
    private ComboBox<String> fromCurrency; // ComboBox for selecting the currency to convert from.
    @FXML
    private ComboBox<String> toCurrency; // ComboBox for selecting the currency to convert to.
    @FXML
    private Label resultLabel; // Label to display the conversion result.

    // Fields for the first BarChart ("From" currency)
    @FXML
    private BarChart<String, Number> fromCurrencyBarChart; // BarChart to display the amount in the "From" currency.
    @FXML
    private CategoryAxis fromXAxis; // X-axis for the "From" BarChart, which displays the currency name.
    @FXML
    private NumberAxis fromYAxis; // Y-axis for the "From" BarChart, which displays the amount.

    // Fields for the second BarChart ("To" currency)
    @FXML
    private BarChart<String, Number> toCurrencyBarChart; // BarChart to display the amount in the "To" currency.
    @FXML
    private CategoryAxis toXAxis; // X-axis for the "To" BarChart, which displays the currency name.
    @FXML
    private NumberAxis toYAxis; // Y-axis for the "To" BarChart, which displays the amount.

    // This method is called automatically after the FXML file has been loaded and the UI components have been injected.
    @FXML
    public void initialize() {
        populateCurrencies(); // Populates the ComboBoxes with currency options.
        resultLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16)); // Sets the font of the result label to Arial, bold, size 16.

        // Sets the label for the X and Y axes of the "From" currency BarChart.
        fromXAxis.setLabel("Currency");
        fromYAxis.setLabel("Amount");

        // Sets the label for the X and Y axes of the "To" currency BarChart.
        toXAxis.setLabel("Currency");
        toYAxis.setLabel("Amount");
    }

    // Populates the ComboBoxes with a list of available currencies.
    private void populateCurrencies() {
        Map<String, String> currencies = CurrencySymbol.getCurrencySymbols(); // Retrieves a map of currency symbols.
        fromCurrency.getItems().addAll(currencies.keySet()); // Adds the currency symbols to the "From" ComboBox.
        toCurrency.getItems().addAll(currencies.keySet()); // Adds the currency symbols to the "To" ComboBox.
    }

    // Handles the currency conversion when the "Convert" button is clicked.
    @FXML
    private void convertCurrency() {
        String from = fromCurrency.getValue(); // Retrieves the selected "From" currency.
        String to = toCurrency.getValue(); // Retrieves the selected "To" currency.
        String amountText = amountField.getText(); // Retrieves the entered amount as a string.

        // Checks if any required field is empty.
        if (from == null || to == null || amountText.isEmpty()) {
            showAlert("Input Error", "Please select both currencies and enter an amount."); // Shows an error alert if any field is empty.
            return; // Exits the method if validation fails.
        }

        try {
            double amount = Double.parseDouble(amountText); // Parses the amount to a double.
            double rate = CurrencyAPI.getConversionRate(from, to); // Retrieves the conversion rate from a currency API.
            double convertedAmount = amount * rate; // Calculates the converted amount.

            // Formats and displays the conversion result in the result label.
            String resultText = String.format("%.2f %s = %.2f %s",
                    amount, CurrencySymbol.getSymbol(from),
                    convertedAmount, CurrencySymbol.getSymbol(to));
            resultLabel.setText(resultText); // Sets the formatted result in the result label.

            // Updates the BarCharts with the conversion results.
            updateBarCharts(amount, convertedAmount, from, to);

        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid number for the amount."); // Shows an error alert if the amount is not a valid number.
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage()); // Displays the error message in the result label if an exception occurs.
        }
    }

    // Updates the BarCharts with the amounts for the selected currencies.
    private void updateBarCharts(double fromAmount, double toAmount, String fromCurrency, String toCurrency) {
        fromCurrencyBarChart.getData().clear(); // Clears any previous data from the "From" currency BarChart.
        toCurrencyBarChart.getData().clear(); // Clears any previous data from the "To" currency BarChart.

        // Creates a new data series for the "From" currency BarChart.
        XYChart.Series<String, Number> fromSeries = new XYChart.Series<>();
        fromSeries.setName(fromCurrency); // Sets the name of the series to the "From" currency name.
        fromSeries.getData().add(new XYChart.Data<>(fromCurrency, fromAmount)); // Adds the data (currency name and amount) to the series.
        fromCurrencyBarChart.getData().add(fromSeries); // Adds the series to the "From" currency BarChart.

        // Creates a new data series for the "To" currency BarChart.
        XYChart.Series<String, Number> toSeries = new XYChart.Series<>();
        toSeries.setName(toCurrency); // Sets the name of the series to the "To" currency name.
        toSeries.getData().add(new XYChart.Data<>(toCurrency, toAmount)); // Adds the data (currency name and amount) to the series.
        toCurrencyBarChart.getData().add(toSeries); // Adds the series to the "To" currency BarChart.
    }

    // Displays an alert with the specified title and message.
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR); // Creates a new error alert.
        alert.setTitle(title); // Sets the title of the alert.
        alert.setHeaderText(null); // Clears the header text of the alert.
        alert.setContentText(message); // Sets the content (message) of the alert.
        alert.showAndWait(); // Displays the alert and waits for user interaction.
    }
}
