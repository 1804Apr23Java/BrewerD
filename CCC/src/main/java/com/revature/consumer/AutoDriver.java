package com.revature.consumer;

import org.springframework.web.client.RestTemplate;

public class AutoDriver {
	
	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		Auto a = rt.getForObject("https://bootcodechallenge.cfapps.io/api/1", Auto.class);
		System.out.println("Consumed Automobile: " + a);
	
	}

}
