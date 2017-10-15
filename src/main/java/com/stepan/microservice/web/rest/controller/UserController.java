package com.stepan.microservice.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepan.microservice.core.user.UserService;
import com.stepan.microservice.core.user.entity.User;

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
		
		System.out.println( service.byId(id));
		return service.byId(id);
		
	}

}
