package com.websystique.springmvc.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.OrderItemPrinted;
import com.websystique.springmvc.repo.OrderItemPrintedRepository;




@Transactional
@Service("orderItemPrintedService")
public class OrderItemPrintedServiceImpl implements OrderItemPrintedService{
	
	@Autowired
	private OrderItemPrintedRepository orderItemPrintedRespository;
		
	private static List<OrderItemPrinted> orderItemPrinteds;
	
	

	public List<OrderItemPrinted> findAll() {
		
		
		orderItemPrinteds = orderItemPrintedRespository.findAll();
		if(orderItemPrinteds ==null || orderItemPrinteds.isEmpty())
		{
			populateDummyOrderItemPrinteds();
			orderItemPrinteds = orderItemPrintedRespository.findAll();
		}

		return orderItemPrinteds;
	}
	
	public OrderItemPrinted findById(Integer id) {
		orderItemPrinteds = orderItemPrintedRespository.findAll();
		for(OrderItemPrinted orderItemPrinted : orderItemPrinteds){
			if(orderItemPrinted.getId() == id){
				return orderItemPrinted;
			}
		}
		return null;
	}
	
	public List<OrderItemPrinted> findByOrderItemId(Integer orderItemId) {
		
		return orderItemPrintedRespository.findByOrderItemId(orderItemId);
		
		
	}
	
	
	
	
	public void save(OrderItemPrinted orderItemPrinted) {		
		orderItemPrintedRespository.create(orderItemPrinted);
	}

	public void update(OrderItemPrinted orderItemPrinted) {
		
			
		if(orderItemPrinted!=null)
		{

			orderItemPrintedRespository.update(orderItemPrinted);
		}



	}



	public void deleteOrderItemPrintedById(Integer id) {
		
		OrderItemPrinted	orderItemPrintedNew = orderItemPrintedRespository.findById(id);
		if(orderItemPrintedNew!=null)
		{
			orderItemPrintedRespository.delete(orderItemPrintedNew.getId());
			
		}
	}
	
	


	public void deleteAll(){
		orderItemPrintedRespository.deleteAll();
	}

	private  void populateDummyOrderItemPrinteds(){
		OrderItemPrinted test1= new OrderItemPrinted();
		test1.setName("Order item name");
		test1.setOrderId(1);
		test1.setPrice("11.00");
		test1.setType("parent");
		test1.setOrderItemId(2);
		test1.setParentId(1);
	
	     save(test1);

	}

	@Override
	public void delete(Integer id) {
		orderItemPrintedRespository.delete(id);
		
	}

	@Override
	public boolean isOrderItemPrintedExist(OrderItemPrinted orderItemPrinted) {

		OrderItemPrinted c = (OrderItemPrinted) findById(orderItemPrinted.getId());
		if(c==null)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public List<OrderItemPrinted> findByOrderId(Integer orderId) {
		return orderItemPrintedRespository.findByOrderId(orderId);

	}



}
