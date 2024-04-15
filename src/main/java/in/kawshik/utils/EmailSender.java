package in.kawshik.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


//MimeMessage message = emailSender.createMimeMessage();
//MimeMessageHelper helper = new MimeMessageHelper(message, true);
//try {
//
//helper.setTo(to);
//helper.setSubject(subject);
//helper.setText(text);
//}catch(MessagingException e) {
//e.printStackTrace();
//}
//try {
//	emailSender.send(message);
//} catch (Exception e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//}


@Service
public class EmailSender {
	
	
	
	@Autowired
    private JavaMailSender emailSender;


    public void sendSimpleMessage(String to, String body, String subject) throws MessagingException {    
    	
    	SimpleMailMessage message = new SimpleMailMessage();
    	
    	message.setFrom("kawshikgoud2018@gmail.com");
    
    	message.setText(body);
		message.setTo(to);
		message.setSubject(subject);
		
		emailSender.send(message);
    }
	
}
