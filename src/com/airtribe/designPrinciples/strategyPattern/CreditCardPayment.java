package com.airtribe.designPrinciples.strategyPattern;

// Concrete strategies - each encapsulates one algorithm
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing credit card payment of $: " + amount);
    }
}
