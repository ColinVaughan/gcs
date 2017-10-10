package com.websystique.springmvc.service;

import java.util.List;
import com.websystique.springmvc.model.Taps;


public interface TapsService {
	
	Taps findByName(String name);
	
	String save(Taps taps);
	
	void update(Taps taps, Taps matching);
	
	List<Taps> findAll(); 
	
}
