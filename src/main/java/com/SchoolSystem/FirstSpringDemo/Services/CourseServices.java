package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {


        @Autowired
        CourseRepository courseRepository;

    public  List<Course> getAllCourses() {
        return courseRepository.getAllCourses();}

        public Course getCourseById(Integer id){
            Course course = courseRepository.getCourseById(id);
            return course;
        }}







