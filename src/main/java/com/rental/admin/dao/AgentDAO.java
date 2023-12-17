package com.rental.admin.dao;

/**
 * @author Lin Lae Win Wah
 */

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.Agent;

public interface AgentDAO extends CrudRepository<Agent, Long> {

	List<Agent> findAll();
	
	Agent findByAgentFName(String agentFName);
}
