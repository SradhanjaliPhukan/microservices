package io.github.sradhanjali.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.sradhanjali.microservice.entities.Tasks;
import io.github.sradhanjali.microservice.repositories.TaskRepository;

@Service
public class TaskService {
	
	private TaskRepository taskRepository;
	
	@Autowired
	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Tasks> findByUserId(int userId) {	
		return taskRepository.findByUserId(userId);
	}

	public Tasks addTasksForUserId(Tasks task) {
		return taskRepository.save(task);
	}
}
