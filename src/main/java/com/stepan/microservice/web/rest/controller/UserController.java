package com.stepan.microservice.web.rest.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepan.microservice.core.user.UserService;
import com.stepan.microservice.core.user.entity.User;
import com.stepan.microservice.web.rest.exception.NotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	
	@PostMapping
	public User create(@RequestBody User user){
		return service.createUser(user);
	}
	
	@GetMapping("/{id}")
	public User userById(@PathVariable("id") Long id){
		User found = service.byId(id);
		if(Objects.isNull(found)) throw new NotFoundException("User with this id is not found");
		return service.byId(id);	
	}

}
