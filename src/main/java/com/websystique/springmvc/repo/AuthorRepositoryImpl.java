package com.websystique.springmvc.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Story;



@Repository
@Qualifier("authorRepository")
public class AuthorRepositoryImpl extends AbstractDao<Integer, Author>  implements AuthorRepository {

	@Override
	public Author findByName(String name) {
		 Criteria criteria = (Criteria) createEntityCriteria();
         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("name", name));
         return (Author) ((org.hibernate.Query) criteria).uniqueResult();
		
	}

	@Override
	public Author findById(Integer id) {
		return getByKey(id);
	}

	@Override
	public String create(Author author) {
		persist(author);
		
		return author.getId().toString();
		
	}

	@Override
	public void update(Author author) {
		update(author);
		
	}

	@Override
	public void delete(Integer id) {
		Author authorToDelete = (Author)getSession().load(Author.class,id);
    	delete(authorToDelete);
    	getSession().flush();
		
	}

	@Override
	public void deleteAll() {
		String hql = String.format("delete from Author");
        Query query = (Query) getSession().createQuery(hql);  
        ((org.hibernate.Query) query).executeUpdate();
		
	}

	@Override
	public List<Author> findByPartialName(String partialName) {
		Criteria criteria = (Criteria) createEntityCriteria();
        ((org.hibernate.Criteria) criteria).add(Restrictions.eq("partialName", partialName));
        return (List<Author>) criteria.list();
	}

	@Override
	public List<Author> findAll() {
		 Criteria criteria = (Criteria) createEntityCriteria();
         return (List<Author>) criteria.list();
	}

	
	@Override
	public Author findByAuthentication(String authType, String auth) {

		if(authType.equals("phone"))
		{
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("authentication_phone", auth));
	         return (Author) ((org.hibernate.Query) criteria).uniqueResult();
		}
		

		else if(authType.equals("email"))
		{
			 Criteria criteria = (Criteria) createEntityCriteria();
	         ((org.hibernate.Criteria) criteria).add(Restrictions.eq("authentication_email", auth));
	         return (Author) ((org.hibernate.Query) criteria).uniqueResult();
		}
		return null;
	}

}
