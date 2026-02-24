package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter = 0;
    private static int courseIdCounter = 0;
    private static int enrollmentIdCounter = 0;

    public static String getNextStudentId() {
        studentIdCounter++;
        return "S" + studentIdCounter;
    }

    public static String getNextCourseId() {
        courseIdCounter++;
        return "C" + courseIdCounter;
    }

    public static String getNextEnrollmentId() {
        enrollmentIdCounter++;
        return "E" + enrollmentIdCounter;
    }
}
