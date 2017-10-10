package com.websystique.springmvc.service;

import java.util.List;
import com.websystique.springmvc.model.Author;


public interface AuthorService {
	
	
	Author findByName(String name);
	
	String save(Author author);
	
	void update(Author author);
	
	void delete(Integer id);

	List<Author> findAll(); 
	
	void deleteAll();
	
	public boolean isAuthorNameExist(String authorName);

	Author findById(Integer id);

	Author findByAuthentication(String authType, String auth);
}
