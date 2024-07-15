package com.example.demo.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.registration;
import com.example.demo.models.registration;
import com.example.demo.services.registrationservice;

@RestController // it used for to inserting data from postman
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class registrationcontroller {

	@Autowired
	registrationservice service;
	
	@PostMapping("/adding") //while we are inserting data we use postmapping
	public registration add(@RequestBody registration reg) {
		
		return service.add(reg);
	}
	
	@PostMapping("/multiadding") // while we are inserting the data we use requestbody
	public Iterable<registration> multiadd(@RequestBody List<registration> reg) {
		
		return service.multiadd(reg);
	}
	
	@GetMapping("/fetching") //while we are retrieving the data we use getmapping
	public List<registration> fetchall(){
		
		return service.fetchall();
	}
	
	@GetMapping("/fetchwithid/{id}") // we are providing id value by placing {id}
	public Optional<registration> getbyid(@PathVariable int id) {
		
		return service.getbyid(id);
	}
	
	@DeleteMapping("/deleting/{id}") // we are deleting the data by id so we provide {id} and using deletemapping
	public String remove(@PathVariable int id) {
		
		return service.remove(id);
	}
	
	@GetMapping("/fetchwithemail/{email}")
	public registration getbyemail(@PathVariable String email) {
		return service.getbyemail(email);
	}
	
	@PutMapping("/update")
	public registration updating(@RequestBody registration reg) {
		
		return service.update(reg);
	}
}
