package com.jwtdemo.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserFunction;
import com.jwtdemo.repo.UserFunctionRepo;
import com.jwtdemo.service.UserFunctionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserFunctionServiceIMPL implements UserFunctionService {

	@Autowired
	private UserFunctionRepo userFunctionRepo;

	@Override
	public UserFunction saveUserFunction(UserFunction userFunction) {
		log.info("Inside UserFunctionServiceIMPL service in saveUserFunction");
		return userFunctionRepo.save(userFunction);
	}

}
