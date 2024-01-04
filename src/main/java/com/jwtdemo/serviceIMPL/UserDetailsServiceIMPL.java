package com.jwtdemo.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserDetails;
import com.jwtdemo.repo.UserDetailsRepo;
import com.jwtdemo.service.UserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceIMPL implements UserDetailsService {

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Override
	public UserDetails saveSingleUser(UserDetails userDetails) {
		log.info("Inside UserDetailsServiceIMPL Service in saveSingleUser");
		return userDetailsRepo.save(userDetails);
	}

}
