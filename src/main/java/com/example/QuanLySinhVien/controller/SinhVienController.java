package com.example.QuanLySinhVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.QuanLySinhVien.model.SinhVien;
import com.example.QuanLySinhVien.service.SinhVienService;

@Controller
@RequestMapping("/Admin")
public class SinhVienController {
	@Autowired
	SinhVienService sinhVienService;

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/dsSinhVien")
	public String DanhSachSinhVien(Model model) {
		model.addAttribute("listDSsinhvien", sinhVienService.getAllSinhVien());

		return "home";
	}

	@GetMapping("/themmoiSinhVien")
	public String ThemMoiSinhVien(Model model) {
		SinhVien sinhvien = new SinhVien();
		model.addAttribute("sinhvien", sinhvien);
		return "addSinhVien";

	}

	@PostMapping("/saveSinhVien")
	public String saveSinhVien(@ModelAttribute("sinhvien") SinhVien sinhvien) {
		sinhVienService.saveSinhVien(sinhvien);
		return "redirect:/Admin/dsSinhVien";

	}

	@GetMapping("/upDateSinhVien/{id}")
	public String upDateKhachHang(@PathVariable(value = "id") int id, Model model) {
		SinhVien sinhvien = sinhVienService.getSinhVienID(id);
		model.addAttribute("sinhvien", sinhvien);
		return "updateSinhVien";
	}

	@GetMapping("/xoaSinhVien/{id}")
	public String deleteSinhVien(@PathVariable(value = "id") int id) {
		this.sinhVienService.deleteSinhVienID(id);
		return "redirect:/Admin/dsSinhVien";
	}
}
