package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
      
	private final UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	public void registerUser(String username, String password) {
		User user =new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setRole("USER");
		userRepository.save(user);
	}
}
