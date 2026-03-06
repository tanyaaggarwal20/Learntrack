package com.airtribe.designPrinciples.chainOfResponsibilityPattern;

public class Level3Support extends SupportHandler {
    @Override
    public void handle(Ticket ticket) {
        if(ticket.getPriority().equals("HIGH")) {
            System.out.println("Level 3 support: Handling critical issue.");
            System.out.println("Resolved by: Support Manager");
        } else {
            System.out.println("Level 3 support: cannot handle, escalating...");
            passToNext(ticket);
        }
    }
}
