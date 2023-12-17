package com.rental.admin.controller;


import java.io.IOException;

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


import com.rental.admin.domain.Type;
import com.rental.admin.domain.User;
import com.rental.admin.service.HouseOwnerService;
import com.rental.admin.service.HouseRenterService;
import com.rental.admin.service.TypeService;
import com.rental.admin.service.UserService;


/**
 * @author Khin Pyae Pyae Phyo
 */

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HouseRenterService houseRenterService;
	
	@Autowired
	private HouseOwnerService houseOwnerService;
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping("/basicTable")
	public String userList(Model model) {
		List<User> userList =userService.findAll();
		
		
		
		for(User user: userList) {
			user.setRent(houseRenterService.addRentCountToUser(user));
			user.setOwned(houseOwnerService.addOwnedCountToUser(user));
			
			Integer rent =  user.getRent();
			Integer owned = user.getOwned();
			 System.out.println(rent);
			 System.out.println(owned);
		}
		
		model.addAttribute("userList",userList);
		
		return "usertable";
	}
	
	@RequestMapping("/typeTable")
	public String typeList(Model model){
	
		List<Type> typeList = typeService.findAll();
		model.addAttribute("typeList" , typeList);
		
		return "typeTable";
		
	}
	
	
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam("id") Long userId, Model model) {

  

    User user = userService.findById(userId);
		
		model.addAttribute("user", user);
		
		return "updateUser";

}
	
	@PostMapping("/updateUser")
	public String updateUserPost(@ModelAttribute("user") User user) throws IOException {
		
		userService.saveUser(user); //user merge with hidden field id
		
		
		return "redirect:/basicTable";
		
	}
	
	
	@RequestMapping(value ="/removeUser", method = RequestMethod.GET)
	public String remove(@ModelAttribute("id") Long userId, Model model) throws IOException {
		
		
		
		userService.removeOne(userId);
		
		
		
		List<User> userList = userService.findAll();
		
		model.addAttribute("userList",userList);
	
		 return "redirect:/basicTable";
	
	}
	
	@GetMapping("/addType")
	public String addType(Model model) {
		
		
		Type type = new Type();
		
		model.addAttribute("type", type);
		return "typeform";
		
	}
	@PostMapping("/addType")
	public String addType(@ModelAttribute("type") Type type) throws IOException {
		
		
		
		typeService.saveType(type);
		
		return "redirect:/typeTable";
	
	}
	
	@RequestMapping("/updateType")
	public String updateType(@RequestParam("id") Long typeId, Model model) {

  

    Type type = typeService.findById(typeId);
		
		model.addAttribute("type",type);
		
		return "updateType";

}
	
	
	@PostMapping("/updateType")
	public String updateTypePost(@ModelAttribute("type") Type type) throws IOException {//update edited data and show user info with id
		
		typeService.saveType(type); //user merge with hidden field id
		
		
		return "redirect:/typeTable";
		
	}
	
	//@PostMapping("/removeType")


	@RequestMapping(value ="/removeType", method = RequestMethod.GET)
	public String removeType(@ModelAttribute("id") Long typeId, Model model) throws IOException {
		
		
		
		typeService.removeOne(typeId);
		
		
		
		List<Type> typeList = typeService.findAll();
		
		model.addAttribute("typeList",typeList);
	
		return "redirect:/typeTable";
	}
	
}