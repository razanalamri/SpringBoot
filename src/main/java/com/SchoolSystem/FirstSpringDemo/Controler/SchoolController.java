package com.SchoolSystem.FirstSpringDemo.Controler;


import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.SchoolSystem.FirstSpringDemo.Services.SchoolServices;
import com.SchoolSystem.FirstSpringDemo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "school" )
public class SchoolController {
    @Autowired
    SchoolServices schoolServices;

    @Autowired
    StudentServices studentServices;

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
    @RequestMapping(value = "deleteSchoolById", method = RequestMethod.POST)
    public void deleteSchoolById(@RequestParam Integer id){
        schoolServices.deleteSchoolById(id);

    }


    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAll(){
        schoolServices.deleteAllSchools();
    }

    @RequestMapping(value="updateCreatedDateByUserInput", method = RequestMethod.POST)
    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException{
        schoolServices.setCreatedDateByUserInput(data.getDate(),data.getId());


}
    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public School getByCreatedDate(@RequestParam Date createdDate){
        School school=schoolServices.getByCreatedDate(createdDate);
        return school;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public School getByUpdatedDate(@RequestParam Date updatedDate){
        School school=schoolServices.getByUpdatedDate(updatedDate);
        return school;
    }

    @RequestMapping(value="getSchoolCreatedAfterDate",method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<School> schoolList = new ArrayList<>();
        schoolList=schoolServices.getSchoolCreatedAfterDate(createdDate);
        return schoolList;

    }

//    @RequestMapping(value = "getByNumberOfStudents", method = RequestMethod.GET)
//    public School getByNumberOfStudents(@RequestParam Integer numberOfStudents){
//        School school=schoolServices.getByNumberOfStudents(numberOfStudents);
//        return school;
//    }

    @RequestMapping(value = "deleteAllSchoolsCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllSchoolsCreatedAfterDate(@RequestParam String createdDate)throws ParseException{
        schoolServices.deleteAllSchoolsCreatedAfterDate(createdDate);
    }





    }





