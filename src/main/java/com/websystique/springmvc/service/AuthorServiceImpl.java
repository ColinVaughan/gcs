package com.websystique.springmvc.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Story;
import com.websystique.springmvc.repo.AnalyticsRepository;
import com.websystique.springmvc.repo.AuthorRepository;


@Transactional
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	

	@Autowired
	private  AuthorRepository authorRepository;
	
	@Override
	public Author findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Author author) {
		return authorRepository.create(author);

		
	}

	@Override
	public void update(Author author) {
	Integer id = (Integer) author.getId();
		
	Author	authorNew = authorRepository.findById((author.getId()));
		
		
		if(authorNew!=null)
		{
			
			authorNew.setId(id);
			if(author.getAuthentication_email()!=null)
			{
				authorNew.setAuthentication_email(author.getAuthentication_email());
			}
			
			if(author.getAuthentication_phone()!=null)
			{
				authorNew.setAuthentication_phone(author.getAuthentication_phone());
			}			
					
			authorNew.setName(author.getName());
		
			authorRepository.update(authorNew);
		}

		
	}

	@Override
	public void delete(Integer id) {
		authorRepository.delete(id);
		
	}

	@Override
	public List<Author> findAll() {
		
		return authorRepository.findAll();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAuthorNameExist(String authorName) {


		if(authorName == null)
		{
			return false;
		}
		List<Author> authors = findAll();
		
		if(authors == null || authors.size()==0)
		{
			return false;
		}
		
		for(Author author : authors){
			if(authors!=null)
			{
				if(author.getName().equalsIgnoreCase(authorName)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	

	@Override
	public Author findByAuthentication(String authType, String auth) {
		
		return authorRepository.findByAuthentication(authType, auth);
	}

	@Override
	public Author findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
