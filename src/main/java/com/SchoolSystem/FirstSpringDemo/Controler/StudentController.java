package com.SchoolSystem.FirstSpringDemo.Controler;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Services.ReportServices;
import com.SchoolSystem.FirstSpringDemo.Services.StudentServices;
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
@RequestMapping(value= "student")
public class StudentController {
    @Autowired
    StudentServices studentServices;
    @Autowired
    SlackClient slackClient;

    @Autowired
    ReportServices reportServices;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        List<Student> students = studentServices.getAllStudents();
        for(Student studentData : students) {
            slackClient.sendMessage(studentServices.formatStudentListForSlack(students).toString());
        }
        return students;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id){
        Student student=studentServices.getStudentById(id);
        slackClient.sendMessage(studentServices.formatStudentObjectForSlack(student).toString());
        return student;
    }

    @RequestMapping(value = "getByStudentName", method = RequestMethod.GET)
    public Student getByStudentName(@RequestParam String studentName){
        Student student=studentServices.getByStudentName(studentName);
        slackClient.sendMessage(studentServices.formatStudentObjectForSlack(student).toString());

        return student;
    }

    @RequestMapping(value = "getStudentsBySchoolId", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolId(@RequestParam Integer id){
        List<Student> students=studentServices.getStudentsBySchoolId(id);
        for(Student studentData : students) {
            slackClient.sendMessage(studentServices.formatStudentListForSlack(students).toString());
        }
        return students;
    }

    @RequestMapping(value = "getByAge", method = RequestMethod.GET)
    public Student getByAge(@RequestParam int age){
        Student student=studentServices.getByAge(age);
        slackClient.sendMessage(studentServices.formatStudentObjectForSlack(student).toString());

        return student;
    }


    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
    public List<Student> getAllActive(){
        List <Student> students = studentServices.getAllActive();
        for(Student studentData : students) {
            slackClient.sendMessage(studentServices.formatStudentListForSlack(students).toString());
        }
        return students;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<Student> getAllInActive(){
        List <Student> students = studentServices.getAllInActive();
        for(Student studentData : students) {
            slackClient.sendMessage(studentServices.formatStudentListForSlack(students).toString());
        }
        return students;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public List<Student> getLatestRow(){
        List <Student> students = studentServices.getLatestRow();
        for(Student studentData : students) {
            slackClient.sendMessage(studentServices.formatStudentListForSlack(students).toString());
        }
        return students;
    }
    @RequestMapping(value = "getLatestUpdate", method = RequestMethod.GET)
    public List<Student> getLatestUpdate(){
        List <Student> students = studentServices.getLatestUpdate();
        for(Student studentData : students) {
            slackClient.sendMessage(studentServices.formatStudentListForSlack(students).toString());
        }
        return students;
    }

    @RequestMapping(value = "deleteStudentById", method = RequestMethod.POST)
    public void deleteStudentById(@RequestParam Integer id){
        studentServices.deleteStudentById(id);

    }


    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAll(){
        studentServices.deleteAllStudents();
    }


    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public Student getByCreatedDate(@RequestParam Date createdDate){
        Student student=studentServices.getByCreatedDate(createdDate);
        slackClient.sendMessage(studentServices.formatStudentObjectForSlack(student).toString());

        return student;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public Student getByUpdatedDate(@RequestParam Date updatedDate){
        Student student=studentServices.getByUpdatedDate(updatedDate);
        slackClient.sendMessage(studentServices.formatStudentObjectForSlack(student).toString());

        return student;
    }

    @RequestMapping(value="getStudentCreatedAfterDate",method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Student> students = new ArrayList<>();
        students=studentServices.getStudentCreatedAfterDate(createdDate);
        for(Student studentData : students) {
            slackClient.sendMessage(studentServices.formatStudentListForSlack(students).toString());
        }
        return students;

    }

    @RequestMapping(value = "deleteAllStudentsCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllStudentsCreatedAfterDate(@RequestParam String createdDate)throws ParseException{
        studentServices.deleteAllStudentsCreatedAfterDate(createdDate);
    }
    @RequestMapping(value = "deleteStudentByStudentName", method = RequestMethod.POST)
    public void deleteStudentByStudentName(@RequestParam String studentName)throws ParseException{
        studentServices.deleteStudentByStudentName(studentName);

    }

    @RequestMapping(value = "deleteStudentByCreatedDate", method = RequestMethod.POST)
    public void deleteStudentByCreatedDate(@RequestParam String createdDate)throws ParseException{
        studentServices.deleteStudentByCreatedDate(createdDate);

    }

    @RequestMapping(value = "deleteStudentByUpdatedDate", method = RequestMethod.POST)
    public void deleteStudentByUpdatedDate(@RequestParam String updatedDate)throws ParseException{
        studentServices.deleteStudentByUpdatedDate(updatedDate);

    }


    @RequestMapping(value = "createStudent", method = RequestMethod.POST)
    public void createStudent(@RequestParam String studentName, String email,String phoneNumber, int age, int id ) {
        studentServices.createStudent(studentName,email,phoneNumber,age,id);
    }

    @RequestMapping(value = "updateStudent",method = RequestMethod.POST)
    public void updateStudent(@RequestParam Integer Id,String studentName,Boolean isActive){
        studentServices.updateStudent(Id,studentName,isActive);
    }

    @RequestMapping(value = "deleteStudentByAge", method = RequestMethod.POST)
    public void deleteStudentByAge(@RequestParam int age)throws ParseException{
        studentServices.deleteStudentByAge(age);
    }

    @RequestMapping(value = "deleteStudentBySchoolId", method = RequestMethod.POST)
    public List<Student> deleteStudentBySchoolId(@RequestParam Integer id)throws ParseException{
        List<Student> students = new ArrayList<>();
        studentServices.deleteStudentBySchoolId(id);
        return students;

    }

    @RequestMapping(value = "report")
    public String generateReportForStudent() throws JRException, FileNotFoundException {
        return reportServices.generateReportForStudent();
    }

    @RequestMapping(value = "OverAllPerformance")
    public String OverAllPerformance() throws Exception {
        return reportServices.OverAllPerformance();
    }

    @RequestMapping(value = "TotalNumberOfStudentsInEachSchool")
    public String TotalNumberOfStudentsInEachSchool() throws Exception {
        return reportServices.TotalNumberOfStudentsInEachSchool();
    }

}
