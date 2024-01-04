package com.jwtdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jwtdemo.entities.UserAccess;

@Repository
public interface UserAccessRepo extends JpaRepository<UserAccess, Integer> {
//	
//	void saveFunctionIdInJoinTable(Integer functionID,Integer userAccessID);
//	
//	void saveGroupIDInJoinTable(Integer userGroupID,Integer userAccessID);

	@Query(value = "SELECT function_name " + "FROM saileshsecurity.user_function "
			+ "WHERE functionid IN (SELECT functionid "
			+ "                      FROM saileshsecurity.useraccess_userfunction "
			+ "                      WHERE user_accessid IN (SELECT user_accessid "
			+ "                                             FROM saileshsecurity.useraccess_usergroup "
			+ "                                             WHERE user_groupid IN (SELECT user_groupid "
			+ "                                                                    FROM saileshsecurity.userrights_usergroup "
			+ "                                                                    WHERE user_rightsid IN (SELECT user_rightsid "
			+ "                                                                                           FROM saileshsecurity.user_rights "
			+ "                                                                                           WHERE user_id = :userId))));", nativeQuery = true)
	List<String> functionListFindByUserID(Integer userId);
}
