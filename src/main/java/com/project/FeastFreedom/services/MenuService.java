package com.project.FeastFreedom.services;

import java.util.ArrayList;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FeastFreedom.model.*;
import com.project.FeastFreedom.repo.*;

@Service
@Transactional
public class MenuService {
	
    @Autowired
    private MenuRepository menuRepo;
    
    @Autowired
    private MenuItemRepository menuItemRepo;
     
    public Menu getMenu(int id) {
        return menuRepo.findById(id).get();
    }
    
    public void insertMenu(Menu menu) {
    	menuRepo.save(menu);
    }
    
    public void deleteMenu(Integer id) {
    	menuRepo.deleteById(id);
    }
    
    public ArrayList<MenuItem> getMenuItems(int id) {
    	return menuItemRepo.findAllByMenuId(id);
    }
    
    public MenuItem getMenuItemByName(String itemName) {
    	return menuItemRepo.findByItemName(itemName);
    }
    
    public void insertMenuItem(MenuItem item) {
    	menuItemRepo.save(item);
    }
    
    public void deleteMenuItem(Integer id) {
    	menuItemRepo.deleteById(id);
    }
}
