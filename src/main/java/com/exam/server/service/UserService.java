package com.exam.server.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.server.model.User;
import com.exam.server.model.UserRole;

public interface UserService {
 //creating user
	public User CreateUser(User user,Set<UserRole> roles) throws Exception;
}
