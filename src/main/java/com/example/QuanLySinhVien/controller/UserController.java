package com.example.QuanLySinhVien.controller;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.QuanLySinhVien.model.UserDtls;
import com.example.QuanLySinhVien.repository.UserRepository;
import com.example.QuanLySinhVien.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session) {

		// System.out.println(user);

		boolean f = userService.checkEmail(user.getEmail());	

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
		}

		else {
			UserDtls userDtls = userService.createUser(user);
			if (userDtls != null) {
				session.setAttribute("msg", "Register Sucessfully");
			} else {
				session.setAttribute("msg", "Something wrong on server");
			}
		}

		return "redirect:/admin/register";
	}
	
//	@ModelAttribute
//	private void userDetails(Model m, Principal p) {
//		String email = p.getName();
//		UserDtls user = userRepo.findByEmail(email);
//		m.addAttribute("user", user);
//	}
	@GetMapping("/dsUser")
	  public String DanhSachUser(Model model) {
		  model.addAttribute("listDSuser",userService.getAllUser()); 
		  return "dsUser";
		  }
}
