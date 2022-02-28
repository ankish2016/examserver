package com.exam.server.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.server.Repository.RoleRepository;
import com.exam.server.Repository.UserRepository;
import com.exam.server.model.User;
import com.exam.server.model.UserRole;
import com.exam.server.service.UserService;

@Service
public class UserServiceImpl implements UserService {
     
	 private UserRepository userRepository;
	 private RoleRepository roleRepository;
 	  
	  //creating Service
	 @Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}



	@Override
	public User CreateUser(User user, Set<UserRole> roles) throws Exception {
	User local=this.userRepository.findByUserName(user.getUserName());
	if(local!=null) {
		System.out.println("User is already there !!");
		throw new Exception("user already present");
	}else
	{
		//user Create
		for(UserRole ur:roles) {
			roleRepository.save(ur.getRole());
		}
	user.getUserRole().addAll(roles);
	local = this.userRepository.save(user);
	}
		return local;
	}

}
