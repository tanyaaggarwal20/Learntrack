package com.airtribe.designPrinciples.observerPattern;

public class EmailNotificationObserver implements Observer{

    private String email;

    EmailNotificationObserver(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email to " + email + ": " + message);
    }
}
