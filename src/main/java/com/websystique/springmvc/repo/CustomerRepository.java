package com.websystique.springmvc.repo;

import java.util.List;


import com.websystique.springmvc.model.Customer;


public interface CustomerRepository  {

    public  List<Customer> findByName(String name);
    public  Customer findByEmailAddress(String emailAddress);
    public  Customer findByPhone(String phone);
    public List < Customer > findAll();
    public void create(Customer customer);
    public void update(Customer customer);
    public void delete(Integer id);
	public void deleteAll();
	Customer findById(Integer id);
    
}
