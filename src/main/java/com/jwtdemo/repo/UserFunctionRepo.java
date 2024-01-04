package com.jwtdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwtdemo.entities.UserFunction;

@Repository
public interface UserFunctionRepo extends JpaRepository<UserFunction, Integer> {
//	@Query(value = "select function_name from saileshsecurity.user_function where function_name!=:ignorefunctionName")
//	List<String> getAllFunctionignoreUserAll(String ignorefunctionName);

}
