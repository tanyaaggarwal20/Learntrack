package com.airtribe.designPrinciples.singletonPattern;

/**
 * Demonstration of Singleton Pattern
 *
 * Singleton Pattern is a creational design pattern that ensures a class
 * has only ONE instance and provides a global point of access to it.
 *
 * When to use:
 * 1. Database connections
 * 2. Configuration managers
 * 3. Logger instances
 * 4. Cache managers
 * 5. Thread pools
 *
 * Advantages:
 * 1. Controlled access to single instance
 * 2. Reduced memory footprint (only one instance)
 * 3. Global access point
 *
 * Disadvantages:
 * 1. Violates Single Responsibility Principle (manages its own creation + business logic)
 * 2. Can make unit testing difficult
 * 3. Can hide dependencies
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Demonstrating Bill Pugh Singleton (Recommended) ===");
        // First call - instance will be created
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.executeQuery("SELECT * FROM users");

        // Second call - same instance will be returned
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.executeQuery("SELECT * FROM products");

        // Verify both references point to the same instance
        System.out.println("Are db1 and db2 the same instance? " + (db1 == db2));

        System.out.println("\n=== Demonstrating Eager Singleton ===");
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("Are eager1 and eager2 the same? " + (eager1 == eager2));
        eager1.doSomething();

        System.out.println("\n=== Demonstrating Lazy Singleton ===");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("Are lazy1 and lazy2 the same? " + (lazy1 == lazy2));
        lazy1.doSomething();

        // Testing thread-safety of Lazy Singleton
        System.out.println("\n=== Testing Thread-Safety ===");
        testThreadSafety();
    }

    /**
     * Test thread-safety by creating multiple threads trying to get singleton instance
     */
    private static void testThreadSafety() {
        Thread thread1 = new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println("Thread 1 got instance: " + instance.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println("Thread 2 got instance: " + instance.hashCode());
        });

        Thread thread3 = new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println("Thread 3 got instance: " + instance.hashCode());
        });

        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads got the same instance (same hashCode)!");
    }
}
