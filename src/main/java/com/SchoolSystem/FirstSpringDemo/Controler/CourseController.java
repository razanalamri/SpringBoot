package com.SchoolSystem.FirstSpringDemo.Controler;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.SchoolSystem.FirstSpringDemo.Services.CourseServices;
import com.SchoolSystem.FirstSpringDemo.Services.ReportServices;
import com.SchoolSystem.FirstSpringDemo.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "course" )
public class CourseController {
    @Autowired
    CourseServices courseServices;

    @Autowired
    SlackClient slackClient;

    @Autowired
    ReportServices reportServices;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses(){
        List<Course> courses = courseServices.getAllCourses();
        for(Course courseData : courses) {
            slackClient.sendMessage(courseServices.formatCourseListForSlack(courses).toString());
        }
        return courses;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer id){
        Course course=courseServices.getCourseById(id);
        slackClient.sendMessage(courseServices.formatCourseObjectForSlack(course).toString());
        return course;
    }

    @RequestMapping(value = "getByCourseName", method = RequestMethod.GET)
    public Course getByCourseName(@RequestParam String courseName){
        Course course=courseServices.getByCourseName(courseName);
        slackClient.sendMessage(courseServices.formatCourseObjectForSlack(course).toString());
        return course;
    }

    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
    public List<Course> getAllActive(){
        List <Course> courses = courseServices.getAllActive();
        for(Course courseData : courses) {
            slackClient.sendMessage(courseServices.formatCourseListForSlack(courses).toString());
        }
        return courses;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<Course> getAllInActive(){
        List <Course> courses = courseServices.getAllInActive();
        for(Course courseData : courses) {
            slackClient.sendMessage(courseServices.formatCourseListForSlack(courses).toString());
        }
        return courses;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public List<Course> getLatestRow(){
        List <Course> courses = courseServices.getLatestRow();
        for(Course courseData : courses) {
            slackClient.sendMessage(courseServices.formatCourseListForSlack(courses).toString());
        }
        return courses;
    }
    @RequestMapping(value = "getLatestUpdate", method = RequestMethod.GET)
    public List<Course> getLatestUpdate(){
        List <Course> courses = courseServices.getLatestUpdate();
        for(Course courseData : courses) {
            slackClient.sendMessage(courseServices.formatCourseListForSlack(courses).toString());
        }
        return courses;
    }

    @RequestMapping(value = "deleteCourseById", method = RequestMethod.POST)
    public void deleteCourseById(@RequestParam Integer id){
        courseServices.deleteCourseById(id);

    }


    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAll(){
        courseServices.deleteAllCourses();
    }


    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public Course getByCreatedDate(@RequestParam Date createdDate){
        Course course=courseServices.getByCreatedDate(createdDate);
        slackClient.sendMessage(courseServices.formatCourseObjectForSlack(course).toString());
        return course;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public Course getByUpdatedDate(@RequestParam Date updatedDate){
        Course course=courseServices.getByUpdatedDate(updatedDate);
        slackClient.sendMessage(courseServices.formatCourseObjectForSlack(course).toString());
        return course;
    }

    @RequestMapping(value="getCourseCreatedAfterDate",method = RequestMethod.GET)
    public List<Course> getCourseCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Course> courses = new ArrayList<>();
        courses=courseServices.getCourseCreatedAfterDate(createdDate);
        for(Course courseData : courses) {
            slackClient.sendMessage(courseServices.formatCourseListForSlack(courses).toString());
        }
        return courses;

    }
    @RequestMapping(value = "getAllActiveCoursesForAStudent", method = RequestMethod.GET)
    public List<Course> getAllActiveCoursesForAStudent(@RequestParam Integer id) throws ParseException{
        List<Course> courses = courseServices.getCoursesByStudentId(id);
        for(Course courseData : courses) {
            slackClient.sendMessage(courseServices.formatCourseListForSlack(courses).toString());
        }
        return courses;
    }

    @RequestMapping(value = "deleteAllCoursesCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllCoursesCreatedAfterDate(@RequestParam String createdDate)throws ParseException{
        courseServices.deleteAllCoursesCreatedAfterDate(createdDate);
    }
    @RequestMapping(value = "deleteCourseByCourseName", method = RequestMethod.POST)
    public void deleteCourseByCourseName(@RequestParam String courseName)throws ParseException{
        courseServices.deleteCourseByCourseName(courseName);

    }

    @RequestMapping(value = "deleteCourseByCreatedDate", method = RequestMethod.POST)
    public void deleteCourseByCreatedDate(@RequestParam String createdDate)throws ParseException{
        courseServices.deleteCourseByCreatedDate(createdDate);

    }

    @RequestMapping(value = "deleteCourseByUpdatedDate", method = RequestMethod.POST)
    public void deleteCourseByUpdatedDate(@RequestParam String updatedDate)throws ParseException{
        courseServices.deleteCourseByUpdatedDate(updatedDate);

    }


    @RequestMapping(value = "createCourse", method = RequestMethod.POST)
    public void createCourse(@RequestParam String courseName) {
        courseServices.createCourse(courseName);
    }

    @RequestMapping(value = "updateCourse",method = RequestMethod.POST)
    public void updateCourse(@RequestParam Integer Id,String courseName,Boolean isActive){
        courseServices.updateCourse(Id,courseName,isActive);
    }

    @RequestMapping(value = "deleteCourseByStudentId", method = RequestMethod.POST)
    public List<Course> deleteCourseByStudentId(@RequestParam Integer id)throws ParseException{
        List<Course> Courses = new ArrayList<>();
        courseServices.deleteCourseByStudentId(id);
        return Courses;
    }

    @RequestMapping(value = "getCoursesByStudentId", method = RequestMethod.GET)
    public List<Course> getCoursesByStudentId(@RequestParam Integer id){
        List<Course> courses=courseServices.getCoursesByStudentId(id);
        for(Course courseData : courses) {
            slackClient.sendMessage(courseServices.formatCourseListForSlack(courses).toString());
        }
        return courses;
    }

//    @RequestMapping(value = "report")
//    public String generateReportForCourse() throws JRException, FileNotFoundException {
//        return reportServices.generateReportForCourse();
//    }

    @RequestMapping(value = "CoursesAndAverageMarksReport")
    public String generateCoursesAndAverageMarksReport() throws FileNotFoundException, JRException {
        return reportServices.averageMarksReport();
    }


}
