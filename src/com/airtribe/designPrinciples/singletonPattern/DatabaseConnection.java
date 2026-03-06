package com.airtribe.designPrinciples.singletonPattern;

/**
 * Singleton Pattern Example - Thread-Safe Implementation
 *
 * Singleton ensures that a class has only ONE instance throughout the application
 * and provides a global point of access to that instance.
 *
 * This example uses the "Bill Pugh Singleton" approach which is:
 * - Thread-safe without synchronization overhead
 * - Lazy initialization (created only when needed)
 * - Simple and clean implementation
 */
public class DatabaseConnection {

    // Private constructor prevents instantiation from outside
    private DatabaseConnection() {
        // Simulate database connection initialization
        System.out.println("Initializing Database Connection...");
    }

    /**
     * Static inner class - SingletonHelper
     * This class is loaded only when getInstance() is called (lazy initialization)
     * The JVM guarantees thread-safety during class loading
     */
    private static class SingletonHelper {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    /**
     * Public method to get the singleton instance
     * This is the global access point to the singleton
     */
    public static DatabaseConnection getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Example business method
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }

    // Example business method
    public void closeConnection() {
        System.out.println("Closing database connection...");
    }
}
