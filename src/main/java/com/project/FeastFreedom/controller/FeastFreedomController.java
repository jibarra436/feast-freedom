package com.project.FeastFreedom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FeastFreedom.config.SESMailer;
import com.project.FeastFreedom.model.*;
import com.project.FeastFreedom.services.*;

import java.util.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api")
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
	
	@PostMapping("/checkout")
	public void createCart(@RequestBody String userEmail, @RequestBody String cart) {
		// Get user by email, if valid send confirmation email
		FeastUser user = userService.getUserByEmail(userEmail);
		
		// Parse cart as JSON? (depends how we implement the cart in angular
		
		if(user != null) {
			
			try {
				SESMailer.send(userEmail, "Feast Freedom Order Confirmation", ""
					+ "<h1>Your Order Has Been Placed!</h1>"
					+ "<p>Thank you for your order!<p>"
					+ "<br><p>Your order:<p>"
					+ cart);
			} catch(MessagingException ex) {
				System.out.println("Error sending mail - "+ex.getMessage());
			}
			
		} else {
			System.out.println("Error finding user with email "+userEmail);
		}
	}
	
	@PostMapping("/kitchen")
	public void createKitchen(@RequestBody Kitchen kit) {
		kitchenService.insert(kit);
	}
	
	
}
