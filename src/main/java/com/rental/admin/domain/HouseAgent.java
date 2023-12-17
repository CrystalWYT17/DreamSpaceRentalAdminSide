package com.rental.admin.domain;

import javax.persistence.CascadeType;

/**
 * @author Lin Lae Win Wah
 */

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class HouseAgent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "agentId")
	private Agent agent;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "houseId")
	private House house;

	public HouseAgent() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
	
}
