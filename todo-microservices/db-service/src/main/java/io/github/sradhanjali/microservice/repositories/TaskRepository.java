package io.github.sradhanjali.microservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.sradhanjali.microservice.entities.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer>{

	List<Tasks> findByUserId(int userId);

}
