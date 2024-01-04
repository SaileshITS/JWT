package com.jwtdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwtdemo.entities.UserGroup;

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Integer> {

}
