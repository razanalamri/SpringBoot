package com.SchoolSystem.FirstSpringDemo.ScheduledJops;

import com.SchoolSystem.FirstSpringDemo.Controler.SchoolController;
import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Mark;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.SchoolRepository;
import com.SchoolSystem.FirstSpringDemo.Services.CourseServices;
import com.SchoolSystem.FirstSpringDemo.Services.MarkServices;
import com.SchoolSystem.FirstSpringDemo.Services.SchoolServices;
import com.SchoolSystem.FirstSpringDemo.Services.StudentServices;
import com.SchoolSystem.FirstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Schedule {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolServices schoolServices;
    @Autowired
    StudentServices studentServices;
    @Autowired
    CourseServices courseServices;
    @Autowired
    MarkServices markServices;

    @Scheduled(cron = "0 0/15 * * * *")
    public List<School> getAllSchools(){
        List<School> schools = schoolServices.getAllSchools();
        for (School schoolData : schools) {
            slackClient.sendMessage(schoolData.getId().toString());
            slackClient.sendMessage(schoolData.getSchoolName());
            slackClient.sendMessage(schoolData.getCreatedDate().toString());
            slackClient.sendMessage(schoolData.getUpdatedDate().toString());
            slackClient.sendMessage(schoolData.getActive().toString());

        }
        return schools;
    }

    @Scheduled(cron = "0 0/15 * * * *")
    public List<Student> getAllStudents(){
        List<Student> students = studentServices.getAllStudents();
        for(Student studentData : students) {
            slackClient.sendMessage(studentData.getId().toString());
            slackClient.sendMessage(studentData.getStudentName());
            slackClient.sendMessage(studentData.getAge().toString());
            slackClient.sendMessage(studentData.getPhoneNumber());
            slackClient.sendMessage(studentData.getEmail());
            slackClient.sendMessage(studentData.getCreatedDate().toString());
            slackClient.sendMessage(studentData.getUpdatedDate().toString());
            slackClient.sendMessage(studentData.getActive().toString());
        }
        return students;
    }
    @Scheduled(cron = "0 0/15 * * * *")
    public List<Course> getAllCourses(){

        List<Course> courses = courseServices.getAllCourses();
        for(Course courseData : courses) {
            slackClient.sendMessage(courseData.getId().toString());
            slackClient.sendMessage(courseData.getCourseName());
            slackClient.sendMessage(courseData.getCreatedDate().toString());
            slackClient.sendMessage(courseData.getUpdatedDate().toString());
            slackClient.sendMessage(courseData.getActive().toString());
        }
        return courses;
    }
    @Scheduled(cron = "0 0/15 * * * *")
    public List<Mark> getAllMarks(){

        List<Mark> marks = markServices.getAllMarks();
        for(Mark markData : marks) {
            slackClient.sendMessage(markData.getId().toString());
            slackClient.sendMessage(markData.getObtainedMarks().toString());
            slackClient.sendMessage(markData.getGrade().toString());
            slackClient.sendMessage(markData.getCreatedDate().toString());
            slackClient.sendMessage(markData.getUpdatedDate().toString());
            slackClient.sendMessage(markData.getActive().toString());
        }
        return marks;
    }







}
