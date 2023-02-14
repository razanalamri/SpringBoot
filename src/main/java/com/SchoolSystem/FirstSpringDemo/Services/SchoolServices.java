package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Repositry.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchoolServices {

    @Autowired
    SchoolRepository schoolRepository;

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

}
