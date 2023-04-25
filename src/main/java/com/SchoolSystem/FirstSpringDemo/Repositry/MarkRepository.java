package com.SchoolSystem.FirstSpringDemo.Repositry;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Mark;
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
public interface MarkRepository extends CrudRepository<Mark,Integer> {

    @Query("SELECT s from Mark s")
    List<Mark> getAllMarks();

    @Query(value="SELECT s from Mark s where s.id = :id ")
    Mark getMarkById(@Param("id")Integer id);


    @Query(value="SELECT s from Mark s where s.isActive =True")
    List<Mark> getAllActive();

    @Query(value="SELECT s from Mark s where s.isActive =False")
    List<Mark> getAllInActive();

    @Query(value="SELECT s from Mark s where s.grade = :grade ")
    Mark getAllByGrade(@Param("grade")String grade);

    @Query(value="SELECT s from Mark s where s.id=(select MAX(s.id) from Mark s)")
    List<Mark> getLatestRow();

    @Query(value="SELECT s from Mark s where s.updatedDate=(select MAX(s.updatedDate) from Mark s)")
    List<Mark> getLatestUpdate();


    @Modifying
    @Transactional
    @Query("UPDATE Mark s set s.isActive=False")
    void deleteAllMarks();

    @Query(value="SELECT s from Mark s where s.createdDate = :createdDate")
    Mark getByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value = "SELECT s from Mark s WHERE s.course.id = :id ")
    List<Mark> getMarksByCourseId(@Param("id") Integer id);

    @Query(value="SELECT s from Mark s where s.updatedDate = :updatedDate")
    Mark getByUpdatedDate(@Param("updatedDate") Date updatedDate);

    @Query(value="SELECT s from Mark s where s.createdDate>createdDate")
    List<Mark> getMarkCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from Mark s where s.obtainedMarks<obtainedMarks")
    List<Mark> getByObtainedMarksMoreThan(@Param("obtainedMarks") int obtainedMarks);

    @Query(value="SELECT s from Mark s where s.obtainedMarks>obtainedMarks")
    List<Mark> getByObtainedMarksLessThan(@Param("obtainedMarks") int obtainedMarks);

    @Query(value = "SELECT s from Mark s where s.createdDate>createdDate")
    List<Mark> deleteAllMarksCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "SELECT s from Mark s WHERE s.course.id = :id ")
    List<Mark> deleteMarksByCourseId(@Param("id") Integer id);


    @Query(value = "SELECT count(m) from Mark m WHERE m.course.courseName = :courseName")
    Integer getNumberOfMarksByCourseName(@Param("courseName") String courseName);


    @Query(value = "select sum(m.obtainedMarks) from Mark m where m.course.id = :id ")
    Integer getSumOfMarksByStudentId(@Param("id") Integer id);


    @Query(value = "select avg(m.obtainedMarks) from Mark m where m.course.student.id = :id ")
    Integer getAvgOfMarksByStudentId(@Param("id") Integer id);

}

