package com.SchoolSystem.FirstSpringDemo.DTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class TopPerformingStudent {

    public TopPerformingStudent(String studentName, String schoolName) {
        this.studentName = studentName;
        this.schoolName = schoolName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    String studentName;
    String schoolName;
}
