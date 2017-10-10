'use strict';

angular.module('myApp').factory('StoryService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://chat-nowapp.rhcloud.com/chat/story/';

    var factory = {
        fetchAllStories: fetchAllStories,
        createStory: createStory,
        updateStory:updateStory,
        deleteStory:deleteStory
    };

    return factory;

    function fetchAllStories() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Stories');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createStory(story) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, story)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Story');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateStory(story, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, story)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Story');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteStory(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Story');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
