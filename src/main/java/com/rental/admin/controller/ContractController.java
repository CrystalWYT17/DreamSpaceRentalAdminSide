package com.rental.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rental.admin.domain.Agent;
import com.rental.admin.domain.Contract;
import com.rental.admin.domain.ContractUser;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseAgentSample;
import com.rental.admin.domain.HouseOwner;
import com.rental.admin.domain.HouseRenter;
import com.rental.admin.domain.User;
import com.rental.admin.service.AgentService;
import com.rental.admin.service.ContractService;
import com.rental.admin.service.ContractUserService;
import com.rental.admin.service.HouseAgentSampleService;
import com.rental.admin.service.HouseOwnerService;
import com.rental.admin.service.HouseRenterService;
import com.rental.admin.service.HouseService;
import com.rental.admin.service.UserService;

@Controller
public class ContractController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private HouseService houseService; 
	
	@Autowired
	private HouseOwnerService houseOwnerService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private ContractUserService contractUserService;
	
	@Autowired
	private HouseRenterService houseRenterService;
	
	@Autowired
	private HouseAgentSampleService houseAgentSampleService;
	
	@RequestMapping("/contract")
	private String contract(Model model) {
		
		List<Contract> contractList = contractService.findAll();
		
		List<ContractUser> cL = new ArrayList<ContractUser>();
		
		for(int i=0; i<contractList.size(); i++) {
			
			Contract contract = contractService.findByContractId(contractList.get(i).getContractId());
			
			System.out.println("id "+contract.getContractId());
			
			if(contract != null) {
				
				Optional<ContractUser> cu = contractUserService.findById(contract.getContractUser().getId());
				
				if(cu.get().getEnabled()) {
					cL.add(contract.getContractUser());
				}
			}
			
		}
		if(contractList.size()==0) {
			model.addAttribute("dataNotExist", true);
		}else {
			
			model.addAttribute("contractUserList", cL);
		}
		
		return "contract";
	}
	
	@RequestMapping("/addNew")
	private String addNew(Model model) {
		
		User user = new User();
		House house = new House();
		//Agent agent = new Agent();
		
		List<String> agentNameList = new ArrayList<String>();
		List<Agent> agentList = agentService.findAll();
		
		for(Agent agent : agentList) {
			agentNameList.add(agent.getAgentFName()+" "+agent.getAgentLName());
		}
		
		String ownerName = "";
		
		List<House> houseList = houseService.findAll();
		List<String> houseAddress = new ArrayList<String>();
		
		for(House h: houseList) {
			
			if(h.getEnabled()) {
				houseAddress.add(h.getAddress());
			}
			
		}
		
		Contract contract = new Contract();
		String agentName = "";
		
		model.addAttribute("user", user);
		model.addAttribute("agentNameList", agentNameList);
		model.addAttribute("agentName", agentName);
		model.addAttribute("ownerName", ownerName);
		model.addAttribute("houseAddress", houseAddress);
		model.addAttribute("house", house);
		model.addAttribute("contract", contract);
		
		return "addNew";
	}

	
	
	@PostMapping("/addNew")
	private String postAddNew(@ModelAttribute("user") User user,@ModelAttribute("agentName") String agentName,
			@ModelAttribute("ownerName") String ownerName,@ModelAttribute("house") House house,
			@ModelAttribute("contract") Contract contract,Model model) throws IOException {
		
		User user1 = userService.findByFirstName(user.getFirstName());
		
		System.out.println("firstname"+user1.getFirstName());
		
		if(user1 != null) {
			
			if(!user1.getLastName().equals(user.getLastName())) {
				
				model.addAttribute("userNotExist", true);
				
				return "addNew";
			}
			
		}
		
		model.addAttribute("userExists", true);
		
		System.out.println("agenName "+agentName);
		
		
		int index = agentName.indexOf(" ");
		
		System.out.println("after substring "+agentName.substring(0,index));
		
		String agentFName = agentName.substring(0, index);
		
		Agent agent = agentService.findByAgentFName(agentFName);
		
		System.out.println("agentid "+agent.getId());
		
		index = ownerName.indexOf(" ");
		String ownerFName = ownerName.substring(0, index);
		String ownerLName = ownerName.substring(index+1);
		User owner1 = new User();
		
		System.out.println("ownerFname:"+ownerFName);
		System.out.println("ownerLname:"+ownerLName);
		try {
			
			owner1 = userService.findByFirstName(ownerFName);
			
			System.out.println("firstname"+owner1.getFirstName());
			if(owner1.equals(null)) { 
				
				if(!owner1.getLastName().equals(ownerLName)) {
					
					model.addAttribute("ownerNotExist", true);
					
					return "addNew";
				}
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			List<String> agentNameList = new ArrayList<String>();
			List<Agent> agentList = agentService.findAll();
			
			for(Agent agent1 : agentList) {
				agentNameList.add(agent1.getAgentFName()+" "+agent1.getAgentLName());
			}
			
			List<House> houseList = houseService.findAll();
			List<String> houseAddress = new ArrayList<String>();
			
			for(House h: houseList) {
				
				if(h.getEnabled()) {
					houseAddress.add(h.getAddress());
				}
				
			}
			String agentName1 = "";

			model.addAttribute("agentNameList", agentNameList);
			model.addAttribute("agentName", agentName1);
			model.addAttribute("houseAddress", houseAddress);
			model.addAttribute("ownerNotExist", true);
			
			return "addNew";
		}
		/////////////////////////////////////////////////////////
		System.out.println("owner:"+owner1);
		if(owner1.getFirstName().equals(user1.getFirstName())) {
			if(owner1.getLastName().equals(user1.getLastName())) {
				model.addAttribute("sameUser", true);
				return "addNew";
			}
		}
		
		model.addAttribute("ownerExists", true);
		
		List<HouseOwner> houseOwnerList = houseOwnerService.findByUser(owner1);
		
		List<String> checkedHouse = new ArrayList<String>();
		
		House checkHouse = houseService.findByAddress(house.getAddress());
		
		List<HouseAgentSample> houseAgentSample = houseAgentSampleService.findAll();
		
		List<String> agentNameList = new ArrayList<String>();
		
		Boolean flag1= false;
		
		for(int i=0; i<houseOwnerList.size(); i++) {
			
			if(houseOwnerList.get(i).getEnabled()) {
				checkedHouse.add(houseOwnerList.get(i).getHouse().getAddress());
			}
			
			
			
		}
		
		for(int i=0; i<houseAgentSample.size(); i++) {
			
			if(checkHouse.getHouseId().equals(houseAgentSample.get(i).getHouseId())) {
				
				if(agent.getId().equals(houseAgentSample.get(i).getAgentId())) {
					break;
				}else {
					Agent a = agentService.findById(houseAgentSample.get(i).getAgentId());
					
					agentNameList.add(a.getAgentFName()+" "+a.getAgentLName());
					flag1=true;
				}
				
			}
		}
		
		if(flag1) {
			
			model.addAttribute("agentNameList", agentNameList);
			
			House h1 = new House();
			
			model.addAttribute("house", h1);
			model.addAttribute("houseAddress", checkedHouse);
			model.addAttribute("house", house);
			
			model.addAttribute("chooseAAgain", true);
			
			return "addNew";
		}
		
		System.out.println("Contract place");
		System.out.println("checkhouse price "+checkHouse.getPrice());
		
		String duration = contract.getDuration();
		String paidBy = contract.getPaidBy();
		Double rentAmount = checkHouse.getPrice();//contract.getRentAmount();
		String signDate= contract.getSignDate();
		String terms = contract.getTerms();
		String validUntil = contract.getValidUntil();
		MultipartFile image = contract.getContractImage();
		
		if(duration.equals(null) || paidBy.equals(null)|| rentAmount.equals(null)|| signDate.equals(null)|| terms.equals(null)
				|| validUntil.equals(null)){
			model.addAttribute("contractNotComplete", true);
			
			return "addNew";
		}
	
//		Contract newContract = new Contract();
//		newContract.setDuration(duration);
//		newContract.setPaidBy(paidBy);
//		newContract.setRentAmount(rentAmount);
//		newContract.setSignDate(signDate);
//		newContract.setTerms(terms);
//		newContract.setValidUntil(validUntil);
		
		contract.setRentAmount(rentAmount);
		
		Contract savedContract = contractService.save(contract);
		
		System.out.println("contractid "+savedContract.getContractId());
		
		Long contractId = savedContract.getContractId();
		
		ContractUser cu = new ContractUser();
		cu.setContract(savedContract);
		cu.setAgent(agent);
		cu.setHouse(checkHouse);
		cu.setUser(user1);
		cu.setEnabled(true);
		
		contractService.saveContractUser(cu);
		
		
		
		byte[] bytes = image.getBytes();
		String name = contractId+".jpg";
		
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File("src/main/resources/static/images/contract/"+name))
				);
		stream.write(bytes);
		stream.close();
		
		////////////////////////////////houserenter///////////////////
		
		List<HouseRenter> hr = houseRenterService.findByUser(user1);
		
		for(HouseRenter h: hr) {
			
			if(h.getHouse().getHouseId().equals(checkHouse.getHouseId())) {
				
				houseRenterService.deleteById(h.getHouseRenterId());
				
			}
			
		}
		
		HouseRenter hr1 = new HouseRenter();
		hr1.setHouse(checkHouse);
		hr1.setUser(user1);
		hr1.setEnabled(true);
		
		houseRenterService.save(hr1);
		
		model.addAttribute("success", true);
		
		return "redirect:/contract"; 
		
		
	}
	
	@RequestMapping("/contractDetail")
	private String contractDetail(@RequestParam("id") Integer contractId,Model model) {
		System.out.println("id "+contractId);
		
		Optional<ContractUser> contractUser1 = contractUserService.findById(contractId);
		
		
		//List<ContractUser> contractUserList = contractUserService.findAll();
		
		ContractUser contractUser = new ContractUser();
			
		contractUser.setAgent(contractUser1.get().getAgent());
		contractUser.setContract(contractUser1.get().getContract());
		contractUser.setHouse(contractUser1.get().getHouse());
		contractUser.setUser(contractUser1.get().getUser());
		contractUser.setId(contractUser1.get().getId());
			
		
		model.addAttribute("contractUser", contractUser);
		
		return "contractDetail";
	}
	
	@PostMapping(value = "/deleteContract")
	private String deleteContractAccept(Model model,@RequestParam("id") Integer contractUserId) {
		
		Optional<ContractUser> cu = contractUserService.findById(contractUserId);
		
		Long contractId = cu.get().getContract().getContractId();
		
		ContractUser cu1 = new ContractUser();
		cu1.setAgent(cu.get().getAgent());
		cu1.setContract(cu.get().getContract());
		cu1.setHouse(cu.get().getHouse());
		cu1.setUser(cu.get().getUser());
		cu1.setId(cu.get().getId());
		cu1.setEnabled(false);
		
		contractService.deleteById(contractId, cu1); 
		
		List<HouseRenter> hr = houseRenterService.findByUser(cu.get().getUser());
		
		for(HouseRenter h: hr) {
			
			if(h.getHouse().getHouseId().equals(cu.get().getHouse().getHouseId())) {
				
				if(h.getEnabled()) {
					
					HouseRenter houseRenter = new HouseRenter();
					houseRenter.setUser(h.getUser());
					houseRenter.setHouse(h.getHouse());
					
					houseService.deleteHouseRenter(h);
					
					houseRenter.setEnabled(false);
					
					houseService.saveHouseRenter(houseRenter);
				}
				
				
			}
			
			
		}
		
		model.addAttribute("deleteSuccess", true);
		
		return "redirect:/contract";
		
	}
	
}
