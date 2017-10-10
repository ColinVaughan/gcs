package com.websystique.springmvc.repo;

import java.util.List;

import com.websystique.springmvc.dto.GetStatusUpdatesResponse;
import com.websystique.springmvc.model.Story;

public interface StoryRepository {

		public  List<Story> findByPartialName(String partialName);
		public  List < Story >  findByGenre(String genre);
	    public  Story findByName(String name);
	    public  List < Story >  findByUpdate(Long updated);
	    public  List < Story >  findByCreationDate(Long created);
	    public List < Story > findAll();
	    public String create(Story story);
	    public void update(Story story);
	    public void delete(Integer id);
		public void deleteAll();
		Story findById(Integer id);
		public List<GetStatusUpdatesResponse> getStatusUpdates(String author);
}
