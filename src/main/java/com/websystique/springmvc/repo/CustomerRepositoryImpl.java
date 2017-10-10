package com.websystique.springmvc.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.model.OrderItemPrinted;

@Repository
@Qualifier("customerRepository")
public class CustomerRepositoryImpl extends AbstractDao<Integer, Customer>  implements CustomerRepository {


		 
	   public void create(Customer customer) {
		   persist(customer);
	    }
	 
	    public void update(Customer customer) {
	    	update(customer);
	    }
	 
	    public void delete(Integer id) {
	    	
	    	Customer  customerToDelete = (Customer)getSession().load(Customer.class,id);
	    	delete(customerToDelete);
	    	getSession().flush();
	    }
	    
	    
	 
	    public void deleteAll() {
	        
	        String hql = String.format("delete from Customer");
	        Query query = (Query) getSession().createQuery(hql);  
	        ((org.hibernate.Query) query).executeUpdate();
	    }
	 
	    
	    
	    
	    
	    public List < Customer > findAll() {
	    	
	    	   Criteria criteria = (Criteria) createEntityCriteria();
	           return (List<Customer>) criteria.list();
	           
	       
	    }

		@Override
		public  List < Customer > findByName(String name) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("name", name));
	         return (List<Customer>) criteria.list();
		}

		@Override
		public Customer findByEmailAddress(String emailAddress) {	    	
	    	 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("emailAddress", emailAddress));
	         return (Customer) ((org.hibernate.Query) criteria).uniqueResult();
		}
		
		@Override
		public Customer findByPhone(String phone) {
		   	 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("phone", phone));
	         return (Customer) ((org.hibernate.Query) criteria).uniqueResult();
	
	
		}

		@Override
		public Customer findById(Integer id) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("id", id));
	         return (Customer) criteria.uniqueResult();
		}
		
		
		

}
