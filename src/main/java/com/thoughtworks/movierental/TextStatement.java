package com.thoughtworks.movierental;

import java.util.List;

class TextStatement {

    private final String name;
    private final List<Rental> rentals;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;

    public TextStatement(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String body() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.amount()).append("\n");
        }
        return result.toString();
    }

    private String footer() {
        double totalAmount = this.totalAmount;
        int totalFrequentRenterPoints = this.totalFrequentRenterPoints;
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }
}
