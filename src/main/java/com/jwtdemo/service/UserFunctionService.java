package com.jwtdemo.service;

import org.springframework.stereotype.Component;

import com.jwtdemo.entities.UserFunction;

@Component
public interface UserFunctionService {

	UserFunction saveUserFunction(UserFunction userFunction);
}
