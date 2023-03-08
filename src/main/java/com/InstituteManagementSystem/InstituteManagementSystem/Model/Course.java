package com.InstituteManagementSystem.InstituteManagementSystem.Model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    public int Courseid;
    public String CourseName;
    public List<Student> students;
    public List<Teacher> teachers;
    public String CourseDescription;


    public int getId() {
        return Courseid;
    }

    public void setId(int id) {
        this.Courseid = id;
    }

    public String getName() {
        return CourseName;
    }

    public void setName(String name) {
        this.CourseName = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getDescription() {
        return CourseDescription;
    }

    public void setDescription(String description) {
        this.CourseDescription = description;
    }
}
