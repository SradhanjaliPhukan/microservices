package io.github.sradhanjali.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.sradhanjali.microservice.model.Users;

@Service
public class UserManagementService {

	private RestTemplate restTemplete;

	@Autowired
	public void setRestTemplete(RestTemplate restTemplete) {
		this.restTemplete = restTemplete;
	}

	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		return restTemplete.getForObject("http://db-service/db/user/get", List.class);
	}

	public Users addUser(Users user) {
		ResponseEntity<Users> responseEntityUser = restTemplete.postForEntity("http://db-service/db/user/add", user, Users.class);
		return responseEntityUser.getBody();				
	}

	public Users findUserById(int id) {
		ResponseEntity<Users> responseEntityUser = restTemplete.getForEntity(String.format("http://db-service/db/user/get/%s", id), Users.class);
		return responseEntityUser.getBody();				
	}

}
