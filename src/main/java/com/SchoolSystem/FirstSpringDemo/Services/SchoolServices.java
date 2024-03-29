package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Repositry.SchoolRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SchoolServices {

    @Autowired
    SchoolRepository schoolRepository;//Reference of SchoolRepository interface
    StudentRepository studentRepository;


    public List<School> getAllSchools() {
        return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    public School getBySchoolName(String schoolName) {
        School school = schoolRepository.getBySchoolName(schoolName);
        return school;

    }

    public List<School> getAllActive() {
        return schoolRepository.getAllActive();
    }

    public List<School> getAllInActive() {
        return schoolRepository.getAllInActive();
    }

    public List<School> getLatestRow() {
        return schoolRepository.getLatestRow();
    }

    public List<School> getLatestUpdate() {
        return schoolRepository.getLatestRow();
    }

    public void deleteSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        school.setActive(false);
        schoolRepository.save(school);
    }


    public void deleteAllSchools() {

        schoolRepository.deleteAllSchools();
    }


    public void setCreatedDateByUserInput(String stringDate, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(javaDate);
        schoolRepository.save(school);
    }

    public School getByCreatedDate(Date createdDate) {
        School school = schoolRepository.getByCreatedDate(createdDate);
        return school;
    }

    public School getByUpdatedDate(Date updatedDate) {
        School school = schoolRepository.getByUpdatedDate(updatedDate);
        return school;
    }

    public List<School> getSchoolCreatedAfterDate(String stringDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        List<School> schoolList = schoolRepository.getSchoolCreatedAfterDate(javaDate);
        return schoolList;
    }

    public void deleteSchoolBySchoolName(String schoolName) throws ParseException {
        School school = schoolRepository.getBySchoolName(schoolName);
        school.setActive(false);
        schoolRepository.save(school);

    }

    public void deleteSchoolByCreatedDate(String stringDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        School school = schoolRepository.getByCreatedDate(javaDate);
        school.setActive(false);
        schoolRepository.save(school);

    }

    public void deleteSchoolByUpdatedDate(String stringDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        School school = schoolRepository.getByUpdatedDate(javaDate);
        school.setActive(false);
        schoolRepository.save(school);

    }


    public void deleteAllSchoolsCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(createdDate);
        List<School> schoolList = schoolRepository.deleteAllSchoolsCreatedAfterDate(javaDate);
        schoolList.stream().forEach(x -> x.setActive(false));
        schoolRepository.saveAll(schoolList);
    }


    public void createSchool(String schoolName) {
        School school = new School();
        school.setSchoolName(schoolName);
        school.setActive(true);
        school.setCreatedDate(new Date());
        schoolRepository.save(school);
    }

    public void updateSchool(Integer Id, String schoolName, Boolean isActive) {
        School school = schoolRepository.getSchoolById(Id);
        school.setSchoolName(schoolName);
        school.setCreatedDate(new Date());
        school.setActive(isActive);
        schoolRepository.save(school);
    }

    public StringBuilder formatSchoolObjectForSlack(School school){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: *" + school.getId() + "*\n");
        sb.append("School Name: *" + school.getSchoolName() + "*\n");
        sb.append("Updated date :*"+school.getUpdatedDate()+"*\n");
        sb.append("Created date:*"+school.getCreatedDate()+"*\n");
        sb.append("Is Active: *" + school.getActive() + "*\n");
        return sb;
    }

    public StringBuilder formatSchoolListForSlack(List<School> schools){
        StringBuilder mainStringBuilder = new StringBuilder();
        for (School schoolFromListOfSchools: schools) {
            mainStringBuilder.append(formatSchoolObjectForSlack(schoolFromListOfSchools));
            mainStringBuilder.append("\n");
        }
        return mainStringBuilder;
    }




}








