package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;



public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	void save(User user);
	
	void update(User user);
	
	void delete(User user);

	List<User> findAll(); 
	
	void deleteAll();
	
	public boolean isUserExist(User user);
	
}
