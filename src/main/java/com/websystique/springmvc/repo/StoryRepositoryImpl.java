package com.websystique.springmvc.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dto.GetStatusUpdatesResponse;
import com.websystique.springmvc.model.Order;
import com.websystique.springmvc.model.Story;
@Repository
@Qualifier("storyRepository")

public class StoryRepositoryImpl extends AbstractDao<Integer, Story>  implements StoryRepository {

	
	
	public List<Story> findByPartialName(String partialName) {
	    
         Criteria crit =createEntityCriteria();
     
         Criterion like_title= Restrictions.and(Restrictions.like("storyTitle", partialName + "%"));
         Criterion like_author= Restrictions.and(Restrictions.like("author", partialName + "%"));
         Criterion like_description= Restrictions.and(Restrictions.like("description", partialName + "%"));
 
         crit.add(Restrictions.or(like_title, like_author, like_description));       
         
         return (List<Story>) crit.list();
	}
	
	
	
	public List<Story> findByUpdate(Long lastUpdate) {
	    
         Criteria crit =createEntityCriteria();
     
         Criterion latest= Restrictions.and(Restrictions.gt("updated", lastUpdate));
             
         crit.add(latest);       
         
         return (List<Story>) crit.list();
	}
	

	public List<Story> findByGenre(String genre) {
		 Criteria criteria = (Criteria) createEntityCriteria();
         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("genre", genre));
         return (List<Story>) ((org.hibernate.Query) criteria).list();
	}

	public Story findByName(String name) {
		 Criteria criteria = (Criteria) createEntityCriteria();
         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("name", name));
         return (Story) ((org.hibernate.Query) criteria).uniqueResult();
	}



	public List<Story> findByCreationDate(Long created) {
		 Criteria criteria = (Criteria) createEntityCriteria();
         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("created", created));
         return (List<Story>) ((org.hibernate.Query) criteria).list();
		
	}


	public List<Story> findAll() {
		 Criteria criteria = (Criteria) createEntityCriteria();
         return (List<Story>) criteria.list();
	}

	public String create(Story story) {
		   try
		   {
			persist(story);
		   }
		   catch (Throwable t)
		   {
			   System.out.println(t.getLocalizedMessage());
			   return t.getLocalizedMessage();
		   }
		   
		   return story.getId().toString();
		
	}

	public void update(Story story) {
		persist(story);
		
	}

	public void delete(Integer id) {
		Story storyToDelete = (Story)getSession().load(Story.class,id);
    	delete(storyToDelete);
    	getSession().flush();
		
	}

	public void deleteAll() {
		  String hql = String.format("delete from Story");
	        Query query = (Query) getSession().createQuery(hql);  
	        ((org.hibernate.Query) query).executeUpdate();
		
	}

	public Story findById(Integer id) {
		 Criteria criteria = (Criteria) createEntityCriteria();
         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("id", id));
         return (Story) criteria.uniqueResult();
	}



	@Override
	public List<GetStatusUpdatesResponse> getStatusUpdates(String author) {
		//1. get all the stories by this author 
		
		 Criteria criteria = (Criteria) createEntityCriteria();
         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("author", author));
         ArrayList<Story> stories =   (ArrayList<Story>) criteria.list();
		//2. for each story, get the id and status and return these 
         
         List<GetStatusUpdatesResponse> list = new ArrayList<GetStatusUpdatesResponse>();
         for(Story story: stories)
         {
        	 GetStatusUpdatesResponse next =new GetStatusUpdatesResponse();
        	 next.setStatus(story.getStatus());
        	 next.setStoryTitle(story.getStoryTitle());
        	 
        	 list.add(next);
         }
         
         return list;
	}
	
	
	

}
