package com.SchoolSystem.FirstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SchoolStudentObjectForJasper {


    Integer id;
    String schoolName;
    String studentName;

    public SchoolStudentObjectForJasper( String studentName, String schoolName,Integer id ) {

        this.studentName = studentName;
        this.schoolName = schoolName;
        this.id = id;
    }
}
