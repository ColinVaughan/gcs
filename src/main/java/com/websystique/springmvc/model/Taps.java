package com.websystique.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ArturAga
 *
 */
@Entity
@Table(name = "taps")

public class Taps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;
	
	Integer number_finishes;

	Integer number_views;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumber_finishes() {
		return number_finishes;
	}

	public void setNumber_finishes(Integer number_finishes) {
		this.number_finishes = number_finishes;
	}

	public Integer getNumber_views() {
		return number_views;
	}

	public void setNumber_views(Integer number_views) {
		this.number_views = number_views;
	}

	@Override
	public String toString() {
		return "Taps [name=" + name + "]";
	}
	
	

}
