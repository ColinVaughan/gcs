package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Order;




public interface OrderService {
	
	Order findById(Integer id);
	
	List < Order > findByDate(Integer lastUpdated);
	
    List < Order > findByCustomerId(Integer customerId);

	
	void save(Order order);
	
	void update(Order order);
	
	void delete(Integer id);

	List<Order> findAll(); 
	
	void deleteAll();
	
	public boolean isOrderExist(Order order);
	
}
