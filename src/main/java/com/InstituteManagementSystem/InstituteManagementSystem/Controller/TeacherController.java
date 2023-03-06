package com.InstituteManagementSystem.InstituteManagementSystem.Controller;


import com.InstituteManagementSystem.InstituteManagementSystem.Model.Teacher;
import com.InstituteManagementSystem.InstituteManagementSystem.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The TeacherController class is a REST controller for managing Teacher data in the Institute Management System.
 */
@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService TeacherService;

    /**
     * Retrieve a list of all Teacher
     * @return a list of all Teacher
     */
    @GetMapping
    public List<Teacher> getTeacher(){
        return TeacherService.getAllTeacher();
    }

    /**
     * Retrieve a specific Teacher by ID
     * @param id the ID of the Teacher to retrieve
     * @return the Teacher with the specified ID
     */
    @GetMapping(path = "/{id}")
    public Teacher getTeacher(@PathVariable(name="id") int id){
        return TeacherService.getTeacher(id);
    }

    /**
     * Create a new Teacher
     * @param currTeacher Teacher to create
     * @return the newly created Teacher
     */
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher currTeacher){
        TeacherService.createTeacher(currTeacher);
        return currTeacher;
    }

    /**
     * Update an existing Teacher
     * @param id the ID of the Teacher to update
     * @param currTeacher the updated Teacher data
     * @return the updated Teacher
     */
    @PutMapping(path = "/{id}")
    public Teacher updateTeacher(@PathVariable(name="id") int id, @RequestBody Teacher currTeacher){
        TeacherService.updateTeacher(id, currTeacher);
        return currTeacher;
    }

    /**
     * Delete a Teacher
     * @param id the ID of the Teacher to delete
     * @return the deleted Teacher
     */
    @DeleteMapping(path = "/{id}")
    public Teacher deleteTeacher(@PathVariable(name="id") int id) {
        return TeacherService.deleatTeacher(id);
    }
}
