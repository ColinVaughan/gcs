package com.websystique.springmvc.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.Analytics;

@Repository
@Qualifier("analyticsRepository")
public class AnalyticsRepositoryImpl  extends AbstractDao<Integer, Analytics> implements AnalyticsRepository{

	@Override
	public void create(Analytics analytics) {

		persist(analytics);
	}
	
	
	

}
