package com.airtribe.designPrinciples.chainOfResponsibilityPattern;

public abstract class SupportHandler {
    protected SupportHandler next;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public abstract void handle(Ticket ticket);

    public void passToNext(Ticket ticket) {
        if(next != null) {
            next.handle(ticket);
        } else {
            System.out.println("No handler present for this ticket.");
        }
    }
}
