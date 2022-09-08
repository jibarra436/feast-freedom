package com.project.FeastFreedom.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.project.FeastFreedom.model.FeastUser;
import com.project.FeastFreedom.model.Kitchen;
import com.project.FeastFreedom.repo.KitchenRepository;
import com.project.FeastFreedom.repo.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
    private KitchenRepository kitchenRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		FeastUser feastuser = userRepo.findByEmail(email);
		Kitchen kitchenuser = kitchenRepo.findByEmail(email);
		
		if (feastuser.getEmail() != null) {
			return new User(feastuser.getEmail(), feastuser.getPassword(), new ArrayList<>());
		}
		else if (kitchenuser.getEmail() != null) {
			return new User(kitchenuser.getEmail(), kitchenuser.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
		
		
		
	}

}