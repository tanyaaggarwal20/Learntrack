package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.DuplicateEntityException;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private static List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        boolean exists = students.stream()
                        .anyMatch(s -> s.getId().equals(student.getId()));
        if(exists) {
            throw new DuplicateEntityException("Student already exists with ID: " + student.getId());
        }
        students.add(student);
    }

    public void deactivateStudent(String studentId) {
        students.stream()
                .filter(s -> s.getId().equals(studentId) && s.isActive())
                .findFirst()
                .orElseThrow(() ->
                        new EntityNotFoundException("No active student found with ID: " + studentId))
                .setActive(false);
    }

    public void viewAllStudents() {
        if(students.isEmpty()) {
            System.out.println("No students present in the system.");
            return;
        }
       for(Student s: students) {
           System.out.println(s);
       }
    }

    public Student searchByStudentId(String studentId) {
         return students.stream()
                .filter(s -> s.isActive() && s.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No student exist with Id: " + studentId));
    }
}

