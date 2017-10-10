package com.websystique.springmvc.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")

public class Customer {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String name;
    public String emailAddress;
    private String phone;
      
    public String restaurantId;

    public String addressLine1;

    public String addressLine2;
    

	public Integer getId() {
	
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Customer() {}


    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', emailAddress='%s', phone='%s', restaurantId='%s', addressLine1='%s', addressLine2='%s' ]",
                id, name, emailAddress, phone,  restaurantId, addressLine1, addressLine2);
    }

}

