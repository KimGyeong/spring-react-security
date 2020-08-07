package com.example.springreactsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springreactsecurity.exception.ResourceNotFoundException;
import com.example.springreactsecurity.model.User;
import com.example.springreactsecurity.repository.UserRepository;
import com.example.springreactsecurity.security.CurrentUser;
import com.example.springreactsecurity.security.UserPrincipal;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		return userRepository.findById(userPrincipal.getId())
			.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
	}
}