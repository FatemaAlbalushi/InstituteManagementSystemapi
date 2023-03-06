package com.InstituteManagementSystem.InstituteManagementSystem.Service;


import com.InstituteManagementSystem.InstituteManagementSystem.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TeacherService {
    /**
     * Retrieve a list of all Teacher.
     * @return a list of all Teacher
     */
    public  List<Teacher> listofTeacher = new CopyOnWriteArrayList<>();
    int currId = 1;

    /**
     * Retrieve a list of all Teacher.
     * @return a list of all Teacher
     */
    public List<Teacher>getAllTeacher(){
        return listofTeacher;
    }

    /**
     * Retrieve a specific Teacher by ID.
     * @param id the ID of the Teacher to retrieve
     * @return the Teacher with the specified ID
     */
    public Teacher getTeacher(int id) {
        Optional<Teacher> foundRecode =  listofTeacher.stream().filter(
                (currentTeacher) -> {
                    return currentTeacher.id == id;
                }
        ).findFirst();

        return foundRecode.orElse(null);

    }

    /**
     * Create a new Teacher.
     * @param currTeacher the Teacher to create
     * @return the newly created Teacher
     */
    public  Teacher createTeacher(Teacher currTeacher){
        currTeacher.id=this.currId ++;
        listofTeacher.add(currTeacher);
        return currTeacher;
    }

    /**
     * Update an existing Teacher.
     * @param id the ID of the Teacher to update
     * @param updatedTeacher the updated Teacher data
     * @return the updated Teacher
     */
    public Teacher updateTeacher(int id, Teacher updatedTeacher){
        Teacher foundTeacher = getTeacher(id);
        foundTeacher.name = updatedTeacher.name;
        foundTeacher.email= updatedTeacher.email;
        foundTeacher.salary= updatedTeacher.salary;
        return foundTeacher;
    }

    /**
     * Delete a Teacher.
     * @param id the ID of the Teacher to delete
     * @return the deleted Teacher
     */
    public Teacher deleatTeacher(int id){
        Teacher foundTeacher = getTeacher(id);
        listofTeacher.remove(foundTeacher);
        return foundTeacher;
    }
}
