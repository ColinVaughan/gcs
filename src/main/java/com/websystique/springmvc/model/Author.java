package com.websystique.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")

public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;
	
	String authentication_phone;

	String authentication_email;

	
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

	
	

	public String getAuthentication_phone() {
		return authentication_phone;
	}

	public void setAuthentication_phone(String authentication_phone) {
		this.authentication_phone = authentication_phone;
	}

	public String getAuthentication_email() {
		return authentication_email;
	}

	public void setAuthentication_email(String authentication_email) {
		this.authentication_email = authentication_email;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + "]";
	}
	
	

}
