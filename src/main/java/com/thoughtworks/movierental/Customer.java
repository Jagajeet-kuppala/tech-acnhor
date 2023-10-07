package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(name, rentals, getTotalAmount(), getTotalFrequentRenterPoints()).generate();
    }

    public String htmlStatement() {
        return new HtmlStatement(getTotalAmount(), getTotalFrequentRenterPoints(), name, rentals).generate();
    }

    private int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals) {
            int frequentRenterPoints = rental.frequentRenterPoints();
            totalFrequentRenterPoints += frequentRenterPoints;
        }
        return totalFrequentRenterPoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            double thisAmount = rental.amount();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

}

// HTML Story
// 1. Extract core logic to calculate rental price
// 2. Add 2 methods
// 2.1. getStatement() -> returns string
// 2.2. getHTMLStatement() -> returns HTML string
