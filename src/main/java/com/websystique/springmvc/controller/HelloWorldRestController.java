package com.websystique.springmvc.controller;
 
import java.util.Date;
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

import com.websystique.springmvc.dto.GetStatusUpdatesResponse;
import com.websystique.springmvc.model.Analytics;
import com.websystique.springmvc.model.AuthRequest;
import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.model.Order;
import com.websystique.springmvc.model.OrderItemPrinted;
import com.websystique.springmvc.model.Story;
import com.websystique.springmvc.model.Taps;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.AnalyticsService;
import com.websystique.springmvc.service.AuthorService;
import com.websystique.springmvc.service.CustomerService;
import com.websystique.springmvc.service.OrderItemPrintedService;
import com.websystique.springmvc.service.OrderService;
import com.websystique.springmvc.service.StoryService;
import com.websystique.springmvc.service.TapsService;
import com.websystique.springmvc.service.UserService;
 
@RestController
public class HelloWorldRestController {
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
 
    @Autowired
    CustomerService customerService;  //Service which will do all data retrieval/manipulation work
 
    @Autowired
    OrderService orderService;  //Service which will do all data retrieval/manipulation work
 
    @Autowired
    OrderItemPrintedService orderItemPrintedService;  //Service which will do all data retrieval/manipulation work
 
    
	  @Autowired
	    StoryService storyService;  

	    
	  @Autowired
	  AnalyticsService analyticsService;  

	    
	  @Autowired
	  AuthorService authorService;  
	  
	  @Autowired
	  TapsService tapsService;  
	  
	    /*
		   * Analytics
		   */
	    @RequestMapping(value = "/analytics/", method = RequestMethod.POST)
	    public ResponseEntity<String> createAnalytics(@RequestBody Analytics analytics) {
	      
	         analyticsService.create(analytics);	   
	         
	        return new ResponseEntity<String>("okay", HttpStatus.CREATED);
	    }
	  
	    
	    
	    @RequestMapping(value = "/taps/", method = RequestMethod.POST)
	    public ResponseEntity<String> createTaps(@RequestBody Taps taps) {
	    	
	    	Taps matching = tapsService.findByName(taps.getName());
	    	if(matching==null)
	    	{
	    		tapsService.save(taps);	
	    	}
	    	else
	    	{
	    		tapsService.update(taps, matching);
	    	}
	    	
       
	        return new ResponseEntity<String>("okay", HttpStatus.CREATED);
	    }
	    
	    
	    
	    
	    @RequestMapping(value = "/taps/", method = RequestMethod.GET)
	    public ResponseEntity<List<Taps>> getAllTaps() {
	      
	 		        return new ResponseEntity<List<Taps>>(tapsService.findAll(), HttpStatus.CREATED);

	    }
	    
	    
	    
	    
	    /*
		   * author
		   */
	    @RequestMapping(value = "/author/", method = RequestMethod.POST)
	    public ResponseEntity<String> createAnalytics(@RequestBody Author author) {
	      
	    	String id=  authorService.save(author);	   
	         
	        return new ResponseEntity<String>(id, HttpStatus.CREATED);
	    }
	  
	    
	    @RequestMapping(value = "/author/unique_check/{name}", method = RequestMethod.GET)
	    public ResponseEntity<String> createAnalytics(@PathVariable("name")  String name) {
	      
	       boolean doesItExist=  authorService.isAuthorNameExist(name);	  
	       
	       if(doesItExist)
	       {
		        return new ResponseEntity<String>("taken", HttpStatus.CREATED);

	       }
	         
	        return new ResponseEntity<String>("okay", HttpStatus.CREATED);
	    }
	  
	    
	    @RequestMapping(value = "/author/checkAuthentication/", method = RequestMethod.POST)
	    public ResponseEntity<Author> createAnalytics(@RequestBody  AuthRequest authRequest) {
	      
	    	Author a=  authorService.findByAuthentication(authRequest.getAuthType(), authRequest.getAuth());	  
	  	         
	        return new ResponseEntity<Author>(a, HttpStatus.OK);
	    }
	  
	    
	    
