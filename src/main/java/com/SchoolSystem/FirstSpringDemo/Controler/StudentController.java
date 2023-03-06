package com.SchoolSystem.FirstSpringDemo.Controler;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.SchoolSystem.FirstSpringDemo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "student")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        List<Student> students = studentServices.getAllStudents();
        return students;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id){
        Student student=studentServices.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "getByStudentName", method = RequestMethod.GET)
    public Student getByStudentName(@RequestParam String studentName){
        Student student=studentServices.getByStudentName(studentName);
        return student;
    }

    @RequestMapping(value = "getByAge", method = RequestMethod.GET)
    public Student getByAge(@RequestParam int age){
        Student student=studentServices.getByAge(age);
        return student;
    }


    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
    public List<Student> getAllActive(){
        List <Student> students = studentServices.getAllActive();
        return students;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<Student> getAllInActive(){
        List <Student> students = studentServices.getAllInActive();
        return students;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public List<Student> getLatestRow(){
        List <Student> students = studentServices.getLatestRow();
        return students;
    }
    @RequestMapping(value = "getLatestUpdate", method = RequestMethod.GET)
    public List<Student> getLatestUpdate(){
        List <Student> students = studentServices.getLatestUpdate();
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
        return student;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public Student getByUpdatedDate(@RequestParam Date updatedDate){
        Student student=studentServices.getByUpdatedDate(updatedDate);
        return student;
    }

    @RequestMapping(value="getStudentCreatedAfterDate",method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Student> students = new ArrayList<>();
        students=studentServices.getStudentCreatedAfterDate(createdDate);
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

}
