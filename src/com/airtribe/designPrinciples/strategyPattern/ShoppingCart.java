package com.airtribe.designPrinciples.strategyPattern;

// Context - uses strategy
public class ShoppingCart {
    private PaymentStrategy strategy;

    void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void checkout(double amount) {
       strategy.makePayment(amount); //delegate to strategy
    }
}
