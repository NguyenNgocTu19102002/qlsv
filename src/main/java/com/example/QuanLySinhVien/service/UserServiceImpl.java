package com.example.QuanLySinhVien.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.QuanLySinhVien.model.UserDtls;
import com.example.QuanLySinhVien.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public UserDtls createUser(UserDtls user) {

		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");

		return userRepo.save(user);
	}
	@Override
	public List<UserDtls> getAllUser(){
		return userRepo.findAll();
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}
	
	@Override
	public void saveUser(UserDtls user) {
		this.userRepo.save(user);
	}
     @Override
    public UserDtls getUserID(int id) {
    	Optional<UserDtls> optional = userRepo.findById(id);
    	 UserDtls khachhang = null;
    	 if(optional.isPresent()) {
    		 khachhang = optional.get();
    	 }else {
    		 	throw new RuntimeException("Không tìm thấy mã khách:" + id);
    	 }
    	 return khachhang;
    	
    }
    @Override
    public void deleteUserID(String id) {
    	this.userRepo.deleteById(id);
    }

	

}