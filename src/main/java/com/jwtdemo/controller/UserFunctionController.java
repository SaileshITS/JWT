package com.jwtdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtdemo.annotation.Allow;
import com.jwtdemo.entities.UserFunction;
import com.jwtdemo.service.UserFunctionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/private/userFunction")
@Slf4j
public class UserFunctionController {

	@Autowired
	private UserFunctionService userFunctionService;

	@PostMapping("/saveuserFunction")
	@Allow(function = "USER.FUNCTION", operation = "WRITE")
	public UserFunction saveUserFunction(@RequestBody UserFunction userFunction) {
		log.info("Inside UserFunctionController saveUserFunction ");
		return userFunctionService.saveUserFunction(userFunction);
	}
}
