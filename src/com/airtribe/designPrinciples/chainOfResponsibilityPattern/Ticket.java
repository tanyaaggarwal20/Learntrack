package com.airtribe.designPrinciples.chainOfResponsibilityPattern;

public class Ticket {
    String priority;
    String issue;

    Ticket(String priority, String issue) {
        this.priority = priority;
        this.issue = issue;
    }

    public String getPriority() {
        return priority;
    }

    public String getIssue() {
        return issue;
    }
}
