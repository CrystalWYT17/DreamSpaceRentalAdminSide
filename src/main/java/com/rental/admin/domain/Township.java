package com.rental.admin.domain;

/**
 * @author Wutt Yee Tun
 */

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Township {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer townshipId;
	
	private String townshipName;
	
	@OneToMany(mappedBy = "township")
	private Set<HouseTownship> houseTownship= new HashSet<HouseTownship>();
	
	public Township() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTownshipId() {
		return townshipId;
	}

	public void setTownshipId(Integer townshipId) {
		this.townshipId = townshipId;
	}

	public String getTownshipName() {
		return townshipName;
	}

	public void setTownshipName(String townshipName) {
		this.townshipName = townshipName;
	}

	public Set<HouseTownship> getHouseTownship() {
		return houseTownship;
	}

	public void setHouseTownship(Set<HouseTownship> houseTownship) {
		this.houseTownship = houseTownship;
	}

	
	
}
