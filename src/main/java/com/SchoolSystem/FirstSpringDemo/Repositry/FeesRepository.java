package com.SchoolSystem.FirstSpringDemo.Repositry;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Fees;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.mailing.models.EmailDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FeesRepository {

    @Query("SELECT s from Fees s")
    List<Fees> getAllFees();
    @Query(value="SELECT s from Fees s where s.id = :id ")
    Fees getFeesById(@Param("id")Integer id);

    @Query(value="SELECT s from Fees s where s.amount = :amount")
    Fees getByAmount(@Param("amount")Integer amount);

    @Query(value="SELECT s from Fees s where s.datePaid = :datePaid")
    Fees getByPaidDate(@Param("datePaid") Date datePaid);


    @Query(value = "SELECT s from Fees s WHERE s.student.id = :id ")
    List<Fees> getFeesByStudentId(@Param("id") Integer id);


    @Query(value="SELECT s from Fees s where s.createdDate = :createdDate")
    Fees getByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from Fees s where s.updatedDate = :updatedDate")
    Fees getByUpdatedDate(@Param("updatedDate") Date updatedDate);

    @Query(value="SELECT s from Fees s where s.isActive =True")
    List<Fees> getAllActive();

    @Query(value="SELECT s from Fees s where s.isActive =False")
    List<Fees> getAllInActive();

    String sendSimpleMail(Fees fees);
}
