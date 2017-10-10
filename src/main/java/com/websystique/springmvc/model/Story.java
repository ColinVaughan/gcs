package com.websystique.springmvc.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "story")

public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String storyTitle;
	Integer numberOfviews = 100;
	boolean isStaffPick = false;
	String staffPickDets = "";
	Integer week;
	String author = "Glitterbug";

	String description;

	String genre = "";
	String genre_minor1 = "";
	String notes = "";
	
	int totalTaps;
	int totalViews;
	int totalFinishes; 
	
	public String storyString = "";
	
	
	String status;
	Long updated;
	Long created;
	// meta data

	public Story() {

	}

	public Story(String storyTitle, Integer week, Integer numberOfviews, boolean isStaffPick, String staffPickDets,
			String genre, String genre_minor1) {
		this.storyTitle = storyTitle;
		this.week = week;
		this.numberOfviews = numberOfviews;
		this.staffPickDets = staffPickDets;
		this.isStaffPick = isStaffPick;
		this.genre = genre;
		this.genre_minor1 = genre_minor1;

	}

	public Story(Story story) {
		this.storyTitle = story.getStoryTitle();
		this.week = story.getWeek();
		this.numberOfviews = story.getNumberOfviews();
		this.staffPickDets = story.getStaffPickDets();
		this.isStaffPick = story.isStaffPick();
		this.genre = story.getGenre();
		this.genre_minor1 = story.getGenre_minor1();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if(id==null)
		{
			return;
		}
		
		
		this.id = (Integer) id;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		if(storyTitle==null)
		{
			return;
		}
		this.storyTitle = storyTitle;
	}

	public Integer getNumberOfviews() {
		return numberOfviews;
	}

	public void setNumberOfviews(Integer numberOfviews) {
		if(numberOfviews==null)
		{
			return;
		}
		this.numberOfviews = numberOfviews;
	}

	public boolean isStaffPick() {
		return isStaffPick;
	}

	public void setStaffPick(boolean staffPick) {
		isStaffPick = staffPick;
	}

	public String getStaffPickDets() {
		return staffPickDets;
	}

	public void setStaffPickDets(String staffPickDets) {
		if(staffPickDets==null)
		{
			return;
		}
		this.staffPickDets = staffPickDets;
	}



	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		if(week==null)
		{
			return;
		}
		this.week = week;
	}

	public String getGenre() {
		return genre;
	}

	public String getGenre_minor1() {

		return genre_minor1;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(author==null)
		{
			return;
		}
		this.author = author;
	}

	
	public void setGenre(String genre) {
		if(genre==null)
		{
			return;
		}
		this.genre = genre;
	}

	public void setGenre_minor1(String genre_minor1) {
		if(genre_minor1==null)
		{
			return;
		}
		this.genre_minor1 = genre_minor1;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description==null)
		{
			return;
		}
		this.description = description;
	}

	public String getStoryString() {
		return storyString;
	}

	public void setStoryString(String storyString) {

		if (storyString != null) {
			this.storyString = storyString;
		}

	}

	public void setNotes(String notes) {
		if(notes==null)
		{
			return;
		}
		this.notes = notes;
	}

	public Long getUpdated() {
		return updated;
	}

	public void setUpdated(Long updated) {
		if(updated==null)
		{
			return;
		}
		this.updated = updated;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		if(created==null)
		{
			return;
		}
		this.created = created;
	}

	public String getNotes() {
		return notes;
	}
	
	

	public int getTotalTaps() {
		return totalTaps;
	}

	public void setTotalTaps(int totalTaps) {
		this.totalTaps = totalTaps;
	}

	public int getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(int totalViews) {

		this.totalViews = totalViews;
	}

	public int getTotalFinishes() {
		return totalFinishes;
	}

	public void setTotalFinishes(int totalFinishes) {

		this.totalFinishes = totalFinishes;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if(status==null)
		{
			return;
		}
		this.status = status;
	}

	@Override
	public String toString() {
		return "Story [storyTitle=" + storyTitle + ", numberOfviews=" + numberOfviews + ", isStaffPick=" + isStaffPick
				+ ", staffPickDets=" + staffPickDets + ", week=" + week + ", author=" + author + ", description="
				+ description + ", genre=" + genre
				+ ", genre_minor1=" + genre_minor1 + ", notes=" + notes 
				+ ", storyString=" + storyString + "]";
	}

}
