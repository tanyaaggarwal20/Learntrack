package com.airtribe.designPrinciples.observerPattern;

public class SmsNotificationObserver implements Observer {
    private String phone;

    SmsNotificationObserver(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(String message) {
        System.out.println("SMS to " + phone + ": " + message);
    }
}
