package com.SchoolSystem.FirstSpringDemo.Services;

import com.SchoolSystem.FirstSpringDemo.Models.Course;
import com.SchoolSystem.FirstSpringDemo.Models.Fees;
import com.SchoolSystem.FirstSpringDemo.Models.Fees;
import com.SchoolSystem.FirstSpringDemo.Repositry.FeesRepository;
import com.SchoolSystem.FirstSpringDemo.mailing.models.EmailDetails;
import com.SchoolSystem.FirstSpringDemo.mailing.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class FeesServices implements FeesRepository {

       @Autowired
       Fees fees;
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

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

    @Override
    public String sendSimpleMail(Fees fees) {

        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo("razan.f96@outlook.com");
            mailMessage.setText(fees.getId().toString());
            mailMessage.setText(fees.getAmount().toString());
            mailMessage.setText(fees.getDatePaid().toString());
            mailMessage.setSubject("Student Details");
            // Sending the mail
            mailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }

}}
