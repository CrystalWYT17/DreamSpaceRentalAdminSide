package com.rental.admin.controller;

/**
 * @author Lin Lae Win Wah
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.rental.admin.domain.Agent;
import com.rental.admin.domain.Township;
import com.rental.admin.service.AgentService;
import com.rental.admin.service.TownshipService;

@Controller
//@RequestMapping("/agent")
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private TownshipService townshipService;
	
	@GetMapping("/add")
	public String addAgent(Model model) {
		Agent agent = new Agent();
		model.addAttribute("agent",agent);
		
		List<Township> township = townshipService.findAll();
		List<String> tList = new ArrayList<String>();
		
		for(Township t: township) {
			tList.add(t.getTownshipName());
		}
		
		Township township1 = new Township();
		
		model.addAttribute("township", township1);
		model.addAttribute("townshipName", tList);
		
		return "agentform";
	}
	
	@PostMapping("/add")
	public String addAgentPost(@ModelAttribute("agent")Agent agent,@ModelAttribute("township") Township township) throws IOException {
		
		agent.setAgentTownship(township.getTownshipName());
		
		agentService.save(agent);
		
		System.out.print(agent.getAgentAddress());
		MultipartFile agentImg = agent.getAgentImage();    //multipartfile type
		byte[] bytes = agentImg.getBytes();			//image change to bytes
		
		String name = agent.getId()+".png";
		
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/images/agent/"+name)));  //save mt location
		
		stream.write(bytes);
		stream.close();
		
		return "redirect:/agentList";
	}
	
	@RequestMapping("/agentList")
	public String agentList(Model model) {
		List<Agent> agentList = agentService.findAll();
		model.addAttribute("agentList",agentList);
		
		return "agentlist";
	}
	
	@RequestMapping("/agentUpdate")
	public String updateAgent(@RequestParam("id") Long id,Model model) {
		Agent agent = agentService.findById(id);
		model.addAttribute("agent",agent);
		
		Township township = new Township();
		List<String> townshipName = new ArrayList<String>();
		
		List<Township> townshipList = townshipService.findAll();
		
		for(Township t:townshipList) {
			townshipName.add(t.getTownshipName());
		}
		model.addAttribute("township", township);
		model.addAttribute("townshipName", townshipName);
		
		return "agentupdate";
	}
	
	@PostMapping("/agentUpdate")
	public String agentUpdate(@ModelAttribute("agent")Agent agent,@ModelAttribute("township") Township township) throws IOException {
		
		agent.setAgentTownship(township.getTownshipName());
		
		agentService.save(agent);
		MultipartFile agentImage = agent.getAgentImage();
		if(!agentImage.isEmpty()) {
			byte[] bytes = agentImage.getBytes();
			String name = agent.getId()+".png";
			Files.delete(Paths.get("src/main/resources/static/images/agent/"+name));   //uri pay data lann kyung a tine twar sharr
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/images/agent/"+name)));
			stream.write(bytes);
			stream.close();
		}
		
		
		
		return "redirect:/agentList";
	}
	
	@PostMapping("/remove")
	public String remove(@ModelAttribute("id") String id, Model model) throws IOException {
		
		Long agentId = Long.parseLong(id.substring(9));
		String name = agentId+".png";
		agentService.removeOne(agentId);
		
		Files.delete(Paths.get("src/main/resources/static/images/agent/"+name));
		
		List<Agent> agentList = agentService.findAll();
		model.addAttribute("agentList",agentList);
		return "redirect:/agentList";
		
	}
	
	@RequestMapping("/agentDetails")
	public String AgentInfo(@RequestParam("id")Long id,Model model) {
		
		Agent agent = agentService.findById(id);
		model.addAttribute("agent",agent);
		return "agentDetails";
	}
	
	
}
