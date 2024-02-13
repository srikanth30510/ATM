package com.klu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/atm")
public class ATM {
@GetMapping("/fromsbi/{accno}")
	public String getdetailsfromsbi(@PathVariable("accno") Long accno)
	{
		String url="http://localhost:8080/sbi/data/"+accno;
		RestTemplate rt=new RestTemplate();
		
		String result=rt.getForObject(url, String.class);
		return result;
	}
@GetMapping("/fromunion/{accno}")
public String getdetailsfromunion(@PathVariable("accno") Long accno)
{
	String url="http://localhost:8082/union/data/"+accno;
	RestTemplate rt=new RestTemplate();
	String result= rt.getForObject(url, String.class);
	return result;
}
}
