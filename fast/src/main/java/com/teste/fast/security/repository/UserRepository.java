package com.teste.fast.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.teste.fast.security.model.Users;


public interface UserRepository extends MongoRepository<Users, String>{
	UserDetails findByLogin(String login);
}
