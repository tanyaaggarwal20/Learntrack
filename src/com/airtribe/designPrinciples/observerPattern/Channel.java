package com.airtribe.designPrinciples.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private List<Observer> observers = new ArrayList<>();

    public void subscribeChannel(Observer obs) {
        observers.add(obs);
    }

    public void unsubscribeChannel(Observer obs) {
        observers.remove(obs);
    }

    public void uploadVideo(String title) {
        System.out.println("New video: " + title);
        notifyAllObservers("New video: " + title + "uploaded");

    }

    public void notifyAllObservers(String message) {
        for(Observer obs: observers) {
            obs.update(message);
        }
    }
}
