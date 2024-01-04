package com.jwtdemo.service;

import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserDetails;

@Service
public interface UserDetailsService {

	UserDetails saveSingleUser(UserDetails userDetails);
}
