package com.exam.server.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.server.model.Role;
import com.exam.server.model.User;
import com.exam.server.model.UserRole;
import com.exam.server.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
     @Autowired
	 private UserService userService;
	//creating user
	@PostMapping("/signup")
	public User CreateUser(@RequestBody User user) throws Exception{
	Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
	    return this.userService.CreateUser(user, roles);	
	}
}
