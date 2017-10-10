package com.websystique.springmvc.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.model.Order;
import com.websystique.springmvc.model.OrderItemPrinted;
import com.websystique.springmvc.model.OrderItemPrinted;

@Repository
@Qualifier("orderItemPrintedRepository")
public class OrderItemPrintedRepositoryImpl  extends AbstractDao<Integer, OrderItemPrinted>  implements OrderItemPrintedRepository {

		 
	   public void create(OrderItemPrinted orderItemPrinted) {
	     
		   persist(orderItemPrinted);
	    }
	 
	    public void update(OrderItemPrinted orderItemPrinted) {
	    	 update(orderItemPrinted);
	    }
	 
	    public void delete(Integer id) {
	    	OrderItemPrinted  orderItemPrinted = (OrderItemPrinted)getSession().load(OrderItemPrinted.class,id);
	    	delete(orderItemPrinted);
	    	getSession().flush();
	    }
	    
	    
	 
	    public void deleteAll() {
	        
	        String hql = String.format("delete from OrderItemPrinted");
	        Query query = (Query) getSession().createQuery(hql);  
	        ((org.hibernate.Query) query).executeUpdate();
	    }
	 
	    
	    public List < OrderItemPrinted > findAll() {
	    	
	    	   Criteria criteria = (Criteria) createEntityCriteria();
	           return (List<OrderItemPrinted>) criteria.list();
	           
	       
	    }

		@Override
		public  List < OrderItemPrinted > findByOrderItemId(Integer orderItemId) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("orderItemId", orderItemId));
	         return (List<OrderItemPrinted>) criteria.list();
		}
		
		@Override
		public  List < OrderItemPrinted > findByOrderId(Integer orderId) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("orderId", orderId));
	         return (List<OrderItemPrinted>) criteria.list();
		}

		@Override
		public OrderItemPrinted findById(Integer id) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("id", id));
	         return (OrderItemPrinted) criteria.uniqueResult();
		}
		

}
