package com.example.QuanLySinhVien.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="masv")
	private String maSV;
	@Column(name="hoten")
	private String hoTen;
	@Column(name="namsinh")
	private Date namSinh;
	@Column(name="dantoc")
	private String danToc;
	@Column(name="malop")
	private String maLop;
	public SinhVien() {
		
	}
	public SinhVien(String maSV, String hoTen, Date namSinh, String danToc, String maLop) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.danToc = danToc;
		this.maLop = maLop;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}
	public String getDanToc() {
		return danToc;
	}
	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", maSV=" + maSV + ", hoTen=" + hoTen + ", namSinh=" + namSinh + ", danToc="
				+ danToc + ", maLop=" + maLop + "]";
	}
	
	
	
	
	

}
