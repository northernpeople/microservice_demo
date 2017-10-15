package com.stepan.microservice.core.user.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stepan.microservice.core.user.UserRepo;
import com.stepan.microservice.core.user.entity.Role;
import com.stepan.microservice.core.user.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoTest {
	
	@Autowired
	UserRepo repo;
	
	User user;
	
	
	@Before
	public void setUp(){
		user = new User();
		user.setEmail("em@il.com");
	}
	
	@Test
	public void shouldSave(){
		
		User saved = repo.saveAndFlush(user);
		assertTrue(saved.getId() != null);
		assertEquals(saved.getRole(), Role.ROLE_USER);
	}
	
	@Test
	public void shouldUpdateRole(){
		
		user.setRole(Role.ROLE_ADMIN);
		User saved = repo.saveAndFlush(user);
		assertEquals(saved.getRole(), Role.ROLE_ADMIN);
	}

}
