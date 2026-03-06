package com.airtribe.designPrinciples.factoryPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter vehicle type:");
        String vehicleType = s.next();

        //client only knows about vehicle interface and factory
        Vehicle v = VehicleFactory.createVehicle(vehicleType);
        v.drive();
    }
}
