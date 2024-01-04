package com.jwtdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtdemo.annotation.Allow;
import com.jwtdemo.entities.UserGroup;
import com.jwtdemo.service.UsergroupService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/private/userGroup")
@Slf4j
public class UserGroupController {

	@Autowired
	private UsergroupService usergroupService;

	@PostMapping("/saveuserGroup")
	@Allow(function = "USER.GROUP", operation = "WRITE")
	public UserGroup saveUserGroup(@RequestBody UserGroup userGroup) {
		log.info("Inside UserGroupController saveUserGroup");
		return usergroupService.saveUserGroup(userGroup);
	}
}
