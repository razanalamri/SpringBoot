package com.SchoolSystem.FirstSpringDemo.BussinessObject;

import javax.persistence.Column;

public class SchoolBO {

    @Column(name="Name_of_School")
    String schoolName;
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }



}
