package com.rental.admin.service;
/**
 * @author Lin Lae Win Wah
 */

import java.util.List;

import com.rental.admin.domain.Agent;

public interface AgentService {

	Agent save(Agent agent);
	
	List<Agent> findAll();
	
	Agent findById(Long id);
	
	void removeOne(Long id);
	
	Agent findByAgentFName(String agentFName);
}
