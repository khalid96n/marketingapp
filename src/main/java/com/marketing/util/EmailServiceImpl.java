package com.marketing.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



@Component
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(String to, String sub, String body) {
		// Try block to check for exceptions
        try {
 
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
           
            mailMessage.setTo(to);
            mailMessage.setText(body);
            mailMessage.setSubject(sub);
 
            // Sending the mail
            javaMailSender.send(mailMessage);
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            e.printStackTrace();
        }

	}

}
