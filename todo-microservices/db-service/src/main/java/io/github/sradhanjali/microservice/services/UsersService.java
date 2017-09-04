package io.github.sradhanjali.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.sradhanjali.microservice.entities.Users;
import io.github.sradhanjali.microservice.repositories.UsersRepository;

@Service
public class UsersService {

	private UsersRepository repository;
	
	@Autowired
	public void setRepository(UsersRepository repository) {
		this.repository = repository;
	}
	
	public Users addUser(Users user){
		return repository.save(user);
	}

	public Users findUserById(int id) {
		return repository.findById(id);
	}

	public List<Users> findAll() {
		return repository.findAll();
	}
}
