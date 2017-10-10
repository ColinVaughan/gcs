package com.websystique.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "analytics")
public class Analytics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
