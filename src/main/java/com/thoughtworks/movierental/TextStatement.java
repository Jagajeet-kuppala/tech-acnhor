package com.thoughtworks.movierental;

import java.util.List;

class TextStatement {

//    private final String name;
//    private final List<Rental> rentals;
//    private final double totalAmount;
//    private final int totalFrequentRenterPoints;

//    public TextStatement(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
//        this.name = name;
//        this.rentals = rentals;
//        this.totalAmount = totalAmount;
//        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
//    }

    @Deprecated
    public String generate(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
        return header(name) + body(rentals) + footer(totalAmount, totalFrequentRenterPoints);
    }

    public String generate(String name, Rentals rentals) {
        return header(name) + body(rentals) + footer(rentals.getTotalAmount(), rentals.getTotalFrequentRenterPoints());
    }

    private String header(String name) {
        return "Rental Record for " + name + "\n";
    }

    private String body(List<Rental> rentals) {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.amount()).append("\n");
        }
        return result.toString();
    }

    private String footer(double totalAmount, int totalFrequentRenterPoints) {
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }
}
