package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.services.UserServiceImple;

@RestController
@RequestMapping("/api/v1.0.0/users")
public class UserResource {

	@Autowired
	private UserServiceImple userServiceImple; 
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(userServiceImple.findAll(), HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws BadRequestException{
		if(user.getId() != null) {
			 throw new BadRequestException("A new User cannot already have an ID");
		}
		return new ResponseEntity<User>(userServiceImple.saveUser(user), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Long id){
		return new ResponseEntity<User>(userServiceImple.findUserById(id), HttpStatus.OK);
	}
	
}
