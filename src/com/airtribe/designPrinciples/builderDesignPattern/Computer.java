package com.airtribe.designPrinciples.builderDesignPattern;

/**
 * Product class that will be built using Builder pattern
 * Builder pattern is useful when you have many optional parameters
 * and want to avoid telescoping constructors
 */

public class Computer {
        // Required parameters
        private final String cpu;
        private final String ram;

        // Optional parameters
        private final String storage;
        private final String graphicsCard;
        private final String monitor;
        private final boolean hasWifi;
        private final boolean hasBluetooth;

        // Private constructor - only Builder can create instances
        private Computer(ComputerBuilder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.monitor = builder.monitor;
            this.hasWifi = builder.hasWifi;
            this.hasBluetooth = builder.hasBluetooth;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + cpu + ", RAM=" + ram +
                    ", Storage=" + storage + ", Graphics=" + graphicsCard +
                    ", Monitor=" + monitor + ", WiFi=" + hasWifi +
                    ", Bluetooth=" + hasBluetooth + "]";
        }


        public static class ComputerBuilder {
            // Required parameters
            private final String cpu;
            private final String ram;

            // Optional parameters - initialized with default values
            private String storage = "256GB SSD";
            private String graphicsCard = "Integrated";
            private String monitor = "None";
            private boolean hasWifi = false;
            private boolean hasBluetooth = false;

            // Constructor with required parameters
            public ComputerBuilder(String cpu, String ram) {
                this.cpu = cpu;
                this.ram = ram;
            }

            // Builder methods for optional parameters
            // Each method returns 'this' to enable method chaining
            public ComputerBuilder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public ComputerBuilder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public ComputerBuilder setMonitor(String monitor) {
                this.monitor = monitor;
                return this;
            }

            public ComputerBuilder setWifi(boolean hasWifi) {
                this.hasWifi = hasWifi;
                return this;
            }

            public ComputerBuilder setBluetooth(boolean hasBluetooth) {
                this.hasBluetooth = hasBluetooth;
                return this;
            }

            // Build method to create the final Computer object
            public Computer build() {
                return new Computer(this);
            }
        }
}
