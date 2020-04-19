package com.rajat.crypt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rajat.crypt.mailservice.MailService;
import com.rajat.crypt.util.ApiUtil;

@RestController
@RequestMapping(value = "/crypt")
public class CryptController {

	@Autowired
	private MailService mailService;

	@Autowired
	private ApiUtil apiUtil;

	String result = "";

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

//		   mailService.sendMailToUser("abc");
		Date currentDate = Calendar.getInstance(TimeZone.getDefault()).getTime();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

		/*
		 * String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";
		 * List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
		 * paratmers.add(new BasicNameValuePair("symbol", "BTC,USDT,BNB,ETH,abc"));
		 */

		/*
		 * String uri =
		 * "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
		 * List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
		 * paratmers.add(new BasicNameValuePair("start", "1")); paratmers.add(new
		 * BasicNameValuePair("limit", "5000")); paratmers.add(new
		 * BasicNameValuePair("convert", "USD"));
		 */

		String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
		List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
		paratmers.add(new BasicNameValuePair("id", "1"));

		try {
			result = ApiUtil.makeAPICall(uri, paratmers);
			System.out.println(result);
		} catch (IOException e) {
			System.out.println("Error: cannont access content - " + e.toString());
		} catch (URISyntaxException e) {
			System.out.println("Error: Invalid URL " + e.toString());
		}
		// formatter.format(currentDate);
		return result;
	}

}
