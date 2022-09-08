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
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/kitchen")
	public List<Kitchen> getKitchenList()
	{
		return kitchenService.getKitchens();
	}
	
	@GetMapping("/kitchen/{id}")
	public ResponseEntity<Kitchen> getKitchenInfo(@PathVariable int id) {
		
	    try {
	        Kitchen kitchen = kitchenService.getKitchen(id);
	        return new ResponseEntity<Kitchen>(kitchen, HttpStatus.OK);
	    } 
	    catch (NoSuchElementException e) {
	        return new ResponseEntity<Kitchen>(HttpStatus.NOT_FOUND);
	    }   
	    
	}
	
	@GetMapping("/kitchen/{id}/menu")
	public ResponseEntity<ArrayList<MenuItem>> getKitchenMenu(@PathVariable int id) {
		
	    try {
	        ArrayList<MenuItem> menuItems = menuService.getMenuItems(id);
	        
	        return new ResponseEntity< ArrayList<MenuItem> >(menuItems, HttpStatus.OK);
	    } 
	    catch (NoSuchElementException e) {
	        return new ResponseEntity<ArrayList<MenuItem>>(HttpStatus.NOT_FOUND);
	    }   
	    
	}
	
}
