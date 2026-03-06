package com.airtribe.designPrinciples.singletonPattern;

/**
 * Lazy Initialization Singleton with Double-Checked Locking
 *
 * Instance is created only when getInstance() is called for the first time.
 *
 * This uses double-checked locking to minimize synchronization overhead
 * while ensuring thread-safety.
 *
 * Pros:
 * - Thread-safe
 * - Lazy initialization (created only when needed)
 * - Good performance (synchronization only during first creation)
 *
 * Cons:
 * - More complex code
 */
public class LazySingleton {
    private static LazySingleton instance;

    // Private constructor
    private LazySingleton() {
        System.out.println("LazySingleton instance created lazily");
    }

    // Double-checked locking for thread-safe lazy initialization
    public static LazySingleton getInstance() {
        // First check (without locking) - for performance
        if(instance == null) {
            /* Synchronize only when instance is null
               Why LazySingleton.class is Used?
               Static methods do not belong to an object, they belong to the class.
               So the lock must also be class-level.
               LazySingleton.class represents the Class object of LazySingleton.
            */
            synchronized (LazySingleton.class) {
                // Second check (with locking) - for thread safety
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("LazySingleton: Doing something...");
    }
}
