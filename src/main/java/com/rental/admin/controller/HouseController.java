package com.rental.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.admin.domain.Agent;
import com.rental.admin.domain.Booking;
import com.rental.admin.domain.ContractUser;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseAgentSample;
import com.rental.admin.domain.HouseImage;
import com.rental.admin.domain.HouseOwner;
import com.rental.admin.domain.HouseRenter;
import com.rental.admin.service.AgentService;
import com.rental.admin.service.BookingService;
import com.rental.admin.service.ContractService;
import com.rental.admin.service.ContractUserService;
import com.rental.admin.service.HouseAgentSampleService;
import com.rental.admin.service.HouseOwnerService;
import com.rental.admin.service.HouseRenterService;
import com.rental.admin.service.HouseService;
import com.rental.admin.utility.MailConstructor;

@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private HouseAgentSampleService houseAgentSampleService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private ContractUserService contractUserService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private HouseRenterService houseRenterService;
	
	@Autowired
	private HouseOwnerService houseOwnerService;
	
	@Autowired
	private ContractService contractService;
	
	@RequestMapping("/rentHouse")
	private String rentHouse(Model model) { 
		
		House house = new House();
		
		List<House> allHouseList = houseService.findAll();
		List<House> houseList = new ArrayList<House>();
		
		if(allHouseList.equals(null)) {
			
			
			model.addAttribute("dataNotExist", true);
			model.addAttribute("houseList", house);
		}
		else {
			 
			for(House all:allHouseList) {
				
				System.out.println("id "+all.getHouseId());
				
				System.out.println("enable "+all.getHouseRenter().getEnabled());
		
				houseList.add(all);
			}
			
			model.addAttribute("houseList", houseList);
		}
		
		
		
		//house.getHouseTownship().getTownship().getTownshipName();
		//house.getHouseType().getType().getTypeName();
		//house.getHouseAgent().getAgent().getAgentFName();
		
		
		
		return "rentHouse";
	}
	
	@RequestMapping("/rentHouseContract")
	private String rentHouseContract(Model model) { 
		
		House house = new House();
		
		List<House> allHouseList = houseService.findAll();
		List<House> houseList = new ArrayList<House>();
		
		List<HouseRenter> hr = houseRenterService.findAll();
		
		if(allHouseList.equals(null)) {
			
			
			model.addAttribute("dataNotExist", true);
			model.addAttribute("houseList", house);
		}
		else {
			
			for(House all:allHouseList) {
				
				System.out.println("id "+all.getHouseId());
				
				System.out.println("enable "+all.getHouseRenter().getEnabled());
				
				for(int i=0; i<hr.size(); i++) {
					if(all.getHouseRenter().getHouse().getHouseId().equals(hr.get(i).getHouse().getHouseId())) {
						if(hr.get(i).getEnabled()) {
							houseList.add(all);
						}
					}
				}
				
			}
			
			model.addAttribute("houseList", houseList);
		}
		
		
		
		//house.getHouseTownship().getTownship().getTownshipName();
		//house.getHouseType().getType().getTypeName();
		//house.getHouseAgent().getAgent().getAgentFName();
		
		
		
		return "rentHouseContract";
	}
	
	@RequestMapping("/rentHouseDetail")
	private String rentHouseDetail(Model model,@RequestParam("id") Long houseId ) {
		
		House house = houseService.findById(houseId);
		
		List<HouseOwner> houseOwnerList =  houseOwnerService.findByUser(house.getHouseOwner().getUser());
		
		for(HouseOwner ho : houseOwnerList) {
			
			if(ho.getHouse().getHouseId().equals(house.getHouseId())) {
				
				model.addAttribute("house", ho.getHouse());
				
			}
			
		
		}
		List<HouseAgentSample> ha = houseAgentSampleService.findAll();
		for(HouseAgentSample h:ha) {
			if(h.getHouseId().equals(house.getHouseId())) {
				
				Agent agent = agentService.findById(h.getAgentId());
				
				model.addAttribute("agentFName", agent.getAgentFName());
				model.addAttribute("agentLName", agent.getAgentLName());
			}
		}
		
		List<HouseImage> houseImage= houseService.findByHouse(house);
		
		List<String> hI = new ArrayList<String>();
		
		for(HouseImage houseImg: houseImage) {
			hI.add(houseImg.getImageName());
		}
		
		
		
		model.addAttribute("houseImage", hI);
		
		return "rentHouseDetail";
	}
	
	@RequestMapping("/rentHouseContractDetail")
	private String rentHouseContractDetail(Model model,@RequestParam("id") Long houseId ) {
		
		House house = houseService.findById(houseId);
		
		List<ContractUser> contractList = contractUserService.findByHouse(house);
			
		System.out.println("houseID "+house.getHouseId());
			
		for(ContractUser con: contractList) {
					
			System.out.println("contractenable "+con.getEnabled());
				
			if(con.getEnabled()) {
							
							
				System.out.println("houseid "+house.getHouseId());
							
				System.out.println("contractid "+house.getContractUser().getId());
							
				System.out.println("conID "+con.getId());
							
				
				model.addAttribute("contractUser", con);
				
			}
			
			
			
		}
		List<HouseAgentSample> ha = houseAgentSampleService.findAll();
		for(HouseAgentSample h:ha) {
			if(h.getHouseId().equals(house.getHouseId())) {
				
				Agent agent = agentService.findById(h.getAgentId());
				
				model.addAttribute("agentFName", agent.getAgentFName());
				model.addAttribute("agentLName", agent.getAgentLName());
			}
		}
		
		List<HouseImage> houseImage= houseService.findByHouse(house);
		
		List<String> hI = new ArrayList<String>();
		
		for(HouseImage houseImg: houseImage) {
			hI.add(houseImg.getImageName());
		}
		
		
		
		model.addAttribute("houseImage", hI);
		
		return "rentHouseContractDetail";
	}
	
	@PostMapping("/deleteHouse")
	private String deleteHouse(Model model,@RequestParam("id") Long houseId) {
		
		House house = houseService.findById(houseId);
		
		House house1 = new House();
		house1.setHouseId(houseId);
		house1.setEnabled(false);
		
		houseService.saveHouse(house1, house.getHouseOwner());
		
		houseService.delete(house);
		
//		HouseAgentSample hs = houseAgentSampleService.findByHouseId(houseId);
//		
//		houseAgentSampleService.deleteById(hs.getId());
//		
//		House house = houseService.findById(houseId);
//		
//		List<HouseRenter> houseRenterList = houseRenterService.findByUser(house.getContractUser().getUser());
//		
//		for(HouseRenter h: houseRenterList) {
//			
//			if(h.getEnabled()) {
//				
//				HouseRenter hr = new HouseRenter();
//				hr.setHouse(h.getHouse());
//				hr.setUser(h.getUser());
//				hr.setHouseRenterId(h.getHouseRenterId());
//				hr.setEnabled(false);
//				
//				houseService.saveHouseRenter(h);
//			}
//		}
//		
//		List<HouseOwner> houseOwnerList = houseOwnerService.findByUser(house.getHouseOwner().getUser());
//		for(HouseOwner ho: houseOwnerList) {
//			if(ho.getHouse().getHouseId().equals(house.getHouseId())) {
//				
//				if(ho.getEnabled()) {
//					HouseOwner owner = new HouseOwner();
//					owner.setHouse(ho.getHouse());
//					owner.setUser(ho.getUser());
//					owner.setHouseOwnerId(ho.getHouseOwnerId());
//					owner.setEnabled(false);
//					
//					houseService.saveHouse(house, owner);
//				}
//				
//			}
//		}
//		
//		List<ContractUser> cu = contractUserService.findByHouse(house);
//		
//		for(ContractUser u:cu) {
//			if(u.getEnabled()) {
//				
//				ContractUser cc= new ContractUser();
//				cc.setAgent(agentService.findById(hs.getAgentId()));
//				cc.setHouse(house);
//				cc.setUser(house.getContractUser().getUser());
//				cc.setContract(u.getContract());
//				cc.setEnabled(false);
//				
//				contractService.saveContractUser(cc);
//				
//			}
//		}
//		
//		houseService.delete(house);
//		
//		model.addAttribute("deleteSuccess", true);
		
		return "redirect:/rentHouse";
	}
	
	@RequestMapping("/manageBooking")
	private String manageBooking(Model model) {
		
		Booking booking = new Booking();
		
		List<Booking> bookingList = bookingService.findAll();
		List<Booking> bookingL = new ArrayList<Booking>();
		
		for(Booking booking1:bookingList) {
			if(!booking1.getApprove()) {
				bookingL.add(booking1);
			}
		}
		
		model.addAttribute("bookingList", bookingL);
		
		return "manageBooking";
	}
	
	
	@PostMapping("/deleteBooking")
	private String deleteBooking(@RequestParam("bookingId") Long bookingId,Model model) {
		
		bookingService.remove(bookingId);
		
		List<Booking> bookingList = bookingService.findAll();
		
		model.addAttribute("bookingList", bookingList);
		
		return "manageBooking";
	}
	
	@PostMapping("/approveBooking")
	private String approveBooking(HttpServletRequest request,@RequestParam("bookingId") Long bookingId,Model model) {
		
		Booking booking = bookingService.findByBookingId(bookingId);
		
		booking.setApprove(true);
		
		bookingService.saveBooking(booking);
		
		List<Booking> bookingList = bookingService.findAll();
		
		model.addAttribute("bookingList", bookingList);
		
		if(booking.getApprove() == true) {
			model.addAttribute("alreadyApproved", true);
		}
		
		String cusEmail = booking.getEmail();
		
		//String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		SimpleMailMessage sentEmail = mailConstructor.constructApproveEmail(request.getLocale(), cusEmail, "Booking Approvement");
		
		mailSender.send(sentEmail);
		
		return "redirect:/manageBooking";
	}
}
