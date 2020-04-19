package com.rajat.crypt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rajat.crypt.mailservice.MailService;

@RestController
@RequestMapping(value = "/crypt")
public class CryptController {	
	
	@Autowired
	private MailService mailService;
	
	@GetMapping
	public String getTime() throws ParseException { 
		   
		   
//		   Calendar currentdate = Calendar.getInstance();
//		   String strdate = null;
//		   DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ssz");
//		   strdate = formatter.format(currentdate.getTime());
//		   System.out.println("strdate=>" + strdate);
//		   TimeZone obj = TimeZone.getTimeZone("CST");
//
//		   formatter.setTimeZone(obj);
//		   strdate = formatter.format(currentdate.getTime());
//		   Date theResult = formatter.parse(strdate);
//
//		   System.out.println("The current time in India is  :: " +currentdate.getTime());
//
//		   System.out.println("The date and time in :: " + obj.getDisplayName() + "is ::" + theResult);
//		   System.out.println("The date and time in :: " + obj.getDisplayName() + "is ::" + strdate);
		   
		   mailService.sendMailToUser("abc");
		   Date currentDate = Calendar.getInstance(TimeZone.getDefault()).getTime();
		   DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		   formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		  
		return formatter.format(currentDate);
	}

}
