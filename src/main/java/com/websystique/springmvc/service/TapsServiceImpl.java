
package com.websystique.springmvc.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websystique.springmvc.model.Taps;
import com.websystique.springmvc.repo.TapsRepository;


@Transactional
@Service("tapService")
public class TapsServiceImpl implements TapsService {



	@Autowired
	private  TapsRepository tapsRepository;
	
	@Override
	public Taps findByName(String name) {
		return tapsRepository.findByName(name);
	}

	@Override
	public String save(Taps taps) {
		return tapsRepository.create(taps);

		
	}

	@Override
	public void update(Taps taps, Taps tapsFromRepo) {
	Integer id = (Integer) taps.getId();
	tapsFromRepo.setId(id);
	
			if(taps.getNumber_views()!=null)
			{
				int newNumViews = tapsFromRepo.getNumber_views()+ taps.getNumber_views();
				taps.setNumber_views(newNumViews);
			}
			if(taps.getNumber_finishes()!=null)
			{
				int newNumFinishes = tapsFromRepo.getNumber_finishes()+ taps.getNumber_finishes();

				taps.setNumber_finishes(newNumFinishes);
			}
			
			
			tapsRepository.update(tapsFromRepo);
		

		
	}

	

	@Override
	public List<Taps> findAll() {
		
		return tapsRepository.findAll();
	}

}
