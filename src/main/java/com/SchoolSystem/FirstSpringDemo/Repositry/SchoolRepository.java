package com.SchoolSystem.FirstSpringDemo.Repositry;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School,Integer> {
    @Query("SELECT s from School s")
    List<School> getAllSchools();

    @Query(value="SELECT s from School s where s.id = :id ")
    School getSchoolById(@Param("id")Integer id);

    @Query(value="SELECT s from School s where s.schoolName = :schoolName")
    School getBySchoolName(@Param("schoolName")String name_of_school);

    @Query(value="SELECT s from School s where s.isActive =True")
    List<School> getAllActive();

    @Query(value="SELECT s from School s where s.isActive =False")
    List<School> getAllInActive();

    @Query(value="SELECT s from School s where s.id=(select MAX(s.id) from School s)")
    List<School> getLatestRow();

    @Query(value="SELECT s from School s where s.updatedDate=(select MAX(s.updatedDate) from School s)")
    List<School> getLatestUpdate();


    @Modifying
    @Transactional
    @Query("UPDATE School s set s.isActive=False")
    void deleteAllSchools();

    @Query(value="SELECT s from School s where s.createdDate = :createdDate")
    School getByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from School s where s.updatedDate = :updatedDate")
    School getByUpdatedDate(@Param("updatedDate") Date updatedDate);

    @Query(value="SELECT s from School s where s.createdDate>createdDate")
    List<School> getSchoolCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "SELECT s from School s where s.createdDate>createdDate")
    List<School> deleteAllSchoolsCreatedAfterDate(@Param("createdDate") Date createdDate);




//    @Query(value="SELECT COUNT(school_id) from Student where numberOfStudents=:numberOfStudents ")
//    School getByNumberOfStudents(@Param("numberOfStudents") Integer numberOfStudents);



}


