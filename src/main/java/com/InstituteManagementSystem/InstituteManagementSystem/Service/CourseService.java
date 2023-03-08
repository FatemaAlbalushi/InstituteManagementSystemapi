package com.InstituteManagementSystem.InstituteManagementSystem.Service;

import com.InstituteManagementSystem.InstituteManagementSystem.Model.Course;
import com.InstituteManagementSystem.InstituteManagementSystem.Model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CourseService {
    public List<Course> listOfCourses = new CopyOnWriteArrayList<>();
    int currId = 1;

    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    public List<Course> getAllCourses() {
        logger.info("Getting all courses");
        return listOfCourses;
    }

    public Course getCourse(int id) {
        Optional<Course> foundRecord = listOfCourses.stream().filter(
                (currentCourse) -> currentCourse.getId() == id
        ).findFirst();

        logger.info("Getting course with id: " + id);
        return foundRecord.orElse(null);
    }

    public Course createCourse(Course course) {
        course.Courseid= currId++;
        listOfCourses.add(course);

        logger.info("Created course with id: " + course.Courseid);
        return course;
    }

    public Course updateCourse(int id, Course updatedCourse) {
        Course foundCourse = getCourse(id);
        foundCourse.CourseName= updatedCourse.CourseName;
        foundCourse.CourseDescription = updatedCourse.CourseDescription;

        logger.info("Updated course with id: " + id);
        return foundCourse;
    }

    public Course deleteCourse(int id) {
        Course foundCourse = getCourse(id);
        listOfCourses.remove(foundCourse);

        logger.info("Deleted course with id: " + id);
        return foundCourse;
    }

    public List<Student> getAppliedStudentsByCourseId(int courseId) {
        Course course = getCourse(courseId);
        return course.getStudents();
    }

    public void addAppliedStudentToCourse(int courseId, Student student) {
        Course course = getCourse(courseId);
        course.addStudent(student);
    }
}
