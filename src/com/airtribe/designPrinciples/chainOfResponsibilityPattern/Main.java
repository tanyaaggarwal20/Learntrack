package com.airtribe.designPrinciples.chainOfResponsibilityPattern;

public class Main {
    public static void main(String[] args) {
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();
        SupportHandler directorLevel = new DirectorSupport();

        level1.setNext(level2);
        level2.setNext(level3);
        level3.setNext(directorLevel);

        Ticket lowTicket = new Ticket("LOW", "low issue");
        Ticket mediumTicket = new Ticket("MEDIUM", "medium issue");
        Ticket highTicket = new Ticket("HIGH", "high issue");
        Ticket criticalTicket = new Ticket("CRITICAL", "critical issue");
        Ticket unknownTicket = new Ticket("unknown", "Highly critical");

        level1.handle(lowTicket);
        level1.handle(mediumTicket);
        level1.handle(highTicket);
        level1.handle(criticalTicket);
        level1.handle(unknownTicket);
     }
}
