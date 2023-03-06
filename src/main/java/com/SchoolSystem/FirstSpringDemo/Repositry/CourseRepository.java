package com.SchoolSystem.FirstSpringDemo.Repositry;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {

    @Query("SELECT s from Course s")
    List <Course> getAllCourses();

    @Query(value="SELECT s from Course s where s.id = :id ")
    Course getCourseById(@Param("id")Integer id);


    @Query(value = "SELECT s from Course s WHERE s.student.id = :id ")
    List<Course> getCoursesByStudentId(@Param("id") Integer id);

    @Query(value="SELECT s from Course s where s.courseName = :courseName")
    Course getByCourseName(@Param("courseName")String Name_of_Course);


    @Query(value="SELECT s from Course s where s.isActive =True")
    List<Course> getAllActive();

    @Query(value="SELECT s from Course s where s.isActive =False")
    List<Course> getAllInActive();

    @Query(value="SELECT s from Course s where s.id=(select MAX(s.id) from Course s)")
    List<Course> getLatestRow();

    @Query(value="SELECT s from Course s where s.updatedDate=(select MAX(s.updatedDate) from Course s)")
    List<Course> getLatestUpdate();


    @Modifying
    @Transactional
    @Query("UPDATE Course s set s.isActive=False")
    void deleteAllCourses();

    @Query(value="SELECT s from Course s where s.createdDate = :createdDate")
    Course getByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from Course s where s.updatedDate = :updatedDate")
    Course getByUpdatedDate(@Param("updatedDate") Date updatedDate);

    @Query(value="SELECT s from Course s where s.createdDate>createdDate")
    List<Course> getCourseCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "SELECT s from Course s where s.createdDate>createdDate")
    List<Course> deleteAllCoursesCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "SELECT s from Course s WHERE s.student.id = :id ")
    List<Course> deleteCourseByStudentId(@Param("id") Integer id);






}






