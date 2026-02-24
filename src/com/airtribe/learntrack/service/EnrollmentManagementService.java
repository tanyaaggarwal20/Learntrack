package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.DuplicateEntityException;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentManagementService {

    private static List<Enrollment> enrollments = new ArrayList<>();
    private final StudentService studentService;
    private final CourseManagementService courseManagementService;

    public EnrollmentManagementService(StudentService studentService, CourseManagementService courseManagementService) {
        this.studentService = studentService;
        this.courseManagementService = courseManagementService;
    }

    public void enrollStudentInCourse(String studentId, String courseId) {
        studentService.searchByStudentId(studentId);
        courseManagementService.searchByCourseId(courseId);

        boolean alreadyEnrolled = enrollments.stream()
                .anyMatch(e -> e.getStudentId().equals(studentId)
                                      && e.getCourseId().equals(courseId));

        if(alreadyEnrolled) {
            throw new DuplicateEntityException(
                    "Student already enrolled in this course with Student Id: "
                    + studentId + " and Course Id " + courseId);
        }

        Enrollment enrollment = new Enrollment(studentId, courseId);
        enrollments.add(enrollment);
    }

    public void viewEnrollmentsForStudent(String studentId) {
        studentService.searchByStudentId(studentId);
        boolean enrollmentExists = false;

        for(Enrollment e: enrollments) {
            if(e.getStudentId().equals(studentId)) {
                System.out.println(e.toString());
                enrollmentExists = true;
            }
        }

        if(!enrollmentExists) {
            System.out.println("No enrollments exist for student with ID: " + studentId);
        }
    }

    public void changeEnrollmentStatus(String enrollmentId, EnrollmentStatus status) {

        Enrollment enrollment = enrollments.stream()
                .filter(e -> e.getId().equals(enrollmentId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No enrollment exist with id: " + enrollmentId));

        if(enrollment.getStatus().equals(status)) {
            System.out.println("Enrollment already has status: " + status);
            return;
        }

        enrollment.setStatus(status);
    }
}
