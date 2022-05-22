package com.example.demo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface UserRepo  extends JpaRepository<User, Long>{
	
	Optional<User> findByUserName(String userName);

}
