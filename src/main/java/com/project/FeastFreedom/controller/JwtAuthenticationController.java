package com.project.FeastFreedom.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.FeastFreedom.config.JwtTokenUtil;
import com.project.FeastFreedom.model.FeastUser;
import com.project.FeastFreedom.model.JwtRequest;
import com.project.FeastFreedom.model.JwtResponse;
import com.project.FeastFreedom.model.Kitchen;
import com.project.FeastFreedom.services.JwtUserDetailsService;
import com.project.FeastFreedom.services.KitchenService;
import com.project.FeastFreedom.services.UserService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KitchenService kitchenService;

	@RequestMapping(value = "/api/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> generateUserAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value = "/api/createuser", method = RequestMethod.POST)
	public void creatUserAccount(@RequestBody FeastUser u) {
		
		String encryptedPW = bCryptPasswordEncoder.encode(u.getPassword());
		
		u.setPassword(encryptedPW);
		
		userService.insert(u);
	}
	
	@RequestMapping(value = "/api/createkitchen", method = RequestMethod.POST)
	public void createKitchen(@RequestBody Kitchen kit) {
		
		String encryptedPW = bCryptPasswordEncoder.encode(kit.getPassword());
		
		kit.setPassword(encryptedPW);
		
		kitchenService.insert(kit);
	}
}
