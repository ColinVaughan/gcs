package com.websystique.springmvc.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.repo.UserRepository;




@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRespository;
		
	private static List<User> users;
	

	

	public List<User> findAll() {
		
		
		users = userRespository.findAll();
		if(users ==null || users.isEmpty())
		{
			populateDummyUsers();
			users = userRespository.findAll();
		}

		return users;
	}
	
	public User findById(long id) {
		users = userRespository.findAll();
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		
		if(users == null)
		{
			return null;
		}
		for(User user : users){
			if(user!=null)
			{
				if(user.getUsername().equalsIgnoreCase(name)){
					return user;
				}
			}
		}
		return null;
	}
	
	public void save(User user) {
	
		userRespository.create(user);

	}

	public void update(User user) {
		
		User	userNew = userRespository.findByEmail(user.getEmail());
		if(userNew!=null)
		{
			userNew.setAddress(user.getAddress());
			userNew.setUsername(user.getEmail());		
			userRespository.create(userNew);
		}

	//	int index = users.indexOf(user);
	//	users.set(index, user);
	}

	public void delete(User user) {
		
		userRespository.delete(user);
	}

	public void deleteUserByEmail(String email) {
		
		User	userNew = userRespository.findByEmail(email);
		if(userNew!=null)
		{
			userRespository.delete(userNew);
			
		}
	}
	
	public boolean isUserExist(User user) {
		return findByName(user.getEmail())!=null;
	}
	
	public void deleteAll(){
		userRespository.deleteAll();
	}

	private  void populateDummyUsers(){

		save(new User("Sam", "NY", "sam@abc.com"));
		save(new User("Tomy", "ALBAMA", "tomy@abc.com"));
		save(new User("Kelly", "NEBRASKA", "kelly@abc.com"));
		save(new User("Tomy1", "ALBAMA1", "tomy1@abc.com"));
	}





}
