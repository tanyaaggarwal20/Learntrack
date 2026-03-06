package com.airtribe.designPrinciples.strategyPattern;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing Paypal payment of $: " + amount);
    }
}
