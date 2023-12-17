package com.rental.admin.dao;
import java.util.List;

/**
 * @author Lin Lae Win Wah
 */
import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.Agent;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseAgent;

public interface HouseAgentDAO extends CrudRepository<HouseAgent, Long>{

//	List<HouseAgent> findByAgent(Agent agent);
//	
//	List<HouseAgent> findByHouse(House house);

}
