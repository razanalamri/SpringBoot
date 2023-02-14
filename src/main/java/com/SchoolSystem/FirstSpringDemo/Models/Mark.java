package com.SchoolSystem.FirstSpringDemo.Models;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;

@Entity
public class Mark extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer obtainedMarks;
    String grade;
    @ManyToOne
    @JoinColumn(name ="course_id",referencedColumnName = "id")
    Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
