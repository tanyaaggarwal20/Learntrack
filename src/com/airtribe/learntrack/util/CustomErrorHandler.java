package com.airtribe.learntrack.util;

public class CustomErrorHandler {
    public static void executeSafely(Runnable action, String successMessage) {
        try {
            action.run();
            System.out.println(successMessage);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void executeSafely(Runnable action) {
        try {
            action.run();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
