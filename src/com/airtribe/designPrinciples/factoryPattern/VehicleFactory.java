package com.airtribe.designPrinciples.factoryPattern;

//factory- centralizes object creation
public class VehicleFactory {
    public static Vehicle createVehicle(String vType) {
        switch (vType.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            default:
                throw new IllegalArgumentException("Unknown Vehicle: " + vType);
        }
    }
}
