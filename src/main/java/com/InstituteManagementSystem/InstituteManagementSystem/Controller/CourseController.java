package com.InstituteManagementSystem.InstituteManagementSystem.Controller;

import com.InstituteManagementSystem.InstituteManagementSystem.Model.Course;
import com.InstituteManagementSystem.InstituteManagementSystem.Model.Student;
import com.InstituteManagementSystem.InstituteManagementSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;


    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourse(id);
    }


    @PostMapping("")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public Course deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }
    @GetMapping("/{id}/applied-students")
    public List<Student> getAppliedStudentsByCourseId(@PathVariable int id) {
        return courseService.getAppliedStudentsByCourseId(id);
    }

    @PostMapping("/{id}/applied-students/add")
    public void addAppliedStudentToCourse(@PathVariable int id, @RequestBody Student student) {
        courseService.addAppliedStudentToCourse(id, student);
    }

}
