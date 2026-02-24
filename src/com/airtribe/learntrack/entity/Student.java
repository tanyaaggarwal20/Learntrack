package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person{
    private String email;
    private String batch;
    private boolean active;

    public Student(String firstName, String lastName, String email, String batch) {
        super(IdGenerator.getNextStudentId(), firstName, lastName);
        this.email = email;
        this.batch = batch;
        this.active = true;
    }

    public Student(String firstName, String lastName, String batch) {
        super(IdGenerator.getNextStudentId(), firstName, lastName);
        this.batch = batch;
        this.active = true;
    }

    @Override
    public void getDisplayName(String firstName, String lastName) {
        System.out.println("Student Name: " + firstName  + " " + lastName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", batch='" + batch + '\'' +
                ", active=" + active +
                '}';
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
