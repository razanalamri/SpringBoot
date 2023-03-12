package com.SchoolSystem.FirstSpringDemo.Repositry;

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
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("SELECT s from Student s")
    List<Student> getAllStudent();


    @Query(value="SELECT s from Student s where s.id = :id ")
   Student getStudentById(@Param("id")Integer id);

    @Query(value="SELECT s from Student s where s.studentName = :studentName")
    Student getByStudentName(@Param("studentName")String name_of_student);

   @Query(value="SELECT s from Student s where s.age = :age")
   Student getByAge(@Param("age")int age);

    @Query(value = "SELECT s from Student s WHERE s.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);


    @Query(value="SELECT s from Student s where s.isActive =True")
    List<Student> getAllActive();

    @Query(value="SELECT s from Student s where s.isActive =False")
    List<Student> getAllInActive();

    @Query(value="SELECT s from Student s where s.id=(select MAX(s.id) from Student s)")
    List<Student> getLatestRow();

    @Query(value="SELECT s from Student s where s.updatedDate=(select MAX(s.updatedDate) from Student s)")
    List<Student> getLatestUpdate();

    @Modifying
    @Transactional
    @Query("UPDATE Student s set s.isActive=False")
    void deleteAllStudents();

    @Query(value="SELECT s from Student s where s.createdDate = :createdDate")
    Student getByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from Student s where s.updatedDate = :updatedDate")
    Student getByUpdatedDate(@Param("updatedDate") Date updatedDate);

    @Query(value="SELECT s from Student s where s.createdDate>createdDate")
    List<Student> getStudentCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "SELECT s from Student s where s.createdDate>createdDate")
    List<Student> deleteAllStudentsCreatedAfterDate(@Param("createdDate") Date createdDate);



}


