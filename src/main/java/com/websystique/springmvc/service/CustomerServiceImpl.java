package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.repo.CustomerRepository;





@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRespository;
		
	private static List<Customer> customers;
	
	public List<Customer> findAll() {
		
		
		customers = customerRespository.findAll();
		if(customers ==null || customers.isEmpty())
		{
			populateDummyCustomers();
			customers = customerRespository.findAll();
		}

		return customers;
	}
	
	@Override
	public Customer findById(Integer id) {
		customers = customerRespository.findAll();
		for(Customer customer : customers){
			if(customer.getId() == id){
				return customer;
			}
		}
		return null;
	}
	
	public Customer findByName(String name) {
		
		if(customers == null)
		{
			return null;
		}
		for(Customer customer : customers){
			if(customer!=null)
			{
				if(customer.getName().equalsIgnoreCase(name)){
					return customer;
				}
			}
		}
		return null;
	}
	
	public void save(Customer customer) {

		customerRespository.create(customer);
	}

	public void update(Customer customer) {
		
		Customer	customerNew = customerRespository.findByPhone(customer.getPhone());
		if(customerNew!=null)
		{
			
			customerNew.setAddressLine1(customer.getAddressLine1());
			customerNew.setAddressLine2(customer.getAddressLine2());
			customerNew.setName(customer.getName());		
			customerNew.setEmailAddress(customer.getEmailAddress());		
			
			customerRespository.update(customerNew);
		}


	}



	public void deleteCustomerByPhone(String phone) {
		
		Customer	customerNew = customerRespository.findByPhone(phone);
		if(customerNew!=null)
		{
			customerRespository.delete(customerNew.getId());
			
		}
	}
	
	
	private Object findByPhone(String phone) {
		
		Customer c = customerRespository.findByPhone(phone);
		if( c == null)
		{
			return null;
		}
		return c;
	}

	public void deleteAll(){
		customerRespository.deleteAll();
	}

	private  void populateDummyCustomers(){
		Customer test1= new Customer();
		test1.setName("customer1");
		test1.setAddressLine1("c1- address");
		test1.setAddressLine2("c1 - address2");
		test1.setPhone("c1 - phone");
		test1.setEmailAddress("c1- email");
		test1.setRestaurantId("1");
		
		Customer test2= new Customer();
		test2.setName("customer2");
		test2.setAddressLine2("c2- address");
		test2.setAddressLine2("c2 - address2");
		test2.setPhone("c2 - phone");
		test2.setEmailAddress("c2- email");
		test2.setRestaurantId("2");
		
	     save(test1);
         save(test2);
	}

	@Override
	public void delete(Integer id) {
		customerRespository.delete(id);
		
	}

	@Override
	public boolean isCustomerExist(Customer customer) {

		Customer c = (Customer) findByPhone(customer.getPhone());
		if(c==null)
		{
			return false;
		}
		
		return true;
	}
	
	





}
