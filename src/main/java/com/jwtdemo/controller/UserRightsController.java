package com.jwtdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtdemo.annotation.Allow;
import com.jwtdemo.entities.UserRights;
import com.jwtdemo.jwtrequestDto.userRightsDto;
import com.jwtdemo.service.UserRightsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/private/saveUserRights")
@Slf4j
public class UserRightsController {

	@Autowired
	private UserRightsService userRightsService;

	@PostMapping("/saveSingleUserRights")
	@Allow(function = "USER.RIGHTS", operation = "WRITE")
	public UserRights saveSingleUserRights(@RequestBody userRightsDto userRightsDto) {
		log.info("Inside UserRightsController saveSingleUserRights");
		return userRightsService.saveUserRights(userRightsDto);
	}

	@DeleteMapping("/deleteUserAccess/{userAccessID}")
	@Allow(function = "USER.RIGHTS", operation = "DELETE")
	public String deleteUserAccess(@PathVariable Integer userAccessID) {
		log.info("Inside UserRightsController  deleteUserAccess");
		return userRightsService.deleteUserRights(userAccessID);
	}

	@GetMapping("/getAllFuctionByUserId/{userId}")
	@Allow(function = "USER.RIGHTS", operation = "READ")
	public List<String> getAllFuctionByUserId(@PathVariable Integer userId) {
		log.info("Inside UserRightsController  getAllFuctionByUserId");
		return userRightsService.getAllFunctionByUserId(userId);
	}
}
