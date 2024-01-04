package com.jwtdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwtdemo.entities.UserRights;

@Repository
public interface UserRightsRepo extends JpaRepository<UserRights, Integer> {

}
