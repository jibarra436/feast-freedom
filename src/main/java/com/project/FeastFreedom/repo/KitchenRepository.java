package com.project.FeastFreedom.repo;

import org.springframework.stereotype.Repository;

import com.project.FeastFreedom.model.*;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Integer> {
	Kitchen findByEmail(String email);
	
	@Modifying
	@Transactional
    @Query(value = "UPDATE kitchen SET imageurl = :imageURL WHERE email = :email", nativeQuery = true)
	void setKitchenImageById(@Param("email") String email, @Param("imageURL") String imageUrl);
}