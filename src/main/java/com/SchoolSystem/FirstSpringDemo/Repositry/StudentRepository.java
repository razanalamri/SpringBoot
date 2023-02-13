package com.SchoolSystem.FirstSpringDemo.Repositry;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("SELECT s from Student s")
    List<Student> getAllStudent();


    @Query(value="SELECT s from Student s where s.id = :id ")
   Student getStudentById(@Param("id")Integer id);

    @Query(value="SELECT s from Student s where s.studentName = :studentName")
    Student getByStudentName(@Param("studentName")String name_of_student);

    @Query(value = "SELECT s from Student s WHERE s.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);
}


