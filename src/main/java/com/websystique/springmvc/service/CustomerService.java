package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Customer;




public interface CustomerService {
	
	
	Customer findByName(String name);
	
	void save(Customer customer);
	
	void update(Customer customer);
	
	void delete(Integer id);

	List<Customer> findAll(); 
	
	void deleteAll();
	
	public boolean isCustomerExist(Customer customer);

	Customer findById(Integer id);
	
}
