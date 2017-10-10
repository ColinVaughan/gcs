package com.websystique.springmvc.repo;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.Story;
import com.websystique.springmvc.model.Taps;


@Repository
@Qualifier("tapsRepository")
public class TapsRepositoryImpl extends AbstractDao<Integer, Taps>  implements TapsRepository {


	public Taps findByName(String name) {
		 Criteria criteria =createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Taps) (criteria).uniqueResult();
	}


	@Override
	public String create(Taps taps) {
		persist(taps);
		return taps.getId().toString();
		
	}

	@Override
	public void update(Taps taps) {
		update(taps);
		
	}

	@Override
	public List<Taps> findAll() {
		 Criteria criteria = (Criteria) createEntityCriteria();
         return (List<Taps>) criteria.list();
	}



	@Override
	public Taps findById(Integer id) {
		return getByKey(id);

	}


}

