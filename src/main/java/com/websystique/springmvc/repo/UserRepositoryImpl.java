package com.websystique.springmvc.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.User;

@Repository
@Qualifier("userRespository")
public class UserRepositoryImpl  extends AbstractDao<Integer, User>  implements UserRepository{
	
	   public void create(User user) {
		   persist(user);
	    }
	 
	    public void update(User user) {
	    	update(user);
	    }
	 
	    public void delete(Integer id) {
	    	
	    	User  userToDelete = (User)getSession().load(User.class,id);
	    	delete(userToDelete);
	    	getSession().flush();
	    }
	    
	    
	 
	    public void deleteAll() {
	        
	        String hql = String.format("delete from User");
	        Query query = (Query) getSession().createQuery(hql);  
	        ((org.hibernate.Query) query).executeUpdate();
	    }
	 
	    
	    
	    
	    
	    public List < User > findAll() {
	    	
	    	   Criteria criteria = (Criteria) createEntityCriteria();
	           return (List<User>) criteria.list();
	           
	       
	    }

		@Override
		public  User  findByUsername(String username) {
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("username", username));
	         return(User) criteria.uniqueResult();
		}

		@Override
		public User findByEmail(String email) {	    	
	    	 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("email", email));
	         return (User) ((org.hibernate.Query) criteria).uniqueResult();
		}



}
