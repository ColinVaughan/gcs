package com.websystique.springmvc.repo;

import java.util.List;


import com.websystique.springmvc.model.OrderItemPrinted;


public interface OrderItemPrintedRepository  {
    
    public  List < OrderItemPrinted > findByOrderItemId(Integer orderItemId);
    public  List < OrderItemPrinted > findByOrderId(Integer orderId);
    public List < OrderItemPrinted > findAll();
    public void create(OrderItemPrinted orderItemPrinted);
    public void update(OrderItemPrinted orderItemPrinted);
    public void delete(Integer id);
	public void deleteAll();
	OrderItemPrinted findById(Integer id);
    
}
