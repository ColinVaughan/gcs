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
import com.websystique.springmvc.model.Story;


@Repository
@Qualifier("orderRepository")
public class OrderRepositoryImpl  extends AbstractDao<Integer, Order> implements OrderRepository {

	


	   public void create(Order order) {
	     
		   persist(order);
	    }
	 
	    public void update(Order order) {
	    	 update(order);
	    }
	 
	    public void delete(Integer id) {
	    	Order  order = (Order)getSession().load(Order.class,id);
	    	delete(order);
	    	getSession().flush();
	    }
	    
	    
	 
	    public void deleteAll() {
	        
	        String hql = String.format("delete from Order");
	        Query query = (Query) getSession().createQuery(hql);  
	        ((org.hibernate.Query) query).executeUpdate();
	    }
	 
	    
	    public List < Order > findAll() {
	    	
	    	   Criteria criteria = (Criteria) createEntityCriteria();
	           return (List<Order>) criteria.list();
	           
	       
	    }


		@Override
		public  List < Order > findByName(String name) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("name", name));
	         return (List<Order>) criteria.list();
		}
		
		

		@Override
		public Order findById(Integer id) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("id", id));
	         return (Order) criteria.uniqueResult();
		}

	

		@Override
		public List<Order> findByLastUpdated(Integer lastUpdated) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("lastUpdated", lastUpdated));
	         return (List<Order>) criteria.list();
		}

		@Override
		public List<Order> findByCustomerId(Integer customerId) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("customerId", customerId));
	         return (List<Order>) criteria.list();
		}
		
		
		
		
		

}
