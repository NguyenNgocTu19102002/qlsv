package com.example.QuanLySinhVien.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuanLySinhVien.model.SinhVien;
import com.example.QuanLySinhVien.repository.SinhVienRepository;

@Service
public class SinhVienServiceImpl implements SinhVienService {
	@Autowired
	 SinhVienRepository sinhVienRepository;
 
	@Override
	public List<SinhVien> getAllSinhVien() {
		return sinhVienRepository.findAll();
	}

	@Override
	public void saveSinhVien(SinhVien sinhvien) {
		this.sinhVienRepository.save(sinhvien);
	}

	@Override
	public SinhVien getSinhVienID(int id) {
		Optional<SinhVien> optional = sinhVienRepository.findById(id);
   	 SinhVien sinhvien = null;
   	 if(optional.isPresent()) {
   		 sinhvien = optional.get();
   	 }else {
   		 	throw new RuntimeException("Không tìm thấy mã sv:" + id);
   	 }
   	 return sinhvien;
	}

	@Override
	public void deleteSinhVienID(int id) {
		this.sinhVienRepository.deleteById(id);
		
	}

}
	