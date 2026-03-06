package com.airtribe.designPrinciples.strategyPattern;

/**
 *With Strategy Pattern
 *
 * Benefits:
 * 1. Each payment algorithm in separate class
 * 2. Can switch payment strategies at runtime
 * 3. Easy to add new payment methods
 * 4. Follows Single Responsibility and Open-Closed Principles
 */
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setStrategy(new CreditCardPayment());
        cart.checkout(100.0);

        cart.setStrategy(new DebitCardPayment());
        cart.checkout(200.0);

        cart.setStrategy(new PaypalPayment());
        cart.checkout(250.0);
    }
}
