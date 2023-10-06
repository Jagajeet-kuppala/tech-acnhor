package com.thoughtworks.movierental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test()
    public void testName() {
        String name = "Ayush";
        Customer customer = new Customer(name);

        Assertions.assertEquals(name, customer.getName());
    }

    @Test()
    public void testStatementWithoutRentals() {
        String name = "Ayush";
        Customer customer = new Customer(name);
        String expectedStatement = "Rental Record for " + name + "\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        String statement = customer.statement();

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void shouldGenerateStatement() {
        Customer customer = new Customer("ABC");
        customer.addRental(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Movie-3", Movie.CHILDRENS), 5));
        customer.addRental(new Rental(new Movie("Movie-4", Movie.CHILDRENS), 2));
        customer.addRental(new Rental(new Movie("Movie-5", Movie.NEW_RELEASE), 3));

        Assertions.assertEquals("Rental Record for ABC\n" +
                "\tMovie-1\t5.0\n" +
                "\tMovie-2\t2.0\n" +
                "\tMovie-3\t4.5\n" +
                "\tMovie-4\t1.5\n" +
                "\tMovie-5\t9.0\n" +
                "Amount owed is 22.0\n" +
                "You earned 6 frequent renter points", customer.statement());
    }

    @Test
    public void shouldGenerateHTMLStatement() {
        Customer customer = new Customer("ABC");
        customer.addRental(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Movie-3", Movie.CHILDRENS), 5));
        customer.addRental(new Rental(new Movie("Movie-4", Movie.CHILDRENS), 2));
        customer.addRental(new Rental(new Movie("Movie-5", Movie.NEW_RELEASE), 3));

        Assertions.assertEquals("<html><h1>Rental Record for <b>ABC</b></h1></br>" +
                "<p>Movie-1 5.0</p></br>" +
                "<p>Movie-2 2.0</p></br>" +
                "<p>Movie-3 4.5</p></br>" +
                "<p>Movie-4 1.5</p></br>" +
                "<p>Movie-5 9.0</p></br>" +
                "Amount owed is <b>22.0</b></br>" +
                "You earned <b>6</b> frequent renter points</html>", customer.htmlStatement());
    }
}
