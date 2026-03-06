package com.airtribe.designPrinciples.strategyPattern;

public class DebitCardPayment implements PaymentStrategy{
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing debit card payment of $: " + amount);
    }
}
