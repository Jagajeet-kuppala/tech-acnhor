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
        return header() + body() + footer();
    }

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<html>" + "<h1>" + "Rental Record for " + "<b>"  +getName() + "</b></h1>" + "</br>";
    }

    private String htmlBody() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append("<p>").append(rental.getMovie().getTitle()).append(" ").append(rental.amount()).append("</p></br>");
        }
        return result.toString();
    }

    private String htmlFooter() {
        double totalAmount = getTotalAmount();
        int totalFrequentRenterPoints = getTotalFrequentRenterPoints();
        String result = "Amount owed is " + "<b>" + totalAmount + "</b>" + "</br>";
        result += "You earned " + "<b>" +  totalFrequentRenterPoints + "</b>"
                + " frequent renter points" + "</html>";
        return result;
    }

    private String footer() {
        double totalAmount = getTotalAmount();
        int totalFrequentRenterPoints = getTotalFrequentRenterPoints();
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private String body() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.amount()).append("\n");
        }
        return result.toString();
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
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
