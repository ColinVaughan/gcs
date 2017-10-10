'use strict';

angular.module('myApp').factory('OrderItemPrintedService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/Spring4MVCAngularJSExample/orderItemPrinted/';

    var factory = {
        fetchAllOIPs: fetchAllOIPs,
        createorderItemPrinted:createorderItemPrinted,
        updateorderItemPrinted:updateorderItemPrinted,
        deleteorderItemPrinted:deleteorderItemPrinted
    };

    return factory;

    function fetchAllOIPs() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching orderItemPrinteds');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createorderItemPrinted(orderItemPrinted) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, orderItemPrinted)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating orderItemPrinted');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateorderItemPrinted(orderItemPrinted, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, orderItemPrinted)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating orderItemPrinted');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteorderItemPrinted(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting orderItemPrinted');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
