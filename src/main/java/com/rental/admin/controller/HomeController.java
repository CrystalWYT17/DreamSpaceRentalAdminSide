package com.rental.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rental.admin.domain.Agent;
import com.rental.admin.domain.Booking;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseRenter;
import com.rental.admin.domain.User;
import com.rental.admin.service.AgentService;
import com.rental.admin.service.BookingService;
import com.rental.admin.service.HouseRenterService;
import com.rental.admin.service.HouseService;
import com.rental.admin.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private HouseRenterService houseRenterService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private BookingService bookingService;

	@RequestMapping("/")
	public String index(Model model) {
		 
		List<User> userList = userService.findAll();
		int userCount=0;
		
		for(int i=0; i<userList.size(); i++) {
			userCount++;
		}
		
		System.out.println(userCount);
		
		List<Agent> agentList = agentService.findAll();
		int agentCount=0;
		
		for(int i=0; i<agentList.size(); i++) {
			agentCount++;
		}
		
		List<House> houseList = houseService.findAll();
		int houseCount=0;
		int inactiveHouseCount=0;
		
		for(int i=0; i<houseList.size(); i++) {
			
			if(houseList.get(i).getEnabled()) {
				houseCount++;
			}else {
				inactiveHouseCount++;
			}
			
		}
		
		List<HouseRenter> houseRenterList = houseRenterService.findAll();
		int houseRenterCount=0;
		
		for(int i=0; i<houseRenterList.size(); i++) {
			
			if(houseRenterList.get(i).getEnabled()) {
				houseRenterCount++;
			}
			
			
		}
		
		List<Booking> bookingList = bookingService.findAll();
		int bookingCount =0;
		int bookingApproveCount =0;
		
		for(int i=0; i<bookingList.size(); i++) {
			
			if(bookingList.get(i).getApprove()) {
				bookingCount++;
			}else {
				bookingApproveCount++;
			}
			
			
		}
		
		System.out.println("inactive "+inactiveHouseCount);
		System.out.println("rent "+houseRenterCount);
		
		model.addAttribute("bookingApproveCount", bookingApproveCount);
		model.addAttribute("bookingCount", bookingCount);
		model.addAttribute("userCount", userCount);
		model.addAttribute("agentCount", agentCount);
		model.addAttribute("houseCount", houseCount);
		model.addAttribute("houseRenterCount", houseRenterCount);
		model.addAttribute("inactiveHouseCount", inactiveHouseCount);
		
		return "home";
	}
	
	@RequestMapping("/home")
	public String home(Model model) { 
		
		List<User> userList = userService.findAll();
		int userCount=0;
		
		for(int i=0; i<userList.size(); i++) {
			userCount++;
		}
		
		System.out.println(userCount);
		
		List<Agent> agentList = agentService.findAll();
		int agentCount=0;
		
		for(int i=0; i<agentList.size(); i++) {
			agentCount++;
		}
		
		List<House> houseList = houseService.findAll();
		int houseCount=0;
		int inactiveHouseCount=0;
		
		for(int i=0; i<houseList.size(); i++) {
			
			if(houseList.get(i).getEnabled()) {
				houseCount++;
			}else {
				inactiveHouseCount++;
			}
			
		}
		
		List<HouseRenter> houseRenterList = houseRenterService.findAll();
		int houseRenterCount=0;
		
		for(int i=0; i<houseRenterList.size(); i++) {
			
			if(houseRenterList.get(i).getEnabled()) {
				houseRenterCount++;
			}
			
			
		}
		
		List<Booking> bookingList = bookingService.findAll();
		int bookingCount =0;
		int bookingApproveCount =0;
		
		for(int i=0; i<bookingList.size(); i++) {
			
			if(bookingList.get(i).getApprove()) {
				bookingCount++;
			}else {
				bookingApproveCount++;
			}
			
			
		}
		
		System.out.println("inactive "+inactiveHouseCount);
		System.out.println("rent "+houseRenterCount);
		
		model.addAttribute("bookingApproveCount", bookingApproveCount);
		model.addAttribute("bookingCount", bookingCount);
		model.addAttribute("userCount", userCount);
		model.addAttribute("agentCount", agentCount);
		model.addAttribute("houseCount", houseCount);
		model.addAttribute("houseRenterCount", houseRenterCount);
		model.addAttribute("inactiveHouseCount", inactiveHouseCount);
		
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login"; 
	}
	
	
	
}
