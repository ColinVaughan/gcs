package com.websystique.springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.Analytics;
import com.websystique.springmvc.repo.AnalyticsRepository;


@Transactional
@Service("analyticsService")
public class AnalyticsServiceImpl implements AnalyticsService {

	@Autowired
	private AnalyticsRepository analyticsRespository;
	
	@Override
	public void create(Analytics analytics) {
		analyticsRespository.create(analytics);
		
	}

}
