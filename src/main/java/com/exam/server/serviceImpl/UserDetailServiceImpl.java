package com.exam.server.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.exam.server.Repository.UserRepository;
import com.exam.server.helper.UserFoundException;
import com.exam.server.model.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
     @Autowired
	 private UserRepository userRepository; 
	
     @Override
	public UserDetails loadUserByUsername(String username){
  
    	 User user = this.userRepository.findByUserName(username);
    	 if(user==null){
    		 System.out.println("user not found");
    		 throw new UserFoundException("user found");
    	 }
		return user;
	}

}
