package com.project.FeastFreedom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class FeastUser {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
    private String email;
	
    private String firstName;
    private String lastName;
    private String password;
    
    private int secQuestion1;
    private String secAnswer1;
    
    private int secQuestion2;
    private String secAnswer2;
	
}
