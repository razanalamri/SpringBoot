package com.SchoolSystem.FirstSpringDemo.Repositry;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {

    @Query("SELECT s from Course s")
    List <Course> getAllCourses();

    @Query(value="SELECT s from Course s where s.id = :id ")
    Course getCourseById(@Param("id")Integer id);


    @Query(value = "SELECT s from Course s WHERE s.student.id = :id ")
    List<Course> getCoursesByStudentId(@Param("id") Integer id);
}




