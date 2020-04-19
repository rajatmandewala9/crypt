package com.rajat.crypt.mailservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMailToUser(String message) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("rajatmandewala9@gmail.com");
		msg.setSubject("Current Value of the cryptocurrency");
		msg.setText(message);
		javaMailSender.send(msg);
	}
	
	//@Scheduled(cron = "* 1  * * * *")
	//@Scheduled(initialDelay = 1000, fixedRate = 200000) wroking
	//@Scheduled(fixedDelay = 10000)
	//@Scheduled(cron = "*/5 * * * * *")
	//@Scheduled(cron = " 0 32 22 ? * *")
	//0 0/30 * * * ?
	
	//@Scheduled(cron = " 0 0/15 * * * ? ")
	public void sendMailTest() {
		System.out.println("aasas");
		// logger.info("Current time is :: " + Calendar.getInstance().getTime());
		//System.out.println("a");		
		 Date currentDate = Calendar.getInstance(TimeZone.getDefault()).getTime();
		   DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		   formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));		  
		// formatter.format(currentDate);		
		this.sendMailToUser("a"+formatter.format(currentDate));
	}

}
