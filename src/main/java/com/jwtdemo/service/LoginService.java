package com.jwtdemo.service;

import org.springframework.stereotype.Service;

import com.jwtdemo.dto.UserDetailsResponseDto;

@Service
public interface LoginService {

	UserDetailsResponseDto login(String email, String password);
}
