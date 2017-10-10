package com.websystique.springmvc.repo;

import java.util.List;

import com.websystique.springmvc.model.Taps;


public interface TapsRepository {
	
	public Taps findByName(String name);
	public String create(Taps taps);
	public void update(Taps taps);
    public List < Taps > findAll();
    Taps findById(Integer id);
}
