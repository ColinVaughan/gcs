package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.OrderItemPrinted;




public interface OrderItemPrintedService {
	
	OrderItemPrinted findById(Integer id);
	
    public  List < OrderItemPrinted > findByOrderItemId(Integer orderItemId);
    public  List < OrderItemPrinted > findByOrderId(Integer orderId);
	
	void save(OrderItemPrinted orderItemPrinted);
	
	void update(OrderItemPrinted orderItemPrinted);
	
	void delete(Integer id);

	List<OrderItemPrinted> findAll(); 
	
	void deleteAll();
	
	public boolean isOrderItemPrintedExist(OrderItemPrinted orderItemPrinted);
	
}
