package com.project.FeastFreedom;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.FeastFreedom.config.SESMailer;
import com.project.FeastFreedom.model.FeastUser;
import com.project.FeastFreedom.model.Kitchen;
import com.project.FeastFreedom.model.Menu;
import com.project.FeastFreedom.model.MenuItem;
import com.project.FeastFreedom.services.KitchenService;
import com.project.FeastFreedom.services.UserService;

@SpringBootTest
class FeastFreedomApplicationTests {
	
	@Autowired
	UserService userService;
	
	@Autowired
	KitchenService kitchenService;
	
	@Test
	void contextLoads() {
	}
	
	/*
	@Test
	void testCreateUser() {
		FeastUser user = new FeastUser();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setPassword("$2a$12$fWpSIYUsRM2VjQdmsuOXhuEaHijw2Np9qS7Gg.NpLfOd4nfmoiy3C"); // "testpw"
		user.setEmail("john@gmail.com");
		
		userService.insert(user);
	}
	*/
	
	/*
	@Test
	void testCreateKitchen() {
		Menu menu = new Menu();
		menu.addItem(new MenuItem("Chicken Taco", 1.99));
		menu.addItem(new MenuItem("Beef Taco", 1.99));
		menu.addItem(new MenuItem("Steak Taco", 2.49));
		
		Kitchen kitchen = new Kitchen();
		kitchen.setKitchenName("Joe's Tacos");
		kitchen.setEmail("joestacos@gmail.com");
		kitchen.setMenu(menu);
		kitchen.setImageURL("https://freedom-feast-kitchen-images.s3.us-east-2.amazonaws.com/testlogo.jpg");
		
		kitchenService.insert(kitchen);
	}
	*/
	
	/*
	@Test
	void testMailer() {		
		try {
			SESMailer.send("joeyibarra436@gmail.com", "Feast Freedom Test Notification", ""
					+ "<h1>Your order has been placed!</h1>"
					+ "<p>Order details: ... </p>"
					);
		} catch(MessagingException ex) {
			System.out.println("MessaingException: "+ex.getMessage());
		}
		
	}
	*/

}
