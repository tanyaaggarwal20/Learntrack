package com.airtribe.designPrinciples.observerPattern;


//Observer interface - all subscribers implement this
public interface Observer {
    void update(String message);
}
