package com.smile.tech.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smile.tech.model.Users;
import com.smile.tech.payload.request.UpdateUserRequest;
import com.smile.tech.payload.request.UserCreateRequest;
import com.smile.tech.payload.response.MessageResponse;
import com.smile.tech.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public void insert(Users user) {
		usersRepository.insert(user);
	}

	public void save(Users user) {
		usersRepository.save(user);
	}
	
	public void delete(Users user) {
		usersRepository.delete(user);
	}

	public Optional<Users> findByUserId(String id) {
		return usersRepository.findByUserId(id);
	}

	public ResponseEntity<?> storeUserDetail(@Valid UserCreateRequest createRequest) {
		Users user = new Users(createRequest.getUserId(), createRequest.getSchoolId(), createRequest.getUsername(),
				createRequest.getToken());
		insert(user);
		return ResponseEntity.ok(new MessageResponse("Users Details Stored Successfully!"));
	}

	public ResponseEntity<?> updateUserDetail(@Valid UpdateUserRequest updateRequest) {
		Optional<Users> exitUser = findByUserId(updateRequest.getUserId());

		if (exitUser.isPresent()) {
			Users user = exitUser.get();

			if (updateRequest.getUserId().trim().length() > 0) {
				user.setUserId(updateRequest.getUserId());
			}
			if (updateRequest.getSchoolId().trim().length() > 0) {
				user.setSchoolId(updateRequest.getSchoolId());
			}
			if (updateRequest.getUsername().trim().length() > 0) {
				user.setUsername(updateRequest.getUsername());
			}
			if (updateRequest.getToken().trim().length() > 0) {
				user.setToken(updateRequest.getToken());
			}

			save(user);
			return ResponseEntity.ok(new MessageResponse("Users Details Updated Successfully!"));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("User Details Not Found!"));
		}
	}

	public ResponseEntity<?> findUserByUserId(String id) {
		Optional<Users> exitUser = findByUserId(id);
		if (exitUser.isPresent()) {
			return ResponseEntity.ok(exitUser.get());
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("User Details Not Found!"));
		}
	}
	
	public ResponseEntity<?> deleteUserByUserId(String id) {
		Optional<Users> exitUser = findByUserId(id);
		if (exitUser.isPresent()) {
			delete(exitUser.get());
			return ResponseEntity.ok(new MessageResponse("Users Details Deleted Successfully!"));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("User Details Not Found!"));
		}
	}

	public List<Users> findAllUsers() {
		return usersRepository.findAll();
	}
	

}
