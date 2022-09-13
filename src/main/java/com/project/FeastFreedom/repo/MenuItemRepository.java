package com.project.FeastFreedom.repo;

import org.springframework.stereotype.Repository;

import com.project.FeastFreedom.model.*;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

	ArrayList<MenuItem> findAllByMenuId(int id);

	MenuItem findByItemName(String itemName);

}