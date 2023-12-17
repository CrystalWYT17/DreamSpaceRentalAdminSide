package com.rental.admin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class HouseOwner {
	
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer houseOwnerId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "houseId")
    private  House house;

    private Boolean enabled;

    public HouseOwner() {

    }

    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getHouseOwnerId() {

        return houseOwnerId;

    }

    public void setHouseOwnerId(Integer houseOwnerId) {

        this.houseOwnerId = houseOwnerId;

    }

    public User getUser() {

        return user;

    }

    public void setUser(User user) {

        this.user = user;

    }

    public House getHouse() {

        return house;

    }

    public void setHouse(House house) {

        this.house = house;

    }

}
