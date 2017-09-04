package io.github.sradhanjali.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.sradhanjali.microservice.model.Tasks;

@Service
public class TaskManagementService {

	private RestTemplate restTemplete;

	@Autowired
	public void setRestTemplete(RestTemplate restTemplete) {
		this.restTemplete = restTemplete;
	}

	public Tasks addTask(Tasks task) {
		ResponseEntity<Tasks> responseEntityUser = restTemplete.postForEntity("http://db-service/db/task/add", task, Tasks.class);
		return responseEntityUser.getBody();				
	}

	@SuppressWarnings("unchecked")
	public List<Tasks> findTasksByUserId(int id) {
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> responseEntityUser = restTemplete.getForEntity(String.format("http://db-service/db/task/get/%s", id), List.class);
		return responseEntityUser.getBody();				
	}
}
