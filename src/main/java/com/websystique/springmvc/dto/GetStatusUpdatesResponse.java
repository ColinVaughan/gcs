package com.websystique.springmvc.dto;


public class GetStatusUpdatesResponse {

    private String status;
    private String storyTitle;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}
    
    

}
