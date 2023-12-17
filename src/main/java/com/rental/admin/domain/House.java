package com.rental.admin.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;




@Entity
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long houseId;
	
	private Double length;
	private Double width;
	private Double area;
	private Integer masterBedRoom;
	private Integer bedRoom;
	private Integer bathRoom;
	private String floor;
	
	@Column(columnDefinition = "text")
	private String facilities;
	
	@Column(columnDefinition = "text")
	private String address;
	
	private Double price;
	private Boolean enabled;
	
	@Transient
	private MultipartFile houseImage1;
	
	@Transient
	private MultipartFile houseImage2;
	
	@Transient
	private MultipartFile houseImage3;
	
	@Transient
	private MultipartFile houseImage4;
	
	@Transient
	private MultipartFile houseImage5;
	
	@OneToOne(mappedBy = "house",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private HouseTownship houseTownship;
	
	@OneToOne(mappedBy = "house",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private HouseType houseType;
	
	@OneToMany(mappedBy = "house",cascade = CascadeType.ALL)
	private Set<HouseImage> houseImages=new HashSet<HouseImage>();
	
	@OneToOne(mappedBy = "house",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.LAZY)
	private HouseRenter houseRenter;
	
	@OneToOne(mappedBy = "house",cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	private HouseOwner houseOwner;
	
//	@OneToOne(mappedBy = "house",cascade = CascadeType.ALL,fetch = FetchType.EAGER) 
//	private HouseAgent houseAgent;
	
	@OneToOne(mappedBy = "house",cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	private ContractUser contractUser;
	
	public House() {
		// TODO Auto-generated constructor stub
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Integer getMasterBedRoom() {
		return masterBedRoom;
	}

	public void setMasterBedRoom(Integer masterBedRoom) {
		this.masterBedRoom = masterBedRoom;
	}

	public Integer getBedRoom() {
		return bedRoom;
	}

	public void setBedRoom(Integer bedRoom) {
		this.bedRoom = bedRoom;
	}

	public Integer getBathRoom() {
		return bathRoom;
	}

	public void setBathRoom(Integer bathRoom) {
		this.bathRoom = bathRoom;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public HouseTownship getHouseTownship() {
		return houseTownship;
	}

	public void setHouseTownship(HouseTownship houseTownship) {
		this.houseTownship = houseTownship;
	}

	public HouseType getHouseType() {
		return houseType;
	}

	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}

	public MultipartFile getHouseImage1() {
		return houseImage1;
	}

	public void setHouseImage1(MultipartFile houseImage1) {
		this.houseImage1 = houseImage1;
	}

	public MultipartFile getHouseImage2() {
		return houseImage2;
	}

	public void setHouseImage2(MultipartFile houseImage2) {
		this.houseImage2 = houseImage2;
	}

	public MultipartFile getHouseImage3() {
		return houseImage3;
	}

	public void setHouseImage3(MultipartFile houseImage3) {
		this.houseImage3 = houseImage3;
	}

	public MultipartFile getHouseImage4() {
		return houseImage4;
	}

	public void setHouseImage4(MultipartFile houseImage4) {
		this.houseImage4 = houseImage4;
	}

	public MultipartFile getHouseImage5() {
		return houseImage5;
	}

	public void setHouseImage5(MultipartFile houseImage5) {
		this.houseImage5 = houseImage5;
	}

	public Set<HouseImage> getHouseImages() {
		return houseImages;
	}

	public void setHouseImages(Set<HouseImage> houseImages) {
		this.houseImages = houseImages;
	}

	public HouseRenter getHouseRenter() {
		return houseRenter;
	}

	public void setHouseRenter(HouseRenter houseRenter) {
		this.houseRenter = houseRenter;
	}

	public HouseOwner getHouseOwner() {
		return houseOwner;
	}

	public void setHouseOwner(HouseOwner houseOwner) {
		this.houseOwner = houseOwner;
	}

//	public HouseAgent getHouseAgent() {
//		return houseAgent;
//	}
//
//	public void setHouseAgent(HouseAgent houseAgent) {
//		this.houseAgent = houseAgent;
//	}

	public ContractUser getContractUser() {
		return contractUser;
	}

	public void setContractUser(ContractUser contractUser) {
		this.contractUser = contractUser;
	}


	

}
