package com.airtribe.learntrack.util;

import java.util.Scanner;

public class InputValidation {
    public static final Scanner s = new Scanner(System.in);

    public static int readInt(String message) {
        while (true) {
            System.out.println(message);
            if (s.hasNextInt()) {
                int value = s.nextInt();
                s.nextLine(); // consume newline
                return value;
            } else {
                System.out.println("Invalid number. Try again.");
                s.next(); // discard bad input
            }
        }
    }

    public static String readNonEmptyString(String message) {
        while (true) {
            System.out.println(message);
            String input = s.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    public static String readValidEmail(String message) {
        while (true) {
            String email = readNonEmptyString(message);

            if (email.contains("@")) return email;

            System.out.println("Invalid email format.");
        }
    }

}

