package com.airtribe.designPrinciples.singletonPattern;

/**
 * Eager Initialization Singleton
 *
 * Instance is created at class loading time, before it's actually needed.
 *
 * Pros:
 * - Simple and thread-safe
 * - No need for synchronization
 *
 * Cons:
 * - Instance is created even if it's never used (wastes resources)
 * - Cannot handle exceptions during object creation
 */
public class EagerSingleton {

    // Instance is created at class loading time
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // Private constructor
    private EagerSingleton() {
        System.out.println("EagerSingleton instance created at class load time");
    }

    // Global access point
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    public void doSomething() {
        System.out.println("EagerSingleton: Doing something...");
    }
}
