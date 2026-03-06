package com.airtribe.designPrinciples.builderDesignPattern;

public class Main {
    public static void main(String[] args) {
        // Example 1: Basic computer with only required parameters
        Computer basicComputer = new Computer.ComputerBuilder("Intel i5", "8GB")
                .build();
        System.out.println("Basic Computer: " + basicComputer);

        // Example 2: Gaming computer with all bells and whistles
        Computer gamingComputer = new Computer.ComputerBuilder("Intel i9", "32GB")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setMonitor("27-inch 4K")
                .setWifi(true)
                .setBluetooth(true)
                .build();

        System.out.println("\nGaming Computer: " + gamingComputer);

        // Example 3: Office computer with some optional features
        Computer officeComputer = new Computer.ComputerBuilder("Intel i7", "16GB")
                .setStorage("512GB SSD")
                .setMonitor("24-inch Full HD")
                .setWifi(true)
                .build();
        System.out.println("\nOffice Computer: " + officeComputer);

        // Notice how readable and flexible the code is compared to:
        // new Computer("Intel i9", "32GB", "2TB SSD", "RTX 4090", "27-inch", true, true)
    }
}
