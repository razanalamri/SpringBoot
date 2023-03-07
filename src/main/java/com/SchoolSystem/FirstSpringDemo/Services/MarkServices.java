package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Mark;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Repositry.CourseRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.MarkRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MarkServices {




        @Autowired
        MarkRepository markRepository;

        @Autowired
        CourseRepository courseRepository;


        public List<Mark> getAllMarks() {
                return markRepository.getAllMarks();
        }

        public Mark getMarkById(Integer id) {
                Mark mark = markRepository.getMarkById(id);
                return mark;
        }
        public Mark getAllByGrade(String grade){
                Mark mark= markRepository.getAllByGrade(grade);
                return mark;
        }


        public List<Mark> getAllActive(){return markRepository.getAllActive();}

        public List<Mark> getAllInActive(){return markRepository.getAllInActive();}
        public List<Mark> getLatestRow(){return markRepository.getLatestRow();}

        public List<Mark> getLatestUpdate(){return markRepository.getLatestRow();}

        public void deleteMarkById(Integer id){
                Mark mark= markRepository.getMarkById(id);
                mark.setActive(false);
                markRepository.save(mark);
        }


        public void deleteAllMarks(){

                markRepository.deleteAllMarks();
        }
        public List<Mark> getMarksByCourseId(Integer id) {
                List<Mark> marks = markRepository.getMarksByCourseId(id);
                return marks;
        }


        public Mark getByCreatedDate(Date createdDate){
                Mark mark= markRepository.getByCreatedDate(createdDate);
                return mark;
        }

        public Mark getByUpdatedDate(Date updatedDate){
                Mark mark= markRepository.getByUpdatedDate(updatedDate);
                return mark;
        }

        public List<Mark> getMarkCreatedAfterDate(String stringDate)throws ParseException{
                DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date javaDate = formatter.parse(stringDate);
                List<Mark> marks = markRepository.getMarkCreatedAfterDate(javaDate);
                return marks;
        }

        public List<Mark> getByObtainedMarksMoreThan(int obtainedMarks)throws ParseException{
                List<Mark> marks = markRepository.getByObtainedMarksMoreThan(obtainedMarks);
                return marks;
        }

        public List<Mark> getByObtainedMarksLessThan(int obtainedMarks)throws ParseException{
                List<Mark> marks = markRepository.getByObtainedMarksLessThan(obtainedMarks);
                return marks;
        }

        public void deleteMarkByCreatedDate(String stringDate)throws ParseException{
                DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date javaDate = formatter.parse(stringDate);
                Mark mark= markRepository.getByCreatedDate(javaDate);
                mark.setActive(false);
                markRepository.save(mark);

        }

        public void deleteMarkByUpdatedDate(String stringDate)throws ParseException{
                DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date javaDate = formatter.parse(stringDate);
                Mark mark= markRepository.getByUpdatedDate(javaDate);
                mark.setActive(false);
                markRepository.save(mark);

        }


        public void deleteAllMarksCreatedAfterDate(String createdDate)throws ParseException{
                DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date javaDate = formatter.parse(createdDate);
                List<Mark> marks =markRepository.deleteAllMarksCreatedAfterDate(javaDate);
                marks.stream().forEach(x -> x.setActive(false));
                markRepository.saveAll(marks);
        }


        public void  createMark(String grade, int obtainedMarks) {
                Mark mark=new Mark();
                mark.setGrade(grade);
                mark.setObtainedMarks(obtainedMarks);
                mark.setActive(true);
                mark.setCreatedDate(new Date());
                markRepository.save(mark);
        }

        public void updateMark(Integer Id,String grade, int obtainedMarks, Boolean isActive){
                Mark mark =markRepository.getMarkById(Id);
                mark.setGrade(grade);
                mark.setObtainedMarks(obtainedMarks);
                mark.setCreatedDate(new Date());
                mark.setActive(isActive);
                markRepository.save(mark);
        }

        public void deleteMarksByCourseId(Integer id)throws ParseException{
                List<Mark> marks= markRepository.deleteMarksByCourseId(id);
                marks.stream().forEach(x -> x.setActive(false));
                markRepository.saveAll(marks);

        }

}



