package com.websystique.springmvc.repo;

import java.util.List;

import com.websystique.springmvc.model.User;


public interface UserRepository  {

    public User findByUsername(String username);
    public User findByEmail(String email);
    public List < User > findAll();
    public void create(User user);
    public void update(User user);
    public void delete(User user);
	public void deleteAll();
    

}