package com.jwtdemo.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserGroup;
import com.jwtdemo.repo.UserGroupRepo;
import com.jwtdemo.service.UsergroupService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserGroupServiceIMPL implements UsergroupService {

	@Autowired
	private UserGroupRepo userGroupRepo;

	@Override
	public UserGroup saveUserGroup(UserGroup userGroup) {
		log.info("Inside UserGroupServiceIMPL Service  saveUserGroup");
		return userGroupRepo.save(userGroup);
	}

}
