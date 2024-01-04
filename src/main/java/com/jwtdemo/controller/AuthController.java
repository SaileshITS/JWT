package com.jwtdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtdemo.jwtHelper.JwtHelper;
import com.jwtdemo.jwtHelper.JwtUserDetailsService;
import com.jwtdemo.jwtrequestDto.JwtRequest;
import com.jwtdemo.repo.UserAccessRepo;
import com.jwtdemo.repo.UserDetailsRepo;
import com.jwtdemo.responseDto.JwtResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/public")
@Slf4j
public class AuthController {

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private JwtHelper helper;

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Autowired
	private UserAccessRepo userAccessRepo;

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		log.info("Inside Login Controller");
		com.jwtdemo.entities.UserDetails findByEmail = userDetailsRepo.findByEmail(request.getEmail());
		List<String> functionListFindByUserID = userAccessRepo.functionListFindByUserID(findByEmail.getUserId());
		
		if (findByEmail != null && findByEmail.getPassword().equals(request.getPassword())) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(findByEmail.getEmail());
			String token = this.helper.generateToken(functionListFindByUserID, userDetails);

			JwtResponse response = JwtResponse.builder().jwtToken(token).userName(request.getEmail()).build();
			log.info(" Login Controller End.....!!!!!!!!!!!!!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}
	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

	@GetMapping("/public/test")
	public String test() {
		log.info("Inside test Controller");
		return "Testing Purpose";
	}
}
