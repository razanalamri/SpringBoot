package com.SchoolSystem.FirstSpringDemo.Controler;


import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "student")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents(){

        List<Student> students = studentServices.getAllStudents();
        return students;
    }

    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id){
        Student student=studentServices.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "student/getByStudentName", method = RequestMethod.GET)
    public Student getByStudentName(@RequestParam String studentName){
        Student student=studentServices.getByStudentName(studentName);
        return student;
    }
}
