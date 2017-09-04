package io.github.sradhanjali.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sradhanjali.microservice.entities.Users;
import io.github.sradhanjali.microservice.services.UsersService;

@RestController
@RequestMapping("/db/user")
public class UserController {

	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping("/add")
	public Users addUser(@RequestBody Users user){
		return usersService.addUser(user);
	}
	
	@GetMapping("/get/{id}")
	public Users findUserById(@PathVariable int id){
		return usersService.findUserById(id);
	}
	
	@GetMapping("/get")
	public List<Users> findAll(){
		return usersService.findAll();
	}
	
	
}
