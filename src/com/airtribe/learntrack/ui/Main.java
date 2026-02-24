package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.service.CourseManagementService;
import com.airtribe.learntrack.service.EnrollmentManagementService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

import static com.airtribe.learntrack.util.CustomErrorHandler.executeSafely;
import static com.airtribe.learntrack.util.InputValidation.*;

public class Main {

    private static final Scanner s = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();
    private static final CourseManagementService courseService = new CourseManagementService();
    private static final EnrollmentManagementService enrollmentService = new EnrollmentManagementService(studentService, courseService);

    public static void main(String[] args) {

        while (true) {
            System.out.println("====== MAIN MENU ======");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");

            int input = readInt("Select an option:");

            switch (input) {
                case 1:
                    showStudentManagementMenu();
                    break;
                case 2:
                    showCourseManagementMenu();
                    break;
                case 3:
                    showEnrollmentManagementMenu();
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Please select a valid option");
            }
        }
    }

    // ================= STUDENT MENU =================

    private static void showStudentManagementMenu() {

        while (true) {
            System.out.println("====== STUDENT MANAGEMENT ======");
            System.out.println("1. Add new student");
            System.out.println("2. View all students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Deactivate student");
            System.out.println("0. Back");

            int input = readInt("Select an option:");

            switch (input) {
                case 1:
                    executeSafely(() -> addNewStudent(), "Student added successfully");
                    break;
                case 2:
                    studentService.viewAllStudents();
                    break;
                case 3:
                    String id = readNonEmptyString("Enter student ID:");
                    executeSafely(() -> {
                        Student student = studentService.searchByStudentId(id);
                        System.out.println(student);
                    });
                    break;
                case 4:
                    String sid = readNonEmptyString("Enter student ID:");
                    executeSafely(() -> studentService.deactivateStudent(sid), "Student deactivated successfully!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void addNewStudent() {

        String firstName = readNonEmptyString("Enter first name:");
        String lastName = readNonEmptyString("Enter last name:");
        String email = readValidEmail("Enter email:");
        String batch = readNonEmptyString("Enter batch:");

        Student student = new Student(firstName, lastName, email, batch);

        studentService.addStudent(student);
    }

    // ================= COURSE MENU =================

    private static void showCourseManagementMenu() {

        while (true) {
            System.out.println("====== COURSE MANAGEMENT ======");
            System.out.println("1. Add new course");
            System.out.println("2. View all courses");
            System.out.println("3. Activate course");
            System.out.println("4. Deactivate course");
            System.out.println("0. Back");

            int input = readInt("Select an option:");

            switch (input) {
                case 1:
                    executeSafely(() -> addNewCourse(), "Course added successfully!");
                    break;
                case 2:
                    courseService.viewAllCourses();
                    break;
                case 3:
                    String id = readNonEmptyString("Enter course ID:");
                    executeSafely(() -> courseService.activateCourse(id), "Course activated successfully!");
                    break;
                case 4:
                    String cid = readNonEmptyString("Enter course ID:");
                    executeSafely(() -> courseService.deactivateCourse(cid), "Course deactivated successfully!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void addNewCourse() {

        String courseName = readNonEmptyString("Enter course name:");
        String description = readNonEmptyString("Enter description:");
        int duration = readInt("Enter duration (weeks):");

        Course course = new Course(courseName, description, duration);

        courseService.addCourse(course);
    }

    // ================= ENROLLMENT MENU =================

    private static void showEnrollmentManagementMenu() {

        while (true) {
            System.out.println("\n====== ENROLLMENT MANAGEMENT ======");
            System.out.println("1. Enroll student");
            System.out.println("2. View enrollments for student");
            System.out.println("3. Mark as COMPLETED");
            System.out.println("4. Mark as CANCELLED");
            System.out.println("0. Back");

            int input = readInt("Select an option:");

            switch (input) {
                case 1:
                    executeSafely(() -> enrollStudent(), "Student enrolled successfully!");
                    break;
                case 2:
                    String id = readNonEmptyString("Enter student ID:");
                    executeSafely(() -> enrollmentService.viewEnrollmentsForStudent(id));
                    break;
                case 3:
                    String eid = readNonEmptyString("Enter enrollment ID:");
                    executeSafely(() ->
                            enrollmentService.changeEnrollmentStatus(eid, EnrollmentStatus.COMPLETED), "Status updated successfully!");
                    break;
                case 4:
                    String enrId = readNonEmptyString("Enter enrollment ID:");
                    executeSafely(() ->
                            enrollmentService.changeEnrollmentStatus(enrId, EnrollmentStatus.CANCELLED), "Status updated successfully!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void enrollStudent() {

        String sid = readNonEmptyString("Enter student ID:");

        String cid = readNonEmptyString("Enter course ID:");

        enrollmentService.enrollStudentInCourse(sid, cid);
    }
}
