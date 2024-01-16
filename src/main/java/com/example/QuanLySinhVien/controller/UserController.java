package com.example.QuanLySinhVien.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.QuanLySinhVien.model.UserDtls;
import com.example.QuanLySinhVien.repository.UserRepository;
import com.example.QuanLySinhVien.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
	}
	@GetMapping("/")
	  public String DanhSachUser(Model model) {
		  model.addAttribute("listDSuser",userService.getAllUser()); 
		  return "index";
		  }
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/signin")
	public String signin() {
		return "login";
	}																								
//	@GetMapping("/signin")
//	public String signIn() {
//		return "signin";
//	}
}
