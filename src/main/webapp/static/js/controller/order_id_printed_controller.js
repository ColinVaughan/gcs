'use strict';

angular.module('myApp').controller('OrderItemPrintedController', ['$scope', 'OrderItemPrintedService', function($scope, OrderItemPrintedService) {
    var self = this;
    self.orderItemPrinted={id:null, orderId:'', name:'', price:'', type:'', parentId:'', orderItemId:''};

    self.orderItemPrinteds=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

	
    fetchAllOIPs();

    function fetchAllOIPs(){
        OrderItemPrintedService.fetchAllOIPs()
            .then(
            function(d) {
                self.orderItemPrinteds = d;
            },
            function(errResponse){
                console.error('Error while fetching OrderItemPrinteds');
            }
        );
    }

    function createOrderItemPrinted(orderItemPrinted){
        OrderItemPrintedService.createOrderItemPrinted(orderItemPrinted)
            .then(
            fetchAllOIPs,
            function(errResponse){
                console.error('Error while creating OrderItemPrinted');
            }
        );
    }

    function updateOrderItemPrinted(orderItemPrinted, id){
        OrderItemPrintedService.updateOrderItemPrinted(orderItemPrinted, id)
            .then(
            fetchAllOIPs,
            function(errResponse){
                console.error('Error while updating OrderItemPrinted');
            }
        );
    }

    function deleteOrderItemPrinted(id){
        OrderItemPrintedService.deleteOrderItemPrinted(id)
            .then(
            fetchAllOIPs,
            function(errResponse){
                console.error('Error while deleting OrderItemPrinted');
            }
        );
    }

    function submit() {
        if(self.orderItemPrinted.id===null){
            console.log('Saving New OrderItemPrinted', self.orderItemPrinted);
            createOrderItemPrinted(self.orderItemPrinted);
        }else{
            updateOrderItemPrinted(self.orderItemPrinted, self.orderItemPrinted.id);
            console.log('OrderItemPrinted updated with id ', self.orderItemPrinted.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.orderItemPrinteds.length; i++){
            if(self.orderItemPrinteds[i].id === id) {
                self.orderItemPrinted = angular.copy(self.orderItemPrinteds[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.orderItemPrinted.id === id) {//clean form if the orderItemPrinted to be deleted is shown there.
            reset();
        }
        deleteOrderItemPrinted(id);
    }


    function reset(){
        self.orderItemPrinted={id:null,ordername:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
