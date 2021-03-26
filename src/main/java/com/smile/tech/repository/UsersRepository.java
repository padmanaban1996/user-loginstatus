package com.smile.tech.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smile.tech.model.Users;

public interface UsersRepository extends MongoRepository<Users, String> {

	public Optional<Users> findByUserId(String id);

}
