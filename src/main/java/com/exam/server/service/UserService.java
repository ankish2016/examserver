package com.exam.server.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.server.model.User;
import com.exam.server.model.UserRole;

public interface UserService {
    //creating user
	public User CreateUser(User user,Set<UserRole> roles) throws Exception;
	//get user by username
	public User getUserByUserName(String UserName);
    
	//delete user by userbyid
	public void deleteUserById(Long userId);
	
	//update user by UserById;
	public User updateUserById(User user);
}
