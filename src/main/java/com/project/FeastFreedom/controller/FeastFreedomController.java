package com.project.FeastFreedom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.FeastFreedom.model.*;
import com.project.FeastFreedom.services.*;

import java.util.*;

@RestController
public class FeastFreedomController {
	
	@Autowired
	private KitchenService kitchenService;
	private UserService userservice;
	
	@GetMapping("/kitchens")
	public List<Kitchen> getList()
	{
		return kitchenService.getKitchens();
	}
	
	@GetMapping("/kitchen/{id}")
	public ResponseEntity<Kitchen> get(@PathVariable int id) {
		
	    try {
	        Kitchen kitchen = kitchenService.getKitchen(id);
	        return new ResponseEntity<Kitchen>(kitchen, HttpStatus.OK);
	    } 
	    catch (NoSuchElementException e) {
	        return new ResponseEntity<Kitchen>(HttpStatus.NOT_FOUND);
	    }   
	    
	}
	
}
