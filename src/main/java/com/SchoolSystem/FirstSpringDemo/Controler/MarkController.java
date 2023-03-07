package com.SchoolSystem.FirstSpringDemo.Controler;


import com.SchoolSystem.FirstSpringDemo.Models.Mark;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.RequestObjects.SchoolRequestForCreateDateUpdate;
import com.SchoolSystem.FirstSpringDemo.Services.MarkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "mark" )
public class MarkController {
    @Autowired
    MarkServices markServices;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Mark> getAllMarks(){

        List<Mark> marks = markServices.getAllMarks();
        return marks;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer id){
        Mark mark=markServices.getMarkById(id);
        return mark;
    }

    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
    public List<Mark> getAllActive(){
        List <Mark> marks = markServices.getAllActive();
        return marks;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<Mark> getAllInActive(){
        List <Mark> marks = markServices.getAllInActive();
        return marks;
    }

    @RequestMapping(value = "getAllByGrade", method = RequestMethod.GET)
    public Mark getAllByGrade(@RequestParam String grade){
        Mark mark=markServices.getAllByGrade(grade);
        return mark;
    }


    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public List<Mark> getLatestRow(){
        List <Mark> marks = markServices.getLatestRow();
        return marks;
    }
    @RequestMapping(value = "getLatestUpdate", method = RequestMethod.GET)
    public List<Mark> getLatestUpdate(){
        List <Mark> marks = markServices.getLatestUpdate();
        return marks;
    }

    @RequestMapping(value = "deleteMarkById", method = RequestMethod.POST)
    public void deleteMarkById(@RequestParam Integer id){
        markServices.deleteMarkById(id);

    }


    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAll(){
        markServices.deleteAllMarks();
    }




    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public Mark getByUpdatedDate(@RequestParam Date updatedDate){
        Mark mark=markServices.getByUpdatedDate(updatedDate);
        return mark;
    }

    @RequestMapping(value="getMarkCreatedAfterDate",method = RequestMethod.GET)
    public List<Mark> getSchoolCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Mark> marks = new ArrayList<>();
        marks=markServices.getMarkCreatedAfterDate(createdDate);
        return marks;

    }

    @RequestMapping(value="getByObtainedMarksMoreThan",method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksMoreThan(@RequestParam int obtainedMarks) throws ParseException {
        List<Mark> marks = new ArrayList<>();
        marks=markServices.getByObtainedMarksMoreThan(obtainedMarks);
        return marks;
    }

    @RequestMapping(value="getByObtainedMarksLessThan",method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksLessThan(@RequestParam int obtainedMarks) throws ParseException {
        List<Mark> marks = new ArrayList<>();
        marks=markServices.getByObtainedMarksLessThan(obtainedMarks);
        return marks;
    }


    @RequestMapping(value = "deleteAllMarksCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllMarksCreatedAfterDate(@RequestParam String createdDate)throws ParseException{
        markServices.deleteAllMarksCreatedAfterDate(createdDate);
    }

    @RequestMapping(value = "deleteMarkByCreatedDate", method = RequestMethod.POST)
    public void deleteMarkByCreatedDate(@RequestParam String createdDate)throws ParseException{
        markServices.deleteMarkByCreatedDate(createdDate);

    }

    @RequestMapping(value = "deleteMarkByUpdatedDate", method = RequestMethod.POST)
    public void deleteMarkByUpdatedDate(@RequestParam String updatedDate)throws ParseException{
        markServices.deleteMarkByUpdatedDate(updatedDate);

    }


    @RequestMapping(value = "createMark", method = RequestMethod.POST)
    public void createMark(@RequestParam String grade, int obtainedMarks ) {
        markServices.createMark(grade,obtainedMarks);
    }

    @RequestMapping(value = "updateMark",method = RequestMethod.POST)
    public void updateMark(@RequestParam Integer Id,String grade,int obtainedMarks,Boolean isActive){
        markServices.updateMark(Id,grade,obtainedMarks,isActive);
    }

    @RequestMapping(value = "getMarksByCourseId", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseId(@RequestParam Integer id){
        List<Mark> marks=markServices.getMarksByCourseId(id);
        return marks;
    }

    @RequestMapping(value = "deleteMarksByCourseId", method = RequestMethod.POST)
    public List<Mark> deleteMarksByCourseId(@RequestParam Integer id)throws ParseException{
        List<Mark> marks = new ArrayList<>();
        markServices.deleteMarksByCourseId(id);
        return marks;

    }


}
