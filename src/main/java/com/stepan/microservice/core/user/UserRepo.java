package com.stepan.microservice.core.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stepan.microservice.core.user.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {}
