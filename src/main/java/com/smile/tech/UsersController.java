package com.smile.tech;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.tech.model.Users;
import com.smile.tech.payload.request.UpdateUserRequest;
import com.smile.tech.payload.request.UserCreateRequest;
import com.smile.tech.service.UsersService;

@RestController
@RequestMapping("/mirror")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	
	@PostMapping(path="/user-store")
	public ResponseEntity<?> storeUsersDeatils(@Valid @RequestBody UserCreateRequest createRequest){
		return usersService.storeUserDetail(createRequest);
	}
	
	@PutMapping(path="/user-update")
	public ResponseEntity<?> updateUsersDeatils(@Valid @RequestBody UpdateUserRequest updateRequest){
		return usersService.updateUserDetail(updateRequest);
	}
	
	@GetMapping(path="/user/{id}")
	public ResponseEntity<?> findUsersDeatilsByUserId(@PathVariable String id){
		return usersService.findUserByUserId(id);
	}
	
	@DeleteMapping(path="/user-delete")
	public ResponseEntity<?> deleteUsersDeatilsByUserId(@PathVariable String id){
		return usersService.deleteUserByUserId(id);
	}
	
	@GetMapping(path = "/user/all")
	public List<Users> findAllUsersDeatils(){
		return usersService.findAllUsers();
	}
	
}
