package com.example.Demo.Service;

import javax.mail.MessagingException;

public interface EmailService {

    public void sendEmail(String to, String userHash,String otp,String Name) throws MessagingException;

    public void sendEmail(String to , String opt, String Name) throws MessagingException;
}
