package com.airtribe.designPrinciples.observerPattern;

public class Main {
    public static void main(String[] args) {
        Observer emailObs1 = new EmailNotificationObserver("xyz@gmail.com");
        Observer emailObs2 = new EmailNotificationObserver("abc@gmail.com");
        Observer smsObs1 = new SmsNotificationObserver("9999998888");
        Channel youtubeChannel = new Channel();

        youtubeChannel.subscribeChannel(emailObs1);
        youtubeChannel.subscribeChannel(emailObs2);
        youtubeChannel.subscribeChannel(smsObs1);

        youtubeChannel.unsubscribeChannel(emailObs1);

        youtubeChannel.uploadVideo("Welcome to channnel!");

    }
}
