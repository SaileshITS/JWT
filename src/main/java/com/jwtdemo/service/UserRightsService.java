package com.jwtdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserRights;
import com.jwtdemo.jwtrequestDto.userRightsDto;

@Service
public interface UserRightsService {

	UserRights saveUserRights(userRightsDto userRightsDto);

	String deleteUserRights(Integer userRightsID);

	List<String> getAllFunctionByUserId(Integer userId);
}
