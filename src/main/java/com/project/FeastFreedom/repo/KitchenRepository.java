package com.project.FeastFreedom.repo;

import org.springframework.stereotype.Repository;

import com.project.FeastFreedom.model.*;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Integer> {
	
}