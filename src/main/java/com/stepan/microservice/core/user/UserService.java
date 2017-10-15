package com.stepan.microservice.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepan.microservice.core.user.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;

	public User createUser(User u){
		return repo.saveAndFlush(u);
	}

	public User byId(Long id) {
		return repo.findOne(id);
	}

}
