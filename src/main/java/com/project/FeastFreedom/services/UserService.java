package com.project.FeastFreedom.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FeastFreedom.model.*;
import com.project.FeastFreedom.repo.*;

@Service
@Transactional
public class UserService {
	
    @Autowired
    private UserRepository userRepo;
    
    public List<FeastUser> getUsers() {
        return userRepo.findAll();
    }
     
    public FeastUser getUser(int id) {
        return userRepo.findById(id).get();
    }
    
    public FeastUser getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    public void insert(FeastUser feastUser) {
    	userRepo.save(feastUser);
    }
    
    public void delete(Integer id) {
    	userRepo.deleteById(id);
    }
}
