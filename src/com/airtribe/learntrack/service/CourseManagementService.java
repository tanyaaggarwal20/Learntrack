package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.DuplicateEntityException;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseManagementService {

    private static List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        boolean courseExists = courses.stream().anyMatch(c -> c.getId().equals(course.getId()));

        if(courseExists) {
            throw new DuplicateEntityException("Course already exists with id: " + course.getId());
        }

        courses.add(course);
    }

    public void viewAllCourses() {
        if(courses.isEmpty()) {
            System.out.println("No courses exists in the system!");
            return;
        }
        for(Course c: courses) {
            System.out.println(c);
        }
    }

    public Course searchByCourseId(String courseId) {
        return courses.stream()
                .filter(c -> c.isActive() && c.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No course exist with Id: " + courseId));
    }

    public void activateCourse(String courseId) {
        courses.stream()
                .filter(c -> c.getId().equals(courseId) && !c.isActive())
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No inactive course found with ID: " + courseId))
                .setActive(true);
    }

    public void deactivateCourse(String courseId) {
        courses.stream()
                .filter(c -> c.getId().equals(courseId) && c.isActive())
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No active course found with ID: " + courseId))
                .setActive(false);
    }
}
