package com.SchoolSystem.FirstSpringDemo.Controler;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Mark;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Services.CourseServices;
import com.SchoolSystem.FirstSpringDemo.Services.MarkServices;
import com.SchoolSystem.FirstSpringDemo.Services.SchoolServices;
import com.SchoolSystem.FirstSpringDemo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    StudentServices studentServices;

    @Autowired
    SchoolServices schoolServices;

    @Autowired
    CourseServices courseServices;

    @Autowired
    MarkServices markServices;

    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools(){

    List<School> schools = schoolServices.getAllSchools();
    return schools;
   }

    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents(){

        List<Student> students = studentServices.getAllStudents();
        return students;
    }

    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses(){

        List<Course> courses = courseServices.getAllCourses();
        return courses;
    }

    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMarks(){

        List<Mark> marks = markServices.getAllMarks();
        return marks;
    }

    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer id){
        School school=schoolServices.getSchoolById(id);
        return school;
    }
    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id){
        Student student=studentServices.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer id){
        Course course=courseServices.getCourseById(id);
        return course;
    }

    @RequestMapping(value = "mark/getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer id){
        Mark mark=markServices.getMarkById(id);
        return mark;
    }
    @RequestMapping(value = "school/getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String schoolName){
        School school=schoolServices.getBySchoolName(schoolName);
        return school;
    }

    @RequestMapping(value = "student/getByStudentName", method = RequestMethod.GET)
    public Student getByStudentName(@RequestParam String studentName){
        Student student=studentServices.getByStudentName(studentName);
        return student;
    }
    @RequestMapping(value = "course/getByCourseName", method = RequestMethod.GET)
    public Course getByCourseName(@RequestParam String courseName){
        Course course=courseServices.getByCourseName(courseName);
        return course;
    }


    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {
        return studentServices.getStudentsBySchoolName(schoolName);

    }

    @RequestMapping(value = "course/getCoursesByStudentName", method = RequestMethod.GET)
    public List<Course> getCoursesByStudentName(@RequestParam String studentName) {
        return courseServices.getCoursesByStudentName(studentName);

    }

    @RequestMapping(value = "mark/getMarksByCourseName", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseName(@RequestParam String courseName) {
        return markServices.getMarksByCourseName(courseName);
    }






}
