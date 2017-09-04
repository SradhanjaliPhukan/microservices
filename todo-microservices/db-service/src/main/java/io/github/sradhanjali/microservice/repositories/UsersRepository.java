package io.github.sradhanjali.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.sradhanjali.microservice.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	Users findById(int id);

}
