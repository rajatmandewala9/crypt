package com.rajat.crypt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rajat.crypt.mailservice.MailService;

@RestController
@RequestMapping(value = "/ping")
public class PingController {	
	
	@Autowired
	private MailService mailService;	
	
	@GetMapping
	public String getPing() {
		mailService.sendMailToUser("mail test");
		return "PingController";
	}

}
