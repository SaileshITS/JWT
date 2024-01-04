package com.jwtdemo.service;

import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserAccess;
import com.jwtdemo.jwtrequestDto.UserAccessDto;

@Service
public interface UserAccessService {

	UserAccess saveUserAccess(UserAccessDto userAccessDto);

	String deleteUserAccess(Integer userAccessID);
}
