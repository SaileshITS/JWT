package com.jwtdemo.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserAccess;
import com.jwtdemo.entities.UserFunction;
import com.jwtdemo.entities.UserGroup;
import com.jwtdemo.jwtrequestDto.UserAccessDto;
import com.jwtdemo.repo.UserAccessRepo;
import com.jwtdemo.repo.UserFunctionRepo;
import com.jwtdemo.repo.UserGroupRepo;
import com.jwtdemo.service.UserAccessService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserAccessServiceIMPL implements UserAccessService {

	@Autowired
	private UserAccessRepo accessRepo;

	@Autowired
	private UserFunctionRepo userFunctionRepo;

	@Autowired
	private UserGroupRepo userGroupRepo;

	@Override
	public UserAccess saveUserAccess(UserAccessDto userAccessDto) {
		log.info("Inside UserAccessServiceIMPL Service in saveUserAccess");
		// want to save the join table data
		UserAccess userAccess = new UserAccess();
		UserFunction userFunction = userFunctionRepo.findById(userAccessDto.getFunctionID()).get();
		UserGroup userGroup = userGroupRepo.findById(userAccessDto.getUserGroupID()).get();

		userAccess.getUserGroupID().add(userGroup);
		userAccess.getFunctionID().add(userFunction);

		return accessRepo.save(userAccess);

	}

	@Override
	public String deleteUserAccess(Integer userAccessID) {
		log.info("Inside UserAccessServiceIMPL Service in deleteUserAccess");
		try {
			accessRepo.deleteById(userAccessID);
			return "delete Successfull";
		} catch (Exception e) {
			return "Not Delete";
		}
	}

}
