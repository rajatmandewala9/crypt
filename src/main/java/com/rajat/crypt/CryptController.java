package com.rajat.crypt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/crypt")
public class CryptController {	
	
	@GetMapping
	public String getTime() throws ParseException {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		   
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
		   
		   Date currentDate = Calendar.getInstance(TimeZone.getDefault()).getTime();
		   
		   
		   DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		   formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Or whatever IST is supposed to be
		   //formatter.format(currentDate);
		   
		   
		   
		   //System.out.println(dtf.format(now)); 
		return formatter.format(currentDate);
	}

}
