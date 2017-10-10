package com.websystique.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")

public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	
	private String username;
	
	private String address;
	
	private String email;
	
	public User(){

	}
	
	public User(String username, String address, String email){
		this.username = username;
		this.address = address;
		this.email = email;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


    @Override
    public String toString() {
        return String.format(
        		 "User[id=%s, username='%s', address='%s', email='%s']",
        	        id, username, address, email);
    }

	public Integer getId() {
	
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	


}
