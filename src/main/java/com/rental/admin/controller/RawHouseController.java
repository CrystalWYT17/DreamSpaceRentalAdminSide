package com.rental.admin.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.admin.domain.Agent;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseAgent;
import com.rental.admin.domain.HouseAgentSample;
import com.rental.admin.domain.HouseOwner;
import com.rental.admin.domain.HouseTownship;
import com.rental.admin.domain.Township;
import com.rental.admin.service.AgentService;
import com.rental.admin.service.HouseAgentSampleService;
import com.rental.admin.service.HouseAgentService;
import com.rental.admin.service.HouseService;
import com.rental.admin.service.HouseTownshipService;

@Controller
//@RequestMapping("/rawHouse")
public class RawHouseController {
	
	@Autowired
	private HouseAgentSampleService houseAgentSampleService;
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private HouseTownshipService houseTownshipService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private HouseAgentService houseAgentService;
	
	@RequestMapping("/listOfRawHouse")
	public String rawHouseList(Model model) {
		List<House> rawHouseList = houseService.findAll();
		
		if(rawHouseList.equals(null)) {
			model.addAttribute("dataNotExist", true);
		}
		
		model.addAttribute("rawHouseList",rawHouseList);
		
		return "rawHouseList";
	}
	
	//Form
	@RequestMapping("/rawHouseConnect")
	public String updateRaw(@RequestParam("id")Long id, Model model) {
		House house = houseService.findById(id);
		Agent agent = new Agent();
		//Township township = houseTownshipService.findHouseByTownship(house).getTownship();
		HouseTownship houseTownship=houseTownshipService.findHouseByTownship(house);
		String township = houseTownship.getTownship().getTownshipName();
		
		System.out.println(township);
		System.out.println(house.getAddress());
		List<Agent> agentList=agentService.findAll();
		System.out.println(agentList);
		if(house.getAddress().equals("Yangon")) {
			model.addAttribute("boo",true);
		}
		model.addAttribute("township",township);
		model.addAttribute("agent",agent);
		model.addAttribute("agentList",agentList);
		model.addAttribute("house",house);
		return "rawHouse";
	}
	
	@PostMapping("/rawHouseConnect")
	public String rawHouseConnect(@ModelAttribute("house") House house,
			@ModelAttribute("agent") Agent agent
			
			) {
		
		House house1 = houseService.findById(house.getHouseId());
		house1.setEnabled(true);
		
		Integer owned = house1.getHouseOwner().getUser().getOwned();
		
		HouseOwner ho= house1.getHouseOwner();
		ho.setEnabled(true);
		
		houseService.saveHouse(house1,ho);
		System.out.println(house.getAddress());
		System.out.println(agent.getAgentEmail());
		
		List<HouseAgent> haList = houseAgentService.findAll();
		
		//List<HouseAgent> houseAgent1 = houseAgentService.findByHouse(house1);
		
		Agent agent1 = agentService.findByAgentFName(agent.getAgentFName());
		
		List<HouseAgentSample> hs = houseAgentSampleService.findAll();
		
		for(HouseAgentSample h: hs) {
			
			if(h.getHouseId().equals(house1.getHouseId())) {
				
				if(!h.getAgentId().equals(agent1.getId())) {
					
					System.out.println("agentid in houseagentsample "+h.getAgentId());
					System.out.println("houseSampleid "+h.getId());
					
					houseAgentSampleService.deleteById(h.getId());
					
					HouseAgentSample h1 = new HouseAgentSample();
					h1.setHouseId(house1.getHouseId());
					h1.setAgentId(agent1.getId());
					houseAgentSampleService.save(h1);
				}
				
			}
			
		}
		
		
		
//		List<HouseAgent> list= new ArrayList<HouseAgent>();
//		
//		HouseAgent houseAgent = new HouseAgent();
//		houseAgent.setAgent(agent1);
//		houseAgent.setHouse(house1);
//		
//		list.add(houseAgent);
//		
//		
//		
//		for(HouseAgent h: haList) {
//			
//			if(h.getHouse().getHouseId().equals(house1.getHouseId())) {
//				
//				if(h.getAgent().getAgentFName().equals(agent1.getAgentFName())){
//					
//					list.add(h);
//					continue;
//				}
//				
//			}
//			else {
//				list.add(h);
//			}
//			
//			
//		}
//		
//		houseAgentService.deleteAll();
		
//		for(int i=0; i<list.size(); i++) {
//			House h1 = houseService.findById(list.get(i).getHouse().getHouseId());
//			Agent a1 = agentService.findById(list.get(i).getAgent().getId());
//			
//			houseAgentService.save(h1, a1);
//		}
//		for(HouseAgent h:haList) {
//			
//			System.out.println(h.getHouse().getHouseId());
//			
//			if(h.getHouse().getHouseId().equals(house1.getHouseId())) {
//				
//				if(!h.getAgent().getId().equals(agent1.getId())) {
//					
//					System.out.println("houseAgentId "+h.getId());
//					houseService.deleteHouseAgent(house1.getHouseAgent().getId());
//					
//					//houseAgentService.deleteById(h.getId());
//					HouseAgent houseAgent = new HouseAgent();
//					houseAgent.setHouse(house1);
//					houseAgent.setAgent(agent1);
//					
//					houseService.saveHouseAgent(house1, houseAgent);
//				}
//				
//				
//			}
//			
//		}
		
		//HouseAgent houseAgent = new HouseAgent();
		
		//houseAgentService.save(house.getHouseId(), agent.getId());
		//HouseAgent houseAgent = houseAgentService.save(house, agent);
		//house.setHouseAgent(houseAgent);
		return "redirect:/listOfRawHouse";
	}
	
	
}
