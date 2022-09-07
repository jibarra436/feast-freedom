package com.project.FeastFreedom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "kitchens")
public class Kitchen {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
    private String kitchenName;
	@Column(unique = true)
    private String email;
	
    private String password;
    
    private String workingDays;
    private String workingTime;
    private String imageURL;
    
    // @OneToOne
    private Menu menu;
}
