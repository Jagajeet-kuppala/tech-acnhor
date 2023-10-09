package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.Collection;

public class Rentals extends ArrayList<Rental> {

//    public Rentals(Collection<? extends Rental> c) {
//        super(c);
//    }

    public int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : this) {
            int frequentRenterPoints = rental.frequentRenterPoints();
            totalFrequentRenterPoints += frequentRenterPoints;
        }
        return totalFrequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            double thisAmount = rental.amount();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }
}