	  /*
	   * Search for stories based on keyword 
	   */
	  @RequestMapping(value = "/search/", method = RequestMethod.GET)
	    public ResponseEntity<List<Story>> search(@PathVariable("partialName") String partialName) {
		  
		        List<Story> stories = storyService.findByPartialName(partialName);
	        if(stories.isEmpty()){
	            return new ResponseEntity<List<Story>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Story>>(stories, HttpStatus.OK);
	    }
	 
	  
	  /*
	   * Search for stories based on keyword 
	   */
	  @RequestMapping(value = "/getUpdates/", method = RequestMethod.GET)
	    public ResponseEntity<List<Story>> getUpdates(@PathVariable("lastDateOfUpdate") Long lastDateOfUpdate) {
		  
		        List<Story> stories = storyService.getStoriesNewerThanThisDate(lastDateOfUpdate);
	        if(stories.isEmpty()){
	            return new ResponseEntity<List<Story>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Story>>(stories, HttpStatus.OK);
	    }
	  
	  
	  
	  /*
	   * Get all stories 
	   */
	  @RequestMapping(value = "/story/", method = RequestMethod.GET)
	    public ResponseEntity<List<Story>> listAllStories() {
		  
		  	Date date = new Date();
		  	System.out.println("this date is "+date.getTime());
	        List<Story> stories = storyService.findAll();
	        if(stories.isEmpty()){
	            return new ResponseEntity<List<Story>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Story>>(stories, HttpStatus.OK);
	    }
	 
	  
	  
	  
	  /*
	   * Get all stories 
	   */
	  @RequestMapping(value = "/story/test/", method = RequestMethod.GET)
	    public ResponseEntity<String> test() {
		  
	        return new ResponseEntity<String>("okay", HttpStatus.OK);
	    }
	 
	  
	  /*
	   * Get all stories 
	   */
	  @RequestMapping(value = "/story/{author}/getStatusUpdates", method = RequestMethod.GET)
	    public ResponseEntity<List<GetStatusUpdatesResponse>> getStatusUpdates(@PathVariable("author") String author) {
		  
		  	Date date = new Date();
		  	System.out.println("this date is "+date.getTime());
	        List<GetStatusUpdatesResponse> stories = storyService.getStatusUpdates(author);
	        if(stories.isEmpty()){
	            return new ResponseEntity<List<GetStatusUpdatesResponse>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<GetStatusUpdatesResponse>>(stories, HttpStatus.OK);
	    }
	 
	  
	  /*
	   * Get 1 story by id 
	   */
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
	 
	     
	    /*
		   * Create a story
		   */
	    @RequestMapping(value = "/story/", method = RequestMethod.POST)
	    public ResponseEntity<String> createStory(@RequestBody Story story) {
	        System.out.println("Creating Story " + story.getStoryTitle()); 
	        String id=  storyService.save(story);	      
	        return new ResponseEntity<String>(id, HttpStatus.CREATED);
	    }
	    
	    
	    //------------------- Update a Story --------------------------------------------------------
	     
	    @RequestMapping(value = "/story/update", method = RequestMethod.PUT)
	    public ResponseEntity<Integer> updateStory(@RequestBody Story story) {

	         	         
	       storyService.update(story);
	        return new ResponseEntity<Integer>(story.getId(), HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Story --------------------------------------------------------
	     
	    @RequestMapping(value = "/story/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Integer> deleteStory(@PathVariable("id") Integer id) {
	        System.out.println("Fetching & Deleting Story with id " + id);
	 
	        Story story = storyService.findById(id);
	        if (story == null) {
	            System.out.println("Unable to delete. Story with id " + id + " not found");
	            return new ResponseEntity<Integer>(id, HttpStatus.NOT_FOUND);
	        }
	 
	        storyService.delete(id);
	        return new ResponseEntity<Integer>(id, HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Stories --------------------------------------------------------
	     
	    @RequestMapping(value = "/story/", method = RequestMethod.DELETE)
	    public ResponseEntity<Story> deleteAllStories() {
	        System.out.println("Deleting All Stories");
	 
	        storyService.deleteAll();
	        return new ResponseEntity<Story>(HttpStatus.NO_CONTENT);
	    }
    
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.save(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        System.out.println("Updating User " + id);
         
        User currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
         
        userService.update(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.delete(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAll();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    

    
    //-------------------Retrieve All Customers--------------------------------------------------------
     
    @RequestMapping(value = "/customer/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomers() {
        System.out.println("Fetching Customers all...");
        List<Customer> customers = customerService.findAll();
        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id) {
        System.out.println("Fetching Customer with id " + id);
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + customer.getName());
 
        boolean doesExist = customerService.isCustomerExist(customer);
        if (doesExist) {
            System.out.println("A Customer with name " + customer.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        customerService.save(customer);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Customer --------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
        System.out.println("Updating Customer " + id);
         
        Customer currentCustomer = customerService.findById(id);
         
        if (currentCustomer==null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
 
        currentCustomer.setName(customer.getName());
        currentCustomer.setAddressLine1(customer.getAddressLine1());
        currentCustomer.setAddressLine2(customer.getAddressLine2());
        currentCustomer.setEmailAddress(customer.getEmailAddress());
         
        customerService.update(currentCustomer);
        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Customer --------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting Customer with id " + id);
 
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
 
        customerService.delete(id);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Customers --------------------------------------------------------
     
    @RequestMapping(value = "/customer/", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteAllCustomers() {
        System.out.println("Deleting All Customers");
 
        customerService.deleteAll();
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
 
    
    
    
    //-------------------Retrieve All Orders--------------------------------------------------------
     
    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listAllOrders() {
        System.out.println("Fetching Orders all...");
        List<Order> orders = orderService.findAll();
        if(orders.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Order--------------------------------------------------------
     
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id) {
        System.out.println("Fetching Order with id " + id);
        Order order = orderService.findById(id);
        if (order == null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Order--------------------------------------------------------
     
    @RequestMapping(value = "/order/", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(@RequestBody Order order,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Order " + order.getDateOrdered());
 
        boolean doesExist = orderService.isOrderExist(order);
        if (doesExist) {  
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        orderService.save(order);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Order --------------------------------------------------------
     
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Integer id, @RequestBody Order order) {
        System.out.println("Updating Order " + id);
         
        Order currentOrder = orderService.findById(id);
         
        if (currentOrder==null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
 

        currentOrder.setCustomerId(order.getCustomerId());
		currentOrder.setDateOrdered(order.getDateOrdered());
		currentOrder.setExpectedDeliveryTime(order.getExpectedDeliveryTime());
		currentOrder.setLastUpdated(order.getLastUpdated());
		currentOrder.setPaymentMethod(order.getPaymentMethod());
		currentOrder.setRequiredASAP(order.getRequiredASAP());
		currentOrder.setRequiresDelivery(order.getRequiresDelivery());
		currentOrder.setOrder_status(order.getOrder_status());		
         
        orderService.update(currentOrder);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
        
    }
 
    
    
    //------------------- Delete a Order --------------------------------------------------------
     
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting Order with id " + id);
 
        Order order = orderService.findById(id);
        if (order == null) {
            System.out.println("Unable to delete. Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
 
        orderService.delete(id);
        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Orders --------------------------------------------------------
     
    @RequestMapping(value = "/order/", method = RequestMethod.DELETE)
    public ResponseEntity<Order> deleteAllOrders() {
        System.out.println("Deleting All Orders");
 
        orderService.deleteAll();
        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
    }
    
    //-------------------Retrieve All OrderItemPrinteds--------------------------------------------------------
    
    @RequestMapping(value = "/orderItemPrinted/", method = RequestMethod.GET)
    public ResponseEntity<List<OrderItemPrinted>> listAllOrderItemPrinteds() {
        System.out.println("Fetching OrderItemPrinteds all...");
        List<OrderItemPrinted> orderItemPrinteds = orderItemPrintedService.findAll();
        if(orderItemPrinteds.isEmpty()){
            return new ResponseEntity<List<OrderItemPrinted>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<OrderItemPrinted>>(orderItemPrinteds, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single OrderItemPrinted--------------------------------------------------------
     
    @RequestMapping(value = "/orderItemPrinted/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderItemPrinted> getOrderItemPrinted(@PathVariable("id") Integer id) {
        System.out.println("Fetching OrderItemPrinted with id " + id);
        OrderItemPrinted orderItemPrinted = orderItemPrintedService.findById(id);
        if (orderItemPrinted == null) {
            System.out.println("OrderItemPrinted with id " + id + " not found");
            return new ResponseEntity<OrderItemPrinted>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderItemPrinted>(orderItemPrinted, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a OrderItemPrinted--------------------------------------------------------
     
    @RequestMapping(value = "/orderItemPrinted/", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrderItemPrinted(@RequestBody OrderItemPrinted orderItemPrinted,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating OrderItemPrinted " + orderItemPrinted.getName());
 
        boolean doesExist = orderItemPrintedService.isOrderItemPrintedExist(orderItemPrinted);
        if (doesExist) {  
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        orderItemPrintedService.save(orderItemPrinted);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/orderItemPrinted/{id}").buildAndExpand(orderItemPrinted.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     

     
    
    //------------------- Delete All OrderItemPrinteds --------------------------------------------------------
     
    @RequestMapping(value = "/orderItemPrinted/", method = RequestMethod.DELETE)
    public ResponseEntity<OrderItemPrinted> deleteAllOrderItemPrinteds() {
        System.out.println("Deleting All OrderItemPrinteds");
 
        orderItemPrintedService.deleteAll();
        return new ResponseEntity<OrderItemPrinted>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
    
 
}