package com.SchoolSystem.FirstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CourseMarkObjectForJasper {
    String courseName;
    Integer obtainedMarks;
    String grade;

    public CourseMarkObjectForJasper(String courseName, Integer obtainedMarks, String grade) {
        this.courseName = courseName;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
    }


}
