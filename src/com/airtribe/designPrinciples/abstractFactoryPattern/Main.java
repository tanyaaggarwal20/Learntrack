package com.airtribe.designPrinciples.abstractFactoryPattern;

/**
 * GOOD EXAMPLE - With Abstract Factory Pattern
 *
 * Benefits:
 * 1. Ensures products from same family are used together
 * 2. Client doesn't need to know concrete product classes
 * 3. Easy to add new product families
 * 4. Follows Open-Closed Principle
 * 5. Eliminates risk of mixing incompatible products
 */
public class Main {
    public static void main(String[] args) {
        // Client works with abstract factory interface
        UIFactory windowsFactory = new WindowsUIFactory();
        UIFactory macFactory = new MacUIFactory();

        // Use Windows theme
        System.out.println("=== Windows Theme ===");
        renderUI(windowsFactory);

        // Use Mac theme
        System.out.println("\n=== Mac Theme ===");
        renderUI(macFactory);

        // Adding new theme (Linux) only requires:
        // 1. Create LinuxButton and LinuxCheckbox
        // 2. Create LinuxUIFactory
        // 3. Client code remains unchanged!
    }

    // Client method - works with any factory
    // Guarantees all products are from same family
    public static void renderUI(UIFactory factory) {
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
        // No risk of mixing Windows button with Mac checkbox!
    }
}


/* Difference b/w Abstract Factory Pattern & Factory Pattern?

   Factory Pattern
   Provides a single method to create objects based on input.
   Only one type of product.
   Creation logic should be hidden.

   Abstract Factory Pattern
   Provides an interface to create families of related objects without specifying their concrete classes.
   Need multiple related objects.
   Objects must work together.

*/