package com.example.currencyconverter;
// Declares that this class is part of the 'com.example.currencyconverter' package.

import javafx.scene.chart.BarChart;
// Imports the BarChart class from the JavaFX library. BarChart is used to create and manage bar charts.

import javafx.scene.chart.XYChart;
// Imports the XYChart class from the JavaFX library. XYChart is a base class for defining charts that use an X-Y axis.

public class CurrencyChart {
    // Defines a public class named 'CurrencyChart'. This class contains methods related to updating bar charts.

    public static void updateBarChart(BarChart<String, Number> chart, double fromAmount, double toAmount, String fromCurrency, String toCurrency) {
        // Declares a public static method named 'updateBarChart'. This method takes a BarChart object, two amounts, and two currency names as parameters.
        // The method is static, meaning it can be called without creating an instance of CurrencyChart.

        chart.getData().clear();
        // Clears any existing data from the provided BarChart. This ensures that the chart will only display the latest data.

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        // Creates a new instance of XYChart.Series, which represents a series of data points to be plotted on the chart.
        // The series uses a String for the X-axis (currency name) and a Number for the Y-axis (amount).

        series.setName("Currency Conversion");
        // Sets the name of the data series to "Currency Conversion". This name will be displayed in the chart legend.

        series.getData().add(new XYChart.Data<>(fromCurrency, fromAmount));
        // Adds a new data point to the series, representing the 'from' currency and its corresponding amount.
        // The XYChart.Data object takes the currency name as the X value and the amount as the Y value.

        series.getData().add(new XYChart.Data<>(toCurrency, toAmount));
        // Adds another data point to the series, representing the 'to' currency and its corresponding amount.

        chart.getData().add(series);
        // Adds the complete data series to the BarChart. The chart will display the data points as bars.
    }
}
