package com.websystique.springmvc.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orderItemPrinted")

public class OrderItemPrinted {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private Integer orderId;
	
    private Integer parentId;

    private String name;

    private Integer menuItemId=1;
    private boolean isSubMenuItem=false;
    
    
private String price;


private String type;

private Integer orderItemId;



	public OrderItemPrinted() {}



	
    public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}


	
	



	public Integer getOrderId() {
		return orderId;
	}




	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}




	public Integer getParentId() {
		return parentId;
	}




	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPrice() {
		return price;
	}




	public void setPrice(String price) {
		this.price = price;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Integer getOrderItemId() {
		return orderItemId;
	}




	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}




	@Override
    public String toString() {
        return String.format(
                "OrderItemPrinted[id=%s,orderId='%s',parentId='%s',name='%s',price='%s',type='%s',orderItemId='%s']",
                id, orderId,parentId, name, price,  type, orderItemId);
    }

}

