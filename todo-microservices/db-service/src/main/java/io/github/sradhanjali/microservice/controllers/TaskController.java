package io.github.sradhanjali.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sradhanjali.microservice.entities.Tasks;
import io.github.sradhanjali.microservice.services.TaskService;

@EnableJpaRepositories
@RestController
@RequestMapping("/db/task")
public class TaskController {
	private TaskService taskService;
	
	@Autowired
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/get/{userId}")
	public List<Tasks> getAllTaskForUser(@PathVariable int userId){
		return taskService.findByUserId(userId);
	}
	
	@PostMapping("/add")
	public Tasks addTasksForUserId(@RequestBody Tasks task){
		return taskService.addTasksForUserId(task);
	}

}
