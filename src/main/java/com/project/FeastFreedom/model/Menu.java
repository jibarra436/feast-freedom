package com.project.FeastFreedom.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(mappedBy = "menu")
	@JsonBackReference
    private Kitchen kitchen;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy="menu", cascade = CascadeType.ALL)
	private List<MenuItem> items;
	
	public void addItem(MenuItem item) {
		if(items == null)
			items = new ArrayList<MenuItem>();
		
		item.setMenu(this);
		items.add(item);
	}
	
}
