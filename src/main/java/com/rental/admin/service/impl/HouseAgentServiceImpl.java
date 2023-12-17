package com.rental.admin.service.impl;
import java.util.List;

/**
 * @author Lin Lae Win Wah
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.HouseAgentDAO;
import com.rental.admin.domain.Agent;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseAgent;
import com.rental.admin.service.HouseAgentService;

@Service
public class HouseAgentServiceImpl implements HouseAgentService{

//	@Autowired
//	HouseAgentDAO houseAgentDAO;

	@Override
	public HouseAgent save(House house, Agent agent) {
		// TODO Auto-generated method stub
//		HouseAgent houseAgent = new HouseAgent();
//		houseAgent.setAgent(agent);
//		houseAgent.setHouse(house);
//	
//		house.setHouseAgent(houseAgent);
//		houseAgent=houseAgentDAO.save(houseAgent);
		return null;
	}

	@Override
	public List<HouseAgent> findByAgent(Agent agent) {
		return null;
		// TODO Auto-generated method stub
		//return houseAgentDAO.findByAgent(agent);
	}

	@Override
	public List<HouseAgent> findByHouse(House house) {
		return null;
		// TODO Auto-generated method stub
		//return houseAgentDAO.findByHouse(house);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		//houseAgentDAO.deleteById(id);
	}

	@Override
	public void update(HouseAgent houseAgent) {
		// TODO Auto-generated method stub
		//houseAgentDAO.save(houseAgent);
	}

	@Override
	public List<HouseAgent> findAll() {
		return null;
		// TODO Auto-generated method stub
		//return (List<HouseAgent>) houseAgentDAO.findAll();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		//houseAgentDAO.deleteAll();
	}

	

	
	
	

	

}
