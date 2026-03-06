package com.airtribe.designPrinciples.chainOfResponsibilityPattern;

public class DirectorSupport extends SupportHandler {
    @Override
    public void handle(Ticket ticket) {
        if(ticket.getPriority().equals("CRITICAL")) {
            System.out.println("Director support: Handling critical issue.");
            System.out.println("Resolved by: Director Support Agent.");
        } else {
            System.out.println("Director support: cannot handle, escalating...");
            passToNext(ticket);
        }
    }
}
