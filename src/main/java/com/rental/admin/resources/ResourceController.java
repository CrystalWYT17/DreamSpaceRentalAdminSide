package com.rental.admin.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rental.admin.service.AgentService;

@RestController
public class ResourceController {
	
	@Autowired
	private AgentService agentService;
	
	@PostMapping("removeList")
	public String removeList(@RequestBody ArrayList<String> agentIdList,Model model) throws IOException {
		
		System.out.println("Lin");
		System.out.println(agentIdList);
		for(String id : agentIdList) {
			Long agentId = Long.parseLong(id.substring(8));
			String name = agentId+".png";
			agentService.removeOne(agentId);
			Files.delete(Paths.get("src/main/resources/static/images/agent/"+name));
			
			
		}
		return "delete success";
	}
}
