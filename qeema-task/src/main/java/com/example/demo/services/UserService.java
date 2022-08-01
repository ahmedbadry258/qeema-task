package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.User;

public interface UserService {

	User saveUser(User user);
	List<User> findAll();
	User findUserById(Long id);
}
