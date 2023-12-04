package com.example.Demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendEmail(String to, String userHash,String userOtp,String Name) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("adoniabhishek9@gmail.com");
        helper.setTo(to);
        helper.setSubject("Greetings of the Day !! Verify funding request for student\n"+Name);


        String url = "http://localhost:8080/student/verify?hash=" + userHash + "&otp=" + userOtp;
        String emailContent = "Click the link below to verify your email:\n" + url;

        helper.setText(emailContent, true); // Set the second parameter to true to indicate HTML content

        emailSender.send(message);
        }


    @Override
    public void sendEmail(String to,String userOtp,String Name) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("adoniabhishek9@gmail.com");
        helper.setTo(to);
        helper.setSubject("Greetings of the Day !! Verify Opt\n"+Name);
        String emailContent = "OPT:\n" + userOtp;

        helper.setText(emailContent);

        emailSender.send(message);
    }

}
