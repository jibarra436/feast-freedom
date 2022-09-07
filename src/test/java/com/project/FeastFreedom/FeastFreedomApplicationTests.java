package com.project.FeastFreedom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.FeastFreedom.model.FeastUser;
import com.project.FeastFreedom.services.UserService;

@SpringBootTest
class FeastFreedomApplicationTests {
	
	@Autowired
	UserService userService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateUser() {
		FeastUser user = new FeastUser();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setPassword("$2a$12$fWpSIYUsRM2VjQdmsuOXhuEaHijw2Np9qS7Gg.NpLfOd4nfmoiy3C"); // "testpw"
		user.setEmail("john@gmail.com");
		
		userService.insert(user);
	}

}
