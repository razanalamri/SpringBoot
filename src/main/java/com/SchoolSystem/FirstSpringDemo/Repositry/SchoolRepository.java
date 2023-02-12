package com.SchoolSystem.FirstSpringDemo.Repositry;

import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School,Integer> {
    @Query("SELECT s from School s")
    List<School> getAllSchools();

    @Query(value="SELECT s from School s where s.id = :id ")
    School getSchoolById(@Param("id")Integer id);
}


