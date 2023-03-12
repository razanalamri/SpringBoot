package com.SchoolSystem.FirstSpringDemo.Controler;
import com.SchoolSystem.FirstSpringDemo.Models.School;
import com.SchoolSystem.FirstSpringDemo.mailing.models.EmailDetails;
import com.SchoolSystem.FirstSpringDemo.mailing.repositories.EmailRepository;
import com.SchoolSystem.FirstSpringDemo.mailing.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value= "emailing" )
public class EmailController {

    @Autowired
    EmailService emailService;



    @PostMapping(value = "sendSimpleMailToMany")
    public String sendSimpleMailToMany(@RequestBody EmailDetails emailDetails){
        String email = emailService.sendSimpleMailToMany(emailDetails);
        return email;
    }

    @PostMapping(value = "sendSimpleMail")
    public String sendSimpleMail(@RequestBody EmailDetails emailDetails){
        String email = emailService.sendSimpleMail(emailDetails);
        return email;
    }

    @PostMapping(value = "sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails emailDetails){
        String email = emailService.sendMailWithAttachment(emailDetails);
        return email;
    }

    @PostMapping(value = "sendMailWithAttachmentToMany")
    public String sendMailWithAttachmentToMany(@RequestBody EmailDetails emailDetails){
        String email = emailService.sendMailWithAttachmentToMany(emailDetails);
        return email;
    }






}
