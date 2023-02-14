package com.SchoolSystem.FirstSpringDemo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="Name_of_Course")
    String courseName;
    @ManyToOne
    @JoinColumn(name ="student_id",referencedColumnName = "id")
    Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
