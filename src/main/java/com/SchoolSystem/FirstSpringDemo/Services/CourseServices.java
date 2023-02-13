package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.CourseRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {


        @Autowired
        CourseRepository courseRepository;

        @Autowired
        StudentRepository studentRepository;



    public  List<Course> getAllCourses() {
        return courseRepository.getAllCourses();}

        public Course getCourseById(Integer id){
            Course course = courseRepository.getCourseById(id);
            return course;
        }

    public List<Course> getCoursesByStudentName(String studentName){

       Student student =studentRepository.getByStudentName(studentName);
        Integer studentId = student.getId();
        List<Course> courses = courseRepository.getCoursesByStudentId(studentId);
        return courses;
    }}












