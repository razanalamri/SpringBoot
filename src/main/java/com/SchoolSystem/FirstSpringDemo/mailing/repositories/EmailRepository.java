package com.SchoolSystem.FirstSpringDemo.mailing.repositories;


import com.SchoolSystem.FirstSpringDemo.mailing.models.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository {
    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}
