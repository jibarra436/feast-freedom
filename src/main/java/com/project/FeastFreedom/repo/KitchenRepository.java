package com.project.FeastFreedom.repo;

import org.springframework.stereotype.Repository;

import com.project.FeastFreedom.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Integer> {
	Kitchen findByEmail(String email);
}