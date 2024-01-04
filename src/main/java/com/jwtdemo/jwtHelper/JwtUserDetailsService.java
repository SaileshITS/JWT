package com.jwtdemo.jwtHelper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jwtdemo.repo.UserDetailsRepo;

@Component
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.jwtdemo.entities.UserDetails findByEmail = userDetailsRepo.findByEmail(username);
		if (findByEmail == null) {
			throw new RuntimeException("Unauthorized");
		}
		return new User(username, "", true, true, true, true, new ArrayList<>());
	}

}