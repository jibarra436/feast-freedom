package com.project.FeastFreedom.repo;

import org.springframework.stereotype.Repository;

import com.project.FeastFreedom.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<FeastUser, Integer> {
	FeastUser findByEmail(String email);	
}