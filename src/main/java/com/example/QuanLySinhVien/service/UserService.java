package com.example.QuanLySinhVien.service;

import java.util.List;

import com.example.QuanLySinhVien.model.UserDtls;

public interface UserService {

	public UserDtls createUser(UserDtls user);

	public boolean checkEmail(String email);
	
	public List<UserDtls> getAllUser();
	
	void saveUser(UserDtls user);
	
    public UserDtls getUserID(int id);	
    
   void deleteUserID(String id);
}
