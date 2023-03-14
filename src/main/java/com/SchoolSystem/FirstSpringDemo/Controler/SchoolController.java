package com.SchoolSystem.FirstSpringDemo.Controler;


import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.SchoolSystem.FirstSpringDemo.Services.SchoolServices;
import com.SchoolSystem.FirstSpringDemo.Slack.SlackClient;
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
    SlackClient slackClient;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<School> getAllSchools(){
        List<School> schools = schoolServices.getAllSchools();
        for(School schoolData : schools) {
            slackClient.sendMessage(schoolData.getId().toString());
            slackClient.sendMessage(schoolData.getSchoolName());
            slackClient.sendMessage(schoolData.getCreatedDate().toString());
            slackClient.sendMessage(schoolData.getUpdatedDate().toString());
            slackClient.sendMessage(schoolData.getActive().toString());

        }
        return schools;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer id){
        School school=schoolServices.getSchoolById(id);
        slackClient.sendMessage(school.getSchoolName());
        slackClient.sendMessage(school.getCreatedDate().toString());
        slackClient.sendMessage(school.getUpdatedDate().toString());
        slackClient.sendMessage(school.getActive().toString());
        return school;

    }

    @RequestMapping(value = "getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String schoolName){
        School school=schoolServices.getBySchoolName(schoolName);
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getCreatedDate().toString());
        slackClient.sendMessage(school.getUpdatedDate().toString());
        slackClient.sendMessage(school.getActive().toString());
        return school;
    }


    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
      public List<School> getAllActive(){
      List <School> schools = schoolServices.getAllActive();
      for(School schoolData : schools) {
          slackClient.sendMessage(schoolData.getId().toString());
          slackClient.sendMessage(schoolData.getSchoolName());
          slackClient.sendMessage(schoolData.getCreatedDate().toString());
          slackClient.sendMessage(schoolData.getUpdatedDate().toString());

      }
      return schools;
    }

    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<School> getAllInActive(){
        List <School> schools = schoolServices.getAllInActive();
        for(School schoolData : schools) {
            slackClient.sendMessage(schoolData.getId().toString());
            slackClient.sendMessage(schoolData.getSchoolName());
            slackClient.sendMessage(schoolData.getCreatedDate().toString());
            slackClient.sendMessage(schoolData.getUpdatedDate().toString());

        }
        return schools;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public List<School> getLatestRow(){
        List <School> schools = schoolServices.getLatestRow();
        for(School schoolData : schools) {
            slackClient.sendMessage(schoolData.getId().toString());
            slackClient.sendMessage(schoolData.getSchoolName());
            slackClient.sendMessage(schoolData.getCreatedDate().toString());
            slackClient.sendMessage(schoolData.getUpdatedDate().toString());
            slackClient.sendMessage(schoolData.getActive().toString());
        }
        return schools;
    }
    @RequestMapping(value = "getLatestUpdate", method = RequestMethod.GET)
    public List<School> getLatestUpdate(){
        List <School> schools = schoolServices.getLatestUpdate();
        for(School schoolData : schools) {
            slackClient.sendMessage(schoolData.getId().toString());
            slackClient.sendMessage(schoolData.getSchoolName());
            slackClient.sendMessage(schoolData.getCreatedDate().toString());
            slackClient.sendMessage(schoolData.getUpdatedDate().toString());
            slackClient.sendMessage(schoolData.getActive().toString());
        }
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
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getCreatedDate().toString());
        slackClient.sendMessage(school.getUpdatedDate().toString());
        slackClient.sendMessage(school.getActive().toString());
        return school;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public School getByUpdatedDate(@RequestParam Date updatedDate){
        School school=schoolServices.getByUpdatedDate(updatedDate);
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getCreatedDate().toString());
        slackClient.sendMessage(school.getUpdatedDate().toString());
        slackClient.sendMessage(school.getActive().toString());
        return school;
    }

    @RequestMapping(value="getSchoolCreatedAfterDate",method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<School> schoolList = new ArrayList<>();
        schoolList=schoolServices.getSchoolCreatedAfterDate(createdDate);
        for(School schoolData : schoolList) {
            slackClient.sendMessage(schoolData.getId().toString());
            slackClient.sendMessage(schoolData.getSchoolName());
            slackClient.sendMessage(schoolData.getCreatedDate().toString());
            slackClient.sendMessage(schoolData.getUpdatedDate().toString());
            slackClient.sendMessage(schoolData.getActive().toString());
        }
        return schoolList;

    }

    @RequestMapping(value = "deleteAllSchoolsCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllSchoolsCreatedAfterDate(@RequestParam String createdDate)throws ParseException{
        schoolServices.deleteAllSchoolsCreatedAfterDate(createdDate);
    }
    @RequestMapping(value = "deleteSchoolBySchoolName", method = RequestMethod.POST)
    public void deleteSchoolBySchoolName(@RequestParam String schoolName)throws ParseException{
        schoolServices.deleteSchoolBySchoolName(schoolName);
    }


    @RequestMapping(value = "deleteSchoolByCreatedDate", method = RequestMethod.POST)
    public void deleteSchoolByCreatedDate(@RequestParam String createdDate)throws ParseException{
        schoolServices.deleteSchoolByCreatedDate(createdDate);

    }

    @RequestMapping(value = "deleteSchoolByUpdatedDate", method = RequestMethod.POST)
    public void deleteSchoolByUpdatedDate(@RequestParam String updatedDate)throws ParseException{
        schoolServices.deleteSchoolByUpdatedDate(updatedDate);

    }

    @RequestMapping(value = "createSchool", method = RequestMethod.POST)
    public void createSchool(@RequestParam String schoolName) {
        schoolServices.createSchool(schoolName);
    }

    @RequestMapping(value = "updateSchool",method = RequestMethod.POST)
    public void updateSchool(@RequestParam Integer Id,String schoolName,Boolean isActive){
        schoolServices.updateSchool(Id,schoolName,isActive);
    }




    }





