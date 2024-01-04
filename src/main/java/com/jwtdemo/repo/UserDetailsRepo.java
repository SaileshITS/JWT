package com.jwtdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jwtdemo.entities.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {

	@Query(nativeQuery = true, value = " select * from saileshsecurity.user_details where email=:email")
	UserDetails findByEmail(String email);

	UserDetails findByUserName(String userName);
}
