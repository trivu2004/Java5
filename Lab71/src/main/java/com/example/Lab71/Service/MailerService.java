package com.example.Lab71.Service;

import com.example.Lab71.Model.MailInfo;
import jakarta.mail.MessagingException;

public interface MailerService {
    void send(MailInfo mail) throws MessagingException;
    void send(String to, String subject, String body) throws MessagingException;
    void queue(MailInfo mail);
    void queue(String to, String subject, String body);
}
