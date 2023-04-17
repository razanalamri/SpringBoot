package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Fees;
import com.SchoolSystem.FirstSpringDemo.Models.Fees;
import com.SchoolSystem.FirstSpringDemo.Repositry.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class FeesServices {

    @Autowired
    FeesRepository feesRepository;
    public List<Fees> getAllFees(){
        return feesRepository.getAllFees();
    }

    public Fees getFeesById(Integer id){
        Fees fees= feesRepository.getFeesById(id);
        return fees;
    }

    public Fees getByAmount(Integer amount) {
        Fees fees = feesRepository.getByAmount(amount);
        return fees;
    }

    public Fees getByPaidDate (Date datePaid) {
        Fees fees = feesRepository.getByPaidDate(datePaid);
        return fees;
    }

    public List<Fees> getFeesByStudentId(Integer id) {
        List<Fees> feesList = feesRepository.getFeesByStudentId(id);
        return feesList;
    }
    public List<Fees> getAllActive(){return feesRepository.getAllActive();}

    public List<Fees> getAllInActive(){return feesRepository.getAllInActive();}
    public Fees getByCreatedDate(Date createdDate){
        Fees fees= feesRepository.getByCreatedDate(createdDate);
        return fees;
    }

    public Fees getByUpdatedDate(Date updatedDate){
        Fees fees= feesRepository.getByUpdatedDate(updatedDate);
        return fees;
    }

}
