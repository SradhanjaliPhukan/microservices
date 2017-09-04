package io.github.sradhanjali.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sradhanjali.microservice.model.Users;
import io.github.sradhanjali.microservice.service.UserManagementService;

@RestController
@RequestMapping("/user")
public class UserManagementController {

	private UserManagementService userManagementService;

	@Autowired
	public void setUserManagementService(UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}

	@GetMapping("/get")
	public List<Users> getAllUsers(){
		return userManagementService.getAllUsers();
	}
	
	@PostMapping("/add")
	public Users addUser(@RequestBody Users users){
		return userManagementService.addUser(users);
	}
	
	@GetMapping("/get/{id}")
	public Users findUserById(@PathVariable int id){
		return userManagementService.findUserById(id);
	}
}
