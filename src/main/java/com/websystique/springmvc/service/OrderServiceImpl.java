package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websystique.springmvc.model.Order;
import com.websystique.springmvc.repo.OrderRepository;




@Transactional
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRespository;
		
	private static List<Order> orders;
	

	

	public List<Order> findAll() {
		
		
		orders = orderRespository.findAll();
		if(orders ==null || orders.isEmpty())
		{
			populateDummyOrders();
			orders = orderRespository.findAll();
		}

		return orders;
	}
	
	public Order findById(Integer id) {
		orders = orderRespository.findAll();
		for(Order order : orders){
			if(order.getId() == id){
				return order;
			}
		}
		return null;
	}
	
	public List<Order> findByDate(Integer lastUpdated) {
		
		return orderRespository.findByLastUpdated(lastUpdated);
		
		
	}
	
	public void save(Order order) {

		
		orderRespository.create(order);
	
	}

	public void update(Order order) {
		
			
		if(order!=null)
		{

			orderRespository.update(order);
		}



	}



	public void deleteOrderById(Integer id) {
		
		Order	orderNew = orderRespository.findById(id);
		if(orderNew!=null)
		{
			orderRespository.delete(orderNew.getId());
			
		}
	}
	


	public void deleteAll(){
		orderRespository.deleteAll();
	}

	private  void populateDummyOrders(){
		Order test1= new Order();
		test1.setPaymentMethod("order1");
		test1.setCustomerId(1);
		test1.setDateOrdered("1-1-2017");
		test1.setExpectedDeliveryTime("2.00pm");
		test1.setLastUpdated(100);
		test1.setRequiredASAP("true");
		test1.setRequiresDelivery("true");
		test1.setOrder_status("new");

		
	     save(test1);

	}

	@Override
	public void delete(Integer id) {
		orderRespository.delete(id);
		
	}

	@Override
	public boolean isOrderExist(Order order) {

		Order c = (Order) findById(order.getId());
		if(c==null)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public List<Order> findByCustomerId(Integer customerId) {
		return orderRespository.findByCustomerId(customerId);
	}





}
