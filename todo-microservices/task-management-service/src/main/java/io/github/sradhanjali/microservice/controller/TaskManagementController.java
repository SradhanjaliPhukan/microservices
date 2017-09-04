package io.github.sradhanjali.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sradhanjali.microservice.model.Tasks;
import io.github.sradhanjali.microservice.service.TaskManagementService;

@RestController
@RequestMapping("/task")
public class TaskManagementController {
	private TaskManagementService taskManagementService;

	@Autowired
	public void setUserManagementService(TaskManagementService taskManagementService) {
		this.taskManagementService = taskManagementService;
	}

	@GetMapping("/get/{id}")
	public List<Tasks> getTasksForUserId(@PathVariable int id){
		return taskManagementService.findTasksByUserId(id);
	}
	
	@PostMapping("/add")
	public Tasks addTasks(@RequestBody Tasks task){
		return taskManagementService.addTask(task);
	}
}
