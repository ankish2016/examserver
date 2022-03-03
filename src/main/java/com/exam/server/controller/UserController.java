package com.exam.server.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.exam.server.helper.UserFoundException;
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
		role.setRoleName("USER");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
	    return this.userService.CreateUser(user, roles);	
	}
	 @GetMapping("/{username}")
      public User getUser(@PathVariable("username")String username)
      {
		return this.userService.getUserByUserName(username);
      }
	 
	 @DeleteMapping("/{userId}")
	 public void dleteUserById(@PathVariable("userId")Long userId)
	 {
		  this.userService.deleteUserById(userId);
	 }
	 
	 @PutMapping("/userupdate")
	 public User updateUser(@RequestBody User user)
	 {
		return this.userService.updateUserById(user);
	 }
	 
	 @ExceptionHandler(UserFoundException.class)
	 public ResponseEntity<?> ExceptionHandler(UserFoundException ex)
	 {
		 
		return ResponseEntity.ok(ex);
		 
	 }
}
