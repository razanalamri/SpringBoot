package com.SchoolSystem.FirstSpringDemo.Controler;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "course" )
public class CourseController {
    @Autowired
    CourseServices courseServices;

    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses(){

        List<Course> courses = courseServices.getAllCourses();
        return courses;
    }

    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer id){
        Course course=courseServices.getCourseById(id);
        return course;
    }

    @RequestMapping(value = "course/getByCourseName", method = RequestMethod.GET)
    public Course getByCourseName(@RequestParam String courseName){
        Course course=courseServices.getByCourseName(courseName);
        return course;
    }
}
