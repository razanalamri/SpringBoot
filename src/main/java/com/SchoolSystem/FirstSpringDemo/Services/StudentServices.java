package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {
@Autowired
    StudentRepository studentRepository;

public void addStudent(){
    Student student=new Student();
    student.setStudentName("Shiam");
    student.setAge(7);
    student.setEmail("shiam@outlook.com");
    student.setPhoneNumber("93555987");
    studentRepository.save(student);
}
    public void deleteStudentById(Integer id){
        Student studentToDelete = studentRepository.findById(id).get();
        studentRepository.delete(studentToDelete);
    }
}
