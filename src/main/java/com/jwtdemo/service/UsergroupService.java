package com.jwtdemo.service;

import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserGroup;

@Service
public interface UsergroupService {

	UserGroup saveUserGroup(UserGroup userGroup);
}
