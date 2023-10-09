package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {

    private final double totalAmount;
    private final int totalFrequentRenterPoints;
    private final String name;
    private final List<Rental> rentalList;
//    private final Rentals rentals;

    @Deprecated
    public HtmlStatement(double totalAmount, int totalFrequentRenterPoints, String name, List<Rental> rentals) {
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
        this.name = name;
        this.rentalList = rentals;
    }

    public HtmlStatement(String name, Rentals rentals) {
        this.name = name;
//        this.rentals = rentals;
        this.totalAmount = rentals.getTotalAmount();
        this.totalFrequentRenterPoints = rentals.getTotalFrequentRenterPoints();
        this.rentalList = rentals;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<html>" + "<h1>" + "Rental Record for " + "<b>" + name + "</b></h1>" + "</br>";
    }

    private String htmlBody() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentalList) {
            result.append("<p>").append(rental.getMovie().getTitle()).append(" ").append(rental.amount()).append("</p></br>");
        }
        return result.toString();
    }

    private String htmlFooter() {
        int totalFrequentRenterPoints = this.totalFrequentRenterPoints;
        String result = "Amount owed is " + "<b>" + totalAmount + "</b>" + "</br>";
        result += "You earned " + "<b>" + totalFrequentRenterPoints + "</b>"
                + " frequent renter points" + "</html>";
        return result;
    }
}
