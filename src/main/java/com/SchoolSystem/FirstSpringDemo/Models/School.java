package com.SchoolSystem.FirstSpringDemo.Models;

import javax.persistence.*;
import java.util.List;

public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    Integer id;
    @Column(name="Name_of_School")
    String schoolName;

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    List<Student> studentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
