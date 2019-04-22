package com.niit.ncs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ncs.dao.UserDAO;
import com.niit.ncs.model.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/user")
	public ResponseEntity<?> displayAllUsers()
	{
		List<User> users = userDAO.getAllUsers();
		
		if(users != null)
		{
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No User Details Available", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> addUserToList(@RequestBody User user)
	{
		if(user != null)
		{
			userDAO.saveUser(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<String>("The User has Null value",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserDetailsById(@PathVariable int id)
	{
		User user = userDAO.getUserById(id);
		if(user != null)
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<String>("The User with the id : "+id+" Does not Exists", HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> updateUserDetails(@RequestBody User user)
	{
		boolean status = userDAO.updateUser(user);
		
		if(status) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("The User Does not Exists", HttpStatus.NOT_FOUND);
		}
		
	}
	//Since 4.3 version 
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserDetailById(@PathVariable int id)
	{
		User u = userDAO.getUserById(id);
		boolean result = userDAO.deleteUser(u);
		if(result) {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("The User with this Id doed not found", HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
