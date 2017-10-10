'use strict';

angular.module('myApp').controller('StoryController', ['$scope', 'StoryService', function($scope, StoryService) {
	
    var self = this;
    self.story={id:null,storyTitle:'',author:'',genre:'',genre_minor1:'',description:'',created:'',numberOfviews:'', storyString:'', updated:''};
    self.stories=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllStories();


    function fetchAllStories(){
        StoryService.fetchAllStories()
            .then(
            function(d) {
                self.stories = d;
            },
            function(errResponse){
                console.error('Error while fetching Stories');
            }
        );
    }

    function createStory(story){
        StoryService.createStory(story)
            .then(
            fetchAllStories,
            function(errResponse){
                console.error('Error while creating Story');
            }
        );
    }

    function updateStory(story, id){
        StoryService.updateStory(story, id)
            .then(
            fetchAllStories,
            function(errResponse){
                console.error('Error while updating Story');
            }
        );
    }

    function deleteStory(id){
        StoryService.deleteStory(id)
            .then(
            fetchAllStories,
            function(errResponse){
                console.error('Error while deleting Story');
            }
        );
    }

    function submit() {
        if(self.story.id===null){
            console.log('Saving New Story', self.story);
            createStory(self.story);
        }else{
            updateStory(self.story, self.story.id);
            console.log('Story updated with id ', self.story.id);
        }
        reset();
    }

    function edit(id){


        console.log('id of the story to be shown', id);
        for(var i = 0; i < self.stories.length; i++){
            if(self.stories[i].id === id) {
                self.story = angular.copy(self.stories[i]);
                break;
            }
        }
    }
    

    function showstory(id){

        console.log('id of the story to be shown', id);
        for(var i = 0; i < self.stories.length; i++){
            if(self.stories[i].id === id) {
                self.story = angular.copy(self.stories[i]);
                break;
            }
        }
    }
    
    
    
    
    

    function remove(id){
        console.log('id to be deleted', id);
        if(self.story.id === id) {//clean form if the story to be deleted is shown there.
            reset();
        }
        deleteStory(id);
    }


    function reset(){
    	self.story={id:null,storyTitle:'',author:'',genre:'',genre_minor1:'',description:'',created:'',numberOfviews:''};     
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
