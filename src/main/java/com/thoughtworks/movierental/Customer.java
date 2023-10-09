package com.thoughtworks.movierental;

public class Customer {
    private final String name;
    private final Rentals rentals = new Rentals();

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
//        return new TextStatement(name, rentals, getTotalAmount(), getTotalFrequentRenterPoints()).generate();
//        return new TextStatement().generate(name, rentals, getTotalAmount(), getTotalFrequentRenterPoints());
        return new TextStatement().generate(name, rentals);
    }

    public String htmlStatement() {
//        return new HtmlStatement(getTotalAmount(), getTotalFrequentRenterPoints(), name, rentals).generate();
        return new HtmlStatement(name, rentals).generate();
    }
}

// HTML Story
// 1. Extract core logic to calculate rental price
// 2. Add 2 methods
// 2.1. getStatement() -> returns string
// 2.2. getHTMLStatement() -> returns HTML string
