package com.rental.admin.domain;
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

@Entity
public class ContractUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractId")
	private Contract contract;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "houseId")
	private House house;
	
	@ManyToOne
	@JoinColumn(name = "agentId")
	private Agent agent;
	
	private Boolean enabled;
	
	public ContractUser() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	
	
	
}
