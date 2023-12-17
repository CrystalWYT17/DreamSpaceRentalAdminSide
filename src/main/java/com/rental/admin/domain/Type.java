package com.rental.admin.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

/**
 * @author Wutt Yee Tun
 */

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long typeId;
	
	private String typeName;
	
	@OneToMany(mappedBy = "type",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<HouseType> houseType = new HashSet<HouseType>();
	
	public Type() {
		// TODO Auto-generated constructor stub
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<HouseType> getHouseType() {
		return houseType;
	}

	public void setHouseType(Set<HouseType> houseType) {
		this.houseType = houseType;
	}

	
	
	
}
