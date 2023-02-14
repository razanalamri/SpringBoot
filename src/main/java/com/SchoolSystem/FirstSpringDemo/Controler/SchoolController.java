package com.SchoolSystem.FirstSpringDemo.Controler;


import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Services.SchoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "school" )
public class SchoolController {
    @Autowired
    SchoolServices schoolServices;


    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<School> getAllSchools(){

        List<School> schools = schoolServices.getAllSchools();
        return schools;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer id){
        School school=schoolServices.getSchoolById(id);
        return school;
    }

    @RequestMapping(value = "getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String schoolName){
        School school=schoolServices.getBySchoolName(schoolName);
        return school;
    }
    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
      public List<School> getAllActive(){
      List <School> schools = schoolServices.getAllActive();
      return schools;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<School> getAllInActive(){
        List <School> schools = schoolServices.getAllInActive();
        return schools;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public List<School> getLatestRow(){
        List <School> schools = schoolServices.getLatestRow();
        return schools;
    }



    }



