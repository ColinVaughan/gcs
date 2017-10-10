package com.websystique.springmvc.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")


public class Order {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;


    private Integer customerId;
	
    private Integer lastUpdated;

    private String requiredASAP;

    
private String requiresDelivery;


private String paymentMethod;

private String expectedDeliveryTime;


    public String order_status;
    public String dateOrdered="";
	
	
	public Order() {}


	
	
	
    public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public Integer getCustomerId() {
		return customerId;
	}





	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}





	public Integer getLastUpdated() {
		return lastUpdated;
	}





	public void setLastUpdated(Integer lastUpdated) {
		this.lastUpdated = lastUpdated;
	}





	public String getRequiredASAP() {
		return requiredASAP;
	}





	public void setRequiredASAP(String requiredASAP) {
		this.requiredASAP = requiredASAP;
	}





	public String getRequiresDelivery() {
		return requiresDelivery;
	}





	public void setRequiresDelivery(String requiresDelivery) {
		this.requiresDelivery = requiresDelivery;
	}





	public String getPaymentMethod() {
		return paymentMethod;
	}





	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}





	public String getExpectedDeliveryTime() {
		return expectedDeliveryTime;
	}





	public void setExpectedDeliveryTime(String expectedDeliveryTime) {
		this.expectedDeliveryTime = expectedDeliveryTime;
	}








	public String getOrder_status() {
		return order_status;
	}





	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}





	public String getDateOrdered() {
		return dateOrdered;
	}





	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}





	@Override
    public String toString() {
        return String.format(
                "Order[id=%s,customerId='%s',lastUpdated='%s',requiredASAP='%s',requiresDelivery='%s',paymentMethod='%s',expectedDeliveryTime='%s',order_status='%s',dateOrdered='%s']",
                id, customerId, lastUpdated, requiredASAP, requiresDelivery,  paymentMethod, expectedDeliveryTime, order_status, dateOrdered);
    }

}

