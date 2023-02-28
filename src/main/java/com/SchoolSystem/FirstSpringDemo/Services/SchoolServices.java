package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Repositry.SchoolRepository;
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
    SchoolRepository schoolRepository; //Reference of SchoolRepository interface

    public List<School> getAllSchools(){
       return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id){
        School school= schoolRepository.getSchoolById(id);
        return school;
    }

    public School getBySchoolName(String schoolName){
        School school= schoolRepository.getBySchoolName(schoolName);
        return school;

}
    public List<School> getAllActive(){return schoolRepository.getAllActive();}

    public List<School> getAllInActive(){return schoolRepository.getAllInActive();}
    public List<School> getLatestRow(){return schoolRepository.getLatestRow();}

    public School deleteId(Integer id){
        School school= schoolRepository.deleteId(id);
        return school;
    }
    public List<School> deleteAllSchools(){
        return schoolRepository.deleteAllSchools();
    }

    public void setCreatedDateByUserInput(String stringDate, Integer id)throws ParseException{
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringDate);
        School school=schoolRepository.getSchoolById(id);
        school.setCreatedDate(javaDate);
        schoolRepository.save(school);
    }
}
