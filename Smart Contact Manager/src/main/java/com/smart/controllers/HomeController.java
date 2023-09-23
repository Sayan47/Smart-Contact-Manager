package com.smart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String home(ModelMap map) {
		map.addAttribute("title", "Smart Contact Manager");
		return "home";
	}

	@GetMapping("/signup")
	public String signup(ModelMap map) {
		map.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/do_register")
	public String register(@ModelAttribute("user") User user, ModelMap map) {
		
		user.setRole("USER_ROLE");
		user.setEnabled(true);
		user.setImageURL("default.png");
		System.out.println(user);
		userRepository.save(user);
		map.addAttribute("user", new User());
		return "signup";
	}

}
