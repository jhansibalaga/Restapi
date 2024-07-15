package com.example.demo.services;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.registration;
import com.example.demo.repository.registrationrepository;

@Service
public class registrationservice {
  
	@Autowired
	registrationrepository repo;
	
	// creating method to add the data into database based on models(registration) order
	public registration add(registration reg) {
		return repo.save(reg); // save is used to send single data
	}
	
	// list used to adding multiple different types of data it is importing from "java.util"
    public Iterable<registration> multiadd(List<registration> reg) {
		
		return repo.saveAll(reg); // saveall is used to inserting multiple data and 
		
	}
    
    public List<registration> fetchall(){
    	
    	return (List<registration>) repo.findAll(); //findll is to retrieving multiple data
    }
    
    public Optional<registration> getbyid(int id) {
    	
    	return repo.findById(id); //optional is used to fetching suitable data
    }
    
    public String remove(int id) {
    	
    	 repo.deleteById(id);
    	 
    	 return "successfully deleted"+id;
    }
    
    public registration getbyemail(String email) {
    	
    	return repo.findByEmail(email); // there is no inbuilt method of "finfbyemail" we have create in repo layer
    }
    
    public registration update(registration reg) {
    	
    	int id = reg.getId();
    	
    	registration reg1 = repo.findById(id).get();
    	
    	reg1.setEmail(reg.getEmail()); //getemail-it fetches the data and setemail-we update the data and set into database
    	
    	reg1.setName(reg.getName());
    	
    	reg1.setPassword(reg.getPassword());
    	
    	return repo.save(reg1);
    	
    }
    
}
