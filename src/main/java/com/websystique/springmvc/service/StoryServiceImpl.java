package com.websystique.springmvc.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dto.GetStatusUpdatesResponse;
import com.websystique.springmvc.model.Story;
import com.websystique.springmvc.repo.StoryRepository;

@Service("storyService")
@Transactional
public class StoryServiceImpl implements StoryService {

	@Autowired
	private StoryRepository storyRepository;
		
	private static List<Story> stories;


	public List<Story> findAll() {
		
		
		stories = storyRepository.findAll();
		if(stories ==null || stories.isEmpty())
		{
			populateDummyStories();
			stories = storyRepository.findAll();
		}

		return stories;
	}
	
	@Override
	public Story findById(Integer id) {
		stories = storyRepository.findAll();
		for(Story story : stories){
			if(story.getId() == id){
				return story;
			}
		}
		return null;
	}
	
	public Story findByName(String title) {
		
		stories = storyRepository.findAll();
		if(stories == null)
		{
			return null;
		}
		for(Story story : stories){
			if(story!=null)
			{
				if(story.getStoryTitle().equalsIgnoreCase(title)){
					return story;
				}
			}
		}
		return null;
	}
	
	public String save(Story story) {
		Date date= new Date();
		if(story.getCreated()==0)
		{
			story.setCreated(date.getTime());
		}
		
		   try
		   {
			   return storyRepository.create(story);
		   }
		   catch (Throwable t)
		   {
			   System.out.println(t.getLocalizedMessage());
			   return t.getLocalizedMessage();
		   }
		
		
	}

	public void update(Story story) {
		
		Integer id = (Integer) story.getId();
		
		Story	storyNew = storyRepository.findById((story.getId()));
		
	
		
		if(storyNew!=null)
		{
			Date date= new Date();
			storyNew.setId(id);
			storyNew.setStoryTitle(story.getStoryTitle());
			storyNew.setNumberOfviews(story.getNumberOfviews());
			storyNew.setStaffPick(story.isStaffPick());
			storyNew.setStaffPickDets(story.getStaffPickDets());
			storyNew.setWeek(story.getWeek());
			
			storyNew.setAuthor(story.getAuthor());
			storyNew.setGenre(story.getGenre());
			storyNew.setGenre_minor1(story.getGenre_minor1());
			storyNew.setDescription(story.getDescription());
			storyNew.setCreated(story.getCreated());
			storyNew.setUpdated(date.getTime());
			storyNew.setNotes(story.getNotes());
			storyNew.setTotalFinishes(story.getTotalFinishes());
			storyNew.setTotalTaps(story.getTotalTaps());
			storyNew.setTotalViews(story.getTotalViews());
			storyNew.setStoryString(story.getStoryString());
			storyNew.setStatus(story.getStatus());

				
			//TODO add all fields 	
			
			storyRepository.update(storyNew);
		}


	}




	public void deleteAll(){
		storyRepository.deleteAll();
	}



	@Override
	public List<Story> findByGenre(String genre) {
		return storyRepository.findByGenre(genre);
	}
	

	@Override
	public List<Story> findByUpdate(Long updated) {
		return storyRepository.findByUpdate(updated);

	}

	@Override
	public List<Story> findByCreationDate(Long created) {
		return storyRepository.findByCreationDate(created);

	}
	
	

	private  void populateDummyStories(){
		Story test1= new Story();
		test1.setAuthor("author1");
		test1.setGenre("horror");
		test1.setStoryTitle("test title");
		test1.setDescription("test description");

		Story test2= new Story();
		test2.setAuthor("author2");
		test2.setGenre("horror");
		test2.setStoryTitle("test title 2");
		test2.setDescription("test description 2");
		
	     save(test1);
         save(test2);
	}

	@Override
	public void delete(Integer id) {
		
		Story	storyNew = storyRepository.findById(id);
		if(storyNew!=null)
		{
			storyRepository.delete(storyNew.getId());
			
		}
		
	}

	@Override
	public List<Story> findByPartialName(String partialName) {
		return storyRepository.findByPartialName(partialName);	 
	}
	
	@Override
	public List<Story> getStoriesNewerThanThisDate(Long updated) {
		return storyRepository.findByUpdate(updated);	 
	}

	@Override
	public List<GetStatusUpdatesResponse> getStatusUpdates(String author) {
		
		return storyRepository.getStatusUpdates(author);


	}
	
	

}
