package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Mark;
import com.SchoolSystem.FirstSpringDemo.Repositry.CourseRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.MarkRepository;
import com.SchoolSystem.FirstSpringDemo.Repositry.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkServices {






        @Autowired
        MarkRepository markRepository;



        public List<Mark> getAllMarks() {
                return markRepository.getAllMarks();



        }

        public Mark getMarkById(Integer id){
                Mark mark = markRepository.getMarkById(id);
                return mark;
        }}


