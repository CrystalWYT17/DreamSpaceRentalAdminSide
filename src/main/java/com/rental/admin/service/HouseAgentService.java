package com.rental.admin.service;
import java.util.List;

/**
 * @author Lin Lae Win Wah
 */
import com.rental.admin.domain.Agent;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseAgent;

public interface HouseAgentService {
	
	HouseAgent save(House house,Agent agent);
	
	List<HouseAgent> findByAgent(Agent agent);
	
	List<HouseAgent> findByHouse(House house);
	
	void deleteById(Long id);
	
	void update(HouseAgent houseAgent);
	
	List<HouseAgent> findAll();
	
	void deleteAll();

}
