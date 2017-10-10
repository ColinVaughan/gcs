		
         <div class="generic-container" ng-controller="CustomerController as ctrl"">
		 
		  
         <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Customers </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Phone</th>
                              <th>Email</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="c in ctrl.customers">
                              <td><span ng-bind="c.id"></span></td>
                              <td><span ng-bind="c.name"></span></td>
                              <td><span ng-bind="c.phone"></span></td>
                              <td><span ng-bind="c.emailAddress"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(c.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(c.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
	           





			   
	  
	       <div class="generic-container" ng-controller="OrderItemPrintedController as ctrl">
		   	
              <div class="panel-heading"><span class="lead">Recent Order details</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>customerId</th>
                              <th>dateOrderItemPrinteded</th>
                              <th>ASAP?</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="c in ctrl.orderItemPrinteds">
                              <td><span ng-bind="c.id"></span></td>
                              <td><span ng-bind="c.orderId"></span></td>
                              <td><span ng-bind="c.name"></span></td>
                              <td><span ng-bind="c.price"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(c.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(c.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
         
            </div>
  
  
   <div class="generic-container" ng-controller="OrderController as ctrl">
   
   
              <div class="panel-heading"><span class="lead">Recent Orders</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>customerId</th>
                              <th>dateOrdered</th>
                              <th>ASAP?</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="c in ctrl.orders">
                              <td><span ng-bind="c.id"></span></td>
                              <td><span ng-bind="c.customerId"></span></td>
                              <td><span ng-bind="c.dateOrdered"></span></td>
                              <td><span ng-bind="c.requiredASAP"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(c.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(c.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
 
 
 
 
 