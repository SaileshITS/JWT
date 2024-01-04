package com.jwtdemo.serviceIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtdemo.entities.UserDetails;
import com.jwtdemo.entities.UserGroup;
import com.jwtdemo.entities.UserRights;
import com.jwtdemo.jwtrequestDto.userRightsDto;
import com.jwtdemo.repo.UserAccessRepo;
import com.jwtdemo.repo.UserDetailsRepo;
import com.jwtdemo.repo.UserGroupRepo;
import com.jwtdemo.repo.UserRightsRepo;
import com.jwtdemo.service.UserRightsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRightsServiceIMPL implements UserRightsService {

	@Autowired
	private UserRightsRepo userRightsRepo;

	@Autowired
	private UserGroupRepo groupRepo;

	@Autowired
	private UserAccessRepo accessRepo;

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Override
	public UserRights saveUserRights(userRightsDto userRightsDto) {
		log.info("Inside UserRightsServiceIMPL service saveUserRights");
		UserRights userRights = new UserRights();
		UserGroup userGroup = groupRepo.findById(userRightsDto.getUserGroupID()).get();
		UserDetails userDetails = userDetailsRepo.findById(userRightsDto.getUserId()).get();
		if (userDetails.getUserId() != null) {
			userRights.setUserId(userDetails);
		}
		userRights.getUserGroupID().add(userGroup);

		return userRightsRepo.save(userRights);
	}

	@Override
	public String deleteUserRights(Integer userRightsID) {
		log.info("Inside UserRightsServiceIMPL service deleteUserRights");
		try {

			userRightsRepo.deleteById(userRightsID);
			return "Successfull Deleted";
		} catch (Exception e) {
			return "Not Deleted";
		}
	}

	@Override
	public List<String> getAllFunctionByUserId(Integer userId) {
		log.info("Inside UserRightsServiceIMPL service getAllFunctionByUserId");
		UserRights userRights = userRightsRepo.findById(userId).get();

		if (userRights.getUserId() != null) {
			return accessRepo.functionListFindByUserID(userId);
		}
		// return accessRepo.findByUserGroupID();
		return new ArrayList<>();
	}

}
