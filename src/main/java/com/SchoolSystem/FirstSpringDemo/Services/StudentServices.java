package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.SchoolRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
@Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudent();
    }

    public Student getStudentById(Integer id){
        Student student= studentRepository.getStudentById(id);
        return student;
    }
}
