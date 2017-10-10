package com.websystique.springmvc.repo;

import java.util.List;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Story;




public interface AuthorRepository {
	
	public Author findByName(String name);
	public  List<Author> findByPartialName(String partialName);
	public String create(Author author);
	public void update(Author author);
	public void delete(Integer id);
	public void deleteAll();
	Author findById(Integer id);
    public List < Author > findAll();
	public Author findByAuthentication(String authType, String auth);
}
