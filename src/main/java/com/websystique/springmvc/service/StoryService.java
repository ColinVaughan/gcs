package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.dto.GetStatusUpdatesResponse;
import com.websystique.springmvc.model.Story;

public interface StoryService {

	List<Story> findByGenre(String genre);
	
	List<Story> findByPartialName(String partialName);
	
	List<Story> getStoriesNewerThanThisDate(Long updated);

	Story findByName(String name);

	List<Story> findByUpdate(Long updated);

	List<Story> findByCreationDate(Long created);

	String save(Story story);

	void update(Story story);

	void delete(Integer id);

	List<Story> findAll();

	void deleteAll();

	Story findById(Integer id);
	
	List<GetStatusUpdatesResponse>  getStatusUpdates(String author);
	
}
