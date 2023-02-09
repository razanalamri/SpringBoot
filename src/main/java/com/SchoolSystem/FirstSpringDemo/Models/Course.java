package com.SchoolSystem.FirstSpringDemo.Models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    Integer id;
    @Column(name="Name_of_Course")
    String courseName;
    List<Mark> marksList;
}
