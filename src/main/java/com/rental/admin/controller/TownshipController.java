package com.rental.admin.controller;

/**
 * @author ThetHninSu
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.admin.domain.Township;
import com.rental.admin.service.TownshipService;

@Controller
//@RequestMapping("/township")
public class TownshipController { 

	@Autowired
	private TownshipService townshipService;
	
	@RequestMapping("/townshipTable")
	public String townshipTable(Model model) {
		
		List<Township> townshipList = townshipService.findAll();
		model.addAttribute("townshipList", townshipList);
		
		return "townshipTable"; 
	}
	 
	@GetMapping("/addTownship")
	public String addTownship(Model model) {
		
		Township township = new Township();
		model.addAttribute("township", township);
		return "addTownship"; 
	}
	
	@PostMapping("/addTownship")
	public String addTownshipPost(@ModelAttribute("township") Township township) {
		
		Township township1 = new Township();
		township1.setTownshipName(township.getTownshipName());
		townshipService.save(township1);
		
		return "redirect:/townshipTable";
	}
	
	@RequestMapping("/updateTownship")
	public String updateTownship(@RequestParam("townshipId") Integer townshipId, Model model) {
		
		Township township = townshipService.findById(townshipId);
		model.addAttribute("township", township);
		return "updateTownship";
	}
	
	@PostMapping("/updateTownship")
	public String updateTownshipPost(@ModelAttribute("townshipId") Integer townshipId,@ModelAttribute("townshipName") String townshipName) {
		
		Township township = townshipService.findById(townshipId);
		
		township.setTownshipName(townshipName);
		
		townshipService.update(township);
		
		return "redirect:/townshipTable";
	}
	@RequestMapping(value ="/deleteTownship", method = RequestMethod.GET)
	public String deleteTownship(@ModelAttribute("townshipId") Integer townshipId,Model model) {
		
		townshipService.removeOne(townshipId);
		
		List<Township> townshipList = townshipService.findAll();
		
		model.addAttribute("townshipList", townshipList);
		
		return "redirect:/townshipTable";
	}

}
