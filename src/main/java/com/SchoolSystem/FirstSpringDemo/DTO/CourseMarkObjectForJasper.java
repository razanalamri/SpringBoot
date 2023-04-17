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
    Integer avgMark;


    public Integer getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(Integer avgMark) {
        this.avgMark = avgMark;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(Integer obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }





//    public CourseMarkObjectForJasper(String courseName, Integer obtainedMarks, String grade) {
//        this.courseName = courseName;
//        this.obtainedMarks = obtainedMarks;
//        this.grade = grade;
//    }


}
