package com.websystique.springmvc.repo;

import java.util.List;


import com.websystique.springmvc.model.Order;


public interface OrderRepository  {

    public  List<Order> findByName(String name);       
    public  List < Order > findByLastUpdated(Integer lastUpdated);
    public  List < Order > findByCustomerId(Integer customerId);
    public List < Order > findAll();
    public void create(Order order);
    public void update(Order order);
    public void delete(Integer id);
	public void deleteAll();
	Order findById(Integer id);
    
}
