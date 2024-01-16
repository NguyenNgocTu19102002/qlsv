package com.example.QuanLySinhVien.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.QuanLySinhVien.model.SinhVien;


@Service
public interface SinhVienService {
   public List<SinhVien> getAllSinhVien();
   
    void saveSinhVien(SinhVien sinhvien);
	
   SinhVien getSinhVienID(int id);	
   
  void deleteSinhVienID(int id);

}
