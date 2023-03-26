package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServices {
   @Autowired
    StudentRepository studentRepository;
   @Autowired
   SchoolServices schoolServices;

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudent();
    }

    public Student getByStudentName(String studentName) {
        Student student = studentRepository.getByStudentName(studentName);
        return student;
    }


        public Student getStudentById(Integer id){
        Student student= studentRepository.getStudentById(id);
        return student;
    }

    public List<Student> getStudentsBySchoolId(Integer id) {
        List<Student> students = studentRepository.getStudentsBySchoolId(id);
        return students;
    }


    public List<Student> getStudentsBySchoolName(String studentName){
        Student student = studentRepository.getByStudentName(studentName);
        Integer studentId = student.getId();
        List<Student> students = studentRepository.getStudentsBySchoolId(studentId);
        return students;
    }

       public Student getByAge(int age){
        Student student= studentRepository.getByAge(age);
        return student;
    }


    public List<Student> getAllActive(){return studentRepository.getAllActive();}

    public List<Student> getAllInActive(){return studentRepository.getAllInActive();}
    public List<Student> getLatestRow(){return studentRepository.getLatestRow();}

    public List<Student> getLatestUpdate(){return studentRepository.getLatestRow();}

    public void deleteStudentById(Integer id){
        Student student= studentRepository.getStudentById(id);
        student.setActive(false);
        studentRepository.save(student);
    }


    public void deleteAllStudents(){

        studentRepository.deleteAllStudents();
    }

    public Student getByCreatedDate(Date createdDate){
        Student student= studentRepository.getByCreatedDate(createdDate);
        return student;
    }

    public Student getByUpdatedDate(Date updatedDate){
        Student student= studentRepository.getByUpdatedDate(updatedDate);
        return student;
    }

    public List<Student> getStudentCreatedAfterDate(String stringDate)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        List<Student> students = studentRepository.getStudentCreatedAfterDate(javaDate);
        return students;
    }

    public void deleteStudentByStudentName(String studentName)throws ParseException{
        Student student= studentRepository.getByStudentName(studentName);
        student.setActive(false);
        studentRepository.save(student);

    }

    public void deleteStudentByAge(int age)throws ParseException{
        Student student= studentRepository.getByAge(age);
        student.setActive(false);
        studentRepository.save(student);

    }

    public void deleteStudentByCreatedDate(String stringDate)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        Student student= studentRepository.getByCreatedDate(javaDate);
        student.setActive(false);
        studentRepository.save(student);

    }

    public void deleteStudentByUpdatedDate(String stringDate)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        Student student= studentRepository.getByUpdatedDate(javaDate);
        student.setActive(false);
        studentRepository.save(student);

    }


    public void deleteAllStudentsCreatedAfterDate(String createdDate)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(createdDate);
        List<Student> students =studentRepository.deleteAllStudentsCreatedAfterDate(javaDate);
        students.stream().forEach(x -> x.setActive(false));
        studentRepository.saveAll(students);
    }


    public void  createStudent(String studentName, String email,String phoneNumber, int age, int id ) {
        Student student=new Student();
        student.setStudentName(studentName);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setActive(true);
        student.setCreatedDate(new Date());
        student.setAge(age);
        student.setSchool(schoolServices.getSchoolById(id));
        studentRepository.save(student);
    }

    public void updateStudent(Integer Id,String studentName, Boolean isActive){
       Student student =studentRepository.getStudentById(Id);
        student.setStudentName(studentName);
        student.setCreatedDate(new Date());
        student.setActive(isActive);
        studentRepository.save(student);
    }

    public void deleteStudentBySchoolId(Integer id)throws ParseException{
        List<Student> student= studentRepository.getStudentsBySchoolId(id);
        student.stream().forEach(x -> x.setActive(false));
        studentRepository.saveAll(student);

    }

    public StringBuilder formatStudentObjectForSlack(Student student){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: *" + student.getId()+ "*\n");
        sb.append("Student Name: *" + student.getStudentName()+ "*\n");
        sb.append("Age: *" + student.getAge()+ "*\n");
        sb.append("Phone Number: *" + student.getPhoneNumber()+ "*\n");
        sb.append("Email : *" + student.getEmail()+ "*\n");
        sb.append("Updated date :*"+student.getUpdatedDate()+"*\n");
        sb.append("Created date:*"+student.getCreatedDate()+"*\n");
        sb.append("Is Active: *" + student.getActive() + "*\n");
        return sb;
    }

    public StringBuilder formatStudentListForSlack(List<Student> students){
        StringBuilder mainStringBuilder = new StringBuilder();
        for (Student studentFromListOfStudents: students) {
            mainStringBuilder.append(formatStudentObjectForSlack(studentFromListOfStudents));
            mainStringBuilder.append("\n");
        }
        return mainStringBuilder;
    }




}






