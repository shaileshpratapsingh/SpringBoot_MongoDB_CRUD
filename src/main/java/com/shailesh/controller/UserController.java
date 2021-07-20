package com.shailesh.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.exception.ResourceNotFoundException;
import com.shailesh.model.User;
import com.shailesh.model.UserRequest;
import com.shailesh.service.ResponseHandler;
import com.shailesh.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @apiNote This controller handles all user operations.
 * @author Shailesh
 *
 */
@RestController
@RequestMapping("/api/v1")
@Api("User Apis")
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value = "View a list of available users")
	@GetMapping("/users")
	public Map<String, Object> getAllUsers() {
		Optional<List<User>> user = service.getAllUsers();
		if (user.isPresent()) {
			return ResponseHandler.generateResponse("All available Users", HttpStatus.OK, true, user.get());
		} else {
			return ResponseHandler.generateResponse("There are no users.", HttpStatus.OK, true, user.get());
		}
	} 

	@ApiOperation(value = "Get particular user by id.")
	@GetMapping("/users/{id}")
	public Map<String, Object> getUserById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Optional<User> user = service.getUser(id);
		if (user.isPresent()) {
			return ResponseHandler.generateResponse("User is available.", HttpStatus.OK, true, user.get());
		} else {
			return ResponseHandler.generateResponse("There is no user available for this id.", HttpStatus.OK, true,
					user.get());
		}
	}

	@ApiOperation(value = "Create new user.")
	@PostMapping("/users")
	public Map<String, Object> createUser(@Valid @RequestBody UserRequest userDetails) {
		Optional<User> user = service.createUser(userDetails);
		if (user.isPresent()) {
			return ResponseHandler.generateResponse("User created successfully.", HttpStatus.OK, true, user.get());
		} else {
			return ResponseHandler.generateResponse("There is some issue while creating user.",
					HttpStatus.INTERNAL_SERVER_ERROR, false, null);
		}
	}

	@ApiOperation(value = "Update existing user.")
	@PutMapping("/users/{id}")
	public Map<String, Object> updateUser(@PathVariable(value = "id") Long id,
			@Valid @RequestBody UserRequest userDetails) throws ResourceNotFoundException {
		Optional<User> user = service.updateUser(id, userDetails);
		if (user.isPresent()) {
			return ResponseHandler.generateResponse("User updated successfully", HttpStatus.OK, true, user.get());
		} else {
			return ResponseHandler.generateResponse("There is some issue while updating user details.",
					HttpStatus.INTERNAL_SERVER_ERROR, false, null);
		}
	}

	@ApiOperation(value = "Delete user.")
	@DeleteMapping("/users/{id}")
	public Map<String, Object> deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Optional<Boolean> flag = service.deleteUser(id);
		if (flag.isPresent()) {
			return ResponseHandler.generateResponse("User deleted successfully", HttpStatus.OK, true, flag.get());
		} else {
			return ResponseHandler.generateResponse("There is some issue while deleting user.",
					HttpStatus.INTERNAL_SERVER_ERROR, false, null);
		}
	}
}
