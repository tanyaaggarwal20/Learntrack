package com.airtribe.designPrinciples.chainOfResponsibilityPattern;

import java.util.Objects;

public class Level1Support extends SupportHandler {
    @Override
    public void handle(Ticket ticket) {
        if(ticket.getPriority().equals("LOW")) {
            System.out.println("Level 1 support: Handling basic issue.");
            System.out.println("Resolved by: Junior Support Agent.");
        } else {
            System.out.println("Level 1 support: cannot handle, escalating...");
            passToNext(ticket);
        }
    }
}
