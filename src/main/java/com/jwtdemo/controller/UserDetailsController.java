package com.jwtdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtdemo.entities.UserDetails;
import com.jwtdemo.service.UserDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/public/userDetails")
@Slf4j
public class UserDetailsController {

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/saveSingleuserDetails")
	public UserDetails saveSingleUserDetails(@RequestBody UserDetails userDetails) {
		log.info("Inside UserDetailsController saveSingleUserDetails ");
		return userDetailsService.saveSingleUser(userDetails);
	}
}
