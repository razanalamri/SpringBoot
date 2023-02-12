package com.SchoolSystem.FirstSpringDemo.Repositry;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Mark;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark,Integer> {

    @Query("SELECT s from Mark s")
    List<Mark> getAllMarks();

    @Query(value="SELECT s from Mark s where s.id = :id ")
    Mark getMarkById(@Param("id")Integer id);
}
