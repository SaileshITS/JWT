package com.jwtdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtdemo.annotation.Allow;
import com.jwtdemo.entities.UserAccess;
import com.jwtdemo.jwtrequestDto.UserAccessDto;
import com.jwtdemo.service.UserAccessService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/private/userAccess")
@Slf4j
public class UserAccessController {

	@Autowired
	private UserAccessService userAccessService;

	@PostMapping("/saveUserAccess")
	@Allow(function = "USER.ACCESS", operation = "WRITE")
	public UserAccess userAccess(@RequestBody UserAccessDto userAccessDto) {
		log.info("Inside UserAccess save User Access");
		return userAccessService.saveUserAccess(userAccessDto);
	}

	@DeleteMapping("/deleteUserAccess/{userAccessID}")
	@Allow(function = "USER.ACCESS", operation = "DELETE")
	public String deleteUserAccess(@PathVariable Integer userAccessID) {
		log.info("Inside UserAccess delete User Access");
		return userAccessService.deleteUserAccess(userAccessID);
	}

}
