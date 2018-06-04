package com.revature.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Automobile;
import com.revature.repository.AutomobileDao;

@RestController
@RequestMapping(value="/api")
public class AutomobileController {

	@Autowired
	AutomobileDao ad;
	
	@GetMapping("/allAutomobiles")
	public ResponseEntity<List<Automobile>> getAllAutomobiles() {
		return new ResponseEntity<>(ad.findAll(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Automobile> getFlashcardById(@PathVariable int id) {
		ResponseEntity<Automobile> resp = new ResponseEntity<>(ad.findAutomobileById(id), HttpStatus.OK);
		return resp;
	}
}
