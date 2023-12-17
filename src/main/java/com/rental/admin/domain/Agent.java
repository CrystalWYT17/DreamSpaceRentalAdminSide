package com.rental.admin.domain;


/**
 * @author Lin Lae Win Wah
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String agentFName;
	private String agentLName;
	private String agentEmail;
	private String agentPh;
	private String agentTownship;
	private String agentAddress;
	
	private Boolean active = true;
	
	@Transient
	private MultipartFile agentImage;
	
	@OneToMany(mappedBy = "agent")
	@JsonIgnore
	private List<ContractUser> contractUserList;
	
//	@OneToMany(mappedBy = "agent",cascade = CascadeType.ALL)
//	@JsonIgnore
//	private List<HouseAgent> houseAgentList;
	
	public Agent() {}
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public MultipartFile getAgentImage() {
		return agentImage;
	}
	public void setAgentImage(MultipartFile agentImage) {
		this.agentImage = agentImage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAgentFName() {
		return agentFName;
	}
	public void setAgentFName(String agentFName) {
		this.agentFName = agentFName;
	}
	public String getAgentLName() {
		return agentLName;
	}
	public void setAgentLName(String agentLName) {
		this.agentLName = agentLName;
	}
	public String getAgentEmail() {
		return agentEmail;
	}
	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}
	public String getAgentPh() {
		return agentPh;
	}
	public void setAgentPh(String agentPh) {
		this.agentPh = agentPh;
	}
	public String getAgentTownship() {
		return agentTownship;
	}
	public void setAgentTownship(String agentTownship) {
		this.agentTownship = agentTownship;
	}
	public String getAgentAddress() {
		return agentAddress;
	}
	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	public List<ContractUser> getContractUserList() {
		return contractUserList;
	}

	public void setContractUserList(List<ContractUser> contractUserList) {
		this.contractUserList = contractUserList;
	}

//	public List<HouseAgent> getHouseAgentList() {
//		return houseAgentList;
//	}
//
//	public void setHouseAgentList(List<HouseAgent> houseAgentList) {
//		this.houseAgentList = houseAgentList;
//	}
//	
	
	
}
