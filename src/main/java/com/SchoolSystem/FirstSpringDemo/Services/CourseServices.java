package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.CourseRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public Course getByCourseName(String courseName) {
        Course course = courseRepository.getByCourseName(courseName);
        return course;
    }

    public List<Course> getCoursesByStudentName(String studentName){

       Student student =studentRepository.getByStudentName(studentName);
        Integer id = student.getId();
        List<Course> courses = courseRepository.getCoursesByStudentId(id);
        return courses;
    }
    public List<Course> getCoursesByStudentId(Integer id) {
        List<Course> courses = courseRepository.getCoursesByStudentId(id);
        return courses;
    }


    public List<Course> getAllActive(){return courseRepository.getAllActive();}

    public List<Course> getAllInActive(){return courseRepository.getAllInActive();}
    public List<Course> getLatestRow(){return courseRepository.getLatestRow();}

    public List<Course> getLatestUpdate(){return courseRepository.getLatestRow();}

    public void deleteCourseById(Integer id){
        Course course= courseRepository.getCourseById(id);
        course.setActive(false);
        courseRepository.save(course);
    }


    public void deleteAllCourses(){

        courseRepository.deleteAllCourses();
    }


    public void setCreatedDateByUserInput(String stringDate, Integer id)throws ParseException {
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        Course course=courseRepository.getCourseById(id);
        course.setCreatedDate(javaDate);
        courseRepository.save(course);
    }
    public Course getByCreatedDate(Date createdDate){
        Course course= courseRepository.getByCreatedDate(createdDate);
        return course;
    }

    public Course getByUpdatedDate(Date updatedDate){
        Course course= courseRepository.getByUpdatedDate(updatedDate);
        return course;
    }

    public List<Course> getCourseCreatedAfterDate(String stringDate)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        List<Course> courses = courseRepository.getCourseCreatedAfterDate(javaDate);
        return courses;
    }

    public void deleteCourseByCourseName(String courseName)throws ParseException{
        Course course= courseRepository.getByCourseName(courseName);
        course.setActive(false);
        courseRepository.save(course);

    }

    public void deleteCourseByCreatedDate(String stringDate)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        Course course= courseRepository.getByCreatedDate(javaDate);
        course.setActive(false);
        courseRepository.save(course);

    }

    public void deleteCourseByUpdatedDate(String stringDate)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        Course course= courseRepository.getByUpdatedDate(javaDate);
        course.setActive(false);
        courseRepository.save(course);

    }


    public void deleteAllCoursesCreatedAfterDate(String createdDate)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(createdDate);
        List<Course> courseList =courseRepository.deleteAllCoursesCreatedAfterDate(javaDate);
        courseList.stream().forEach(x -> x.setActive(false));
        courseRepository.saveAll(courseList);
    }


    public void  createCourse(String courseName) {
        Course course=new Course();
        course.setCourseName(courseName);
        course.setActive(true);
        course.setCreatedDate(new Date());
        courseRepository.save(course);
    }

    public void updateCourse(Integer Id,String courseName, Boolean isActive){
        Course course =courseRepository.getCourseById(Id);
        course.setCourseName(courseName);
        course.setCreatedDate(new Date());
        course.setActive(isActive);
        courseRepository.save(course);
    }

    public void deleteCourseByStudentId(Integer id)throws ParseException{
        List<Course> course= courseRepository.deleteCourseByStudentId(id);
        course.stream().forEach(x -> x.setActive(false));
        courseRepository.saveAll(course);

    }
    public List<Course> getAllActiveCoursesForAStudent(Integer id)throws ParseException {
        List<Course> courses = courseRepository.getAllActiveCoursesForAStudent(id);
        return courses;
    }
    public StringBuilder formatCourseObjectForSlack(Course course){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: *" + course.getId()+ "*\n");
        sb.append("Course Name: *" + course.getCourseName() +"*\n");
        sb.append("Updated date :*"+course.getUpdatedDate()+"*\n");
        sb.append("Created date:*"+course.getCreatedDate()+"*\n");
        sb.append("Is Active: *" + course.getActive() + "*\n");
        return sb;
    }

    public StringBuilder formatCourseListForSlack(List<Course> courses){
        StringBuilder mainStringBuilder = new StringBuilder();
        for (Course courseFromListOfCourses: courses) {
            mainStringBuilder.append(formatCourseObjectForSlack(courseFromListOfCourses));
            mainStringBuilder.append("\n");
        }
        return mainStringBuilder;
    }

}












