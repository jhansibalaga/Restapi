package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // creating setters for all columns

@Getter // creating getters for all columns

@AllArgsConstructor 

@NoArgsConstructor

@Entity // table name
public class registration {
      //	creating columns
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //providing auto increment to id
	private int id;
	
	@Size(min=4 ,max=20)
	private String name;
	
	@Email  //providing email syntax 
	private String email;
	
	@Size(max = 10,min = 8)   //providing restriction
	private String password;
	
}
