package com.SchoolSystem.FirstSpringDemo.Controler;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Fees;
import com.SchoolSystem.FirstSpringDemo.Models.Student;
import com.SchoolSystem.FirstSpringDemo.Services.FeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value= "Fees" )
public class FeesController {

    @Autowired
    FeesServices feesServices;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Fees> getAllFees(){
        List<Fees> fees = feesServices.getAllFees();
        return fees;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Fees getStudentById(@RequestParam Integer id){
        Fees fees=feesServices.getFeesById(id);
        return fees;
    }

    @RequestMapping(value = "getByAmount", method = RequestMethod.GET)
    public Fees getByAmount(@RequestParam Integer amount){
        Fees fees=feesServices.getByAmount(amount);
        return fees;
    }


    @RequestMapping(value = "getByPaidDate", method = RequestMethod.GET)
    public Fees getByPaidDate(@RequestParam  Date datePaid){
        Fees fees=feesServices.getByPaidDate(datePaid);
        return fees;

}

    @RequestMapping(value = "getFeesByStudentId", method = RequestMethod.GET)
    public List<Fees> getFeesByStudentId(@RequestParam Integer id){
        List<Fees> feesList=feesServices.getFeesByStudentId(id);
        return feesList;
    }

    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
    public List<Fees> getAllActive(){
        List <Fees> feesList = feesServices.getAllActive();
        return feesList;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<Fees> getAllInActive(){
        List <Fees> feesList = feesServices.getAllInActive();
        return feesList;
    }

    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public Fees getByCreatedDate(@RequestParam java.sql.Date createdDate){
        Fees fees=feesServices.getByCreatedDate(createdDate);
        return fees;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public Fees getByUpdatedDate(@RequestParam java.sql.Date updatedDate){
        Fees fees=feesServices.getByUpdatedDate(updatedDate);
        return fees;
    }







}
