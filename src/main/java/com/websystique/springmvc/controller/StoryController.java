package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Story;
import com.websystique.springmvc.service.StoryService;

@RestController
public class StoryController {

	  @Autowired
	    StoryService storyService;  
	  
	  /*
	  
	  
	   // Get all stories 
	   
	  @RequestMapping(value = "/story/", method = RequestMethod.GET)
	    public ResponseEntity<List<Story>> listAllStories() {
	        List<Story> stories = storyService.findAll();
	        if(stories.isEmpty()){
	            return new ResponseEntity<List<Story>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Story>>(stories, HttpStatus.OK);
	    }
	 
	  
	  
	   // Get 1 story by id 
	   
	    @RequestMapping(value = "/story/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Story> getStory(@PathVariable("id") Integer id) {
	        System.out.println("Fetching Story with id " + id);
	        Story story = storyService.findById(id);
	        if (story == null) {
	            System.out.println("Story with id " + id + " not found");
	            return new ResponseEntity<Story>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Story>(story, HttpStatus.OK);
	    }
	 
	  // Create a story
	   * 
	    @RequestMapping(value = "/story/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createStory(@RequestBody Story story,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Story " + story.getStoryTitle()); 
	        storyService.save(story);	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/story/{id}").buildAndExpand(story.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	    
	    //------------------- Update a Story --------------------------------------------------------
	     
	    @RequestMapping(value = "/story/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Story> updateStory(@PathVariable("id") Integer id, @RequestBody Story story) {
	        System.out.println("Updating Story " + id);
	         	         
	        storyService.update(id, story);
	        return new ResponseEntity<Story>(story, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Story --------------------------------------------------------
	     
	    @RequestMapping(value = "/story/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Story> deleteStory(@PathVariable("id") Integer id) {
	        System.out.println("Fetching & Deleting Story with id " + id);
	 
	        Story story = storyService.findById(id);
	        if (story == null) {
	            System.out.println("Unable to delete. Story with id " + id + " not found");
	            return new ResponseEntity<Story>(HttpStatus.NOT_FOUND);
	        }
	 
	        storyService.delete(id);
	        return new ResponseEntity<Story>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Stories --------------------------------------------------------
	     
	    @RequestMapping(value = "/story/", method = RequestMethod.DELETE)
	    public ResponseEntity<Story> deleteAllStories() {
	        System.out.println("Deleting All Stories");
	 
	        storyService.deleteAll();
	        return new ResponseEntity<Story>(HttpStatus.NO_CONTENT);
	    }
	    */

}
