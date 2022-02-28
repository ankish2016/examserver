package com.exam.server;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.server.model.Role;
import com.exam.server.model.User;
import com.exam.server.model.UserRole;
import com.exam.server.service.UserService;
import com.exam.server.serviceImpl.UserServiceImpl;

@SpringBootApplication 
public class ExamServerApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}
	@Autowired 
    private UserService userService;
	@Override
	public void run(String... args) throws Exception {
//		
//		User user=new User();
//		user.setUserName("ankish");
//		user.setFirstName("ankish");
//		user.setLastname("raj");
//		user.setEmail("ankishraj@gmail.com");
//		user.setPassword("abc");
//		user.setPhone("123456");
//		user.setProfile("default.png");
//		Role role=new Role();
//		role.setRoleId(1l);
//		role.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//	User createUser = this.userService.CreateUser(user, userRoleSet);
//	System.out.println("user is created"+createUser);
	}
}
