package com.airtribe.designPrinciples.chainOfResponsibilityPattern;

public class Level2Support extends SupportHandler {
    @Override
    public void handle(Ticket ticket) {
        if(ticket.getPriority().equals("MEDIUM")) {
            System.out.println("Level 2 support: Handling technical issue.");
            System.out.println("Resolved by: Senior Support Agent.");
        } else {
            System.out.println("Level 2 support: cannot handle, escalating...");
            passToNext(ticket);
        }
    }
}
