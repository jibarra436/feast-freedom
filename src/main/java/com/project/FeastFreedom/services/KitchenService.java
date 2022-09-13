package com.project.FeastFreedom.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FeastFreedom.model.*;
import com.project.FeastFreedom.repo.*;

@Service
@Transactional
public class KitchenService {
	
    @Autowired
    private KitchenRepository kitchenRepo;
     
    public List<Kitchen> getKitchens() {
        return kitchenRepo.findAll();
    }
     
    public Kitchen getKitchen(int id) {
        return kitchenRepo.findById(id).get();
    }
    
    public void setKitchenImage(String email, String imageUrl) {
    	kitchenRepo.setKitchenImageById(email, imageUrl);
    }
    
    public void insert(Kitchen kitchen) {
    	kitchenRepo.save(kitchen);
    }
    
    public void delete(Integer id) {
    	kitchenRepo.deleteById(id);
    }
}
