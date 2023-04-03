package com.SchoolSystem.FirstSpringDemo.Controler;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseControllerTest {

    @Autowired
CourseController courseController;

    @Test
    void getAllCourses() {
        List<Course> allCourses = courseController.getAllCourses();
        assertNotNull(allCourses);
    }

    @Test
    void getCourseById() {
        Course courseToTest;
        courseToTest = courseController.getCourseById(1);
        String courseName=courseToTest.getCourseName();
        assertEquals("Math",courseName);
    }

    @Test
    void getByCourseName() {
        Course courseToTest;
        courseToTest = courseController.getByCourseName("Math");
        int id=courseToTest.getId();
        assertEquals(1,id);

    }

    @Test
    void getAllActive() {
        List<Course> activeCourses = courseController.getAllActive();
        assertNotNull(activeCourses);
    }

    @Test
    void getAllInActive() {
        List<Course> InactiveCourses = courseController.getAllInActive();
        assertNotNull(InactiveCourses);
    }

    @Test
    void getLatestRow()throws Exception {
        List<Course> latestRow = courseController.getLatestRow();
        assertNotNull(latestRow);
    }

    @Test
    void getLatestUpdate() throws Exception {
        List<Course> latestUpdate = courseController.getLatestUpdate();
        assertNotNull(latestUpdate);
    }


    @Test
    void getByCreatedDate() {
        Course courseToTest;
        courseToTest = courseController.getByCreatedDate(valueOf("2012-11-02"));
        String courseName=courseToTest.getCourseName();
        assertEquals("Math",courseName);
    }

    @Test
    void getByUpdatedDate() {
        Course courseToTest;
        courseToTest = courseController.getByCreatedDate(valueOf("2001-03-05"));
        String courseName=courseToTest.getCourseName();
        assertEquals("Math",courseName);
    }
}