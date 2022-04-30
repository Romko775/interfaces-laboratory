package com.snu.lab;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hotel {
    private final StringProperty name;
    private final StringProperty resort;
    private final StringProperty category;
    private final DoubleProperty rate;

    public Hotel(String name, String resort, String category, double rate) {
        this.name = new SimpleStringProperty(name);
        this.resort = new SimpleStringProperty(resort);
        this.category = new SimpleStringProperty(category);
        this.rate = new SimpleDoubleProperty(rate);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.getValue();
    }

    public StringProperty resortProperty() {
        return resort;
    }

    public String getResort() {
        return resort.getValue();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public String getCategory() {
        return category.getValue();
    }

    public DoubleProperty rateProperty() {
        return rate;
    }

    public Double getRate() {
        return rate.getValue();
    }
}
