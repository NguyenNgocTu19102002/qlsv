package com.example.QuanLySinhVien.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QuanLySinhVien.model.SinhVien;
@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer>{

   
}	