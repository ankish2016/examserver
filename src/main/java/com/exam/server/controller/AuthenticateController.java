package com.exam.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.exam.server.config.JwtUtil;
import com.exam.server.model.request.JwtRequest;
import com.exam.server.response.JwtResponse;
import com.exam.server.serviceImpl.UserDetailServiceImpl;

@RestController
public class AuthenticateController  {

	 @Autowired
	 private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 private UserDetailServiceImpl userDetailServiceImpl;
	 
	 @Autowired
	 private JwtUtil jwtUtil;
	 
	 
	 @PostMapping("/signin")
	 public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		 try {
			 authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());
		 }catch(UsernameNotFoundException ex){
			 ex.printStackTrace();
			 System.out.println("user not found");
		 }
		 // authenticate
		 UserDetails userDetails = this.userDetailServiceImpl.loadUserByUsername(jwtRequest.getUserName());
		 String token = this.jwtUtil.generateToken(userDetails);
		 return ResponseEntity.ok(new JwtResponse(token));
	 }
	 
	 private void authenticate(String userName,String password) throws Exception {
		 try {
			 this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			 
		 }catch(DisabledException e) {
			 throw new Exception("user is disabled"+e.getMessage());
		 }
		 catch(BadCredentialsException e) {
			 throw new Exception("Bad crendtial "+e.getMessage());
		 }
	 }
}
